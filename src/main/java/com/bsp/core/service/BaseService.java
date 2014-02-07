package com.bsp.core.service;

import java.util.List;

import com.bsp.model.Criteria;
import com.bsp.model.PageInfo;

public interface BaseService<T> {

	List<T> getEntity(T entity);
	
	T getEntityById(Long id) throws Exception;
	
	int save(T entity) throws Exception;
	
	int update(T entity);
	
	int delete(List<String> ids);
	
	int delete(long id);
	
	int countByCriteria(Criteria criteria);
	
	List<T> findListByCriteria(Criteria criteria);
	
	PageInfo<T> findListByCriteria(Criteria criteria, int pageNo,
			int pageSize);
}
