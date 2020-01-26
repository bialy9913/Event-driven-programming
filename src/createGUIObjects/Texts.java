package createGUIObjects;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Texts {
    private Text incorrectLoginCredentials=new Text();
    private Text notFilledFields=new Text();
    private Text objectAlreadyExists=new Text();
    private Text objectNotFound=new Text();
    public Texts(){
        incorrectLoginCredentials.setVisible(false);
        incorrectLoginCredentials.setText("Niepoprawne dane logowania!");
        incorrectLoginCredentials.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        incorrectLoginCredentials.setFill(Color.RED);

        notFilledFields.setVisible(false);
        notFilledFields.setText("Wypelnij wszystkie dane!");
        notFilledFields.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        notFilledFields.setFill(Color.RED);

        objectAlreadyExists.setVisible(false);
        objectAlreadyExists.setText("");
        objectAlreadyExists.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        objectAlreadyExists.setFill(Color.RED);

        objectNotFound.setVisible(false);
        objectNotFound.setText("");
        objectNotFound.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        objectNotFound.setFill(Color.RED);
    }

    public void setincorrectLoginCredentials(double x,double y) {
        incorrectLoginCredentials.setTranslateX(x);
        incorrectLoginCredentials.setTranslateY(y);
    }
    public Text getincorrectLoginCredentials() {
        return incorrectLoginCredentials;
    }

    public void setnotFilledFields(double x,double y) {
        notFilledFields.setTranslateX(x);
        notFilledFields.setTranslateY(y);
    }
    public Text getnotFilledFields() {
        return notFilledFields;
    }
    public Text getobjectAlreadyExists() {
        return objectAlreadyExists;
    }
    public void setTextOfObjectAlreadyExists(String string){
        objectAlreadyExists.setText("Taki "+string+" już istnieje!");
    }
    public void setTextOfObjectNotFound(String string){
        objectNotFound.setText("Podanego "+string+" brak w bazie!");
    }
    public void setobjectAlreadyExists(double x,double y) {
        objectAlreadyExists.setTranslateX(x);
        objectAlreadyExists.setTranslateY(y);
    }
    public void setobjectNotFound(double x,double y) {
        objectNotFound.setTranslateX(x);
        objectNotFound.setTranslateY(y);
    }

    public Text getObjectNotFound() {
        return objectNotFound;
    }
}
