import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;

public class AnimalRegistry {
    private static int totalAnimalsCreated = 0; // Статическая переменная-счетчик
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        incrementTotalAnimalsCreated(); // Увеличение счетчика при добавлении животного
    }
   
    private static void incrementTotalAnimalsCreated() {
        totalAnimalsCreated++; // Увеличение счетчика на 1
    }  

    public static int getTotalAnimalsCreated() {
        return totalAnimalsCreated;
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
        Collections.sort(animals, (a1, a2) -> a1.getDateOfBirth().compareTo(a2.getDateOfBirth()));

        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName() + ": " + animal.getDateOfBirth());
        }
    }
}

//Выводит общее кол-во созданных животных:
//AnimalRegistry registry = new AnimalRegistry();
//registry.addAnimal(new Animal("Кот"));
//registry.addAnimal(new Animal("Собака"));
//registry.addAnimal(new Animal("Корова"));

//int totalAnimals = AnimalRegistry.getTotalAnimalsCreated();
//System.out.println("Общее количество созданных животных: " + totalAnimals);
