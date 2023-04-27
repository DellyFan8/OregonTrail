import java.util.ArrayList;

public class Person {
    private final int age;
    private final String name;
    private int health;
    //health the max health to 30 we can change. sense make?
    private ArrayList<Effect> Effets;
    public enum Gender{MALE, FEMALE}
    private final Gender gender;

    public Person(int age, String name, int health, Gender gender) {
        this.age = age;
        this.name = name;
        this.health = health;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int runnerhealth){
        this.health= runnerhealth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", Effets=" + Effets +
                ", gender=" + gender +
                '}'+"\n";
    }
}
