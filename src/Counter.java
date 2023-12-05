import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Counter implements AutoCloseable {
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            throw new IllegalStateException("Rabota s obektom tipa Counter byla ne v resursnom try ili resurs ostalsya otkryt.");
        }
    }
}

//нужно просто сохранить код в файле с именем Main.java, скомпилировать его и запустить, чтобы увидеть результат
//public class Main {
//    public static void main(String[] args) {
//        try (Counter counter = new Counter()) {
//            // Работа с объектом типа Counter
//            counter.add(); // Увеличиваем значение на 1
//            int count = counter.getCount(); // Получаем значение счетчика
//            System.out.println("Значение счетчика: " + count);
//        } catch (IllegalStateException e) {
//            System.out.println("Исключение: " + e.getMessage());
//        }
//    }
//}

