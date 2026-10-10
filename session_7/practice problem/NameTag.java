public class NameTag {
    private final String firstName;
    private final char lastInitial;

    public NameTag(String fullName) {
        // Split the full name by space
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        // Store only the first character of the last name
        this.lastInitial = parts[1].charAt(0);
    }

    public String getNickname() {
        // Constructs and returns "First L."
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Output: Maria G.
    }
}
