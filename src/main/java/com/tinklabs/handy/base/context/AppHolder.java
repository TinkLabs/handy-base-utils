package com.tinklabs.handy.base.context;

/**
 * @description: 应用信息持有类
 * @company: tinklabs
 * @author: pengtao
 * @date: 2019 2019年4月3日 下午3:09:13
 */
public class AppHolder {

	/**
     * 应用名
     */
    private static String appName;

    /**
     * 当前环境
     */
    private static String env;

    public static void initApp(String appName, String env) {
        AppHolder.appName = appName;
        AppHolder.env = env;
    }

    public static String getAppName() {
        return appName;
    }

    public static String getEnv() {
        return env;
    }

    
}
