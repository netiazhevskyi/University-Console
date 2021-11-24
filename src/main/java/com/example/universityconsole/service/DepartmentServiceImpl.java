package com.example.universityconsole.service;

import com.example.universityconsole.model.Department;
import com.example.universityconsole.model.Lector;
import com.example.universityconsole.repository.DepartmentRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department getDepartment(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Map<String, Long> getDepartmentStatistics(String departmentName) {
        List<Lector> lectorList = departmentRepository.findByDepartmentName(departmentName)
                .getLectorList();
        return lectorList.stream()
                .map(Lector::getDegree)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public Double getAverageSalary(String departmentName) {
        List<Lector> lectorList = departmentRepository.findByDepartmentName(departmentName)
                .getLectorList();
        return lectorList.stream()
                .map(Lector::getSalary)
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
    }

    @Override
    public void getEmployeeCount(String departmentName) {
        int size = departmentRepository.findByDepartmentName(departmentName)
                .getLectorList().size();
        System.out.println(departmentName + String.format(" department has %s employees", size));
    }

}
