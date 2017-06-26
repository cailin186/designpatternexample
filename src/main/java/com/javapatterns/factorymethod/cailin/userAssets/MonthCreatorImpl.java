package com.javapatterns.factorymethod.cailin.userAssets;

import com.javapatterns.factorymethod.cailin.userAssets.impl.IPoint;
import com.javapatterns.factorymethod.cailin.userAssets.impl.IPointCreator;
import com.javapatterns.factorymethod.cailin.userAssets.impl.month.MonthImpl;

public class MonthCreatorImpl implements IPointCreator {

	@Override
	public IPoint factory() {
		return new MonthImpl();
	}

}
