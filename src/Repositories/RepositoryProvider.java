package Repositories;

import java.util.ArrayList;

import Domain.ToyStudent.ToyStudent;

public class RepositoryProvider {

    public static Repository<ToyStudent> buildStudentRepository() {
        return new InMemoryRepository<ToyStudent>(new ArrayList<>(), "Student");
    }
}
