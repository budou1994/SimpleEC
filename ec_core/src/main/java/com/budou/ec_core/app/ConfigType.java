package com.budou.ec_core.app;

/**
 * package：com.budou.ec_core.app
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 21:55
 * desc   ：枚举类，可用作惰性单例的初始化
 */

public enum ConfigType {

    API_HOST,  //api host 网络请求域名
    APPLICATION_CONTEXT, //全局上下文对象
    CONFIG_READY, // 配置是否完成
    ICON; // 字体图标库
}
