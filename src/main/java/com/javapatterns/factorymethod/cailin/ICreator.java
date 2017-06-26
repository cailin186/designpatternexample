package com.javapatterns.factorymethod.cailin;

import com.javapatterns.factorymethod.cailin.userAssets.impl.IPoint;

public interface ICreator {
	public IPoint factory();
}
