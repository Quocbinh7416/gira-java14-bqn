package cybersoft.javabackend.girajava14bqn.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.girajava14bqn.common.ResponseHandler;

@RestControllerAdvice
public class RoleHandlerException {
	
	@ExceptionHandler(InvalidRoleException.class)
	public Object handleInvalidRoleException(InvalidRoleException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
