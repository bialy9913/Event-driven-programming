package sample;

import javafx.scene.control.MenuButton;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class CreateMenuButtons {
    private MenuButton registerCar=new MenuButton();
    private MenuButton carIdentityCard=new MenuButton();
    private MenuButton driverLicence=new MenuButton();
    private MenuButton driver=new MenuButton();
    public CreateMenuButtons(CreateMenuItems createMenuItems,CreateButtons createButtons,CreateHboxes createHboxes){
        //Zeby ustawic tytul w ContextMenu trzeba go przypiac do new Label()
        registerCar.setText("Rejestracja pojazdu");
        registerCar.getItems().add(createMenuItems.getRegisterCarPoland());
        registerCar.getItems().add(createMenuItems.getCarRegistrationDeregister());
        registerCar.setBackground(Background.EMPTY);
        registerCar.setTextFill(Paint.valueOf("white"));
        registerCar.setFont(new Font(registerCar.getFont().getName(),20.0));
        createHboxes.getMainMenuTrees().getChildren().add(registerCar);

        carIdentityCard.setText("Dowód rejestracyjny");
        carIdentityCard.getItems().add(createMenuItems.getCarIdentityCardChange());
        carIdentityCard.setBackground(Background.EMPTY);
        carIdentityCard.setTextFill(Paint.valueOf("white"));
        carIdentityCard.setFont(new Font(carIdentityCard.getFont().getName(),20.0));
        createHboxes.getMainMenuTrees().getChildren().add(carIdentityCard);

        driverLicence.setText("Prawo jazdy");
        driverLicence.getItems().add(createMenuItems.getDriverLicenceDuplicate());
        driverLicence.getItems().add(createMenuItems.getDriverLicenceNew());
        driverLicence.setBackground(Background.EMPTY);
        driverLicence.setTextFill(Paint.valueOf("white"));
        driverLicence.setFont(new Font(driverLicence.getFont().getName(),20.0));
        createHboxes.getMainMenuTrees().getChildren().add(driverLicence);

        driver.setText("Kierowca");
        driver.getItems().add(createMenuItems.getDriverCreateDriver());
        driver.getItems().add(createMenuItems.getDriverCheckDriver());
        driver.getItems().add(createMenuItems.getDriverChangeData());
        driver.setBackground(Background.EMPTY);
        driver.setTextFill(Paint.valueOf("white"));
        driver.setFont(new Font(driver.getFont().getName(),20.0));
        createHboxes.getMainMenuTrees().getChildren().add(driver);

        //Adding logout button at the end of the MenuBar
        createHboxes.getMainMenuTrees().getChildren().add(createButtons.getLogOut());
        //----------------------------------------------
    }

}
