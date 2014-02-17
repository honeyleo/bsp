package com.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.manager.dao.CityDAO;
import com.manager.model.City;
import com.manager.model.Criteria;
import com.manager.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;
    
    @Cacheable(value = "commonCache", key = "'City_id_' + #id")
    @Override
    public City getById(Long id) {
        return cityDAO.selectById(id);
    }

    @Cacheable(value = "commonCache", key = "'CityService_provinces'")
    @Override
    public List<City> getAllProvince() {
        Criteria cir = new Criteria();
        return cityDAO.selectListByCriteria(cir);
    }

}
