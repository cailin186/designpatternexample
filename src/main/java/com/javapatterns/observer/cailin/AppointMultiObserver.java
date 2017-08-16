package com.javapatterns.observer.cailin;

public class AppointMultiObserver implements IObserver{


	public void update(String state) {
		System.out.println("我是一对多的约课观察者:"+state);
	}



}
