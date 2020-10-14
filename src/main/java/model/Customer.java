package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    @JsonProperty("contacts")
    private List<Contact> contactList;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String middleName, Integer id, List<Contact> contactList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.id = id;
        this.contactList = contactList;
    }

    public Customer(String firstName, String lastName, String middleName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactsList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", id=" + id +
                ", contactList=" + contactList +
                '}';
    }
}
