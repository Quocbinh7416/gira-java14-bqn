package cybersoft.javabackend.girajava14bqn.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncode());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// cấu hình CORS
		http.cors();
		
		// cấu hình session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// disable csrf
		http.csrf().disable();
		
		// cấu hình xác thực cho các api
		http.antMatcher("/**").authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/swagger-ui.html").permitAll()
			.antMatchers("/swagger-ui.html/**").permitAll()
			.antMatchers("/openapi/**").permitAll()
			.antMatchers("/api/**").permitAll()
			.anyRequest().authenticated();
	}
}
