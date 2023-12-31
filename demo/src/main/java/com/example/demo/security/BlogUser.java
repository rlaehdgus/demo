package com.example.demo.security;

import com.example.demo.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

// lombok 사용
// Security 에서 사용되는 User 에서 파라미터를 추가함.
//@Data         // constructor 도중 에러가 발생하므로 사용하지 않음
public class BlogUser extends User implements UserDetails, CredentialsContainer {
    private static final long serialVersionUID = 3718162515893387291L;

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public BlogUser(User user) {
    	setUserNo(user.getUserNo());
    	setUserName(user.getUserName());
    	setUserId(user.getUserId());
    	setUserEmail(user.getUserEmail());
    	setUserPhone(user.getUserPhone());
    	setUserAddr(user.getUserAddr());
    	setUserGender(user.getUserGender());
    	setRegDt(user.getRegDt());
    	setUpdDt(user.getUpdDt());
    	
    	
//        setM_seq(user.getM_seq());
//        setName(user.getName());
//        setId(user.getId());
//        setPassword(user.getPassword());
//        setAddress(user.getAddress());
//        setPhone(user.getPhone());
//        setGender(user.getGender());
//        setAuth_type(user.getAuth_type());
//        setCre_dt(user.getCre_dt());
//        setUpd_dt(user.getUpd_dt());
        this.username = getUserId();
        this.password = user.getUserPwd();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("MEMBER");
        this.authorities = Collections.singletonList(grantedAuthority);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public void eraseCredentials() {
        this.password = null;
    }
    @Override
    public String toString() {
        return getUsername();
    }
}