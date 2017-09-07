package com.joni.dd.killjoni.Menu2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class AdapterMenu2 extends RecyclerView.Adapter<AdapterMenu2.ViewHolder> {

    private List<UserMenu2> item;
    Context context;

    public AdapterMenu2(Context context, List<UserMenu2> item) {
        Log.d("123", "RecyclerViewAdapterStatusServer");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu2_content, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            holder.FragsEventTime.setText(item.get(position).getEventTime());
            holder.killerLastName.setText(item.get(position).getKillerLastName());
            holder.victimLastName.setText(item.get(position).getVictimLastName());
            holder.weapon.setText(item.get(position).getWeapon());
            holder.headshot.setText(item.get(position).getHeadshot());

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
