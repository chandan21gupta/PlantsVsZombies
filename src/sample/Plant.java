package sample;

public class Plant {
    protected float health = 100;
    protected float damage = 10;
    protected String img;
    protected int cost = 50;
    protected int xCord;
    protected int yCord;

    public Plant() {
    }

    public float getHealth() {
        return this.health;
    }
    public void setHealth(float health) {
        this.health = this.health - health;
    }
    public void attack(Zombies Z) {
        Z.setHealth(damage);
    }
    public float getDamage() {
        return this.damage;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }
    public String getName() {
        return this.img;
    }

    public void setXCord(int i) {
        this.xCord = i;
    }

    public void setYCord(int z){
        this.yCord = z;
    }

}
