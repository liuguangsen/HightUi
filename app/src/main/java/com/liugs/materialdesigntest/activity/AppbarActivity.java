package com.liugs.materialdesigntest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;

import com.liugs.materialdesigntest.R;


public class AppbarActivity extends AppCompatActivity {
    private AppBarLayout appbar_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar);
        initView();
    }

    private void initView() {
        appbar_layout = findViewById(R.id.appbar_layout);
        //当AppbarLayout 的偏移发生改变的时候回调，也就是子View滑动
        appbar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

            }
        });

        //返回子View的可滑动距离
        appbar_layout.getTotalScrollRange();
        //移除偏移监听器
        appbar_layout.removeOnOffsetChangedListener(null);

    }
}
