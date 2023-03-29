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


        public Map(ArrayList<Location> locations, int day) {
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


        public void advanceDay() {
            int dist = dailyDistanceTraveled();
            int distanceToNextLocation = distanceto(closestloc());
            if(distanceToNextLocation<dist && distanceToNextLocation!= 0){
                playerdistance+=distanceToNextLocation;
                daynumber++;
                dayDisplay(distanceToNextLocation);
            }
            else {
                playerdistance += dist;
                daynumber++;
                dayDisplay(dist);
            }
        }
        public int dailyDistanceTraveled(){
            //for testing will be 20, however at some point will need to handle distance calulation
            //may need to be passed information
            return 20;
        }
    public void dayDisplay(int distanceTravelled){
    //display day related information every time a day advances
        // record names of places entered, rivers crossed etc


           out.println("Day "+(daynumber-startnumber)+", "+toDate()+":"); //plus one so we don't get "April 1st day 0:"
           out.println("Today you travelled "+ distanceTravelled+" miles.");

           if (distanceto()==0){out.println("You crossed the "+closestloc().getLocationName().substring(0,closestloc().getLocationName().length()-9)+".");}
           else out.println(distanceto()+" miles to "+closestloc().getLocationName()+".");

           out.println("Daily log of injuries, illnesses, events, etc. goes here");

    }
    public void RandomEvent() {
        Random rand = new Random();
        int randNum = (int) (Math.random() % 100);
        if (randNum >= 0 && randNum <= 1) { // lose trail(2.0%), call event class
        }
        else if (randNum >= 2 && randNum <= 3) { // thief comes during night(2.0%), call event class
        }
    }

    public int RandomSickness(String Enum, int health) {//name should be replaced with Enum
        int randSickness = (int) (Math.random() % 100);
        Effect EffectClass = new Effect();
        if (health != 40) {
            if (randSickness >= 0 && randSickness <= (40 - health)) {
                // one of the random sicknesses is given to this person
                int num = (int) (Math.random() % 2);
                int newHealth;
                if (num == 0) {
                    newHealth = EffectClass.Sickness(Enum, "dysentery", health);
                    return newHealth;
                } else if (num == 1) {
                    newHealth = EffectClass.Sickness(Enum, "measles", health);
                    return newHealth;
                }
            }
            else { return health; }
        }
        return health;
    }

    @Override
    public String toString() {
        return "RelearningJavaEt{" +
                "Locations=" + locations +
                ", playerdistance=" + playerdistance +
                ", daynumber=" + daynumber +
                '}';
    }

    public String toDate()
    {
            int numdate= this.daynumber;
            LocalDate date = LocalDate.of(1850, 3, 1).plusDays(numdate);
            String formattedDate = date.format(DateTimeFormatter.ofPattern("MMMM d")); // format as "MonthName day"
            return  formattedDate;
    }

}
