package co.sasams.service;/*
package za.co.sasams.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
//import za.co.sasams.model.ModelObject;
import za.co.sasams.util.SamsException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

*/
/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 2012/08/18
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 *//*

@Service
public abstract class DAO {
    @PersistenceContext
    protected EntityManager em;


    public <T> T find(Class<T> cls, Object id) {
        return em.find(cls, id);
    }

    public <T> T findByName(Class<T> cls, String name) {
        return (T) em.createQuery("SELECT t from " + cls.getSimpleName() + " t WHERE lower(t.name) = :name")
                .setParameter("name", name).getSingleResult();

    }

    protected ModelObject merge(Class cls, ModelObject formObject) {
        if (formObject == null) {
            return null;
        } else if (formObject.getId() == -1) {   //add new for canister upliftment model
            return persist(formObject);
        } else {
            ModelObject modelObject = (ModelObject) em.find(cls, formObject.getId());
            return toModelObject(formObject, modelObject);
        }
    }

    */
/**
     * Translate a formObject to a databaseObject
     *
     * @param formObject     data from the form
     * @param databaseObject database object
     * @return updated database object
     *//*

    protected abstract ModelObject toModelObject(ModelObject formObject, ModelObject databaseObject);

    */
/**
     * Find the entity with code or return null if it does not exist.
     *//*

    public <T> T findByCode(Class<T> cls, String code) {
        List list = em.createQuery(
                "select e from " + cls.getSimpleName() + " e " +
                        "where LOWER(e.code) = :code")
                .setParameter("code", code.toLowerCase())
                .getResultList();
        return list.isEmpty() ? null : (T) list.get(0);
    }

    */
/**
     * Find the entity with name or throw an exception if it does not exist.
     *//*

    public <T> T findByNameEx(Class<T> cls, String name) {
        T ans = findByName(cls, name);
        if (ans == null) {
            throw new SamsException(cls.getSimpleName() + " not found for name '" +
                    name + "'");
        }
        return ans;
    }

    */
/**
     * If date is a java.sql.Timestamp then convert it to a java.util.Date.
     * Date fields in classes are populated with java.sql.Timestamp instances
     * by Hibernate and java.sql.Timestamp is not available to client side
     * GWT code.
     *//*

    public static Date fix(Date date) {
        if (date instanceof Timestamp) {
            date = new Date(date.getTime());
        }
        return date;
    }

    */
/**
     * Take the week ending for a periods and count back 6 days to get to the Monday.
     * A period is from Monday to Sunday, and we only keep the weekending in the database and week starting is
     * calculated by this method.
     *//*

    protected Date getWeekStartDate(Date weekEnding) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(weekEnding);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        long weekStartInMilliseconds = cal.getTimeInMillis() - (86400000L * 6);
        return new Date(weekStartInMilliseconds);
    }

    protected int validInt(String property, String value) {
        if (value == null) {
            throw new SamsException("Invalid argument, " + property + " may not be null");
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new SamsException("Invalid argument, " + property + " must be an integer, (" + value + ") is not valid");
        }
    }

    public ModelObject persist(ModelObject object) {
        em.persist(object);
        return object;
    }

    public Query createQuery(String query) {
        return em.createQuery(query);
    }

    public void setForRollBackOnly(boolean test) {
        if (test) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

}
*/
