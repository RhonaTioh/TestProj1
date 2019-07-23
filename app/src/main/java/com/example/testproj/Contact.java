package com.example.testproj;

public class Contact {

    private int Id;
    private String Name, ContactPerson, Contact, Email, Director1, Director2, Director3, Secretary, Shareholder1, Shareholder2, Shareholder3, financialYearEndDate;

    public Contact(int id, String name, String contactPerson, String contact, String email, String director1, String director2, String director3, String secretary, String shareholder1, String shareholder2, String shareholder3, String financialYearEndDate) {
        Id = id;
        Name = name;
        ContactPerson = contactPerson;
        Contact = contact;
        Email = email;
        Director1 = director1;
        Director2 = director2;
        Director3 = director3;
        Secretary = secretary;
        Shareholder1 = shareholder1;
        Shareholder2 = shareholder2;
        Shareholder3 = shareholder3;
        this.financialYearEndDate = financialYearEndDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String contactPerson) {
        ContactPerson = contactPerson;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDirector1() {
        return Director1;
    }

    public void setDirector1(String director1) {
        Director1 = director1;
    }

    public String getDirector2() {
        return Director2;
    }

    public void setDirector2(String director2) {
        Director2 = director2;
    }

    public String getDirector3() {
        return Director3;
    }

    public void setDirector3(String director3) {
        Director3 = director3;
    }

    public String getSecretary() {
        return Secretary;
    }

    public void setSecretary(String secretary) {
        this.Secretary = secretary;
    }

    public String getShareholder1() {
        return Shareholder1;
    }

    public void setShareholder1(String shareholder1) {
        Shareholder1 = shareholder1;
    }

    public String getShareholder2() {
        return Shareholder2;
    }

    public void setShareholder2(String shareholder2) {
        Shareholder2 = shareholder2;
    }

    public String getShareholder3() {
        return Shareholder3;
    }

    public void setShareholder3(String shareholder3) {
        Shareholder3 = shareholder3;
    }

    public String getFinancialYearEndDate() {
        return financialYearEndDate;
    }

    public void setFinancialYearEndDate(String financialYearEndDate) {
        this.financialYearEndDate = financialYearEndDate;
    }
}