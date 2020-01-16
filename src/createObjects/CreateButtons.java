package createObjects;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class CreateButtons {
    private Button logIn=new Button("Zaloguj się");
    private Button logOut=new Button("Wyloguj się");

    private Button carRegistration=new Button("Zarejestruj samochód");
    private Button carRegistrationDeregister=new Button("Wyrejestruj samochód");

    private Button createEmployee=new Button("Dodaj pracownika");
    private Button createEmployeeConfirm=new Button("Dodaj pracownika");

    //Driver------------------------------------------------------------------------
    private Button driverCreateDriver=new Button("Dodaj kierowcę");
    private Button driverCheckDriver=new Button("Sprawdź");
    private Button driverChangeDriverDataConfirmation=new Button("Potwierdź zmiany");
    //------------------------------------------------------------------------------
    //Driver licence----------------------------------------------------------------
    private Button driverLicenceCreateNew=new Button("Wydaj prawo jazdy");
    private Button driverLicenceDuplicate=new Button("Wydaj duplikat");
    //------------------------------------------------------------------------------
    //Car dientity card-------------------------------------------------------------
    private Button carIdentityCardChange=new Button("Wydaj nowy dowód");
    //------------------------------------------------------------------------------
    public CreateButtons(int APP_W,int APP_H,CreateTextFields createTextFields)
    {
        logIn.setPrefSize(200,70);
        logIn.setTranslateX(APP_W/2.0-logIn.getPrefWidth()/2.0);
        logIn.setTranslateY(createTextFields.getPasswordField().getTranslateY()+createTextFields.getPasswordField().getPrefHeight());
        logIn.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        logOut.setPrefSize(200,30);
        logOut.setBackground(Background.EMPTY);
        logOut.setTextFill(Paint.valueOf("white"));
        logOut.setFont(new Font(logOut.getFont().getName(),20.0));

        carRegistration.setPrefSize(200,30);
        carRegistration.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));
        carRegistrationDeregister.setPrefSize(200,30);
        carRegistrationDeregister.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        createEmployee.setPrefSize(200,30);
        createEmployee.setBackground(Background.EMPTY);
        createEmployee.setTextFill(Paint.valueOf("white"));
        createEmployee.setFont(new Font(createEmployee.getFont().getName(),20.0));

        createEmployeeConfirm.setPrefSize(200,30);
        createEmployeeConfirm.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        driverCreateDriver.setPrefSize(200,30);
        driverCreateDriver.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        driverCheckDriver.setPrefSize(200,30);
        driverCheckDriver.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));
        driverChangeDriverDataConfirmation.setPrefSize(200,30);
        driverChangeDriverDataConfirmation.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        driverLicenceCreateNew.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        driverLicenceDuplicate.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));

        carIdentityCardChange.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                new CornerRadii(1024), null)));


        driverCheckDriver.setVisible(false);
        driverLicenceCreateNew.setVisible(false);
        driverLicenceDuplicate.setVisible(false);
        carIdentityCardChange.setVisible(false);
        carRegistrationDeregister.setVisible(false);
    }

    public Button getLogIn() {
        return logIn;
    }

    public Button getLogOut() {
        return logOut;
    }

    public Button getCreateEmployee() {
        return createEmployee;
    }
    public Button getCarRegistration() {
        return carRegistration;
    }

    public Button getCreateEmployeeConfirm() {
        return createEmployeeConfirm;
    }

    public Button getDriverCreateDriver() {
        return driverCreateDriver;
    }
    public Button getDriverCheckDriver() {
        return driverCheckDriver;
    }

    public Button getDriverChangeDataConfirmation(){
        return driverChangeDriverDataConfirmation;
    }

    public Button getDriverLicenceCreateNew() {
        return driverLicenceCreateNew;
    }
    public Button getDriverLicenceDuplicate() {
        return driverLicenceDuplicate;
    }
    public Button getCarIdentityCardChange() {
        return carIdentityCardChange;
    }
    public Button getCarRegistrationDeregister() {
        return carRegistrationDeregister;
    }
}
