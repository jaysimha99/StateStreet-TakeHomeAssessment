package com.statestreet.sc.registration.repository;

import com.statestreet.sc.registration.model.Course;
import com.statestreet.sc.registration.model.StudentCourse;
import com.statestreet.sc.registration.model.StudentCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {
    List<StudentCourse> findByCourse(Course course);

    @Query("SELECT student FROM StudentCourse sc WHERE sc.course.name = :courseName")
    Set<Long> findStudentIdsByCourse(@Param("courseName") String courseName);
    //Set<Long> findStudentIdsByCourse(Course course);
}
