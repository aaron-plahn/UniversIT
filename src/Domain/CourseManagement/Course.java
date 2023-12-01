package Domain.CourseManagement;

import Repositories.Entity;

public class Course implements Entity {

  private String ID;
  private String name;
  private String description;
  private int creditValue;
  private Department courseDepartment;

  public Course(String ID, String name, String description, Department courseDepartment) {
    this.ID = ID;
    this.name = name;
    this.description = description;
    this.creditValue = 3;
    this.courseDepartment = courseDepartment;
  }

  public void updateCourse(String ID, String name, String description, int creditValue,
      Department courseDepartment) {
    this.ID = ID;
    this.name = name;
    this.description = description;
    this.creditValue = 3;
    this.courseDepartment = courseDepartment;
  }

  public String getId() {
    return this.ID;
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
