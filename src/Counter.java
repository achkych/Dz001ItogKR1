import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            throw new IllegalStateException("Resurs ostalsya otkrytym");
        }
    }
}