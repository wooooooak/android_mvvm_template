package com.example.android_mvvm_template.di

import com.example.android_mvvm_template.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun getNetworkModule(baseUrl: String) = module {
    factory { provideYourApi() }
    single<OkHttpClient> { provideOkHttpClient() }
    single<Retrofit> { provideRetrofit(get(), baseUrl) }
}

private fun provideYourApi() {

}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    baseUrl: String
): Retrofit = Retrofit.Builder().client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(baseUrl)
    .build()

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
        .connectTimeout(5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)
        .readTimeout(5, TimeUnit.MINUTES)
        .retryOnConnectionFailure(false)
        .build()
