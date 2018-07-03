package com.github.xujsh.springboot.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年7月3日 下午1:56:25<br/>
 */
@Component
public class EnvPostProcessor implements EnvironmentPostProcessor {
	
	private static Logger log = LoggerFactory.getLogger(EnvPostProcessor.class);
	
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		String includes = environment.getProperty("properties.includes",String.class);
		if(includes != null && includes.length() > 0) {
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				String includeArray[] =  includes.split(",");
				for(String include : includeArray) {
					File includeFile = ResourceUtils.getFile("classpath:"+include);
					if(includeFile == null || !includeFile.exists()) {
						continue;
					}
					InputStream in = new FileInputStream(includeFile);
					StreamUtils.copy(new FileInputStream(includeFile), out);
					out.write("\r\n".getBytes());
					in.close();	
				}
				Properties properties = new Properties();
				properties.load(new ByteArrayInputStream(out.toByteArray()));
				PropertiesPropertySource propertySource = new PropertiesPropertySource("my", properties);
				environment.getPropertySources().addLast(propertySource);
			}catch(Exception e) {
				log.error("读取配置文件异常", e);
			}
		}
	}
}
