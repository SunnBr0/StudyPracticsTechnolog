import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {
    private String name;
    private int id;
    private List<Course> teachingCourses;

    public Teacher(String name, int id) {
        this.name = name;
        this.id = id;
        this.teachingCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void assignCourse(Course course) {
        teachingCourses.add(course);
    }

    public void cancelCourse(Course course) {
        teachingCourses.remove(course);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Teacher))
            return false;
        Teacher that = (Teacher) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

}