package races;

public class Human {
    public Integer strength = 3;
    public Integer stealth = 3;
    public Integer intelligence = 3;
    public Integer health = 100;

    public Human(){}

    public void attack(Human human) {
        human.setHealth(human.getHealth() - this.strength);
    }

    public Integer getStrength() {
        return this.strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getStealth() {
        return this.stealth;
    }

    public void setStealth(Integer stealth) {
        this.stealth = stealth;
    }

    public Integer getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

}
