package com.joni.dd.killjoni.Menu1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class AdapterMenu1 extends RecyclerView.Adapter<AdapterMenu1.ViewHolder> {

    private List<UserMenu1> item;
    Context context;

    public AdapterMenu1(Context context, List<UserMenu1> item) {
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.menu1_content, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.message.setText(item.get(position).getMessage());
            holder.eventTime.setText(item.get(position).getEventTime());
            holder.lastName.setText(item.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView message, eventTime, lastName;

        public ViewHolder(View itemView) {
            super(itemView);

            message = (TextView) itemView.findViewById(R.id.message);
            eventTime = (TextView) itemView.findViewById(R.id.eventTimeChat);
            lastName = (TextView) itemView.findViewById(R.id.lastName);

        }
    }
}
