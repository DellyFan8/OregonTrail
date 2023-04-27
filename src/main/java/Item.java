public class Item {

    //Does not impact anything other than display text
    private final String name;
    //Item weight in pounds
    private final double weight;
    private int quantity;
    public Item(){
        name = "UNDEFINED ITEM NAME";
        weight = -1;
    }

    public Item(String name, double weight){
        this.name = name;
        this.weight = weight;
        quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }



    @Override
    public String toString() {
        return name + "\t" +"weight- "+ weight;
    }
}
