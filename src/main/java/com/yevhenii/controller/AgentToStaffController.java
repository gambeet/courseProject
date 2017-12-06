package com.yevhenii.controller;

import com.yevhenii.model.Agent;
import com.yevhenii.model.AgentToStaff;
import com.yevhenii.model.RecruitedStaff;
import com.yevhenii.model.StolenDocument;
import com.yevhenii.sevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Controller
@RequestMapping("/me")
public class AgentToStaffController {
    @Autowired
    private AgentsService agentsService;
    @Autowired
    private RecruitedStaffService recruitedStaffService;
    @Autowired
    private AgentToStaffService agentToStaffService;
    @Autowired
    CountriesService countriesService;
    @Autowired
    StolenDocumentsService stolenDocumentsService;

    @RequestMapping()
    public String getAgent(Model model, Authentication authentication){
        Agent agent = agentsService.getByCodeName(authentication.getName());
        model.addAttribute("agent", agent);
        Collection<AgentToStaff> agentToStaffsById = agent.getAgentToStaffsById();
        model.addAttribute("myStaffs", agentToStaffsById);
        model.addAttribute("myDocs", agent.getStolenDocumentsById());
        return "/me/mypage";
    }

    @RequestMapping("/declassified")
    public String declassified(Authentication authentication){
        Agent agent = agentsService.getByCodeName(authentication.getName());
        agent.setStatus(true);
        agentsService.save(agent);
        return "redirect:/login";
    }

    @RequestMapping("/addStaff")
    public String addStaffPage(Model model){
        model.addAttribute("newStaff", new RecruitedStaff());
        model.addAttribute("countries", countriesService.getAll());
        model.addAttribute("staffs", recruitedStaffService.getAll());
        return "/me/addStaff";
    }
    @RequestMapping(value = "/addStaff/submit", method = RequestMethod.POST)
    public String submitAddStaff(@ModelAttribute RecruitedStaff item, Authentication authentication){
        AgentToStaff agentToStaff = new AgentToStaff();
        recruitedStaffService.save(item);
//        agentToStaff.setAgentByAgentId(agentsService.getByCodeName(authentication.getName()));
//        agentToStaff.setRecruitedStaffByStaffId(item);
//        agentToStaffService.save(agentToStaff);
        return "redirect:../";
    }

    @RequestMapping(value = "/addStaff/submit/{id}", method = RequestMethod.GET)
    public String submitAddExistStaff(@PathVariable int id, Authentication authentication) {
        AgentToStaff agentToStaff = new AgentToStaff();
        agentToStaff.setAgentByAgentId(agentsService.getByCodeName(authentication.getName()));
        agentToStaff.setRecruitedStaffByStaffId(recruitedStaffService.getById(id));
        agentToStaffService.save(agentToStaff);
        return "redirect:../../";
    }

    @RequestMapping("/addDoc")
    public String addDocPage(Model model, Authentication authentication){
        model.addAttribute("item", new StolenDocument());
        model.addAttribute("agent", agentsService.getByCodeName(authentication.getName()));
        model.addAttribute("countries", countriesService.getAll());
        return "/me/addDoc";
    }
    @RequestMapping(value = "/addDoc/submit", method = RequestMethod.POST)
    public String submitAddDoc(@ModelAttribute StolenDocument item, Authentication authentication){
        item.setAgentByAgentId(agentsService.getByCodeName(authentication.getName()));
        stolenDocumentsService.save(item);
        return "redirect:../";
    }

    @RequestMapping(value = "/deleteStaff/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        agentToStaffService.delete(id);
        return "redirect:../";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public String edit(@PathVariable Integer id, Model model){
//        AgentToStaff item = agentToStaffService.getById(id);
//        model.addAttribute("item", item);
//        //model.addAttribute("countries", countriesService.getAll());
//        return "recstaff/edit";
//    }

}
