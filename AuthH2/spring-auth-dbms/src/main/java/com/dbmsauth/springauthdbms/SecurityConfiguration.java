package com.dbmsauth.springauthdbms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource datasource; //Default Data Source, this tells where datasource is and we need to have an instance of data source.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.jdbcAuthentication()
                .dataSource(datasource);

        // auth.jdbcAuthentication() // some configuration we need to do here. Hey I have user info in db and look up there!
        //         .dataSource(datasource) // Takes in defalut datasource i.e embedded
        //         .withDefaultSchema()
        //         .withUser(
        //             User.withUsername("user")
        //             .password("pass")
        //             .roles("USER")
        //         )
        //         .withUser(
        //             User.withUsername("admin")
        //             .password("pass")
        //             .roles("ADMIN")
        //         );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    
}