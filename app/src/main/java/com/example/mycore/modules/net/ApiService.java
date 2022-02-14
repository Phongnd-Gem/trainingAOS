package com.example.mycore.modules.net;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.moczul.ok2curl.CurlInterceptor;

import java.text.DateFormat;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final long REQUEST_TIME_OUT = 60;

    public static GithubAPI githubAPI() {
        return retrofit.create(GithubAPI.class);
    }

    private static Retrofit retrofit = new Retrofit
            .Builder()
            .client(getOkHttpClient())
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setLenient()
                    .setDateFormat(DateFormat.DEFAULT)
                    .create())).build();

    private static OkHttpClient getOkHttpClient() {
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
                .cipherSuites(
                        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384,
                        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
                        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();

        return new OkHttpClient.Builder()
                .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new CurlInterceptor(message -> Log.v("Ok2Curl", message)))
                .connectionSpecs(Collections.singletonList(spec))
                .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }
}
