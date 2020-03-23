package com.kamikadze328.testforcv.test2;

import com.kamikadze328.testforcv.test2.model.Room;
import com.kamikadze328.testforcv.test2.model.Student;
import com.kamikadze328.testforcv.test2.model.Subject;
import com.kamikadze328.testforcv.test2.repositories.RoomRepository;
import com.kamikadze328.testforcv.test2.repositories.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Test2ApplicationTests {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    public void testAddNewStudent(){
        Room room = new Room();
        Student student = new Student("Kek", room);
        System.out.println(roomRepository.save(room));
        System.out.println(studentRepository.save(student));
    }

    private static SessionFactory sessionFactory;
    private Session session;

    @Test
    public void givenData_whenInsert_thenCreatesMtoMrelationship() {
        String[] employeeData = { "Peter", "Allan" };
        String[] projectData = { "IT Project", "Networking Project" };
        List<Subject> projects = new ArrayList<>();

        for (String proj : projectData) {
            projects.add(new Subject(proj));
        }

        for (String emp : employeeData) {
            Student employee = new Student(emp);

            assertEquals(0, employee.getSubjects().size());
            employee.setSubjects(projects);
            session.persist(employee);

            assertNotNull(employee);
        }
    }

    @Test
    public void givenSession_whenRead_thenReturnsMtoMdata() {
        @SuppressWarnings("unchecked")
        List<Student> employeeList = session.createQuery("FROM Student")
                .list();

        assertNotNull(employeeList);

        for(Student employee : employeeList) {
            assertNotNull(employee.getSubjects());
        }
    }
}


