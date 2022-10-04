package pro.sky.employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String lastName, String firstName) throws EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee toFindEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> withdrawalOfEmployees();
}
