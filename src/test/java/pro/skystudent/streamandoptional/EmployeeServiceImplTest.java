package pro.skystudent.streamandoptional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.skystudent.streamandoptional.data.Employee;
import pro.skystudent.streamandoptional.exceptions.EmployeeAlreadyExistException;
import pro.skystudent.streamandoptional.exceptions.EmployeeIsMissingException;
import pro.skystudent.streamandoptional.exceptions.InvalidOrMissingNameException;
import pro.skystudent.streamandoptional.exceptions.NoEmployeesInListException;
import pro.skystudent.streamandoptional.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.skystudent.streamandoptional.EmployeeBookConstants.FIRST_NAME;
import static pro.skystudent.streamandoptional.EmployeeBookConstants.LAST_NAME;
import static pro.skystudent.streamandoptional.EmployeeBookConstants.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    private void initialize() {
        out = new EmployeeServiceImpl();
    }

    @Test
    public void TestingAddEmployeeWithNewEmployee() {

        Employee newEmployeeToTestAdd = new Employee(FIRST_NAME, LAST_NAME);
//        В EmployeeServiceImpl уже добавлено 10 сотрудников на прошлом задании вручную в качестве базового набора данных.
        assertEquals(10, out.printAllEmployees().size());
        Employee existingEmployee = out.addEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(newEmployeeToTestAdd, existingEmployee);
        assertEquals(11, out.printAllEmployees().size());
        assertTrue(out.printAllEmployees().contains(existingEmployee));
    }

    private static Stream<Arguments> providingIncorrectDataForAddEmployeeTest() {
        return Stream.of(
                Arguments.of(INCORRECT_LAST_NAME, LAST_NAME),
                Arguments.of(FIRST_NAME, INCORRECT_LAST_NAME),
                Arguments.of(INCORRECT_FIRST_NAME_WITH_REPLACED_LETTER, LAST_NAME),
                Arguments.of(FIRST_NAME, INCORRECT_LAST_NAME_WITH_SPACE_AFTER),
                Arguments.of(INCORRECT_FIRST_NAME_WITH_REPLACED_LETTER, INCORRECT_LAST_NAME_WITH_SPACE_AFTER)

        );
    }

    @MethodSource("providingIncorrectDataForAddEmployeeTest")
    @ParameterizedTest
    public void testingAddingEmployeeWithIncorrectNameAndLastNameToThrowException(String firstName, String lastName) {
        assertThrows(InvalidOrMissingNameException.class, () -> out.addEmployee(firstName,lastName));
    }

    @Test
    public void testingAddingAlreadyAddedEmployeeToThrowException() {
        Employee addingEmployee =  out.addEmployee(FIRST_NAME, LAST_NAME);
        assertTrue(out.printAllEmployees().contains(addingEmployee));
        assertThrows(EmployeeAlreadyExistException.class, () -> out.addEmployee(FIRST_NAME, LAST_NAME));

    }

    @Test
    public void testingExceptionInFindEmployeeMethod() {
        assertThrows(EmployeeIsMissingException.class, () -> out.findEmployee(FIRST_NAME, LAST_NAME));

    }

    @Test
    public void testingFindEmployeeMethod() {
        assertEquals(10, out.printAllEmployees().size());
        Employee employeeToFind = out.addEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(11, out.printAllEmployees().size());
        out.findEmployee(FIRST_NAME, LAST_NAME);
    }

    @Test
    public void testingCorrectRemoveEmployeeMethod() {
        assertEquals(10, out.printAllEmployees().size());
        Employee employeeToRemove = out.addEmployee(FIRST_NAME, LAST_NAME);
        assertTrue(out.printAllEmployees().contains(employeeToRemove));
        assertEquals(11, out.printAllEmployees().size());
        assertEquals(employeeToRemove, out.findEmployee(FIRST_NAME, LAST_NAME));
        out.removeEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(10, out.printAllEmployees().size());
        assertFalse(out.printAllEmployees().contains(employeeToRemove));
    }

    @Test
    public void testingEmployeeIsMissingExceptionInRemoveEmployeeMethod() {
        assertThrows(EmployeeIsMissingException.class, () -> out.removeEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void testingExceptionIfEmployeeListIsEmpty() {
        out.printAllEmployees().clear();
        assertThrows(NoEmployeesInListException.class, () -> out.printAllEmployees());
    }
}
