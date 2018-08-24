package com.weidu.testlitepal;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button insert = findViewById(R.id.insert);
        Button delete = findViewById(R.id.delete);
        Button update = findViewById(R.id.update);
        Button check = findViewById(R.id.check);
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        check.setOnClickListener(this);

    }

    private int id = 0;
    public void insert(){
        id++;
        Person person = new Person();
        person.setId(id);
        person.setName("姚明");
        person.setSex("男");
        person.setAge(18);
        person.save();
    }
    public void delete(){
        LitePal.delete(Person.class,1);
    }
    public void update(){
        ContentValues values = new ContentValues();
        values.put("name", "这是修改操作");
        Log.i("test","测试提交");
        LitePal.updateAll(Person.class, values);
    }
    public void check(){
        List<Person> all = LitePal.findAll(Person.class);
        for (int i = 0;i<all.size();i++){
            Log.i("test_LitePal","数据库数为：id = " + all.get(i).getId() + ",name = " + all.get(i).getName() + ",sex = " + all.get(i).getSex() + ",age = " + all.get(i).getAge());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.insert:
                insert();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.update:
                update();
                break;
            case R.id.check:
                check();
                break;
        }
    }
}
