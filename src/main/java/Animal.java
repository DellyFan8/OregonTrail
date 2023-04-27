public class Animal extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {HORSE, OXEN, MULE}
    private final Food.Type type;


    public Animal(Food.Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

    public Food.Type getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Food "+
                "type = " + type + " "+super.toString();
    }
}
