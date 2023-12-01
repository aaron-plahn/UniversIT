package Domain.Student;

import java.util.ArrayList;

import Domain.Grade.CourseOutcome;
import Repositories.Entity;

public class Student implements Entity {
    private final byte MAX_NUMBER_OF_CLASSES_AT_ONCE = 7;
    private final byte MIN_MAX_NUMBER_OF_CLASSES_AT_ONCE = 2;
    private StudentInfo studentInfo;
    private byte maxNumberOfClasses = 5;
    private byte currentNumberOfClasses = 0; // using byte because the number shouldn't get bigger
    private String studentNumber;
    private String major = "undecided";
    private String minor = "";
    private ArrayList<String> courseIDs = new ArrayList<>();
    private ArrayList<CourseOutcome> courseOutcomes = new ArrayList<CourseOutcome>();

    public Student(StudentInfo studentsInfo, String studentNumber) {
        this.studentInfo = studentsInfo;
        this.studentNumber = studentNumber;

    }

    public String toString() {
        String studentNameAndIdAndMajor = "" + studentInfo.getName() + " (" + studentNumber + ")" + " Major: " + major;

        String classSummary = " enrolled in: " + currentNumberOfClasses + "/" + maxNumberOfClasses + " classes";

        if (minor.isEmpty())
            return studentNameAndIdAndMajor + classSummary;
        return studentNameAndIdAndMajor + " Minor: " + minor + " " + classSummary;
    }

    // private void makeStudentNumber() {
    // Random random = new Random();
    // DecimalFormat format = new DecimalFormat("0000000");
    // // TODO [AP] This wouldn't compile so I tweaked it, but this might not be the
    // // right logic
    // String studentsNumberAsString = format.format(random.nextInt(999998));
    // this.studentNumber = Long.parseLong(studentsNumberAsString);
    // // thinking of having a list array instead taking a random, take a random
    // index
    // // from it and removing that posibility

    // }

    public void updateMajor(String newMajor) {
        this.major = newMajor;
    }

    public void updateMinor(String newMinor) {
        this.minor = newMinor;
    }

    public StudentInfo getStudentInfo(/* long securityCode? */) {

        return studentInfo;
    }

    public void enrollIn(String courseID) {
        if (currentNumberOfClasses < maxNumberOfClasses) {
            courseIDs.add(courseID);
            currentNumberOfClasses++;
        }
    }

    public void drop(String courseID) {
        currentNumberOfClasses--;
        courseIDs.remove(courseID);
    }

    public String[] getActiveCourseIDs() {
        String[] courseIDsAsArray = courseIDs.toArray(new String[courseIDs.size()]);

        return courseIDsAsArray;
    }

    public boolean hasEnoughClasses() {
        return currentNumberOfClasses <= MIN_MAX_NUMBER_OF_CLASSES_AT_ONCE;
    }

    public void updateMaxNumberOfClasses(byte newMaxNumber) {
        if (newMaxNumber >= MIN_MAX_NUMBER_OF_CLASSES_AT_ONCE && newMaxNumber <= MAX_NUMBER_OF_CLASSES_AT_ONCE)
            maxNumberOfClasses = newMaxNumber;
    }

    public String getId() {
        return this.studentNumber;
    }

    public Student recordCourseOutcome(CourseOutcome courseOutcome) {
        courseOutcomes.add(courseOutcome);

        return this;
    }

    public ArrayList<CourseOutcome> getCourseOutcomes() {
        return courseOutcomes;
    }

}
