package com.akitsme.musicmania.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.akitsme.musicmania.Adapters.CustompagerAdapter;
import com.akitsme.musicmania.helper.DownloadImageTask;
import com.akitsme.musicmania.R;
import com.akitsme.musicmania.helper.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AKASH on 18-02-2017.
 */

public class Mainpage_fragment extends Fragment{
    @Nullable
    public Button mbutton;
    public String mResponse;
    public ImageView mImageView;
    public JsonObjectRequest request;
    public ViewPager pager;
    public CustompagerAdapter adapter;
    public String name;
    public JSONArray array;
    public RequestQueue mRequestQueue;
    public Activity mActivity;
    public View rootView;
    public static String url="http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=adele&api_key=e14851321e364fcb987a2028b13e4d7f&format=json";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_mainpage,container,false);
        mActivity=this.getActivity();
        mbutton=(Button)rootView.findViewById(R.id.button);
        mRequestQueue= VolleySingleton.getInstance().getmRequestQueue();
        request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //mResponse=response.toString();
                //Toast.makeText(getApplicationContext(),mResponse,Toast.LENGTH_LONG).show();
                try{

                    JSONObject read = response.getJSONObject("artist");
                    //name = read.getString("url");
                    array=read.getJSONArray("image");
                    JSONObject json = array.getJSONObject(2);
                    name=json.getString("#text");
                    mImageView=(ImageView)rootView.findViewById(R.id.image);
                    DownloadImageTask runner=new DownloadImageTask(mImageView);
                    runner.execute(name);
                 /*try {
                      mImageView = (ImageView)findViewById(R.id.image);
                      Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(name).getContent());
                      mImageView.setImageBitmap(bitmap);
                  } catch (MalformedURLException e) {
                     Toast.makeText(getApplicationContext(),
                             "Error: " + e.getMessage(),
                             Toast.LENGTH_LONG).show();
                     e.printStackTrace();
                  } catch (IOException e) {
                     Toast.makeText(getApplicationContext(),
                             "Error: " + e.getMessage(),
                             Toast.LENGTH_LONG).show();
                     e.printStackTrace();
                  }*/

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
                Toast.makeText(mActivity,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        });//end of onresponse method

        //click listener for button click
        mbutton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    mRequestQueue.add(request);
                }
        }
        );
        return rootView;
    }
}


