package com.joni.dd.killjoni.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.RetrofitCalls;

public class Fragment3_4Players extends Fragment {

    RetrofitCalls retrofitCalls;
    RadioGroup radioGroup;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment4_players, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.rbgPlayers);
        loadPlayers();
        return view;
    }

    private void loadPlayers() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPlayers);
        retrofitCalls = new RetrofitCalls(getContext(), recyclerView);
        retrofitCalls.loadPlayers(radioGroup,null);
    }
}
