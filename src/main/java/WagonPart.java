public class WagonPart extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {Axle, Wheel,Tongue, Ox}   //yes Ox is part of a wagon, Fight me
                                                // - Schmeling



    private final Type type;


    public WagonPart(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

}
