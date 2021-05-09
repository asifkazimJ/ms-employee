package az.kapitalbank.msemployee.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USR_TBL")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;

}
