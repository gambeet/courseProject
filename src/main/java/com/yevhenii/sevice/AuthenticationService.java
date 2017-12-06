package com.yevhenii.sevice;

import com.yevhenii.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    AgentsService service;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Agent agent = service.getByCodeName(s);
        System.out.println(agent);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(agent.getRole()));
        User user = new User(agent.getCodeName(), agent.getPassword(),!agent.getStatus(),true,true,true, authorities);
        System.out.println(user.getAuthorities());
        return user;
    }
}
