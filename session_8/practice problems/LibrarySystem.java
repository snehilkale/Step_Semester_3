import java.time.LocalDate;
import java.util.List;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public String calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDays()).toString();
    }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    @Override public int getBorrowingDays() { return 14; }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    @Override public int getBorrowingDays() { return 7; }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    @Override public int getBorrowingDays() { return 3; }
}

public class LibrarySystem {
    public static void processItems(List<String> inputLines) {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
            
            LibraryItem item = null;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                case "MAGAZINE": item = new Magazine(title); break;
            }
            
            if (item != null) {
                System.out.println(item.title + ": " + item.calculateDueDate(currentDate));
            }
        }
    }

    public static void main(String[] args) {
        processItems(List.of("BOOK \"1984\"", "DVD \"The Matrix\"", "MAGAZINE \"Forbes Issue 500\""));
    }
}
