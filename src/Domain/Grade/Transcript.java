package Domain.Grade;

public class Transcript {
    private double totalGradePoints;
    private CourseOutcome[] courseOutcomes;
    private String outcomeString = "";

    public Transcript(CourseOutcome... courseOutcome) {
        this.courseOutcomes = courseOutcome;
    }

    public double getGpa() {
        if (courseOutcomes.length == 0) {
            System.out.println("Error, no course outcomes available");
            return -1;
        }
        for (CourseOutcome outcome : courseOutcomes)
            totalGradePoints = totalGradePoints + outcome.getGradePoints();

        return totalGradePoints / courseOutcomes.length;

    }

    public String toString() {
        for (CourseOutcome outcome : courseOutcomes) {
            outcomeString = outcomeString + outcome + "\n";
        }

        return ("Courses: " + "\n" + outcomeString + "GPA: " + this.getGpa());

    }

}
