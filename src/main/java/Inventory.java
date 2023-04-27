import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    //Stores all items for game
    private ArrayList<Item> items;
    private ArrayList<Person> peopleinparty;

    //Stores group's money
    private double dollars;

    public Inventory(double dollars, ArrayList<Person> peopleinparty){
        this.peopleinparty = peopleinparty;
        items = new ArrayList<>();
        this.dollars = dollars;
    }
    public Inventory(double dollars){
        items = new ArrayList<>();
        this.dollars = dollars;
    }
    public int personcount(){
        return peopleinparty.size();
    }

    //Adds item to the inventory list
    //If item already exists then quantity is increased of that item instead of adding a new object
    public void add(Item item){
        boolean found = false;
        for(Item x:items){
            if(x.getName().equals(item.getName())){
                x.increaseQuantity();
                found = true;
            }
        }
        if(!found){
            items.add(item);
        }
    }

    public Inventory(ArrayList<Person> peopleinparty, double dollars) {
        this.peopleinparty = peopleinparty;
        this.dollars = dollars;
    }

    //Loops through inventory and adds up weight of items (NEEDS IMPLEMENTED)
    public double getWeight(){
        return -1;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public double getDollars() {
        return dollars;
    }

    public void setDollars(double dollars) {
        this.dollars = dollars;
    }

    public void takeDollars(double amount){
        dollars-=amount;
    }


    //Display Inventory
    //Need to add section for each type of item class
    @Override
    public String toString() {
        String toReturn = "";
        toReturn+="Money:  "+dollars+"\n";
        //Food
        toReturn+="Name\tType\tQuantity\n";
        for(Item x:items){
            if(x.getClass() == Food.class){
                toReturn+=x.getName()+"\t"+((Food) x).getType()+"\t"+x.getQuantity()+"\n";
            }
        }

        return toReturn;
    }

    public ArrayList<Person> getPeopleinparty() {
        return peopleinparty;
    }
    public Person getIndividual(int index){
        return getPeopleinparty().get(index);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
