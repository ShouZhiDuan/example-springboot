package com.example.dsz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/7 10:27
 * @Description: cookie与session对比：http://www.woshipm.com/pd/864133.html
 */
@RestController
@RequestMapping("/cookie")
public class CookieController {


    @GetMapping("/testRequest")
    public Object testRequest(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.println("name = " + cookie.getName() + " & value = " + cookie.getValue());
            }
            return cookies;
        }
        return "当前请求没有cookie信息";
    }

    @GetMapping("/testResponse")
    public Object testResponse(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("dsz", "18");
        cookie.setMaxAge(30);//设置失效时间
        response.addCookie(cookie);//设置响应出去的cookie
        cookie.setPath("/");//设置同一个Tomcat服务器中部署，了多个web项目，那么这些web项目的cookie能共享。
        cookie.setDomain(".baidu.com");//那么所有的*.baidu.com
        return cookie;
    }


}
