package com.akitsme.musicmania.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akitsme.musicmania.Artist_data;
import com.akitsme.musicmania.R;
import com.akitsme.musicmania.helper.DownloadImageTask;

import java.util.ArrayList;

/**
 * Created by AKASH on 19-02-2017.
 */

public class Artist_adapter extends RecyclerView.Adapter<Artist_adapter.myHolder>{

    private ArrayList<Artist_data> arrayList=new ArrayList<>();
    public Artist_adapter(ArrayList<Artist_data> arrayList){
        this.arrayList=arrayList;
    }


    @Override
    public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artist,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(myHolder holder, int position) {
        DownloadImageTask runner=new DownloadImageTask(holder.imageView);
        runner.execute(arrayList.get(position).getmArtist_Image_link());
        holder.textView.setText(arrayList.get(position).getmArtist_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public myHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.artistImage);
            textView=(TextView)itemView.findViewById(R.id.artistName);
        }
    }
}
