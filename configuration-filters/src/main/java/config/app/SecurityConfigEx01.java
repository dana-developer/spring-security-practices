package config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigEx01 {
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return new WebSecurityCustomizer() {
			@Override
			public void customize(WebSecurity web) {
				web.ignoring().requestMatchers(new AntPathRequestMatcher("/assets/**"));
			}
		};
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    	http.formLogin().loginPage("/login").successUrl("/"); 이전방식(세세하게 연결해서 설정하는 방식)
//    	http
//    		.formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
//
//				@Override
//				public void customize(FormLoginConfigurer<HttpSecurity> t) {
//					
//					
//				}
//    		});
//		http.formLogin((formLogin) -> {
//			formLogin
//				.loginPage("/user/login")
//				.usernameParameter("email")
//				.loginProcessingUrl("/");
//		});
		http.formLogin((formLogin) -> {});
		return http.build();
	}
}
