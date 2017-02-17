package com.akitsme.musicmania;

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

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public Button mbutton;
    public String mResponse;
    public ImageView mImageView;
    public JsonObjectRequest request;
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
                mResponse=response.toString();
                Toast.makeText(getApplicationContext(),mResponse,Toast.LENGTH_LONG).show();
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
