package com.lqx.cglib;

import org.springframework.asm.Type;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cglib.core.ClassGenerator;
import org.springframework.cglib.core.Constants;
import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.cglib.transform.ClassEmitterTransformer;
import org.springframework.cglib.transform.TransformingClassGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author linqx
 * @version 1.0
 * @classname MyBeanFactoryAwareGeneratorStrategy
 * @description TODO
 * @date 2022/5/19 10:10
 */
public  class MyBeanFactoryAwareGeneratorStrategy extends DefaultGeneratorStrategy {

	private final ClassLoader classLoader;

	public MyBeanFactoryAwareGeneratorStrategy(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	protected ClassGenerator transform(ClassGenerator cg) throws Exception {
		ClassEmitterTransformer transformer = new ClassEmitterTransformer() {
			@Override
			public void end_class() {
				declare_field(Constants.ACC_PUBLIC, "自定义的bean工厂", Type.getType(BeanFactory.class), null);
				super.end_class();
			}
		};
		return new TransformingClassGenerator(cg, transformer);
	}

	@Override
	public byte[] generate(ClassGenerator cg) throws Exception {
		if (this.classLoader == null) {
			return super.generate(cg);
		}

		Thread currentThread = Thread.currentThread();
		ClassLoader threadContextClassLoader;
		try {
			threadContextClassLoader = currentThread.getContextClassLoader();
		}
		catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back...
			return super.generate(cg);
		}

		boolean overrideClassLoader = !this.classLoader.equals(threadContextClassLoader);
		if (overrideClassLoader) {
			currentThread.setContextClassLoader(this.classLoader);
		}
		try {
			//生成的字节码保存到本地
			byte[] generate = super.generate(cg);
			FileOutputStream fileOutputStream = null;
			try {
				fileOutputStream = new FileOutputStream(new File("D:\\MyConfigProxy.class"));
				try {
					fileOutputStream.write(generate);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fileOutputStream != null) {
						try {
							fileOutputStream.flush();
							fileOutputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			return generate;
		}
		finally {
			if (overrideClassLoader) {
				// Reset original thread context ClassLoader.
				currentThread.setContextClassLoader(threadContextClassLoader);
			}
		}
	}
}
