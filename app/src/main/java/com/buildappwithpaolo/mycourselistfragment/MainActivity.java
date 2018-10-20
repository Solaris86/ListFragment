package com.buildappwithpaolo.mycourselistfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.myContainer);

        if (fragment == null) {
            fragment = new MyFragment();
            fm.beginTransaction()
                    .add(R.id.myContainer, fragment)
                    .commit();
        }
    }
}