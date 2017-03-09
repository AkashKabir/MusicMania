package com.akitsme.retrofit;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akitsme.retrofit.Fragments.Artist_fragment;
import com.akitsme.retrofit.Fragments.FragementA;
import com.akitsme.retrofit.Fragments.FragmentB;

public class MainActivity extends AppCompatActivity {

    android.support.design.widget.CoordinatorLayout coordinatorLayout;
    Button buttona;
    FragmentTransaction ft;
    Button buttonb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttona=(Button)findViewById(R.id.A);
        buttonb=(Button)findViewById(R.id.B);
        ft =getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main, new FragementA());
        ft.commit();
        coordinatorLayout=(CoordinatorLayout) findViewById(R.id.mainsnack);
      buttona.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ft =getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main,new Artist_fragment());
                ft.commit();
            }
        });

        buttonb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ft =getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main,new FragmentB());
                ft.commit();
                Snackbar.make(coordinatorLayout,"Hello its me",Snackbar.LENGTH_SHORT).show();

            }
        });
    }
}
