package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CarIdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carIdentityCardId;
    private String vinNumber;
    private String plateNumber;
    private String carMake;
    private String carModel;
    private String engineCapacity;
    private java.sql.Date dateOfRelease;
    private String validate;
    public CarIdentityCard(){

    }

    public int getCarIdentityCardId() {
        return carIdentityCardId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public String getValidate() {
        return validate;
    }

    public void setCarIdentityCardId(int carIdentityCardId) {
        this.carIdentityCardId = carIdentityCardId;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
