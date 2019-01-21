package com.blogbasbas.chatsimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogbasbas.chatsimple.model.MessageItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 10/08/2018.
 */

public class AdapterPesan extends RecyclerView.Adapter<AdapterPesan.MyViewHolder> {
    private static final String User = "2";
    // list
    private List<MessageItem> itemList;

    AdapterPesan(List<MessageItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public AdapterPesan.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPesan.MyViewHolder holder, int position) {
        holder.setContent(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemSender)
        CardView sender;

        @BindView(R.id.itemReceiver)
        CardView receiver;

        @BindView(R.id.tvSenderUsername)
        TextView tvSenderUsername;

        @BindView(R.id.tvSenderMessage)
        TextView tvSenderMessage;

        @BindView(R.id.tvReceiverUsername)
        TextView tvReceiverUsername;

        @BindView(R.id.tvReceiverMessage)
        TextView tvReceiverMessage;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setContent(MessageItem item){
//
            if (User.equals(item.getMessageSender())){
                receiver.setVisibility(View.GONE);
                tvReceiverUsername.setVisibility(View.GONE);

                tvSenderMessage.setText(item.getMessageBody());
                tvSenderUsername.setText("Bas");
            } else {
                sender.setVisibility(View.GONE);
                tvSenderUsername.setVisibility(View.GONE);

                tvReceiverMessage.setText(item.getMessageBody());
                tvReceiverUsername.setText("Umar Basri");
            }
        }
    }
}