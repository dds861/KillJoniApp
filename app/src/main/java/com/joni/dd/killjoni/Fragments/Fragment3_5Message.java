package com.joni.dd.killjoni.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.RetrofitCalls;

public class Fragment3_5Message extends Fragment {


    RadioGroup radioGroup;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment5_message, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.rbgMessage);
        EditText edMessage=(EditText)view.findViewById(R.id.edMessage);
        loadPlayers(edMessage);
        return view;
    }

    private void loadPlayers(EditText edMessage) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMessagePlayers);
        RetrofitCalls retrofitCalls = new RetrofitCalls(getContext(), recyclerView);
        //Загружаем игроков
        retrofitCalls.loadPlayers(radioGroup,edMessage);
    }
}
