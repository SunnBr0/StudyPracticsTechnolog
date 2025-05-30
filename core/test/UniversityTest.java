import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    private University university;
    private Teacher teacher1;
    private Teacher teacher2;
    private Student student1;
    private Student student2;
    private Course course1;
    private Course course2;
    private Faculty faculty1;

    @BeforeEach
    public void setup() {
        university = new University("ВГУ");
        teacher1 = new Teacher("Иван", 1);
        teacher2 = new Teacher("Петр", 2);
        student1 = new Student("Пупсень", 2);
        student2 = new Student("Вупсень", 3);
        course1 = new Course("Физика", "PHYS101", teacher1);
        course2 = new Course("Информатика", "INFO101", null);
        faculty1 = new Faculty("Физический факультет");
    }
    @Test
    public void testAddTeacher() {
        university.addTeacher(teacher1);
        assertTrue(university.getTeachers().contains(teacher1));
    }

    @Test
    public void testAddDuplicateTeacher() {
        university.addTeacher(teacher1);
        university.addTeacher(teacher1);
        long count = university.getTeachers().stream().filter(t -> t.equals(teacher1)).count();
        assertEquals(2, count, "Дубликаты преподавателей не запрещены в текущей реализации");
    }

    @Test
    public void testAddStudent() {
        university.addStudent(student1);
        assertTrue(university.getStudents().contains(student1));
    }

    @Test
    public void testAddDuplicateStudent() {
        university.addStudent(student1);
        university.addStudent(student1);
        long count = university.getStudents().stream().filter(s -> s.equals(student1)).count();
        assertEquals(2, count, "Дубликаты студентов не запрещены в текущей реализации");
    }

    @Test
    public void testAddCourse() {
        university.addCourse(course1);
        assertTrue(university.getCourses().contains(course1));
    }

    @Test
    public void testAssignTeacherToCourse() {
        university.addTeacher(teacher1);
        university.addCourse(course2);

        university.assignTeacherToCourse(teacher1, course2);

        assertEquals(teacher1, course2.getTeacher());
        assertTrue(teacher1.getTeachingCourses().contains(course2));
    }



    @Test
    public void testUnsubscribeStudentNotEnrolled() {
        university.addCourse(course1);
        university.addStudent(student2);

        // Отписка студента, который не записан в курс — не должна выбрасывать исключений
        assertDoesNotThrow(() -> university.unsubscribeStudentInCourse(student2, course1));
    }

    @Test
    public void testCancelTeacherFromCourse() {
        university.addTeacher(teacher1);
        university.addCourse(course1);

        university.assignTeacherToCourse(teacher1, course1);
        assertEquals(teacher1, course1.getTeacher());

        university.cancelTeacherToCourse(teacher1, course1);
        assertNull(course1.getTeacher());
        assertFalse(teacher1.getTeachingCourses().contains(course1));
    }

    @Test
    public void testCancelTeacherNotAssigned() {
        university.addTeacher(teacher2);
        university.addCourse(course1);

        // Отмена преподавателя, который не назначен — не должна выбрасывать исключений
        assertDoesNotThrow(() -> university.cancelTeacherToCourse(teacher2, course1));
    }

    @Test
    public void testAddFaculty() {
        university.addFaculty(faculty1);
        assertTrue(university.getFaculties().contains(faculty1));
    }

    @Test
    public void testFacultyRelations() {
        university.addFaculty(faculty1);
        faculty1.addTeacher(teacher1);
        faculty1.addStudent(student1);
        faculty1.addCourse(course1);

        assertTrue(faculty1.getTeachers().contains(teacher1));
        assertTrue(faculty1.getStudents().contains(student1));
        assertTrue(faculty1.getCourses().contains(course1));
    }

    @Test
    public void testEnrollStudentInMultipleCourses() {
        university.addStudent(student1);
        university.addCourse(course1);
        university.addCourse(course2);

        university.enrollStudentInCourse(student1, course1);
        university.enrollStudentInCourse(student1, course2);

        assertTrue(student1.getEnrolledCourses().contains(course1));
        assertTrue(student1.getEnrolledCourses().contains(course2));
    }

    @Test
    public void testAssignMultipleCoursesToTeacher() {
        university.addTeacher(teacher1);
        university.addCourse(course1);
        university.addCourse(course2);

        university.assignTeacherToCourse(teacher1, course1);
        university.assignTeacherToCourse(teacher1, course2);

        assertTrue(teacher1.getTeachingCourses().contains(course1));
        assertTrue(teacher1.getTeachingCourses().contains(course2));
    }
    @Test
    public void testGetInfoStudentInCourse() {
        // Создаем буфер для перехвата вывода в консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;  // сохраняем оригинальный поток

        try {
            System.setOut(new PrintStream(outContent)); // перенаправляем вывод в буфер

            // Создаем университет и студента
            University university = new University("ВГУ");
            Student student = new Student("Иван", 123);
            Course course1 = new Course("Математика", "MATH101", null);
            Course course2 = new Course("Физика", "PHYS101", null);

            // Добавляем курсы студенту
            student.enrollCourse(course1);
            student.enrollCourse(course2);

            // Добавляем студента в университет
            university.addStudent(student);

            // Вызываем тестируемый метод, который печатает информацию
            university.getInfoStudentInCourse();

        } finally {
            System.setOut(originalOut); // обязательно восстанавливаем оригинальный System.out
        }

        // Получаем содержимое вывода
        String output = outContent.toString();

        // Проверяем, что вывод содержит название университета, имя студента, ID и курсы
        assertTrue(output.contains("Университет: ВГУ"), "Должно содержать название университета");
        assertTrue(output.contains("Имя: Иван"), "Должно содержать имя студента");
        assertTrue(output.contains("Идентификатор студента: 123"), "Должно содержать ID студента");
        assertTrue(output.contains("Математика"), "Должно содержать курс Математика");
        assertTrue(output.contains("Физика"), "Должно содержать курс Физика");
    }
    @Test
    public void testGetInfoTeacherToCourse() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outContent));

            University university = new University("ВГУ");
            Teacher teacher = new Teacher("Петр", 1);
            Course course1 = new Course("Физика", "PHYS101", teacher);
            Course course2 = new Course("Математика", "MATH101", teacher);
            teacher.assignCourse(course1);
            teacher.assignCourse(course2);

            university.addTeacher(teacher);

            university.getInfoTeacherToCourse();

        } finally {
            System.setOut(originalOut);
        }

        String output = outContent.toString();

        assertTrue(output.contains("Университет: ВГУ"));
        assertTrue(output.contains("Препод"));
        assertTrue(output.contains("Имя: Петр"));
        assertTrue(output.contains("Физика"));
        assertTrue(output.contains("Математика"));
        assertTrue(output.contains("Идентификатор учителя: 1"));
    }
   
}
