package cybersoft.javabackend.girajava14bqn.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.girajava14bqn.user.model.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User createUserDtoToUserEntity(CreateUserDTO dto);
	
	CreateUserDTO userEntityToCreateUserDTO(User user);
}
