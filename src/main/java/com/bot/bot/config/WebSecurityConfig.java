package com.bot.bot.config;

import com.bot.bot.model.Accounts;
import com.bot.bot.repo.AccountsBotRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.RequestEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;


@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/", "/bot/ask").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }



    @Bean
    public PrincipalExtractor principalExtractor(AccountsBotRepository accountsBotRepository) {
        return map -> {
                String id = (String) map.get("id");
                Accounts accounts = accountsBotRepository.findById(id).orElseGet(() -> {
                    Accounts newAccounts = new Accounts();
                    newAccounts.setId(id);
                    newAccounts.setDiscordName((String) map.get("username"));
                    newAccounts.setKeyBot("none");
                    newAccounts.setStatus("Offline");
                    return newAccounts;
                });

                accountsBotRepository.save(accounts);
                return accounts;

            };

    }

}






