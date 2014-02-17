package com.manager.service;

import java.util.List;

import com.manager.model.City;

public interface CityService {
    
    City getById(Long id);
    
    List<City> getAllProvince();
}
