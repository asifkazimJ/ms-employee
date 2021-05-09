package az.kapitalbank.msemployee.service;

import az.kapitalbank.msemployee.model.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getById(Long id);
}
