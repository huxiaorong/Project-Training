package com.example.msl.learning_chinese;


public class StringUtil {



    /**
     * 返回截取指定长度字节数后的字符串,多余部分用“...”代替
     * @param strs
     * @param length
     * @return
     */
    public static String cutStr(String strs, int length) {
        int sum = 0;
        String finalStr = "";
        if (null == strs || strs.getBytes().length <= length) {
            finalStr = (strs==null?"":strs);
        } else {
            for (int i = 0; i < strs.length(); i++) {
                String str = strs.substring(i, i + 1);
                // 累加单个字符字节数
                sum += str.getBytes().length;
                if (sum > length) {
                    finalStr = strs.substring(0, i) + "...";
                    break;
                }
            }
        }
        return finalStr;
    }

}
