package com.hero.league.config;

import com.hero.league.entity.Users;
import com.hero.league.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Autowired
    private UsersMapper usersMapper;

    @Bean
    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password("admin").roles("").build());
//        manager.createUser(User.withUsername("guest").password("guest").roles("").build());
//        return manager;

        return username -> {
            Users users = usersMapper.getUserByUsername(username);
            if (users == null) {
                throw new UsernameNotFoundException("用户名未找到");
            }
            String password = users.getUserPassword();
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String passwordAfterEncoder = passwordEncoder.encode(password);
            return User.withUsername(username).password(passwordAfterEncoder).roles("").build();
        };
    }
}
