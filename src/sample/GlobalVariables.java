package sample;

import entities.Users;

public class GlobalVariables {
    private boolean toShowNotIncorrectCredentials;
    private boolean toShowNotFilledFields;
    private boolean objectHasLoggedIn=false;
    private boolean objectAlreadyExists=false;
    private boolean objectNotFound=false;
    private boolean makeInvisibilityForLogOut=false;
    //Variable used while changing driver's personal data;Created to minimize number of code lines--
    private boolean driverChangeDataWasClicked=false;
    //----------------------------------------------------------------------------------------------
    private boolean driverCheckWasClicked =false;
    private boolean driverLicenceNewWasClicked=false;

    //Made with threads-----------------------------------------------------
    private boolean createEmployeeWasClicked=false;
    private boolean createEmployeeConfirmWasClicked=false;
    private boolean createDriverWasClicked=false;
    //------------------------------------------------------------------------

    private int threadStartedReading=0;

    private int logInSuccessful=0;
    private Users logInUser;

    private int carRegistrationSuccessful=0;

    private int carRegistrationDeregister =0;

    private int createEmployeeConfirmSuccessful=0;

    private int createDriverSuccessful =0;

    private int driverLicenceNewDriverExists =0;
    private int driverLicenceNewDriverHasNoLicence =0;

    private int driverLicenceDuplicateDriverExists=0;

    private int carIdentityCardChangeCardExists=0;

    public GlobalVariables(){

    }
    public void setAllToDefault(){

    }

    public boolean istoShowNotIncorrectCredentials() {
        return toShowNotIncorrectCredentials;
    }

    public boolean istoShowNotFilledFields() {
        return toShowNotFilledFields;
    }

    public void settoShowNotIncorrectCredentials(boolean toShowNotIncorrectCredentials) {
        this.toShowNotIncorrectCredentials = toShowNotIncorrectCredentials;
    }

    public void settoShowNotFilledFields(boolean toShowNotFilledFields) {
        this.toShowNotFilledFields = toShowNotFilledFields;
    }
    public boolean isobjectHasLoggedIn() {
        return objectHasLoggedIn;
    }
    public void setobjectHasLoggedIn(boolean objectHasLoggedIn) {
        this.objectHasLoggedIn = objectHasLoggedIn;
    }

    public boolean isobjectAlreadyExists() {
        return objectAlreadyExists;
    }

    public void setobjectAlreadyExists(boolean objectAlreadyExists) {
        this.objectAlreadyExists = objectAlreadyExists;
    }

    public boolean isObjectNotFound() {
        return objectNotFound;
    }

    public void setObjectNotFound(boolean objectNotFound) {
        this.objectNotFound = objectNotFound;
    }

    public boolean isMakeInvisibilityForLogOut() {
        return makeInvisibilityForLogOut;
    }

    public void setMakeInvisibilityForLogOut(boolean makeInvisibilityForLogOut) {
        this.makeInvisibilityForLogOut = makeInvisibilityForLogOut;
    }

    public boolean isDriverChangeDataWasClicked() {
        return driverChangeDataWasClicked;
    }

    public void setDriverChangeDataWasClicked(boolean driverChangeDataWasClicked) {
        this.driverChangeDataWasClicked = driverChangeDataWasClicked;
    }

    public boolean isDriverCheckWasClicked() {
        return driverCheckWasClicked;
    }

    public void setDriverCheckWasClicked(boolean driverLicenceDuplicateWasClicked) {
        this.driverCheckWasClicked = driverLicenceDuplicateWasClicked;
    }

    public boolean isDriverLicenceNewWasClicked() {
        return driverLicenceNewWasClicked;
    }

    public void setDriverLicenceNewWasClicked(boolean driverLicenceNewWasClicked) {
        this.driverLicenceNewWasClicked = driverLicenceNewWasClicked;
    }
    //-----------------------------------------------------------------------------------------
    public boolean getCreateEmployeeWasClicked() {
        return createEmployeeWasClicked;
    }
    public void setCreateEmployeeWasClicked(boolean createEmployeeWasClicked) {
        this.createEmployeeWasClicked = createEmployeeWasClicked;
    }
    public boolean isCreateEmployeeConfirmWasClicked() {
        return createEmployeeConfirmWasClicked;
    }
    public void setCreateEmployeeConfirmWasClicked(boolean createEmployeeConfirmWasClicked) {
        this.createEmployeeConfirmWasClicked = createEmployeeConfirmWasClicked;
    }
    public boolean isCreateDriverWasClicked() {
        return createDriverWasClicked;
    }
    public void setCreateDriverWasClicked(boolean createDriverWasClicked) {
        this.createDriverWasClicked = createDriverWasClicked;
    }
    //-------------------------------------------------------------------------------

    public void setLogInSuccessful(int logInSuccessful) {
        this.logInSuccessful = logInSuccessful;
    }
    public int getLogInSuccessful() {
        return logInSuccessful;
    }
    public void setLogInUser(Users logInUser) {
        this.logInUser = logInUser;
    }
    public Users getLogInUser() {
        return logInUser;
    }
    public int getCarRegistrationSuccessful() {
        return carRegistrationSuccessful;
    }
    public void setCarRegistrationSuccessful(int carRegistrationSuccessful) {
        this.carRegistrationSuccessful = carRegistrationSuccessful;
    }
    public int getCarRegistrationDeregister() {
        return carRegistrationDeregister;
    }
    public void setCarRegistrationDeregister(int carRegistrationDeregister) {
        this.carRegistrationDeregister = carRegistrationDeregister;
    }
    public int getCreateEmployeeConfirmSuccessful() {
        return createEmployeeConfirmSuccessful;
    }
    public void setCreateEmployeeConfirmSuccessful(int createEmployeeConfirmSuccessful) {
        this.createEmployeeConfirmSuccessful = createEmployeeConfirmSuccessful;
    }
    public int getCreateDriverSuccessful() {
        return createDriverSuccessful;
    }
    public void setCreateDriverSuccessful(int createDriverSuccessful) {
        this.createDriverSuccessful = createDriverSuccessful;
    }
    public int getDriverLicenceNewDriverExists() {
        return driverLicenceNewDriverExists;
    }
    public int getDriverLicenceNewDriverHasNoLicence() {
        return driverLicenceNewDriverHasNoLicence;
    }
    public void setDriverLicenceNewDriverExists(int driverLicenceNewDriverExists) {
        this.driverLicenceNewDriverExists = driverLicenceNewDriverExists;
    }
    public void setDriverLicenceNewDriverHasNoLicence(int driverLicenceNewDriverHasNoLicence) {
        this.driverLicenceNewDriverHasNoLicence = driverLicenceNewDriverHasNoLicence;
    }
    public int getDriverLicenceDuplicateDriverExists() {
        return driverLicenceDuplicateDriverExists;
    }
    public void setDriverLicenceDuplicateDriverExists(int driverLicenceDuplicateDriverExists) {
        this.driverLicenceDuplicateDriverExists = driverLicenceDuplicateDriverExists;
    }
    public int getCarIdentityCardChangeCardExists() {
        return carIdentityCardChangeCardExists;
    }
    public void setCarIdentityCardChangeCardExists(int carIdentityCardChangeCardExists) {
        this.carIdentityCardChangeCardExists = carIdentityCardChangeCardExists;
    }
    public int getThreadStartedReading() {
        return threadStartedReading;
    }
    public void setThreadStartedReading(int threadStartedReading) {
        this.threadStartedReading = threadStartedReading;
    }
}