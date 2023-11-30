package Controllers;

import java.util.ArrayList;
import java.util.Optional;

import Domain.Student.Student;
import QueryParameters.QueryParameters;
import Repositories.Repository;

public class StudentController {
    // TODO Make this the concrete student type
    private Repository<Student> repository;

    public StudentController(Repository<Student> repository) {
        this.repository = repository;
    }

    // TODO Use `QueryParams`
    public Optional<Student> fetchById(QueryParameters params) {
        return this.repository.fetchById(params.get("id"));
    }

    public ArrayList<Student> fetchMany() {
        return this.repository.fetchMany();
    }

    public void create(QueryParameters params) {
        Student student = new Student(params.get("name"), params.get("id"));

        System.out.println("Creating student: " + student);

        this.repository.create(student);
    }

    public void update(Student updatedStudent) {
        this.repository.update(updatedStudent);
    }
}