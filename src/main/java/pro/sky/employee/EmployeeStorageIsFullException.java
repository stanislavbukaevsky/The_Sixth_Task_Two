package pro.sky.employee;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeStorageIsFullException extends Exception {
}
