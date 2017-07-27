package com.sishuok.architecture1.goodsmgr.dao;

import com.sishuok.architecture1.goodsmgr.vo.GoodsModel;
import com.sishuok.architecture1.goodsmgr.vo.GoodsQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapperDAO extends GoodsDAO{
	 List<Integer> getIdsByConditionPage(GoodsQueryModel gqm);
	 List<GoodsModel> getByIds(String ids);
}
