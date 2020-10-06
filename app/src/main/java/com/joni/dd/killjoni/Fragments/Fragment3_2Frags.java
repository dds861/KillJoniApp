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
import com.joni.dd.killjoni.Adapters.Adapter3_2Frags;
import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.UserMenu.User3_2Frags;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment3_2Frags extends Fragment {

    private LinearLayoutManager layoutManager;
    private List<User3_2Frags> userList = null;

    View view;
    Retrofit retrofit = null;
    String url;
    APIService apiService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2_frags, container, false);
        //Setting the url
        url = "http://killjoniast.myarena.ru/android/";

        //Initializing Retrofit with building it
        createRetrofit(url);

        //Initializing apiService
        apiService = retrofit.create(APIService.class);


        getFrags();


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


    public void getFrags() {


        Call<List<User3_2Frags>> call = apiService.getFrags();
        call.enqueue(new Callback<List<User3_2Frags>>() {
            @Override
            public void onResponse(Call<List<User3_2Frags>> call, Response<List<User3_2Frags>> response) {

                userList = response.body();
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewFragment2);
                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);

                Adapter3_2Frags adapterMenu2 = new Adapter3_2Frags(getContext(), userList);


                recyclerView.setAdapter(adapterMenu2);
            }

            @Override
            public void onFailure(Call<List<User3_2Frags>> call, Throwable t) {
                Log.d("123", t.getMessage());
            }
        });


    }

}
