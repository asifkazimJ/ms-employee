package az.kapitalbank.msemployee.model.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeRequestDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email
    private String email;
    private String organization;
    private String position;
}
