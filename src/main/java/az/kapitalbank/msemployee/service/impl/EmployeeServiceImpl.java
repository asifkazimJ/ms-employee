package az.kapitalbank.msemployee.service.impl;

import az.kapitalbank.msemployee.error.DuplicateRecordException;
import az.kapitalbank.msemployee.error.EmployeeNotFoundException;
import az.kapitalbank.msemployee.error.ErrorCode;
import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.repository.EmployeeRepository;
import az.kapitalbank.msemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        log.info("Employee adding request, employee:{}",employee);
        Employee existEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (existEmployee != null) {
            log.info("Email is already exist, email:{}",employee.getEmail());
            throw new DuplicateRecordException(ErrorCode.DUPLICATE_RECORD, "Email is already exist");
        }
        log.info("Employee adding successfully, employee:{}",employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        log.info("Find Employee by id , id : {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        ErrorCode.EMPLOYEE_NOT_FOUND, "Employee not found in our records!")
                );
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        log.info("Employee update request, employee:{}",employee);
        Employee existEmployee = employeeRepository.findById(employee.getEmpId())
                .orElseThrow(() -> new EmployeeNotFoundException(
                        ErrorCode.EMPLOYEE_NOT_FOUND, "Employee not found in our records!")
                );
        existEmployee.setName(employee.getName());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setSurname(employee.getSurname());
        existEmployee.setOrganization(employee.getOrganization());
        existEmployee.setPosition(employee.getPosition());
        log.info("Employee adding successfully, employee:{}",employee);
        return employeeRepository.save(existEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Employee record deleting for id={}", id);
        try {
            employeeRepository.deleteById(id);
        } catch(EmptyResultDataAccessException ex) {
            throw new EmployeeNotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND, "Employee not found in our records !");
        }
        log.info("Employee record deleted for id={}", id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
