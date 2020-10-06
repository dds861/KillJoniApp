package com.joni.dd.killjoni.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joni.dd.killjoni.APIService;
import com.joni.dd.killjoni.Adapters.Adapter3_1Chat;
import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.UserMenu.User3_1Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment3_1Chat extends Fragment {

    private LinearLayoutManager layoutManager;
    private List<User3_1Chat> userList = null;

    private Call<List<User3_1Chat>> call = null;
    View view;
    Retrofit retrofit = null;
    String url;
    APIService apiService;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1_chat,container,false);
        //Setting the url
        url = "http://killjoniast.myarena.ru/android/";

        //Initializing Retrofit with building it
        createRetrofit(url);

        //Initializing apiService
        apiService = retrofit.create(APIService.class);

        getChat();
        return view;
    }

    private Retrofit createRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private void getChat() {
        call = apiService.getChat();
        call.enqueue(new Callback<List<User3_1Chat>>() {
            @Override
            public void onResponse(Call<List<User3_1Chat>> call, Response<List<User3_1Chat>> response) {

                userList = response.body();
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewFragment1);
                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                Adapter3_1Chat adapterMenu1 = new Adapter3_1Chat(getContext(), userList);
                recyclerView.setAdapter(adapterMenu1);
            }
            @Override
            public void onFailure(Call<List<User3_1Chat>> call, Throwable t) {
                Log.d("123", t.getMessage());
            }
        });
    }
}
