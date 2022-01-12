package cybersoft.javabackend.girajava14bqn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cybersoft.javabackend.girajava14bqn.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14bqn.user.dto.UserMapper;
import cybersoft.javabackend.girajava14bqn.user.model.User;

@SpringBootTest
public class UserMapperTest {
	@Test
	public void shouldMaperCreateUserDtoToUserEntity() {
		CreateUserDTO dto = new CreateUserDTO();
		dto.setUsername("user123");
		dto.setEmail("example@example.com");
		dto.setPassword("P123456");
		dto.setFullname("MrExample");
		
		User user = UserMapper.INSTANCE.createUserDtoToUserEntity(dto);
		
		assertThat(user.getUsername()).isEqualTo(dto.getUsername());
		assertThat(user.getPassword()).isEqualTo(dto.getPassword());
		assertThat(user.getEmail()).isEqualTo(dto.getEmail());
		assertThat(user.getFullname()).isEqualTo(dto.getFullname());
	}
	
	@Test
	public void shouldMaperUserEntityToCreateUserDto() {
		User user = new User();
		user.setUsername("user123");
		user.setEmail("example@example.com");
		user.setPassword("P123456");
		user.setFullname("MrExample");
		
		CreateUserDTO dto = UserMapper.INSTANCE.userEntityToCreateUserDTO(user);
		
		assertThat(user.getUsername()).isEqualTo(dto.getUsername());
		assertThat(user.getPassword()).isEqualTo(dto.getPassword());
		assertThat(user.getEmail()).isEqualTo(dto.getEmail());
		assertThat(user.getFullname()).isEqualTo(dto.getFullname());
	}
}
