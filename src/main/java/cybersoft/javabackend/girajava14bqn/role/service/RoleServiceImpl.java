package cybersoft.javabackend.girajava14bqn.role.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14bqn.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14bqn.role.model.Role;
import cybersoft.javabackend.girajava14bqn.role.repository.RoleRepository;
import cybersoft.javabackend.girajava14bqn.role.util.RoleConverter;

@Service
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		repository = roleRepository;
	}
	
	@Override
	public List<RoleDTO> findAllDTO() {
		List<Role> roles = repository.findAll();
		
		return RoleConverter.toRoleDTOs(roles);
	}

	@Override
	public RoleDTO create(RoleDTO dto) {
		Role role = RoleConverter.toRole(dto);
		
		Role createdRole = repository.save(role);
		
		return RoleConverter.toRoleDTO(createdRole);
	}

	@Override
	public Optional<Role> findByName(String roleName) {
		return repository.findByName(roleName);
	}

}
