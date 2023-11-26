package Repositories;

import java.util.ArrayList;
import java.util.Optional;

import Domain.Student.Student;

public class RepositoryTest {
    public static void main(String[] args) {
        Repository<Student> studentRepository = new InMemoryRepository<>(new ArrayList<Student>(), "Student");

        String id1 = "T445566767";

        Student student1 = new Student("Aaron Plahn", id1);

        studentRepository.create(student1);

        Optional<Student> searchResult = studentRepository.fetchById(id1);

        if (searchResult.isPresent()) {
            System.out.println("Found student with id: " + id1 + ", " + searchResult);
        } else {
            System.out.println("No result found for student with id: " + id1);
        }

        student1.promote();

        Optional<Student> searchResultForUpdatedStudent = studentRepository.fetchById(id1);

        if (searchResultForUpdatedStudent.isPresent()) {
            System.out.println("Found student with id: " + id1 + ", " + searchResult);
        } else {
            System.out.println("No result found for student with id: " + id1);
        }

        Student student2 = new Student("rookie", "T123");

        studentRepository.create(student2);

        studentRepository.fetchMany().forEach(
                student -> System.out.println(student));
    }
}
