package com.yeohe.testdbflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserModel people=new UserModel();
        ArrayList<UserModel> list=new ArrayList<UserModel>();
        for(int i=0;i<1000;i++){
            people.name="dfa"+i;
            people.age=i+1;
            people.sex=0;
            list.add(people);
        }

        //实时保存，马上保存
        new SaveModelTransaction<>(ProcessModelInfo.withModels(list)).onExecute();
//异步保存，使用异步，如果立刻查询可能无法查到结果
//TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(peoples)));

        //people.update();//更新对象
        //people.delete();//删除对象
        //people.insert();//插入对象

        select();

        List<UserModel> list1=new ArrayList<UserModel>();
        updata(list1);

    }

    //查寻
    private void select(){
        //返回单个查询结果
        UserModel user = new Select().from(UserModel.class).querySingle();
        Toast.makeText(this,user.name,Toast.LENGTH_LONG).show();

        //返回所有查询结果
        List<UserModel> peoples = new Select().from(UserModel.class).queryList();

        //查询gender = 1的所有People
        List<UserModel> peoples2 = new Select().from(UserModel.class).where(
                Condition.column(UserModel$Table.NAME).is("张三"),
                Condition.column(UserModel$Table.SEX).is(1)).queryList();
    }

    //删除
    private void delete(){

    }

    //改
    private void updata(List<UserModel> list) {
        list = new Select().from(UserModel.class).queryList();
        if (list != null && list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                UserModel updataModel = list.get(j);
                updataModel.name = "卡卡罗特";
                updataModel.update();
                list.set(j, updataModel);
            }
        }

        Toast.makeText(this,new Select().from(UserModel.class).queryList().get(0).name,Toast.LENGTH_LONG).show();
    }




}
