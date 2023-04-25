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
        return 0;
    }
    public double gettemp(){
        return 0;
    }
}
