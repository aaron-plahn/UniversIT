import java.util.HashMap;
import java.util.Optional;

import Controllers.CourseController;
import Controllers.StudentController;
import Domain.CourseManagement.Course;
import Domain.Student.Student;
import QueryParameters.QueryParameters;
import Repositories.Repository;

public class Router {
    final static private String GET = "GET";

    final static private String POST = "POST";

    private HashMap<String, RequestHandler> routes;

    private Repository<Student> studentRepository;

    private Repository<Course> courseRepository;

    public Router(Repository<Student> studentRepository, Repository<Course> courseRepository) {
        this.studentRepository = studentRepository;

        this.courseRepository = courseRepository;

        this.routes = new HashMap<String, RequestHandler>();
    }

    public Router register(String path, RequestHandler handler) {
        this.routes.put(path, handler);

        return this;
    }

    public void routeRequest(String url) {
        // Extract the path up to the query params
        String route = url.split("\\?", -1)[0];

        this.routes.get(route).handle(new QueryParameters(url));
    }

    public void execute(String url) {
        // {METHOD}:{SCOPE}/{ACTION}?{PARAMS}
        String[] splitOnColon = url.split("\\:", -1);

        String method = splitOnColon[0];

        String scope = splitOnColon[1].split("/", -1)[0];

        String[] afterSlashSplitOnQuestionMark = splitOnColon[1].split("/", -1)[1].split("\\?", -1);

        String action = afterSlashSplitOnQuestionMark.length == 1 ? "" : afterSlashSplitOnQuestionMark[0];

        QueryParameters params = new QueryParameters(url);

        execute(method, scope, action, params);
    }

    public void execute(String method, String scope, String action, QueryParameters params) {
        StudentController studentController = new StudentController(this.studentRepository);

        if (scope.equals("students")) {

            if (method.equals(GET)) {
                if (action.equals("")) {

                    Optional<Student> result = studentController.fetchById(params);

                    if (result.isPresent()) {
                        Student foundStudent = result.get();

                        System.out.println("[FOUND]: Student " + foundStudent);
                    } else {
                        System.out.println("[NOT FOUND]: Student");
                    }

                    return;

                }
            }

            if (method.equals(POST)) {
                if (action.equals("")) {
                    studentController.create(params);

                    return;
                }

            }
        }

        if (scope.equals("grades")) {
            if (method.equals(POST)) {
                if (action.equals("recordGrade")) {
                    studentController.recordGrade(params);
                }
            }

            if (method.equals(GET)) {
                if (action.equals("transcript")) {
                    System.out.println(studentController.getTranscript(params));
                }
            }

            return;
        }

        if (scope.equals("courses")) {
            CourseController controller = new CourseController(this.courseRepository);

            if (method.equals(POST)) {
                if (action.equals("create")) {
                    controller.create(params);

                    return;
                }
            }
        }

        if (scope.equals("schedule")) {
            System.out.println("Not supported: schedule");
            return;
        }

        System.out.println("Missing route: " + "[" + method + "] " + scope + "/" + action);
    }
}
