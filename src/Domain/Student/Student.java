package Domain.Student;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Student {
    private final byte MAX_NUMBER_OF_CLASSES_AT_ONCE = 7;
    private final byte MIN_MAX_NUMBER_OF_CLASSES_AT_ONCE = 2;
    private StudentInfo studentInfo;
    private byte maxNumberOfClasses = 5;
    private byte currentNumberOfClasses = 0; // using byte because the number shouldn't get bigger
    private long studentNumber; // T00 added at toString currently
    private String major = "undecided";
    private String minor = "";
    private ArrayList<String> courseIDs = new ArrayList<>();

    public Student(StudentInfo studentsInfo) {
        this.studentInfo = studentsInfo;
        makeStudentNumber();

    }

    public String toString() {
        if (minor.isEmpty())
            return "T007" + studentNumber + " Major: " + major + currentNumberOfClasses + "/" + maxNumberOfClasses;
        return "T007" + studentNumber + " Major: " + major + "Minor:" + minor + currentNumberOfClasses + "/"
                + maxNumberOfClasses;
    }

    private void makeStudentNumber() {
        Random random = new Random();
        DecimalFormat format = new DecimalFormat("0000000");
        // TODO [AP] This wouldn't compile so I tweaked it, but this might not be the
        // right logic
        String studentsNumberAsString = format.format(random.nextInt(999998));
        this.studentNumber = Long.parseLong(studentsNumberAsString);
        // thinking of having a list array instead taking a random, take a random index
        // from it and removing that posibility

    }

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

}
