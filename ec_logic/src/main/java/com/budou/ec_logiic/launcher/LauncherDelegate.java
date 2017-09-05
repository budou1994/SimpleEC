package com.budou.ec_logiic.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.budou.ec_core.delegates.EcDelegate;
import com.budou.ec_core.ui.banner.BannerScrollTag;
import com.budou.ec_core.util.storage.EcPreference;
import com.budou.ec_core.util.timer.BaseTimerTask;
import com.budou.ec_core.util.timer.ITimerListener;
import com.budou.ec_logiic.R;
import com.budou.ec_logiic.R2;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * package：com.budou.ec_logiic.launcher
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月05日 22:35
 * desc   ：启动页delegate
 */

public class LauncherDelegate extends EcDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView textView = null;

    private Timer mTimer = null;
    private int Count = 5;


    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    private void checkIsShowScroll() {
        if (!EcPreference.getAppFlag(BannerScrollTag.HAS_FIRST_LAUNCHER_APP.name())) {
            getSupportDelegate().start(new LauncherScrollDelegate(),SINGLETASK);
        }else {
            //登录逻辑
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTimer != null) {
                    textView.setText(MessageFormat.format("跳过\n{0}s", Count));
                    Count--;
                    if (Count < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });

    }
}
