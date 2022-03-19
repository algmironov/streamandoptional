package pro.skystudent.streamandoptional;

import pro.skystudent.streamandoptional.data.Employee;
import pro.skystudent.streamandoptional.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeBookConstants {

    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final String FIRST_NAME2 = "Julia";
    public static final String LAST_NAME2 = "Wood";
    public static final String FIRST_NAME3 = "Max";
    public static final String LAST_NAME3 = "Blue";


    public static final String INCORRECT_FIRST_NAME = "1van";
    public static final String INCORRECT_LAST_NAME = "Ivan0v";
    public static final String INCORRECT_FIRST_NAME_WITH_REPLACED_LETTER = "1vаn";
    public static final String INCORRECT_LAST_NAME_WITH_SPACE_AFTER = "Ivanov ";

    public static final float MAX_SALARY = 1000000f;
    public static final float MIN_SALARY = 10000f;

    public static final int DEPARTMENT_ID1 = 1;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee EMPLOYEE_WITH_MAX_SALARY = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID1, MAX_SALARY);
    public static final Employee EMPLOYEE_WITH_MIN_SALARY = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID1, MIN_SALARY);
    public static final Employee MISSING_EMPLOYEE = new Employee(FIRST_NAME3, LAST_NAME3, DEPARTMENT_ID2, MAX_SALARY);
    public static final Set<Employee> EMPLOYEES = Set.of(EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_WITH_MIN_SALARY);
    public static final Set<Employee> EMPLOYEES2 = Set.of(EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_WITH_MIN_SALARY, MISSING_EMPLOYEE);
    public static final Map<Integer, List<Employee>> EMPLOYEES_MAP = EMPLOYEES2.stream().collect(groupingBy(Employee::getDepartmentId));



}
