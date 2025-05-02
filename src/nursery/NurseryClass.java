package nursery;

import java.util.ArrayList;
import java.util.List;

public abstract class NurseryClass {
    protected String classId;
    protected String className;
    protected int maxCapacity;
    protected Teacher assignedTeacher;
    protected List<Student> students = new ArrayList<>();
    protected List<String> activities = new ArrayList<>();

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public void assignTeacher(Teacher teacher) throws Exception {
        this.assignedTeacher = teacher;
        teacher.assignToClass(this);
    }

    public abstract void enrollStudent(Student student) throws Exception;
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract void generateClassReport();

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public List<String> getActivities() {
        return activities;
    }
}
