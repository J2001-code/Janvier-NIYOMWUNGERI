package nursery;

public class MiddleClass extends NurseryClass {

    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    @Override
    public void enrollStudent(Student student) throws Exception {
        if (student.getAge() < 3 || student.getAge() > 4) {
            throw new Exception("Student age not suitable for Middle Class (3–4 years).");
        }
        if (students.size() >= maxCapacity) {
            throw new Exception("Middle Class is full.");
        }
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                throw new Exception("Duplicate student ID.");
            }
        }
        if (student.getRegisteredClass() != null) {
            throw new Exception("Student already enrolled in a class.");
        }

        students.add(student);
        student.setRegisteredClass(this);
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking language development and basic counting skills.");
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Conducting activity in Middle Class: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Middle Class Report ---");
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        trackProgress();
    }
}
