package com.example.universityconsole.service;

import com.example.universityconsole.model.Department;
import java.util.Map;

public interface DepartmentService {
    Department getDepartment(String departmentName);

    Map<String, Long> getDepartmentStatistics(String departmentName);

    Double getAverageSalary(String departmentName);

    void getEmployeeCount(String departmentName);
}
