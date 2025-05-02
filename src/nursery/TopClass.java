package nursery;

public class TopClass extends NurseryClass {

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    @Override
    public void enrollStudent(Student student) throws Exception {
        if (student.getAge() < 4 || student.getAge() > 5) {
            throw new Exception("Student age not suitable for Top Class (4–5 years).");
        }
        if (students.size() >= maxCapacity) {
            throw new Exception("Top Class is full.");
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
        System.out.println("Tracking reading, writing, and arithmetic development. Assessments included.");
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Conducting activity in Top Class: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Top Class Report ---");
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        trackProgress();
    }
}
