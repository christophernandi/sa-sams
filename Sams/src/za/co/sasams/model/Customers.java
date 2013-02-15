package za.co.sasams.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/08/22
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Customers {
    private int customerNumber;

    @javax.persistence.Column(name = "customerNumber")
    @Id
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    private String customerName;

    @javax.persistence.Column(name = "customerName")
    @Basic
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String contactLastName;

    @javax.persistence.Column(name = "contactLastName")
    @Basic
    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    private String contactFirstName;

    @javax.persistence.Column(name = "contactFirstName")
    @Basic
    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    private String phone;

    @javax.persistence.Column(name = "phone")
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String addressLine1;

    @javax.persistence.Column(name = "addressLine1")
    @Basic
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    private String addressLine2;

    @javax.persistence.Column(name = "addressLine2")
    @Basic
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    private String city;

    @javax.persistence.Column(name = "city")
    @Basic
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String state;

    @javax.persistence.Column(name = "state")
    @Basic
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String postalCode;

    @javax.persistence.Column(name = "postalCode")
    @Basic
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String country;

    @javax.persistence.Column(name = "country")
    @Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private int salesRepEmployeeNumber;

    @javax.persistence.Column(name = "salesRepEmployeeNumber")
    @Basic
    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    private double creditLimit;

    @javax.persistence.Column(name = "creditLimit")
    @Basic
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (Double.compare(customers.creditLimit, creditLimit) != 0) return false;
        if (customerNumber != customers.customerNumber) return false;
        if (salesRepEmployeeNumber != customers.salesRepEmployeeNumber) return false;
        if (addressLine1 != null ? !addressLine1.equals(customers.addressLine1) : customers.addressLine1 != null)
            return false;
        if (addressLine2 != null ? !addressLine2.equals(customers.addressLine2) : customers.addressLine2 != null)
            return false;
        if (city != null ? !city.equals(customers.city) : customers.city != null) return false;
        if (contactFirstName != null ? !contactFirstName.equals(customers.contactFirstName) : customers.contactFirstName != null)
            return false;
        if (contactLastName != null ? !contactLastName.equals(customers.contactLastName) : customers.contactLastName != null)
            return false;
        if (country != null ? !country.equals(customers.country) : customers.country != null) return false;
        if (customerName != null ? !customerName.equals(customers.customerName) : customers.customerName != null)
            return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (postalCode != null ? !postalCode.equals(customers.postalCode) : customers.postalCode != null) return false;
        if (state != null ? !state.equals(customers.state) : customers.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = customerNumber;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (contactLastName != null ? contactLastName.hashCode() : 0);
        result = 31 * result + (contactFirstName != null ? contactFirstName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + salesRepEmployeeNumber;
        temp = creditLimit != +0.0d ? Double.doubleToLongBits(creditLimit) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
