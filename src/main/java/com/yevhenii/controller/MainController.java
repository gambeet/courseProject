package com.yevhenii.controller;

import com.yevhenii.sevice.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    AgentsService service;

    @RequestMapping
    public String index(Model model){
        return "index";
    }


    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403(Model model, Authentication authentication) {
        model.addAttribute("role", authentication.getAuthorities());
        model.addAttribute("user", authentication.getName());
        return "/error/403";
    }

}
