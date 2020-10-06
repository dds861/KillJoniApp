package com.joni.dd.killjoni.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.RetrofitCalls;

public class Fragment3_3Status extends Fragment implements View.OnClickListener {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3_status, container, false);

        Button btnStart = (Button) view.findViewById(R.id.btnStart);
        Button btnStop = (Button) view.findViewById(R.id.btnStop);
        Button btnRestart = (Button) view.findViewById(R.id.btnRestart);
        Button btnChangeMap = (Button) view.findViewById(R.id.btnChangeMap);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnRestart.setOnClickListener(this);
        btnChangeMap.setOnClickListener(this);

        loadStatus();
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                new RetrofitCalls().loadServerControlButtons(getContext(), R.id.btnStart);
                break;
            case R.id.btnStop:
                new RetrofitCalls().loadServerControlButtons(getContext(), R.id.btnStop);
                break;
            case R.id.btnRestart:
                new RetrofitCalls().loadServerControlButtons(getContext(), R.id.btnRestart);
                break;
            case R.id.btnChangeMap:
                new RetrofitCalls().loadServerControlButtons(getContext(), R.id.btnChangeMap);
                break;
        }
    }

    private void loadStatus() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewStatus);
        RetrofitCalls retrofitCallsStatus = new RetrofitCalls(getContext(), recyclerView);
        retrofitCallsStatus.loadStatus();
    }
}
