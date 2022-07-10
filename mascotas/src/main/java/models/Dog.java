package models;

public class Dog extends Animal implements Pet {
    public Dog() {
        super();
    }

    public Dog(String name, String breed, Double weight) {
        super(name, breed, weight);
    }

    @Override
    public String showAffection() {
        if (getWeight() < 30) {
            return getName()+" hopped into your lap and cuddled you!";
        } else {
            return getName()+" curl next to you!";
        }
    }
    
}
