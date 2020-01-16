package sample;

import database.ReadFromDatabase;
import entities.Users;

public class VarUsedToReadDB {

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

    private int threadStartedReading=0;

    public VarUsedToReadDB(){

    }
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
