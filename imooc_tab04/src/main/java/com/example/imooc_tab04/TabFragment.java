package com.example.imooc_tab04;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AI on 2018/3/25.
 */

/**
 * arguments:参数
 * suppress:镇压、压制
 */
@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {

    private int pos;

    @SuppressLint("ValidFragment")
    public TabFragment(int pos){
        this.pos=pos;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment,container,false);
        TextView tv=view.findViewById(R.id.id_tv);


        /**
         * 另外一种获得文字的写法
         * //获取Activity传递过来的参数
         Bundle mBundle = getArguments();
         String title = mBundle.getString("arg");
         */
        tv.setText(TabAdapter.TITLES[pos]);
        return view;
    }
}
