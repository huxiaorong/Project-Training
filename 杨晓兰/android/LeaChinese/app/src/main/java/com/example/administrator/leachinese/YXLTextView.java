package com.example.administrator.leachinese;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class YXLTextView extends View {
    private String[] pinyin;
    private String[] chinese;
    private String myText;
    private TextPaint textPaintSpell = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint textPaintChinese = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private int fontSizeSpell = SizeUtils.dp2px(getContext(),18);
    private int fontSizeChinese =SizeUtils.dp2px(getContext(),18);
    private int colorSpell = Color.parseColor("#1b97d6");
    private int colorChinese = Color.parseColor("#000000");
    public YXLTextView(Context context) {
        super(context);
        init();
    }

    public YXLTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public YXLTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    public void init(){
        float denity = getResources().getDisplayMetrics().density;
        textPaintSpell.setStrokeWidth(denity);
        textPaintChinese.setStrokeWidth(denity);
        textPaintSpell.setTextAlign(Paint.Align.LEFT);
        textPaintChinese.setTextAlign(Paint.Align.LEFT);
        textPaintChinese.setTextSize(fontSizeChinese);
        textPaintChinese.setColor(colorChinese);
        textPaintSpell.setTextSize(fontSizeSpell);
        textPaintSpell.setColor(colorSpell);
    }
    public void init(Context context, @Nullable AttributeSet attrs){
        float denity = getResources().getDisplayMetrics().density;
        textPaintSpell.setStrokeWidth(denity);
        textPaintChinese.setStrokeWidth(denity);
        textPaintSpell.setTextAlign(Paint.Align.LEFT);
        textPaintChinese.setTextAlign(Paint.Align.LEFT);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.YXLTextView);
        myText = array.getString(R.styleable.YXLTextView_myText);
        array.recycle();
        setStringResource(myText);
        textPaintChinese.setTextSize(fontSizeChinese);
        textPaintChinese.setColor(colorChinese);
        textPaintSpell.setTextSize(fontSizeSpell);
        textPaintSpell.setColor(colorSpell);
    }


    public void setMyText(String myText) {
        this.myText = myText;
        setStringResource(myText);
    }

    //设置文字资源
    public void setStringResource(String string) {
        String[] spellArray = getPinyinString(string);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : spellArray){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }

        char[] chars = string.toCharArray();
        String[] chineseArray = new String[chars.length];
        for (int i = 0; i < chars.length;i++){
            chineseArray[i] = String.valueOf(chars[i]);
        }
        setSpellAndChinese(spellArray,chineseArray);
    }
    //拼音和汉字的资源
    public void setSpellAndChinese(String[] pinYin, String[] chinese) {
        this.pinyin = pinYin;
        this.chinese = chinese;
    }
    public static String[] getPinyinString(String character) {
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
            return pinyin;
        } else {
            return null;
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        float widthMesure = 0f;
        int comlum = 1;
        float pinyinWidth;
        if (pinyin != null && pinyin.length > 0) {
            for (int index = 0; index < pinyin.length; index++) {
                pinyinWidth = widthMesure + textPaintSpell.measureText(pinyin[index]);
                if (pinyinWidth > getWidth()) {
                    comlum++;
                    widthMesure = 0;
                }
                canvas.drawText(pinyin[index], widthMesure, (comlum * 2 - 1) * (textPaintChinese.getFontSpacing()), textPaintSpell);
                canvas.drawText(chinese[index],
                        widthMesure + (textPaintSpell.measureText(pinyin[index]) - textPaintChinese.measureText(chinese[index])) / 2,
                        (comlum * 2) * (textPaintChinese.getFontSpacing()), textPaintChinese);
                if (index + 1 < pinyin.length) {
                    widthMesure = widthMesure + textPaintSpell.measureText(pinyin[index] + 1);
                } else {
                    widthMesure = widthMesure + textPaintSpell.measureText(pinyin[index]);
                }
            }
        }
    }
}
