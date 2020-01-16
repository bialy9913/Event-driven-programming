package controlers;

import javafx.scene.layout.VBox;
import sample.*;

public class MenuItemsController extends Thread{
    private CreateMenuItems createMenuItems;
    private CreateTextFields createTextFields;
    private CreateVboxes createVboxes;
    private GlobalVariables globalVariables;
    private CreateButtons createButtons;
    private HideOtherObjects hideOtherObjects;
    public MenuItemsController(CreateMenuItems createMenuItems, CreateTextFields createTextFields, CreateVboxes createVboxes
                                 , GlobalVariables globalVariables, CreateButtons createButtons){
        this.createMenuItems=createMenuItems;
        this.createTextFields=createTextFields;
        this.createVboxes=createVboxes;
        this.globalVariables = globalVariables;
        this.createButtons=createButtons;
    }
    public void setHideOtherObjects(HideOtherObjects hideOtherObjects) {
        this.hideOtherObjects = hideOtherObjects;
    }
    @Override
    public void run() {
        while(true){
            synchronized (globalVariables){
                clickOnRegisterCarPoland();
                clickOnCarRegistrationDeregister();
                clickOnDriverCreateDriver();
                clickOnDriverLicenceNew();
                clickOnDriverLicenceDuplicate();
                clickOnCarIdentityCardChange();
                clickOnDriverChangeDriverData();
                clickOnDriverCheckDriver();
            }
        }
    }

    private void clickOnRegisterCarPoland(){
        createMenuItems.getRegisterCarPoland().setOnAction(e ->{
            hideOtherObjects.hide(createVboxes.getCarRegistration(),0);
            createVboxes.getCarRegistration().setVisible(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });

    }
    private void clickOnCarRegistrationDeregister(){
        createMenuItems.getCarRegistrationDeregister().setOnAction(e->{
            hideOtherObjects.hide(new VBox(),1);
            createTextFields.getCarRegistrationDeregisterVinNumber().setVisible(true);
            createButtons.getCarRegistrationDeregister().setTranslateX(createTextFields.getCarRegistrationDeregisterVinNumber().getTranslateX());
            createButtons.getCarRegistrationDeregister().setTranslateY(createTextFields.getCarRegistrationDeregisterVinNumber().getTranslateY()
                                                                       +createTextFields.getCarRegistrationDeregisterVinNumber().getHeight());
            createButtons.getCarRegistrationDeregister().setVisible(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnCarIdentityCardChange(){
        createMenuItems.getCarIdentityCardChange().setOnAction(e -> {
            hideOtherObjects.hide(new VBox(),1);
            createButtons.getCarIdentityCardChange().setTranslateX(createTextFields.getCarIdentityCardVinNumber().getTranslateX());
            createButtons.getCarIdentityCardChange().setTranslateY(createTextFields.getCarIdentityCardVinNumber().getTranslateY()
                    +createTextFields.getCarIdentityCardVinNumber().getLayoutBounds().getHeight());
            createTextFields.getCarIdentityCardVinNumber().setVisible(true);
            createButtons.getCarIdentityCardChange().setVisible(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    //Driver--------------------------------------------------------------------------
    private void clickOnDriverCreateDriver(){
        createMenuItems.getDriverCreateDriver().setOnAction(e->{
            hideOtherObjects.hide(createVboxes.getCreateDriver(),0);
            createVboxes.getCreateDriver().setVisible(true);
            globalVariables.setDriverChangeDataWasClicked(false);
            globalVariables.setDriverCheckWasClicked(false);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverCheckDriver(){
        createMenuItems.getDriverCheckDriver().setOnAction(e->{
            hideOtherObjects.hide(new VBox(),1);
            createButtons.getDriverCheckDriver().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
            createButtons.getDriverCheckDriver().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                    +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
            createTextFields.getDriverGivenPesel().setVisible(true);
            createButtons.getDriverCheckDriver().setVisible(true);
            globalVariables.setDriverChangeDataWasClicked(false);
            globalVariables.setDriverCheckWasClicked(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverChangeDriverData(){
        createMenuItems.getDriverChangeData().setOnAction(e->{
            hideOtherObjects.hide(new VBox(),1);
            createButtons.getDriverCheckDriver().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
            createButtons.getDriverCheckDriver().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                    +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
            createTextFields.getDriverGivenPesel().setVisible(true);
            createButtons.getDriverCheckDriver().setVisible(true);
            globalVariables.setDriverChangeDataWasClicked(true);
            globalVariables.setDriverCheckWasClicked(false);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    //--------------------------------------------------------------------------------
    private void clickOnDriverLicenceDuplicate(){
        createMenuItems.getDriverLicenceDuplicate().setOnAction(e->{
            hideOtherObjects.hide(new VBox(),1);
            createButtons.getDriverLicenceDuplicate().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
            createButtons.getDriverLicenceDuplicate().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                    +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
            createTextFields.getDriverGivenPesel().setVisible(true);
            createButtons.getDriverLicenceDuplicate().setVisible(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverLicenceNew(){
        createMenuItems.getDriverLicenceNew().setOnAction(e->{
            hideOtherObjects.hide(new VBox(),1);
            createButtons.getDriverLicenceCreateNew().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
            createButtons.getDriverLicenceCreateNew().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                    +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
            createTextFields.getDriverGivenPesel().setVisible(true);
            createButtons.getDriverLicenceCreateNew().setVisible(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
}
