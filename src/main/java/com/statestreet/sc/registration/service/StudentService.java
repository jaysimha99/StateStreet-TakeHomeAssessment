package com.statestreet.sc.registration.service;

import com.statestreet.sc.registration.model.Course;
import com.statestreet.sc.registration.model.Student;
import com.statestreet.sc.registration.model.StudentCourse;
import com.statestreet.sc.registration.repository.CourseRepository;
import com.statestreet.sc.registration.repository.StudentCourseRepository;
import com.statestreet.sc.registration.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return Optional.of(student.get());
    }

    // Add a new student along with their course registrations
    public Student addStudent(Student student, Set<Course> courses) {
        Student newStudent = studentRepository.save(student);
        if(courses != null) {
            for (Course course : courses) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(student);
                studentCourse.setCourse(course);
                studentCourseRepository.save(studentCourse);
            }
        }
        return newStudent;
    }

    // Delete a student
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    // Get all students, sorted by their name, for a given course with course name as input
    public List<Student> getStudentsByCourseName(String courseName) {
        Optional<Course> course = courseRepository.findByName(courseName);
        return course.map(value -> studentCourseRepository.findByCourse(value)
                .stream()
                .map(StudentCourse::getStudent)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList())).orElseGet(List::of);
    }

    // Find all students who don’t register for a given course
    public List<Student> getStudentsNotInCourse(String courseName) {
        Optional<Course> course = courseRepository.findByName(courseName);
        if (course.isPresent()) {
            return studentRepository.findByIdNotIn(
                    studentCourseRepository.findStudentIdsByCourse(courseName));
        }
        return List.of();
    }
}