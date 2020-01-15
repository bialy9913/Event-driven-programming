package sample;

import javafx.scene.layout.HBox;

public class CreateHboxes {
    private HBox mainMenuTrees=new HBox();
    public CreateHboxes(){
        mainMenuTrees.setSpacing(2.0);
        mainMenuTrees.setVisible(false);
    }
    public HBox getMainMenuTrees() {
        return mainMenuTrees;
    }
}
