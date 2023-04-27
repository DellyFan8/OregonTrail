public class Tool extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {}
    private final Type type;


    public Tool(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

}
