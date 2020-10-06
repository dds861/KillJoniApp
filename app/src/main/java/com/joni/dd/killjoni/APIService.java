package com.joni.dd.killjoni;


import com.joni.dd.killjoni.UserMenu.User3_3Status;
import com.joni.dd.killjoni.UserMenu.User3_1Chat;
import com.joni.dd.killjoni.UserMenu.User3_2Frags;
import com.joni.dd.killjoni.UserMenu.User3_4Players;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dd on 03.05.2017.
 */

public interface APIService {
    //url for Chat
    @GET("hlstats_Events_Chat.php")
    Call<List<User3_1Chat>> getChat();

    //url for Frags
    @GET("hlstats_Events_Frags.php")
    Call<List<User3_2Frags>> getFrags();

    //url for myarena Status
    @GET("api.php")
    Call<User3_3Status> getUserData(@Query("query") String query, @Query("token") String token);

    //url for myarena Status
    @GET("api.php")
    Call<User3_3Status> getPlayers(@Query("query") String query, @Query("token") String token);

    //kick
    @GET("api.php")
    Call<User3_4Players> getConsoleCmd(@Query("query") String query, @Query("cmd") String cmd, @Query("token") String token);;

    //Start
    @GET("api.php")
    Call<User3_4Players> getServerActions(@Query("query") String query, @Query("token") String token);





}
