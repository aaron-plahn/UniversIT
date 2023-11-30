import QueryParameters.QueryParameters;

public interface RequestHandler {
    void handle(QueryParameters params);
}
