package com.newlight77.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableOAuth2Sso
@Order(-100)
@SpringBootApplication(scanBasePackages="com.newlight77")
public class AdminApplication extends WebSecurityConfigurerAdapter {

  private final Logger LOGGER = LoggerFactory.getLogger(AdminApplication.class);

  public static void main(String[] args) throws Exception {
    SpringApplication.run(AdminApplication.class, args);
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);

    //@formatter:off
    web.ignoring()
            .mvcMatchers("/favicon.ico", "/webjars/**", "/css/**");
    //@formatter:on
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //@formatter:off
    http
            .antMatcher("/**")
            .requestMatchers()
            .antMatchers(
                    "/", // permitAll()
                    "/login", // authenticated()
                    "/api/unsecure/**",
                    "/me" // authenticated() = true
            )
            .and()
            .authorizeRequests()
            .antMatchers(
                    "/", // permitAll()
                    "/api/unsecure/**"
            )
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
    ;

    //@formatter:on

  }

  private Filter csrfHeaderFilter() {
    return new OncePerRequestFilter() {
      @Override protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
              ServletException,
              IOException {
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
          Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
          String token = csrf.getToken();
          if (cookie == null || token != null && !token.equals(cookie.getValue())) {
            cookie = new Cookie("XSRF-TOKEN", token);
            cookie.setPath("/");
            response.addCookie(cookie);
          }
        }
        filterChain.doFilter(request, response);
      }
    };
  }

  private CsrfTokenRepository csrfTokenRepository() {
    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    repository.setHeaderName("X-XSRF-TOKEN");
    return repository;
  }

}
