package Controllers;

import java.util.ArrayList;
import java.util.Optional;

import Domain.Student.Student;
import Repositories.Repository;

public class StudentController {
    // TODO Make this the concrete student type
    private Repository<Student> repository;

    public StudentController(Repository<Student> repository) {
        this.repository = repository;
    }

    public Optional<Student> fetchById(String id) {
        return this.repository.fetchById(id);
    }

    public ArrayList<Student> fetchMany() {
        return this.repository.fetchMany();
    }

    public void create(Student student) {
        System.out.println("Creating student: " + student);

        this.repository.create(student);
    }

    public void update(Student updatedStudent) {
        this.repository.update(updatedStudent);
    }
}