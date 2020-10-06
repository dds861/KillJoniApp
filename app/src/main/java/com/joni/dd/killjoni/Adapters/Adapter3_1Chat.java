package com.joni.dd.killjoni.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joni.dd.killjoni.R;
import com.joni.dd.killjoni.UserMenu.User3_1Chat;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class Adapter3_1Chat extends RecyclerView.Adapter<Adapter3_1Chat.ViewHolder> {

    private List<User3_1Chat> item;
    Context context;

    public Adapter3_1Chat(Context context, List<User3_1Chat> item) {
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content1_chat, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String message = item.get(position).getMessage();
        String eventTimeChat = item.get(position).getEventTime();
        String lastName = item.get(position).getLastName();

        holder.message.setText(message);
        holder.eventTime.setText(eventTimeChat.substring(11));
        holder.lastName.setText(lastName);
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
