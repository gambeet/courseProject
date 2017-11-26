//package com.yevhenii.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by Yevhenii on 13.11.2017.
// */
////@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity config) throws Exception{
//        config
//                .authorizeRequests()
//                .antMatchers("/countries").permitAll()
//                .antMatchers("/countries/add").hasRole("ADMIN")
//                .and()
//                .formLogin().loginPage("/login").defaultSuccessUrl("/countries/add").permitAll()
//                .and()
//                .logout().logoutUrl("/logout").permitAll().invalidateHttpSession(true);
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception{
//        builder.authenticationProvider();
//        //builder.inMemoryAuthentication().withUser("mainEditor").password("passpass").roles("ADMIN");
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//}
