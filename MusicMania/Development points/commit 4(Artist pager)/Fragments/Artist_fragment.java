package com.akitsme.musicmania.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.akitsme.musicmania.Adapters.Artist_adapter;
import com.akitsme.musicmania.Adapters.CustompagerAdapter;
import com.akitsme.musicmania.Artist_data;
import com.akitsme.musicmania.R;
import com.akitsme.musicmania.helper.DownloadImageTask;
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

import static android.support.design.R.attr.layoutManager;

/**
 * Created by AKASH on 19-02-2017.
 */



public class Artist_fragment extends Fragment {

    public Button mbutton;
    public RecyclerView.LayoutManager layoutManager;
    public String mResponse;
    public JsonObjectRequest request;
    public String name;
    public JSONArray array;
    public JSONArray array2;
    public JSONObject json2;
    public RequestQueue mRequestQueue;
    public RecyclerView mrecyclerView_artist;
    public Activity mActivity;
    public int flag=0;
    public View rootView;
    public String image;
    public ArrayList<Artist_data> arrayList=new ArrayList<>();
    public static String url="http://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user=rj&api_key=e14851321e364fcb987a2028b13e4d7f&format=json";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_artist,container,false);
        mrecyclerView_artist = (RecyclerView) rootView.findViewById(R.id.recyclerview_artist);

        mActivity=this.getActivity();
        layoutManager=new GridLayoutManager(mActivity,2);
        mrecyclerView_artist.setLayoutManager(layoutManager);

        mRequestQueue= VolleySingleton.getInstance().getmRequestQueue();
        request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //mResponse=response.toString();
                //Toast.makeText(mActivity,mResponse,Toast.LENGTH_LONG).show();
                try{
                            Toast.makeText(mActivity,"entered into response",Toast.LENGTH_LONG).show();

                            JSONObject read = response.getJSONObject("topartists");
                            array=read.getJSONArray("artist");

                            for(int i=0;i<array.length();i++){
                                JSONObject json =array.getJSONObject(i);
                                name=json.getString("name");
                                array2=json.getJSONArray("image");
                                json2=array2.getJSONObject(2);
                                image=json2.getString("#text");
                                arrayList.add(new Artist_data(name,image));
                                if(flag==0){
                                    mrecyclerView_artist.setAdapter(new Artist_adapter(arrayList));
                                    flag=1;
                                }
                                mrecyclerView_artist.getAdapter().notifyDataSetChanged();
                            }
                }catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(mActivity,
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                //Toast.makeText(mActivity,name,Toast.LENGTH_LONG).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mActivity,"Artist no Connection",Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(request);
        return rootView;
    }
}
