package com.example.windcore.twitterapproach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.windcore.twitterapproach.db.Result;
import com.google.gson.JsonArray;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_tweet)
    EditText etTweet;
    @BindView(R.id.b_post)
    Button bPost;

    List<Result> result;
    //MovieDBAPI movieDBAPI;
    TwitterAPI twitterAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


       
        twitterAPI = ApiUtils.getAPIService();
        Log.d("mess","First");
        //getTimeline();

    }

    @OnClick(R.id.b_post)
    public void onViewClicked() {
            postTweet(etTweet.getText().toString());
    }


    protected void getTimeline(){

       twitterAPI.getTimeline().enqueue(new Callback<JsonArray>() {
           @Override
           public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
               Log.d("mess",response.body().get(0).toString());
           }

           @Override
           public void onFailure(Call<JsonArray> call, Throwable t) {
               Log.d("mess", call.toString());
               Log.d("mess",t.getMessage());
           }
       });
    }

    protected void postTweet(String status){
        twitterAPI.postTweet(status).enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Log.d("mess","posted");
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("mess", "fail");

            }
        });
    }



}
//Log.d("mess",t.getMessage());