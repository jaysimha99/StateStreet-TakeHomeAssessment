Model Student Course Registration – Use whatever technology you prefer, not necessarily JPA/Hibernate (preferred since that is what we use).
Student: ID, Name
Course: ID, Name
A student can take many courses and a course can have many students.
1).Write skeleton code of entity bean (or whatever technologies you like) classes to model Student and Course and student course registration.
2). Write a skeleton Student DAO class that support
2.1). add a new student along with their course registrations.
2.2). Delete a student.
2.3).Get all students, sorted by their name, for a given course with course name as input.
Bonus Points:
2.4). What if we want to record course scores?  What possible changes need to be made?
Explain briefly.

To record course scores, you need to:

1.Update the StudentCourse entity to include a score field.
2.Modify the SQL script to insert scores along with student-course relationships.
3.Ensure repository and service layers handle the new field appropriately.
4.Update the controller layer to handle the new field in requests and responses.

2.5). How to find all students who don’t register for a given course? 

To find all students who have not registered for a given course in a Spring Boot application, you can use a combination of JPQL or native SQL queries. Below is the step-by-step process, including the repository, service, and controller layers.

Step 1: Update the StudentRepository
Create a custom query in your StudentRepository to find students who are not registered for a given course. This can be done using a subquery or a LEFT JOIN with a WHERE clause to exclude registered students.
Step 2: Update the StudentService
Add a method in your service layer to call the repository method.
Step 3: Update the StudentController
Add an endpoint in your controller to expose this functionality.
Step 4: Test the Endpoint
Endpoint: GET /students/not-registered/{courseId}


Notes:
1)	Code skeleton is enough. No need to write every single line.
  
2)	Need both entity bean classes as well as table DDLs.
    Added data.sql with create and insert commands for all the tables.
3)	For the DAO/Repository classes need query details for relevant questions.
    I added few queries as per the request.
4)	Show proper transaction management.
    I used @Transactional for DAO class (StudentService.java)
5)	Show best practice(s) when you can solve the problems with multiple approaches.  If possible comment why one approach is better than the others.

While solving this, I got two different approaches
    a) With 2 tables
    b) With 3 tables 
    Every approach has its own pros and cons. we should analyse the requirement and decide the approach.
6)	We love Hibernate and also hate it!! Would love to hear your opinion on best practices.
    
    Hibernate provides lot many features to accomplish complex functionality. But we should be careful in planing to avoid performance issues. 
    Best practices - Define proper primary key, annotation usage, multi table relations, locking etc.
7)	Please upload to Github and send us the link afterwards.




