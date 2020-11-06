package com.company;

import com.company.animal.Animal;
import com.company.animal.HuntResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        HashSet<Animal> setOfAnimals = Animal.generateSetOfAnimals(30);

        ArrayList<Animal> list;
        list = new ArrayList<Animal>(setOfAnimals.stream()
                .sorted(((a1, a2) -> a2.getSize() - a1.getSize()  ))
                .collect(Collectors.toList()));

        Animal victim = list.get(list.size() - 1);
        list.remove(list.size() -1);

        HuntResult result = Animal.hunt(list, victim);
        System.out.printf("Жертва %s убегает ", victim);
        System.out.println("За ней гонятся стая животных состоящих из: ");
        for (Animal animal: list){
            System.out.println(animal);
        }
        String resultToPrint = result != null ? String.format("Жертву догнал зверь %s, на расстоянии %s метров", result.getHunter(), result.getHunter().getRanDistance()) : "Никто из стаи не догнал жертву";

        System.out.println(resultToPrint);
    }
}
