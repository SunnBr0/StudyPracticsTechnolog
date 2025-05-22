import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testConstructorAndGetters() {
        Student student = new Student("Аня", 101);
        assertEquals("Аня", student.getName());
        assertEquals(101, student.getId());
        assertNotNull(student.getEnrolledCourses());
        assertTrue(student.getEnrolledCourses().isEmpty());
    }

    @Test
    public void testEnrollCourse() {
        Student student = new Student("Аня", 101);
        Course course = new Course("История", "HIST101", null);

        student.enrollCourse(course);

        List<Course> courses = student.getEnrolledCourses();
        assertEquals(1, courses.size());
        assertTrue(courses.contains(course));
    }

    @Test
    public void testUnsubscribeCourse() {
        Student student = new Student("Аня", 101);
        Course course = new Course("История", "HIST101", null);

        student.enrollCourse(course);
        assertTrue(student.getEnrolledCourses().contains(course));

        student.unsubscribeCourse(course);
        assertFalse(student.getEnrolledCourses().contains(course));
    }
    @Test
    public void testEnrollSameCourseMultipleTimes() {
        Student student = new Student("Аня", 101);
        Course course = new Course("История", "HIST101", null);

        student.enrollCourse(course);
        student.enrollCourse(course); // повторная попытка

        // Ожидаем, что курс добавится дважды, т.к. нет проверки в коде на дубликаты
        List<Course> courses = student.getEnrolledCourses();
        assertEquals(2, courses.size());
    }

    @Test
    public void testToString() {
        Student student = new Student("Аня", 101);
        assertEquals("Аня", student.toString());
    }
}
