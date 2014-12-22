package com.coupang.c4.step14.beanfactory;

//singleton instance 관io
// 고려 내용 추후 다른 scope 생성이 용이한 구조가 되도록


import com.coupang.c4.ResourceUtil;
import com.coupang.c4.step13.reflectionsamples.ReflectionTargetClass2;
import com.coupang.c4.step15.beanfactory.AbstractBeanDefinitionLoader;
import com.coupang.c4.step15.beanfactory.BeanDefinition;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.io.InputStream;
import com.coupang.c4.ResourceUtil;
//import com.coupang.c4.step14.beanfactory.PropertyReader;

import com.coupang.c4.ResourceUtil;

interface BeanFactoryInterface{

	public <T> T getInstance(Class<T> type);
}

public class SimpleBeanFactory implements BeanFactoryInterface{
	private String propertyPath;
	public SimpleBeanFactory(String propertyPath){
		this.propertyPath = propertyPath;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getInstance(Class<T> type){
	try {
			String classPath = type.getName();
			Class forName = Class.forName(classPath);

			Object object = Class.forName(classPath);
			return (T)object;
		}
    catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		catch(ClassCastException e){

		}

		return null;
	}

	public Object getInstance(String beanName) throws IOException, ClassNotFoundException {
		// TODO : 코드를 채워주세요 //key beanName,

		HashMap<String,String > container = new HashMap<String, String>();


		String configurationPath = "/com/coupang/c4/step14/";
		InputStream inputStream = ResourceUtil.resourceAsInputStream(configurationPath+"bean-definitions.properties");
		String [] line = ResourceUtil.readFully(inputStream);

		for(int index=0; index<line.length; index++) {
			String key = line[index].split("=")[0];
			String value = line[index].split("=")[1];
			container.put(key, value);
		}

		return container.get(beanName);


	}
}
