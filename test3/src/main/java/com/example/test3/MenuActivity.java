package com.example.test3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        // 1. 找到 Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        // 2. 将 Toolbar 设置为 SupportActionBar
        setSupportActionBar(toolbar);
        // 3. 设置标题
        setTitle("menuTest");

        testText = findViewById(R.id.test_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.font_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.font_small) {
            testText.setTextSize(10);
        } else if (itemId == R.id.font_medium) {
            testText.setTextSize(16);
        } else if (itemId == R.id.font_large) {
            testText.setTextSize(20);
        } else if (itemId == R.id.plain_item) {
            Toast.makeText(this, "你点击了普通菜单项", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.color_red) {
            testText.setTextColor(Color.RED);
        } else if (itemId == R.id.color_black) {
            testText.setTextColor(Color.BLACK);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
