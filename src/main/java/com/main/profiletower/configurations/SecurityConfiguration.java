package com.main.profiletower.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;


    //TODO:Change these from living in application.properties to regular string queries
    // For example:
    // String userQuery = "SELECT ..."
    // String rolesQuery = "SELECT ..."
    // *//


    //TODO:In application.properties you need to changes the query to select username instead of email
    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery) //Change to string
                .authoritiesByUsernameQuery(rolesQuery) //Change to string
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/account/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()//TODO:Check if this is working as it should
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/account/login")
                .failureUrl("/account/login?error=true")
                .defaultSuccessUrl("/")//TODO:Check if this is good or if i want another default after login.
                .usernameParameter("email") //was "email" maybe use username?
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }



    //What resources are allowed to view without login.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/webjars/**");
    }

}
