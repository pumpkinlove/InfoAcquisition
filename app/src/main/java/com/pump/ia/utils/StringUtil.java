package com.pump.ia.utils;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class StringUtil {

    public static boolean isBlank(String str){

        if(str == null)
            return false;
        if(str.length() < 1)
            return false;
        if("".equals(str))
            return false;
        return true;
    }
}
