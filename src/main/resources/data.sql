-- Students Table
CREATE TABLE STUDENT (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Courses Table
CREATE TABLE COURSE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- StudentCourses Table
CREATE TABLE STUDENT_COURSE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    course_id BIGINT,
    score DECIMAL(5, 2),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);

-- Insert into COURSE table
INSERT INTO COURSE (id, name) VALUES (1, 'Mathematics');
INSERT INTO COURSE (id, name) VALUES (2, 'Physics');
INSERT INTO COURSE (id, name) VALUES (3, 'Chemistry');

-- Insert into STUDENT table
INSERT INTO STUDENT (id, name) VALUES (1, 'John Doe');
INSERT INTO STUDENT (id, name) VALUES (2, 'Jane Smith');
INSERT INTO STUDENT (id, name) VALUES (3, 'Robert Brown');

-- Insert into STUDENT_COURSE table
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (1, 1, 95);
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (1, 2, 88);
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (2, 1, 78);
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (2, 3, 92);
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (3, 2, 85);
INSERT INTO STUDENT_COURSE (student_id, course_id, score) VALUES (3, 3, 80);

