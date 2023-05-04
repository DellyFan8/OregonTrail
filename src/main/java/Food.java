public class Food extends Item{
    //Adds custom types of each item (controls behavior in standardized form)
    public enum Type {FOOD, WATER, RATIONS}
    private final Type type;


    /**
     * Instantiates a new Food.
     *
     * @param type   the type of food
     * @param name   the name of the food
     * @param weight the weight of the food
     */
    public Food(Type type, String name, double weight){
        super(name, weight);
        this.type = type;
    }

    /**
     * Instantiates a new Food.
     *
     * @param type      the type of food
     * @param name      the name of the food partly legacy from before switching to pure rations
     * @param quantity  the quantity of food
     * @param designate Designates between the two food declarations.
     */
    public Food(Type type, String name, int quantity,boolean designate) {
        super(name, quantity);
        this.type = type;
    }

    /**
     * Get the type of food
     *
     * @return the type of food
     */
    public Type getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Food "+
                "type = " + type + " "+super.toString();
    }

    /**
     * Remove the amount of food,
     *
     * @param item the food item to remove, including quantity.
     */
    public void removeItem(Food item){
        if(item.getType()==this.type){
            addquantity(item.getQuantity()*-1);
        }

    }
}
