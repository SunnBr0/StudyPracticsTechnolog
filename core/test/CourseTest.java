import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course course;
    private Teacher teacher;
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setUp() {
        teacher = new Teacher("Иван Иванов", 1);
        course = new Course("Математика", "MATH101", teacher);
        student1 = new Student("Пётр Петров", 10);
        student2 = new Student("Анна Смирнова", 11);
    }

    @Test
    public void testGetName() {
        assertEquals("Математика", course.getName());
    }

    @Test
    public void testGetCode() {
        assertEquals("MATH101", course.getCode());
    }

    @Test
    public void testGetTeacher() {
        assertEquals(teacher, course.getTeacher());
    }

    @Test
    public void testSetTeacher() {
        Teacher newTeacher = new Teacher("Мария Иванова", 2);
        course.setTeacher(newTeacher);
        assertEquals(newTeacher, course.getTeacher());
    }

    @Test
    public void testCancelTeacher() {
        course.cancelTeacher(teacher);
        assertNull(course.getTeacher());
    }

    @Test
    public void testEnrollStudent() {
        course.enrollStudent(student1);
        course.enrollStudent(student2);
        assertTrue(course.getEnrolledStudents().contains(student1));
        assertTrue(course.getEnrolledStudents().contains(student2));
        assertEquals(2, course.getEnrolledStudents().size());
    }

    @Test
    public void testUnsubscribeStudent() {
        course.enrollStudent(student1);
        course.enrollStudent(student2);
        course.unsubscribeStudent(student1);
        assertFalse(course.getEnrolledStudents().contains(student1));
        assertTrue(course.getEnrolledStudents().contains(student2));
        assertEquals(1, course.getEnrolledStudents().size());
    }

    @Test
    public void testToString() {
        assertEquals("Математика", course.toString());
    }
}
