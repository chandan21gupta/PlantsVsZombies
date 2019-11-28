package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    public void changeScreen(ActionEvent event) throws IOException {
        final Node source = (Node)event.getSource();
        String id = source.getId();
        //Parent gameScreen = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        if(id.equals("startGame")) {
            Game game = new Game(new Level(1),event);
        }
    }
}
