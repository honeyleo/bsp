package net.bsp.manager.service.impl;

import java.util.List;

import net.bsp.manager.dao.CityDAO;
import net.bsp.manager.model.City;
import net.bsp.manager.model.Criteria;
import net.bsp.manager.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
