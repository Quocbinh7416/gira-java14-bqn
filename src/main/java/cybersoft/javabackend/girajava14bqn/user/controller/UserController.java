package cybersoft.javabackend.girajava14bqn.user.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.girajava14bqn.user.dto.CreateUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "userController", description = "user api")
public interface UserController {
	@Operation(method = "get", description = "get all user")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get users successfully"),
			@ApiResponse(responseCode = "403", description = "do not have correct authorization")
	})
	@GetMapping(value = "/api/users", produces = "application/json")
	public ResponseEntity<Object> getUsers();
	
	@Operation(method = "post", description = "create new user")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "invalid user"),
		@ApiResponse(responseCode = "200", description = "created")
	})
	@PostMapping(value="/api/user")
	public ResponseEntity<Object> createUser(
			@Parameter(description = "user dto") @Valid @RequestBody CreateUserDTO dto,
				BindingResult bindingResult
				);
}
