package Domain.CourseManagement;

public class CourseSection {

    private String courseSectionID;
    private String instructorID;

    public CourseSection(String courseSectionID, String instructorID) {
        this.courseSectionID = courseSectionID;
        this.instructorID = instructorID;
    }

    public void updateCourseSection(String courseSectionID, String instructorID) {
        this.courseSectionID = courseSectionID;
        this.instructorID = instructorID;
    }

    public String toString() {
        return (courseSectionID + ", " + instructorID);
    }
    // need to figure out how to include infrom from Course objects in CourseSection
    // objects
}
