package com.joni.dd.killjoni.Menu3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;

/**
 * Created by dd on 09.05.2017.
 */

public class AdapterMenu3 extends RecyclerView.Adapter<AdapterMenu3.ViewHolder> {

    private UserMenu3 userMyarenaStatus;

    public AdapterMenu3(UserMenu3 userMyarenaStatus) {
        this.userMyarenaStatus = userMyarenaStatus;
    }

    @Override
    public AdapterMenu3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu3_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMenu3.ViewHolder holder, int position) {
        holder.mTvStatus.setText(userMyarenaStatus.getStatus());
        holder.mTvOnline.setText(String.valueOf(userMyarenaStatus.getOnline()));
        holder.mTvServerId.setText(userMyarenaStatus.getServerId());
        holder.mTvServerName.setText(userMyarenaStatus.getServerName());
        holder.mTvServerAddress.setText(userMyarenaStatus.getServerAddress());
        holder.mTvServerMaxslots.setText(userMyarenaStatus.getServerMaxslots());
        holder.mTvServerLocation.setText(userMyarenaStatus.getServerLocation());
        holder.mTvServerType.setText(userMyarenaStatus.getServerType());
        holder.mTvServerDateblock.setText(userMyarenaStatus.getServerDateblock());
        holder.mTvServerDaystoblock.setText(String.valueOf(userMyarenaStatus.getServerDaystoblock()));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        View view;
        TextView mTvStatus;
        TextView mTvOnline;
        TextView mTvServerId;
        TextView mTvServerName;
        TextView mTvServerAddress;
        TextView mTvServerMaxslots;
        TextView mTvServerLocation;
        TextView mTvServerType;
        TextView mTvServerDateblock;
        TextView mTvServerDaystoblock;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mTvStatus = (TextView) view.findViewById(R.id.tv_status);
            this.mTvOnline = (TextView) view.findViewById(R.id.tv_online);
            this.mTvServerId = (TextView) view.findViewById(R.id.tv_serverId);
            this.mTvServerName = (TextView) view.findViewById(R.id.tv_serverName);
            this.mTvServerAddress = (TextView) view.findViewById(R.id.tv_serverAddress);
            this.mTvServerMaxslots = (TextView) view.findViewById(R.id.tv_serverMaxslots);
            this.mTvServerLocation = (TextView) view.findViewById(R.id.tv_serverLocation);
            this.mTvServerType = (TextView) view.findViewById(R.id.tv_serverType);
            this.mTvServerDateblock = (TextView) view.findViewById(R.id.tv_serverDateblock);
            this.mTvServerDaystoblock = (TextView) view.findViewById(R.id.tv_serverDaystoblock);
        }
    }
}

