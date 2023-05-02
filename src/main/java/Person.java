import java.util.ArrayList;
import java.util.Random;

public class Person {
    private final int age;
    private final String name;
    private int health;
    //health the max health to 30 we can change. sense make?
    private ArrayList<Effect> effets=new ArrayList<>();
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
    public void increasehealth(int health){
        if (this.health<35)this.health+=health;
        else this.health=40;
    }


    //currently suffers from duplicate Sicknesses
    public Effect randomsickness(int rations){
        Random rand = new Random();

        //this num can be adjusted to change how common these get to be
        if(rand.nextInt(20+(5-rations))>17){
            Effect sickness=null;
            switch (rand.nextInt(5)){
                case 1:
                    sickness = new Effect(Effect.Type.Cholera);
                    this.health-=20;
                    break;
                case 2:
                    sickness = new Effect(Effect.Type.Tyhoidfever);
                    this.health-=15;
                    break;
                case 3:
                    sickness = new Effect(Effect.Type.Measles);
                    this.health-=15;
                    break;
                case 4:
                    sickness = new Effect(Effect.Type.Dysentery);
                    this.health-=20;
                    break;
                case 5:
                    sickness=new Effect(Effect.Type.Prairiefever);
                    this.health-=20;
                    break;

            }
            if (sickness!=null)
                effets.add(sickness);
            return sickness;

        }
        return null;
    }

    public ArrayList<Effect> getEffets() {
        return effets;
    }
    public void removeEffect(int index){
        effets.remove(index);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", Effets=" + effets +
                ", gender=" + gender +
                '}'+"\n";
    }
}
