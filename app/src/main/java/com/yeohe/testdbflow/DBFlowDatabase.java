package com.yeohe.testdbflow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Administrator on 2017/12/4.
 */

@Database(name = DBFlowDatabase.NAME,version = DBFlowDatabase.VERSION)
public class DBFlowDatabase {

    //数据库名称
    public static final String NAME="TESTDB" ;

    //数据库版本号
    public static final int VERSION=1;

}
