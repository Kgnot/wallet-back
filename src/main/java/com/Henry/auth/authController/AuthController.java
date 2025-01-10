package com.Henry.auth.authController;


import com.Henry.auth.services.AuthService;
import com.Henry.auth.utils.LoginRequest;
import com.Henry.auth.utils.RegisterRequest;
import com.Henry.security.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CookieUtil cookieUtil;

    /* Apartado de autenticación em cookies : */
    @Value("${jwt.cookie.expiration}")
    private int exp;
    @Value("${domain}")
    private String domain;
    @Value("${jwt.cookie.name}")
    private String cookieName;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        String jwt = authService.login(request).getToken();
        // Aquí creamos el cookie:
        cookieUtil.create(
                response,
                jwt,
                cookieName,
                domain,
                exp,
                true
        );
        return ResponseEntity.ok().body("{\"message\": \"login successful\"}");
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request, HttpServletResponse response) {
        String jwt = authService.register(request).getToken();
        //cookieUtil.clear(response, cookieName,domain); // primero limpiamos

        cookieUtil.create(
                response,
                jwt,
                cookieName,
                domain,
                exp,
                true);
        return ResponseEntity.ok().body("{\"message\": \"sign in successful\"}");
    } // Estó también toca cambiarlo.

    @GetMapping("check-auth")
    public boolean checkAuth(HttpServletRequest request) {
        return isCookiePresent(request);//? ResponseEntity.ok("Authenticated") : ResponseEntity.status(401).body("Not Authenticated")
    }

    @GetMapping("logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        cookieUtil.clear(response, cookieName,domain);

        return ResponseEntity.ok().body("\"message:\": \"Logout\" ");
    }


    private boolean isCookiePresent(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        return cookie == null ? false : true;
    }


}
