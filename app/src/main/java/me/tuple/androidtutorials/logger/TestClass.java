package me.tuple.androidtutorials.logger;

import com.promegu.xlog.base.XLog;

public class TestClass {


    public static String getName(){
        return getFullName("Gokul","Prabhu");

    }
    @XLog
    public static String getFullName(String firstName,String lastName){
        return firstName + lastName;
    }
}
