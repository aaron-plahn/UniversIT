package Domain.CourseManagement;

public class Course {

  private String ID;
  private String name;
  private String description;
  private int creditValue;
  private Department.department courseDepartment;

  public Course(String ID, String name, String description, int creditValue, Department.department courseDepartment) {
    this.ID = ID;
    this.name = name;
    this.description = description;
    this.creditValue = 3;
    this.courseDepartment = courseDepartment;
  }

  public void updateCourse(String ID, String name, String description, int creditValue,
      Department.department courseDepartment) {
    this.ID = ID;
    this.name = name;
    this.description = description;
    this.creditValue = 3;
    this.courseDepartment = courseDepartment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String toString() {
    return (name + ID + ", " + courseDepartment + ", " + description + ", credit value: " + creditValue);
  }

}
