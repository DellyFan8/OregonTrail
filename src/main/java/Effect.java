import java.util.Objects;

public class Effect {
    enum Type {Dysentery, Cholera, Measles, Tyhoidfever,Prairiefever}
    Type effecttype;

    public Effect(Type type){
        this.effecttype= type;

    }

    public Type getEffecttype() {
        return effecttype;
    }
    public String sicknessName(){
        if (effecttype==Type.Dysentery){
            return "Dysentery";
        }if (effecttype==Type.Cholera){
            return "Cholera";
        }if (effecttype==Type.Measles) {
            return "Measles";
        }if (effecttype==Type.Prairiefever){
            return "Prairie fever";
        }else
            return "Typhoid fever";
    }

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


    @Override
    public String toString() {
        return "Effect{" +
                "effecttype=" + effecttype +
                '}';
    }
}
