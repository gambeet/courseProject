package com.yevhenii.controller;

import com.yevhenii.model.Agent;
import com.yevhenii.model.StolenDocument;
import com.yevhenii.sevice.AgentsService;
import com.yevhenii.sevice.CountriesService;
import com.yevhenii.sevice.StolenDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stolendocs")
public class StolenDocumentsController {
    @Autowired
    private AgentsService agentsService;
    @Autowired
    private CountriesService countriesService;
    @Autowired
    private StolenDocumentsService stolenDocumentsService;

    @RequestMapping
    public String mainPage(Model model){
        model.addAttribute("stolendocs", stolenDocumentsService.getAll());
        return "stolendocs/list";
    }

    @RequestMapping("/add")
    public String addPage(Model model){
        model.addAttribute("stolendoc", new StolenDocument());
        model.addAttribute("countries", countriesService.getAll());
        model.addAttribute("agents", agentsService.getAll());
        return "stolendocs/add";
    }
    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String submitAdd(@ModelAttribute StolenDocument item){
        stolenDocumentsService.save(item);
        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        stolenDocumentsService.delete(id);
        return "redirect:../";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        StolenDocument item = stolenDocumentsService.getById(id);
        model.addAttribute("item", item);
        model.addAttribute("countries", countriesService.getAll());
        model.addAttribute("agents", agentsService.getAll());
        return "stolendocs/edit";
    }
    @RequestMapping(value = "/edit/submit", method = RequestMethod.POST)
    public String submitEditCountry(@ModelAttribute StolenDocument item){
        stolenDocumentsService.update(item);
        return "redirect:../";
    }
}
