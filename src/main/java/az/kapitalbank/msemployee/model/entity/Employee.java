package az.kapitalbank.msemployee.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private Long empId;
    private String name;
    private String surname;
    private String email;
    private String organization;
    private String position;

}
