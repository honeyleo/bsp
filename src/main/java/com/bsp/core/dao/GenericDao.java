package com.bsp.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsp.model.Criteria;

public interface GenericDao<T> {

	List<T> getEntity(T entity);
	
	T getEntityById(long id);
	
	int save(T entity);
	
	int update(T entity);
	
	int delete(@Param("ids") List<String> ids);
	
	int delete(@Param("id") long id);
	
	int countByCriteria(Criteria criteria);
	
	List<T> findListByCriteria(Criteria criteria);

}
