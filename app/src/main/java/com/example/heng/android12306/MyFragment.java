package com.example.heng.android12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

public class MyFragment extends Fragment {

    private ListView myLv;//1、定义ListView
    private Button button;
    List<Map<String, Object>> mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    //此方法实现在Activity中的操作
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myLv = (ListView) getActivity().findViewById(R.id.myLv);
        button=(Button) getActivity().findViewById(R.id.button);
        String[] data = new String[]{"我的联系人", "我的账户", "我的密码"};
        myLv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });
        //响应条目点击事件
        myLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position) {
                    //跳转到我的联系人
                    case 0:
                        intent.setClass(getActivity(), MyContactActivity.class);
                        break;
                    //跳转到我的账户
                    case 1:
                        intent.setClass(getActivity(), MyAccountActivity.class);
                        break;
                    //跳转到我的密码
                    case 2:
                        intent.setClass(getActivity(), MyPasswordActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });

    }
}
