import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.out;

//I think we should probably have a map class
public class Map {
    public static void main(String[] args){

//        //series of locations for testing
//        ArrayList<Location> runnerLocations = new ArrayList<>();
//
//        //Insert location adding loop at some point when aaron is Good
//        runnerLocations.add(new Location(0,"location0"));
//        runnerLocations.add(new Location(1000,"Location1"));
//        runnerLocations.add(new Location(2000,"location2"));
//        runnerLocations.add(new Location(2500, "Special event crossing river"));//special event
//int day=0;
//        Map trail = new Map(runnerLocations, day);
//
//        //jerk
//        out.println(trail.toString());
//        out.println("");
//        out.println(trail.closestloc());
    }


        private ArrayList<Location> locations;
        private int playerdistance=0;
        private int daynumber;//to deal with weather events, possibly add days depending on what month is picked and then subtract that at the end when displaying how long of a trip you had.
        private int startnumber;
        private ArrayList<String> notification = new ArrayList<>();


        public Map(ArrayList<Location> locations, Inventory inventory, int day) {
            this.locations = locations;
            this.daynumber=day;
            this.startnumber=day;
        }

        public int distanceto(Location target){
            return target.getMilesinfromstart()-playerdistance;

        }

    public int getPlayerdistance() {
        return playerdistance;
    }

    //default to next location.
        public int distanceto(){
            return distanceto(closestloc());
        }
        public Location closestloc() {
            for (Location loc : locations) {
                if (loc.getMilesinfromstart() >= playerdistance) {
                    return loc;
                }
            }
            return locations.get(locations.size()-1);
        }

        //advance the day,
        public int advanceDay() {
            int dist = dailyDistanceTravelled();
            int distanceToNextLocation = distanceto(closestloc());

            if(distanceToNextLocation<dist && distanceToNextLocation!= 0){
                playerdistance+=distanceToNextLocation;
                daynumber++;

                //needs to be done separately
                return distanceToNextLocation;
            }
            else {
                playerdistance += dist;
                daynumber++;
                return dist;
            }

        }

        //handling if user decides to wait somewhere, not implemented elsewhere but may be eventually
    public int advanceDay(boolean dayadvance) {
        int dist = dailyDistanceTravelled();
        int distanceToNextLocation = distanceto(closestloc());

        if(distanceToNextLocation<dist && distanceToNextLocation!= 0){
            daynumber++;

            //needs to be done separately
            return 0;
        }
        else {
            daynumber++;
            return 0;
        }

    }


    //add a notification to be displayed
        public void addnoti(String runnernotification){
            notification.add(runnernotification);
        }

        //Clear all notifications
        public void clearnoti(){
            for (int i = notification.size(); i > 0; i--) {
                notification.remove(0);
            }
        }

        //Get a notification from an index
        public String getnoti(int index){
            return notification.get(index);
        }

        //Calculating miles travelled on a given day
        public int dailyDistanceTravelled(){
            //for testing will be 20, however at some point will need to handle distance calulation
            //may need to be passed information
            return 20;
        }
//    Legacy funtion:
//    public void dayDisplay(){
//        //display day related information every time a day advances
//        // record names of places entered, rivers crossed etc
//
//
//        out.println("Day "+(daynumber-startnumber)+", "+toDate()+":"); //plus one so we don't get "April 1st day 0:"
//        if (notification.size()!=0){
//            for (int i = 0; i <notification.size() ; i++) {
//                out.println(getnoti(i));
//            }
//        }
//
//        out.println("Daily log of injuries, illnesses, events, etc. goes here");
//        clearnoti();
//
//    }

    //display what events happened that day
    public void dayDisplay(int distanceTravelled){
    //display day related information every time a day advances
        // record names of places entered, rivers crossed etc

//Use we or you?

           out.println("Today you travelled "+ distanceTravelled+" miles.");
           if (distanceto()== 0)
           {
               //This can now be handled with noticiations. keeping here because it was stupid once upon a time and good for memories
//               if (closestloc().hasEvent()) {
//                   if (closestloc().getEvent().getEventType() == Event.EventType.RIVERCROSSING)
//                       out.println("You crossed the " + closestloc().getLocationName().substring(0, closestloc().getLocationName().length() - 9) + ".");
//               }
           }
           else out.println(distanceto()+" miles to "+closestloc().getLocationName()+".");
        if (notification.size()!=0){
               for (int i = 0; i <notification.size() ; i++) {
                   out.println(getnoti(i));
           }
           }

           out.println("Daily log of injuries, illnesses, events, etc. goes here");
           clearnoti();
           out.println();

    }

    public void RandomEvent() {
        Random rand = new Random();
        int randNum = (int) (Math.random() % 100);
        if (randNum >= 0 && randNum <= 1) { // lose trail(2.0%), call event class
        }
        else if (randNum >= 2 && randNum <= 3) { // thief comes during night(2.0%), call event class
        }
    }

    public int RandomSickness(String name, int health) {//name should be replaced with Enum
        int randSickness = (int) (Math.random() % 100);
        Effect EffectClass = new Effect();
        if (health != 40) {
            if (randSickness >= 0 && randSickness < (40 - health)) {
                // one of the random sicknesses is given to this person
                int num = (int) (Math.random() % 2);
                int newHealth;
                String SicknessNotification;
                if (num == 0) {
                    String type = "dysentery";
                    newHealth = EffectClass.Sickness(name, type, health);
                    SicknessNotification = EffectClass.SicknessResult(name, type, health);
                    healthnoti(name, SicknessNotification, type);
                    return newHealth;
                }
                else if (num == 1) {
                    String type = "measles";
                    newHealth = EffectClass.Sickness(name, type, health);
                    SicknessNotification = EffectClass.SicknessResult(name, type, health);
                    healthnoti(name, SicknessNotification, type);
                    return newHealth;
                }
            }
            else { return health; }
        }
        return health;
    }

    public void healthnoti(String name, String healthNotification, String type) {
        notification.add(name + healthNotification + type + ".");
    }

    //A classic to string
    @Override
    public String toString() {
        return "RelearningJavaEt{" +
                "Locations=" + locations +
                ", playerdistance=" + playerdistance +
                ", daynumber=" + daynumber +
                '}';
    }

    //Funtion to take date current day count and return a formatted string
    public String toDate() {
            int numdate= this.daynumber;
            LocalDate date = LocalDate.of(1850, 3, 1).plusDays(numdate);
            String formattedDate = date.format(DateTimeFormatter.ofPattern("MMMM d")); // format as "MonthName day"
            return  formattedDate;
    }

    //Functing to display the date
    public void datedisplay(){
        String date = "Day "+(daynumber-startnumber)+", "+toDate()+":";
        for (int i = 0; i <date.length() ; i++) {
            out.print(date.charAt(i));
            wait(100);
        }
        out.print("\n");
    }

    //A terrible funtion to wait
    static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
