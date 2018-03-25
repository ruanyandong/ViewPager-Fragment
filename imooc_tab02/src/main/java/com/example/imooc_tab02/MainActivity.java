package com.example.imooc_tab02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mImgWeiXin;
    private ImageButton mImgFriend;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();

        /**
         * 设置显示第一个Fragment
         */
        setSelect(0);

    }

    private void initEvents() {
        mTabWeiXin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initView() {

        mTabWeiXin=findViewById(R.id.id_tab_weixin);
        mTabFriend=findViewById(R.id.id_tab_friend);
        mTabAddress=findViewById(R.id.id_tab_address);
        mTabSetting=findViewById(R.id.id_tab_setting);

        mImgWeiXin=findViewById(R.id.id_tab_weixin_image);
        mImgFriend=findViewById(R.id.id_tab_friend_image);
        mImgAddress=findViewById(R.id.id_tab_address_image);
        mImgSetting=findViewById(R.id.id_tab_setting_image);

    }

    /**
     * 把图片设置为亮色
     * 设置内容区域
     * @param i
     */
    private void setSelect(int i){

        FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction transaction=fragmentManager.beginTransaction();

        /**
         * 影藏Fragment
         */
        hideFragment(transaction);

        switch (i){
            case 0:
                if (mTab01==null){
                    mTab01=new WeiXinFragment();
                    transaction.add(R.id.id_content,mTab01);
                }else{
                    /**
                     *显示Fragment
                     */
                    transaction.show(mTab01);
                }
                mImgWeiXin.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 1:
                if (mTab02==null){
                    mTab02=new FriendFragment();
                    transaction.add(R.id.id_content,mTab02);
                }else{
                    /**
                     *显示Fragment
                     */
                    transaction.show(mTab02);
                }
                mImgFriend.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 2:
                if (mTab03==null){
                    mTab03=new AddressFragment();
                    transaction.add(R.id.id_content,mTab03);
                }else{
                    /**
                     *显示Fragment
                     */
                    transaction.show(mTab03);
                }
                mImgAddress.setImageResource(R.mipmap.ic_launcher_round);
                break;

            case 3:
                if (mTab04==null){
                    mTab04=new SettingFragment();
                    transaction.add(R.id.id_content,mTab04);
                }else{
                    /**
                     *显示Fragment
                     */
                    transaction.show(mTab04);
                }
                mImgSetting.setImageResource(R.mipmap.ic_launcher_round);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {


        if(mTab01!=null){
            transaction.hide(mTab01);
        }
        if(mTab02!=null){
            transaction.hide(mTab02);
        }
        if(mTab03!=null){
            transaction.hide(mTab03);
        }
        if(mTab04!=null){
            transaction.hide(mTab04);
        }

    }

    @Override
    public void onClick(View v) {

        resetImg();
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
     * 切换图片为暗色
     */
    private void resetImg() {
        mImgWeiXin.setImageResource(R.mipmap.ic_launcher);
        mImgFriend.setImageResource(R.mipmap.ic_launcher);
        mImgAddress.setImageResource(R.mipmap.ic_launcher);
        mImgSetting.setImageResource(R.mipmap.ic_launcher);
    }
}
