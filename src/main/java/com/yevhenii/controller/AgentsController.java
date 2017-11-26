package com.yevhenii.controller;

import com.yevhenii.model.Agent;
import com.yevhenii.model.Country;
import com.yevhenii.sevice.AgentsService;
import com.yevhenii.sevice.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Controller
@RequestMapping("/agents")
public class AgentsController {
    @Autowired
    private AgentsService agentsService;
    @Autowired
    private CountriesService countriesService;

    @RequestMapping
    public String mainPage(Model model){
        model.addAttribute("agents", agentsService.getAll());
        return "agents/list";
    }

    @RequestMapping("/add")
    public String addPage(Model model){
        model.addAttribute("agent", new Agent());
        model.addAttribute("countries", countriesService.getAll());
        return "agents/add";
    }
    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String submitAddCountry(@ModelAttribute Agent item){
        agentsService.save(item);
        return "redirect:../";
    }
}
