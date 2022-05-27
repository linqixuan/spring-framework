package com.lqx.beandefinitions;

import com.lqx.beandefinitions.beans.Bean1;
import com.lqx.beandefinitions.beans.Bean2;
import com.lqx.beandefinitions.beans.ImportBean1;
import com.lqx.beandefinitions.beans.MyEnableAnnotation;
import com.lqx.beandefinitions.beans.MyImportBeanDefinitionRegistrar;
import com.lqx.beandefinitions.beans.MyImportSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author linqx
 * @version 1.0
 * @classname MergeConfig
 * @description TODO
 * @date 2022/5/27 8:13
 */
@Configuration
@Import({ImportBean1.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan("com.lqx.beandefinitions.scan")
@ImportResource("classpath:spring.xml")
@PropertySource("classpath:my.properties")
@MyEnableAnnotation()
public class MergeConfig {

	@Autowired
	Environment environment;

	@Bean
	public Bean1 getBean1() {
		Bean1 bean1 = new Bean1();
		bean1.setAge(Integer.valueOf(environment.getProperty("age")));
		bean1.setName(environment.getProperty("name"));
		return bean1;
	}
	//内部类
	private class InnerClass{
		@Bean
		public Bean2 getBean2(){
			return new Bean2();
		}
	}
}

