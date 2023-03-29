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
        out.println("Hello World!");
        List<String> name = Arrays.asList("John", "William", "James", "George", "Charles", "Joseph", "Robert", "Henry", "Edward", "Thomas", "Samuel", "David", "Frank", "Benjamin", "Andrew", "Peter", "Daniel", "Isaac", "Michael", "Abraham", "Mary", "Elizabeth", "Sarah", "Margaret", "Susan", "Ann", "Jane", "Emily", "Emma", "Catherine", "Caroline", "Martha", "Harriet", "Ellen", "Julia", "Alice", "Rebecca", "Hannah", "Louisa", "Frances");
        Random random = new Random();
        party = new ArrayList<Person>();
        out.println("Your Party names: ");
        int namepos = random.nextInt(20);
        String names = name.get(namepos);
        out.println(names);
        int age = random.nextInt(25)+10;
        party.add(new Person(age,names,40, Person.Gender.MALE ));
        namepos = random.nextInt(20)+20;
        names = name.get(namepos);
        out.println(names);
        age = random.nextInt(25)+10;
        party.add(new Person(age,names,40, Person.Gender.FEMALE ));
        for (int i = 0; i < 3; i++) {
            namepos = random.nextInt(name.size());
            names = name.get(namepos);
            out.println(names);
            age = random.nextInt(20);
            if (namepos<=20) {
                party.add(new Person(age,names,40, Person.Gender.MALE ));
            }
              else {
                party.add(new Person(age,names,40, Person.Gender.FEMALE ));
            }
        }
        boolean cool = keyboardyn("Is this okay? (y/n)");
        if(!cool){out.println("This is MVP, I truly do not care.");}

        int input =intinput(party.get(0).getName()+"'s Career?\n1.) Banker\n2.) Carpenter\n3.) Farmer",3);
        //you happy aaron
        int startcash = (input == 1)? 1600:(input==2)? 800:(input==3)?400:1600;
        //women's career?
        inventory = new Inventory(startcash);
        out.println("What month do you wish to leave?");
        input = intinput("1.) March\n2.) April\n3.) May\n4.) June\n5.) July",5);
        int day=0;
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

        ArrayList<Location> runnerLocations = new ArrayList<Location>();
        runnerLocations.add(new Location(0,"Independence",new Store("Independence Wholesale", inventory), 1));
        //Declare information about KR crossing.
        Event krCrossing = new Event(Event.EventType.RIVERCROSSING);
        runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));
        //Declare information about BBR crossing.
        Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING);
        runnerLocations.add(new Location(184,"Big Blue River Crossing",bbrCrossing));

        runnerLocations.add(new Location(319,"Fort Kearny",new Store("Koo Koo Kearney's", inventory), 1.25));//Koo's Store does not ever get called
        //Declare information about AshHallow, Event class will probably need updating.
        Event ashHallow = new Event(Event.EventType.ENDOFPROTYPE);
        runnerLocations.add(new Location(504,"Ash Hallow", ashHallow));


        oregonTrail = new Map(runnerLocations,day);






        out.println("You need to go shopping before you can depart.");
        if(oregonTrail.closestloc().hasStore()){
            oregonTrail.closestloc().goShopping();
        }
        out.println("You leave leaving " + oregonTrail.closestloc().getLocationName() + " on " + oregonTrail.toDate());
        playGame();

    }

    public static void playGame(){
        Scanner keyboard = new Scanner(System.in);
        boolean keepGoing = true;
        while(keepGoing){
            int townOption = -1;
            int advanceOption = -1;
            out.println("Traveling the trail...");
            oregonTrail.advanceDay();
            boolean menu = true;
            while(menu==true){
                out.println("1.) View Party\n2.) View Inventory");
                int optionNum = 3;
                if(oregonTrail.closestloc().distanceto(oregonTrail.getPlayerdistance())==0){
                    out.println(optionNum+".) Go into town");
                    townOption = optionNum;
                    optionNum++;
                }
                out.println(optionNum+".) Continue down the trail");
                advanceOption = optionNum;
                out.println("\n\nWhat would you like to do?");
                int option = keyboard.nextInt();
                if(option==1)
                    out.println(party.toString());
                else if(option < 1 || option > optionNum)
                    out.println("Please select something that is an option");
                else if(option == 2)
                    out.println(inventory.toString());
                else if(option == townOption&&townOption!=-1)
                    oregonTrail.closestloc().goIntoLocation();
                else if(option == advanceOption){
                    menu = false;
                }
                else{
                    out.println("Please select something that is an option");
                }
            }

        }
    }


    static boolean keyboardyn(String output){
        out.println(output);
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        if (answer.charAt(0)=='y' || answer.charAt(0)=='Y' || answer.equalsIgnoreCase("sure")) {return true;}
        else if (answer.charAt(0)=='n' || answer.charAt(0)=='N') {return false;}
        return false;
    }
    static int intinput(String output, int upperbound){
        Scanner keyboard = new Scanner(System.in);
        int answer;
        do {
            out.println(output);
            answer = keyboard.nextInt();
        }while (!(answer <=upperbound));
        return answer;

    }

}
