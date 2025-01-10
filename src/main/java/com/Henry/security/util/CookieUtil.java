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
        cookie.setDomain(domain);

        String sameSite = "None"; // None
        String cookieHeader = String.format(
                "%s=%s; Max-Age=%d; Path=%s; Domain=%s; HttpOnly; Secure; SameSite=%s",
                cookie.getName(),
                cookie.getValue(),
                cookie.getMaxAge(),
                cookie.getPath(),
                cookie.getDomain(),
                sameSite
        );
        http.addCookie(cookie);
        http.addHeader("Set-Cookie", cookieHeader);
    }

    public void clear(HttpServletResponse http, String name, String domain) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setDomain(domain);

        String sameSite = "None"; // None
        String cookieHeader = String.format(
                "%s=; Max-Age=0; Path=%s; Domain=%s; HttpOnly; Secure; SameSite=%s",
                cookie.getName(),
                cookie.getPath(),
                cookie.getDomain(),
                sameSite
        );
        http.addCookie(cookie);
        http.addHeader("Set-Cookie", cookieHeader);
    }
}
