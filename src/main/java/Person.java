import java.util.ArrayList;
import java.util.Random;

public class Person {
    private final int age;
    private final String name;
    private int health;
    //health the max health to 30 we can change. sense make?
    private ArrayList<Effect> effects =new ArrayList<>();
    public enum Gender{MALE, FEMALE}
    private final Gender gender;

    /**
     * Instantiates a new Person.
     *
     * @param age    the age of the person
     * @param name   the name of the person
     * @param health the health of the person
     * @param gender the gender of the person
     */
    public Person(int age, String name, int health, Gender gender) {
        this.age = age;
        this.name = name;
        this.health = health;
        this.gender = gender;
    }

    /**
     * Gets name of the person.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the int health of the person
     *
     * @return the health of the person
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Sets the health of a person.
     *
     * @param runnerhealth the health of the person
     */
    public void setHealth(int runnerhealth){
        this.health= runnerhealth;
    }

    /**
     * increase the health of a person.
     *
     * @param health the amount to increase health by.
     */
    public void increasehealth(int health){
        if (this.health<35)this.health+=health;
        else this.health=40;
    }

    /**
     * determines whether a person is going to get a sickness, and then randomly applies a sickness
     *
     * @param rations the current rations count
     * @return the sickness effect
     */
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
                effects.add(sickness);
            return sickness;

        }
        return null;
    }

    /**
     * Gets the effects that a person current has.
     *
     * @return the effects
     */
    public ArrayList<Effect> getEffects() {
        return effects;
    }

    /**
     * Remove effect at given index.
     *
     * @param index the index
     */
    public void removeEffect(int index){
        effects.remove(index);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", Effets=" + effects +
                ", gender=" + gender +
                '}'+"\n";
    }
}
