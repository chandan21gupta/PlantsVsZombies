package sample;

public class NormalZombie implements Zombies{
    private float health = 100;
    private float damage = 10;
    private float speed = 10;
    private int levelX = 1;
    private final String imgL1 = "src/images/chars/nightKingArmy1.png";
    private final String imgL2 = "src/images/chars/dannyArmy1.png";
    private final String imgL3 = "src/images/chars/cersieArmy1.png";

    public NormalZombie(int x){
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

    @Override
    public void move() {

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
}
