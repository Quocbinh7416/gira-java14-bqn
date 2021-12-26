package cybersoft.javabackend.girajava14bqn.role.service;

import java.util.List;

import cybersoft.javabackend.girajava14bqn.role.dto.RoleDTO;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

}
