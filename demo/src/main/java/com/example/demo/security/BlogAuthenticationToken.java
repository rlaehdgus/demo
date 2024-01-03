package com.example.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class BlogAuthenticationToken extends AbstractAuthenticationToken {
	private Long userNo;
    private String id;
    private String credentials;

    public BlogAuthenticationToken(Long userNo, String id, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.userNo = userNo;
        this.id = id;
        this.credentials = credentials;
    }

    public BlogAuthenticationToken(String id, String credentials) {
        super(null);
        this.id = id;
        this.credentials = credentials;
    }

    public BlogAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.id;
    }
}
