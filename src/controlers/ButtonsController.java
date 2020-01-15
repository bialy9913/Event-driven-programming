package controlers;

import database.ReadFromDatabase;
import entities.CarIdentityCard;
import entities.DriverLicence;
import entities.Drivers;
import entities.Users;
import sample.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.time.LocalDate;

public class ButtonsController extends Thread{
    private int APP_W;
    private int APP_H;
    private CreateButtons createButtons;
    private CreateTextFields createTextFields;
    private Texts texts;
    private GlobalVariables globalVariables;
    private CreateVboxes createVboxes;
    private CreateHboxes createHboxes;
    private EntityManagerFactory entityManagerFactory;
    private CreateTextAreas createTextAreas;
    private HideOtherObjects hideOtherObjects;
    private VarUsedToReadDB varUsedToReadDB;
    private CurrentThreadInDB currentThreadInDB;
    private ReadFromDatabase readFromDatabase;
    private boolean createThread=false;
    private ProgressIndicatorClass progressIndicatorClass;
    public ButtonsController(int APP_W, int APP_H, CreateButtons createButtons
                               , CreateTextFields createTextFields, Texts texts
                               , GlobalVariables globalVariables
                               , CreateVboxes createVboxes
                               , CreateHboxes createHboxes, EntityManagerFactory entityManagerFactory
                               , CreateTextAreas createTextAreas
                               , VarUsedToReadDB varUsedToReadDB
                               , CurrentThreadInDB currentThreadInDB
                               , ProgressIndicatorClass progressIndicatorClass)
    {
        this.APP_W=APP_W;
        this.APP_H=APP_H;
        this.createButtons=createButtons;
        this.createTextFields=createTextFields;
        this.texts=texts;
        this.globalVariables = globalVariables;
        this.createVboxes=createVboxes;
        this.createHboxes=createHboxes;
        this.entityManagerFactory=entityManagerFactory;
        this.createTextAreas=createTextAreas;
        this.varUsedToReadDB=varUsedToReadDB;
        this.currentThreadInDB = currentThreadInDB;
        this.progressIndicatorClass=progressIndicatorClass;
    }

    @Override
    public void run() {
        while(true){
            if(createThread){
                createThread=false;
                readFromDatabase.run();
            }
            synchronized (globalVariables){
                clickOnLogOutButton();
                clickOnLoginButton();
                clickOnCarRegistration();
                clickOnCreateEmployee();
                clickOnCreateEmployeeConfirm();
                clickOnCreateDriver();
                //clickOnCheckDriver();
                //clickOnChangeDriverDataConfirmation();
                clickOnDriverLicenceNew();
                clickOnDriverLicenceDuplicate();
                clickOnCarIdentityCardChange();
                clickOnCarRegistrationDeregister();
            }
        }
    }

    public void clickOnLoginButton(){
        createButtons.getLogIn().setOnMouseClicked(e -> {
            if(!createTextFields.gettextFieldLogin().getText().isEmpty()
                    && !createTextFields.getPasswordField().getText().isEmpty()){
                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                //currentThreadInDB.setReadFromDatabase(readFromDatabase);
                readFromDatabase.setGetLogInUser(true);
                createThread=true;
                globalVariables.setThreadStartedReading(1);
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,createButtons.getLogIn().getTranslateY()+createButtons.getLogIn().getPrefHeight()
                                +texts.getnotFilledFields().getLayoutBounds().getHeight());

                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnLogOutButton(){
        createButtons.getLogOut().setOnMouseClicked(e -> {
            globalVariables.setMakeInvisibilityForLogOut(true);
            createTextFields.gettextFieldLogin().setVisible(true);
            createTextFields.getPasswordField().setVisible(true);
            createButtons.getLogIn().setVisible(true);

            if(currentThreadInDB.getReadFromDatabase()!=null){
                currentThreadInDB.getReadFromDatabase().stop();
                currentThreadInDB.setReadFromDatabase(null);
            }

        });
    }
    public void clickOnCarRegistration(){
        createButtons.getCarRegistration().setOnMouseClicked(e -> {
            if(!(createTextFields.getCarRegistrationVinNumber().getText().equals("")&&createTextFields.getCarRegistrationPlateNumber().getText().equals("")
                 &&createTextFields.getCarRegistrationCarMake().getText().equals("")&&createTextFields.getCarRegistrationCarModel().getText().equals("")
                 &&createTextFields.getCarRegistrationEngineCapacity().getText().equals(""))){

                CarIdentityCard carIdentityCard=new CarIdentityCard();

                carIdentityCard.setVinNumber(createTextFields.getCarRegistrationVinNumber().getText());
                carIdentityCard.setPlateNumber(createTextFields.getCarRegistrationPlateNumber().getText());
                carIdentityCard.setCarMake(createTextFields.getCarRegistrationCarMake().getText());
                carIdentityCard.setCarModel(createTextFields.getCarRegistrationCarModel().getText());
                carIdentityCard.setEngineCapacity(createTextFields.getCarRegistrationEngineCapacity().getText());
                carIdentityCard.setDateOfRelease(Date.valueOf(LocalDate.now().toString()));
                carIdentityCard.setValidate("Y");

                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                currentThreadInDB.setReadFromDatabase(readFromDatabase);
                readFromDatabase.setCarIdentityCard(carIdentityCard);
                readFromDatabase.setCarRegistration(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(createVboxes.getCarRegistration().getTranslateX()+createVboxes.getCarRegistration().getWidth()/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,createVboxes.getCarRegistration().getTranslateY()+createVboxes.getCarRegistration().getHeight()
                                +texts.getnotFilledFields().getLayoutBounds().getHeight());

                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnCarRegistrationDeregister(){
        createButtons.getCarRegistrationDeregister().setOnAction(e->{
            if(!createTextFields.getCarRegistrationDeregisterVinNumber().getText().equals("")){
                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                currentThreadInDB.setReadFromDatabase(readFromDatabase);
                readFromDatabase.setDeregisterCar(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(createVboxes.getCarRegistration().getTranslateX()+createVboxes.getCarRegistration().getWidth()/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,createButtons.getCarRegistrationDeregister().getTranslateY()+createButtons.getCarRegistrationDeregister().getPrefHeight()
                                +texts.getnotFilledFields().getLayoutBounds().getHeight());

                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    //Handling click on button which is visible in the main bar
    public void clickOnCreateEmployee(){
        createButtons.getCreateEmployee().setOnMouseClicked(e->{
            globalVariables.setCreateEmployeeWasClicked(true);
        });
    }
    //Handling click on button which is visible after clicking above button
    public void clickOnCreateEmployeeConfirm(){
        createButtons.getCreateEmployeeConfirm().setOnMouseClicked(e->{
            globalVariables.setCreateEmployeeConfirmWasClicked(true);
            if(!createTextFields.getCreateEmployeeShortName().getText().equals("")
               &&!createTextFields.getCreateEmployeeLogin().getText().equals("")&&!createTextFields.getCreateEmployeePassword().getText().equals("")){

                Users users=new Users();
                users.setShortName(createTextFields.getCreateEmployeeShortName().getText());
                users.setLogin(createTextFields.getCreateEmployeeLogin().getText());
                users.setPassword(createTextFields.getCreateEmployeePassword().getText());

                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                currentThreadInDB.setReadFromDatabase(readFromDatabase);
                readFromDatabase.setUsers(users);
                readFromDatabase.setCreateEmployeeConfirm(true);
                createThread=true;
                globalVariables.setThreadStartedReading(1);
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                                        ,createVboxes.getCreateEmployee().getTranslateY()+createVboxes.getCreateEmployee().getHeight()
                                        +createButtons.getCreateEmployeeConfirm().getHeight());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnCreateDriver(){
        createButtons.getDriverCreateDriver().setOnAction(e->{
            if(!createTextFields.getDriverFirstName().getText().equals("")&&!createTextFields.getDriverName().getText().equals("")
               &&!createTextFields.getDriverStreet().getText().equals("")&&!createTextFields.getDriverHouseNumber().getText().equals("")
               &&!createTextFields.getDriverPostCode().getText().equals("")&&!createTextFields.getDriverLocation().getText().equals("")
               &&!createTextFields.getDriverPesel().getText().equals("")&&!createTextFields.getDriverPesel().getText().equals("")){
                Drivers drivers=new Drivers();
                drivers.setFirstName(createTextFields.getDriverFirstName().getText());
                drivers.setName(createTextFields.getDriverName().getText());
                drivers.setStreet(createTextFields.getDriverStreet().getText());
                drivers.setHouseNumber(createTextFields.getDriverHouseNumber().getText());
                drivers.setLocation(createTextFields.getDriverLocation().getText());
                drivers.setPostcode(createTextFields.getDriverPostCode().getText());
                drivers.setPesel(createTextFields.getDriverPesel().getText());

                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                readFromDatabase.setDrivers(drivers);
                readFromDatabase.setCreateDriver(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,createVboxes.getCreateDriver().getTranslateY()+createVboxes.getCreateDriver().getHeight()
                                +createButtons.getDriverCreateDriver().getHeight());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnCheckDriver(){
        createButtons.getDriverCheckDriver().setOnAction(e->{
            if(!createTextFields.getDriverGivenPesel().getText().equals("")){
                EntityManager entityManager=entityManagerFactory.createEntityManager();
                Drivers drivers;
                String statement="select d from Drivers d where pesel='"+createTextFields.getDriverGivenPesel().getText()+"'";
                try{
                    TypedQuery<Drivers> query=entityManager.createQuery(statement,Drivers.class);
                    drivers=query.getSingleResult();
                    //Przejscie do wyswietlenia danych kierowcy-----------------
                    createTextFields.getDriverGivenPesel().setVisible(false);
                    createButtons.getDriverCheckDriver().setVisible(false);

                    //Change Driver's information; this if/else statement is written to minimise lines of code
                    //Driver Change Data
                    if(globalVariables.isDriverChangeDataWasClicked()){
                        createVboxes.getChangeDriverDataTextAreas().setVisible(true);
                        createTextFields.setDriverDataFirstName(drivers.getFirstName());
                        createTextFields.setDriverDataName(drivers.getName());
                        createTextFields.setDriverDataStreet(drivers.getStreet());
                        createTextFields.setDriverDataHouseNumber(drivers.getHouseNumber());
                        createTextFields.setDriverDataLocation(drivers.getLocation());
                        createTextFields.setDriverDataPostCode(drivers.getPostcode());
                    }
                    else{
                        createTextFields.getDriverGivenPesel().setText("");
                    }
                    //Driver Licence duplicate
                    if(globalVariables.isDriverCheckWasClicked()){
                        createVboxes.getCheckDriverTextAreas().setVisible(true);
                        createTextAreas.setDriverFirstName(drivers.getFirstName());
                        createTextAreas.setDriverName(drivers.getName());
                        createTextAreas.setDriverStreet(drivers.getStreet());
                        createTextAreas.setDriverHouseNumber(drivers.getHouseNumber());
                        createTextAreas.setDriverLocation(drivers.getLocation());
                        createTextAreas.setDriverPostCode(drivers.getPostcode());
                    }
                    //----------------------------------------------------------

                }catch(Exception e1){
                    texts.setTextOfObjectNotFound("kierowcy");
                    texts.setobjectNotFound(createButtons.getDriverCheckDriver().getTranslateX()
                                               -texts.getObjectNotFound().getLayoutBounds().getWidth()/2.0
                                            ,createButtons.getDriverCheckDriver().getTranslateY()
                                                +texts.getObjectNotFound().getLayoutBounds().getHeight()
                                                +createButtons.getDriverCheckDriver().getHeight());
                    globalVariables.setObjectNotFound(true);
                }
                finally{
                    entityManager.close();
                }
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                                         ,texts.getnotFilledFields().getLayoutBounds().getHeight()/2.0
                                          +createButtons.getDriverCheckDriver().getLayoutBounds().getHeight()
                                          +createButtons.getDriverCheckDriver().getTranslateY());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnChangeDriverDataConfirmation(){
        createButtons.getDriverChangeDataConfirmation().setOnAction(e->{
            EntityManager entityManager=entityManagerFactory.createEntityManager();
            Drivers drivers;
            String statement="select d from Drivers d where pesel='"+createTextFields.getDriverGivenPesel().getText()+"'";
            try{
                TypedQuery<Drivers> query=entityManager.createQuery(statement,Drivers.class);
                drivers=query.getSingleResult();

                String Driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";
                String uName ="root";
                String pwd = "rootpassword";
                Connection conn;
                try {
                    Class.forName(Driver).newInstance();
                    conn = DriverManager.getConnection(url, uName, pwd);
                    Statement stmt = conn.createStatement();
                    String sql="";

                    //Finding out which element was updated
                    boolean tmp=false;
                    if(!drivers.getFirstName().equals(createTextFields.getDriverDataFirstName().getText())){
                        sql = "UPDATE drivers set firstName='"+createTextFields.getDriverDataFirstName().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    else if(!drivers.getName().equals(createTextFields.getDriverDataName().getText())){
                        sql = "UPDATE drivers set name='"+createTextFields.getDriverDataName().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    else if(!drivers.getStreet().equals(createTextFields.getDriverDataStreet().getText())){
                        sql = "UPDATE drivers set street='"+createTextFields.getDriverDataStreet().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    else if(!drivers.getHouseNumber().equals(createTextFields.getDriverDataHouseNumber().getText())){
                        sql = "UPDATE drivers set houseNumber='"+createTextFields.getDriverDataHouseNumber().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    else if(!drivers.getPostcode().equals(createTextFields.getDriverDataPostCode().getText())){
                        sql = "UPDATE drivers set postcode='"+createTextFields.getDriverDataPostCode().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    else if(!drivers.getLocation().equals(createTextFields.getDriverDataLocation().getText())){
                        sql = "UPDATE drivers set location='"+createTextFields.getDriverDataFirstName().getText()+"'"
                                +" where pesel='"+drivers.getPesel()+"'";
                        tmp=true;
                    }
                    if(tmp){
                        stmt.executeUpdate(sql);
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
                finally{
                    createTextFields.getDriverGivenPesel().setText("");
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        });
    }
    public void clickOnDriverLicenceDuplicate(){
        createButtons.getDriverLicenceDuplicate().setOnAction(e->{
            if(!createTextFields.getDriverGivenPesel().getText().equals("")){
                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                readFromDatabase.setDriverLicenceDuplicate(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,texts.getnotFilledFields().getLayoutBounds().getHeight()/2.0
                                +createButtons.getDriverLicenceCreateNew().getLayoutBounds().getHeight()
                                +createButtons.getDriverLicenceCreateNew().getTranslateY());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnDriverLicenceNew(){
        createButtons.getDriverLicenceCreateNew().setOnAction(e->{
            if(!createTextFields.getDriverGivenPesel().getText().equals("")){
                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                readFromDatabase.setDriverLicenceNew(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,texts.getnotFilledFields().getLayoutBounds().getHeight()/2.0
                                +createButtons.getDriverLicenceCreateNew().getLayoutBounds().getHeight()
                                +createButtons.getDriverLicenceCreateNew().getTranslateY());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }
    public void clickOnCarIdentityCardChange(){
        createButtons.getCarIdentityCardChange().setOnAction(e->{
            if(!createTextFields.getCarIdentityCardVinNumber().getText().equals("")){
                readFromDatabase=new ReadFromDatabase(createTextFields,varUsedToReadDB,entityManagerFactory,currentThreadInDB,progressIndicatorClass);
                readFromDatabase.setCarIdentityCardChange(true);
                createThread=true;
            }
            else{
                texts.setnotFilledFields(APP_W/2.0-texts.getnotFilledFields().getLayoutBounds().getWidth()/2.0
                        ,texts.getnotFilledFields().getLayoutBounds().getHeight()/2.0
                                +createButtons.getCarIdentityCardChange().getLayoutBounds().getHeight()
                                +createButtons.getCarIdentityCardChange().getTranslateY());
                globalVariables.settoShowNotFilledFields(true);
            }
        });
    }

    public void setHideOtherObjects(HideOtherObjects hideOtherObjects) {
        this.hideOtherObjects = hideOtherObjects;
    }
}
