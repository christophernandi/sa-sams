package co.sasams.dto;

//import za.co.sasams.model.Employees;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 2012/08/18
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddEditCustomerParameters {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected int postaCode;
    protected String city;
//    protected Employees employee;
    protected String state;
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPostaCode() {
        return postaCode;
    }

    public void setPostaCode(int postaCode) {
        this.postaCode = postaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

     public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
