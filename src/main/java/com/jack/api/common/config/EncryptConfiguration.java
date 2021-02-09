//package com.jack.api.common.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
////@EnableWebSecurity
//public class EncryptConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
////
////    @Override
////    protected UserDetailsService userDetailsService() {
//////        return new Bytree
////    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq")
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser("sang")
//                .password("$2a$10$eUHbAOMq4bpxTvOVz33LIehLe3fu6NwqC9tdOcxJXEhyZ4simqXTC")
//                .roles("USER");
//    }
//}
