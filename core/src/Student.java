import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;
    private List<Course> enrolledCourses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void unsubscribeCourse(Course course) {
        enrolledCourses.remove(course);
    }

    @Override
    public String toString() {
        return name;
    }
}
