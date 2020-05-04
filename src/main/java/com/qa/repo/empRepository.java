package com.qa.repo;

import com.qa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empRepository extends JpaRepository<Employee,Long> {
    Employee findByName(String name);

}
