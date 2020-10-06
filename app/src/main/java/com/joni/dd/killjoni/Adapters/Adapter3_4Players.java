package com.joni.dd.killjoni.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.RetrofitCalls;
import com.joni.dd.killjoni.UserMenu.User3_3Status;

import java.util.List;

/**
 * Created by dd on 09.05.2017.
 */

public class Adapter3_4Players extends RecyclerView.Adapter<Adapter3_4Players.ViewHolder> {

    Context context;
    private List<User3_3Status.P> pList;
    RadioGroup radioGroup;
    EditText edMessage;


    public Adapter3_4Players(Context context, User3_3Status userMyarenaStatus, RadioGroup radioGroup,EditText edMessage) {

        this.pList = userMyarenaStatus.getData().getP();
        this.context = context;
        this.radioGroup = radioGroup;
        this.edMessage = edMessage;
    }

    @Override
    public Adapter3_4Players.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content4_players, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter3_4Players.ViewHolder holder, int position) {


        String tv_PlayerPid = String.valueOf(pList.get(position).getPid());
        String tv_PlayerName = pList.get(position).getName();
        String tv_PlayerScore = String.valueOf(pList.get(position).getScore());
        String tv_PlayerTime = pList.get(position).getTime();

        holder.tv_PlayerPid.setText(tv_PlayerPid);
        holder.tv_PlayerName.setText(tv_PlayerName);
        holder.tv_PlayerScore.setText(tv_PlayerScore);
        holder.tv_PlayerTime.setText(tv_PlayerTime);

        final String PlayerName = String.valueOf(holder.tv_PlayerName.getText());

        //При нажатии на список игроков, отправится запрос, запрос будет содержать какая radio точка выбрана
        holder.tv_PlayerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrofitCalls().loadPlayersAction(context, PlayerName,radioGroup,edMessage);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        View view;
        TextView tv_PlayerPid;
        TextView tv_PlayerName;
        TextView tv_PlayerScore;
        TextView tv_PlayerTime;


        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.tv_PlayerPid = (TextView) view.findViewById(R.id.tv_PlayerPid);
            this.tv_PlayerName = (TextView) view.findViewById(R.id.tv_PlayerName);
            this.tv_PlayerScore = (TextView) view.findViewById(R.id.tv_PlayerScore);
            this.tv_PlayerTime = (TextView) view.findViewById(R.id.tv_PlayerTime);


        }
    }
}

