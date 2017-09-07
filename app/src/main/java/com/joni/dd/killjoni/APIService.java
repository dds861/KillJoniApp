package com.joni.dd.killjoni;


import com.joni.dd.killjoni.Menu1.UserMenu1;
import com.joni.dd.killjoni.Menu2.UserMenu2;
import com.joni.dd.killjoni.Menu3.UserMenu3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dd on 03.05.2017.
 */

public interface APIService {
    //url for Chat
    @GET("hlstats_Events_Chat.php")
    Call<List<UserMenu1>> getUserDataChat();

    //url for Frags
    @GET("hlstats_Events_Frags.php")
    Call<List<UserMenu2>> getUserDataFrags();

    //url for myarena Status
    @GET("api.php?query=status&token=5d4b9daa7be20d6d58cbb2028170f961")
    Call<UserMenu3> getUserData();

}
