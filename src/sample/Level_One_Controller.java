package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;

public class Level_One_Controller {
    String current_plant = null;
    public void generatePlant(MouseEvent event) {
       current_plant = event.getPickResult().getIntersectedNode().getId();
        System.out.println(current_plant);
    }

    public void addPlant(MouseEvent event) {
        if(current_plant == null)
            return;
        String img_url = null;
        Image image = null;
        if(current_plant.equals("jonSnow")) {
            Plant jonSnow = new JonSnow();
            img_url = jonSnow.getName();
            System.out.println(img_url);
        }
        try {
            image = new Image("file:src/images/chars/johnSnow.png");
        }
        catch(Exception e) {
            //do nothing
        }
        ImageView imageView = new ImageView(image);
        double x = event.getX();
        double y = event.getY();
        imageView.setX(x);
        imageView.setY(y);
        System.out.println(x+" "+y);
        current_plant = null;
    }
}
