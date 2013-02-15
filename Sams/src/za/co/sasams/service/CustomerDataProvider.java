package za.co.sasams.service;

import org.springframework.stereotype.Repository;
import za.co.sasams.model.Customers;
//import za.co.sasams.model.ModelObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 2012/08/18
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CustomerDataProvider {

    @PersistenceContext
    protected EntityManager em;

    public List<Customers> searchCustomers() {
        return em.createQuery("SELECT c FROM Customers c").getResultList();
    }

    public Customers find(int id) {
        System.out.println("INSIDE FIND " + id);
        Customers c = (Customers) em.find(Customers.class, id);
        System.out.println("Customer toString "+c.toString());
        return c;
    }

//    @Override
//    protected ModelObject toModelObject(ModelObject formObject, ModelObject databaseObject) {
//        return persist(formObject);
//    }
}
