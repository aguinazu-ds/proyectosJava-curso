package models;

public abstract class Animal {
    String name = "";
    String breed = "";
    Double weight = 0.0;

    public Animal() {
    }

    public Animal(String name, String breed, Double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


}
