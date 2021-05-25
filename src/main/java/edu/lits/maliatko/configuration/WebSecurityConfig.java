package edu.lits.maliatko.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.parentAuthenticationManager(authenticationManagerBean())
        .userDetailsService(jwtUserDetailsService);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationConfigurer) throws Exception {
        authenticationConfigurer
                .userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login",
                        "/",
                        "/css/*",
                        "/js/*",
                        "/img/*",
                        "/registration",
                        "/addKidToList",

                        "/management/*",

                        "/creating_groups",
                        "/payment/list",
                        "/queue",
                        "/info-kid-id",
                        "/visiting",
                        "/visitingCheck",
                        "/swagger-ui.html/*",
                        "/rest/*",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/configuration/ui",
                        "/swagger-resources/configuration/security",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**",
                        "favicon.ico",
                "/json/kindergartenList")
                .permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(jwtAuthenticationEntryPoint, new CustomRequestMatcher(AUTH_LIST))
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.cors();

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    private static final List<String> AUTH_LIST = Arrays.asList(
            "/swagger-resources/**",
            "/swagger-ui.html**",
            "/webjars/**",
            "favicon.ico");

    @Bean
    public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Swagger Realm");
        return entryPoint;
    }

    private class CustomRequestMatcher implements RequestMatcher {

        private List<AntPathRequestMatcher> matchers;

        private CustomRequestMatcher(List<String> matchers) {
            this.matchers = matchers.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList());
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            return matchers.stream().anyMatch(a -> a.matches(request));
        }

    }


}