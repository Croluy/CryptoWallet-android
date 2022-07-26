package wannabit.io.cosmostaion.base.chains;

import static wannabit.io.cosmostaion.base.BaseConstant.*;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.bitcoinj.crypto.ChildNumber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseChain;

public class Okc extends ChainConfig {

    public BaseChain baseChain() { return BaseChain.OKEX_MAIN; }
    public int chainImg() { return R.drawable.chain_okc; }
    public int chainInfoImg() { return R.drawable.infoicon_okx; }
    public int chainInfoTitle() { return R.string.str_front_guide_title_okx; }
    public int chainInfoMsg() { return R.string.str_front_guide_msg_okx; }
    public int chainColor() { return R.color.color_okx; }
    public int chainBgColor() { return R.color.colorTransBgOkx; }
    public int chainTabColor() { return R.color.color_tab_myvalidator_okx; }
    public String chainName() { return "okex"; }
    public String chainTitle() { return "(OKC)"; }
    public String chainTitleToUp() { return "OKC"; }
    public String chainIdPrefix() { return "exchain-"; }

    public int mainDenomImg() { return R.drawable.token_okx; }
    public String mainDenom() { return "okt"; }
    public String mainSymbol() { return "OKT"; }
    public int decimal() {
        return 0;
    }
    public String addressPrefix() { return "ex"; }

    public boolean pushSupport() { return false; }
    public boolean dexSupport() { return false; }
    public boolean wcSupport() { return false; }

    public String lcdUrl() { return "https://exchainrpc.okex.org/okexchain/v1/"; }
    public String apiUrl() { return "https://www.oklink.com/api/explorer/v1/"; }

    public BigDecimal blockTime() { return new BigDecimal("0.4124"); }
    public String explorerUrl() { return "https://www.oklink.com/okexchain/"; }
    public String monikerUrl() { return MONIKER_URL + "okex/"; }
    public String relayerImgUrl() { return ""; }
    public String homeInfoLink() { return  "https://www.okx.com"; }
    public String blogInfoLink() { return  "https://www.okx.com/academy/en/"; }
    public String coingeckoLink() { return  COINGECKO_URL + "okc-token"; }

    public List<ChildNumber> setParentPath(int customPath) {
        if (customPath == 0 || customPath == 1) {
            return ImmutableList.of(new ChildNumber(44, true), new ChildNumber(996, true), ChildNumber.ZERO_HARDENED, ChildNumber.ZERO);
        } else {
            return ImmutableList.of(new ChildNumber(44, true), new ChildNumber(60, true), ChildNumber.ZERO_HARDENED, ChildNumber.ZERO);
        }
    }

    public ArrayList<String> supportHdPaths() {
        return Lists.newArrayList("m/44'/996'/0'/0/X", "m/44'/996'/0'/0/X", "m/44'/60'/0'/0/X");
    }


    public static String OKC_COIN_IMG_URL = RESOURCE_BASE_URL + "coin_image/okex/";
}