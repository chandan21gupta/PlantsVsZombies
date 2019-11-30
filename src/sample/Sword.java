package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Sword {
    protected ImageView imageViewX= new ImageView();;
    protected final String sword_url = "src/images/extraImages/sword.png";
//    protected double x_coor;
//    protected double y_coor;
    int speed = 2;
    protected double X;
    protected double Y;

    public ImageView getImage(int x, int y){
        String img_url = null;
        Image image = null;
        img_url = sword_url;
        try {
            File file = new File(img_url);
            img_url = file.toURI().toURL().toExternalForm();
            System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {
            //do nothing
        }
        imageViewX.setImage(image);
        imageViewX.setFitHeight(50);
        imageViewX.setFitWidth(30);
        setCoordinates(x,y);
        return imageViewX;
    }

    public ImageView getImageView(){
        return imageViewX;
    }
    private void setCoordinates(int z, int y){
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
        System.out.println(imageViewX.getY());
    }

    public void move() {
        setX(speed);
    }

    public double getX() {
        return X;
    }

    public void setX(int a) {
        X=X+a;
    }


    public double getY() {
        return Y;
    }

    public void setY(int a) {
        Y=Y+a;
    }


}
