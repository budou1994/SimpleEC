package com.budou.simpleec.ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.budou.ec_core.delegates.EcDelegate;
import com.budou.ec_core.net.RestClient;
import com.budou.ec_core.net.callback.IError;
import com.budou.ec_core.net.callback.IFailure;
import com.budou.ec_core.net.callback.IRequest;
import com.budou.ec_core.net.callback.ISuccess;

/**
 * package：com.budou.simpleec.ec
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月02日 22:12
 * desc   ：
 */

public class ExampleDelegate extends EcDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        RestClient.builder()
                .url("http://www.songshumall.com:8021/HomePage/GetMobileIndexPage")
//                .params("", "")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .onRequest(new IRequest() {
                    @Override
                    public void onRequestStart() {

                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .build()
                .post();
    }
}
