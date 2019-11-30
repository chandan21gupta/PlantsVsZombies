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
        //Parent gameScreen = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
        System.out.println(id);
        if(id.equals("startGame")) {
            Game game = new Game(new Level(1),event);
        }
        else if (id.equals("selectLevel")){
            System.out.println("selectLevel");
        }
        else if(id.equals("loadGame")) {
            System.out.println("loadBut");
//            secondPane = FXMLLoader.load(getClass().getResource("AboutScreen.fxml"));
//            Game game = new Game(new Level(1),event);
        }
        else if (id.equals("aboutGame")){
            secondPane = FXMLLoader.load(getClass().getResource("AboutScreen.fxml"));
        }
        else if(id.equals("exit")) {
            System.exit(-1);
        }

    }
}
