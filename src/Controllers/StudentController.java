package Controllers;

import java.util.ArrayList;

import Repositories.Entity;
import Repositories.Repository;

public class StudentController {
    // TODO Make this the concrete student type
    private Repository<Entity> repository;

    public StudentController(Repository<Entity> repository) {
        this.repository = repository;
    }

    ArrayList<Entity> fetchMany() {
        return new ArrayList<Entity>();
    }
}