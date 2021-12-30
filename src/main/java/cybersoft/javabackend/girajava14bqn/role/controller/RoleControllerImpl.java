package cybersoft.javabackend.girajava14bqn.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14bqn.common.ResponseHandler;
import cybersoft.javabackend.girajava14bqn.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14bqn.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.girajava14bqn.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController{
	private RoleService service;
	
	public RoleControllerImpl(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public ResponseEntity<Object> getRole() {
		List<RoleDTO> roles = service.findAllDTO();
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(RoleDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST) ;
		}
		
		RoleDTO createRole = service.create(dto);
		
		return ResponseHandler.getResponse(createRole, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateRole(long id, @Valid UpdateRoleDTO dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST) ;
		}
		
		RoleDTO updatedRole = service.updateRole(id, dto);
		
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteRole(long id) {
		
		service.deleteRole(id);
		
		return ResponseHandler.getResponse("Delete role successully", HttpStatus.OK);
	}

	
}
