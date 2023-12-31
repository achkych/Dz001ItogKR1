﻿import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
  
    public void listCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                Set<String> commands = animal.getCommands();
                System.out.println("Список команд для " + name + ":");
                for (String command : commands) {
                    System.out.println("- " + command);
                }
                return;
            }
        }

        System.out.println("Животное " + name + " не найдено в реестре.");
    }

    public void trainAnimal(String name, String newCommand) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.addCommand(newCommand);
                System.out.println("Животное " + name + " успешно обучено новой команде: " + newCommand);
                return;
            }
        }

        System.out.println("Животное " + name + " не найдено в реестре.");
    }

    public void listAnimalsByDateOfBirth() {
        System.out.println("Список животных по дате рождения:");
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        Collections.sort(sortedAnimals, Comparator.comparing(Animal::getDateOfBirth));
        for (Animal animal : sortedAnimals) {
            System.out.println("- " + animal.getName() + ": " + animal.getDateOfBirth());
        }
    }
}


