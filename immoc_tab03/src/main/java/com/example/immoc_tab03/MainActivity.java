package com.example.immoc_tab03;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    /**
     * FragmentPagerAdapter的数据源是Fragment
     */
    private FragmentPagerAdapter mAdapter;

    private List<Fragment> mFragments;


    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mImgWeiXin;
    private ImageButton mImgFriend;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();

        /**
         * 默认设置第一个Fragment
         */
        setSelect(0);
    }

    /**
     * 设置点击事件
     */
    private void initEvent() {

        mTabWeiXin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_friend:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }
    }


    /**
     * 设置图片为亮色
     * 设置内容区域
     * @param i
     */
    private void setSelect(int i) {
        resetImg();

        switch (i){
            case 0:
                mImgWeiXin.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 1:
                mImgFriend.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 2:
                mImgAddress.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 3:
                mImgSetting.setImageResource(R.mipmap.ic_launcher_round);
                break;

            default:
                break;

        }
        /**
         * 设置正确的FragmentItem
         */
        mViewPager.setCurrentItem(i);

    }

    private void initView() {

        mViewPager=findViewById(R.id.id_viewpager);

        mTabWeiXin=findViewById(R.id.id_tab_weixin);
        mTabFriend=findViewById(R.id.id_tab_friend);
        mTabAddress=findViewById(R.id.id_tab_address);
        mTabSetting=findViewById(R.id.id_tab_setting);

        mImgWeiXin=findViewById(R.id.id_tab_weixin_image);
        mImgFriend=findViewById(R.id.id_tab_friend_image);
        mImgAddress=findViewById(R.id.id_tab_address_image);
        mImgSetting=findViewById(R.id.id_tab_setting_image);

        mFragments=new ArrayList<Fragment>();

        Fragment mTab01=new WeiXinFragment();
        Fragment mTab02=new FriendFragment();
        Fragment mTab03=new AddressFragment();
        Fragment mTab04=new SettingFragment();

        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);

        /**
         * 需要一个FragmentManager作为参数
         */
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()){
            /**
             * 返回指定位置的Fragment
             * @param position
             * @return
             */
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
            /**
             * 返回数据源的长度
             * @return
             */
            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int currentItem=mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem){
                    case 0:
                        mImgWeiXin.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 1:
                        mImgFriend.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 2:
                        mImgAddress.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 3:
                        mImgSetting.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    /**
     * 切换图片为暗色
     */
    private void resetImg() {
        mImgWeiXin.setImageResource(R.mipmap.ic_launcher);
        mImgFriend.setImageResource(R.mipmap.ic_launcher);
        mImgAddress.setImageResource(R.mipmap.ic_launcher);
        mImgSetting.setImageResource(R.mipmap.ic_launcher);
    }

}
