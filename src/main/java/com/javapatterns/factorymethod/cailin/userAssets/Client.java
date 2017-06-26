package com.javapatterns.factorymethod.cailin.userAssets;

import com.javapatterns.factorymethod.cailin.userAssets.impl.IPointCreator;

public class Client {

	public static void main(String[] args) {
		IPointCreator point = new PointCreatorImpl();
//		IPointCreator month = new MonthCreatorImpl();
		
		point.factory().addAppoint();
		point.factory().cancelAppoint();
//		
//		month.factory().addAppoint();
//		month.factory().cancelAppoint();
//		
		
	}
	
	
	
}
