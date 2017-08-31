package com.budou.ec_core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * package：com.budou.ec_core.app
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 21:54
 * desc   ：存储全局信息
 */

public final class EC {

    /**
     * 在项目module中对EC进行配置时，就会将配置文件信息传递到Configurator配置项中
     *
     * @param context 上下文对象
     * @return 配置项实例
     */
    public static Configurator init(Context context) {

        Configurator.getInstance()
                .getEcCONFIGS()
                .put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());

        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getEcCONFIGS();
    }

    public static Context getApplicationsContext() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
