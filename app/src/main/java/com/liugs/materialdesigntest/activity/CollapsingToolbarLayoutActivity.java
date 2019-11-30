package com.liugs.materialdesigntest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.liugs.materialdesigntest.R;
import com.liugs.materialdesigntest.StatusBarUtils;

/**
 * 折叠控件
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        initView();
    }

    private void initView(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_layout_toolbar);
        //设置沉浸式状态栏
        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);
        //设置标题颜色
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        //加载动作菜单
        toolbar.inflateMenu(R.menu.layout_toolbar_menu);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        collapsingToolbarLayout.setTitle("");
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        //设置纱布
        collapsingToolbarLayout.setContentScrim(getResources().getDrawable(R.mipmap.meizhi));
        //监听appBarLayout的偏移
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    collapsingToolbarLayout.setTitle("AppbarLayout");
                }else{
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
    }
}
