package com.coupang.c4.step14;

//import com.coupang.c4.step14.beanfactory.PropertyReader;
import com.coupang.c4.step14.beanfactory.SimpleBeanFactory;
import com.coupang.c4.step14.beans.Sample1;
import com.coupang.c4.step14.beans.Sample2;

import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory("/com/coupang/c4/step14/bean-definitions.properties");
		Object instance = simpleBeanFactory.getInstance(Sample1.class);

		System.out.println(instance != null);

		Object instance2 = simpleBeanFactory.getInstance("sample2");
		System.out.println(instance2 != null);

	}
}
