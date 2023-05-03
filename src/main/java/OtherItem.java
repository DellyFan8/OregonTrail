public class OtherItem extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {BULLETS}
    private final Type type;


    public OtherItem(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }
    public OtherItem(Type type, String name, int quantity, boolean designate) {
        super(name, quantity);
        this.type = type;
    }

}
