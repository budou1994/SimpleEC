package com.budou.ec_core.net.callback;

/**
 * package：com.budou.ec_core.net.callback
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 21:44
 * desc   ：请求失败回调
 */

public interface IError {
    void onError(int code,String msg);
}
