package com.example.demo.config;

import com.example.demo.security.BlogAuthenticationFilter;
import com.example.demo.security.BlogAuthenticationProvider;
import com.example.demo.security.BlogUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private BlogUserDetailsService blogUserDetailsService;
//    private PasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        // static 디렉토리의 하위 파일 목록은 인증 무시
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/admin/css/**", "/admin/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .addFilterAfter(blogAuthenticationFilter(), CsrfFilter.class)
                .authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/blog/main").permitAll()
                .antMatchers("/**").authenticated()
                .and()
            // 로그인 설정
            .formLogin()
                .loginPage("/member/login")
//                .defaultSuccessUrl("/blog/list")
                .usernameParameter("id")
                .permitAll()
                .and()
            //로그아웃 설정
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//                .logoutSuccessUrl("/blog/list")
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public BlogAuthenticationFilter blogAuthenticationFilter() throws Exception {
        BlogAuthenticationFilter filter = new BlogAuthenticationFilter(
                new AntPathRequestMatcher("/member/log*", HttpMethod.POST.name())
        );
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/blog/list"));
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/member/login"));
        return filter;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new BlogAuthenticationProvider(blogUserDetailsService, bCryptPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
