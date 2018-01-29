package dekkan100.appsmatic.com.dekkan100.API.WebService;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import dekkan100.appsmatic.com.dekkan100.API.URLs.Urls;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eng Ali on 1/29/2018.
 */
public class Generator {

    private static final String API_URL = Urls.API_BASE_URL;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100,TimeUnit.SECONDS);
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }






}
