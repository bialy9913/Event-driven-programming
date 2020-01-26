package createGUIObjects;

import javafx.scene.control.ListView;

public class DriverCarList {
    private ListView listView;
    public DriverCarList(){
        listView=new ListView();
        listView.setVisible(false);
        listView.setTranslateX(600);
        listView.setTranslateY(300);
    }
    public ListView getListView() {
        return listView;
    }
}
