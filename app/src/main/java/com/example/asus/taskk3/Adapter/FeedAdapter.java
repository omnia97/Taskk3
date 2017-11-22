package com.example.asus.taskk3.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.taskk3.Interface.ItemClickListener;
import com.example.asus.taskk3.Model.RSSObject;
import com.example.asus.taskk3.R;

/**
 * Created by asus on 11/21/2017.
 */

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
{
    public TextView textTitle,textPubDate,textContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);
        textTitle=(TextView)itemView.findViewById(R.id.textTitle);
        textPubDate=(TextView)itemView.findViewById(R.id.textPubDate);
        textContent=(TextView)itemView.findViewById(R.id.textContent);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(),true);
        return true;
    }
}



public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>{

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {

        holder.textTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.textPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.textContent.setText(rssObject.getItems().get(position).getContent());


    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
