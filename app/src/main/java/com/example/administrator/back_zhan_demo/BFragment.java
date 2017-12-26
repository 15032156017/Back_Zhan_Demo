package com.example.administrator.back_zhan_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * date: on 2017/12/17
 * time: 19:57
 * Package_Name: com.example.administrator.back_zhan_demo
 * Author: MrL.Xin
 * desc:
 */

public class BFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, null);
        return view;
    }
}
