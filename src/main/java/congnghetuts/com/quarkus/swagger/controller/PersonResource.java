package congnghetuts.com.quarkus.swagger.controller;

import congnghetuts.com.quarkus.swagger.model.Person;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Path("/person")
public class PersonResource {

    private List<Person> people = new ArrayList<>();

    public PersonResource() {
        people.add(new Person(1, "Nguyen Van A", "nguyenvana@gmail.com"));
        people.add(new Person(2, "Nguyen Van B", "nguyenvanb@gmail.com"));
    }


    @GET
    public List<Person> getALl() {
        return people;
    }

    @Operation(summary = "Tao moi mot persion")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Person duoc tao thanh cong!",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    )
            }
    )
    @POST
    public void Add(Person person) {
        people.add(person);
    }
}