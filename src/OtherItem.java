public class OtherItem extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {}
    private Type type;


    public OtherItem(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

}
