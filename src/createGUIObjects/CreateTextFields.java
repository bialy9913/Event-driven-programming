package createGUIObjects;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class CreateTextFields {
    private int APP_W;
    private int APP_H;
    private TextField textFieldLogin=new TextField();
    private PasswordField passwordField=new PasswordField();

    private TextField carRegistrationDriverPesel=new TextField();
    private TextField carRegistrationVinNumber=new TextField();
    private TextField carRegistrationPlateNumber=new TextField();
    private TextField carRegistrationCarMake=new TextField();
    private TextField carRegistrationCarModel=new TextField();
    private TextField carRegistrationEngineCapacity=new TextField();

    private TextField carRegistrationDeregisterVinNumber=new TextField();

    private TextField createEmployeeShortName=new TextField();
    private TextField createEmployeeLogin=new TextField();
    private PasswordField createEmployeePassword=new PasswordField();

    //---------------Driver---------------------------------------------
    //Create driver-----------------------------------------------------
    private TextField driverFirstName=new TextField();
    private TextField driverName=new TextField();
    private TextField driverStreet=new TextField();
    private TextField driverHouseNumber=new TextField();
    private TextField driverPostCode=new TextField();
    private TextField driverLocation=new TextField();
    private TextField driverPesel=new TextField();
    //------------------------------------------------------------------
    //Change driver data------------------------------------------------
    private TextField driverDataFirstName=new TextField();
    private TextField driverDataName=new TextField();
    private TextField driverDataStreet=new TextField();
    private TextField driverDataHouseNumber=new TextField();
    private TextField driverDataLocation=new TextField();
    private TextField driverDataPostCode=new TextField();
    //------------------------------------------------------------------
    //Check driver------------------------------------------------------
    private TextField driverGivenPesel=new TextField();
    //------------------------------------------------------------------
    private TextField carIdentityCardVinNumber=new TextField();
    //------------------------------------------------------------------

    public CreateTextFields(int APP_W,int APP_H)
    {
        this.APP_W=APP_W;
        this.APP_H=APP_H;
        textFieldLogin.setPrefSize(200,31);
        textFieldLogin.setTranslateX(APP_W/2.0-textFieldLogin.getPrefWidth()/2.0);
        textFieldLogin.setTranslateY(APP_H/2.0-textFieldLogin.getPrefHeight()/2.0);
        textFieldLogin.setPromptText("Login");
        textFieldLogin.setBackground(new Background(new BackgroundFill(Color.WHITE,
            new CornerRadii(1024), null)));
        passwordField.setPrefSize(200,13);
        passwordField.setTranslateX(APP_W/2.0-passwordField.getPrefWidth()/2.0);
        passwordField.setTranslateY(textFieldLogin.getTranslateY()+textFieldLogin.getPrefHeight());
        passwordField.setPromptText("Hasło");
        passwordField.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        createRegisterCarFields();
        createCreateEmployeeFields();
        createCreateDriver();
        createDriverGivenPesel();
        createIdentityCardVinNumber();
        createCarRegistrationDeregister();
    }
    private void createRegisterCarFields(){
        carRegistrationDriverPesel.setPromptText("PESEL kierowcy");
        carRegistrationVinNumber.setPromptText("Numer VIN");
        carRegistrationPlateNumber.setPromptText("Numer rejestracyjny");
        carRegistrationCarMake.setPromptText("Marka samochodu");
        carRegistrationCarModel.setPromptText("Model samochodu");
        carRegistrationEngineCapacity.setPromptText("Pojemność silnika");

        carRegistrationDriverPesel.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        carRegistrationVinNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        carRegistrationPlateNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        carRegistrationCarMake.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        carRegistrationCarModel.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        carRegistrationEngineCapacity.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }
    private void createCreateEmployeeFields(){
        createEmployeeShortName.setPromptText("Skrócona nazwa nowego pracownika");
        createEmployeeLogin.setPromptText("Nazwa użytkownika");
        createEmployeePassword.setPromptText("Hasło");
        createEmployeeShortName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        createEmployeeLogin.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        createEmployeePassword.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }
    private void createCreateDriver(){
        driverFirstName.setPromptText("Imię kierowcy");
        driverName.setPromptText("Nazwisko kierowcy");
        driverStreet.setPromptText("Ulica");
        driverHouseNumber.setPromptText("Numer domu");
        driverPostCode.setPromptText("Kod pocztowy");
        driverLocation.setPromptText("Miejscowość");
        driverPesel.setPromptText("PESEL");

        driverFirstName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverStreet.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverHouseNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverPostCode.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverLocation.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverPesel.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }
    private void createDriverGivenPesel(){
        driverGivenPesel.setPromptText("Podaj PESEL");
        driverGivenPesel.setPrefSize(200,13);
        driverGivenPesel.setTranslateX(APP_W/2.0-driverGivenPesel.getPrefWidth()/2.0);
        driverGivenPesel.setTranslateY(APP_H/2.0-driverGivenPesel.getPrefHeight()/2.0);
        driverGivenPesel.setVisible(false);
        driverGivenPesel.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }
    private void createIdentityCardVinNumber(){
        carIdentityCardVinNumber.setPromptText("Numer VIN");
        carIdentityCardVinNumber.setPrefSize(200,13);
        carIdentityCardVinNumber.setTranslateX(APP_W/2.0-carIdentityCardVinNumber.getPrefWidth()/2.0);
        carIdentityCardVinNumber.setTranslateY(APP_H/2.0-carIdentityCardVinNumber.getPrefHeight()/2.0);
        carIdentityCardVinNumber.setVisible(false);
        carIdentityCardVinNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }
    private void createCarRegistrationDeregister(){
        carRegistrationDeregisterVinNumber.setPromptText("Numer VIN");
        carRegistrationDeregisterVinNumber.setPrefSize(200,13);
        carRegistrationDeregisterVinNumber.setTranslateX(APP_W/2.0-carRegistrationDeregisterVinNumber.getPrefWidth()/2.0);
        carRegistrationDeregisterVinNumber.setTranslateY(APP_H/2.0-carRegistrationDeregisterVinNumber.getPrefHeight()/2.0);
        carRegistrationDeregisterVinNumber.setVisible(false);
        carRegistrationDeregisterVinNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataFirstName(String string) {
        driverDataFirstName.setText(string);
        driverDataFirstName.setPrefSize(driverDataFirstName.getFont().getSize()*(double)(driverDataFirstName.getText().length()),20);
        driverDataFirstName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataName(String string) {
        driverDataName.setText(string);
        driverDataName.setPrefSize(driverDataName.getFont().getSize()*(double)(driverDataName.getText().length()),20);
        driverDataName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataStreet(String string) {
        driverDataStreet.setText(string);
        driverDataStreet.setPrefSize(driverDataStreet.getFont().getSize()*(double)(driverDataStreet.getText().length()),20);
        driverDataStreet.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataHouseNumber(String string) {
        driverDataHouseNumber.setText(string);
        driverDataHouseNumber.setPrefSize(driverDataHouseNumber.getFont().getSize()*(double)(driverDataHouseNumber.getText().length()),20);
        driverDataHouseNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataLocation(String string) {
        driverDataLocation.setText(string);
        driverDataLocation.setPrefSize(driverDataLocation.getFont().getSize()*(double)(driverDataLocation.getText().length()),20);
        driverDataLocation.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public void setDriverDataPostCode(String string) {
        driverDataPostCode.setText(string);
        driverDataPostCode.setPrefSize(driverDataPostCode.getFont().getSize()*(double)(driverDataPostCode.getText().length()),20);
        driverDataPostCode.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
    }

    public TextField gettextFieldLogin() {
        return textFieldLogin;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getCreateEmployeeShortName() {
        return createEmployeeShortName;
    }

    public TextField getCreateEmployeeLogin() {
        return createEmployeeLogin;
    }

    public PasswordField getCreateEmployeePassword() {
        return createEmployeePassword;
    }
    public TextField getDriverFirstName() {
        return driverFirstName;
    }

    public TextField getDriverName() {
        return driverName;
    }

    public TextField getDriverStreet() {
        return driverStreet;
    }

    public TextField getDriverHouseNumber() {
        return driverHouseNumber;
    }

    public TextField getDriverPostCode() {
        return driverPostCode;
    }

    public TextField getDriverLocation() {
        return driverLocation;
    }

    public TextField getDriverPesel() {
        return driverPesel;
    }
    public TextField getDriverGivenPesel() {
        return driverGivenPesel;
    }
    public TextField getCarIdentityCardVinNumber() {
        return carIdentityCardVinNumber;
    }

    public TextField getTextFieldLogin() {
        return textFieldLogin;
    }

    public TextField getCarRegistrationDriverPesel() {
        return carRegistrationDriverPesel;
    }

    public TextField getCarRegistrationVinNumber() {
        return carRegistrationVinNumber;
    }

    public TextField getCarRegistrationPlateNumber() {
        return carRegistrationPlateNumber;
    }

    public TextField getCarRegistrationCarMake() {
        return carRegistrationCarMake;
    }

    public TextField getCarRegistrationCarModel() {
        return carRegistrationCarModel;
    }

    public TextField getCarRegistrationEngineCapacity() {
        return carRegistrationEngineCapacity;
    }
    public TextField getCarRegistrationDeregisterVinNumber() {
        return carRegistrationDeregisterVinNumber;
    }
    
    public TextField getDriverDataFirstName() {
        return driverDataFirstName;
    }

    public TextField getDriverDataName() {
        return driverDataName;
    }

    public TextField getDriverDataStreet() {
        return driverDataStreet;
    }

    public TextField getDriverDataHouseNumber() {
        return driverDataHouseNumber;
    }

    public TextField getDriverDataLocation() {
        return driverDataLocation;
    }

    public TextField getDriverDataPostCode() {
        return driverDataPostCode;
    }
}
