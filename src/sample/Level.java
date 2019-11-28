package sample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level {
    int level = 1;
    Parent gameScreen;
    Level(int level) {
        this.level = level;
        if(this.level == 1) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource("playScreen.fxml"));
            }
            catch(Exception e) {
                System.out.println("Nothing on ground level");
            }
        }
        else if(this.level == 2) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource("Level2.fxml"));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 2");
            }
        }
        else if(this.level == 3) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource("Level3.fxml"));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 3");
            }
        }
        else if(this.level == 4) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource("Level4.fxml"));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 4");
            }
        }
//        else if(this.level == 5) {
//
//        }
    }

     Parent getPane() {
        return this.gameScreen;
    }
}
