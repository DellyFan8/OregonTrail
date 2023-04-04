import java.util.Objects;

public class Effect {
    public int Sickness(String name, String type, int health) {
        if (health <= 15) {
            System.out.println(name + " has died from " + type + ".");
            health = 0;
            return health;
        }
        else if (health <= 20 && Objects.equals(type, "dysentery")) {
            System.out.println(name + " has died from dysentery.");
            health = 0;
            return health;
        }
        else if (Objects.equals(type, "measles")) {
            System.out.println(name + " got measles.");
            health = health - 15;
            return health;
        }
        else {
            System.out.println(name + " got dysentery.");
            health = health - 20;
            return health;
        }
    }
}
