package com.linfeiyang.shop.common;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GsonUtils {

    public static String toJson(Object o) {
        return new Gson().toJson(o);
    }

    public static <T> T toObject(String str, Class<T> type) {
        return new Gson().fromJson(str, type);
    }

}
