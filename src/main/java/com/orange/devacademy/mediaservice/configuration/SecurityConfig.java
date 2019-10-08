package com.orange.devacademy.mediaservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.orange.devacademy.mediaservice.configuration.MediaConstants.API_V1;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String API_ENDPOINT =  API_V1 + "/**";
    private static final String[] ENDPOINTS_NOAUTH = {
            API_V1 + "/status",
            API_V1 + "/version",
            API_V1 + "/doc",
            "/register",
            "/login",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security"};

    private static final String[] IGNORE_RESOURCES = {"**/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();

        http.authorizeRequests()
                .antMatchers(ENDPOINTS_NOAUTH)
                .permitAll();

        http.authorizeRequests()
                .antMatchers(API_ENDPOINT)
                .authenticated();

        http.httpBasic();
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("gigi")
//                .password(passwordEncoder().encode("gigi"))
//                .authorities("USER");
//    }

}
