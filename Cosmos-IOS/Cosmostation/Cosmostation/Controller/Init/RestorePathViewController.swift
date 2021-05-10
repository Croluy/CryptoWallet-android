//
//  RestorePathViewController.swift
//  Cosmostation
//
//  Created by yongjoo on 28/03/2019.
//  Copyright © 2019 wannabit. All rights reserved.
//

import UIKit
import Alamofire
import BitcoinKit
import SwiftKeychainWrapper
import GRPC
import NIO

class RestorePathViewController: BaseViewController, UITableViewDelegate, UITableViewDataSource {

    var userChain: ChainType?
    var userInputWords: [String]?
    var usingBip44:Bool = false
    @IBOutlet weak var restoreTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.restoreTableView.delegate = self
        self.restoreTableView.dataSource = self
        self.restoreTableView.separatorStyle = UITableViewCell.SeparatorStyle.none
        self.restoreTableView.register(UINib(nibName: "RestorePathCell", bundle: nil), forCellReuseIdentifier: "RestorePathCell")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.navigationController?.setNavigationBarHidden(false, animated: false)
        self.navigationController?.navigationBar.topItem?.title = NSLocalizedString("title_path", comment: "")
        self.navigationController?.navigationBar.setBackgroundImage(UIImage(), for: UIBarMetrics.default)
        self.navigationController?.navigationBar.shadowImage = UIImage()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell:RestorePathCell? = tableView.dequeueReusableCell(withIdentifier:"RestorePathCell") as? RestorePathCell
        cell?.rootCardView.backgroundColor = WUtils.getChainBg(userChain!)
        WUtils.setDenomTitle(userChain!, cell!.denomTitle)
        if (userChain == ChainType.BINANCE_MAIN || userChain == ChainType.BINANCE_TEST) {
            cell?.pathLabel.text = BNB_BASE_PATH.appending(String(indexPath.row))
        } else if (userChain == ChainType.IOV_MAIN || userChain == ChainType.IOV_TEST) {
            cell?.pathLabel.text = IOV_BASE_PATH.appending(String(indexPath.row))
        } else if (userChain == ChainType.BAND_MAIN) {
            cell?.pathLabel.text = BAND_BASE_PATH.appending(String(indexPath.row))
        } else if (userChain == ChainType.KAVA_MAIN || userChain == ChainType.KAVA_TEST) {
            if (self.usingBip44) {
                cell?.pathLabel.text = KAVA_BASE_PATH.appending(String(indexPath.row))
            } else {
                cell?.pathLabel.text = BASE_PATH.appending(String(indexPath.row))
            }
        } else if (userChain == ChainType.SECRET_MAIN) {
            if (self.usingBip44) {
                cell?.pathLabel.text = BASE_PATH.appending(String(indexPath.row))
            } else {
                cell?.pathLabel.text = SECRET_BASE_PATH.appending(String(indexPath.row))
            }
        } else if (userChain == ChainType.OKEX_MAIN || userChain == ChainType.OKEX_TEST) {
            if (self.usingBip44) {
                cell?.pathLabel.text = "(Ethermint Type) " + OK_BASE_PATH.appending(String(indexPath.row))
            } else {
                cell?.pathLabel.text = "(Tendermint Type) " + OK_BASE_PATH.appending(String(indexPath.row))
            }
        } else if (userChain == ChainType.PERSIS_MAIN) {
            cell?.pathLabel.text = PERSIS_BASE_PATH.appending(String(indexPath.row))
        } else if (userChain == ChainType.CRYPTO_MAIN) {
            cell?.pathLabel.text = CRYPTO_BASE_PATH.appending(String(indexPath.row))
        } else {
            cell?.pathLabel.text = BASE_PATH.appending(String(indexPath.row))
        }
        
        DispatchQueue.global().async {
            let address = WKey.getDpAddressPath(self.userInputWords!, indexPath.row, self.userChain!, self.usingBip44)
            DispatchQueue.main.async(execute: {
                cell?.addressLabel.text = address
                let tempAccount = BaseData.instance.selectExistAccount(address: address, chain: WUtils.getChainDBName(self.userChain!))
                if (tempAccount == nil) {
                    cell?.stateLabel.text = NSLocalizedString("ready", comment: "")
                    cell?.stateLabel.textColor = UIColor.white
                } else {
                    if (tempAccount!.account_has_private) {
                        cell?.stateLabel.text = NSLocalizedString("imported", comment: "")
                        cell?.stateLabel.textColor = UIColor.init(hexString: "7A7f88")
                        cell?.rootCardView.backgroundColor = UIColor.init(hexString: "2E2E2E", alpha: 0.4)
                    } else {
                        cell?.stateLabel.text = NSLocalizedString("override", comment: "")
                        cell?.stateLabel.textColor = UIColor.white
                    }
                }
                if (WUtils.isGRPC(self.userChain!)) {
                    DispatchQueue.global().async {
                        var amount = "0"
                        let group = MultiThreadedEventLoopGroup(numberOfThreads: 1)
                        defer { try! group.syncShutdownGracefully() }
                        
                        let channel = BaseNetWork.getConnection(self.userChain!, group)!
                        defer { try! channel.close().wait() }
                        
                        let req = Cosmos_Bank_V1beta1_QueryAllBalancesRequest.with {
                            $0.address = address
                        }
                        do {
                            let response = try Cosmos_Bank_V1beta1_QueryClient(channel: channel).allBalances(req).response.wait()
                            response.balances.forEach { balance in
                                if (balance.denom == WUtils.getMainDenom(self.userChain)) {
                                    amount = balance.amount
                                }
                            }
                        } catch { }
                        DispatchQueue.main.async(execute: {
                            cell?.denomAmount.attributedText = WUtils.displayAmount2(amount, cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                        });
                    }
                }
                
                else {
                    cell?.denomAmount.attributedText = WUtils.displayAmount2(NSDecimalNumber.zero.stringValue, cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                    let request = Alamofire.request(BaseNetWork.accountInfoUrl(self.userChain, address), method: .get, parameters: [:], encoding: URLEncoding.default, headers: [:])
                    request.responseJSON { (response) in
                        switch response.result {
                        case .success(let res):
                            if (self.userChain == ChainType.BINANCE_MAIN || self.userChain == ChainType.BINANCE_TEST) {
                                if let responseData = res as? NSDictionary {
                                    let bnbAccountInfo = BnbAccountInfo.init(responseData)
                                    if let coin = bnbAccountInfo.balances.filter({$0.symbol == WUtils.getMainDenom(self.userChain)}).first {
                                        cell?.denomAmount.attributedText = WUtils.displayAmount2(coin.free , cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                                    }
                                }
                                
                            } else if (self.userChain == ChainType.OKEX_MAIN || self.userChain == ChainType.OKEX_TEST) {
                                if let responseData = res as? NSDictionary {
                                    let okAccountInfo = OkAccountInfo.init(responseData)
                                    if let coin = okAccountInfo.value?.coins.filter({$0.denom == WUtils.getMainDenom(self.userChain)}).first {
                                        cell?.denomAmount.attributedText = WUtils.displayAmount2(coin.amount , cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                                    }
                                }
                                
                            } else if (self.userChain == ChainType.KAVA_MAIN || self.userChain == ChainType.KAVA_TEST) {
                                if let responseData = res as? NSDictionary {
                                    let kavaAccountInfo = KavaAccountInfo.init(responseData)
                                    if let coin = kavaAccountInfo.result.value.coins.filter({$0.denom == WUtils.getMainDenom(self.userChain)}).first {
                                        cell?.denomAmount.attributedText = WUtils.displayAmount2(coin.amount , cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                                    }
                                }
                                
                            } else {
                                if let responseData = res as? NSDictionary, let info = responseData.object(forKey: "result") as? NSDictionary {
                                    let accountInfo = AccountInfo.init(info)
                                    if (accountInfo.type == COSMOS_AUTH_TYPE_ACCOUNT && accountInfo.value.coins.count > 0) {
                                        if let coin = accountInfo.value.coins.filter({$0.denom == WUtils.getMainDenom(self.userChain)}).first {
                                            cell?.denomAmount.attributedText = WUtils.displayAmount2(coin.amount , cell!.denomAmount.font!, WUtils.mainDivideDecimal(self.userChain), WUtils.mainDisplayDecimal(self.userChain))
                                        }
                                    }
                                }
                            }
                        
                        
                        case .failure(let error):
                            if (SHOW_LOG) { print("onFetchAccountInfo ", error) }
                        }
                    }
                    
                }

            });
        }
        return cell!
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let cell:RestorePathCell? = tableView.cellForRow(at: indexPath) as? RestorePathCell
        if (cell?.stateLabel.text == NSLocalizedString("imported", comment: "")) {
            return
        } else if (cell?.stateLabel.text == NSLocalizedString("ready", comment: "")) {
            BaseData.instance.setLastTab(0)
            self.onGenAccount(self.userInputWords!, self.userChain!, indexPath.row, self.usingBip44)

        } else {
            BaseData.instance.setLastTab(0)
            self.onOverrideAccount(self.userInputWords!, self.userChain!, indexPath.row, self.usingBip44)
        }
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 86;
    }
    
    func onGenAccount(_ mnemonic: [String], _ chain:ChainType, _ path:Int, _ newBip:Bool) {
        self.showWaittingAlert()
        DispatchQueue.global().async {
            var resource: String = ""
            for word in self.userInputWords! {
                resource = resource + " " + word
            }
            
            let newAccount = Account.init(isNew: true)
            let keyResult = KeychainWrapper.standard.set(resource, forKey: newAccount.account_uuid.sha1(), withAccessibility: .afterFirstUnlockThisDeviceOnly)
            var insertResult :Int64 = -1
            if(keyResult) {
                newAccount.account_address = WKey.getDpAddressPath(mnemonic, path, chain, newBip)
                newAccount.account_base_chain = WUtils.getChainDBName(chain)
                newAccount.account_has_private = true
                newAccount.account_from_mnemonic = true
                newAccount.account_path = String(path)
                newAccount.account_m_size = Int64(self.userInputWords!.count)
                newAccount.account_import_time = Date().millisecondsSince1970
                newAccount.account_new_bip44 = newBip
                newAccount.account_sort_order = 9999
                insertResult = BaseData.instance.insertAccount(newAccount)
                
                if(insertResult < 0) {
                    KeychainWrapper.standard.removeObject(forKey: newAccount.account_uuid.sha1())
                }
            }
            
            DispatchQueue.main.async(execute: {
                self.hideWaittingAlert()
                if(keyResult && insertResult > 0) {
                    BaseData.instance.setRecentAccountId(insertResult)
                    self.onStartMainTab()
                } else {
                    //TODO Error control
                }
            });
        }
    }
    
    
    func onOverrideAccount(_ mnemonic: [String], _ chain:ChainType, _ path:Int, _ newBip:Bool) {
        self.showWaittingAlert()
        DispatchQueue.global().async {
            var resource: String = ""
            for word in self.userInputWords! {
                resource = resource + " " + word
            }
            
            let existedAccount = BaseData.instance.selectExistAccount(address: WKey.getDpAddressPath(mnemonic, path, chain, newBip), chain: WUtils.getChainDBName(chain))
            let keyResult = KeychainWrapper.standard.set(resource, forKey: existedAccount!.account_uuid.sha1(), withAccessibility: .afterFirstUnlockThisDeviceOnly)
            var updateResult :Int64 = -1
            if(keyResult) {
                existedAccount!.account_has_private = true
                existedAccount!.account_from_mnemonic = true
                existedAccount!.account_path = String(path)
                existedAccount!.account_m_size = Int64(self.userInputWords!.count)
                existedAccount!.account_new_bip44 = newBip
                updateResult = BaseData.instance.overrideAccount(existedAccount!)
                
                if(updateResult < 0) {
                    KeychainWrapper.standard.removeObject(forKey: existedAccount!.account_uuid.sha1())
                }
            }
            
            DispatchQueue.main.async(execute: {
                self.hideWaittingAlert()
                if(keyResult && updateResult > 0) {
                    BaseData.instance.setRecentAccountId(existedAccount!.account_id)
                    self.onStartMainTab()
                } else {
                    //TODO Error control
                }
            });
        }
    }
}
