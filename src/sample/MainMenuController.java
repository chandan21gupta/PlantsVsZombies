package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
        Parent secondPane;
        Scene gameScene;
        //Parent gameScreen = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        System.out.println(id);
        if(id.equals("startGame")) {
            Game game = new Game(new Level(1,0),event,0);
        }
        else if (id.equals("selectLevel")){
            Parent newPane = FXMLLoader.load(getClass().getResource("SelectLevel.fxml"));
            gameScene = new Scene(newPane);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);
        }
        else if(id.equals("loadGame")) {
            Game game = new Game(new Level(1,1),event,1);
        }
        else if (id.equals("aboutGame")){
            Parent newPane = FXMLLoader.load(getClass().getResource("AboutScreen.fxml"));
            gameScene = new Scene(newPane);
            Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
            window.setScene(gameScene);
            window.show();
        }
        else if(id.equals("exitGame")) {
            //System.out.println("Exiting...");
            System.exit(1);
        }
    }
}
