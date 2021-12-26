package cybersoft.javabackend.girajava14bqn.role.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.girajava14bqn.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14bqn.role.model.Role;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

}
