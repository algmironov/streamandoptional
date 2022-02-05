package pro.skystudent.streamandoptional.service.impl;

import org.springframework.stereotype.Service;
import pro.skystudent.streamandoptional.data.Employee;
import pro.skystudent.streamandoptional.exceptions.EmployeeIsMissingException;
import pro.skystudent.streamandoptional.service.DepartmentService;
import pro.skystudent.streamandoptional.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMinSalaryInDepartment (int departmentId){
        return employeeService.printAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeIsMissingException("Employee not found"));
    }

    @Override
    public Employee findEmployeeWithMaxSalaryInDepartment ( int departmentId){
        return employeeService.printAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeIsMissingException("Employee not found"));
    }

    @Override
    public Collection<Employee> printEmployeesFromDepartment(int departmentId) {
       return employeeService.printAllEmployees().stream().
               filter(e -> e.getDepartmentId() == departmentId).
               collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> printAllEmployeesByDepartment() {
       return employeeService.printAllEmployees().stream().
               collect(Collectors.groupingBy(Employee::getDepartmentId));
        }
}