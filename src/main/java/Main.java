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
    //Sicknesses
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
        runnerLocations.add(new Location(0,"Independence",new Store("Independence Wholesale", inventory,0), 1));

        //KR crossing information
        Event krCrossing = new Event(Event.EventType.RIVERCROSSING,1450.848,true);
        runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));

        //BBR crossing information
        Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING,2072.64,false);
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
        Event split1=new Event(Event.EventType.SPLIT1);
        runnerLocations.add(new Location(914,"South Pass",split1));





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
            boolean dayhunted= false;
            while(menu){
                out.println("1.) View Party\n2.) View Inventory\n3.) Change Pace and Rations\n4.) Go Hunting");
                int optionNum = 5;
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
                    oregonTrail.setRations(intinput("Current Rations: "+oregonTrail.getRations()+"\nSet rations (1 to 5, 1 being low rations):", 5, 1));
                    oregonTrail.setPace(intinput("Current Pace: "+oregonTrail.getPace()+"\nSet pace (1 to 5, 1 being low Pace):", 5, 1));

                } else if (option==4) {
                    if(!dayhunted)
                        oregonTrail.hunt();
                    else
                        out.println("You cannot hunt again today.");
                    dayhunted=true;

                } else if (option < 1 || option > optionNum)
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
                    if (oregonTrail.closestloc().hasEvent()&&oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance())==0) {
                        if (oregonTrail.closestloc().getEvent().getEventType() == Event.EventType.RIVERCROSSING && oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance()) == 0) {
                            if (riverEvent(oregonTrail.closestloc())) {
                                oregonTrail.incdist();
                            } else {
                            }
                        } else if ((oregonTrail.closestloc().getEvent().getEventType()== Event.EventType.SPLIT1||oregonTrail.closestloc().getEvent().getEventType()== Event.EventType.SPLIT2) &&oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance())==0) {
                            splitHandeler(oregonTrail.closestloc());
                        } else if (oregonTrail.closestloc().getEvent().getEventType()== Event.EventType.END) {
                            oregonTrail.endGame();

                        }
                    }

                //Person sickness handling
                
                // Check for random event
                oregonTrail.RandomEvent();

            }
            oregonTrail.dayDisplay(distancetraversed);

            //endregion

        }
    }

    //takes in a string for a yes no reponse and returns bool
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
    static int intinput(String output, int upperbound, int lowebound){

        Scanner keyboard = new Scanner(System.in);
        int answer;
        do {
            out.println(output);
            answer = keyboard.nextInt();
        }while (!(answer>=lowebound&&answer<=upperbound));
        return answer;

    }


    //deals with river crossings when called
    static boolean riverEvent(Location eventLocation ){
        //insert chances and effects for crossing river, may need to be passed inventory

        Random rand = new Random();


        //River name included crossing, should eventually fix
        String rivername = eventLocation.getLocationName().substring(0,eventLocation.getLocationName().length()-9);
        out.println("You find yourself at "+rivername+".");
        out.println(returnriver(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())));

        //For those whomst did not write this terrible function the following is an attempt to explain a bit of what is happening
        //I would encourage folding the regions and NEVER LOOKING AT IT, just look at this explanation!
        //I am very much aware that based on the fact that I feel the need to do this that this is a lot.
        //But I don't know how much better I could do it. Thankfully all you need to do is call this function, and it
        // should deal with itself! Also doesn't deal with having guides, but sh.
            /*
            Declaration of Variables

            Do {                            Causes this to loop until the river has actually been crossed

                Output and reading to take at river of action to take at river.

                Switch{                     Switch statement over the input provided
                    Case 1:                 This Case contains odds for fording the river based on river height
                        if(){               This if and 3 subsequent else-if's determine what odds to take
                        Switch():           Switch on a random number generator
                            Case 1:
                                Adds a random wagon part to the list of items to break

                                lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                break;
                            Case 2:         For those whom don't know when a case number is defined, It will fall
                            Case 3:         to the next case and until it hits a break statement.
                            Case 4:         This was used to easily shift the odds of different things happening.
                                Adds a random amount of rations or bullets to the list of items to lose

                                lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+30),false));
                                break;
                            Default{}       Default case, often is the most common event to happen

                            for(){}         Removes each item on the list from your inventory. Does not handle going
                                            into the negatives. Also formats and adds the removal notification.

                        }
                    Case 2:                 This Case contains odds for floating across the river based on height
                        The same logic as in the previous Case is mirrored here.
                    Case 3:                 This Case contains the logic for waiting by the river
                    Case 4:                 This Case contains the logic for crossing the river via Ferry

                }
            }While;
             */

        //region River Chaos
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
                //region Fording river
                case 1:
                    if (keyboardyn("Are you sure you would like to ford the river?")){
                        //Chance of death??
                        ArrayList<Item> lostbroken=new ArrayList<>();


                        //river height odds table
                        if(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12<3){
                            switch (rand.nextInt(7)) {
                                case 1:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                default:
                                    oregonTrail.addnoti("You successfully forded the river");

                            }
                            crossed=true;
                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>5) {
                            switch ((rand.nextInt(10))){
                                case 1:
                                case 2:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                                case 3:
                                case 4:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                case 5:
                                case 6:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+30),false));
                                    break;
                                case 7:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                                default:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                            }
                            crossed=true;

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>4) {
                            switch (rand.nextInt(10)){
                                //One other design option for these loops is to just create an array list of lost items and output those at the end.
                                case 1:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+30),false));
                                    break;
                                case 5:
                                case 6:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                                case 7:
                                    oregonTrail.addnoti("You successfully forded the "+rivername+" without losing any items");
                                    break;
                                default:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                            }
                            crossed=true;

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>=3) {
                            switch (rand.nextInt(10)){
                                case 1:
                                case 2:
                                case 3:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                case 4:
                                case 5:
                                case 6:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                                case 7:
                                case 8:
                                    oregonTrail.addnoti("You successfully forded the "+rivername+" without losing any items");
                                    break;
                                default:
                                    //at some point make this all into one display
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                            }
                            crossed=true;
                        }
                        String lbOut=("You successfully forded the "+rivername);
                        if (lostbroken != null) {
                            lbOut=lbOut+" but lost";
                            for (Item item :lostbroken) {
                                lbOut=lbOut+" "+item.getQuantity()+" "+item.getName();
                                oregonTrail.getPlayerinventory().removeItems(item);
                            }
                            lbOut=lbOut+".";
                        }
                        else {
                            lbOut= lbOut+" without losing any items.";
                        }
                        oregonTrail.addnoti(lbOut);


                    }
                    else {
                        break;
                    }

                    break;


                    //endregion
                //region Caulking river

                case 2:
                    if (keyboardyn("Are you sure you would like to Caulk your boat and float across")){
                                ArrayList<Item> lostbroken=new ArrayList<>();
                        //river height odds table
                        if(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12<5) {
                            switch (rand.nextInt(7)) {
                                case 1:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                default:
                                    oregonTrail.addnoti("You successfully crossed the river");
                                    break;

                            }
                            crossed = true;
                        }else if(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>9){
                            oregonTrail.endGame();

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>7) {
                            switch ((rand.nextInt(10))){
                                case 1:
                                case 4:
                                case 5:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                                case 2:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                case 3:
                                case 7:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+30),false));
                                    break;
                                case 6:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                                default:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                            }
                            crossed=true;

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>6) {
                            switch (rand.nextInt(10)){
                                //One other design option for these loops is to just create an array list of lost items and output those at the end.
                                case 1:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+30),false));
                                    break;
                                case 5:
                                case 6:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                                case 7:
                                    oregonTrail.addnoti("You successfully forded the "+rivername+" without losing any items");
                                    break;
                                default:
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                            }
                            crossed=true;

                        } else if (eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease())/12>=5) {
                            switch (rand.nextInt(10)){
                                case 1:
                                case 2:
                                case 3:
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    break;
                                case 4:
                                case 5:
                                case 6:
                                    lostbroken.add(new Food(Food.Type.RATIONS,"Rations",(rand.nextInt(50)+40),false));
                                    break;
                                case 7:
                                case 8:
                                    oregonTrail.addnoti("You successfully forded the "+rivername+" without losing any items");
                                    break;
                                default:
                                    //at some point make this all into one display
                                    lostbroken.add(oregonTrail.getPlayerinventory().brokenWagonpart());
                                    lostbroken.add(new OtherItem(OtherItem.Type.BULLETS, "Bullets",(rand.nextInt(20)+10),false));
                                    break;
                            }
                            crossed=true;
                        }
                        String lbOut=("You successfully floated across the "+rivername);
                        if (!lostbroken.isEmpty()) {
                            lbOut=lbOut+" but lost";
                            for (Item item :lostbroken) {
                                if (item!=null) {
                                    lbOut = lbOut + " " + item.getQuantity() + " " + item.getName();
                                    oregonTrail.getPlayerinventory().removeItems(item);
                                }
                            }
                            lbOut=lbOut+".";
                        }
                        else {
                            lbOut= lbOut+" without losing any items.";
                        }
                        oregonTrail.addnoti(lbOut);

                    }
                    else {
                        break;
                    }


                    out.println("You caulk your wagon and float across.");
                    break;

                    //endregion
                //region waiting by river
                case 3:
                    out.println("You wait a day by the river.");
                    oregonTrail.addnoti("You waited the day by the river to see if the conditions improve.");
                    oregonTrail.advanceDay(false);
                    returnriver(eventLocation.getEvent().riverheight(oregonTrail.getWaterTableincrease()));
                    crossed=false;
                    break;
                    //endregion
                //region Ferry
                case 4:
                    int cost = oregonTrail.getPlayerinventory().personcount()*10;
                    if (keyboardyn("The ferry costs "+cost+" gold.\nDo you wish to cross?")){
                        crossed=true;
                        oregonTrail.advanceDay(false);
                        oregonTrail.advanceDay(false);
                        oregonTrail.addnoti("Today you ferried across the "+rivername+", costing "+cost+" gold and lost 3 days of time.");
                        oregonTrail.advanceDay(false);
                        oregonTrail.getPlayerinventory().takeDollars(cost);
                    }
                    break;
                    //endregion

                }
            }while(crossed==false);
        //endregion


        return true;
        }
    static void splitHandeler(Location eventLocation){
        if (eventLocation.getEvent().getEventType()==Event.EventType.SPLIT1){
            ArrayList<Location> runnerLocations=new ArrayList<>();
            Event grCrossing = new Event(Event.EventType.RIVERCROSSING,5608.32 ,true);
            runnerLocations.add(new Location(989,"Green River crossing",grCrossing));
                switch (intinput("You come across a split in the road. From here you can either:\n 1.) Continue on the trail\n2.) Travel to Fort Bridger\n",2)) {
                    case 2:
                        //Fort Bridger
                        runnerLocations.add(new Location(1026,"Fort Bridger",new Store("Bridger's Store", inventory), 1.75));
                        break;
                    default:
                        break;
                }
            //soda springs
            runnerLocations.add(new Location(1133,"Soda Springs"));
            //fort hall
            runnerLocations.add(new Location(1190,"Fort Hall",new Store("Hall's Store", inventory), 2));
            //snake river
            Event snCrossing = new Event(Event.EventType.RIVERCROSSING,1800,false);
            runnerLocations.add(new Location(1372,"Snake river Crossing",snCrossing));
            //Fort boise
            runnerLocations.add(new Location(1486,"Fort Boise",new Store("Boise's Store", inventory),2.25));
            //Blue Mountain
            Event split2 = new Event(Event.EventType.SPLIT2);
            runnerLocations.add(new Location(1642, "Blue mountain",split2));
            for(Location loc:runnerLocations){
                oregonTrail.addloc(loc);

            }



        } else if (eventLocation.getEvent().getEventType()== Event.EventType.SPLIT2) {
            ArrayList<Location> runnerLocations=new ArrayList<>();
            Event end= new Event(Event.EventType.END);
            switch (intinput("You come across a split in the road. From here you can either:\n 1.) Continue on the trail\n2.) Travel to Fort Walla Walla\n",2)) {
                case 1:
                    //The dallas
                    runnerLocations.add(new Location(1820,"The Dallas"));
                    runnerLocations.add(new Location(2100,"The End",end));

                    break;

                case 2:
                    //Fort Bridger
                    runnerLocations.add(new Location(1743,"Fort Walla Walla",new Store("Wally's Store", inventory), 1.75));
                    //The dallas
                    runnerLocations.add(new Location(1923,"The Dallas"));
                    runnerLocations.add(new Location(2203,"The End",end));

                    break;
                default:
                    break;

            }
            for(Location loc:runnerLocations){
                oregonTrail.addloc(loc);

            }




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
    static String returnriver(double riverheight){
        String output= "The river is "+(int)(riverheight/12)+" feet ";
        if((int)(riverheight%12)!=0)
            output=output+ ((int)(riverheight%12)+" inches ");
        return (output+"deep.");
    }

    }


