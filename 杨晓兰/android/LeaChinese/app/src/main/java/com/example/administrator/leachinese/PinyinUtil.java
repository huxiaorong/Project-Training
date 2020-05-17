package com.example.administrator.leachinese;

import android.util.Log;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {

    public static String getPinyinString(String character) {
        if (character != null && character.length() > 0) {
            String[] pinyin = new String[character.length()];
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
            for (int index = 0; index < character.length(); index++) {
                char c = character.charAt(index);

                try {
                    String[] pinyinUnit = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if (pinyinUnit == null) {
                        pinyin[index] = "  ";
                    }else {
                        pinyin[index] = pinyinUnit[0];
                    }
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0;i<pinyin.length-1;i++){
                stringBuffer.append(pinyin[i]);
                stringBuffer.append("     ");
            }
            stringBuffer.append(pinyin[pinyin.length-1]);
            Log.e("stringBuffer",stringBuffer.toString());
            return stringBuffer.toString();
        } else {
            return null;
        }
    }
}
