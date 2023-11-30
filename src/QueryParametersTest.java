public class QueryParametersTest {
    public static void main(String[] args) {
        QueryParameters qps = new QueryParameters("app/users?id=22&name=Bro");

        String name = qps.get("name");

        System.out.println("name: " + name);

        String id = qps.get("id");

        System.out.println("id: " + id);
    }
}
