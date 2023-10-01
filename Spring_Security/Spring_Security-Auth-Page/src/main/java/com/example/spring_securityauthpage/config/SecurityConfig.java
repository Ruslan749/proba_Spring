package com.example.spring_securityauthpage.config;

import com.example.spring_securityauthpage.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonDetailsService personDetailsService;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }
    // говорим спринг исмпользовать собственую странцу аутентификации
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        //конфигурируем сам spring security (вход, ошибки и т.д)
        // конфигурируем авторизацию

        http.csrf().disable() // отключаем защиту от меж сайтовой потделки запросов
                .authorizeRequests() // включаем настройки для авторизтрованых и не авторизированых пользователей
                .antMatchers("/auth/login", "/error").permitAll() // пускать всех не авторизированых пользователей на эти страницы
                .anyRequest().authenticated() // указываем что на все остальные страницы можно попасть после авторизации
                .and() // заканчиваем настройку авторизации
                .formLogin().loginPage("/auth/login") // какую подключить форму
                .loginProcessingUrl("/process_login") // с какого адреса забрать данные
                .defaultSuccessUrl("/hello",true) // на какую страницу вести после аутентификации
                .failureUrl("/auth/login?error"); // куда будет вести в случае неудачной аутентификации

    }

    // настраивает аутентификацию
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService);
    }
    // указываем с каким алгоритмом будем проводить шифрование
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
