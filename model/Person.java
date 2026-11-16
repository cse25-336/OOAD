package model;

public abstract class Person {
    protected String firstName;
    protected String surname;
    protected String address;
    protected String phone;

    public Person(String firstName, String surname, String address, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public abstract String displayContactDetails();
}