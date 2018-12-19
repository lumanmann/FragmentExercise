package com.lumanman.fragmentexercise;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RvFragment rvFragment = new RvFragment();
        rvFragment.setContext(this);

        TextViewFragment textViewFragment = new TextViewFragment();

        rvFragment.setRvCallBack(new RvFragment.RvCallBack() {
            @Override
            public void getClickedText(String text) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                TextViewFragment textViewFragment = new TextViewFragment();
                textViewFragment.setString(text);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout2, textViewFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, rvFragment);
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2, textViewFragment);
        textViewFragment.setString("start!");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
