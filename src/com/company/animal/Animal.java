package com.company.animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Animal {
    int size;
    String name;
    int speed;
    int distanceToHome;
    int ranDistance;

    public int getRanDistance() {
        return ranDistance;
    }

    public void setRanDistance(int ranDistance) {
        this.ranDistance = ranDistance;
    }

    public Animal(int size, String name, int speed, int distanceToHome ) {
        this.size = size;
        this.name = name;
        this.speed = speed;
        this.distanceToHome = distanceToHome;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistanceToHome() {
        return distanceToHome;
    }

    public void setDistanceToHome(int distanceToHome) {
        this.distanceToHome = distanceToHome;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", distanceToHome=" + distanceToHome +
                '}';
    }

    public static HashSet<Animal> generateSetOfAnimals(int size){
        HashSet<Animal> set = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int siz = rand.nextInt(100);
            String rName = "animal" + i;
            int rSpeed = rand.nextInt(30);
            int rD2H = rand.nextInt(100);
            set.add(new Animal(siz, rName, rSpeed, rD2H ));
        }
        return set;
    }

    public static HuntResult hunt(ArrayList<Animal> pack, Animal victim){
        int distanceToRun = victim.getDistanceToHome();

        for (int i = 0; i < distanceToRun; i++) {
            victim.setRanDistance(victim.getRanDistance() + victim.getSpeed());
            for (Animal animal: pack){
                animal.setRanDistance(animal.getRanDistance() + animal.getSpeed());
                if(animal.getRanDistance() >= victim.getRanDistance()){
                    return new HuntResult(animal);
                }
            }
        }
        return null;
    }
}
