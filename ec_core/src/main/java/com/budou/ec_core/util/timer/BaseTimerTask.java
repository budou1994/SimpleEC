package com.budou.ec_core.util.timer;

import java.util.TimerTask;

/**
 * package：com.budou.ec_core.util.timer
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月05日 22:50
 * desc   ：
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener listener = null;

    public BaseTimerTask(ITimerListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        if (listener != null) {
            listener.onTimer();
        }
    }
}
