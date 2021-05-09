package az.kapitalbank.msemployee.repository;

import az.kapitalbank.msemployee.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}


