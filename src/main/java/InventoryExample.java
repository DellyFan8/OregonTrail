import java.util.Scanner;

public class InventoryExample {
    public static void main(String[] args){
        Inventory inventory = new Inventory(1500);

        //Syntax for adding items to the inventory of the user

        Item item = new Food(Food.Type.FOOD, "Beef", 2);

        //If adding existing item object
        inventory.add(item);

        //If simply adding item to the list that doesn't exist yet
        inventory.add(new Food(Food.Type.FOOD, "Beef", 2));
        inventory.add(new Food(Food.Type.WATER, "aqua", 10));
        inventory.add(new Food(Food.Type.WATER, "aqua", 10));
        inventory.add(new Food(Food.Type.WATER, "aqua", 10));
        inventory.add(new Food(Food.Type.WATER, "aqua", 10));
        inventory.add(new Food(Food.Type.WATER, "aqua", 10));

        //Should output 5 aqua and 2 Mr. Moo
        System.out.println(inventory);


        //Creates a new store
        Store store = new Store("Trader Bob's", inventory);
            //Prints out store's inventory for store
        boolean stay = true;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to "+store.getName()+"! Below are our items:\n");
        while(stay){
            System.out.println(store);
            System.out.println("You have "+store.getInventory().getDollars());
            System.out.println("What number item do you want?");
            int selection = keyboard.nextInt();
            System.out.println("How many");
            int num = keyboard.nextInt();
            if(store.confirmPurchase(selection,num)==1){
                System.out.println("You are about to purchase " + num+ " "+store.getItemName(selection-1)+" for a total of "+ store.getItemPrice(selection-1)*num+"\nAre you sure? (y/n)");
                String confirm = keyboard.next();
                if(confirm.equalsIgnoreCase("Y")){
                    store.purchase(selection, num);
                    System.out.println("Purchase Confirmed");
                }
                else{
                    System.out.println("Purchase Cancelled");
                }
            }
            else{
                System.out.println("You either don't have enough money or tried to order more than what is available\nPlease try again.");
            }
            System.out.println("Leave? (y/n)");
            String stayString = keyboard.next();
            if(stayString.equalsIgnoreCase("Y")){
                stay = false;
            }
        }
            System.out.println("\n\n"+inventory);
            System.out.println(store);
    }


}
