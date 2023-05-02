public class WagonPart extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {Axle, Wheel,Tongue, Ox,Test}   //yes Ox is part of a wagon, Fight me
                                                // - Schmeling



    private final Type type;


    public WagonPart(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

    public WagonPart( Type type,String name, int quantity,boolean literallytodesignate) {
        super(name, quantity);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    public void removeItem(WagonPart part){
        if(part.getType()==this.type){
            addquantity(part.getQuantity()*-1);
        }

    }

}
