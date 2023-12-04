import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class AnimalRegistryProgram {
    private static AnimalRegistry registry = new AnimalRegistry();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                showMenu();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewAnimal(scanner);
                        break;
                    case 2:
                        listCommands(scanner);
                        break;
                    case 3:
                        trainAnimal(scanner);
                        break;
                    case 4:
                        listAnimalsByDateOfBirth();
                        break;
                    case 5:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } while (choice != 5);
        }
    }
    private static void showMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Добавить новое животное");
        System.out.println("2. Вывести список команд животного");
        System.out.println("3. Обучить новой команде");
        System.out.println("4. Вывести список животных по дате рождения");
        System.out.println("5. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    private static void addNewAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
        System.out.print("Введите тип животного (собака, кошка, хомяк, лошадь, верблюд, осел): ");
        String type = scanner.nextLine();

        Animal animal;
        Set<String> commands = new HashSet<>();
        switch (type.toLowerCase()) {
            case TypeAnimal.DOG:
                animal = new Dog(name, dateOfBirth, commands);
                break;
            case TypeAnimal.CAT:
                animal = new Cat(name, dateOfBirth, commands);
                break;
            case TypeAnimal.HAMSTER:
                animal = new Hamster(name, dateOfBirth, commands);
                break;
            case TypeAnimal.HORSE:
                animal = new Horse(name, dateOfBirth, commands);
                break;
            case TypeAnimal.CAMEL:
                animal = new Camel(name, dateOfBirth, commands);
                break;
            case TypeAnimal.DONKEY:
                animal = new Donkey(name, dateOfBirth, commands);
                break;
            default:
                System.out.println("Неверный тип животного. Животное не добавлено.");
                return;
        }

        registry.addAnimal(animal);
        System.out.println("Животное " + name + " успешно добавлено в реестр.");
    }

    private static void listCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        registry.listCommands(name);
    }

    private static void trainAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новую команду: ");
        String command = scanner.nextLine();
        registry.trainAnimal(name, command);
    }

    private static void listAnimalsByDateOfBirth() {
        registry.listAnimalsByDateOfBirth();
    }
}