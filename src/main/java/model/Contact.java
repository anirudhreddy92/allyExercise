package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
    private Integer id;
    @JsonProperty("isPrimaryContact")
    private Boolean isPrimaryContact;
    private Integer phoneNumber;
    private Integer secondaryPhoneNumber;
    private String homeAddress;
    private Integer zip;
    private String state;

    public Contact() {
    }

    public Contact(Integer id, Boolean isPrimaryContact, Integer phoneNumber, Integer secondaryPhoneNumber, String homeAddress, Integer zip, String state) {
        this.id = id;
        this.isPrimaryContact = isPrimaryContact;
        this.phoneNumber = phoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.homeAddress = homeAddress;
        this.zip = zip;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPrimaryContact() {
        return isPrimaryContact;
    }

    public void setPrimaryContact(Boolean primaryContact) {
        isPrimaryContact = primaryContact;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(Integer secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", isPrimaryContact=" + isPrimaryContact +
                ", phoneNumber=" + phoneNumber +
                ", secondaryPhoneNumber=" + secondaryPhoneNumber +
                ", homeAddress='" + homeAddress + '\'' +
                ", zip=" + zip +
                ", state='" + state + '\'' +
                '}';
    }
}
