package Domain.CourseManagement;

import java.util.ArrayList;

public class CourseManager {

    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<CourseSection> courseSections = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(int index, String ID, String name, String description, int creditValue,
            Department.department department) {
        if (index >= 0 && index < courses.size()) {
            Course course = courses.get(index);
            course.updateCourse(ID, name, description, creditValue, department);
        } else {
            System.out.println("index not available");
        }
    }

    public void updateCourseDescription(int index, String description) {
        if (index >= 0 && index < courses.size()) {
            Course course = courses.get(index);
            course.setDescription(description);
        } else {
            System.out.println("index not available");
        }
    }

    public void removeCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            courses.remove(index);
        } else {
            System.out.println("index not available");
        }
    }

    public void addCourseSection(CourseSection courseSection) {
        courseSections.add(courseSection);
    }

    public void updateCourseSection(int index, String courseSectionID, String instructorID) {
        if (index >= 0 && index < courseSections.size()) {
            CourseSection courseSection = courseSections.get(index);
            courseSection.updateCourseSection(courseSectionID, instructorID);
        } else {
            System.out.println("index not available");
        }
    }

    public void removeCourseSection(int index) {
        if (index >= 0 && index < courseSections.size()) {
            courseSections.remove(index);
        } else {
            System.out.println("index not available");
        }
    }
}