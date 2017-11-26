package com.yevhenii.controller;

import com.yevhenii.model.Country;
import com.yevhenii.sevice.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/countries")
public class CountriesController {
    @Autowired
    private CountriesService service;

    @RequestMapping
    public String mainPage(Model model){
        model.addAttribute("countries", service.getAll());
        return "countries/list";
    }

    @RequestMapping("/add")
    public String addPage(Model model){
        model.addAttribute("country", new Country());
        return "countries/add";
    }
    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String submitAddCountry(@ModelAttribute Country item){
        service.save(item);

        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:../";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        Country item = service.getById(id);
        model.addAttribute("item", item);
        return "countries/edit";
    }
    @RequestMapping(value = "/edit/submit", method = RequestMethod.POST)
    public String submitEditCountry(@ModelAttribute Country item){
        service.update(item);
        return "redirect:../";
    }

}
