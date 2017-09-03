package com.budou.ec_core.net;

import android.content.Context;

import com.budou.ec_core.net.callback.IError;
import com.budou.ec_core.net.callback.IFailure;
import com.budou.ec_core.net.callback.IRequest;
import com.budou.ec_core.net.callback.ISuccess;
import com.budou.ec_core.net.callback.RequestCallbacks;
import com.budou.ec_core.ui.loader.EcLoader;
import com.budou.ec_core.ui.loader.LoaderStyle;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * package：com.budou.ec_core.net
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 02:26
 * desc   ：
 */

public class RestClient {

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUEST;
    private final ISuccess ISUCESS;
    private final IError IERROR;
    private final IFailure IFAILURE;
    private final RequestBody BODY;
    private final Context CONTEXT;
    private final LoaderStyle STYLE;

    public RestClient(String url,
                      WeakHashMap<String, Object> params,
                      IRequest iRequest,
                      ISuccess iSuccess,
                      IError iError,
                      IFailure iFailure,
                      RequestBody body,
                      Context context,
                      LoaderStyle style) {
        this.URL = url;
        params.putAll(PARAMS);
        this.IREQUEST = iRequest;
        this.ISUCESS = iSuccess;
        this.IERROR = iError;
        this.IFAILURE = iFailure;
        this.BODY = body;
        this.CONTEXT = context;
        this.STYLE = style;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {

        RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (IREQUEST != null) {
            IREQUEST.onRequestStart();
        }

        if (STYLE != null) {
            EcLoader.showLoading(CONTEXT,STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallBack());
        }
    }

    private Callback<String> getRequestCallBack() {
        return new RequestCallbacks(IREQUEST,
                ISUCESS,
                IERROR,
                IFAILURE,
                STYLE);
    }

    public void get() {
        request(HttpMethod.GET);
    }

    public void post() {
        request(HttpMethod.POST);
    }

    public void put() {
        request(HttpMethod.PUT);
    }

    public void delete() {
        request(HttpMethod.DELETE);
    }
}
