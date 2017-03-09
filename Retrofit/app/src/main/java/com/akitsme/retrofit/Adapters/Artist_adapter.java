package com.akitsme.retrofit.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.akitsme.retrofit.R;
import com.akitsme.retrofit.model.Artist_data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AKASH on 19-02-2017.
 */

public class Artist_adapter extends RecyclerView.Adapter<Artist_adapter.myHolder>{
    public Context mcontext;
    private ArrayList<Artist_data> arrayList=new ArrayList<>();
    public Artist_adapter(Context context, ArrayList<Artist_data> arrayList){
        this.arrayList=arrayList;
        this.mcontext=context;
    }


    @Override
    public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artist,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(myHolder holder, int position) {
        Picasso.with(mcontext).load(arrayList.get(position).getmArtist_Image_link()).into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getmArtist_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public myHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.artistImage);
            textView=(TextView)itemView.findViewById(R.id.artistName);
        }
    }
}
