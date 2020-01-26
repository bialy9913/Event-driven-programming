package createGUIObjects;

import javafx.scene.control.ProgressIndicator;


public class ProgressIndicatorClass {
    private ProgressIndicator progressIndicator;
    public ProgressIndicatorClass(){
        this.progressIndicator=new ProgressIndicator();
        progressIndicator.setVisible(false);
        progressIndicator.setTranslateX(600);
        progressIndicator.setTranslateY(600);
        progressIndicator.setStyle(" -fx-progress-color: red;");
    }
    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }
}
