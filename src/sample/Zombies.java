package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Zombies{
    protected float health = 100;
    protected float damage = 10;
    protected int speed = 5;
    protected int levelX = 1;
    protected double X;
    protected double Y;
    protected ImageView imageView = new ImageView();
    protected String imgL1 = "src/images/chars/nightKingArmy1.png";
    protected String imgL2 = "src/images/chars/dannyArmy1.png";
    protected String imgL3 = "src/images/chars/cersieArmy1.png";
    protected int XCord;

    public Zombies(int x){

        levelX = x;

    }

    public float getHealth() {
        return this.health;
    }

    public void setHealth(float health) {
        this.health = this.health - health;
    }

    public void attack(Plant P) {
        P.setHealth(damage);
    }

    public void move() {
        setX(speed);
    }

    public double getX() {
        return X;
    }

    public void setX(int a) {
        X=X-a;
    }


    public double getY() {
        return Y;
    }

    public void setY(int a) {
        Y=Y-a;
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getName() {
        if (levelX==1){
            return this.imgL1;
        }
        else if (levelX==2){
            return this.imgL2;
        }
        else if (levelX==3){
            return this.imgL3;
        }
        else return this.imgL1;
    }

    public ImageView getImage(int z){
        String img_url = null;
        Image image = null;
        img_url = this.getName();
        try {
            File file = new File(img_url);

            img_url = file.toURI().toURL().toExternalForm();
            System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {
            //do nothing
        }
        imageView.setImage(image);
        imageView.setFitHeight(66);
        imageView.setFitWidth(40);
        setCoordinates(z);
        return imageView;
    }

    private void setCoordinates(int z){
        imageView.setX((double) 690);
        X = (double) 690;

        if (z==0){
            imageView.setY((double) 90);
            Y = (double) 90;
        }
        else if (z==1){
            imageView.setY((double) 148);
            Y = (double) 148;
        }
        else if(z==2){
            imageView.setY((double) 213);
            Y = (double) 213;
        }
        else if(z==3){
            imageView.setY((double) 271);
            Y = (double) 271;
        }
        else{
            imageView.setY((double) 331);
            Y = (double) 331;
        }
        System.out.println(imageView.getY());
    }

    public ImageView getImageView(){
        return this.imageView;
    }

}
