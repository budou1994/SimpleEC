package com.budou.ec_core.net;

import com.budou.ec_core.app.ConfigType;
import com.budou.ec_core.app.EC;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * package：com.budou.ec_core.net
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月03日 03:17
 * desc   ：
 */

public class RestCreator {


    /**
     * 全局参数
     */
    public static final class ParamsHolder{
        private static final WeakHashMap<String,Object>PARAMS=new WeakHashMap<>();
    }

    public static WeakHashMap<String,Object>getParams(){
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = (String) EC.getConfigurations()
                .get(ConfigType.API_HOST.name());

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .build();

    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MINUTES)
                .build();

    }

    private static final class RestServiceHolder {

        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT
                .create(RestService.class);
    }
}
