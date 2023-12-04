import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
public class Pets extends Animal {
    protected Pets(String name, LocalDate dateOfBirth, Set<String> commands) {
        super(name, dateOfBirth);
        this.commands = commands;
    }
}
