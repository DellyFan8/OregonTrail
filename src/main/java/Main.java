import java.util.*;

import static java.lang.System.out;

public class Main {

    static Inventory inventory;
    static ArrayList<Person> party;
    static Scanner keyboard;
    static Map oregonTrail;

//Needs:
    //River crossings
    //Career select

    public static void main(String[] args) {

        party = new ArrayList<Person>();

        //region Naming declaration
        if(intinput("1.) Story mode\n2.) Freeplay",2)==2) {
            Random random = new Random();
            List<String> name = Arrays.asList("John", "William", "James", "George", "Charles", "Joseph", "Robert", "Henry", "Edward", "Thomas", "Samuel", "David", "Frank", "Benjamin", "Andrew", "Peter", "Daniel", "Isaac", "Michael", "Abraham", "Mary", "Elizabeth", "Sarah", "Margaret", "Susan", "Ann", "Jane", "Emily", "Emma", "Catherine", "Caroline", "Martha", "Harriet", "Ellen", "Julia", "Alice", "Rebecca", "Hannah", "Louisa", "Frances");
            out.println("Your Party names: ");

            //Declaring Father Figure
            int namepos = random.nextInt(20);
            String names = name.get(namepos);
            out.println(names);
            int age = random.nextInt(25) + 15;
            party.add(new Person(age, names, 40, Person.Gender.MALE));

            //Declaring Mother
            namepos = random.nextInt(20) + 20;
            names = name.get(namepos);
            out.println(names);
            age = random.nextInt(25) + 15;
            party.add(new Person(age, names, 40, Person.Gender.FEMALE));

            //Children generation
            for (int i = 0; i <= 2; i++) {
                namepos = random.nextInt(name.size());
                names = name.get(namepos);
                out.println(names);
                age = random.nextInt(18);//technically can have kids older than mom and dad...
                if (namepos <= 20) {
                    party.add(new Person(age, names, 40, Person.Gender.MALE));
                } else {
                    party.add(new Person(age, names, 40, Person.Gender.FEMALE));
                }
            }
            boolean cool = keyboardyn("Is this okay? (y/n)");
            if (!cool) {
                out.println("This is MVP, I truly do not care.");
            }

//endregion

            //region Career choices

            //Man Career
            int input = intinput(party.get(0).getName() + "'s Career?\n1.) Banker\n2.) Carpenter\n3.) Farmer", 3);
            int startcash = (input == 1) ? 800 : (input == 2) ? 400 : (input == 3) ? 200 : (input == 4) ? 0 : 1600;        //you happy aaron


            //Women's Career?
            //if we do this the above numbers should be adjusted.

            input = intinput(party.get(1).getName() + "'s Career?\n1.) Apothecary\n2.) Blacksmiths\n3.) Tavern Keeper\n4.) Housewife", 4);
            startcash += (input == 1) ? 800 : (input == 2) ? 400 : (input == 3) ? 200 : (input == 4) ? 0 : 800;

            //generating
            inventory = new Inventory(startcash,party);

//endregion
        }
        else{
            Random random = new Random();
            out.println("Your Party names: ");

            //Declaring Father Figure
            String names = "Charles";
            out.println(names);
            int age = random.nextInt(25) + 15;
            party.add(new Person(age, names, 40, Person.Gender.MALE));

            //Declaring Mother
            names = "Augusta";
            out.println(names);
            age = random.nextInt(25) + 15;
            party.add(new Person(age, names, 40, Person.Gender.FEMALE));

            //declaring Hattie
            names = "Hattie";
            out.println(names);
            age = 13;
            party.add(new Person(age, names, 40, Person.Gender.FEMALE));

            //Oh brother.
            names = "Ben";
            out.println(names);
            age = random.nextInt(10)+1;
            party.add(new Person(age, names, 40, Person.Gender.MALE));

            //Oh bother2.
            names = "Jake";
            out.println(names);
            age = random.nextInt(10)+1;
            party.add(new Person(age, names, 40, Person.Gender.MALE));
            inventory = new Inventory(865,party);


        }
        //region Date to leave
        out.println("What month do you wish to leave?");
        int input = intinput("1.) March\n2.) April\n3.) May\n4.) June\n5.) July",5);
        int day=0;

        //Calculating what day to set calendar to
        switch (input){
            case 5:
                day+=30;
            case 4:
                day += 31;
            case 3:
                day+=30;
            case 2:
                day+= 31;
            case 1:
                day+=0;
                break;
        }
        //endregion

        //region Location Declaration

        //Declare location runner
        ArrayList<Location> runnerLocations = new ArrayList<Location>();

        //Independence information
        runnerLocations.add(new Location(0,"Independence",new Store("Independence Wholesale", inventory), 1));

        //KR crossing information
        Event krCrossing = new Event(Event.EventType.RIVERCROSSING);
        runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));

        //BBR crossing information
        Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING);
        runnerLocations.add(new Location(184,"Big Blue River Crossing",bbrCrossing));

        //Fort Kearny information
        runnerLocations.add(new Location(319,"Fort Kearny",new Store("Koo Koo Kearney's", inventory), 1.25));

        //Ash Hallow information
        Event ashHallow = new Event(Event.EventType.ENDOFPROTYPE);
        runnerLocations.add(new Location(504,"Ash Hallow", ashHallow));
        //endregion

        //Declare Oregon Trail Map
        oregonTrail = new Map(runnerLocations, inventory, day);

        //region Shopping!
        out.println("You need to go shopping before you can depart.");

        if(oregonTrail.closestloc().hasStore()){
            oregonTrail.closestloc().goShopping();
        }


        oregonTrail.addnoti("Today we left "+oregonTrail.closestloc().getLocationName()+".");
        oregonTrail.addnoti("We bought X items while there.");
        oregonTrail.dayDisplay(20);
        //endregion

        // Play game
        playGame();
    }

    public static void playGame(){
        //declaring stuff
        Scanner keyboard = new Scanner(System.in);
        boolean keepGoing = true;


        while(keepGoing){
            //Order of days events:
            //display date
                //check
            //What to do?
                //check
            //Travel distance(20miles or to next location)
                //check
            //check for events or store
                //check for rivers, unsure on stores
            //check for sickness
            //play events or town
                //see above
            //Display what has happened over the day
                //check



            int townOption = -1;
            int advanceOption = -1;
            int distancetraversed = 0;

            oregonTrail.datedisplay();

            //region Menu
            boolean menu = true;
            while(menu==true){
                out.println("1.) View Party\n2.) View Inventory");
                int optionNum = 3;
                if (oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance()) == 0 && oregonTrail.closestloc().hasStore()) {
                    out.println(optionNum + ".) Go into town");
                    townOption = optionNum;
                    optionNum++;

                }
                out.println(optionNum + ".) Continue down the trail");
                advanceOption = optionNum;
                out.print("What would you like to do?  ");

                int option = keyboard.nextInt();

                if (option == 1)
                    out.println(party.toString());

                else if (option < 1 || option > optionNum)
                    out.println("Please select something that is an option");

                else if (option == 2)
                    out.println(inventory.toString());

                else if (option == townOption && townOption != -1)
                    oregonTrail.closestloc().goIntoLocation();




                else if (option == advanceOption) {
                    menu = false;
                    distancetraversed= oregonTrail.advanceDay();
                    out.print("Traveling the trail");
                    wait(750);
                    out.print(".");
                    wait(750);
                    out.print(".");
                    wait(750);
                    out.println(".");

                } else {
                    out.println("Please select something that is an option");
                }
                    if (oregonTrail.closestloc().hasEvent()) {
                        if (oregonTrail.closestloc().getEvent().getEventType() == Event.EventType.RIVERCROSSING && oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance()) == 0) {
                            if (riverEvent(oregonTrail.closestloc())) {
                            } else {
                            }
                        }
                    }

                //Person sickness handling
                for (int i = 0; i < inventory.personcount(); i++) {
                    inventory.getIndividual(i).setHealth(oregonTrail.RandomSickness(inventory.getIndividual(i).getName(), inventory.getIndividual(i).getHealth()));

                }

            }
            oregonTrail.dayDisplay(distancetraversed);

            //endregion

        }
    }

    //takes in an string for a yes no reponse and returns bool
    static boolean keyboardyn(String output){

        out.println(output);

        //Declare things
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();

        if (answer.toUpperCase().charAt(0)=='Y' ||answer.equalsIgnoreCase("sure")) {return true;}
        else if (answer.charAt(0)=='n' || answer.charAt(0)=='N') {return false;}
        return false;
    }

    //Takes in string and outputs it repeatedly until an answer is sucessfully given.
    static int intinput(String output, int upperbound){

        Scanner keyboard = new Scanner(System.in);
        int answer;
        do {
            out.println(output);
            answer = keyboard.nextInt();
        }while (!(answer <=upperbound));
        return answer;

    }


    //deals with river crossings when called
    static boolean riverEvent(Location eventLocation){
        //insert chances and effects for crossing river, may need to be passed inventory

        Random rand = new Random();

        out.println("You find yourself at "+eventLocation.getLocationName()+".");
        if(keyboardyn("Do you want to cross the River?")) {
            //Random River nonsense
            switch (rand.nextInt(5)) {
                case 1:
                    out.println("you lost some items: Insert items lost here");
                    oregonTrail.addnoti("We crossed "+eventLocation.getLocationName().substring(0, eventLocation.getLocationName().length() - 9)+" Today, but lost *insert items here*");
                    break;
                case 2:
                    out.println("You should've died. but we haven't implemented death yet");
                    oregonTrail.addnoti("We crossed "+eventLocation.getLocationName().substring(0, eventLocation.getLocationName().length() - 9)+" Today."+" And should have died");
                    break;
                default:
                    out.println("you successfully crossed the " + eventLocation.getLocationName().substring(0, eventLocation.getLocationName().length() - 9) + ".");
                    oregonTrail.addnoti("We crossed "+eventLocation.getLocationName().substring(0, eventLocation.getLocationName().length() - 9)+" Today.");
                    break;
            }
            return true;
        }
        else{
            return false;
            }
        }

        //another terrible wait
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

