package com.akitsme.musicmania;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.akitsme.musicmania.Adapters.CustompagerAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.astuetz.PagerSlidingTabStrip;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    public Button mbutton;
    public String mResponse;
    public ImageView mImageView;
    public JsonObjectRequest request;
    public ViewPager pager;
    public CustompagerAdapter adapter;
    public String name;
    public JSONArray array;
    public RequestQueue mRequestQueue;
    public static String url="http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=adele&api_key=e14851321e364fcb987a2028b13e4d7f&format=json";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);

        mbutton=(Button)findViewById(R.id.button);
        pager=(ViewPager)findViewById(R.id.pager);

        pager.setAdapter(new CustompagerAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(pager);


       /*mRequestQueue=VolleySingleton.getInstance().getmRequestQueue();
        request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mResponse=response.toString();
                Toast.makeText(getApplicationContext(),mResponse,Toast.LENGTH_LONG).show();
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
                  }

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
        }); */

        //click listener for button click
       /* mbutton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    mRequestQueue.add(request);
                }
        }
        ); //end of click listener*/
       // mRequestQueue.add(request);
    }

}

