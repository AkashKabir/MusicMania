package com.akitsme.musicmania;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public Button mbutton;
    public String mResponse;
    public ImageView mImageView;
    public JsonObjectRequest request;
    public String name;
    public JSONArray array;
    public RequestQueue mRequestQueue;
    public static String url="http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=adele&api_key=e14851321e364fcb987a2028b13e4d7f&format=json";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton=(Button)findViewById(R.id.button);
        mRequestQueue=VolleySingleton.getInstance().getmRequestQueue();
        request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // mResponse=response.toString();
                //Toast.makeText(getApplicationContext(),mResponse,Toast.LENGTH_LONG).show();
              try{
                  JSONObject read = response.getJSONObject("artist");
                  //name = read.getString("url");
                  array=read.getJSONArray("image");
                  JSONObject json = array.getJSONObject(2);
                  name=json.getString("#text");
                  mImageView=(ImageView)findViewById(R.id.image);
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
                  Toast.makeText(getApplicationContext(),
                          "Error: " + e.getMessage(),
                          Toast.LENGTH_LONG).show();
              }
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        });
        mbutton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    mRequestQueue.add(request);
                }
        }
        );
    }

}

