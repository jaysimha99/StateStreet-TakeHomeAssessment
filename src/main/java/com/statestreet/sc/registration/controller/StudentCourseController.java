package com.statestreet.sc.registration.controller;

import com.statestreet.sc.registration.model.Course;
import com.statestreet.sc.registration.model.StudentDTO;
import com.statestreet.sc.registration.repository.StudentRepository;
import com.statestreet.sc.registration.service.StudentService;
import com.statestreet.sc.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class StudentCourseController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("api/v1/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());

        Set<Course> courses = studentDTO.getCourses();

        Student savedStudent = studentService.addStudent(student, courses);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    @DeleteMapping("api/v1/student/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable Long id){
        Optional<Student> oldStudent = studentService.getStudentById(id);
        if (oldStudent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 3. Get all students, sorted by their name, for a given course
    @GetMapping("/api/students/course")
    public ResponseEntity<List<Student>> getStudentsByCourseName(@RequestParam String courseName) {
        List<Student> students = studentService.getStudentsByCourseName(courseName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // 4. Find all students who don’t register for a given course
    @GetMapping("/api/students/notInCourse")
    public ResponseEntity<List<Student>> getStudentsNotInCourse(@RequestParam String courseName) {
        List<Student> students = studentService.getStudentsNotInCourse(courseName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
