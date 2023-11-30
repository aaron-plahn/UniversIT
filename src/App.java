import java.util.ArrayList;
import Domain.Student.Student;
import Repositories.InMemoryRepository;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the UniversIT Information Management System");

        System.out.println("This is a COMP 1130 WL1 (Fall 2023) project.");

        // Router.execute("GET", "foo", "fetchById", "T1");

        // Router.execute("GET", "students", "", "T1");

        Router router = new Router(new InMemoryRepository<Student>(new ArrayList<Student>(), "Student"));

        router.execute("POST", "students", "", "John Doe", "T1");

        router.execute("GET", "students", "", "T1");

    }
}