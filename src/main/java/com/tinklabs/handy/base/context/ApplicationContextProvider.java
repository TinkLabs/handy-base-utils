package com.tinklabs.handy.base.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @description: spring 上下文管理
 * @copyright: Copyright (c) 2019
 * @company: tinklabs
 * @author: 曹友安
 * @version: 1.0
 * @date: 2019 Mar 15, 2019 4:19:10 PM
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	private static final String DEFAULT_EVN = "default";

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextContainer.setApplicationContext(applicationContext);
		// 初始化系统环境参数
		String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
		if (activeProfiles != null && activeProfiles.length > 0) {
			AppHolder.initApp(appName, activeProfiles[0]);
		} else {
			AppHolder.initApp(appName, DEFAULT_EVN);
		}

	}

}
