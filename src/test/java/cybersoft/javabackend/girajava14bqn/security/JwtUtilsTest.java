package cybersoft.javabackend.girajava14bqn.security;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cybersoft.javabackend.girajava14bqn.security.dto.CustomUserDetails;
import cybersoft.javabackend.girajava14bqn.security.jwt.JwtUtils;

@SpringBootTest
public class JwtUtilsTest {
	
	@Autowired
	private JwtUtils utils;
	
	private Authentication validAuth;
	private Authentication invalidAuth;
	
	@BeforeAll
	public void setupTest() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UserDetails user = new CustomUserDetails("testadmin", "testadmin", authorities);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(
				user, 
				null, 
				null);
	}
	
	@Test
	public void shouldInjectJwtUtilSeccessfullly() {
		assertThat(utils).isNotNull();
	}
	
	@Test
	public void shouldGenerateJwtTokenSuccessfully() {
		String token = utils.generateJwtToken(validAuth);
		
		assertThat(token).isNotNull();
		
	}
	
	@Test
	public void shouldThrowExceptionWhileGeneratingJwtToken() {
		
//		assertThrows(NullPointerException.class, () -> {
//			utils.generateJwtToken(invalidAuth);
//		});
	}
	
	@Test
	public void shouldValidateCorrectToken() {
		String token = "123";
		
		assertThat(utils.validateJwtToken(token)).isEqualTo(false);
	}
}
