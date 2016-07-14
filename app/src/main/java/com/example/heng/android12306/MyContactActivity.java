package com.example.heng.android12306;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyContactActivity extends Activity {
    private ListView lvMyconact;
    private Button button3;
    List<Map<String, Object>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contact);
        lvMyconact = (ListView) this.findViewById(R.id.lvMyContact);
        button3=(Button) this.findViewById(R.id.button3);
        mData = getData();
        SimpleAdapter adpter = new SimpleAdapter(this, mData, R.layout.my_contact_item, new String[]{"name", "idCard", "tel", "icon"}, new int[]{R.id.tvNameContact, R.id.tvIdCardContact, R.id.tvTelcontact, R.id.imgContact});
        lvMyconact.setAdapter(adpter);

        lvMyconact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(MyContactActivity.this,"sfsfsdf"+position,Toast.LENGTH_LONG).show();
                Intent intet=new Intent(MyContactActivity.this,MyContactEditActivity.class);
                intet.putExtra("row", (Serializable) mData.get(position));//取得数据类是Map
                startActivity(intet);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyContactActivity.this,
                        MyContactNewActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_contact,menu);
        return true;
    }
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_contact:
                Intent intent=new Intent(MyContactActivity.this,MyContactNewActivity.class);
                startActivity(intent);
                break;
            case R.id.reback:
                Toast.makeText(MyContactActivity.this,"退出",Toast.LENGTH_LONG).show();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }


    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> row = new HashMap<String, Object>();
        row.put("name", "小明(学生)");
        row.put("idCard", "学生证：1234567894546212");
        row.put("tel", "电话：98745612310");
        row.put("icon",R.drawable.forward_25);
        data.add(row);

        row = new HashMap<String, Object>();
        row.put("name", "李四(成人)");
        row.put("idCard", "身份证：3651234654798897645");
        row.put("tel", "电话：9444552310");
        row.put("icon",R.drawable.forward_25);
        data.add(row);
        return data;
    }
}
