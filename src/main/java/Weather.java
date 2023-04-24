import java.util.Random;

public class Weather {

    //could possibly use float
    private double rainaverage;
    private double rainmax;
    private double rainmedian;
    private int rainzero;

    private double tempaverage;
    private double tempmax;
    private double tempmin;
    private double tempmedian;

    public Weather(double rainaverage, double rainmax, double rainmedian, int rainzero) {
        this.rainaverage = rainaverage;
        this.rainmax = rainmax;
        this.rainmedian = rainmedian;
        this.rainzero = rainzero;
    }

    public double getrain(){
        Random rand= new Random();
        if (rand.nextInt(0,70)>this.rainzero){
            return rand.nextDouble(0,this.rainmax);
        }
        return 0;
    }
    public double gettemp(){
        Random rand = new Random();
        return rand.nextDouble(tempmin,tempmax);


    }
}
