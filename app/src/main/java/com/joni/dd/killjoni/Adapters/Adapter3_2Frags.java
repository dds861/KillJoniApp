package com.joni.dd.killjoni.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.UserMenu.User3_2Frags;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class Adapter3_2Frags extends RecyclerView.Adapter<Adapter3_2Frags.ViewHolder> {

    private List<User3_2Frags> item;
    Context context;

    public Adapter3_2Frags(Context context, List<User3_2Frags> item) {
        Log.d("123", "RecyclerViewAdapterStatusServer");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content2_frags, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String eventTimeFrags = item.get(position).getEventTime();
        String killerLastName = item.get(position).getKillerLastName();
        String victimLastName = item.get(position).getVictimLastName();
        String weapon = item.get(position).getWeapon();
        String headshot = item.get(position).getHeadshot();



        holder.FragsEventTime.setText(eventTimeFrags.substring(11));
        holder.killerLastName.setText(killerLastName);
        holder.victimLastName.setText(victimLastName);
        holder.weapon.setText(weapon);
        holder.headshot.setText(headshot);

    }

    @Override
    public int getItemCount() {
        Log.d("123", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView eventTime;
        private TextView FragsEventTime, killerLastName, victimLastName, weapon, headshot;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.d("123", "ViewHolder");

            eventTime = (TextView) itemView.findViewById(R.id.eventTimeChat);

            FragsEventTime = (TextView) itemView.findViewById(R.id.eventTimeFrags);
            killerLastName = (TextView) itemView.findViewById(R.id.killerLastName);
            victimLastName = (TextView) itemView.findViewById(R.id.victimLastName);
            weapon = (TextView) itemView.findViewById(R.id.weapon);
            headshot = (TextView) itemView.findViewById(R.id.headshot);


        }


    }
}
