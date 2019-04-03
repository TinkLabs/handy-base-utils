package com.tinklabs.handy.base.context;

import org.springframework.context.ApplicationContext;

public class SpringContextContainer {

    private SpringContextContainer() {
    }

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext ctx) {
        applicationContext = ctx;
    }

}
