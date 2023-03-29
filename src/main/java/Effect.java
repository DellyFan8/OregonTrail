import java.util.Objects;

public class Effect {
    public void Sickness(String Enum, String type) {
        if (Objects.equals(type, "measles")) {
            System.out.println(Enum + " got measles!");

        }
        else if (Objects.equals(type, "dysentery")) {
            System.out.println(Enum + " got dysentery!");

        }
    }
}
