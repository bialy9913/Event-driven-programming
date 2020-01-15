package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class HideOtherObjects {
    private Pane root;
    private CreateVboxes createVboxes;
    private CreateHboxes createHboxes;
    private ImageView imageView;
    public HideOtherObjects(Pane root, CreateVboxes createVboxes, CreateHboxes createHboxes, ImageView imageView){
        this.createVboxes=createVboxes;
        this.createHboxes=createHboxes;
        this.root=root;
        this.imageView=imageView;
    }
    public void hide(VBox vBoxNotToHide,int notHideOnlyMainMenu){
        for(int i=0;i<root.getChildren().size();i++){
            if(notHideOnlyMainMenu==0){
                if(!root.getChildren().get(i).equals(imageView)&&root.getChildren().get(i)!=vBoxNotToHide && root.getChildren().get(i)!=createHboxes.getMainMenuTrees()){
                    root.getChildren().get(i).setVisible(false);
                }
            }
            else if(!root.getChildren().get(i).equals(imageView)&&notHideOnlyMainMenu==1){
                if(root.getChildren().get(i)!=createHboxes.getMainMenuTrees()){
                    root.getChildren().get(i).setVisible(false);
                }
            }
        }
    }
}
