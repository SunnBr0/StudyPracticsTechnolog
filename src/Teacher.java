package src;

import java.util.ArrayList;
import java.util.List;

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
}