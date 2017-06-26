package com.javapatterns.factorymethod.cailin.userAssets.impl.month;

import com.javapatterns.factorymethod.cailin.userAssets.impl.IPoint;

public class MonthImpl implements IPoint {

	@Override
	public int addAppoint() {
	System.out.println("month add.................");
	return 0;
	}

	@Override
	public int cancelAppoint() {
		System.out.println("month cancel.................");
		return 0;
	}

}
