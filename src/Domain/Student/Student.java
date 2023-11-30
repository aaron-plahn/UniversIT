package Domain.Student;

import java.util.ArrayList;

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

    public Student(StudentInfo studentsInfo, String studentNumber) {
        this.studentInfo = studentsInfo;
        this.studentNumber = studentNumber;

    }

    public String toString() {
        if (minor.isEmpty())
            return studentNumber + " Major: " + major + "enrolled in: " + currentNumberOfClasses + "/"
                    + maxNumberOfClasses + " classes";
        return "T007" + studentNumber + " Major: " + major + "Minor:" + minor + currentNumberOfClasses + "/"
                + maxNumberOfClasses;
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

}
