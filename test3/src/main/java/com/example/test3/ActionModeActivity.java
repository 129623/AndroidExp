package com.example.test3;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActionModeActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        listView = findViewById(R.id.list_view);

        // 1. 准备数据源和适配器
        data = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            data.add("Item " + i);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, data);
        listView.setAdapter(adapter);

        // 2. 设置 ListView 为多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        // 3. 设置多选模式的监听器
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            // 当选择的项发生变化时调用
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // 更新标题以显示选中了多少项
                int checkedCount = listView.getCheckedItemCount();
                mode.setTitle(checkedCount + " selected");
            }

            // 当 ActionMode 第一次创建时调用
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // 加载上下文菜单
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.contextual_menu, menu);
                return true;
            }

            // 每次 ActionMode 显示时调用（在 onCreateActionMode 之后）
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false; // 返回 false 表示无需更新菜单
            }

            // 当上下文菜单中的项被点击时调用
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.action_delete) {
                    // 执行删除逻辑
                    deleteSelectedItems();
                    // 结束 ActionMode
                    mode.finish();
                    return true;
                }
                return false;
            }

            // 当退出 ActionMode 时调用
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // 无需特殊处理
            }
        });
    }

    private void deleteSelectedItems() {
        // 从后往前遍历，避免因删除导致位置错乱
        for (int i = listView.getCount() - 1; i >= 0; i--) {
            if (listView.isItemChecked(i)) {
                data.remove(i);
            }
        }
        // 通知适配器数据已改变
        adapter.notifyDataSetChanged();
    }
}
