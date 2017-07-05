package fish.payara.test.payara.soak.rest;

import fish.payara.test.payara.soak.jpa.entity.Person;
import fish.payara.test.payara.soak.jpa.PersonManager;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Matt Gill
 */
@Path("/person")
@RequestScoped
public class PersonEndpoints implements Serializable {

    @Inject
    private PersonManager manager;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() {
        return manager.getAllPeople();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addPerson(final Person person) {
        return manager.addPerson(person);
    }
}
