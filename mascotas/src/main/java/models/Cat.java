package models;

public class Cat extends Animal implements Pet {

    public Cat() {
        super();
    }

    public Cat(String name, String breed, Double weight) {
        super(name, breed, weight);
    }    

    @Override
    public String showAffection() {
        return "Your "+getBreed()+" cat, "+getName()+", loked at you with some affection, you think";
    }    
}
