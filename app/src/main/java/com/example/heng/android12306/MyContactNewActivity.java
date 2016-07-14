package com.example.heng.android12306;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyContactNewActivity extends Activity {

    private ListView listView;
    List<Map<String, Object>> mData;
    private Button bntMyContactSave;
    private TextView textNew2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contact_new);
        listView = (ListView) this.findViewById(R.id.listView);
        bntMyContactSave = (Button) this.findViewById(R.id.bntMyContactSave);
        textNew2= (TextView) this.findViewById(R.id.textNew2);
        mData = getData();

        SimpleAdapter adapter = new SimpleAdapter(this, mData, R.layout.my_contact_new_item, new String[]{"a1", "a2"}, new int[]{R.id.textNew1, R.id.textNew2});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                switch (position) {
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactNewActivity.this);
                        builder.setTitle("请输入姓名");//设置标题
                        builder.setIcon(android.R.drawable.btn_star);//设置图标
                        final EditText et_userName = new EditText(MyContactNewActivity.this);//定义一个文本输入框
                        builder.setView(et_userName);//将输入框放置在对话框中
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                textNew2 = (TextView)view.findViewById(R.id.textNew2);
                                textNew2.setText(et_userName.getText().toString().trim());

                                // startActivityForResult();
                                // lvMyContactEdit.
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        break;
                    case 1:
                        //创建一个Builder对象
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MyContactNewActivity.this);
                        builder1.setTitle("请选择证件类型");//设置标题
                        builder1.setIcon(android.R.drawable.btn_star);//设置图标
                        final String[] items = new String[]{"身份证", "港澳通行证", "护照"};
                        final boolean[] bSelect = new boolean[items.length];//用来存放选择项
        /*
        * 第一个参数为单选框数据集合
        * 第二参数为默认勾选的项
        * 第三个参数为监听器
        * */
                        builder1.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {//响应单选条目
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ///tv_show.setText(items[which]);
                                textNew2 = (TextView) view.findViewById(R.id.textNew2);
                                textNew2.setText(items[which]);
                            }
                        });

                        builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder1.show();
                        break;
                    case 2:
                        //创建一个Builder对象
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MyContactNewActivity.this);
                        builder2.setTitle("请输入证件号码");//设置标题
                        builder2.setIcon(android.R.drawable.btn_star);//设置图标
                        //final EditText et_userName1 = new EditText(this);//定义一个文本输入框
                        final EditText et_userName2 = new EditText(MyContactNewActivity.this);//定义一个文本输入框
                        builder2.setView(et_userName2);//将输入框放置在对话框中
                        builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                // tv_show.setText(et_userName2.getText().toString().trim());
                                textNew2 = (TextView) view.findViewById(R.id.textNew2);
                                textNew2.setText(et_userName2.getText().toString().trim());
                            }
                        });
                        builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder2.show();
                        break;
                    case 3:
                        //创建一个Builder对象
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(MyContactNewActivity.this);
                        builder3.setTitle("请选择乘客类型");//设置标题
                        builder3.setIcon(android.R.drawable.btn_star);//设置图标
                        final String[] items3 = new String[]{"成人", "学生", "军人"};
                        final boolean[] bSelect3 = new boolean[items3.length];//用来存放选择项
        /*
        * 第一个参数为单选框数据集合
        * 第二参数为默认勾选的项
        * 第三个参数为监听器
        * */
                        builder3.setSingleChoiceItems(items3, 0, new DialogInterface.OnClickListener() {//响应单选条目
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //tv_show.setText(items3[which]);
                                textNew2 = (TextView) view.findViewById(R.id.textNew2);
                                textNew2.setText(items3[which]);

                            }
                        });

                        builder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder3.show();
                        break;
                    case 4:
                        //创建一个Builder对象
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(MyContactNewActivity.this);
                        builder4.setTitle("请输入电话号码");//设置标题
                        builder4.setIcon(android.R.drawable.btn_star);//设置图标
                        // final EditText et_userName = new EditText(this);//定义一个文本输入框
                        final EditText et_userName4 = new EditText(MyContactNewActivity.this);//定义一个文本输入框
                        builder4.setView(et_userName4);//将输入框放置在对话框中
                        builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //tv_show.setText(et_userName4.getText().toString().trim());
                                textNew2 = (TextView) view.findViewById(R.id.textNew2);
                                textNew2.setText(et_userName4.getText().toString().trim());
                            }
                        });
                        builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder4.show();
                        break;
                }
            }
        });
        bntMyContactSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyContactNewActivity.this, "添加成功" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        //row姓名
        Map<String, Object> row1 = new HashMap<String, Object>();
        row1.put("a1", "姓名");
        row1.put("a2","");
        data.add(row1);
//row2证件类型

        Map<String, Object> row2 = new HashMap<String, Object>();
        row2.put("a1", "证件类型");
        row2.put("a2","身份证");
        data.add(row2);

        Map<String, Object> row3 = new HashMap<String, Object>();
        row3.put("a1", "证件号码");
        row3.put("a2", "");
        data.add(row3);

        Map<String, Object> row4 = new HashMap<String, Object>();
        row4.put("a1", "乘客类型");
        row4.put("a2","学生");
        data.add(row4);

        Map<String, Object> row5 = new HashMap<String, Object>();
        row5.put("a1", "电话号码");
        row5.put("a2", "");
        data.add(row5);
        return data;

    }
}
