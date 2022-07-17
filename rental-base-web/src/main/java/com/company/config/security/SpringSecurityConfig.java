package com.company.config.security;

import com.company.config.security.detailservice.CustometUserDetailService;
import com.company.config.security.filter.CheckTokenFilter;
import com.company.config.security.handler.CustomAccessDeineHandler;
import com.company.config.security.handler.LoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SpringSecurityConfig
 * @company 公司
 * @Description SpringSecurity配置类
 * @Configuration 表明该类是一个配置类
 * @EnableWebSecurity 启用SpringSecurity 注解
 * @EnableGlobalMethodSecurity(prePostEnabled = true) 启用SpringSecurity 注解
 * @createTime 2022年07月10日 09:01:01
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustometUserDetailService custometUserDetailService;
    @Autowired
    private CustomAccessDeineHandler customAccessDeineHandler;

    @Autowired
    private CheckTokenFilter checkTokenFilter;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 解决跨域问题
        http.cors().and().headers().frameOptions().disable();
        http.addFilterBefore(checkTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 除了/api/user/login请求之外的所有请求都需要权限验证
        //  关闭跨域请求伪点
        http.csrf().disable()
        //基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //放行登录请求,其他的所有请求都要认证
                .antMatchers("/api/user/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(loginFailureHandler)
                .accessDeniedHandler(customAccessDeineHandler);
    }

    /**
     * 注入AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置我们自定义的UserDetails
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(custometUserDetailService);
    }
}
