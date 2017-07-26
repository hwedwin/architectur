package com.sishuok.architecture1.storemgr.service;


import com.sishuok.architecture1.common.service.IBaseService;

import com.sishuok.architecture1.storemgr.vo.StoreModel;
import com.sishuok.architecture1.storemgr.vo.StoreQueryModel;
import org.springframework.stereotype.Service;

public interface IStoreService extends IBaseService<StoreModel,StoreQueryModel>{
	 StoreModel getByGoodsUuid(int goodsUuid);
}

