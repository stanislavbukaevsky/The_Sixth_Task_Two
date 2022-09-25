package pro.sky.employee;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String lastName, String firstName);

    void deleteEmployee(String firstName, String lastName);

    Employee toFindEmployee(String firstName, String lastName);

    List<Employee> withdrawalOfEmployees();
}
