import java.util.ArrayList;

import Domain.ToyStudent.ToyStudent;
import Repositories.InMemoryRepository;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the UniversIT Information Management System");

        System.out.println("This is a COMP 1130 WL1 (Fall 2023) project.");

        Router router = new Router(new InMemoryRepository<ToyStudent>(new ArrayList<ToyStudent>(), "Student"));

        router.execute("POST:students/?id=T1&name=Bobby");

        router.execute("GET:students/?id=T1");

        router.execute("GET:courses/?id=345");

        router.execute("GET:grades/?studentId=55");

        router.execute("GET:schedule/?timeSlot=1");

    }
}