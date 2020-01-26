package createGUIObjects;

import javafx.scene.control.TextArea;

public class CreateTextAreas {
    //Check driver--------------------------------------
    private TextArea driverFirstName=new TextArea();
    private TextArea driverName=new TextArea();
    private TextArea driverStreet=new TextArea();
    private TextArea driverHouseNumber=new TextArea();
    private TextArea driverLocation=new TextArea();
    private TextArea driverPostCode=new TextArea();
    //--------------------------------------------------
    public CreateTextAreas(){
        driverFirstName.setEditable(false);
        driverName.setEditable(false);
        driverStreet.setEditable(false);
        driverHouseNumber.setEditable(false);
        driverLocation.setEditable(false);
        driverPostCode.setEditable(false);

        /*driverFirstName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverName.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverStreet.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverHouseNumber.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverLocation.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));
        driverPostCode.setBackground(new Background(new BackgroundFill(Color.WHITE,
                new CornerRadii(1024), null)));*/
    }

    public void setDriverFirstName(String string) {
        driverFirstName.setText(string);
        driverFirstName.setPrefSize(driverFirstName.getFont().getSize()*(double)(driverFirstName.getText().length()),20);
    }

    public void setDriverName(String string) {
        driverName.setText(string);
        driverName.setPrefSize(driverName.getFont().getSize()*(double)(driverName.getText().length()),20);
    }

    public void setDriverStreet(String string) {
        driverStreet.setText(string);
        driverStreet.setPrefSize(driverStreet.getFont().getSize()*(double)(driverStreet.getText().length()),20);
    }

    public void setDriverHouseNumber(String string) {
        driverHouseNumber.setText(string);
        driverHouseNumber.setPrefSize(driverHouseNumber.getFont().getSize()*(double)(driverHouseNumber.getText().length()),20);
    }

    public void setDriverLocation(String string) {
        driverLocation.setText(string);
        driverLocation.setPrefSize(driverLocation.getFont().getSize()*(double)(driverLocation.getText().length()),20);
    }

    public void setDriverPostCode(String string) {
        driverPostCode.setText(string);
        driverPostCode.setPrefSize(driverPostCode.getFont().getSize()*(double)(driverPostCode.getText().length()),20);
    }

    public TextArea getDriverFirstName() {
        return driverFirstName;
    }

    public TextArea getDriverName() {
        return driverName;
    }

    public TextArea getDriverStreet() {
        return driverStreet;
    }

    public TextArea getDriverHouseNumber() {
        return driverHouseNumber;
    }

    public TextArea getDriverLocation() {
        return driverLocation;
    }

    public TextArea getDriverPostCode() {
        return driverPostCode;
    }
}
