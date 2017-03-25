package com.pro.blogL.util;

import java.util.UUID;

/**
 * Created by lhd on 2017/3/24.
 */
public class StringUtils {

    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-","");
        return id;
    }

}
