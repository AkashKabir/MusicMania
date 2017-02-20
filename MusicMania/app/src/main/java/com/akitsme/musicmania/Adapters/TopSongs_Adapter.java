package com.akitsme.musicmania.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akitsme.musicmania.R;
import com.akitsme.musicmania.Model.TopSongs_data;
import com.akitsme.musicmania.helper.DownloadImageTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AKASH on 20-02-2017.
 */

public class TopSongs_Adapter  extends RecyclerView.Adapter<TopSongs_Adapter.myHolder>{
    private ArrayList<TopSongs_data> arrayList=new ArrayList<>();
    public Context mcontext;
    public TopSongs_Adapter(Context mcontext,ArrayList<TopSongs_data> arrayList){
        this.arrayList=arrayList;
        this.mcontext=mcontext;
    }


    @Override
    public TopSongs_Adapter.myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.topsongs,parent,false);
        return new TopSongs_Adapter.myHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongs_Adapter.myHolder holder, int position) {
        //DownloadImageTask runner=new DownloadImageTask(holder.imageView);
        //runner.execute(arrayList.get(position).getSongImage());
        Picasso.with(mcontext).load(arrayList.get(position).getSongImage()).into(holder.imageView);
            holder.textView.setText(arrayList.get(position).getTitle());
        holder.textView2.setText(arrayList.get(position).getArtist_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView textView2;
        public myHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.song_title);
            imageView=(ImageView)itemView.findViewById(R.id.music_image);
            textView2=(TextView)itemView.findViewById(R.id.song_artist_name);
        }
    }
}
