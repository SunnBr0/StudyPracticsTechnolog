import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String code;
    private Teacher teacher;
    private List<Student> enrolledStudents = new ArrayList<>(); // ← добавили

    public Course(String name, String code, Teacher teacher) {
        this.name = name;
        this.code = code;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void cancelTeacher(Teacher teacher) {
        this.teacher = null;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void unsubscribeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return name;
    }
}
