package com.classtable.pain.finaldesign.utils;

import org.xutils.DbManager;

public class Dbinit {
    static DbManager.DaoConfig daoConfig;  
    public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null){
            daoConfig=new DbManager.DaoConfig()  
            .setDbName("tclass.db")
            .setDbVersion(1)
            .setAllowTransaction(true)  
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override  
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {  
  
                }  
            });  
        }  
        return daoConfig;  
    }  
}  