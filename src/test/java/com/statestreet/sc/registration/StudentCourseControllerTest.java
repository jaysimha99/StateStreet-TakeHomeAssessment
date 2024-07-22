package com.statestreet.sc.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statestreet.sc.registration.controller.StudentCourseController;
import com.statestreet.sc.registration.model.Student;
import com.statestreet.sc.registration.model.StudentCourse;
import com.statestreet.sc.registration.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentCourseController.class)
public class StudentCourseControllerTest {

    @MockBean
    private StudentService studentService;

    @InjectMocks
    private StudentCourseController studentController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testAddStudentWithCourses() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        StudentCourse course1 = new StudentCourse();
       //TODO::complete the test case

        when(studentService.addStudent(any(Student.class), any())).thenReturn(student);

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(student)));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Long studentId = 1L;

        mockMvc.perform(delete("/students/{id}", studentId))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudentsByCourseName() throws Exception {


    }

    @Test
    public void testgetStudentsNotInCourse() throws Exception {

    }
}
