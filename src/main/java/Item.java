public class Item {

    //Does not impact anything other than display text
    //I utterly hate like 90% of this class.- A teammate.
    //Enum inside an extended class makes it nearly impossible to compare.
    private final String name;
    //Item weight in pounds
    private final double weight;
    private int quantity;
    public Item(){
        name = "UNDEFINED ITEM NAME";
        this.weight = -1;
    }

    public Item(String name, double weight){
        this.name = name;
        this.weight = weight;
        quantity = 1;
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.weight=0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }
    public void decreaseQuantity(){
        quantity--;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public String getName(){
        return name;
    }
    public void addquantity(int quantity){
        this.quantity+=quantity;
    }
    @Override
    public String toString() {
        return name + "\t" +"weight- "+ weight;
    }
}
