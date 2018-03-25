package com.example.ai.viewpagertabweixin;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;

    private PagerAdapter mAdapter;

    private List<View> mViews=new ArrayList<>();



    private LinearLayout mTabWeiXin;

    private  LinearLayout mTabFriend;

    private LinearLayout mTabAddress;

    private LinearLayout mTabSetting;


    private ImageButton mWeiXinImage;

    private ImageButton mFriendImage;

    private ImageButton mAddressImage;

    private ImageButton mSettingImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       initView();

       initEvents();

    }

    private void initEvents(){
        mTabWeiXin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                /**
                 * 得到ViewPager里对应View的位置
                 */
                int currentItem=mViewPager.getCurrentItem();

                resetImg();
                switch (currentItem){
                    case 0:
                        mWeiXinImage.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 1:
                        mFriendImage.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 2:
                        mAddressImage.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 3:
                        mSettingImage.setImageResource(R.mipmap.ic_launcher_round);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView(){
        mViewPager=(ViewPager)findViewById(R.id.id_viewPager);

        mTabWeiXin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFriend=(LinearLayout)findViewById(R.id.id_tab_friend);
        mTabAddress=(LinearLayout)findViewById(R.id.id_tab_address);
        mTabSetting=(LinearLayout)findViewById(R.id.id_tab_setting);

        mWeiXinImage=(ImageButton)findViewById(R.id.id_tab_weixin_image);
        mFriendImage=(ImageButton)findViewById(R.id.id_tab_friend_image);
        mAddressImage=(ImageButton)findViewById(R.id.id_tab_address_image);
        mSettingImage=(ImageButton)findViewById(R.id.id_tab_setting_image);

        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View tab01=layoutInflater.inflate(R.layout.tab01,null);
        View tab02=layoutInflater.inflate(R.layout.tab02,null);
        View tab03=layoutInflater.inflate(R.layout.tab03,null);
        View tab04=layoutInflater.inflate(R.layout.tab04,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mAdapter=new PagerAdapter() {
            /**
             * 为给定的位置创建相应的View。
             * 创建View之后,需要在该方法中自行添加到container中。
             * @param container ViewPager本身
             * @param position 给定的位置
             * @return 提交给ViewPager进行保存的实例对象
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }
            /**
             * 为给定的位置移除相应的View
             * @param container ViewPager本身
             * @param position 给定的位置 * @param object 在instantiateItem中提交给ViewPager进行保存的实例对象 */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }
            /**
             * 包含View的个数
             * @return
             */
            @Override
            public int getCount() {
                return mViews.size();
            }
            /**
             *确认View与实例对象是否相互对应。
             *ViewPager内部用于获取View对应的ItemInfo。
             *@param view ViewPager显示的View内容
             *@param object 在instantiateItem中提交给ViewPager进行保存的实例对象
             * @return 是否相互对应
             */
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        };
        mViewPager.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v) {

        resetImg();
        switch (v.getId()){

            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeiXinImage.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case R.id.id_tab_friend:
                mViewPager.setCurrentItem(1);
                mFriendImage.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImage.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case R.id.id_tab_setting:
                mViewPager.setCurrentItem(3);
                mSettingImage.setImageResource(R.mipmap.ic_launcher_round);
                break;
            default:
                break;
        }

    }

    /**
     * 将所有的图片切换为暗色
     */
    private void resetImg(){
        mWeiXinImage.setImageResource(R.mipmap.ic_launcher);
        mFriendImage.setImageResource(R.mipmap.ic_launcher);
        mAddressImage.setImageResource(R.mipmap.ic_launcher);
        mSettingImage.setImageResource(R.mipmap.ic_launcher);
    }
}
