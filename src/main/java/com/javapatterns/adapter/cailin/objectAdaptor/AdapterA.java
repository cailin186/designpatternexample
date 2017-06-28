package com.javapatterns.adapter.cailin.objectAdaptor;

public class AdapterA  implements Target {

	 Adaptee adaptor = new Adaptee();
	 public void targetMethod() {
	        System.out.println("新方法....................");
	        adaptor. doSomething();

	    }

}
