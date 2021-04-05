package com.sandbox.springcloud.configclient;

import com.sandbox.springcloud.configclient.defaultoauth.DefaultAuthenticationProvider;
import com.sandbox.springcloud.configclient.defaultoauth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * 用于保护oauth相关的endpoints，同时主要作用于用户的登录(form login,Basic auth)
 */
@Configuration
@EnableWebSecurity
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        authenticationProvider = choose();
        /**
         *  注入AuthenticationProvider的两种方式：
         *  第一种：直接定义一个AuthenticationProvider，并标注@Service，执行时会自动注入该AuthenticationProvider
         *  第二种：在此手动指定AuthenticationProvider
         */
         auth.authenticationProvider(authenticationProvider);

        // 如果不注入AuthenticationProvider，也可以注入UserDetailsService
//        auth.userDetailsService(userService);


//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
//                .roles("test");

//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN")
//                .and()
//                .withUser("terry").password("terry").roles("USER")
//                .and()
//                .withUser("larry").password("larry").roles("USER");
    }
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        /*
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .csrf().disable()
            .httpBasic();
        */



        http.csrf().disable();
        http.httpBasic();//.disable();
        http
                .authorizeRequests()
                // 拦截之排除项
                .antMatchers("/about").permitAll()            // anyRequestPass
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()                               // must be hasLogined
                .and()

//                使用默认自带登录界面
                .formLogin()                                                // 默认地址为/login
                .loginPage("/login")
                // 指定了以下内容，登录成功后便不会再跳转至redirect页面
//                  .loginPage("http://www.baidu.com")                        // 可指定一个已写好的登录页面，而不使用自带登录页面。此时，默认的登录界面便不会再出现。当需要认证时，将浏览器重定向到该url，在/login请求时呈现登录页面
//                  .defaultSuccessUrl("http://www.baidu.com")
//                  .successForwardUrl("http://www.baidu.com")
//                  .failureForwardUrl("http://www.baidu.com")
//                  .failureUrl("http://www.baidu.com")
                .and()

//                .formLogin()
//                  .loginPage("/login")
//                  .defaultSuccessUrl("/index")
//                  .usernameParameter("username")
//                  .passwordParameter("password")
//                  .permitAll()
//                  .and()
                // 不使用session
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                  .rememberMe()
//                  //设置cookie有效期
//                  .tokenValiditySeconds(60 * 60 * 24 * 7)
//                  .and()

//                .requiresChannel()
//                .antMatchers()
//                .requiresSecure()
//                .and()

                .logout()
                .logoutSuccessUrl("http://www.baidu.com")
                .permitAll();


//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/favor.ico");
    }

    @Autowired
    @Qualifier("customAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;
    /**
     * 需要配置这个支持password模式
     * support password grant type
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    @Qualifier("customAuthenticationProvider")
//    private AuthenticationProvider customAuthenticationProvider;
//    @Autowired
//    @Qualifier("defaultAuthenticationProvider")
//    private DefaultAuthenticationProvider defaultAuthenticationProvider;


//    @Value(value = "${OAuth.Mode}")
//    String mode;

//    private AuthenticationProvider choose() {
//        AuthenticationProvider provider;
//        String _mode = mode.toLowerCase();
//        switch (_mode) {
//            case "default":
//                provider = defaultAuthenticationProvider;
//                break;
//            case "custom":
//                provider = customAuthenticationProvider;
//                break;
//            default:
//                provider = defaultAuthenticationProvider;
//                break;
//        }
//        return provider;
//    }
}


