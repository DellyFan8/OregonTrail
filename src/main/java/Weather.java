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
    public Weather(String rainaverage, String rainmax, String rainmedian, String rainzero, String tempaverage, String tempmax, String tempmin, String tempmedian) {
        this.rainaverage = Double.parseDouble(rainaverage);
        this.rainmax = Double.parseDouble(rainmax);
        this.rainmedian = Double.parseDouble(rainmedian);
        this.rainzero = Integer.parseInt(rainzero);
        this.tempaverage = Double.parseDouble(tempaverage);
        this.tempmax = Double.parseDouble(tempmax);
        this.tempmin = Double.parseDouble(tempmin);
        this.tempmedian = Double.parseDouble(tempmedian);
    }

    public double getrain(){

        return 0;
    }
    public double gettemp(){
        return 0;


    }
}
