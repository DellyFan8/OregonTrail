import java.util.Objects;

public class Effect {
    public int Sickness(String Enum, String type, int health) {
        if (health <= 20) {
            System.out.println(Enum + " has died.");
            health = 0;
            return health;
        }
        else if (Objects.equals(type, "measles")) {
            System.out.println(Enum + " got measles.");
            health = health - 20;
            return health;
        }
        else {
            System.out.println(Enum + " got dysentery.");
            health = health - 20;
            return health;
        }
    }
}
