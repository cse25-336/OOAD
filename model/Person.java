package model;

public abstract class Person {
    private String firstName;
    private String surname;
    private String address;
    private String phone;

    public Person(String firstName, String surname, String address, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public void updateContactDetails(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }
}