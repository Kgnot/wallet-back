package com.Henry.security.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    private boolean isPresent =false;

    public void create(
            HttpServletResponse http,
            String value,
            String name,
            int exp,
            boolean secure
    ) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(exp);
        cookie.setPath("/");

        String sameSite = "None";
        String cookieHeader = String.format(
                "%s=%s; Max-Age=%d; Path=%s; HttpOnly; Secure; SameSite=%s",
                cookie.getName(),
                cookie.getValue(),
                cookie.getMaxAge(),
                cookie.getPath(),
                sameSite
        );
        http.addCookie(cookie);
        http.addHeader("Set-Cookie", cookieHeader);
        isPresent = true;
    }

    public void clear(HttpServletResponse http, String name, String domain) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");

        http.addCookie(cookie);
        isPresent = false;

    }

    public boolean isCookiePresent(){
        return isPresent;
    }
}
