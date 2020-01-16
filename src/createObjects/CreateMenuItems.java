package createObjects;

import javafx.scene.control.MenuItem;

public class CreateMenuItems {
    //Car registration---------------------------------------
    private MenuItem registerCarPoland=new MenuItem();
    private MenuItem carRegistrationDeregister=new MenuItem();
    //-------------------------------------------------------
    //Car identity card--------------------------------------
    private MenuItem carIdentityCardChange=new MenuItem();
    //-------------------------------------------------------
    //Driver's licence---------------------------------------
    private MenuItem driverLicenceDuplicate=new MenuItem();
    private MenuItem driverLicenceNew=new MenuItem();
    //-------------------------------------------------------
    //Driver-------------------------------------------------
    private MenuItem driverCreateDriver=new MenuItem();
    private MenuItem driverCheckDriver=new MenuItem();
    private MenuItem driverChangeData=new MenuItem();
    //-------------------------------------------------------

    public CreateMenuItems(){
        registerCarPoland.setText("Rejejstrowanie pojazdu z kraju");
        carRegistrationDeregister.setText("Wyrejestruj samochód");
        carIdentityCardChange.setText("Wymiana dowodu z powodu brakującego miejsca na wpisy");
        driverLicenceDuplicate.setText("Wydanie wtórnika prawa jazdy ");
        driverLicenceNew.setText("Nowe prawo jazdy");
        driverCreateDriver.setText("Dodaj kierowcę");
        driverCheckDriver.setText("Sprawdź kierowcę");
        driverChangeData.setText("Zmień dane kierowcy");
    }
    public MenuItem getRegisterCarPoland() {
        return registerCarPoland;
    }
    public MenuItem getCarIdentityCardChange() {
        return carIdentityCardChange;
    }
    public MenuItem getDriverLicenceDuplicate() {
        return driverLicenceDuplicate;
    }
    public MenuItem getDriverCheckDriver() {
        return driverCheckDriver;
    }
    public MenuItem getDriverChangeData() {
        return driverChangeData;
    }
    public MenuItem getDriverCreateDriver() {
        return driverCreateDriver;
    }
    public MenuItem getDriverLicenceNew() {
        return driverLicenceNew;
    }
    public MenuItem getCarRegistrationDeregister() {
        return carRegistrationDeregister;
    }
}
