package fish.payara.test.payara.soak.jsf;

import fish.payara.test.payara.soak.jpa.PersonManager;
import fish.payara.test.payara.soak.jpa.entity.Person;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Matt Gill
 */
@Named
@RequestScoped
public class PersonBean implements Serializable{
    
    @Inject
    private PersonManager manager;
    
    private Person person;
    
    private String outputMessage;
    
    @PostConstruct
    public void init() {
        outputMessage = "";
        person = new Person();
    }
    
    public void create() {
        outputMessage = manager.addPerson(person);
    }
    
    public void deleteAll() {
        outputMessage = manager.deleteAllPeople();
    }
    
    public Person getPerson() {
        return person;
    }
    
    public String getOutputMessage() {
        return outputMessage;
    }
    
}
