package com.yevhenii.controller;

import com.yevhenii.model.Agent;
import com.yevhenii.model.Country;
import com.yevhenii.sevice.AgentsService;
import com.yevhenii.sevice.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
    public String submitAdd(@ModelAttribute Agent item){
        item.setPassword(encoder.encode(item.getPassword()));
        agentsService.save(item);
        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        agentsService.delete(id);
        return "redirect:../";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        Agent item = agentsService.getById(id);
        model.addAttribute("item", item);
        model.addAttribute("countries", countriesService.getAll());
        return "agents/edit";
    }
    @RequestMapping(value = "/edit/submit", method = RequestMethod.POST)
    public String submitEditCountry(@ModelAttribute Agent item){
        agentsService.update(item);
        return "redirect:../";
    }
}
