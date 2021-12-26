package cybersoft.javabackend.girajava14bqn.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.girajava14bqn.role.validation.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
	private long id;
	
	@NotBlank(message = "{role.name.not-blank}")
	@UniqueRoleName
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	private String code;
	
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
}
