package com.leonwang.app.chinashop.utils;

/**
 * Created by ghbha on 2016/5/9.
 */
public class TextUtil {
    public static String getFormatArea(String areaName) {
        if (areaName.length() > 2 && areaName.contains("县")) {
            areaName = areaName.replace("县", "");
        } else if (areaName.contains("市")) {
            areaName = areaName.replace("市", "");
        } else if (areaName.contains("新区")) {
            areaName = areaName.replace("新区","");
        } else if (areaName.contains("区")) {
            areaName = areaName.replace("区","");
        }
        return areaName;
    }
}
