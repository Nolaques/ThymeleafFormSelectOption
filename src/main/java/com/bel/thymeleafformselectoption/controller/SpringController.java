package com.bel.thymeleafformselectoption.controller;

import com.bel.thymeleafformselectoption.dao.CountryDAO;
import com.bel.thymeleafformselectoption.form.PersonForm;
import com.bel.thymeleafformselectoption.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class SpringController {

    @Autowired
    private CountryDAO countryDAO;

    @RequestMapping("/")
    public String home() {
        return "_menu";
    }

    @RequestMapping(value = {"/selectOptionExample1"}, method = RequestMethod.GET)
    public String selectOptionExample1Page(Model model) {

        PersonForm form = new PersonForm();
        model.addAttribute("personForm", form);

        List<Country> list = countryDAO.getCountries();
        model.addAttribute("countries", list);

        return "selectOptionExample1";
    }

    @RequestMapping(value = {"/selectOptionExample2"}, method = RequestMethod.GET)
    public String selectOptionExample2Page(Model model) {

        PersonForm form = new PersonForm();
        model.addAttribute("personForm", form);

        //Long: countryId
        //String: countryName
        Map<Long, String> mapCountries = countryDAO.getMapCountries();
        model.addAttribute("mapCountries", mapCountries);

        return "selectOptionExample2";
    }

    @RequestMapping(value = {"/selectOptionExample3"}, method = RequestMethod.GET)
    public String selectOptionExample3Page(Model model){

        PersonForm form = new PersonForm();
        model.addAttribute("personForm", form);

        //Long: countryId
        //String: countryName
        Map<Long,String> mapCountries=countryDAO.getMapCountries();
        model.addAttribute("mapCountries", mapCountries);

        return "selectOptionExample3";
    }
}
