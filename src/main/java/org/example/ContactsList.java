package org.example;



public class ContactsList {
    private String names;
    private String email;
    private String number;

    public ContactsList(String names, String email, String number) {
        this.names = names;
        this.email = email;
        this.number = number;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
