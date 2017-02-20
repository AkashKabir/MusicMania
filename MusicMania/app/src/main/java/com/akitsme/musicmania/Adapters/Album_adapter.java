package com.akitsme.musicmania.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akitsme.musicmania.Model.Album_data;
import com.akitsme.musicmania.Model.TopSongs_data;
import com.akitsme.musicmania.R;
import com.akitsme.musicmania.helper.DownloadImageTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AKASH on 20-02-2017.
 */

public class Album_adapter extends RecyclerView.Adapter<Album_adapter.myHolder>{

    private ArrayList<Album_data> arrayList=new ArrayList<>();
    public Context mcontext;
    public Album_adapter(Context context,ArrayList<Album_data> arrayList){
        this.arrayList=arrayList;
        this.mcontext=context;
    }


    @Override
    public Album_adapter.myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.album,parent,false);
        return new Album_adapter.myHolder(view);
    }

    @Override
    public void onBindViewHolder(Album_adapter.myHolder holder, int position) {
       // DownloadImageTask runner=new DownloadImageTask(holder.imageView);
        //runner.execute(arrayList.get(position).getAlbumImage());
        Picasso.with(mcontext).load(arrayList.get(position).getAlbumImage()).into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getAlbumTitle());
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
            textView=(TextView)itemView.findViewById(R.id.album_title);
            imageView=(ImageView)itemView.findViewById(R.id.album_image);
            textView2=(TextView)itemView.findViewById(R.id.album_artist_name);
        }
    }
}
