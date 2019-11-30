package sample;

import javafx.scene.image.ImageView;

public class Arya extends Plant {
    {
        this.cost = 150;
        this.health = 250;
        this.damage = 50;
        this.img = "src/images/chars/arya.png";
        this.isShooter=1;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setDamage(float damage) {
        super.setDamage(damage);
    }

    @Override
    public void setHealth(float health) {
        super.setHealth(health);
    }

    @Override
    public void attack(Zombies Z) {
        super.attack(Z);
    }

    @Override
    public float getHealth() {
        return super.getHealth();
    }

    @Override
    public float getDamage() {
        return super.getDamage();
    }

    @Override
    public void setXCord(int i) {
        super.setXCord(i);
    }

    @Override
    public ImageView getImage() {
        return super.getImage();
    }

    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }

    @Override
    public void setYCord(int z) {
        super.setYCord(z);
    }

    @Override
    public int getCost() {
        return super.getCost();
    }

    @Override
    public void setCoordinates(int z, int y) {
        super.setCoordinates(z, y);
    }
}
