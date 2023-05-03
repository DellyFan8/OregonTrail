import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Inventory {
    //Stores all items for game
    private static ArrayList<Item> items;
    private ArrayList<Person> peopleinparty;

    //Stores group's money
    private double dollars;

//    public static void main(String[] args){
//        Inventory test = new Inventory(600);
//        test.add(new WagonPart(WagonPart.Type.Wheel,"Wheel",0));
//        test.add(new WagonPart(WagonPart.Type.Axle, "Axle",0));
//        test.add(new WagonPart(WagonPart.Type.Axle, "Axle",0));
//        test.add(new WagonPart(WagonPart.Type.Axle, "Axle",0));
//        test.add(new Food(Food.Type.FOOD,"food",0));
//        System.out.println(test);
//    }

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
        double weight=0;
        for (Item item:items){
            weight+=item.getWeight();
        }
        return weight;
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
            if(x.getClass()==WagonPart.class){
                toReturn+=x.getName()+"\t"+((WagonPart) x).getType()+"\t"+x.getQuantity()+"\n";
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


    //breaks a wagon part
    public Item brokenWagonpart(){
        Random rand = new Random();
        ArrayList<Item> runneritems = getitemtypes();
        Item brokenitem= runneritems.get(rand.nextInt(runneritems.size()));



        return brokenitem;
    }


    //this function will iterate through all items and return an array of all items of a certain type, Food
    public static ArrayList<Item> getitemtypes(){
        ArrayList<Item> runner= new ArrayList<>();
        for (Item item:items) {
            if (item.getClass()==WagonPart.class){
                runner.add(item);
            }
        }
        return runner;
    }
    public int getRations(){
        for (Item item:items){
            if (item.getClass()==Food.class)
                return ((Food)item).getQuantity();
        }
        return 0;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public ArrayList<Item> getClassItem(Class cls){
        ArrayList<Item> runner=new ArrayList<>();
        for (Item item:items) {
            if(item.getClass()==cls)
                runner.add(item);
        }
        return runner;
    }
    public void removeItems(Item itemtoremove){
        for (Item item:items) {
            if (itemtoremove.getClass()==WagonPart.class&&item.getClass()==itemtoremove.getClass())
                ((WagonPart)item).removeItem(((WagonPart) itemtoremove));
            if (itemtoremove.getClass()==Food.class&&item.getClass()==itemtoremove.getClass())
                ((Food)item).removeItem(((Food) itemtoremove));
            if (itemtoremove.getClass()==Medicine.class&&item.getClass()==itemtoremove.getClass())
                ;

        }


    }

}

