package sample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level {
    ArrayList<String> lev = new ArrayList<>();
    String name;
    int level = 1;
//    Parent gameScreen;
    FXMLLoader gameScreen;
    Level_One_Controller controller ;
    {
        lev.add("playScreen");
        lev.add("Level2");
        lev.add("Level3");
        lev.add("Level4");
        name = lev.get(level-1)+".fxml";
    }

    Level(int level,int load) {

        if (load==1){
            controller = new Level_One_Controller(1);
        }
        else {
            controller = new Level_One_Controller(0);
        }

        this.level = level;
        if(this.level == 1) {
            try {
                gameScreen = new FXMLLoader(getClass().getResource(name));
                gameScreen.setController(controller);
            }
            catch(Exception e) {
                System.out.println("Nothing on ground level");
            }
        }
        else if(this.level == 2) {
            try {
                gameScreen = new FXMLLoader(getClass().getResource(name));
                gameScreen.setController(controller);
            }
            catch(Exception e) {
                System.out.println("Nothing on level 2");
            }
        }
        else if(this.level == 3) {
            try {
                gameScreen = new FXMLLoader(getClass().getResource(name));
                gameScreen.setController(controller);
            }
            catch(Exception e) {
                System.out.println("Nothing on level 3");
            }
        }
        else {
            try {
                gameScreen = new FXMLLoader(getClass().getResource(name));
                gameScreen.setController(controller);
            }
            catch(Exception e) {
                System.out.println("Nothing on level 4");
            }
        }
        System.out.println(gameScreen);
    }

     FXMLLoader getPane() {
        return this.gameScreen;
    }
}
