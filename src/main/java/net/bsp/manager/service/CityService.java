package net.bsp.manager.service;

import java.util.List;

import net.bsp.manager.model.City;

public interface CityService {
    
    City getById(Long id);
    
    List<City> getAllProvince();
}
