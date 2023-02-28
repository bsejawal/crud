package com.bsejawal.crud.util;

public class StringUtil {
    public static boolean isEmpty(String str){

        if(str == null) return true;
        if(str.trim().isEmpty()) return true;
        return false;
    }

}
