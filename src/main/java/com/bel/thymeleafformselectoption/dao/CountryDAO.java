package com.bel.thymeleafformselectoption.dao;


import com.bel.thymeleafformselectoption.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CountryDAO {

    private static final List<Country> COUNTRIES = new ArrayList<>();

    static {
        initData();
    }

    private static void initData(){

        Country fr = new Country(1L,"FR", "France");
        Country en = new Country(2L,"EN", "England");
        Country ru = new Country(3L,"RU", "Russia");
        Country no = new Country(4L,"NO", "Norway");

        COUNTRIES.add(fr);
        COUNTRIES.add(en);
        COUNTRIES.add(ru);
        COUNTRIES.add(no);
    }

    public List<Country> getCountries(){
        return COUNTRIES;
    }

    public Map<Long,String> getMapCountries(){
        Map<Long,String> map = new HashMap<>();

        for (Country c :  COUNTRIES ) {
            map.put(c.getCountryId(), c.getCountryName());
        }
        return map;

    }

}
