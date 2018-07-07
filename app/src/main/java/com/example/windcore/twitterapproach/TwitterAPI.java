package com.example.windcore.twitterapproach;


import com.example.windcore.twitterapproach.db.Result;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TwitterAPI {
    @GET("/1.1/statuses/user_timeline.json")
    Call<JsonArray> getTimeline();

    @POST("/1.1/statuses/update.json")
    Call<JsonArray> postTweet(@Query("status") String status);

}
