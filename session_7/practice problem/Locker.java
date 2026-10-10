public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        // Check if the provided current code matches the actual code
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Locker " + lockerNumber + ": Code successfully changed.");
        } else {
            System.out.println("Locker " + lockerNumber + ": Incorrect current code. Change rejected.");
        }
    }
    
    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // Success
        l.changeCode("0000", "9999"); // Rejected
    }
}
