package Controllers;

import java.util.ArrayList;
import java.util.Optional;

import Domain.ToyStudent.ToyStudent;
import QueryParameters.QueryParameters;
import Repositories.Repository;

public class StudentController {
    // TODO Make this the concrete student type
    private Repository<ToyStudent> repository;

    public StudentController(Repository<ToyStudent> repository) {
        this.repository = repository;
    }

    // TODO Use `QueryParams`
    public Optional<ToyStudent> fetchById(QueryParameters params) {
        return this.repository.fetchById(params.get("id"));
    }

    public ArrayList<ToyStudent> fetchMany() {
        return this.repository.fetchMany();
    }

    public void create(QueryParameters params) {
        ToyStudent student = new ToyStudent(params.get("name"), params.get("id"));

        System.out.println("Creating student: " + student);

        this.repository.create(student);
    }

    public void update(ToyStudent updatedStudent) {
        this.repository.update(updatedStudent);
    }
}