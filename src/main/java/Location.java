import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Location {
//For testing to make sure I do thinks right
    public static void main(String[] args){
        out.println("Hello World!");
        Location loc1= new Location(1000,"Location7");

        out.println(loc1.distanceto(100));
    }

    private int milesinfromstart;
    private String locationname;
    private Event event;
    private Store store;
    private ArrayList<Weather> weather;

    //
    public Location(int milesinfromstart, String locationname, Store store, double storemultiplier, Event event){
        this.milesinfromstart = milesinfromstart;
        this.locationname = locationname;
        this.event = event;
        this.store=store;
        this.store.setMultiplier(storemultiplier);
    }
    public Location (int milesinfromstart, String locationname, Event event) {
        this.milesinfromstart = milesinfromstart;
        this.locationname = locationname;
        this.event = event;
        store = null;
    }

    public Location (int milesinfromstart, String locationname, Store store, double storemultiplier) {
        this.milesinfromstart = milesinfromstart;
        this.locationname = locationname;
        this.store = store;
        this.store.setMultiplier(storemultiplier);
    }

    public Location (int milesinfromstart, String locationname) {
        this.milesinfromstart = milesinfromstart;
        this.locationname = locationname;
    }

    public boolean hasStore(){
        return(store!=null);
    }
    public boolean hasEvent(){
        return(event!=null);
    }

    //getters and setters
    public int getMilesinfromstart() {
        return milesinfromstart;
    }

    public Event getEvent() {
        return event;
    }

    public void setMilesinfromstart(int milesinfromstart) {
        this.milesinfromstart = milesinfromstart;
    }

    public String getLocationName() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public int distanceto(int currentmilage){
        return (this.milesinfromstart-currentmilage);
    }

    public void goShopping(){
        //Prints out store's inventory for store
        boolean stayInStore = true;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to "+store.getName()+"! Below are our items:\n");
        while(stayInStore==true){
            System.out.println(store);
            System.out.println("You have "+store.getInventory().getDollars());
            System.out.println("What number item do you want? Enter -1 to leave instead");
            int selection = keyboard.nextInt();
            if(selection==-1){
                break;
            }
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
            if(stayString.toUpperCase().equals("Y")){
                stayInStore = false;
            }
        }
    }

    public void goIntoLocation(){
        out.println("Welcome to "+locationname);
        Scanner keyboard = new Scanner(in);
        boolean menu = true;
        while(menu==true){
            out.println("1.) Look Around");
            int optionNum = 2;
            int storeOption = -1;
            int advanceOption = -1;
            if(hasStore()){
                out.println(optionNum+".) Go into the store");
                storeOption = optionNum;
                optionNum++;
            }
            out.println(optionNum+".) Leave Town");
            advanceOption = optionNum;
            out.println("\n\nWhat would you like to do?");
            int option = keyboard.nextInt();
            if(option==1)
                out.println("You looked around the area and took in its beauty");
            else if(option < 1 || option > optionNum)
                out.println("Please select something that is an option");
            else if(option == storeOption&&storeOption!=-1)
                goShopping();
            else if(option == advanceOption){
                menu = false;
            }
            else{
                out.println("Please select something that is an option");
            }
        }
    }
    public Weather retrieveweekweather(int dayoftravel){
        int week = dayoftravel/7;
        return weather.get(week);
    }
//public void eventStoreHandler(Location eventLocation, int optionNum){
//
//
//    if (eventLocation.hasStore()){
//        //It looks like this is always -1
//        int townOption=-1;
//
//        out.println(optionNum+".) Go into town");
//        townOption = optionNum;
//        optionNum++;
//
//    }
//    if (eventLocation.getEvent().getEventType()== Event.EventType.RIVERCROSSING){
//        if(eventLocation.getEvent().riverEvent(eventLocation)){}
//    }
//}

    @Override
    public String toString() {
        return "Location{" +
                "milesinfromstart=" + milesinfromstart +
                ", locationname='" + locationname + '\'' +
                ", storeindicator=" + store +
                '}';
    }


}
