package az.kapitalbank.msemployee.service;

import az.kapitalbank.msemployee.model.dto.EmployeeRequestDto;
import az.kapitalbank.msemployee.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(EmployeeRequestDto employeeRequestDto);

    Employee getById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployee();
}
