package com.javapatterns.factorymethod.cailin.userAssets;

import com.javapatterns.factorymethod.cailin.userAssets.impl.IPoint;
import com.javapatterns.factorymethod.cailin.userAssets.impl.IPointCreator;
import com.javapatterns.factorymethod.cailin.userAssets.impl.point.PointImpl;

public class PointCreatorImpl implements IPointCreator {

	@Override
	public IPoint factory() {
		return new PointImpl();
	}

}
