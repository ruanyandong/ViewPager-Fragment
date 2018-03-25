package com.example.imooc_tab04;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by AI on 2018/3/25.
 */

public class TabAdapter extends FragmentPagerAdapter {

    public static String[] TITLES=new String[]{
            "课程","问答","求课","学习","计划"
    };


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 另外一种写法
     *@Override public Fragment getItem(int position) {
    //新建一个Fragment来展示ViewPager item的内容，并传递参数
    Fragment fragment = new ItemFragment();
    Bundle args = new Bundle();
    args.putString("arg", TITLE[position]);
    fragment.setArguments(args);
    return fragment;
    }
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        TabFragment fragment=new TabFragment(position);

        return fragment;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    /**
     * 设置Viewpager的指示器Indicator的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        /**
         * return TITLES[position%TITLES.length]也可以
         */
        return TITLES[position];
    }

}
