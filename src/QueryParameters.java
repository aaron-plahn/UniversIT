import java.util.HashMap;
import java.util.Optional;

public class QueryParameters {
    private HashMap<String, String> paramMap;

    // Note that this is quick-and-dirty for demo purposes
    QueryParameters(String path) {
        this.paramMap = new HashMap<String, String>();

        // extract what comes after the ?, e.g. "app/users?name=foo&age=22" ->
        // "?name=foo&age=22"
        String query = path.split("\\?", -1)[1];

        // extract each separate "name=foo"
        String[] paramDefinitions = query.split("\\&", -1);

        for (String paramDefinition : paramDefinitions) {
            String[] nameAndValue = paramDefinition.split("=", -1);

            this.paramMap.put(nameAndValue[0], nameAndValue[1]);
        }
    }

    String get(String parameterName) {
        return this.paramMap.get(parameterName);
    }
}
