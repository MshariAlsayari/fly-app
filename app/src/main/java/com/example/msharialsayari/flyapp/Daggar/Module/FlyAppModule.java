package com.example.msharialsayari.flyapp.Daggar.Module;

import android.util.Log;

import com.example.msharialsayari.flyapp.Retrofit.Interface.NetworkApi;
import com.squareup.picasso.Downloader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by msharialsayari on 10/10/2017 AD.
 */
@Module
public class FlyAppModule {


    @Provides
    @Singleton
    public Retrofit createRetrofitObject() {


        return new Retrofit.Builder()
                .baseUrl("https://api.schiphol.nl/public-flights/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    @Provides
    @Singleton
    NetworkApi provideNetworApi(Retrofit retrofit) {
        return retrofit.create(NetworkApi.class);
    }


}
