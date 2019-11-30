package sample;


public class JonSnow extends Plant{

    {
        this.health = 100;
        this.damage = 10;
        this.img = "src/sample/johnSnow.png";
        this.cost = 50;
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

}
