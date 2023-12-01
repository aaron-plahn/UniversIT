import java.util.ArrayList;

import Domain.CourseManagement.Course;
import Domain.Student.Student;
import Repositories.InMemoryRepository;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the UniversIT Information Management System");

        System.out.println("This is a COMP 1130 WL1 (Fall 2023) project.");

        InMemoryRepository<Student> studentRepository = new InMemoryRepository<Student>(new ArrayList<Student>(),
                "Student");

        InMemoryRepository<Course> courseRepository = new InMemoryRepository<Course>(new ArrayList<Course>(), "Course");

        Router router = new Router(studentRepository, courseRepository);

        router.execute(
                "POST:students/?id=T1&firstName=Barley&middleName=Boe&lastName=Peep&streetNumber=22&addressLineOne=woofyWay&addressLineTwo=apt3&cityName=Dogville&postalCode=V2G5G6");

        router.execute("GET:students/?id=T1");

        router.execute(
                "POST:courses/create?id=COMP1130&name=Java&description=Best comp course ever&department=COMPUTERSCIENCE");

        // router.execute("GET:grades/?studentId=55");

        // router.execute("GET:schedule/?timeSlot=1");

    }
}