package com.lqx.cglib;

/**
 * @author linqx
 * @version 1.0
 * @classname CglibMain
 * @description TODO
 * @date 2022/5/19 8:36
 */
public class CglibMain {

//	@Test
//	public void cglibTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//		// 反射出ConfigurationClassEnhancer，并创建实例
//		Class<?> configurationClassEnhancerClass = Class.forName("org.springframework.context.annotation.ConfigurationClassEnhancer");
//		Constructor<?> constructor = configurationClassEnhancerClass.getDeclaredConstructor();
//		constructor.setAccessible(true);
//		Object configurationClassEnhancer = constructor.newInstance();
//
//		// 获取属性callbackFilter
//		Field callbackFilterField = configurationClassEnhancerClass.getDeclaredField("CALLBACK_FILTER");
//		callbackFilterField.setAccessible(true);
//		CallbackFilter callbackFilter = (CallbackFilter) callbackFilterField.get(configurationClassEnhancer);
//
//		//反射ConditionalCallbackFilter类
//		Class<?> ConditionalCallbackFilter = Class.forName("org.springframework.context.annotation.ConfigurationClassEnhancer$ConditionalCallbackFilter");
//		//获取getCallbackTypes方法
//		Method getCallbackTypesMethod = ConditionalCallbackFilter.getDeclaredMethod("getCallbackTypes");
//		getCallbackTypesMethod.setAccessible(true);
//
//
//		//反射出EnhancedConfiguration接口
//		Class<?> enhancedConfiguration = Class.forName("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
//
//		//创建增强类
//		Enhancer enhancer = new Enhancer();
//		//设置目标类
//		enhancer.setSuperclass(MyConfig.class);
//		//设置要实现的接口
//		enhancer.setInterfaces(new Class<?>[]{enhancedConfiguration});
//		enhancer.setUseFactory(false);
//		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//		//生成自定义的策略
//		enhancer.setStrategy(new MyBeanFactoryAwareGeneratorStrategy(this.getClass().getClassLoader()));
//		//过滤器
//		enhancer.setCallbackFilter(callbackFilter);
//		//过滤器类型
//		enhancer.setCallbackTypes((Class[]) getCallbackTypesMethod.invoke(callbackFilter));
//		//创建代理类
//		Class proxy = enhancer.createClass();
//		System.out.println(proxy);
//	}
}
