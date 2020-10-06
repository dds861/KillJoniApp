package com.joni.dd.killjoni.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.UserMenu.User3_3Status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: dds86
 * Created on 17-Oct-17
 */
public class Adapter3_3Status extends RecyclerView.Adapter<Adapter3_3Status.ViewHolder> {
    private Context mContext;
    View view;
    User3_3Status userMenu3;


    private ClickListener clickListener;

    public Adapter3_3Status(User3_3Status userMenu3) {
        this.userMenu3 = userMenu3;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content3_status, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //TODO: add your code
        if (!userMenu3.getStatus().equals("NO")) {
            String tv_status = userMenu3.getStatus();
            String tv_online = String.valueOf(userMenu3.getOnline());
            String tv_serverId = userMenu3.getServer_id();
            String tv_serverName = userMenu3.getServer_name();
            String tv_serverAddress = userMenu3.getServer_address();
            String tv_serverMaxslots = userMenu3.getServer_maxslots();
            String tv_serverLocation = userMenu3.getServer_location();
            String tv_serverType = userMenu3.getServer_type();
            String tv_serverDaystoblock = String.valueOf(userMenu3.getServer_daystoblock());
            String tv_serverPlayersOnline = String.valueOf(userMenu3.getData().getS().getPlayers());
            String tv_serverMap = userMenu3.getData().getS().getMap();


            holder.tv_status.setText(tv_status);
            holder.tv_online.setText(tv_online);
            holder.tv_serverId.setText(tv_serverId);
            holder.tv_serverName.setText(tv_serverName);
            holder.tv_serverAddress.setText(tv_serverAddress);
            holder.tv_serverMaxslots.setText(tv_serverMaxslots);
            holder.tv_serverLocation.setText(tv_serverLocation);
            holder.tv_serverType.setText(tv_serverType);
            holder.tv_serverDaystoblock.setText(tv_serverDaystoblock);

            holder.tv_serverPlayersOnline.setText(tv_serverPlayersOnline);
            holder.tv_serverMap.setText(tv_serverMap);


            long seconds = Long.valueOf(userMenu3.getServer_dateblock());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String dateString = formatter.format(new Date(seconds * 1000L));


            holder.tv_serverDateblock.setText(dateString);

        }

    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        View view;
        TextView tv_status;
        TextView tv_online;
        TextView tv_serverId;
        TextView tv_serverName;
        TextView tv_serverAddress;
        TextView tv_serverMaxslots;
        TextView tv_serverLocation;
        TextView tv_serverType;
        TextView tv_serverDateblock;
        TextView tv_serverDaystoblock;
        TextView tv_serverPlayersOnline;
        TextView tv_serverMap;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.tv_status = (TextView) view.findViewById(R.id.tv_status);
            this.tv_online = (TextView) view.findViewById(R.id.tv_online);
            this.tv_serverId = (TextView) view.findViewById(R.id.tv_serverId);
            this.tv_serverName = (TextView) view.findViewById(R.id.tv_serverName);
            this.tv_serverAddress = (TextView) view.findViewById(R.id.tv_serverAddress);
            this.tv_serverMaxslots = (TextView) view.findViewById(R.id.tv_serverMaxslots);
            this.tv_serverLocation = (TextView) view.findViewById(R.id.tv_serverLocation);
            this.tv_serverType = (TextView) view.findViewById(R.id.tv_serverType);
            this.tv_serverDateblock = (TextView) view.findViewById(R.id.tv_serverDateblock);
            this.tv_serverDaystoblock = (TextView) view.findViewById(R.id.tv_serverDaystoblock);
            this.tv_serverPlayersOnline = (TextView) view.findViewById(R.id.tv_serverPlayersOnline);
            this.tv_serverMap = (TextView) view.findViewById(R.id.tv_serverMap);
        }
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }

}
