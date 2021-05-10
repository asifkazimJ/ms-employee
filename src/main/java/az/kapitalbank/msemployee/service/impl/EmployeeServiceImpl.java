package az.kapitalbank.msemployee.service.impl;

import az.kapitalbank.msemployee.error.DuplicateRecordException;
import az.kapitalbank.msemployee.error.EmployeeNotFoundException;
import az.kapitalbank.msemployee.error.ErrorCode;
import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.repository.EmployeeRepository;
import az.kapitalbank.msemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employeeDto) {
        Employee employee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (employee != null) {
            throw new DuplicateRecordException(ErrorCode.DUPLICATE_RECORD, "Email id already exist");
        }
        return employeeRepository.save(employeeDto);
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
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
