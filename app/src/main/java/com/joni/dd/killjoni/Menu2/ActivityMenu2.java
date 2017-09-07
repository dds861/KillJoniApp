package com.joni.dd.killjoni.Menu2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.joni.dd.killjoni.APIService;
import com.joni.dd.killjoni.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityMenu2 extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private List<UserMenu2> userList = null;
    private RecyclerView recyclerView;
    private Call<List<UserMenu2>> call = null;

    Retrofit retrofit = null;
    String url;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_with_widgets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Setting the url
        url = "http://killjoniast.myarena.ru/android/";

        //Initializing Retrofit with building it
        createRetrofit(url);

        //Initializing apiService
        apiService = retrofit.create(APIService.class);


        getUserList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserList();
            }
        });
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


    private void getUserList() {


        //получаем какое меню мы нажали
        Intent intent = getIntent();
        final int temp = intent.getIntExtra("id", 0);

        call = apiService.getUserDataFrags();


        call.enqueue(new Callback<List<UserMenu2>>() {
            @Override
            public void onResponse(Call<List<UserMenu2>> call, Response<List<UserMenu2>> response) {

                userList = response.body();
                recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
                layoutManager = new LinearLayoutManager(ActivityMenu2.this);
                recyclerView.setLayoutManager(layoutManager);

                AdapterMenu2 adapterMenu2 = new AdapterMenu2(getApplicationContext(), userList);


                recyclerView.setAdapter(adapterMenu2);
            }

            @Override
            public void onFailure(Call<List<UserMenu2>> call, Throwable t) {
                Log.d("123", t.getMessage());
            }
        });


    }

}
