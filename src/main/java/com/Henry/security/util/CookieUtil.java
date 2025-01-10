package com.Henry.security.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public void create(
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
        cookie.setPath("/");

        String sameSite = "None"; // None
        String cookieHeader = String.format(
                "%s=%s; Max-Age=%d; Path=%s; HttpOnly; %s; SameSite=%s",
                cookie.getName(),
                cookie.getValue(),
                cookie.getMaxAge(),
                cookie.getPath(),
                secure ? "Secure" : "",
                sameSite
        );
        http.addHeader("Set-Cookie", cookieHeader);
    }

    public void clear(HttpServletResponse http, String name, String domain) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");

        http.addCookie(cookie);
    }
}
