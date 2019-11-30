package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.Serializable;

public class Advice implements Serializable {
    protected ImageView imageViewX = new ImageView();
    private final String img_url = "src/images/extraImages/scroll.png";
    String getName() {
        return this.img_url;
    }
    double X;
    double Y;
    public ImageView getImageView() {
        String img = null;
        Image image = null;
        img = img_url;
        try {
            File file = new File(img);
            img = file.toURI().toURL().toExternalForm();
            image = new Image(img);
        }
        catch(Exception e) {
            //do nothing
        }
        imageViewX.setImage(image);
        return imageViewX;
    }

    public void setCoordinates(int z, int y){
        if (y==0){
            imageViewX.setX((double) 110);
            X = (double) 110;
        }
        else if (y==1){
            imageViewX.setX((double)180);
            X = (double) 180;
        }
        else if (y==2){
            imageViewX.setX((double)250);
            X = (double) 250;
        }
        else if (y==3){
            imageViewX.setX((double)330);
            X = (double) 330;
        }
        else if (y==4){
            imageViewX.setX((double)410);
            X = (double) 410;
        }
        else if (y==5){
            imageViewX.setX((double)490);
            X = (double) 490;
        }

        if (z==0){
            imageViewX.setY((double) 90);
            Y = (double) 90;
        }
        else if (z==1){
            imageViewX.setY((double) 148);
            Y = (double) 148;
        }
        else if(z==2){
            imageViewX.setY((double) 213);
            Y = (double) 213;
        }
        else if(z==3){
            imageViewX.setY((double) 271);
            Y = (double) 271;
        }
        else{
            imageViewX.setY((double) 331);
            Y = (double) 331;
        }
        //System.out.println(imageViewX.getY());
    }
}
