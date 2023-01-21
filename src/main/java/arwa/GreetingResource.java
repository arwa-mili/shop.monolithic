package arwa;

import io.quarkus.runtime.QuarkusApplication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public static void main(String[] args) {

    }


    public List<String> Hello() {
        return List.of("Hello","World");
    }
}