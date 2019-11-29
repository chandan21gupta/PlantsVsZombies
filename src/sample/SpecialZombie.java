package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class SpecialZombie implements Zombies{

    private float health = 400;
    private float damage = 12;
    private int speed = 5;
    private int levelX = 1;
    private ImageView imageView = new ImageView();
    private int X;
    private int Y;
    private final String imgL1 = "src/images/chars/nightKingArmy1.png";

    public SpecialZombie(int x){
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
        //Special Attack to be added here;
    }

    @Override
    public void move() {
        setX(speed);
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public void setX(int a) {
        X=X-a;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public void setY(int a) {
        Y=Y-a;
    }

    @Override
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
        imageView.setFitHeight(70);
        imageView.setFitWidth(40);
        setCoordinates(z);
        return imageView;
    }

    private void setCoordinates(int z){
        imageView.setX((double) 690);
        if (z==0){
            imageView.setY((double) 148);
        }
        else if(z==1){
            imageView.setY((double) 213);
        }
        else if(z==2){
            imageView.setY((double) 271);
        }
        else if(z==3){
            imageView.setY((double) 321);
        }
        else if(z==4){
            imageView.setY((double) 392);
        }
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getName() {
            return this.imgL1;

    }

}
