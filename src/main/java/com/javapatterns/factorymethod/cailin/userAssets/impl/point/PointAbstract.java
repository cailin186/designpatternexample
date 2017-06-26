package com.javapatterns.factorymethod.cailin.userAssets.impl.point;

import com.javapatterns.factorymethod.cailin.userAssets.po.UserAssetPO;

public abstract class PointAbstract {
	private static final UserAssetPO UserAssetPO = null;
	public  int addAppoint(){
		consumelog(UserAssetPO);
		return 0;
	}
	public  int cancelAppoint(){
		consumelog(UserAssetPO);
		return 0;
	}
	public abstract void consumelog(UserAssetPO po);
}
