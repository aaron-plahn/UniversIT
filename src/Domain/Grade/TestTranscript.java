package Domain.Grade;

public class TestTranscript {
    // this is just a test class
    public static void main(String[] args) throws Exception {
        CourseOutcome courseOutcome = new CourseOutcome("F23", "ENGL3340", Grade.A);
        CourseOutcome courseOutcome2 = new CourseOutcome("F23", "ENGL1100", Grade.B);
        CourseOutcome courseOutcome3 = new CourseOutcome("F23", "COMP1300", Grade.C);
        Transcript transcript = new Transcript(courseOutcome, courseOutcome2, courseOutcome3);
        System.out.println(transcript.toString());

    }
}