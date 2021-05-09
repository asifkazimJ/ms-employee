package az.kapitalbank.msemployee.service.impl;

import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.repository.EmployeeRepository;
import az.kapitalbank.msemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
