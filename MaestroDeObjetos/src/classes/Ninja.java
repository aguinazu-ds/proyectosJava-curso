package classes;

import races.Human;

public class Ninja extends Human {
    public Ninja(){
        super();
        this.stealth = 10;
    }
    public void steal(Human human) {
        human.setHealth(human.getHealth() - this.stealth);
        this.health = this.health + this.stealth;
    }
    public void runAway() {
        this.health = this.health - 10;
    }
}
