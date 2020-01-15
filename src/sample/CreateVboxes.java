package sample;

import javafx.scene.layout.VBox;

public class CreateVboxes {
    private int APP_W;
    private int APP_H;
    private CreateTextFields createTextFields;
    private CreateButtons createButtons;
    private CreateTextAreas createTextAreas;
    private VBox carRegistration=new VBox();
    private VBox createEmployee=new VBox();
    private VBox createDriver=new VBox();
    private VBox checkDriverTextAreas=new VBox();
    private VBox changeDriverDataTextAreas=new VBox();
    public CreateVboxes(int APP_W,int APP_H,CreateTextFields createTextFields,CreateButtons createButtons
                        ,CreateTextAreas createTextAreas){
        this.APP_W=APP_W;
        this.APP_H=APP_H;
        this.createTextFields=createTextFields;
        this.createButtons=createButtons;   
        this.createTextAreas=createTextAreas;

        createCarRegistration();
        createCreateEmployee();
        createCreateDriver();
        createCheckDriverTextAreas();
        createChangeDriverDataTextAreas();
    }
    private void createCarRegistration(){
        carRegistration.setVisible(false);

        carRegistration.getChildren().add(createTextFields.getCarRegistrationVinNumber());
        carRegistration.getChildren().add(createTextFields.getCarRegistrationPlateNumber());
        carRegistration.getChildren().add(createTextFields.getCarRegistrationCarMake());
        carRegistration.getChildren().add(createTextFields.getCarRegistrationCarModel());
        carRegistration.getChildren().add(createTextFields.getCarRegistrationEngineCapacity());
        carRegistration.getChildren().add(createButtons.getCarRegistration());
        carRegistration.setPrefWidth(200);
        carRegistration.setPrefHeight(70);
        carRegistration.setTranslateX(APP_W/2.0-carRegistration.getPrefWidth()/2.0);
        carRegistration.setTranslateY(APP_H/2.0-carRegistration.getPrefHeight()/2.0);
    }
    private void createCarRegistrationDeregister(){

    }
    private void createCreateEmployee(){
        createEmployee.setVisible(false);

        createEmployee.getChildren().add(createTextFields.getCreateEmployeeShortName());
        createEmployee.getChildren().add(createTextFields.getCreateEmployeeLogin());
        createEmployee.getChildren().add(createTextFields.getCreateEmployeePassword());
        createEmployee.getChildren().add(createButtons.getCreateEmployeeConfirm());
        createEmployee.setPrefWidth(200);
        createEmployee.setPrefHeight(70);
        createEmployee.setTranslateX(APP_W/2.0-createEmployee.getPrefWidth()/2.0);
        createEmployee.setTranslateY(APP_H/2.0-createEmployee.getPrefHeight()/2.0);
    }
    private void createCreateDriver(){
        createDriver.setVisible(false);

        createDriver.getChildren().add(createTextFields.getDriverFirstName());
        createDriver.getChildren().add(createTextFields.getDriverName());
        createDriver.getChildren().add(createTextFields.getDriverStreet());
        createDriver.getChildren().add(createTextFields.getDriverHouseNumber());
        createDriver.getChildren().add(createTextFields.getDriverPostCode());
        createDriver.getChildren().add(createTextFields.getDriverLocation());
        createDriver.getChildren().add(createTextFields.getDriverPesel());
        createDriver.getChildren().add(createButtons.getDriverCreateDriver());
        createDriver.setPrefWidth(200);
        createDriver.setPrefHeight(70);
        createDriver.setTranslateX(APP_W/2.0-createDriver.getPrefWidth()/2.0);
        createDriver.setTranslateY(APP_H/2.0-createDriver.getPrefHeight()/2.0);
    }
    private void createCheckDriverTextAreas(){
        checkDriverTextAreas.setVisible(false);

        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverFirstName());
        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverName());
        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverStreet());
        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverHouseNumber());
        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverLocation());
        checkDriverTextAreas.getChildren().add(createTextAreas.getDriverPostCode());
        checkDriverTextAreas.setTranslateX(APP_W/2.0-checkDriverTextAreas.getWidth()/2.0);
        checkDriverTextAreas.setTranslateY(APP_H/2.0-checkDriverTextAreas.getHeight()/2.0);
    }
    private void createChangeDriverDataTextAreas(){
        changeDriverDataTextAreas.setVisible(false);

        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataFirstName());
        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataName());
        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataStreet());
        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataHouseNumber());
        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataLocation());
        changeDriverDataTextAreas.getChildren().add(createTextFields.getDriverDataPostCode());
        changeDriverDataTextAreas.getChildren().add(createButtons.getDriverChangeDataConfirmation());
        changeDriverDataTextAreas.setTranslateX(APP_W/2.0-changeDriverDataTextAreas.getWidth()/2.0);
        changeDriverDataTextAreas.setTranslateY(APP_H/2.0-changeDriverDataTextAreas.getHeight()/2.0);
    }

    public VBox getCarRegistration() {
        return carRegistration;
    }

    public VBox getCreateEmployee() {
        return createEmployee;
    }

    public VBox getCreateDriver() {
        return createDriver;
    }

    public VBox getCheckDriverTextAreas() {
        return checkDriverTextAreas;
    }

    public VBox getChangeDriverDataTextAreas() {
        return changeDriverDataTextAreas;
    }
}
