package pro.sky.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> listOfEmployee = new ArrayList<>(List.of(
            new Employee("Соколов", "Артем"),
            new Employee("Панкратова", "Ангелина"),
            new Employee("Орлов", "Дмитрий"),
            new Employee("Кузнецова", "Софья"),
            new Employee("Соловьев", "Вячеслав"),
            new Employee("Иванова", "Ярослава"),
            new Employee("Зиновьев", "Никита"),
            new Employee("Маслова", "Софья"),
            new Employee("Трофимов", "Роман"),
            new Employee("Яковлева", "Мария")
    ));

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        for (Employee employee : listOfEmployee) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                try {
                    throw new EmployeeAlreadyAddedException();
                } catch (EmployeeAlreadyAddedException e) {
                    System.out.println("Сотрудник с таким именем уже существует!");
                }
            } else if (listOfEmployee.size() > listOfEmployee.size() + 1) {
                try {
                    throw new EmployeeStorageIsFullException();
                } catch (EmployeeStorageIsFullException e) {
                    System.out.println("Список сотрудников переполнен!");
                }
            }
        }
        return listOfEmployee.add(new Employee(lastName, firstName));
    }

    @Override
    public void deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (listOfEmployee.remove(employee)) {
            try {
                throw new EmployeeNotFoundException();
            } catch (EmployeeNotFoundException e) {
                System.out.println("Сотрудника с таким именем не существует!");
            }
        }
    }

    @Override
    public Employee toFindEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (listOfEmployee.contains(employee)) {
            try {
                throw new EmployeeNotFoundException();
            } catch (EmployeeNotFoundException e) {
                System.out.println("Сотрудника с таким именем не существует!");
            }
        }
        return employee;
    }

    @Override
    public List<Employee> withdrawalOfEmployees() {
        for (Employee employee : listOfEmployee) {
            System.out.println(employee);
        }
        return listOfEmployee;
    }
}
