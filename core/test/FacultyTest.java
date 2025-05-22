import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FacultyTest {

    private Faculty faculty;
    private Teacher teacher;
    private Student student;
    private Course course;

    @BeforeEach
    public void setUp() {
        faculty = new Faculty("Физический");
        teacher = new Teacher("Иван Иванов", 1);
        student = new Student("Пётр Петров", 2);
        course = new Course("Математика", "MATH101", teacher);
    }

    @Test
    public void testGetName() {
        assertEquals("Физический", faculty.getName());
    }

    @Test
    public void testAddAndGetTeachers() {
        faculty.addTeacher(teacher);
        assertTrue(faculty.getTeachers().contains(teacher));
        assertEquals(1, faculty.getTeachers().size());
    }

    @Test
    public void testAddAndGetStudents() {
        faculty.addStudent(student);
        assertTrue(faculty.getStudents().contains(student));
        assertEquals(1, faculty.getStudents().size());
    }

    @Test
    public void testAddAndGetCourses() {
        faculty.addCourse(course);
        assertTrue(faculty.getCourses().contains(course));
        assertEquals(1, faculty.getCourses().size());
    }

    @Test
    public void testToString() {
        assertEquals("Факультет: Физический", faculty.toString());
    }
}
