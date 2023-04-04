import java.util.Objects;

public class Effect {
    public int Sickness(String type, int health) {
        if (health <= 15) {
            health = 0;
            return health;
        }
        else if (health <= 20 && Objects.equals(type, "dysentery")) {
            health = 0;
            return health;
        }
        else if (Objects.equals(type, "measles")) {
            health = health - 15;
            return health;
        }
        else {
            health = health - 20;
            return health;
        }
    }

    public String SicknessResult(String type, int health) {
        if (health <= 15) {
            return (" has died from ");
        }
        else if (health <= 20 && Objects.equals(type, "dysentery")) {
            return (" has died from ");
        }
        else {
            return (" got ");
        }
    }
}
