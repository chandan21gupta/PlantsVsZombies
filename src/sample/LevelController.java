package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelController {
    public void onclick(ActionEvent event) throws IOException {
        final Node source = (Node)event.getSource();
        String id = source.getId();
//        Parent secondPane;
//        Scene gameScene;
        //Parent gameScreen = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        System.out.println(id);
        if(id.equals("lev1")) {
            Game game = new Game(new Level(1,0),event,0);
        } else if(id.equals("lev2")) {
            Game game = new Game(new Level(2,0),event,0);
        }else if(id.equals("lev3")) {
            Game game = new Game(new Level(3,0),event,0);
        }else if(id.equals("lev4")) {
            Game game = new Game(new Level(4,0),event,0);
        }else if(id.equals("lev5")) {
            Game game = new Game(new Level(5,0),event,0);
        }
    }
}
