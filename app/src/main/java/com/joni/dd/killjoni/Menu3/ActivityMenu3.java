package com.joni.dd.killjoni.Menu3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.joni.dd.killjoni.APIService;
import com.joni.dd.killjoni.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityMenu3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserMenu3> data;
    private AdapterMenu3 recyclerViewAdapter;
    private UserMenu3 userMyarenaStatusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initViews();
            }
        });


    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewMain2);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.myarena.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<UserMenu3> call2 = apiService.getUserData();

        call2.enqueue(new Callback<UserMenu3>() {
            @Override
            public void onResponse(Call<UserMenu3> call, Response<UserMenu3> response) {

                userMyarenaStatusList = response.body();


//                data = new ArrayList<>(Arrays.asList(userMyarenaStatusList.getOnline()));
                recyclerViewAdapter = new AdapterMenu3(userMyarenaStatusList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<UserMenu3> call, Throwable t) {

            }


        });
    }
}
