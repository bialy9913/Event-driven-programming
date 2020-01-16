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
            globalVariables.setMenuItemRegisterCarPoland(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });

    }
    private void clickOnCarRegistrationDeregister(){
        createMenuItems.getCarRegistrationDeregister().setOnAction(e->{
            globalVariables.setMenuItemCarRegistrationDeregister(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnCarIdentityCardChange(){
        createMenuItems.getCarIdentityCardChange().setOnAction(e -> {
            globalVariables.setMenuItemCarIdentityCardChange(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setMenuItemCarIdentityCardChange(true);
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    //Driver--------------------------------------------------------------------------
    private void clickOnDriverCreateDriver(){
        createMenuItems.getDriverCreateDriver().setOnAction(e->{
            globalVariables.setMenuItemDriverCreateDriver(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverCheckDriver(){
        createMenuItems.getDriverCheckDriver().setOnAction(e->{
            globalVariables.setMenuItemDriverCheckDriver(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverChangeDriverData(){
        createMenuItems.getDriverChangeData().setOnAction(e->{
            globalVariables.setMenuItemDriverChangeDriverData(true);
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
            globalVariables.setMenuItemDriverLicenceDuplicate(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
    private void clickOnDriverLicenceNew(){
        createMenuItems.getDriverLicenceNew().setOnAction(e->{
            globalVariables.setMenuItemDriverLicenceNew(true);
            if(globalVariables.getThreadStartedReading()==1){
                globalVariables.setThreadStartedReading(2);
                globalVariables.getCurrentReadingThread().setRunning(false);
                globalVariables.setCurrentReadingThread(null);
            }
        });
    }
}
