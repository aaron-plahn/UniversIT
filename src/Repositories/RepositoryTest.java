package Repositories;

import java.util.ArrayList;
import java.util.Optional;

import Domain.ToyStudent.ToyStudent;

public class RepositoryTest {
    public static void main(String[] args) {
        Repository<ToyStudent> studentRepository = new InMemoryRepository<>(new ArrayList<ToyStudent>(), "Student");

        String id1 = "T445566767";

        ToyStudent student1 = new ToyStudent("Aaron Plahn", id1);

        studentRepository.create(student1);

        Optional<ToyStudent> searchResult = studentRepository.fetchById(id1);

        if (searchResult.isPresent()) {
            System.out.println("Found student with id: " + id1 + ", " + searchResult);
        } else {
            System.out.println("No result found for student with id: " + id1);
        }

        student1.promote();

        Optional<ToyStudent> searchResultForUpdatedStudent = studentRepository.fetchById(id1);

        if (searchResultForUpdatedStudent.isPresent()) {
            System.out.println("Found student with id: " + id1 + ", " + searchResult);
        } else {
            System.out.println("No result found for student with id: " + id1);
        }

        ToyStudent student2 = new ToyStudent("rookie", "T123");

        studentRepository.create(student2);

        studentRepository.fetchMany().forEach(
                student -> System.out.println(student));
    }
}
