package com.example.layout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //线性布局
        //setContentView(R.layout.activity_liner);
        //表格布局
        //setContentView(R.layout.activity_table);
        //约束布局
        //setContentView(R.layout.activity_constract1);
        setContentView(R.layout.activity_constract2);
    }
}