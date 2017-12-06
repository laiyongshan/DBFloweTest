package com.yeohe.testdbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Administrator on 2017/12/4.
 */

@ModelContainer
@Table(databaseName = DBFlowDatabase.NAME)
public class UserModel extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String name;

    @Column
    public int sex;

    @Column
    public int age;
}
