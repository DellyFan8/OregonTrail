import java.util.ArrayList;

public class Store {
    private String name;
    private final ArrayList<StoreItem> storeItems;

    private Inventory inventory;

    public Store(String name, Inventory inventory){
        this.name=name;
        this.inventory = inventory;
        storeItems = new ArrayList<StoreItem>();
//        storeItems.add(new StoreItem(new Food(Food.Type.WATER, "Water", 2), 4, 24.50));
//        storeItems.add(new StoreItem(new Food(Food.Type.FOOD, "Beef", 50), 1, 43));
//        storeItems.add(new StoreItem(new Food(Food.Type.FOOD, "Flour", 5), 2, 10.35));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Wheel,"Wagon Wheel",20),4,25));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Axle,"Wagon Axle",20),4,25));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Tongue,"WagonTongue",20),4,25));
        storeItems.add(new StoreItem(new OtherItem(OtherItem.Type.BULLETS, "Bullet case",5),30,10));


    }

    //for enabling stores to have different item count, cost is consistant for the store multi.
    public Store(String name, Inventory inventory,int storenum){
        this.name=name;
        this.inventory = inventory;
        storeItems = new ArrayList<StoreItem>();
        //Simplifying food to just rations
        storeItems.add(new StoreItem(new Food(Food.Type.RATIONS,"Rations",5),200, 1));
//        storeItems.add(new StoreItem(new Food(Food.Type.WATER, "Water", 2), 4, 24.50));
//        storeItems.add(new StoreItem(new Food(Food.Type.FOOD, "Beef", 50), 1, 43));
//        storeItems.add(new StoreItem(new Food(Food.Type.FOOD, "Flour", 5), 2, 10.35));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Wheel,"Wheel",20),4,25));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Axle,"Axle",20),4,25));
        storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Tongue,"Tongue",20),4,25));
        storeItems.add(new StoreItem(new OtherItem(OtherItem.Type.BULLETS, "Bullets",5),30,10));

        if (storenum==0)
        {
            storeItems.add(new StoreItem(new WagonPart(WagonPart.Type.Ox,"Oxen", 0),8,60));
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory){
        this.inventory=inventory;
    }
    public int confirmPurchase(int num, int quantity){
        if(storeItems.get(num-1).getQuantity()>=quantity&&inventory.getDollars()>=storeItems.get(num-1).getCost()*quantity){
            return 1;
        }
        return -1;
    }
    public void purchase(int number, int quantity){
            inventory.takeDollars(storeItems.get(number-1).getCost()*quantity);
            for(int i = 0; i<quantity; i++){
                inventory.add(storeItems.get(number-1).getItem());
                storeItems.get(number-1).lowerQuantity(1);
            }
    }

    public String getItemName(int item){
        return storeItems.get(item).getItem().getName();
    }

    public double getItemPrice(int item){
        return storeItems.get(item).getCost();
    }

    public void addItem(StoreItem item){
        storeItems.add(item);
    }

    @Override
    public String toString() {
        String toReturn = "Option #:\tItem:\t\t\tPrice:\t\tQuantity Available\n";
        int itemNumber = 1;
        for(StoreItem i:storeItems){
            //if(i.getQuantity()>0){
                toReturn+=itemNumber+".\t\t\t"+i.getItem().getName()+"\t\t\t$"+i.getCost()+"\t\t"+i.getQuantity()+"\n";
                itemNumber++;
            //}
        }
        return toReturn;
    }

    public void setMultiplier(double storeMultiplier) {
        for(StoreItem item:storeItems){
            System.out.println(item.getCost()+"\t"+Math.round(item.getCost()*storeMultiplier*100));
            item.setCost(Math.round(item.getCost()*storeMultiplier * 100) / 100.0);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
