package az.kapitalbank.msemployee.service.impl;

import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.repository.EmployeeRepository;
import az.kapitalbank.msemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository userRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return userRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }
}
