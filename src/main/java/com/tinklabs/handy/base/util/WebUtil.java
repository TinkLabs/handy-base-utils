package com.tinklabs.handy.base.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
    public static String getUrl(HttpServletRequest request){
        return  request.getScheme() +"://" + request.getServerName();
    }
}
