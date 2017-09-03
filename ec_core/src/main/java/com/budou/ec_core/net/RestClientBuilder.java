package com.budou.ec_core.net;

import android.content.Context;

import com.budou.ec_core.net.callback.IError;
import com.budou.ec_core.net.callback.IFailure;
import com.budou.ec_core.net.callback.IRequest;
import com.budou.ec_core.net.callback.ISuccess;
import com.budou.ec_core.ui.loader.EcLoader;
import com.budou.ec_core.ui.loader.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * package：com.budou.ec_core.net
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 21:36
 * desc   ：
 */

public class RestClientBuilder {

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private String mUrl = null;
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IError mIError = null;
    private IFailure mIFailure = null;
    private RequestBody mBody = null;
    private LoaderStyle mStyle = null;
    private Context mContext = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String mUrl) {
        this.mUrl = mUrl;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> mParams) {
        PARAMS.putAll(mParams);
        return this;
    }

    public final RestClientBuilder params(String key, Object valus) {
        PARAMS.put(key, valus);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest mIRequest) {
        this.mIRequest = mIRequest;
        return this;
    }

    public RestClientBuilder failure(IFailure mIFailure) {
        this.mIFailure = mIFailure;
        return this;
    }

    public RestClientBuilder error(IError mIError) {
        this.mIError = mIError;
        return this;
    }

    public RestClientBuilder success(ISuccess mISuccess) {
        this.mISuccess = mISuccess;
        return this;
    }

    public RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }
    public RestClientBuilder loader(Context context,LoaderStyle style){
        this.mStyle=style;
        this.mContext=context;
        return this;
    }
    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl,
                PARAMS,
                mIRequest,
                mISuccess,
                mIError,
                mIFailure,
                mBody,
                mContext,
                mStyle);
    }
}
