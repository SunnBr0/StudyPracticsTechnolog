package src;

public class Main {
    public static void main(String[] args) {
        // Постановка задачи:
        // Создать систему, в которой можно было бы регистрировать преподов, студентов и курсы
        University university = new University("ВГУ");

        Teacher teacher1 = new Teacher("Иван Иванов Иванович", 1);
        Teacher teacher2 = new Teacher("Петр Петров Петрович", 2);

        Course course1 = new Course("Дискретная математика", "MATH101", teacher1);
        Course course2 = new Course("Физика", "PHYS101", teacher2);

        Student student1 = new Student("Вупсень", 1);
        Student student2 = new Student("Пупсень", 2);

        university.addTeacher(teacher1);
        university.addTeacher(teacher2);
        university.addCourse(course1);
        university.addCourse(course2);
        university.addStudent(student1);
        university.addStudent(student2);
        university.enrollStudentInCourse(student1, course1);
        university.enrollStudentInCourse(student2, course2);
        university.assignTeacherToCourse(teacher1, course1);
        university.assignTeacherToCourse(teacher2, course2);

        university.getInfoStudentInCourse();
        university.getInfoTeacherToCourse();

    }

}
