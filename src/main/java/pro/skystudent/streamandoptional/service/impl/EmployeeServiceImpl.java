package pro.skystudent.streamandoptional.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.skystudent.streamandoptional.data.Employee;
import pro.skystudent.streamandoptional.exceptions.*;
import pro.skystudent.streamandoptional.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static int size;
    private Map<String, Employee> employeeBook;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        checkNames(firstName, lastName);

        firstName = StringUtils.capitalize(firstName.toLowerCase());
        lastName = StringUtils.capitalize(lastName.toLowerCase());

        Employee newEmployee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyExistException("This employee already exists");
        } else {
            employeeBook.put(firstName + lastName, newEmployee);
            size++;
            return newEmployee;
        }
    }

    private void checkNames(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)){
            throw new InvalidOrMissingNameException("Name Error!");
            }
    }

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
        employeeBook.put("MikeBlack", new Employee("Mike", "Black"));
        employeeBook.put("JoeGrey", new Employee("Joe", "Grey"));
        employeeBook.put("MaxWHite", new Employee("Max", "White"));
        employeeBook.put("BobGreen", new Employee("Bob", "Green"));
        employeeBook.put("ZoeViolet", new Employee("Zoe", "Violet"));
        employeeBook.put("JohnGrant", new Employee("John", "Grant"));
        employeeBook.put("WilliamTurner", new Employee("William", "Turner"));
        employeeBook.put("NinaCold", new Employee("Nina", "Cold"));
        employeeBook.put("KateSilverspoon", new Employee("Kate", "Silverspoon"));
        employeeBook.put("GregoryButcher", new Employee("Gregory", "Butcher"));
        employeeBook.get("MikeBlack").setDepartment(1);
        employeeBook.get("JoeGrey").setDepartment(1);
        employeeBook.get("MaxWHite").setDepartment(1);
        employeeBook.get("BobGreen").setDepartment(2);
        employeeBook.get("ZoeViolet").setDepartment(2);
        employeeBook.get("JohnGrant").setDepartment(2);
        employeeBook.get("WilliamTurner").setDepartment(3);
        employeeBook.get("NinaCold").setDepartment(3);
        employeeBook.get("KateSilverspoon").setDepartment(3);
        employeeBook.get("GregoryButcher").setDepartment(3);
        employeeBook.get("MikeBlack").setSalary(75600f);
        employeeBook.get("JoeGrey").setSalary(77800f);
        employeeBook.get("MaxWHite").setSalary(81001f);
        employeeBook.get("BobGreen").setSalary(82300f);
        employeeBook.get("ZoeViolet").setSalary(83200f);
        employeeBook.get("JohnGrant").setSalary(85002f);
        employeeBook.get("WilliamTurner").setSalary(91200f);
        employeeBook.get("NinaCold").setSalary(78900f);
        employeeBook.get("KateSilverspoon").setSalary(99900f);
        employeeBook.get("GregoryButcher").setSalary(80050f);
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employeeBook.containsKey(firstName + lastName)) {
            throw new EmployeeIsMissingException("This employee is missing");
        }
        checkNames(firstName, lastName);

        firstName = StringUtils.capitalize(firstName.toLowerCase());
        lastName = StringUtils.capitalize(lastName.toLowerCase());

        return employeeBook.get(firstName + lastName);
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (!employeeBook.containsKey(firstName + lastName)) {
            throw new EmployeeIsMissingException("Cannot delete missing employee");
        }
        checkNames(firstName, lastName);

        firstName = StringUtils.capitalize(firstName.toLowerCase());
        lastName = StringUtils.capitalize(lastName.toLowerCase());

        employeeBook.remove(firstName + lastName);
        size--;
        return employeeBook.get(firstName + lastName);
    }

    @Override
    public Collection<Employee> printAllEmployees() {
        if (employeeBook.size() == 0) {
            throw new NoEmployeesInListException("Employee list is empty");
        }
        return employeeBook.values();
    }


    @Override
    public Integer getSize() {
        return size;
    }

}