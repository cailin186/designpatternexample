package com.javapatterns.adapter.classAdapter;

public class Client {
	public static void main(String[] args) {
		
		Target target  = new TargetImpl();
		target.sampleOperation1();
		target.sampleOperation2();
		
		System.out.println("---------------");
		
		Target adaptor  = new Adapter();
		adaptor.sampleOperation1();
		adaptor.sampleOperation2();
		
		
	}
}
