package com.example.heng.android12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class MyContactEditActivity extends AppCompatActivity {
    private ListView lvMyContactEdit;
    private Button bntMyContactSave;
    private TextView tvMyContactEditValue;
    List<Map<String, Object>> mData;
    Map<String, Object> contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contact_edit);
        lvMyContactEdit = (ListView) this.findViewById(R.id.lvMyContactEdit);
        bntMyContactSave = (Button) this.findViewById(R.id.bntMyContactSave);
        tvMyContactEditValue = (TextView)findViewById(R.id.tvMyContactEditValue);
        //接收数据
        Intent intent = getIntent();
        contact = (Map<String, Object>) intent.getSerializableExtra("row");
        mData = getData();
        SimpleAdapter adpter = new SimpleAdapter(this, mData, R.layout.my_contact_edit_item, new String[]{"key1", "key2", "key3"}, new int[]{R.id.tvMyContactEditKey, R.id.tvMyContactEditValue, R.id.imEditContact});
        lvMyContactEdit.setAdapter(adpter);

        lvMyContactEdit.setOnItemClickListener(new AdapterView.OnItemClickListener() {//响应条目事件
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                //Toast.makeText(MyContactEditActivity.this, "***" + position, Toast.LENGTH_LONG).show();
                switch (position) {
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
                        builder.setTitle("请输入姓名");//设置标题
                        builder.setIcon(android.R.drawable.btn_star);//设置图标
                        final EditText et_userName = new EditText(MyContactEditActivity.this);//定义一个文本输入框
                        builder.setView(et_userName);//将输入框放置在对话框中
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                tvMyContactEditValue = (TextView) view.findViewById(R.id.tvMyContactEditValue);
                                tvMyContactEditValue.setText(et_userName.getText().toString().trim());

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
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MyContactEditActivity.this);
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
                                tvMyContactEditValue = (TextView) view.findViewById(R.id.tvMyContactEditValue);
                                tvMyContactEditValue.setText(items[which]);
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
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MyContactEditActivity.this);
                        builder2.setTitle("请输入证件号码");//设置标题
                        builder2.setIcon(android.R.drawable.btn_star);//设置图标
                        //final EditText et_userName1 = new EditText(this);//定义一个文本输入框
                        final EditText et_userName2 = new EditText(MyContactEditActivity.this);//定义一个文本输入框
                        builder2.setView(et_userName2);//将输入框放置在对话框中
                        builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                               // tv_show.setText(et_userName2.getText().toString().trim());
                                tvMyContactEditValue = (TextView) view.findViewById(R.id.tvMyContactEditValue);
                                tvMyContactEditValue.setText(et_userName2.getText().toString().trim());
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
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(MyContactEditActivity.this);
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
                                tvMyContactEditValue = (TextView) view.findViewById(R.id.tvMyContactEditValue);
                                tvMyContactEditValue.setText(items3[which]);

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
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(MyContactEditActivity.this);
                        builder4.setTitle("请输入电话号码");//设置标题
                        builder4.setIcon(android.R.drawable.btn_star);//设置图标
                       // final EditText et_userName = new EditText(this);//定义一个文本输入框
                        final EditText et_userName4 = new EditText(MyContactEditActivity.this);//定义一个文本输入框
                        builder4.setView(et_userName4);//将输入框放置在对话框中
                        builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //tv_show.setText(et_userName4.getText().toString().trim());
                                tvMyContactEditValue = (TextView) view.findViewById(R.id.tvMyContactEditValue);
                                tvMyContactEditValue.setText(et_userName4.getText().toString().trim());
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
                Toast.makeText(MyContactEditActivity.this, "保存成功" , Toast.LENGTH_LONG).show();
            }
        });

    }
//    public void dialog0() {//带输入框的对话框
//        //创建一个Builder对象
//        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
//        builder.setTitle("请输入姓名");//设置标题
//        builder.setIcon(android.R.drawable.btn_star);//设置图标
//        final EditText et_userName = new EditText(this);//定义一个文本输入框
//        builder.setView(et_userName);//将输入框放置在对话框中
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                //tv_show = (TextView) view.findViewById(R.id.tv_show);
//                tv_show.setText(et_userName.getText().toString().trim());
//               // startActivityForResult();
//               // lvMyContactEdit.
//            }
//        });
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.show();
//    }
/*    public void dialog1() {//实现单选且没有确定键的对话框
        //创建一个Builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
        builder.setTitle("请选择证件类型");//设置标题
        builder.setIcon(android.R.drawable.btn_star);//设置图标
        final String[] items = new String[]{"身份证", "港澳通行证", "护照"};
        final boolean[] bSelect = new boolean[items.length];//用来存放选择项
        *//*
        * 第一个参数为单选框数据集合
        * 第二参数为默认勾选的项
        * 第三个参数为监听器
        * *//*
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {//响应单选条目
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tv_show.setText(items[which]);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }*/
   /* public void dialog2() {//带输入框的对话框
        //创建一个Builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
        builder.setTitle("请输入证件号码");//设置标题
        builder.setIcon(android.R.drawable.btn_star);//设置图标
        final EditText et_userName = new EditText(this);//定义一个文本输入框
        builder.setView(et_userName);//将输入框放置在对话框中
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tv_show.setText(et_userName.getText().toString().trim());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }*/
   /* public void dialog3() {//实现单选且没有确定键的对话框
        //创建一个Builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
        builder.setTitle("请选择乘客类型");//设置标题
        builder.setIcon(android.R.drawable.btn_star);//设置图标
        final String[] items = new String[]{"成人", "学生", "军人"};
        final boolean[] bSelect = new boolean[items.length];//用来存放选择项
        *//*
        * 第一个参数为单选框数据集合
        * 第二参数为默认勾选的项
        * 第三个参数为监听器
        * *//*
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {//响应单选条目
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tv_show.setText(items[which]);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }*/
   /* public void dialog4() {//带输入框的对话框
        //创建一个Builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MyContactEditActivity.this);
        builder.setTitle("请输入电话号码");//设置标题
        builder.setIcon(android.R.drawable.btn_star);//设置图标
        final EditText et_userName = new EditText(this);//定义一个文本输入框
        builder.setView(et_userName);//将输入框放置在对话框中
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tv_show.setText(et_userName.getText().toString().trim());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
*/
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        //row姓名
        Map<String, Object> row1 = new HashMap<String, Object>();
        String name = (String) contact.get("name");
        row1.put("key1", "姓名");
        row1.put("key2", name.split("\\(")[0]);
        //row1.put("key2", "小明");
        row1.put("key3", R.drawable.forward_25);
        data.add(row1);
//row2证件类型

        Map<String, Object> row2 = new HashMap<String, Object>();
        String idCard = (String) contact.get("idCard");
        row2.put("key1", "证件类型");
        row2.put("key2", idCard.split("：")[0]);
        row2.put("key3", R.drawable.forward_25);
        data.add(row2);

        Map<String, Object> row3 = new HashMap<String, Object>();
        row3.put("key1", "证件号码");
        row3.put("key2", idCard.split("：")[1]);
        row3.put("key3", R.drawable.forward_25);
        data.add(row3);

        Map<String, Object> row4 = new HashMap<String, Object>();
        row4.put("key1", "乘客类型");
        row4.put("key2", name.split("\\(")[1].split("\\)")[0]);
        row4.put("key3", R.drawable.forward_25);
        data.add(row4);

        Map<String, Object> row5 = new HashMap<String, Object>();
        String tel = (String) contact.get("tel");
        row5.put("key1", "电话号码");
        row5.put("key2", tel.split("：")[1]);
        row5.put("key3", R.drawable.forward_25);
        data.add(row5);
        return data;

    }
}
