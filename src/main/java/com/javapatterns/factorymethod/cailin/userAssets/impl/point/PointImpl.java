package com.javapatterns.factorymethod.cailin.userAssets.impl.point;

import com.javapatterns.factorymethod.cailin.userAssets.PointTemplateAbstract;
import com.javapatterns.factorymethod.cailin.userAssets.impl.IPoint;
import com.javapatterns.factorymethod.cailin.userAssets.po.UserAssetPO;

public class PointImpl extends PointTemplateAbstract implements IPoint {

	@Override
	public int addAppoint() {

		UserAssetPO userAssetsPO = CombineUserAssets();
		System.out.println("point add....................");
		super.consumLog(userAssetsPO);
		return 0;
	}

	private UserAssetPO CombineUserAssets() {
		UserAssetPO userAssetsPO = new UserAssetPO();
		userAssetsPO.setSkuId(1001L);
		userAssetsPO.setSkuTypeName("point");
		return userAssetsPO;
	}

	@Override
	public int cancelAppoint() {
		System.out.println("point cancel....................");
		return 0;
	}
	
}
