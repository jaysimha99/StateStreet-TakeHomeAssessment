package com.statestreet.sc.registration.repository;

import com.statestreet.sc.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByIdNotIn(Set<Long> studentIds);
}
