import org.apache.poi.ss.formula.atp.Switch;

import java.util.*;

import static java.lang.System.out;

public class Main {
//Every comment made out of rage should definitly be kept
    static Inventory inventory;
    static ArrayList<Person> party;
    static Scanner keyboard;
    static Map oregonTrail;

//Needs:
    //help
    public static void main(String[] args) {
        party = new ArrayList<Person>();

        //region Naming declaration
        if(intinput("1.) Story mode\n2.) Freeplay\n",2)==2) {
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
        int input = intinput("1.) March\n2.) April\n3.) May\n4.) June\n5.) July\n",5);
        int day = 0;

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
        Event krCrossing = new Event(Event.EventType.RIVERCROSSING,1450.848,true);
        runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));

        //BBR crossing information
        Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING);
        runnerLocations.add(new Location(184,"Big Blue River Crossing",bbrCrossing));

        //Fort Kearny information
        runnerLocations.add(new Location(319,"Fort Kearny",new Store("Koo Koo Kearney's", inventory), 1.25));

        //Ash Hallow information
        runnerLocations.add(new Location(504,"Ash Hallow"));

        //Chimney rock information
        runnerLocations.add(new Location(554,"Chimney Rock"));

        //Scotts Bluff
        runnerLocations.add(new Location(596,"Scotts Bluff"));

        //Registar Cliff
        runnerLocations.add(new Location(658,"Register Cliff"));

        //Fort Laramie
        runnerLocations.add(new Location(750,"Fort Laramie",new Store("Laramie's Store", inventory), 1.5));

        //Independence Rock
        runnerLocations.add(new Location(815,"Independence Rock"));

        //South Pass
        runnerLocations.add(new Location(914,"South Pass"));

        //Fort Bridger
        //runnerLocations.add(new Location(1026,"Fort Bridger",new Store("Bridger's Store", inventory), 1.75));

        //Green River crossing
        //runnerLocations.add(new Location(989,"Green River crossing"))



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
        //endregion

        // Play game
        oregonTrail.setRainandTemp();
        playGame();

    }

    public static void playGame(){
        oregonTrail.setRainandTemp();
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
                //check for sickness recovery
            // check for random events
                //check
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
            while(menu){
                out.println("1.) View Party\n2.) View Inventory\n3.) Change Pace and Rations");
                int optionNum = 4;
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
                else if (option==3) {
                    oregonTrail.setRations(intinput("Current Rations: "+oregonTrail.getRations()+"\nSet rations (1 to 5, 1 being low rations):",1,5));
                    oregonTrail.setPace(intinput("Current Pace: "+oregonTrail.getPace()+"\nSet pace (1 to 5, 1 being low Pace):",1,5));

                }
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
                            if (riverEvent(oregonTrail.closestloc(),oregonTrail)) {
                            } else {
                            }
                        }
                    }

                //Person sickness handling
                for (int i = 0; i < inventory.personcount(); i++) {
                    inventory.getIndividual(i).setHealth(oregonTrail.RandomSickness(inventory.getIndividual(i).getName(), inventory.getIndividual(i).getHealth()));
                }

                // Where the new sicknessRecovery method will be implemented (recovery every 5 days, could be changed later)
                if ((oregonTrail.getDayNumber() % 5) == 0) {
                    for (int i = 0; i < inventory.personcount(); i++) {
                        inventory.getIndividual(i).setHealth(oregonTrail.sicknessRecovery(inventory.getIndividual(i).getName(), inventory.getIndividual(i).getHealth()));
                    }
                }
                
                // Check for random event
                oregonTrail.RandomEvent();

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
            out.print(output);
            answer = keyboard.nextInt();
        }while (!(answer <=upperbound));
        return answer;

    }
    static int intinput(String output,int lowebound, int upperbound){

        Scanner keyboard = new Scanner(System.in);
        int answer;
        do {
            out.println(output);
            answer = keyboard.nextInt();
        }while (!(answer>=lowebound&&answer<=upperbound));
        return answer;

    }


    //deals with river crossings when called
    static boolean riverEvent(Location eventLocation, Map oregonTrail){
        //insert chances and effects for crossing river, may need to be passed inventory

        Random rand = new Random();
        String rivername = eventLocation.getLocationName();
        out.println("You find yourself at "+rivername+".");
        out.println(returnriver(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())));
        int input;
        boolean crossed;
        do {


            //region outputting river prompt based off of river type
            crossed=false;
            if(eventLocation.getEvent().isHasFerry()==true)
                input =intinput("How do you want to cross the river?\n1.) Attempt to ford the river\n2.) Caulk the wagon and float it across\n3.) Wait to see if conditions improve\n4.) Take ferry across\n",4);
            else
                input = intinput("How do you want to cross the river?\n1.) Attempt to ford the river\n2.) Caulk the wagon and float it across\n3.) Wait to see if conditions improve\n",3);
            //endregion
            //Switch based off of route of crossing river
            switch (input){
//Needs:
    //odds of loosing items upon crossing
                //region Fording river
                case 1:
                    if (keyboardyn("Are you sure you would like to ford the river?")){

                        //river height odds table
                        if(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12<3){

                            crossed=true;
                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>5) {

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>4) {

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>=3) {

                        }



                    }
                    else {
                        break;
                    }



                    crossed=true;
                    break;


                    //endregion
                //region Caulking river
                case 2:
                    if (keyboardyn("Are you sure you would like to Caulk your boat and float across")){

                        //river height odds table
                        if(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12<5){

                            crossed=true;
                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>9) {

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>7) {

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>=5) {

                        }

                    }
                    else {
                        break;
                    }


                    out.println("You caulk your wagon and float across.");
                    crossed=true;
                    break;

                    //endregion
                //region waiting by river
                case 3:
                    out.println("You wait a day by the river.");
                    oregonTrail.addnoti("You waited the day by the river to see if the conditions improve.");
                    oregonTrail.advanceDay();
                    returnriver(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease()));
                    crossed=false;
                    break;
                    //endregion
                //region Ferry
                case 4:
                    int cost = oregonTrail.getPlayerinventory().personcount()*10;
                    if (keyboardyn("The ferry costs "+cost+" gold.\nDo you wish to cross?")){
                        crossed=true;
                        oregonTrail.addnoti("You wait your turn for the ferry");
                        oregonTrail.advanceDay();
                        oregonTrail.addnoti("You wait your turn for the ferry");
                        oregonTrail.advanceDay();
                        oregonTrail.addnoti("Today you ferried across the "+rivername+"river, costing "+cost+" gold and lost 3 days of time.");
                        oregonTrail.advanceDay();
                        oregonTrail.getPlayerinventory().takeDollars(cost);
                    }
                    break;
                    //endregion

                }
            }while(crossed==false);


        return true;
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
    static String returnriver(double riverheight){
        String output= "The river is "+(int)(riverheight/12)+" feet ";
        if((int)(riverheight%12)!=0)
            output=output+ ((int)(riverheight%12)+" inches ");
        return (output+"deep.");
    }







    }


