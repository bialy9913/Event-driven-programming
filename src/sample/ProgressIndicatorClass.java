package sample;

import javafx.scene.control.ProgressIndicator;

public class ProgressIndicatorClass {
    private ProgressIndicator progressIndicator;
    public ProgressIndicatorClass(){
        this.progressIndicator=new ProgressIndicator();
        progressIndicator.setVisible(false);
        progressIndicator.setTranslateX(600);
        progressIndicator.setTranslateY(600);
        System.out.println("halo halo siema siema");
    }
    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }
}
