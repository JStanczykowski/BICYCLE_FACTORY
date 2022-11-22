package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.service.UserService;

import java.net.URL;

@Configuration
@EnableWebSecurity
@Profile("!https")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(
				"/registration**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll();
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/h2/**").permitAll()
				.antMatchers("/admin/").hasRole("ADMIN")
				.antMatchers("/index.html").hasRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/worker", true)
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf()
//				.disable()
//				.authorizeRequests()
//				.antMatchers("/index.html")
//				.hasRole("ROLE_USER")
//				.antMatchers("/menago.html")
//.anonymous()
//				.antMatchers("/login*")
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login.html")
//				.loginProcessingUrl("/login.html")
//				.defaultSuccessUrl("/login.html", true)
//				// .failureUrl("/login.html?error=true")
//
//				.and()
//				.logout()
//				.logoutUrl("/logout")
//				.deleteCookies("JSESSIONID")	;
//
//		// .and()
//		// .exceptionHandling().accessDeniedPage("/accessDenied");
//		// .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
//		return http.build();
//
//	}
}
