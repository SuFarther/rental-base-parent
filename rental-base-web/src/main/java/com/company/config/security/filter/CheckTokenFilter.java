package com.company.config.security.filter;

import com.alibaba.druid.util.StringUtils;
import com.company.config.jwt.JwtUtils;
import com.company.config.security.detailservice.CustometUserDetailService;
import com.company.config.security.exception.CustomerAuthenionException;
import com.company.config.security.handler.LoginFailureHandler;
import io.jsonwebtoken.Claims;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**@author  苏东坡
 * @version 1.0
 * @ClassName CheckTokenFilter
 * @company 公司
 * @Description token验证过滤器
 * @createTime 2022年07月11日 06:47:47
 */
@Data
@Component("checkTokenFilter")
public class CheckTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CustometUserDetailService custometUserDetailService;
    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Value("${company.loginUrl}")
    private String loginUrl;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            //获取请求url
            String url = httpServletRequest.getRequestURI();
            //token验证，登录请求、验证码请求不做token验证
            if(!url.equals(loginUrl)){
                //验证码不需要token验证
                validateToken(httpServletRequest);
            }
        }catch (AuthenticationException e){
            loginFailureHandler.commence(httpServletRequest,httpServletResponse,e);
            return;
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    //token验证
    private void validateToken(HttpServletRequest request){
        //从头部获取token
        String token = request.getHeader("token");
        //如果从头部获取token失败，那么从参数获取
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        //如果没有获取到token
        if(StringUtils.isEmpty(token)){
            throw new CustomerAuthenionException("token获取失败！");
        }
        //解析token
        String username = jwtUtils.getUsernameFromToken(token);
        if(StringUtils.isEmpty(username)){
            throw new CustomerAuthenionException("token解析失败！");
        }
        // 获取用户类型
        Claims claimsFromToken = jwtUtils.getClaimsFromToken(token);

        //获取用户信息，交给spring security
        UserDetails details = custometUserDetailService.loadUserByUsername(username+":"+claimsFromToken.get("userType"));
        if(details == null){
            throw new CustomerAuthenionException("token解析失败！");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details,null,details.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        //设置到spring security上下文
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}