package com.yevhenii.controller;

import com.yevhenii.model.RecruitedStaff;
import com.yevhenii.model.StolenDocument;
import com.yevhenii.sevice.AgentsService;
import com.yevhenii.sevice.CountriesService;
import com.yevhenii.sevice.RecruitedStaffService;
import com.yevhenii.sevice.StolenDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Controller
@RequestMapping("/recstaff")
public class RecruitedStaffController {
    @Autowired
    private CountriesService countriesService;
    @Autowired
    private RecruitedStaffService recruitedStaff;

    @RequestMapping
    public String mainPage(Model model){
        model.addAttribute("staffs", recruitedStaff.getAll());
        return "recstaff/list";
    }

    @RequestMapping("/add")
    public String addPage(Model model){
        model.addAttribute("item", new RecruitedStaff());
        model.addAttribute("countries", countriesService.getAll());
        return "recstaff/add";
    }
    @RequestMapping(value = "/add/submit", method = RequestMethod.POST)
    public String submitAdd(@ModelAttribute RecruitedStaff item){
        recruitedStaff.save(item);
        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        recruitedStaff.delete(id);
        return "redirect:../";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        RecruitedStaff item = recruitedStaff.getById(id);
        model.addAttribute("item", item);
        model.addAttribute("countries", countriesService.getAll());
        return "recstaff/edit";
    }
    @RequestMapping(value = "/edit/submit", method = RequestMethod.POST)
    public String submitEditCountry(@ModelAttribute RecruitedStaff item){
        recruitedStaff.update(item);
        return "redirect:../";
    }
}
