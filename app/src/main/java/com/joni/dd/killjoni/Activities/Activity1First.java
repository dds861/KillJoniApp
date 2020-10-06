package com.joni.dd.killjoni.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.joni.dd.killjoni.R;

import java.util.ArrayList;

public class Activity1First extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtToken;
    private Button mBtnAddServer;
    static SharedPreferences preferences;

    ListView listView;
    static ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    private void initView() {
        mEtToken = (EditText) findViewById(R.id.etToken);
        mBtnAddServer = (Button) findViewById(R.id.btnAddServer);
        mBtnAddServer.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

        listView = (ListView) findViewById(R.id.listView);

        //Здесь надо подгрузить список охраненных данных в listview
        //инициализируем preferences
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //по одному item-у заргужаем в arrylist из preferences
        //в preferences должны быть какие нибудь данные или пустота
        for (int i = 0; i < preferences.getAll().size(); i++) {
            arrayList.add(getToken(getApplicationContext(), i));
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), view);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(Activity1First.this, "Deleted", Toast.LENGTH_SHORT).show();
                        //Текущий Токен приравниваем null, таким образом удаляем текущий Токен
                        setToken(null, getApplicationContext(), position);
                        //уменьшаем arraylist
                        arrayList.remove(position);
                        //обновляем список
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                });
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Intent intent = new Intent(getApplicationContext(), Activity3SectionsPager.class);
                String tokenToSend = getToken(getApplicationContext(), position);
                intent.putExtra("token", tokenToSend);
                startActivity(intent);

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddServer:

                String value = mEtToken.getText().toString();   //получаем текст из Edittext
                //Проверяем что введенное значение не null
                if (value == null || value.isEmpty()) {
                    Toast.makeText(this, "Token is null or empty", Toast.LENGTH_SHORT).show();
                    break;
                }



                setToken(value, this, arrayList.size());        //сохраняем значение из Edittext в preference
                //при нажатии добавить Token, список arraylist будет обновляться
                arrayList.add(getToken(getApplicationContext(), arrayList.size()));
                //при изменении данных в arraylist, необходимо уведомить адаптер
                arrayAdapter.notifyDataSetChanged();
                break;


            default:
                break;
        }


    }

    private static void setToken(String value, Context context, int key) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(String.valueOf(key), value);
        editor.commit();
    }

    private static String getToken(Context context, int key) {

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString(String.valueOf(key), null);
        return token;
    }
}
