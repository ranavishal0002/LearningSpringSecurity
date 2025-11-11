//package com.example.SpringSecurity.filters;
//
//import com.example.SpringSecurity.service.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        final String requestTokenHeader = request.getHeader("Authorization");
//        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = requestTokenHeader.substring(7); // Remove "Bearer " prefix
//        Long userId = jwtService.getUserIdFromToken(token.trim());
//
//        if(userId!=null){
//            // Token is valid, continue with the filter chain
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
//
//
