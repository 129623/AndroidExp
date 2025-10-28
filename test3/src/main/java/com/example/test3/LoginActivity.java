package com.example.test3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 不再设置 Activity 的内容视图，使其保持透明
        // setContentView(R.layout.activity_login);

        // 显示登录对话框
        showLoginDialog();
    }

    private void showLoginDialog() {
        // 1. 创建 AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. 加载自定义布局
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);

        // 3. 将自定义布局设置给对话框
        builder.setView(dialogView);

        // 获取布局中的控件
        final EditText username = dialogView.findViewById(R.id.username);
        final EditText password = dialogView.findViewById(R.id.password);

        // 4. 设置对话框的标题和按钮
        builder.setTitle("Login")
                .setPositiveButton("Sign In", (dialog, id) -> {
                    // 处理登录逻辑
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    Toast.makeText(this, "Username: " + user + ", Password: " + pass, Toast.LENGTH_SHORT).show();
                    // 登录成功后销毁当前 Activity
                    finish();
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    // 用户取消对话框，也销毁当前 Activity
                    dialog.cancel();
                });

        // 5. 创建并显示对话框
        AlertDialog dialog = builder.create();

        // 6. 设置当对话框被取消（例如按返回键）时的监听器
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // 销毁 LoginActivity，返回主页面
                finish();
            }
        });

        dialog.show();
    }
}
