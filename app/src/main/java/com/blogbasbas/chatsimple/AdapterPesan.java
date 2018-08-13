package com.blogbasbas.chatsimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogbasbas.chatsimple.model.MessageItem;

import java.util.List;

/**
 * Created by User on 10/08/2018.
 */

public class AdapterPesan extends RecyclerView.Adapter<AdapterPesan.MyViewHolder> {
    private static final String User = "1";


    List<MessageItem> itemList;
    Context context;

    public AdapterPesan(List<MessageItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public AdapterPesan.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan,parent,false);
            return new MyViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPesan.MyViewHolder holder, int position) {

       if (User.equals(itemList.get(position).getMessageSender())){
           holder.pesan1.setVisibility(View.GONE);
           holder.tvNama1.setVisibility(View.GONE);
           holder.pesan2.setText(itemList.get(position).getMessageBody());
       } else if (!User.equals(itemList.get(position).getMessageSender())){
           holder.pesan1.setText(itemList.get(position).getMessageBody());
           holder.pesan2.setVisibility(View.GONE);
           holder.tvNama2.setVisibility(View.GONE);
       }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pesan1,pesan2,tvNama1,tvNama2;
        public MyViewHolder(View itemView) {
            super(itemView);
            pesan1 = (TextView) itemView.findViewById(R.id.tv_body_left);
            pesan2 = (TextView) itemView.findViewById(R.id.tv_body_right);
            tvNama1 =(TextView) itemView.findViewById(R.id.tv_nama1);
            tvNama2 =(TextView) itemView.findViewById(R.id.tv_nama2);
        }
    }
}
