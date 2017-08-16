package com.javapatterns.observer.cailin;

public class One2OneAppointObserver implements IObserver{


	public void update(String state) {
		System.out.println("我是约课的观察者，我得到了约课的最新数据:"+state);
	}



}
