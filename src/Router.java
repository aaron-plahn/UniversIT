import java.util.Optional;

import Controllers.StudentController;
import Domain.Student.Student;
import Repositories.InMemoryRepository;

public class Router {
    final static private String GET = "GET";

    final static private String POST = "POST";

    private InMemoryRepository<Student> studentRepository;

    public Router(InMemoryRepository<Student> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(String method, String scope, String action, String... args) {
        if (scope.equals("students")) {
            StudentController controller = new StudentController(this.studentRepository);

            if (method.equals(GET)) {
                if (action.equals("")) {

                    Optional<Student> result = controller.fetchById(args[0]);

                    if (result.isPresent()) {
                        System.out.println("[FOUND]: Student : (" + args[0] + ")" + "\n" + result.get());
                    } else {
                        System.out.println("[NOT FOUND]: Student: (" + args[0] + ")");
                    }

                    return;

                }
            }

            if (method.equals(POST)) {
                String newId = args[1];

                if (action.equals("")) {
                    Student newStudent = new Student(args[0], newId);

                    controller.create(newStudent);

                    System.out.println("[Created]: Student: " + newStudent);

                    return;
                }

            }

        }

        System.out.println("Missing route: " + "[" + method + "] " + scope + "/" + action);
    }
}
