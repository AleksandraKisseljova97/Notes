/*package persistence;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Graphics {
    private Stage stage;
    private Scene scene;
    private notesView notesview;

    Graphics()throws IOException{
        Button backButton = new Button("back");
        notesview = new notesView();
    }
    public void setNotesview(ActionEvent e){

    }

    public Stage start(){
        scene = new Scene(notesview.getPane(),450,300);

        stage = new Stage();
        stage.setTitle("Notes managment");
        stage.setScene(scene);
        notesview.getPane().getChildren();
        return stage;
    }
}*/
