package com.joni.dd.killjoni;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.joni.dd.killjoni.Adapters.Adapter3_3Status;
import com.joni.dd.killjoni.Adapters.Adapter3_4Players;
import com.joni.dd.killjoni.UserMenu.User3_3Status;
import com.joni.dd.killjoni.UserMenu.User3_4Players;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by dds86 on 15-Oct-17.
 */

public class RetrofitCalls extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    Retrofit retrofit;


    private String getToken(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }


    public RetrofitCalls() {
    }

    public RetrofitCalls(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    private void loadRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.myarena.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void loadRecyclerview() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void loadPlayers(final RadioGroup radioGroup, final EditText edMessage) {
        loadRecyclerview();
        loadRetrofit();

        APIService apiService = retrofit.create(APIService.class);
        Call<User3_3Status> call = apiService.getPlayers("status", getToken(context));
        call.enqueue(new Callback<User3_3Status>() {
            @Override
            public void onResponse(Call<User3_3Status> call, Response<User3_3Status> response) {

                User3_3Status user3Status = response.body();
                //Проверяем правильный ли Токен
                if (!user3Status.getStatus().equals("NO")) {
                    Adapter3_4Players recyclerViewAdapter = new Adapter3_4Players(context, user3Status, radioGroup, edMessage);
                    recyclerView.setAdapter(recyclerViewAdapter);

                }
            }

            @Override
            public void onFailure(Call<User3_3Status> call, Throwable t) {

            }
        });
    }

    public void loadStatus() {
        loadRecyclerview();
        loadRetrofit();

        APIService apiService = retrofit.create(APIService.class);
        Call<User3_3Status> call = apiService.getUserData("status", getToken(context));
        call.enqueue(new Callback<User3_3Status>() {
            @Override
            public void onResponse(Call<User3_3Status> call, Response<User3_3Status> response) {
                User3_3Status userMenu3 = response.body();
                Adapter3_3Status adapter1First = new Adapter3_3Status(userMenu3);
                recyclerView.setAdapter(adapter1First);
            }

            @Override
            public void onFailure(Call<User3_3Status> call, Throwable t) {

            }
        });
    }



    /**
     *
     * @param context
     * @param PlayerName
     * @param radioGroup
     * @param edMessage
     * Поступает radiogroup в которой определяется какая radio кнопка нажата, и анацилизирует PlayerNameCommand,
     * который даальше передается APIService для отправки консольной команды
     *
     */
    public void loadPlayersAction(final Context context, String PlayerName, RadioGroup radioGroup, EditText edMessage) {
        String PlayerNameCommand;


        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbPlayersKick:
                PlayerNameCommand = "amx_kick " + PlayerName;
                break;
            case R.id.rbPlayersSlap:
                PlayerNameCommand = "amx_slap " + PlayerName;
                break;
            case R.id.rbPlayersSlay:
                PlayerNameCommand = "amx_slay " + PlayerName;
                break;
            case R.id.rbPlayersBan:
                PlayerNameCommand = "amx_ban 10 " + PlayerName + " banned";
                break;
            case R.id.rbPlayersGag:
                PlayerNameCommand = "gag " + PlayerName;
                break;
            case R.id.rbMessageAllPlayers:
                PlayerNameCommand = "amx_say " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllAdmins:
                PlayerNameCommand = "amx_chat " + edMessage.getText().toString();
                break;
            case R.id.rbMessagePrivate:
                PlayerNameCommand = "amx_psay " + PlayerName + " " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllHudLeft:
                PlayerNameCommand = "amx_tsay green " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllHudCenter:
                PlayerNameCommand = "amx_csay green " + edMessage.getText().toString();
                break;

            default:
                Toast.makeText(context, "Select action", Toast.LENGTH_SHORT).show();
                PlayerNameCommand = "";
        }

        loadRetrofit();


        APIService apiService = retrofit.create(APIService.class);

        Call<User3_4Players> call = apiService.getConsoleCmd("consolecmd", PlayerNameCommand, getToken(context));
        call.enqueue(new Callback<User3_4Players>() {
            @Override
            public void onResponse(Call<User3_4Players> call, Response<User3_4Players> response) {
                User3_4Players userMenu5 = response.body();

                Toast.makeText(context, userMenu5.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User3_4Players> call, Throwable t) {

            }
        });
    }

    public void loadServerControlButtons(final Context context, int serverControlButtons) {
        final Context context1 = context;

        String controlButton = null;
        switch (serverControlButtons) {
            case R.id.btnStart:
                controlButton = "start";
                break;
            case R.id.btnStop:
                controlButton = "stop";
                break;
            case R.id.btnRestart:
                controlButton = "restart";
                break;
            case R.id.btnChangeMap:
                controlButton = "changelevel";
                break;
        }

        loadRetrofit();

        APIService apiService = retrofit.create(APIService.class);
        Call<User3_4Players> call = apiService.getServerActions(controlButton, getToken(context));
        call.enqueue(new Callback<User3_4Players>() {
            @Override
            public void onResponse(Call<User3_4Players> call, Response<User3_4Players> response) {
                User3_4Players userMenu5 = response.body();
                Toast.makeText(context1, userMenu5.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User3_4Players> call, Throwable t) {

            }
        });
    }
}
