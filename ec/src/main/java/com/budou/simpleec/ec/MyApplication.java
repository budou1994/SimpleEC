package com.budou.simpleec.ec;

import android.app.Application;

import com.budou.ec_core.app.EC;
import com.budou.ec_core.net.interceptors.DebugInterceptor;
import com.budou.ec_logiic.icons.FontEcModule;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * package：com.budou.simpleec.ec
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 23:52
 * desc   ：
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EC.init(this)
                .withApiHost("http://127.0.0.1/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }
}
