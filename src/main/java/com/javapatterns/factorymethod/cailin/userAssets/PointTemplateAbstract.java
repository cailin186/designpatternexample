package com.javapatterns.factorymethod.cailin.userAssets;

import com.javapatterns.factorymethod.cailin.userAssets.po.UserAssetPO;

public abstract class PointTemplateAbstract {

	public void consumLog(UserAssetPO userAssetsPO){
           System.out.println("consumlog................"+userAssetsPO.toString());		
	}
	
	
}
