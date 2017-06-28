package com.javapatterns.adapter.cailin.classAdaptor;

public class AdapterA extends Adaptee implements Target {

	 public void targetMethod() {
	        System.out.println("新方法....................");
	        doSomething();

	    }

}
