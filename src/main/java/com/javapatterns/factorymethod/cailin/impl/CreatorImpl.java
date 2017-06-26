package com.javapatterns.factorymethod.cailin.impl;

import com.javapatterns.factorymethod.cailin.ICreator;
import com.javapatterns.factorymethod.cailin.IProduct;

public class CreatorImpl implements ICreator {

	@Override
	public IProduct factory() {
		return new ProductIml();
	}

}
