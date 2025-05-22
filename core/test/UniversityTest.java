import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    @Test
    public void testAddTeacher() {
        University university = new University("ВГУ");
        Teacher teacher = new Teacher("Иван", 1);
        university.addTeacher(teacher);
        assertTrue(university.getTeachers().contains(teacher));
    }

    @Test
    public void testAddStudent() {
        University university = new University("ВГУ");
        Student student = new Student("Пупсень", 2);
        university.addStudent(student);
        assertTrue(university.getStudents().contains(student));
    }

    @Test
    public void testAddCourse() {
        University university = new University("ВГУ");
        Teacher teacher = new Teacher("Петр", 2);
        Course course = new Course("Физика", "PHYS101", teacher);
        university.addCourse(course);
        assertTrue(university.getCourses().contains(course));
    }


    @Test
    public void testAssignTeacherToCourse() {
        University university = new University("ВГУ");
        Teacher teacher = new Teacher("Иван", 1);
        Course course = new Course("Информатика", "INFO101", null);

        university.addTeacher(teacher);
        university.addCourse(course);
        university.assignTeacherToCourse(teacher, course);

        assertEquals(teacher, course.getTeacher()); 
    }

    @Test
    public void testUnsubscribeStudentFromCourse() {
        University university = new University("ВГУ");
        Teacher teacher = new Teacher("Петр", 2);
        Course course = new Course("Физика", "PHYS101", teacher);
        Student student = new Student("Пупсень", 2);

        university.addCourse(course);
        university.addStudent(student);
        university.enrollStudentInCourse(student, course);
        university.unsubscribeStudentInCourse(student, course);

        assertFalse(course.getEnrolledStudents().contains(student));
    }

    @Test
    public void testCancelTeacherFromCourse() {
        University university = new University("ВГУ");
        Teacher teacher = new Teacher("Петр", 2);
        Course course = new Course("Физика", "PHYS101", teacher);

        university.addCourse(course);
        university.addTeacher(teacher);
        university.assignTeacherToCourse(teacher, course);
        university.cancelTeacherToCourse(teacher, course);

        assertNull(course.getTeacher());
    }

    @Test
    public void testAddFaculty() {
        University university = new University("ВГУ");
        Faculty faculty = new Faculty("Физический факультет");

        university.addFaculty(faculty);
        assertTrue(university.getFaculties().contains(faculty));
    }
}
