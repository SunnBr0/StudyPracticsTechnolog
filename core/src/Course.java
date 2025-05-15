public class Course {
    private String name;
    private String code;
    private Teacher teacher;

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

    @Override
    public String toString() {
        return name;
    }
}
