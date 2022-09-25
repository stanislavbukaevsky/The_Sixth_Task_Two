package pro.sky.employee;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;


    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String toString() {
        return "Данные о сотруднике: " + lastName + " " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}

