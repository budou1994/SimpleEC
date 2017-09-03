package com.budou.ec_core.net.callback;

/**
 * package：com.budou.ec_core.net.callback
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 21:49
 * desc   ：在请求开始与结束的时候进行回调
 */

public interface IRequest {

    void onRequestStart();

    void onRequestEnd();
}
