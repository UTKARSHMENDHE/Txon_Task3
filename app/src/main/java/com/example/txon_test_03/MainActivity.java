package com.example.txon_test_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view)
    {
        Intent n=new Intent(getApplicationContext(),Activity2.class);
        startActivity(n);

    }
    public void exit(View view)
    {
       moveTaskToBack(true);
       android.os.Process.killProcess(android.os.Process.myPid());
       System.exit(1);

    }

}