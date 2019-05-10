package com.kang.qiandao.utils;

import java.util.UUID;

public class IdGeneratorUtil {
    public static  String getId() {

        String id =UUID.randomUUID().toString();
        id=id.replace("-","");
        return  id;
    }
}
