package Controllers;

import Domain.CourseManagement.Course;
import Domain.CourseManagement.Department;
import QueryParameters.QueryParameters;
import Repositories.Repository;

public class CourseController {
    private Repository<Course> repository;

    public CourseController(Repository<Course> repository) {
        this.repository = repository;
    }

    public void create(QueryParameters params) {
        // TODO Deal with mapping the department string to an enum
        Course newCourse = new Course(params.get("id"), params.get("name"), params.get("description"),
                Department.COMPUTERSCIENCE);

        repository.create(newCourse);

        System.out.println("Created course: " + newCourse);
    }
}
