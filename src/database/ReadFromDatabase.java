package database;

import createObjects.CreateTextFields;
import createObjects.ProgressIndicatorClass;
import entities.CarIdentityCard;
import entities.DriverLicence;
import entities.Drivers;
import entities.Users;
import synchronizedObjects.VarUsedToReadDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReadFromDatabase extends Thread{
    private volatile boolean running=true;

    private CreateTextFields createTextFields;
    private VarUsedToReadDB varUsedToReadDB;
    private EntityManagerFactory entityManagerFactory;
    private ProgressIndicatorClass progressIndicatorClass;

    private boolean getLogInUser=false;

    private boolean carRegistration=false;
    private CarIdentityCard carIdentityCard=null;

    private boolean deregisterCar=false;

    private boolean createEmployeeConfirm=false;
    private Users users=null;

    private boolean createDriver=false;
    private Drivers drivers=null;

    private boolean driverLicenceNew=false;

    private boolean driverLicenceDuplicate=false;

    private boolean carIdentityCardChange=false;

    private boolean changeDriverDataConfirmation=false;
    private ArrayList<String > sqlUpdateQueries=new ArrayList<>();

    public ReadFromDatabase(CreateTextFields createTextFields
            , VarUsedToReadDB varUsedToReadDB
                            ,EntityManagerFactory entityManagerFactory
                            , ProgressIndicatorClass progressIndicatorClass) {
        this.createTextFields = createTextFields;
        this.varUsedToReadDB=varUsedToReadDB;
        this.entityManagerFactory = entityManagerFactory;
        this.progressIndicatorClass=progressIndicatorClass;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while(running){
            synchronized (varUsedToReadDB){
                if(getLogInUser){
                    handleLogIn();
                    getLogInUser=false;
                    running=false;
                    //currentThreadInDB.setReadFromDatabase(null);
                }
                if(carRegistration){
                    handleCarRegistration();
                    carRegistration=false;
                    running=false;
                    //currentThreadInDB.setReadFromDatabase(null);
                }
                if(deregisterCar){
                    handleCarRegistrationDeregister();
                    deregisterCar=false;
                    running=false;
                }
                if(createEmployeeConfirm){
                    while(running){

                    }
                    handleCreateEmployeeConfirm();
                    createEmployeeConfirm=false;
                    running=false;
                }
                if(createDriver){
                    handleCreateDriver();
                    createDriver=false;
                    running=false;
                    //currentThreadInDB.setReadFromDatabase(null);
                }
                if(driverLicenceNew){
                    handleDriverLicenceNew();
                    driverLicenceNew=false;
                    running=false;
                }
                if(driverLicenceDuplicate){
                    handleDriverLicenceDuplicate();
                    driverLicenceDuplicate=false;
                    running=false;
                }
                if(carIdentityCardChange){
                    handleCarIdentityCardChange();
                    carIdentityCardChange=false;
                    running=false;
                }
                if(changeDriverDataConfirmation){
                    handleChangeDriverDataConfirmation();
                    changeDriverDataConfirmation=false;
                    running=false;
                }
                if(!running){
                    varUsedToReadDB.setThreadStartedReading(2);
                }
            }
        }
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public void handleLogIn(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Users users;
        String statement="select u from Users u where login='"+createTextFields.gettextFieldLogin().getText()+"' and password='"
                +createTextFields.getPasswordField().getText()+"'";
        try{
            TypedQuery<Users> query=entityManager.createQuery(statement,Users.class);
            users=query.getSingleResult();
            varUsedToReadDB.setLogInSuccessful(1);
            varUsedToReadDB.setLogInUser(users);
        }catch(Exception t){
            varUsedToReadDB.setLogInSuccessful(2);
        }
        finally {
            entityManager.close();
        }
    }
    public void setGetLogInUser(boolean getLogInUser) {
        this.getLogInUser = getLogInUser;
    }
    public void setCarIdentityCard(CarIdentityCard carIdentityCard) {
        this.carIdentityCard = carIdentityCard;
    }
    public void handleCarRegistration(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(carIdentityCard);
            entityManager.getTransaction().commit();
            varUsedToReadDB.setCarRegistrationSuccessful(1);
        }catch(Exception e1){
            e1.printStackTrace();
            varUsedToReadDB.setCarRegistrationSuccessful(2);
        }
        finally {
            entityManager.close();
        }
    }
    public void setCarRegistration(boolean carRegistration) {
        this.carRegistration = carRegistration;
    }
    public void handleCarRegistrationDeregister() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CarIdentityCard carIdentityCardTmp;
        String statement = "select c from CarIdentityCard c where vinNumber='" + createTextFields.getCarRegistrationDeregisterVinNumber().getText() + "'";
        try {
            TypedQuery<CarIdentityCard> query = entityManager.createQuery(statement, CarIdentityCard.class);
            carIdentityCardTmp = query.getSingleResult();
            entityManager.getTransaction().begin();
            entityManager.remove(carIdentityCardTmp);
            entityManager.getTransaction().commit();
            varUsedToReadDB.setCarRegistrationDeregister(1);
        } catch (Exception e) {
            e.printStackTrace();
            varUsedToReadDB.setCarRegistrationDeregister(2);
        }
        finally {
            entityManager.close();
        }
    }
    public void setDeregisterCar(boolean deregisterCar) {
        this.deregisterCar = deregisterCar;
    }
    public void handleCreateEmployeeConfirm(){
        /*EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(users);
            entityManager.getTransaction().commit();
            varUsedToReadDB.setCreateEmployeeConfirmSuccessful(1);
        }catch(Exception e){
            varUsedToReadDB.setCreateEmployeeConfirmSuccessful(2);
        }
        finally {
            entityManager.close();
        }*/
    }
    public void setCreateEmployeeConfirm(boolean createEmployeeConfirm) {
        this.createEmployeeConfirm = createEmployeeConfirm;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }
    public void handleCreateDriver(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(drivers);
            entityManager.getTransaction().commit();
            entityManager.close();
            varUsedToReadDB.setCreateDriverSuccessful(1);
        }catch(Exception e1){
            varUsedToReadDB.setCreateDriverSuccessful(2);
        }
    }
    public void setCreateDriver(boolean createDriver) {
        this.createDriver = createDriver;
    }
    public void handleDriverLicenceNew(){
        boolean driverHasLicence;
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Drivers drivers;
        String statement="select d from Drivers d where pesel='"+createTextFields.getDriverGivenPesel().getText()+"'";
        try{
            TypedQuery<Drivers> query=entityManager.createQuery(statement,Drivers.class);
            drivers=query.getSingleResult();

            DriverLicence driverLicence=new DriverLicence();
            driverLicence.setDriverId(drivers.getDriverId());
            driverLicence.setValidateTo(Date.valueOf(LocalDate.now().toString()));
            driverLicence.setValidate("Y");

            varUsedToReadDB.setDriverLicenceNewDriverExists(1);

            statement="select d from DriverLicence d where driverId="+drivers.getDriverId()+" and validate='Y'";
            try {
                TypedQuery<DriverLicence> query1 = entityManager.createQuery(statement, DriverLicence.class);
                DriverLicence driverLicence1 = query1.getSingleResult();
                driverHasLicence=true;
                varUsedToReadDB.setDriverLicenceNewDriverHasNoLicence(2);
            }catch(Exception e1){
                driverHasLicence=false;
                varUsedToReadDB.setDriverLicenceNewDriverHasNoLicence(1);
            }
            if(!driverHasLicence){
                try{
                    entityManager.getTransaction().begin();
                    entityManager.persist(driverLicence);
                    entityManager.getTransaction().commit();
                    entityManager.close();
                }catch(Exception e1){

                }
                finally{
                    entityManager.close();
                }
            }
        }catch(Exception e1){
            varUsedToReadDB.setDriverLicenceNewDriverExists(2);
        }
        finally{
            entityManager.close();
            createTextFields.getDriverGivenPesel().setText("");
        }
    }
    public void setDriverLicenceNew(boolean driverLicenceNew) {
        this.driverLicenceNew = driverLicenceNew;
    }
    public void handleDriverLicenceDuplicate(){
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

            varUsedToReadDB.setDriverLicenceDuplicateDriverExists(1);
            try {
                Class.forName(Driver).newInstance();
                conn = DriverManager.getConnection(url, uName, pwd);
                Statement stmt = conn.createStatement();
                String sql = "UPDATE driverlicence set validate='N' where driverId="+drivers.getDriverId();
                stmt.executeUpdate(sql);
            }catch(Exception e1){
                e1.printStackTrace();
            }

            DriverLicence driverLicence=new DriverLicence();
            driverLicence.setDriverId(drivers.getDriverId());
            driverLicence.setValidateTo(Date.valueOf(LocalDate.now().toString()));
            driverLicence.setValidate("Y");
            try{
                entityManager.getTransaction().begin();
                entityManager.persist(driverLicence);
                entityManager.getTransaction().commit();
                entityManager.close();
            }catch(Exception e1){
                entityManager.close();
                e1.printStackTrace();
            }
            finally{
                createTextFields.getDriverGivenPesel().setText("");
            }

        }catch(Exception e1){
            varUsedToReadDB.setDriverLicenceDuplicateDriverExists(2);
        }
        finally{
            entityManager.close();
            createTextFields.getDriverGivenPesel().setText("");
        }
    }
    public void setDriverLicenceDuplicate(boolean driverLicenceDuplicate) {
        this.driverLicenceDuplicate = driverLicenceDuplicate;
    }
    public void handleCarIdentityCardChange(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        CarIdentityCard carIdentityCard;
        String statement="select c from CarIdentityCard c where vinNumber='"+
                createTextFields.getCarIdentityCardVinNumber().getText()+"'" +
                "and validate='Y'";
        try {
            TypedQuery<CarIdentityCard> query = entityManager.createQuery(statement, CarIdentityCard.class);
            carIdentityCard = query.getSingleResult();

            String Driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";
            String uName ="root";
            String pwd = "rootpassword";
            Connection conn;

            varUsedToReadDB.setCarIdentityCardChangeCardExists(1);

            try {
                Class.forName(Driver).newInstance();
                conn = DriverManager.getConnection(url, uName, pwd);
                Statement stmt = conn.createStatement();
                String sql = "UPDATE caridentitycard set validate='N' where vinnumber='"
                        + createTextFields.getCarIdentityCardVinNumber().getText() + "'";
                stmt.executeUpdate(sql);
            }catch(Exception e1){
                e1.printStackTrace();
            }

            CarIdentityCard carIdentityCard1=new CarIdentityCard();
            carIdentityCard1.setVinNumber(carIdentityCard.getVinNumber());
            carIdentityCard1.setPlateNumber(carIdentityCard.getPlateNumber());
            carIdentityCard1.setCarMake(carIdentityCard.getCarMake());
            carIdentityCard1.setCarModel(carIdentityCard.getCarModel());
            carIdentityCard1.setEngineCapacity(carIdentityCard.getEngineCapacity());
            carIdentityCard1.setValidate("Y");
            carIdentityCard1.setDateOfRelease(Date.valueOf(LocalDate.now().toString()));

            entityManager.getTransaction().begin();
            entityManager.persist(carIdentityCard1);
            entityManager.getTransaction().commit();
            entityManager.close();

        }catch(Exception e1){
            varUsedToReadDB.setCarIdentityCardChangeCardExists(2);
        }
        finally{
            entityManager.close();
            createTextFields.getCarIdentityCardVinNumber().setText("");
        }
    }
    public void setCarIdentityCardChange(boolean carIdentityCardChange) {
        this.carIdentityCardChange = carIdentityCardChange;
    }
    public ArrayList<String> getSqlUpdateQueries() {
        return sqlUpdateQueries;
    }
    public void handleChangeDriverDataConfirmation(){

        String Driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";
        String uName ="root";
        String pwd = "rootpassword";
        Connection conn;

        try {
            Class.forName(Driver).newInstance();
            conn = DriverManager.getConnection(url, uName, pwd);
            Statement stmt = conn.createStatement();

            for(String string:sqlUpdateQueries){
                stmt.executeUpdate(string);
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }
        finally{
            createTextFields.getDriverGivenPesel().setText("");
        }
    }
    public void setChangeDriverDataConfirmation(boolean changeDriverDataConfirmation) {
        this.changeDriverDataConfirmation = changeDriverDataConfirmation;
    }
}
