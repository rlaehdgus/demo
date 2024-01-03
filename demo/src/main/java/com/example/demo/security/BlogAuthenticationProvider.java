package com.example.demo.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BlogAuthenticationProvider implements AuthenticationProvider {

    private final BlogUserDetailsService blogUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public BlogAuthenticationProvider(BlogUserDetailsService blogUserDetailsService, PasswordEncoder passwordEncoder) {
        this.blogUserDetailsService = blogUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String id = authentication.getName();
        String password = (String)authentication.getCredentials();

        BlogUser user = blogUserDetailsService.loadUserByUsername(id);

        // user 정보 값 체크
        if(user == null) {
            throw new BadCredentialsException("id is not found! => (id: " + id + ")");
        }

        // password 체크
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new BadCredentialsException("password is not matched!");
        }

        return new BlogAuthenticationToken(user.getUserNo(), id, password, user.getAuthorities());
    }

    // 토큰 타입과 일치할 때 인증
    @Override
    public boolean supports(Class<?> authentication) {
        return BlogAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
