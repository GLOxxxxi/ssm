package com.suncaper.demo.common.utls;

public class FormatUtils {
    public static String difficultyUtils(String difficultyValue){
        switch (difficultyValue){
            case "不困难": return  "BKN";
            case "一般困难": return  "YBKN";
            case "特殊困难": return  "TSKN";
            default: return "未知";
        }
    }
}
