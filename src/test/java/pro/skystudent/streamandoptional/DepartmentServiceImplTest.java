package pro.skystudent.streamandoptional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skystudent.streamandoptional.exceptions.EmployeeIsMissingException;
import pro.skystudent.streamandoptional.service.EmployeeService;
import pro.skystudent.streamandoptional.service.impl.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.skystudent.streamandoptional.EmployeeBookConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void testingEmployeeWithMaxSalaryByDepartmentID() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE_WITH_MAX_SALARY, out.findEmployeeWithMaxSalaryInDepartment(DEPARTMENT_ID1));
    }

    @Test
    public void testingThrowingEmployeeIsMissingExceptionInEmployeeWithMaxSalaryByDepartmentIDMethod() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeIsMissingException.class, () -> out.findEmployeeWithMaxSalaryInDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void testingEmployeeWithMinSalaryByDepartmentID() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE_WITH_MIN_SALARY, out.findEmployeeWithMinSalaryInDepartment(DEPARTMENT_ID1));
    }

    @Test
    public void testingThrowingEmployeeIsMissingExceptionInEmployeeWithMinSalaryByDepartmentIDMethod() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeIsMissingException.class, () -> out.findEmployeeWithMinSalaryInDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void testingPrintAllEmployeesFromDepartmentShouldReturnEmptyListIfEmployeesAreMissing() {
        when(employeeService.printAllEmployees()).thenReturn(new ArrayList());
        assertEquals(new ArrayList(), out.printEmployeesFromDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void testingPrintAllEmployeesFromDepartment() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES2);
        out.printEmployeesFromDepartment(1);
        assertEquals(List.of(EMPLOYEE_WITH_MIN_SALARY, EMPLOYEE_WITH_MAX_SALARY).contains(EMPLOYEE_WITH_MAX_SALARY)
                && List.of(EMPLOYEE_WITH_MIN_SALARY, EMPLOYEE_WITH_MAX_SALARY).contains(EMPLOYEE_WITH_MIN_SALARY),
                out.printEmployeesFromDepartment(DEPARTMENT_ID1).contains(EMPLOYEE_WITH_MIN_SALARY) &&
                        out.printEmployeesFromDepartment(DEPARTMENT_ID1).contains(EMPLOYEE_WITH_MAX_SALARY));

    }

    @Test
    public void testingPrintAllEmployeesByDepartmentShouldReturnEmptyMapIfEmployeesAreMissing() {
        when(employeeService.printAllEmployees()).thenReturn(new ArrayList());
        assertEquals(new HashMap(), out.printAllEmployeesByDepartment());
    }

    @Test
    public void testingPrintAllEmployeesByDepartmentId() {
        when(employeeService.printAllEmployees()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEES_MAP, out.printAllEmployeesByDepartment());

    }
}
