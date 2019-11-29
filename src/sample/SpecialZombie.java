package sample;

import javafx.scene.image.ImageView;

public class SpecialZombie implements Zombies{

    private float health = 400;
    private float damage = 12;
    private int speed = 5;
    private int levelX = 1;
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
    public ImageView getImage() {
        return null;
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
