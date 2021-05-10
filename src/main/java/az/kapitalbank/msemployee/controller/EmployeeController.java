package az.kapitalbank.msemployee.controller;

import az.kapitalbank.msemployee.model.dto.EmployeeRequestDto;
import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController{

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllUser() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.addEmployee(employeeRequestDto);
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
