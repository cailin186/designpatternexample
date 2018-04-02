package com.javapatterns.factorymethod.cailin.impl;

import com.javapatterns.factorymethod.cailin.ICreator;
import com.javapatterns.factorymethod.cailin.IProduct;

public class CreatorImpl implements ICreator {

	public IProduct factory() {
		return new ProductIml();
	}

}
