package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Sword {
    protected ImageView imageView;
    protected final String sword_url = "src/images/extraImages/sword.png";
    protected double x_coor;
    protected double y_coor;

    Sword(double x, double y) {
        x_coor = x;
        y_coor = y;
        Image image = null;
        String img_url = this.sword_url;
//        System.out.println("src/images/extraImages/sword.png");
        try {
            File file = new File(img_url);

           img_url = file.toURI().toURL().toExternalForm();
            System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {

        }
        //Image image = new Image(sword_url);
        imageView.setImage(image);
        imageView.setFitHeight(66);
        imageView.setFitWidth(40);
        imageView.setX(this.x_coor);
        imageView.setY(this.y_coor);
        imageView.setFitHeight(60);
        imageView.setFitWidth(30);
        this.imageView = imageView;
    }

//    private String getName() {
//        return this.sword_url;
//    }

    public ImageView getImage(){
        return imageView;
    }
}
