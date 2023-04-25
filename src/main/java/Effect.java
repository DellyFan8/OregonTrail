import java.util.Objects;

public class Effect {
    public int Sickness(String type, int health) {
        if (Objects.equals(type, "dysentery") || Objects.equals(type, "cholera")) {
            if (health <= 20) {
                health = 0;
                return health;
            }
            else {
                health = health - 20;
                return health;
            }
        }
        else if (Objects.equals(type, "measles") || Objects.equals(type, "typhoid fever")) {
            if (health <= 15) {
                health = 0;
                return health;
            }
            else {
                health = health - 15;
                return health;
            }
        }
        return health;
    }

    public String SicknessResult(String type, int health) {
        if (health <= 15) {
            return (" has died from ");
        }
        else if ((health <= 20) && (Objects.equals(type, "dysentery") || Objects.equals(type, "cholera"))) {
            return (" has died from ");
        }
        else {
            return (" got ");
        }
    }
}
