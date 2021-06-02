package com.example.javaspring.repository;

import com.example.javaspring.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {
    @Query("select s from Employee as s where s.fullName like %:search%")
    Page<Employee> searchByName(@Param("search") String search, Pageable pageable);
}
