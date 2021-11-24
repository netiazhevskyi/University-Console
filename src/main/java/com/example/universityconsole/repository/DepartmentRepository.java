package com.example.universityconsole.repository;

import com.example.universityconsole.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("FROM Department d LEFT JOIN FETCH d.lectorList dl "
            + "FETCH ALL PROPERTIES WHERE d.departmentName = ?1")
    Department findByDepartmentName(String departmentName);
}
