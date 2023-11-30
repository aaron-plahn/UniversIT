public class CourseOutcome {
    private String semester;
    private String courseID;
    private Grade Grade;

    public CourseOutcome(String semester, String courseID, Grade grade) {

        this.semester = semester;
        this.courseID = courseID;
        this.Grade = grade;

    }

    public String toString() {

        return courseID + ", " + semester + ", Grade: " + Grade;
    }

    // good OOP here!
    public double getGradePoints() {
        double courseGradePoints;
        switch (Grade) {
            case A:
                courseGradePoints = 4;
                break;
            case B:
                courseGradePoints = 3;
                break;
            case C:
                courseGradePoints = 2;
                break;
            case D:
                courseGradePoints = 1;
                break;
            case F:
                courseGradePoints = 0;
                break;
            default:
                courseGradePoints = -1;
                System.out.println("Error set to -1");

        }
        return courseGradePoints;
    }

}
