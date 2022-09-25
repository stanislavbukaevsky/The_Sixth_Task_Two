package pro.sky.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.addEmployee(lastName, firstName);
        return "Сотрудник с именем " + firstName + " и фамилией : " + lastName + " добавлен в список!";
    }

    @GetMapping(path = "/delete")
    public String deleteEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.deleteEmployee(lastName, firstName);
        return "Сотрудник с именем " + firstName + " и фамилией : " + lastName + " удален из списка!";
    }

    @GetMapping(path = "/find")
    public String toFindEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.toFindEmployee(lastName, firstName);
        return "Имя сотрудника: " + firstName + " Фамилия сотрудника: " + lastName;
    }

    @GetMapping(path = "/with")
    public List<Employee> withdrawalOfEmployees() {
        return employeeService.withdrawalOfEmployees();
    }
}
