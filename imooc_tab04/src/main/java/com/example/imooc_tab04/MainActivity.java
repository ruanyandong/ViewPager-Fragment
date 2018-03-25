package com.example.imooc_tab04;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.viewpagerindicator.TabPageIndicator;

/**
 * 写完这些后，还要自定义TabIndicator的样式，在style里定义，最后在配置文件里应用
 */
public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;

    private TabPageIndicator mTabPageIndicator;

    private TabAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mViewPager=findViewById(R.id.id_viewpager);

        mTabPageIndicator=findViewById(R.id.id_indicator);

        mAdapter=new TabAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);

        /**
         * 初始化位置是第一个view
         */
        mTabPageIndicator.setViewPager(mViewPager,0);
    }
}
