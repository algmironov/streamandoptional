package pro.skystudent.streamandoptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skystudent.streamandoptional.data.Employee;
import pro.skystudent.streamandoptional.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String welcomeToDepartment() {
        return "Welcome to Department page!";
    }

    @GetMapping("/all-from-department")
    Collection<Employee> printEmployeesFromDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.printEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> printAllEmployeesByDepartment() {
        return departmentService.printAllEmployeesByDepartment();
    }

    @GetMapping("/min-salary")
    Employee findEmployeeWithMinSalaryInDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMinSalaryInDepartment(departmentId);
    }

    @GetMapping("/max-salary")
    Employee findEmployeeWithMaxSalaryInDepartment(@RequestParam("departmentId")int departmentId) {
        return departmentService.findEmployeeWithMaxSalaryInDepartment(departmentId);
    }
}
