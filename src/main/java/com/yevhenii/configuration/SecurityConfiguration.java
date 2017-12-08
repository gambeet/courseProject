package com.yevhenii.configuration;

import com.yevhenii.sevice.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by Yevhenii on 13.11.2017.
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity config) throws Exception{
        config
                .authorizeRequests()
                .antMatchers("/countries/**").access("hasRole('ROLE_ADMIN')")
//              "hasRole('ROLE_ADMIN') or hasRole('ROLE_AGENT')"
//                .antMatchers("/agents/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/stolendocs/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/countries/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/me").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll().invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("kunLao").password("qwerty").roles("AGENT")
//                .and()
//                .withUser("gambeet").password("password").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
