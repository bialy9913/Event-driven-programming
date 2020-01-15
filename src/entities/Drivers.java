package entities;

import javax.persistence.*;

@Entity
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String firstName;
    private String name;
    private String street;
    private String houseNumber;
    private String postcode;
    private String location;
    private String pesel;
    public Drivers(){

    }

    public int getDriverId() {
        return driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getLocation() {
        return location;
    }

    public String getPesel() {
        return pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
