package nursery;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private String teacherRole;
    private NurseryClass assignedClass;

    public Teacher(String teacherId, String teacherName, String teacherRole) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherRole = teacherRole;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public NurseryClass getAssignedClass() {
        return assignedClass;
    }

    public void assignToClass(NurseryClass nurseryClass) {
        this.assignedClass = nurseryClass;
    }

    @Override
    public String toString() {
        return teacherName + " (" + teacherRole + ")";
    }
}
