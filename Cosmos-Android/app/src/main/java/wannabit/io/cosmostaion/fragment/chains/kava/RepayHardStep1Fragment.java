package wannabit.io.cosmostaion.fragment.chains.kava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.chains.kava.RepayHardActivity;
import wannabit.io.cosmostaion.base.BaseFragment;

public class RepayHardStep1Fragment extends BaseFragment {

    public static RepayHardStep1Fragment newInstance(Bundle bundle) {
        RepayHardStep1Fragment fragment = new RepayHardStep1Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tx_step_memo, container, false);
        return rootView;
    }

    private RepayHardActivity getSActivity() {
        return (RepayHardActivity)getBaseActivity();
    }
}
