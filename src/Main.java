import controlers.ButtonsController;
import controlers.Controller;
import controlers.MenuItemsController;
import createGUIObjects.*;
import entities.CarIdentityCard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import synchronizedObjects.GlobalVariables;
import synchronizedObjects.VarUsedToReadDB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application{

    private static int APP_W=1280;
    private static int APP_H=720;//setting width and height of the pane

    //private EntityManagerFactory entityManagerFactory;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");

    private CreateHboxes createHboxes=new CreateHboxes();
    private Texts texts=new Texts();
    private CreateTextFields createTextFields=new CreateTextFields(APP_W,APP_H);
    private CreateButtons createButtons=new CreateButtons(APP_W,APP_H,createTextFields);
    private DriverCarList driverCarList=new DriverCarList();
    private CreateMenuItems createMenuItems=new CreateMenuItems();
    private GlobalVariables globalVariables =new GlobalVariables();
    private VarUsedToReadDB varUsedToReadDB=new VarUsedToReadDB();
    private Controller controller=new Controller(globalVariables,varUsedToReadDB);
    private CreateTextAreas createTextAreas=new CreateTextAreas();
    private CreateVboxes createVboxes=new CreateVboxes(APP_W,APP_H,createTextFields,createButtons,createTextAreas);

    private CreateMenuButtons createMenuButtons=new CreateMenuButtons(createMenuItems,createButtons,createHboxes);

    private ProgressIndicatorClass progressIndicatorClass=new ProgressIndicatorClass();
    private ButtonsController buttonsController =new ButtonsController(APP_W,APP_H,createButtons,createTextFields,texts
                                                                            , globalVariables,createVboxes,createHboxes,entityManagerFactory
                                                                            ,createTextAreas,varUsedToReadDB
                                                                            , progressIndicatorClass,driverCarList);
    private MenuItemsController menuItemsController =new MenuItemsController(createMenuItems,createTextFields,createVboxes, globalVariables
                                                                                  ,createButtons);
    //variable used to count current time of showing alerts
    private double showAlertCurrentTime=0.0;
    private double showAlertTime=2.0;
    private long showProgressTime=0;
    //-----------------------------------------------------

    private Timeline timeline=new Timeline();

    private ImageView imageView;

    private Parent createContent() {
        //creating the pane and handling keyboard events
        final Pane root = new Pane();
        root.setPrefWidth(APP_W);
        root.setPrefHeight(APP_H);

        Image image=new Image("car.jpg");
        imageView=new ImageView(image);

        HideOtherObjects hideOtherObjects=new HideOtherObjects(root,createVboxes,createHboxes,imageView);
        buttonsController.setHideOtherObjects(hideOtherObjects);
        menuItemsController.setHideOtherObjects(hideOtherObjects);

        root.getChildren().add(imageView);
        root.getChildren().add(createButtons.getLogIn());
        root.getChildren().add(createButtons.getDriverCheckDriver());
        root.getChildren().add(createButtons.getDriverLicenceDuplicate());
        root.getChildren().add(createButtons.getDriverLicenceCreateNew());
        root.getChildren().add(createButtons.getCarIdentityCardChange());
        root.getChildren().add(createButtons.getCarRegistrationDeregister());
        root.getChildren().add(createTextFields.gettextFieldLogin());
        root.getChildren().add(createTextFields.getPasswordField());
        root.getChildren().add(createTextFields.getDriverGivenPesel());
        root.getChildren().add(createTextFields.getCarIdentityCardVinNumber());
        root.getChildren().add(createTextFields.getCarRegistrationDeregisterVinNumber());
        root.getChildren().add(texts.getincorrectLoginCredentials());
        root.getChildren().add(texts.getnotFilledFields());
        root.getChildren().add(texts.getobjectAlreadyExists());
        root.getChildren().add(texts.getObjectNotFound());
        root.getChildren().add(createHboxes.getMainMenuTrees());
        root.getChildren().add(createVboxes.getCarRegistration());
        root.getChildren().add(createVboxes.getCreateEmployee());
        root.getChildren().add(createVboxes.getCreateDriver());
        root.getChildren().add(createVboxes.getCheckDriverTextAreas());
        root.getChildren().add(createVboxes.getChangeDriverDataTextAreas());
        root.getChildren().add(progressIndicatorClass.getProgressIndicator());
        root.getChildren().add(driverCarList.getListView());


        KeyFrame frame = new KeyFrame(Duration.seconds(0.033), event -> {
            synchronized (globalVariables){
                //showing incorrect login credentials alert on the screen-----------------------
                if(globalVariables.istoShowNotIncorrectCredentials()){
                    texts.getincorrectLoginCredentials().setVisible(true);
                    showAlertCurrentTime+=0.033;
                    if(showAlertCurrentTime>showAlertTime){
                        texts.getincorrectLoginCredentials().setVisible(false);
                        globalVariables.settoShowNotIncorrectCredentials(false);
                        showAlertCurrentTime=0.0;
                    }
                }
                if(globalVariables.istoShowNotFilledFields()){
                    texts.getnotFilledFields().setVisible(true);
                    showAlertCurrentTime+=0.033;
                    if(showAlertCurrentTime>showAlertTime){
                        texts.getnotFilledFields().setVisible(false);
                        globalVariables.settoShowNotFilledFields(false);
                        showAlertCurrentTime=0.0;
                    }
                }
                //------------------------------------------------------------------------------
                //Showing such an object already exists in database alert on the screen------------
                if(globalVariables.isobjectAlreadyExists()){
                    texts.getobjectAlreadyExists().setVisible(true);
                    showAlertCurrentTime+=0.033;
                    if(showAlertCurrentTime>showAlertTime){
                        texts.getobjectAlreadyExists().setVisible(false);
                        globalVariables.setobjectAlreadyExists(false);
                        showAlertCurrentTime=0.0;
                    }
                }
                //------------------------------------------------------------------------------
                //Showing such an object doesn't exist in database alert on the screen------------
                if(globalVariables.isObjectNotFound()){
                    texts.getObjectNotFound().setVisible(true);
                    showAlertCurrentTime+=0.033;
                    if(showAlertCurrentTime>showAlertTime){
                        texts.getObjectNotFound().setVisible(false);
                        globalVariables.setObjectNotFound(false);
                        showAlertCurrentTime=0.0;
                    }
                }
                //------------------------------------------------------------------------------
                //Hiding every Object except those for logging in-------------------------------
                if(globalVariables.isMakeInvisibilityForLogOut()){
                    for(int i=0;i<root.getChildren().size();i++){
                        if(!root.getChildren().get(i).equals(createTextFields.gettextFieldLogin())
                                &&!root.getChildren().get(i).equals(createTextFields.getPasswordField())
                                &&!root.getChildren().get(i).equals(createButtons.getLogIn())
                                &&!root.getChildren().get(i).equals(imageView)){
                            root.getChildren().get(i).setVisible(false);
                        }
                    }
                    globalVariables.setMakeInvisibilityForLogOut(false);
                }
                //-----------------------------------------------------------------------------------------------
                if(globalVariables.getCreateEmployeeWasClicked()){
                    hideOtherObjects.hide(createVboxes.getCreateEmployee(),0);
                    createVboxes.getCreateEmployee().setVisible(true);
                    globalVariables.setCreateEmployeeWasClicked(false);
                }
                /*if(globalVariables.isCreateEmployeeConfirmWasClicked()){
                    hideOtherObjects.hide(createVboxes.getCreateEmployee(),0);
                    globalVariables.setCreateEmployeeConfirmWasClicked(false);
                }*/
                /*if(globalVariables.isCreateDriverWasClicked()){
                    hideOtherObjects.hide(createVboxes.getCreateDriver(),0);
                    createVboxes.getCreateDriver().setVisible(true);
                    globalVariables.setCreateDriverWasClicked(false);
                }*/
                //-----------------------------------------------------------------------------------------------
                if (globalVariables.getCarRegistrationSuccessful() != 0) {
                    createTextFields.getCarRegistrationVinNumber().setText("");
                    createTextFields.getCarRegistrationPlateNumber().setText("");
                    createTextFields.getCarRegistrationCarMake().setText("");
                    createTextFields.getCarRegistrationCarModel().setText("");
                    createTextFields.getCarRegistrationEngineCapacity().setText("");

                    globalVariables.setCarRegistrationSuccessful(0);
                }

                if (globalVariables.getLogInSuccessful() == 1) {
                    if (globalVariables.getLogInUser().getUserId() == 0) {
                        if (!createHboxes.getMainMenuTrees().getChildren().contains(createButtons.getCreateEmployee())) {
                            createHboxes.getMainMenuTrees().getChildren().add(createHboxes.getMainMenuTrees().getChildren().size() - 1
                                    , createButtons.getCreateEmployee());
                        }
                    } else {
                        if (createHboxes.getMainMenuTrees().getChildren().contains(createButtons.getCreateEmployee())) {
                            createHboxes.getMainMenuTrees().getChildren().remove(createButtons.getCreateEmployee());
                        }
                    }
                    //-------------------------------------------------------------------------------------------
                    createHboxes.getMainMenuTrees().setVisible(true);
                    //Ereasing fields for login credentials for the next logging
                    createTextFields.gettextFieldLogin().setText("");
                    createTextFields.getPasswordField().setText("");
                    //----------------------------------------------------------
                    createTextFields.gettextFieldLogin().setVisible(false);
                    createTextFields.getPasswordField().setVisible(false);
                    createButtons.getLogIn().setVisible(false);
                    globalVariables.setLogInSuccessful(0);
                    globalVariables.setLogInUser(null);
                }
                else if (globalVariables.getLogInSuccessful() == 2) {
                    createTextFields.gettextFieldLogin().setText("");
                    createTextFields.getPasswordField().setText("");
                    texts.setincorrectLoginCredentials(APP_W / 2.0 - texts.getincorrectLoginCredentials().getLayoutBounds().getWidth() / 2.0
                            , createButtons.getLogIn().getTranslateY() + createButtons.getLogIn().getPrefHeight()
                                    + texts.getincorrectLoginCredentials().getLayoutBounds().getHeight());

                    globalVariables.settoShowNotIncorrectCredentials(true);
                    globalVariables.setLogInSuccessful(0);
                    globalVariables.setLogInUser(null);
                }
                if(globalVariables.getCreateEmployeeConfirmSuccessful()==2){
                    texts.setobjectAlreadyExists(APP_W/2.0-texts.getobjectAlreadyExists().getLayoutBounds().getWidth()/2.0
                            ,createVboxes.getCreateEmployee().getTranslateY()+createVboxes.getCreateEmployee().getHeight()
                                    +createButtons.getCreateEmployeeConfirm().getHeight());
                    texts.setTextOfObjectAlreadyExists("użytkownik");
                    globalVariables.setobjectAlreadyExists(true);
                }
                if(globalVariables.getCreateEmployeeConfirmSuccessful()!=0){
                    createTextFields.getCreateEmployeeShortName().setText("");
                    createTextFields.getCreateEmployeeLogin().setText("");
                    createTextFields.getCreateEmployeePassword().setText("");
                    globalVariables.setCreateEmployeeConfirmSuccessful(0);
                }
                if(globalVariables.getCreateDriverSuccessful()!=0){
                    if(globalVariables.getCreateDriverSuccessful()==2){
                        texts.setobjectAlreadyExists(APP_W/2.0-texts.getobjectAlreadyExists().getLayoutBounds().getWidth()/2.0
                                ,createVboxes.getCreateEmployee().getTranslateY()+createVboxes.getCreateEmployee().getHeight()
                                        +createButtons.getCreateEmployeeConfirm().getHeight());
                        texts.setTextOfObjectAlreadyExists("kierowca");
                        globalVariables.setobjectAlreadyExists(true);
                    }
                    createTextFields.getDriverFirstName().setText("");
                    createTextFields.getDriverName().setText("");
                    createTextFields.getDriverStreet().setText("");
                    createTextFields.getDriverHouseNumber().setText("");
                    createTextFields.getDriverLocation().setText("");
                    createTextFields.getDriverPostCode().setText("");
                    createTextFields.getDriverPesel().setText("");

                    globalVariables.setCreateDriverSuccessful(0);
                }
                if(globalVariables.getDriverLicenceNewDriverExists()!=0){
                    if(globalVariables.getDriverLicenceNewDriverExists()==2){
                        texts.setTextOfObjectNotFound("kierowcy");
                        texts.setobjectNotFound(createButtons.getDriverLicenceCreateNew().getTranslateX()
                                        -texts.getObjectNotFound().getLayoutBounds().getWidth()/2.0
                                ,createButtons.getDriverLicenceCreateNew().getTranslateY()
                                        +texts.getObjectNotFound().getLayoutBounds().getHeight()
                                        +createButtons.getDriverLicenceCreateNew().getHeight());
                        globalVariables.setObjectNotFound(true);
                    }
                    globalVariables.setDriverLicenceNewDriverExists(0);
                }
                if(globalVariables.getDriverLicenceNewDriverHasNoLicence()!=0){
                    if(globalVariables.getDriverLicenceNewDriverHasNoLicence()==2){
                        texts.setobjectAlreadyExists(createButtons.getDriverLicenceCreateNew().getTranslateX()
                                        -texts.getobjectAlreadyExists().getLayoutBounds().getWidth()/2.0
                                ,createButtons.getDriverLicenceCreateNew().getTranslateY()
                                        +texts.getobjectAlreadyExists().getLayoutBounds().getHeight()
                                        +createButtons.getDriverLicenceCreateNew().getHeight());
                        texts.setTextOfObjectAlreadyExists("prawa jazdy");
                        globalVariables.setobjectAlreadyExists(true);
                    }
                    globalVariables.setDriverLicenceNewDriverHasNoLicence(0);
                    globalVariables.setDriverLicenceNewDriverExists(0);
                }
                if(globalVariables.getDriverLicenceDuplicateDriverExists()!=0){
                    if(globalVariables.getDriverLicenceDuplicateDriverExists()==2){
                        texts.setTextOfObjectNotFound("kierowcy");
                        texts.setobjectNotFound(createButtons.getDriverLicenceCreateNew().getTranslateX()
                                        -texts.getObjectNotFound().getLayoutBounds().getWidth()/2.0
                                ,createButtons.getDriverLicenceCreateNew().getTranslateY()
                                        +texts.getObjectNotFound().getLayoutBounds().getHeight()
                                        +createButtons.getDriverLicenceCreateNew().getHeight());
                        globalVariables.setObjectNotFound(true);
                    }
                    globalVariables.setDriverLicenceDuplicateDriverExists(0);
                }
                if(globalVariables.getCarIdentityCardChangeCardExists()!=0){
                    if(globalVariables.getCarIdentityCardChangeCardExists()==2){
                        texts.setTextOfObjectNotFound("dowodu rejestracyjnego");
                        texts.setobjectNotFound(createButtons.getCarIdentityCardChange().getTranslateX()
                                        -texts.getObjectNotFound().getLayoutBounds().getWidth()/2.0
                                ,createButtons.getCarIdentityCardChange().getTranslateY()
                                        +texts.getObjectNotFound().getLayoutBounds().getHeight()
                                        +createButtons.getCarIdentityCardChange().getHeight());
                        globalVariables.setObjectNotFound(true);
                    }
                    globalVariables.setCarIdentityCardChangeCardExists(0);
                }
                if(globalVariables.getDriverDriverCarList()!=0){
                    driverCarList.getListView().setVisible(true);
                    driverCarList.getListView().getItems().clear();
                    for(int i=0;i<globalVariables.getList().size();i++){
                        driverCarList.getListView().getItems().add(globalVariables.getList().get(i));
                    }
                    globalVariables.setDriverDriverCarList(0);
                }
                //--Indicator
                if(globalVariables.getThreadStartedReading()!=0){
                    if(globalVariables.getThreadStartedReading()==1){
                        progressIndicatorClass.getProgressIndicator().setVisible(true);
                    }
                    else{
                        progressIndicatorClass.getProgressIndicator().setVisible(false);
                        globalVariables.setThreadStartedReading(0);
                    }
                }
                //MenuItems
                if(globalVariables.isMenuItemRegisterCarPoland()){
                    hideOtherObjects.hide(createVboxes.getCarRegistration(),0);
                    createVboxes.getCarRegistration().setVisible(true);

                    globalVariables.setMenuItemRegisterCarPoland(false);
                }
                if(globalVariables.isMenuItemCarRegistrationDeregister()){
                    hideOtherObjects.hide(new VBox(),1);
                    createTextFields.getCarRegistrationDeregisterVinNumber().setVisible(true);
                    createButtons.getCarRegistrationDeregister().setTranslateX(createTextFields.getCarRegistrationDeregisterVinNumber().getTranslateX());
                    createButtons.getCarRegistrationDeregister().setTranslateY(createTextFields.getCarRegistrationDeregisterVinNumber().getTranslateY()
                            +createTextFields.getCarRegistrationDeregisterVinNumber().getHeight());
                    createButtons.getCarRegistrationDeregister().setVisible(true);
                    globalVariables.setMenuItemCarRegistrationDeregister(false);
                }
                if(globalVariables.isMenuItemCarIdentityCardChange()){
                    hideOtherObjects.hide(new VBox(),1);
                    createButtons.getCarIdentityCardChange().setTranslateX(createTextFields.getCarIdentityCardVinNumber().getTranslateX());
                    createButtons.getCarIdentityCardChange().setTranslateY(createTextFields.getCarIdentityCardVinNumber().getTranslateY()
                            +createTextFields.getCarIdentityCardVinNumber().getLayoutBounds().getHeight());
                    createTextFields.getCarIdentityCardVinNumber().setVisible(true);
                    createButtons.getCarIdentityCardChange().setVisible(true);
                    globalVariables.setMenuItemCarIdentityCardChange(false);
                }
                if(globalVariables.isMenuItemDriverCreateDriver()){
                    hideOtherObjects.hide(createVboxes.getCreateDriver(),0);
                    createVboxes.getCreateDriver().setVisible(true);
                    globalVariables.setDriverChangeDataWasClicked(false);
                    globalVariables.setDriverCheckWasClicked(false);
                    globalVariables.setMenuItemDriverCreateDriver(false);
                }
                if(globalVariables.isMenuItemDriverCheckDriver()){
                    hideOtherObjects.hide(new VBox(),1);
                    createButtons.getDriverCheckDriver().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
                    createButtons.getDriverCheckDriver().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                            +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
                    createTextFields.getDriverGivenPesel().setVisible(true);
                    createButtons.getDriverCheckDriver().setVisible(true);
                    globalVariables.setDriverChangeDataWasClicked(false);
                    globalVariables.setDriverCheckWasClicked(true);

                    globalVariables.setMenuItemDriverCheckDriver(false);
                }
                if(globalVariables.isMenuItemDriverChangeDriverData()){
                    hideOtherObjects.hide(new VBox(),1);
                    createButtons.getDriverCheckDriver().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
                    createButtons.getDriverCheckDriver().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                            +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
                    createTextFields.getDriverGivenPesel().setVisible(true);
                    createButtons.getDriverCheckDriver().setVisible(true);
                    globalVariables.setDriverChangeDataWasClicked(true);
                    globalVariables.setDriverCheckWasClicked(false);

                    globalVariables.setMenuItemDriverChangeDriverData(false);
                }
                if(globalVariables.isMenuItemDriverLicenceDuplicate()){
                    hideOtherObjects.hide(new VBox(),1);
                    createButtons.getDriverLicenceDuplicate().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
                    createButtons.getDriverLicenceDuplicate().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                            +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
                    createTextFields.getDriverGivenPesel().setVisible(true);
                    createButtons.getDriverLicenceDuplicate().setVisible(true);

                    globalVariables.setMenuItemDriverLicenceDuplicate(false);
                }
                if(globalVariables.isMenuItemDriverLicenceNew()){
                    hideOtherObjects.hide(new VBox(),1);
                    createButtons.getDriverLicenceCreateNew().setTranslateX(createTextFields.getDriverGivenPesel().getTranslateX());
                    createButtons.getDriverLicenceCreateNew().setTranslateY(createTextFields.getDriverGivenPesel().getTranslateY()
                            +createTextFields.getDriverGivenPesel().getLayoutBounds().getHeight());
                    createTextFields.getDriverGivenPesel().setVisible(true);
                    createButtons.getDriverLicenceCreateNew().setVisible(true);

                    globalVariables.setMenuItemDriverLicenceNew(false);
                }
            }
                //------------------------------------------------------------------------------
                //Handle click on---------------------------------------------------------------
                //Menu Items--------------------------------------------------------------------
                /*menuItemsController.clickOnRegisterCarPoland(hideOtherObjects);
                menuItemsController.clickOnDriverCreateDriver(hideOtherObjects);
                menuItemsController.clickOnDriverCheckDriver(hideOtherObjects);
                menuItemsController.clickOnDriverChangeDriverData(hideOtherObjects);
                menuItemsController.clickOnDriverLicenceNew(hideOtherObjects);
                menuItemsController.clickOnDriverLicenceDuplicate(hideOtherObjects);
                menuItemsController.clickOnCarIdentityCardChange(hideOtherObjects);
                menuItemsController.clickOnCarRegistrationDeregister(hideOtherObjects);*/
                //------------------------------------------------------------------------------
                //------------------------------------------------------------------------------
        });
        timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);



        return root;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception{
        Scene scene=new Scene(createContent());
        primaryStage.setTitle("I7B4S1_RADOSŁAW_ŻURAWICZ_PrZ_PROJEKT");
        primaryStage.setResizable(false);
        scene.setFill(Color.LAVENDER);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(e -> {
            entityManagerFactory.close();
            buttonsController.stop();
            menuItemsController.stop();
            controller.stop();
        });

        primaryStage.show();
        timeline.play();
        buttonsController.start();
        menuItemsController.start();
        controller.start();
        /*HostServices hs =  getHostServices();
        hs.showDocument("C:\\Users\\rz199\\Desktop\\Radosław Żurawicz_CV.pdf");*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
