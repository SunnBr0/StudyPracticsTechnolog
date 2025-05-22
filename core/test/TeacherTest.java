import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testConstructorAndGetters() {
        Teacher teacher = new Teacher("Иван", 1);
        assertEquals("Иван", teacher.getName());
        assertEquals(1, teacher.getId());
        assertNotNull(teacher.getTeachingCourses());
        assertTrue(teacher.getTeachingCourses().isEmpty());
    }

    @Test
    public void testAssignCourse() {
        Teacher teacher = new Teacher("Иван", 1);
        Course course = new Course("Математика", "MATH101", teacher);

        teacher.assignCourse(course);

        List<Course> courses = teacher.getTeachingCourses();
        assertEquals(1, courses.size());
        assertTrue(courses.contains(course));
    }

    @Test
    public void testCancelCourse() {
        Teacher teacher = new Teacher("Иван", 1);
        Course course = new Course("Математика", "MATH101", teacher);

        teacher.assignCourse(course);
        assertTrue(teacher.getTeachingCourses().contains(course));

        teacher.cancelCourse(course);
        assertFalse(teacher.getTeachingCourses().contains(course));
    }

    @Test
    public void testToString() {
        Teacher teacher = new Teacher("Иван", 1);
        assertEquals("Иван", teacher.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Teacher t1 = new Teacher("Иван", 1);
        Teacher t2 = new Teacher("Иван", 1);
        Teacher t3 = new Teacher("Петр", 2);
        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
        assertNotEquals(t1, t3);
        assertNotEquals(t1.hashCode(), t3.hashCode());
        assertNotEquals(t1, null);
        assertNotEquals(t1, "some string");
    }

    @Test
    public void testAssignSameCourseMultipleTimes() {
        Teacher teacher = new Teacher("Иван", 1);
        Course course = new Course("Математика", "MATH101", teacher);

        teacher.assignCourse(course);
        teacher.assignCourse(course); // повторное добавление

        // Проверяем, что курс добавился дважды (потому что в реализации не проверяется
        // на дубликаты)
        List<Course> courses = teacher.getTeachingCourses();
        assertEquals(2, courses.size());
    }
    @Test
    public void testCancelNullCourse() {
        Teacher teacher = new Teacher("Иван", 1);
        // Удаление null из списка — должно работать без ошибок, remove(null) не падает
        assertDoesNotThrow(() -> teacher.cancelCourse(null));
    }
    @Test
    public void testCancelCourseNotAssigned() {
        Teacher teacher = new Teacher("Иван", 1);
        Course course = new Course("Математика", "MATH101", teacher);
        // Отмена курса, который не назначен учителю — не должно выбрасывать исключений
        assertDoesNotThrow(() -> teacher.cancelCourse(course));
    }

    
}
