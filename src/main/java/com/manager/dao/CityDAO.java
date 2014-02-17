package com.manager.dao;

import java.util.List;

import com.manager.model.City;
import com.manager.model.Criteria;

public interface CityDAO {
    /**
     * 根据条件查询记录总数
     */
    int countByCriteria(Criteria criteria);

    /**
     * 根据条件查询记录集
     */
    List<City> selectListByCriteria(Criteria criteria);

    /**
     * 根据主键查询记录
     */
    City selectById(Long id);

}