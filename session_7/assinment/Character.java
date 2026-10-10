package assinment;

public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Starts at max health
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHealth -= amount;
            if (currentHealth < 0) {
                currentHealth = 0; // Floor at 0
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            currentHealth += amount;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth; // Cap at max health
            }
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getCurrentHealth()); // 70
        
        c.heal(50);
        System.out.println("Health after 50 heal: " + c.getCurrentHealth()); // 100 (capped)
        
        c.takeDamage(150);
        System.out.println("Health after 150 damage: " + c.getCurrentHealth()); // 0 (floored)
    }
}
