package com.budou.ec_core.delegates.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.budou.ec_core.R;
import com.budou.ec_core.app.EC;
import com.budou.ec_core.delegates.EcDelegate;

/**
 * package：com.budou.ec_core.delegates.bottom
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月08日 23:01
 * desc   ：
 */

public abstract class BottomItemDelegate extends EcDelegate implements View.OnKeyListener {

    private final static long EXIT_TIME = 2000L;
    private long mExitTime = 0;

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if (rootView != null) {
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.KEYCODE_DPAD_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > EXIT_TIME) {
                mExitTime = System.currentTimeMillis();
                Toast.makeText(EC.getApplicationsContext(), "双击退出" + getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            } else {
                _mActivity.finish();
                if (mExitTime != 0) {
                    mExitTime = 0;
                }
            }
        }
        return false;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();

    }


}
