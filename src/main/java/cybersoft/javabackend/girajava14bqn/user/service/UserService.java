package cybersoft.javabackend.girajava14bqn.user.service;

import javax.validation.Valid;

import cybersoft.javabackend.girajava14bqn.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14bqn.user.model.User;

public interface UserService {
	public User getUserByid(long id);

	public CreateUserDTO create(@Valid CreateUserDTO dto);
}
