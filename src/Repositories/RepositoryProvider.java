package Repositories;

import java.util.ArrayList;

import Domain.Student.Student;

public class RepositoryProvider {

    public static Repository<Student> buildStudentRepository() {
        return new InMemoryRepository<Student>(new ArrayList<>(), "Student");
    }
}
