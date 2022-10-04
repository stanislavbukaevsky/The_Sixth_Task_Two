package pro.sky.employee;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> mapOfEmployees = new HashMap<>(Map.of(
            "Артем Соколов", new Employee("Соколов", "Артем"),
            "Ангелина Панкратова", new Employee("Панкратова", "Ангелина"),
            "Дмитрий Орлов", new Employee("Орлов", "Дмитрий"),
            "Софья Кузнецова", new Employee("Кузнецова", "Софья"),
            "Вячеслав Соловьев", new Employee("Соловьев", "Вячеслав"),
            "Ярослава Иванова", new Employee("Иванова", "Ярослава"),
            "Никита Зиновьев", new Employee("Зиновьев", "Никита"),
            "Софья Маслова", new Employee("Маслова", "Софья"),
            "Роман Трофимов", new Employee("Трофимов", "Роман"),
            "Мария Яковлева", new Employee("Яковлева", "Мария")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        Employee mapOfEmployee = new Employee(firstName, lastName);

        if (mapOfEmployees.containsKey(mapOfEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        mapOfEmployees.put(mapOfEmployee.getFullName(), mapOfEmployee);
        return mapOfEmployee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee mapOfEmployee = new Employee(firstName, lastName);

        if (mapOfEmployees.containsKey(mapOfEmployee.getFullName())) {
            return mapOfEmployees.remove(mapOfEmployee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee toFindEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee mapOfEmployee = new Employee(firstName, lastName);

        if (mapOfEmployees.containsKey(mapOfEmployee.getFullName())) {
            return mapOfEmployees.get(mapOfEmployee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> withdrawalOfEmployees() {
        return Collections.unmodifiableCollection(mapOfEmployees.values());
    }
}
