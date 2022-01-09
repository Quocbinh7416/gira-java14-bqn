package cybersoft.javabackend.girajava14bqn.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14bqn.common.ResponseHandler;
import cybersoft.javabackend.girajava14bqn.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14bqn.user.service.UserService;

@RestController
public class UserControllerImpl implements UserController{
	private UserService service;
	
	@Override
	public ResponseEntity<Object> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid CreateUserDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST) ;
		}
		
		CreateUserDTO createUser = service.create(dto);
		
		return ResponseHandler.getResponse(createUser, HttpStatus.OK);
	}


}
