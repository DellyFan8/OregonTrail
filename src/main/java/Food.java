public class Food extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {FOOD, WATER}
    private final Type type;


    public Food(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

    public Type getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Food "+
                "type = " + type + " "+super.toString();
    }
}
