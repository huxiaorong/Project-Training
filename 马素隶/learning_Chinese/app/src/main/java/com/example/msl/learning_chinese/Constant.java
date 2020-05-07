package com.example.msl.learning_chinese;


public class Constant {
    private static String ip = "http://192.168.0.103:8080";
    public final static String BASE_URL=ip+"/LeaChinese";
    public final static String GAME_ONE=BASE_URL+"/idiom";
    public static int level=0;
    public static int guan=1;
    public final static String GAME_TWO=BASE_URL+"/findword/";
    public static String tag="open";
    public static User USER=new User();
}
