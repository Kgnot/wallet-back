package com.Henry.security.jwt;

import com.Henry.auth.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilters extends OncePerRequestFilter {
    // OncePerRequestFilter es una clase abstracta la cual nos ayuda a establecer filtros personalizados
    // Necesitamos añadir los servicios entonces:

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Value("${jwt.cookie.name}")
    private String cookieName;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Vamos a obtener el token:
        final String token = getTokenFromCookies(request);
        final String email;
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        // si el token no es nulo entonces obtendremos el email: [que en este caso seria nuestro username]
        email = jwtService.getUserNameFromToken(token);
        //si llega a ser que el email no es nulo y no esta en el contexto de seguridad entonces debemos validar:
        if(email!= null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if(jwtService.isTokenValid(token,userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);



        return cookie == null ? null : cookie.getValue();
    }

}
