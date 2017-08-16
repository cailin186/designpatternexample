package com.javapatterns.observer.cailin;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {
	/**
	 * 用来保存注册的观察者对象
	 */
	private List<IObserver> list = new ArrayList<IObserver>();

	/**
	 * 注册观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void addListener(IObserver observer) {
		list.add(observer);
		System.out.println("Attached an observer");
	}

	/**
	 * 删除观察者对象
	 * 
	 * @param observer
	 *            观察者对象
	 */
	public void removeListener(IObserver observer) {
		list.remove(observer);
	}

	/**
	 * 通知所有注册的观察者对象
	 */
	public void nodifyObservers(String state) {

		for (IObserver observer : list) {
			observer.update(state);
		}

	}
}