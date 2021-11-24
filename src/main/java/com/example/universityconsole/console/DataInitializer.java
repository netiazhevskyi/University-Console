package com.example.universityconsole.console;

import com.example.universityconsole.model.Department;
import com.example.universityconsole.model.Lector;
import com.example.universityconsole.repository.DepartmentRepository;
import com.example.universityconsole.service.LectorService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final DepartmentRepository departmentRepository;
    private final LectorService lectorService;

    public DataInitializer(DepartmentRepository departmentRepository, LectorService lectorService) {
        this.departmentRepository = departmentRepository;
        this.lectorService = lectorService;
    }

    @PostConstruct
    public void inject() {
        Department economics = new Department();
        economics.setDepartmentName("Economics");
        economics.setHeadOfDepartment("Vasyl Ivanov");

        Department mathematics = new Department();
        mathematics.setDepartmentName("Mathematics");
        mathematics.setHeadOfDepartment("Ivanov Petrov");

        Lector petro = new Lector();
        petro.setDegree("assistant");
        petro.setName("Petro Pupkin");
        petro.setSalary(20000.00);
        petro.setDepartmentList(List.of(economics, mathematics));

        Lector vasyl = new Lector();
        vasyl.setDegree("professor");
        vasyl.setName("Vasyl Alonso");
        vasyl.setSalary(15210.00);
        vasyl.setDepartmentList(List.of(mathematics));

        economics.setLectorList(List.of(petro, vasyl));
        mathematics.setLectorList(List.of(vasyl));
        departmentRepository.save(economics);
        departmentRepository.save(mathematics);

    }
}
