package com.wang.community.controller;

import com.wang.community.dto.AccessTokenDTO;
import com.wang.community.dto.GithubUser;
import com.wang.community.model.User;
import com.wang.community.provider.GithubProvider;
import com.wang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);

        if (githubUser != null && githubUser.getId() != null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
//            user.setGmtCreate(System.currentTimeMillis());
//            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", token));
//            // 获得session，用于显示登录后的个人信息
//            request.getSession().setAttribute("githubUser", githubUser);
        } else {
            // 登录失败，重新登录
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
