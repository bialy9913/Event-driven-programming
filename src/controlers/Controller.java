package controlers;

import sample.GlobalVariables;
import sample.VarUsedToReadDB;

public class Controller extends Thread{
    private GlobalVariables globalVariables;
    private VarUsedToReadDB varUsedToReadDB;
    public Controller(GlobalVariables globalVariables, VarUsedToReadDB varUsedToReadDB){
        this.globalVariables=globalVariables;
        this.varUsedToReadDB=varUsedToReadDB;
    }
    public void mainHandler(){
        if(varUsedToReadDB.getLogInSuccessful()!=0){
            globalVariables.setLogInUser(varUsedToReadDB.getLogInUser());
            globalVariables.setLogInSuccessful(varUsedToReadDB.getLogInSuccessful());

            varUsedToReadDB.setLogInUser(null);
            varUsedToReadDB.setLogInSuccessful(0);
        }
        if(varUsedToReadDB.getCarRegistrationSuccessful()!=0){
            globalVariables.setCarRegistrationSuccessful(varUsedToReadDB.getCarRegistrationSuccessful());

            varUsedToReadDB.setCarRegistrationSuccessful(0);
        }
        if(varUsedToReadDB.getCarRegistrationDeregister()!=0){
            globalVariables.setCarRegistrationDeregister(varUsedToReadDB.getCarRegistrationDeregister());

            varUsedToReadDB.setCarRegistrationDeregister(0);
        }
        if(varUsedToReadDB.getCreateEmployeeConfirmSuccessful()!=0){
            globalVariables.setCreateEmployeeConfirmSuccessful(varUsedToReadDB.getCreateEmployeeConfirmSuccessful());

            varUsedToReadDB.setCreateEmployeeConfirmSuccessful(0);
        }
        if(varUsedToReadDB.getCreateDriverSuccessful()!=0){
            globalVariables.setCreateDriverSuccessful(varUsedToReadDB.getCreateDriverSuccessful());

            varUsedToReadDB.setCreateDriverSuccessful(0);
        }
        if(varUsedToReadDB.getDriverLicenceNewDriverExists()!=0){
            globalVariables.setDriverLicenceNewDriverExists(varUsedToReadDB.getDriverLicenceNewDriverExists());

            varUsedToReadDB.setDriverLicenceNewDriverExists(0);
        }
        if(varUsedToReadDB.getDriverLicenceNewDriverHasNoLicence()!=0){
            globalVariables.setDriverLicenceNewDriverHasNoLicence(varUsedToReadDB.getDriverLicenceNewDriverHasNoLicence());

            varUsedToReadDB.setDriverLicenceNewDriverHasNoLicence(0);
        }
        if(varUsedToReadDB.getDriverLicenceDuplicateDriverExists()!=0){
            globalVariables.setDriverLicenceDuplicateDriverExists(varUsedToReadDB.getDriverLicenceDuplicateDriverExists());

            varUsedToReadDB.setDriverLicenceDuplicateDriverExists(0);
        }
        if(varUsedToReadDB.getCarIdentityCardChangeCardExists()!=0){
            globalVariables.setCarIdentityCardChangeCardExists(varUsedToReadDB.getCarIdentityCardChangeCardExists());

            varUsedToReadDB.setCarIdentityCardChangeCardExists(0);
        }
        if(varUsedToReadDB.getThreadStartedReading()!=0){
            globalVariables.setThreadStartedReading(varUsedToReadDB.getThreadStartedReading());

            varUsedToReadDB.setThreadStartedReading(0);
        }
    }

    @Override
    public void run() {
        while(true){
            synchronized (varUsedToReadDB){
                synchronized (globalVariables){
                    mainHandler();
                }
            }
        }
    }
}
