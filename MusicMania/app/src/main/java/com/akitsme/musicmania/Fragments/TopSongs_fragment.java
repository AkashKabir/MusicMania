package com.akitsme.musicmania.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.akitsme.musicmania.Adapters.TopSongs_Adapter;
import com.akitsme.musicmania.R;
import com.akitsme.musicmania.Model.TopSongs_data;
import com.akitsme.musicmania.helper.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by AKASH on 20-02-2017.
 */

public class TopSongs_fragment extends Fragment{

    public RecyclerView.LayoutManager layoutManager;
    public JsonObjectRequest request;
    public String name;
    public JSONArray array;
    public JSONArray array2;
    public JSONObject json2;
    public JSONObject json3;
    public RequestQueue mRequestQueue;
    public RecyclerView mrecyclerView_topsongs;
    public Activity mActivity;
    public int flag=0;
    public View rootView;
    public String image;
    public ArrayList<TopSongs_data> arrayList=new ArrayList<>();
    public static String url="http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=e14851321e364fcb987a2028b13e4d7f&format=json";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_topsongs,container,false);
        mrecyclerView_topsongs = (RecyclerView) rootView.findViewById(R.id.recyclerview_topsongs);
        mActivity=this.getActivity();

        layoutManager=new LinearLayoutManager(mActivity);
        mrecyclerView_topsongs.setLayoutManager(layoutManager);

        mRequestQueue= VolleySingleton.getInstance().getmRequestQueue();
        request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //mResponse=response.toString();
                //Toast.makeText(mActivity,mResponse,Toast.LENGTH_LONG).show();
                try{
                    Toast.makeText(mActivity,"Songs",Toast.LENGTH_SHORT).show();

                    JSONObject read = response.getJSONObject("tracks");
                    array=read.getJSONArray("track");

                    for(int i=0;i<array.length();i++){
                        JSONObject json =array.getJSONObject(i);
                        name=json.getString("name");
                        json3=json.getJSONObject("artist");
                        String artist_name = json3.getString("name");
                        array2=json.getJSONArray("image");
                        json2=array2.getJSONObject(2);
                        image=json2.getString("#text");
                        arrayList.add(new TopSongs_data(name,image,artist_name));
                        if(flag==0){
                            mrecyclerView_topsongs.setAdapter(new TopSongs_Adapter(mActivity,arrayList));
                            flag=1;
                        }
                        mrecyclerView_topsongs.getAdapter().notifyDataSetChanged();
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(mActivity,
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mActivity,"Song no Connection",Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(request);
        return rootView;
    }
}
