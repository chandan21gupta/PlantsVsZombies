package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Zombies {
    public float getHealth();
    public void setHealth(float health);
    public float getDamage();
    public void setDamage(float damage);
    public String getName();
    public void attack(Plant P);
    public void move();
    public int getX();
    public void setX(int a);
    public int getY();
    public void setY(int a);
    public ImageView getImage();
}
