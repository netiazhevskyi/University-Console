package com.example.universityconsole.repository;

import com.example.universityconsole.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> findByNameContaining(String criteria);
}
