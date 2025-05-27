package itis.oris_hw02.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.aspectj.weaver.patterns.ExactTypePattern;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityFilterChain configureFilter(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requsts) -> requsts
//                        .requestMatchers("/**").permitAll()
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/signIn")
//                        .loginProcessingUrl("/signIn")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/signIn?error=true")
//                )
//                .build();
//        return http.build();
//    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                //остальные ссылки
                .antMatchers("/**").permitAll()

                //проверка на роль
                .antMatchers("/users").hasAnyAuthority("ADMIN")
                //закончили
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/user")
                .failureUrl("/signIn?error")
                .permitAll();
    }
}
