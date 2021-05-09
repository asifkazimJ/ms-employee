package az.kapitalbank.msemployee.service;

import az.kapitalbank.msemployee.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployee();
}
