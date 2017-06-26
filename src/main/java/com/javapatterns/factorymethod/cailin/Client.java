package com.javapatterns.factorymethod.cailin;

import com.javapatterns.factorymethod.cailin.impl.CreatorImpl;
import com.javapatterns.factorymethod.cailin.impl.ProductIml;

public class Client {

	public static void main(String[] args) {
		ICreator creator1,creator2;
		IProduct product1,product2;
		creator1 = new CreatorImpl();
		product1 = new ProductIml();
	
		
		creator2 = new CreatorImpl();
		product2 = new ProductIml();
	
	
		
	}
}
