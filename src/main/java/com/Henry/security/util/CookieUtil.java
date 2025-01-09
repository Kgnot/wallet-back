package com.Henry.security.util;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {


    public  void create(
            HttpServletResponse http,
            String value,
            String name,
            String domain,
            int exp,
            boolean secure
    ) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(exp);
        cookie.setDomain(domain);
        cookie.setPath("/");
        http.addCookie(cookie);
    }

    public void clear(HttpServletResponse http, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        http.addCookie(cookie);
    }
}
