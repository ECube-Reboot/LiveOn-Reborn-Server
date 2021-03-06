package com.twoCube.auth.Token;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    private final TokenService tokenService;

    // 실제 필터링 로직은 doFilterInternal 에 들어감
    // JWT 토큰의 인증 정보를 현재 쓰레드의 SecurityContext 에 저장하는 역할 수행
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("getting token");

        // 1. Request Header 에서 토큰을 꺼냄
        String jwt = resolveToken(request);

        log.debug(String.valueOf(request));

        // 2. validateToken 으로 토큰 유효성 검사
        // 정상 토큰이면 해당 토큰으로 Authentication 을 가져와서 SecurityContext 에 저장
        if (StringUtils.hasText(jwt) && tokenService.verifyToken(jwt)) {

            System.out.println("Normal jwt");

            Authentication authentication = tokenService.getAuthentication(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    // Request Header 에서 토큰 정보를 꺼내오기
    private String resolveToken(HttpServletRequest request) {
        System.out.println("resolvinb");

        Enumeration eHeader = request.getHeaderNames();
        while (eHeader.hasMoreElements()) {
            String request_Name = (String)eHeader.nextElement();
            String request_Value = request.getHeader(request_Name);
            System.out.println("request_Name : " + request_Name + " | request_Value : " + request_Value);
        }

        System.out.println(request.getHeader("jwt"));

        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        System.out.println(bearerToken);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            System.out.println("success");
            return bearerToken.substring(7);
        }
        log.debug("don'thave");
        return null;
    }
}
