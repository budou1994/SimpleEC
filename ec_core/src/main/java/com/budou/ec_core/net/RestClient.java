package com.budou.ec_core.net;

import android.content.Context;

import com.budou.ec_core.net.callback.IError;
import com.budou.ec_core.net.callback.IFailure;
import com.budou.ec_core.net.callback.IRequest;
import com.budou.ec_core.net.callback.ISuccess;
import com.budou.ec_core.net.callback.RequestCallbacks;
import com.budou.ec_core.net.download.DownloadHandler;
import com.budou.ec_core.ui.loader.EcLoader;
import com.budou.ec_core.ui.loader.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
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
    private final ISuccess ISUCCESS;
    private final IError IERROR;
    private final String DOWLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final IFailure IFAILURE;
    private final RequestBody BODY;
    private final File FILE;
    private final Context CONTEXT;
    private final LoaderStyle STYLE;

    public RestClient(String url,
                      WeakHashMap<String, Object> params,
                      IRequest iRequest,
                      ISuccess iSuccess,
                      IError iError,
                      IFailure iFailure,
                      String name,
                      String extension,
                      String dowload_dir,
                      RequestBody body,
                      File file,
                      Context context,
                      LoaderStyle style) {
        this.URL = url;
        params.putAll(PARAMS);
        this.IREQUEST = iRequest;
        this.ISUCCESS = iSuccess;
        this.IERROR = iError;
        this.IFAILURE = iFailure;
        this.NAME = name;
        this.EXTENSION = extension;
        this.DOWLOAD_DIR = dowload_dir;
        this.BODY = body;
        this.FILE = file;
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
            EcLoader.showLoading(CONTEXT, STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = service.upload(URL, body);
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
                ISUCCESS,
                IERROR,
                IFAILURE,
                STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public  final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (PARAMS.isEmpty()) {
                throw new RuntimeException("ＰＡＲＡＭＳ must be null");
            } else {
                request(HttpMethod.POST_RAW);
            }
        }
    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (PARAMS.isEmpty()) {
                throw new RuntimeException("ＰＡＲＡＭＳ must be null");
            } else {
                request(HttpMethod.PUT_RAW);
            }
        }
    }

    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void download() {
        new DownloadHandler(URL,PARAMS, IREQUEST, DOWLOAD_DIR, EXTENSION, NAME,
                ISUCCESS, IFAILURE, IERROR)
                .handleDowload();
    }
}
