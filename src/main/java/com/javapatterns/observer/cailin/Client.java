package com.javapatterns.observer.cailin;

public class Client {

	public static void main(String[] args) {
		
		String data = ".............我是需要通知的数据....";
		// 创建主题对象
		AppointStatusSubject appointSubject = new AppointStatusSubject();
		// 创建观察者对象
		IObserver one2oneAppoint = new One2OneAppointObserver();
		IObserver appointMulti = new AppointMultiObserver();
		// 将观察者对象登记到主题对象上
		appointSubject.addListener(one2oneAppoint);
		appointSubject.addListener(appointMulti);
		// 发布数据状态
		appointSubject.publish(data);

	}

}
