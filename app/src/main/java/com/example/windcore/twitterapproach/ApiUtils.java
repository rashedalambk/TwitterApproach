package com.example.windcore.twitterapproach;


import okhttp3.OkHttpClient;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class ApiUtils {

    private ApiUtils() {
    }

    private static final String BASE_URL = Constants.baseURL;

    public static TwitterAPI getAPIService() {

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.consumerKey, Constants.consumerSecret);
        consumer.setTokenWithSecret(Constants.accessToken, Constants.accessTokenSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();
        return RetrofitClient.getClient(BASE_URL, client).create(TwitterAPI.class);
    }

}