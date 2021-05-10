package az.kapitalbank.msemployee.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

}
