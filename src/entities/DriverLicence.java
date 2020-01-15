package entities;

import javax.persistence.*;

@Entity
public class DriverLicence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverLicenceId;
    private int driverId;
    private java.sql.Date validateTo;
    private String validate;
    public DriverLicence(){

    }

    public int getDriverLicenceId() {
        return driverLicenceId;
    }

    public int getDriverId() {
        return driverId;
    }

    public java.sql.Date getValidateTo() {
        return validateTo;
    }

    public String getValidate() {
        return validate;
    }

    public void setDriverLicenceId(int driverLicenceId) {
        this.driverLicenceId = driverLicenceId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setValidateTo(java.sql.Date validateTo) {
        this.validateTo = validateTo;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
