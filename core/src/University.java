import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private String name;
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void enrollStudentInCourse(Student student, Course course) {
        Boolean value = new Secruty().acces(student.getName());
        if(value){
            student.enrollCourse(course);
        }
    }

    public void unsubscribeStudentInCourse(Student student, Course course) {
        student.unsubscribeCourse(course);
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        teacher.assignCourse(course);
        course.setTeacher(teacher);
    }

    public void cancelTeacherToCourse(Teacher teacher, Course course) {
        teacher.cancelCourse(course);
        course.cancelTeacher(teacher);

    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void getInfoStudentInCourse() {
        for (Student student : students) {
            System.out.println("Университет: " + name);
            System.out.println("Студент ");
            System.out.println("Имя: " + student.getName());
            System.out.println("Прикреплён к курсам: " + student.getEnrolledCourses());
            System.out.println("Идентификатор студента: " + student.getId());
            System.out.println();
        }
    }

    public void getInfoTeacherToCourse() {
        for (Teacher teacher : teachers) {
            System.out.println("Университет: " + name);
            System.out.println("Препод ");
            System.out.println("Имя: " + teacher.getName());
            System.out.println("Преподаёт курсы: " + teacher.getTeachingCourses());
            System.out.println("Идентификатор учителя: " + teacher.getId());
            System.out.println();
        }
    }

    public void getInfoTeachersAndStudents() {
        System.out.println("==");
        System.out.println("Университет: " + name);
        for (Student student : students) {
            System.out.println("Студент ");
            System.out.println("Имя: " + student.getName());
            System.out.println("Прикреплён к курсам: " + student.getEnrolledCourses());
            System.out.println("Идентификатор студента: " + student.getId());
            System.out.println();
        }
        for (Teacher teacher : teachers) {
            System.out.println("Препод ");
            System.out.println("Имя: " + teacher.getName());
            System.out.println("Преподаёт курсы: " + teacher.getTeachingCourses());
            System.out.println("Идентификатор учителя: " + teacher.getId());
            System.out.println();
        }
        System.out.println("==");
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void getInfoFaculties() {
        System.out.println("==");
        for (Faculty faculty : faculties) {
            System.out.println(faculty);
            System.out.println("Преподаватели: " + faculty.getTeachers());
            System.out.println("Студенты: " + faculty.getStudents());
            System.out.println("Курсы: " + faculty.getCourses());
            System.out.println();
        }
        System.out.println("==");

    }

}
