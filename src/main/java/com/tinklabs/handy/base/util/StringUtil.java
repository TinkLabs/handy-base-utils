package com.tinklabs.handy.base.util;
/**
 * @description
 * @author Landin
 * @date 2019-05-15 14:37
 */
public class StringUtil {
    /**
     * Separate a string into two parts by using a separator string.
     * This function will always return an array of two so that it is safe to
     * use the following syntax:
     *   list($left, $right) = Utils::separate('abc|def', '|');
     */
    public static String[] separate(String str, String seperator, boolean trim) {
        if(str == null){
            return new String[]{null,null};
        }
        int index = str.indexOf(seperator);
        if (index == -1) {
            if (trim) {
                str = str.trim();
            }
            return new String[]{str,null};
        } else {
            String a = str.substring(0, index);
            String b = str.substring(index+1, str.length());
            if (trim){
                a = a.trim();
            }
            if (trim){
                b = b.trim();
            }
            return new String[]{a, b};
        }
    }
    public static String replaceFirst(String str, String needle, String replacement) {
        int index = str.indexOf(needle);
        if (index != -1) {
            return str.replaceFirst(needle, replacement);
        }
        return str;
    }
    /**
     * @description  remove the first and last double quotes in the string
     * @author Landin
     * @date 2019-05-20 14:56
     * @param str
     * @return java.lang.String
     */
    public static String removeDoubleQuotesInFL(String str) {
        if(str.startsWith("\"") && str.endsWith("\"")){
            return str.substring(1,str.length() - 1);
        }else{
            return str;
        }
    }
}
