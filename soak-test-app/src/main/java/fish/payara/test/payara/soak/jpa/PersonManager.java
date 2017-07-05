package fish.payara.test.payara.soak.jpa;

import fish.payara.test.payara.soak.jpa.entity.Person;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author Matt Gill
 */
@Named
@RequestScoped
public class PersonManager implements Serializable {

    @Resource
    private UserTransaction utx;

    @PersistenceContext(unitName = "soakTestPU")
    private EntityManager em;

    public List<Person> getAllPeople() {
        Query query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> people = query.getResultList();
        
        if(people.size() > 1000) {
            deleteAllPeople();
        }
        
        return people;
    }

    public String deleteAllPeople() {
        startTransaction();
        Query query = em.createNamedQuery("Person.deleteAll", Person.class);
        int count = query.executeUpdate();
        endTransaction();
        return "Successfully deleted all " + count + " records.";
    }

    public String addPerson(final Person person) {
        startTransaction();
        em.persist(person);
        endTransaction();
        return "Successfully added person: " + person.getTitle() + " " + person.getFirstname() + " " + person.getSurname()+ ".";
    }

    public void startTransaction() {
        try {
            utx.begin();
        } catch (NotSupportedException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void endTransaction() {
        try {
            utx.commit();
        } catch (RollbackException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
