package com.budou.ec_core.net.callback;

import android.os.Handler;

import com.budou.ec_core.ui.loader.EcLoader;
import com.budou.ec_core.ui.loader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * package：com.budou.ec_core.net.callback
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 23:47
 * desc   ：
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest IREQUEST;
    private final ISuccess ISUCESS;
    private final IError IERROR;
    private final IFailure IFAILURE;
    private final LoaderStyle LOADERSTYLE;

    private static final Handler HANDLER=new Handler();
    public RequestCallbacks(IRequest iRequest,
                            ISuccess iSuccess,
                            IError iError,
                            IFailure iFailure,
                            LoaderStyle style) {
        this.IREQUEST = iRequest;
        this.ISUCESS = iSuccess;
        this.IERROR = iError;
        this.IFAILURE = iFailure;
        this.LOADERSTYLE=style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (ISUCESS != null) {
                    ISUCESS.onSuccess(response.body());
                }
            }
        } else {
            if (IERROR != null) {
                IERROR.onError(response.code(), response.message());
            }
        }

        if (LOADERSTYLE!=null){
//            EcLoader.stopLoading();
            onRequestFinish();
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

        if (IFAILURE != null) {
            IFAILURE.onFailure();
        }
        if (IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
        if (LOADERSTYLE!=null){
            onRequestFinish();
        }
    }

    private void onRequestFinish() {
//        final long delayed = EC.getApplicationsContext(ConfigKeys.LOADER_DELAYED);
        if (LOADERSTYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    EcLoader.stopLoading();
                }
            }, 1000);
        }
    }
}
