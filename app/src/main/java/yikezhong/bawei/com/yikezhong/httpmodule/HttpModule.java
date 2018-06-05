package yikezhong.bawei.com.yikezhong.httpmodule;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yikezhong.bawei.com.yikezhong.api.ApiInterface;
import yikezhong.bawei.com.yikezhong.api.IApi;
import yikezhong.bawei.com.yikezhong.http.HttpUri;

/**
 * Created by Think on 2018/6/5.
 *
 * 容器  网络请求
 */

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    IApi provideLoginApi(OkHttpClient.Builder builder) {
        //okHttp拦截器
        OkHttpClient builder1 = new OkHttpClient.Builder()
                .addInterceptor(new MyInter())//拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUri.GONG)
                .client(builder1)//设置okHttp拦截器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ApiInterface loginApiService = retrofit.create(ApiInterface.class);
        return IApi.getIApi(loginApiService);
    }
    //拦截器
    public class MyInter implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取到request
            Request request = chain.request();
            okhttp3.HttpUrl httpUrl = request
                    .url()
                    .newBuilder()
                    .addQueryParameter("source", "android")
                    .build();
            Request requestNew = request
                    .newBuilder()
                    .url(httpUrl)
                    .build();
            return chain.proceed(requestNew);

        }
    }

}
