package nursery;

public class BabyClass extends NurseryClass {

    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    @Override
    public void enrollStudent(Student student) throws Exception {
        if (student.getAge() < 2 || student.getAge() > 3) {
            throw new Exception("Student age not suitable for Baby Class (2–3 years).");
        }
        if (students.size() >= maxCapacity) {
            throw new Exception("Baby Class is full.");
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
        System.out.println("Tracking motor skills and play-based learning.");
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Conducting activity in Baby Class: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Baby Class Report ---");
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        trackProgress();
    }

    @Override
    public void assignTeacher(Teacher teacher) throws Exception {
        if (!teacher.getTeacherRole().equals("Early Childhood Educator")) {
            throw new Exception("Only Early Childhood Educators can be assigned to Baby Class.");
        }
        super.assignTeacher(teacher);
    }
}
