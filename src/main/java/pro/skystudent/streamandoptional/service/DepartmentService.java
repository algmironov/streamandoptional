package pro.skystudent.streamandoptional.service;

import pro.skystudent.streamandoptional.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Collection<Employee> printEmployeesFromDepartment(int departmentId);

    Map<Integer, List<Employee>> printAllEmployeesByDepartment();

    Employee findEmployeeWithMinSalaryInDepartment(int departmentId);

    Employee findEmployeeWithMaxSalaryInDepartment(int departmentId);
}
