package com.example.administrator.back_zhan_demo;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Fragment> mList;
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fram, aFragment, AFragment.class.getSimpleName())
                .add(R.id.fram, bFragment, BFragment.class.getSimpleName())
                .add(R.id.fram, cFragment, CFragment.class.getSimpleName()).hide(bFragment)
                .hide(cFragment).commit();
                mList = new LinkedList<>();
                addBackStack(aFragment);
    }

    /**
     * 添加到回退栈
     *
     * @param fragment
     */
    private void addBackStack(Fragment fragment) {
        if (mList.contains(fragment)) {
            mList.remove(fragment);
            mList.add(fragment);
        } else {
            mList.add(fragment);
        }
    }

    @Override
    public void onBackPressed() {
        if (mList.size() > 1) {
//            移除里面的fragment
            mList.remove(mList.getLast());
            showFragment(mList.getLast());
        } else {
            finish();
        }
    }

    //    显示最后一个
    private void showFragment(Fragment last) {
        manager.beginTransaction().hide(aFragment).hide(bFragment).hide(cFragment)
                .show(last).commit();
    }

    public void click(View view) {
        manager.beginTransaction().hide(aFragment).hide(bFragment)
                .hide(cFragment).commit();
        switch (view.getId()) {
            case R.id.btn_a:
                manager.beginTransaction().show(aFragment).commit();
                addBackStack(aFragment);
                break;
            case R.id.btn_b:
                manager.beginTransaction().show(bFragment).commit();
                addBackStack(bFragment);
                break;
            case R.id.btn_c:
                manager.beginTransaction().show(cFragment).commit();
                addBackStack(cFragment);
                break;
        }
    }
}
