package com.liugs.materialdesigntest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.liugs.materialdesigntest.R;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        initToolBar();
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        //设置溢出菜单
        toolbar.inflateMenu(R.menu.layout_toolbar_menu);
        //设置navigationIcon
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.more));
        //给navigationIcon注册点击时事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this,"点击我啦",Toast.LENGTH_LONG).show();
            }
        });
        //给溢出菜单注册点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.github:
                        Toast.makeText(ToolBarActivity.this,"点击github啦",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about:
                        Toast.makeText(ToolBarActivity.this,"点击about啦",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.more:
                        Toast.makeText(ToolBarActivity.this,"点击more啦",Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
    }


}
