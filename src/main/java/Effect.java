import java.util.Objects;

public class Effect {
    public int Sickness(String name, String type, int health) {
        if (health <= 20) {
            System.out.println(name + " has died.");
            health = 0;
            return health;
        }
        else if (Objects.equals(type, "measles")) {
            System.out.println(name + " got measles.");
            health = health - 20;
            return health;
        }
        else {
            System.out.println(name + " got dysentery.");
            health = health - 20;
            return health;
        }
    }
}
