package com.example.universityconsole.console;

import com.example.universityconsole.model.Department;
import com.example.universityconsole.service.DepartmentService;
import com.example.universityconsole.service.LectorService;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleController {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public ConsoleController(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void consoleCommand(int i) {
        Scanner scan = new Scanner(System.in);
        String departmentName = "";
        switch (i) {
            case 1:
                System.out.print("Enter department name: ");
                departmentName = scan.next();
                Department department = departmentService.getDepartment(departmentName);
                String headOfDepartment = department.getHeadOfDepartment();
                System.out.printf("Head of %s department is %s%n",
                        departmentName, headOfDepartment);
                return;
            case 2:
                System.out.print("Enter department name: ");
                Map<String, Long> departmentStatistics = departmentService
                        .getDepartmentStatistics(scan.next());
                System.out.println(departmentStatistics);
                return;
            case 3:
                System.out.print("Enter department name: ");
                departmentName = scan.next();
                Double averageSalary = departmentService.getAverageSalary(departmentName);
                System.out.printf("The average salary of %s is %s%n",
                        departmentName, averageSalary);
                return;
            case 4:
                System.out.print("Enter department name: ");
                departmentName = scan.next();
                departmentService.getEmployeeCount(departmentName);
                return;
            case 5:
                System.out.print("Enter your search criteria: ");
                String criteria = scan.next();
                lectorService.getLectorsByCriteria(criteria);
                return;
            default:
                System.out.print("Incorrect option chosen. Please enter numbers from 1 to 5");
        }
    }
}
