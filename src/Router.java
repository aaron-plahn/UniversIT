import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import Controllers.StudentController;
import Domain.Student.Student;
import QueryParameters.QueryParameters;
import Repositories.InMemoryRepository;

public class Router {
    final static private String GET = "GET";

    final static private String POST = "POST";

    private HashMap<String, RequestHandler> routes;

    private InMemoryRepository<Student> studentRepository;

    public Router(InMemoryRepository<Student> studentRepository) {
        this.studentRepository = studentRepository;

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
        if (scope.equals("students")) {
            StudentController controller = new StudentController(this.studentRepository);

            if (method.equals(GET)) {
                if (action.equals("")) {

                    Optional<Student> result = controller.fetchById(params);

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
                    controller.create(params);

                    return;
                }

            }

        }

        System.out.println("Missing route: " + "[" + method + "] " + scope + "/" + action);
    }
}
