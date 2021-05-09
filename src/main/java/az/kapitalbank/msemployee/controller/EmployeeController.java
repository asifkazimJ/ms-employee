package az.kapitalbank.msemployee.controller;

import az.kapitalbank.msemployee.model.entity.Employee;
import az.kapitalbank.msemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController{

    private final EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllUser() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
