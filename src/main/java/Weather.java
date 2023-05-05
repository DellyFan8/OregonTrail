import java.util.Random;

import static java.lang.Math.abs;

public class Weather {
//Note: Rain data is in mm and temp is C.
    //could possibly use float
    private final double rainaverage;
    private final double rainmax;
    private final double rainmedian;
    private final int rainzero;

    private final double tempaverage;
    private final double tempmax;
    private final double tempmin;
    private final double tempmedian;
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
        Random rand= new Random();
        if (rand.nextInt(70)<rainzero){
            return 0;
        }
        else {
            String rain= rand.nextInt((int) abs(rainmax)+1) +"."+ rand.nextInt(10);
            return Double.parseDouble(rain);

        }

    }
    public int gettemp(){
        Random rand = new Random();
        return rand.nextInt((int) (tempmax-tempmin))+(int)tempmin;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "rainaverage=" + rainaverage +
                ", rainmax=" + rainmax +
                ", rainmedian=" + rainmedian +
                ", rainzero=" + rainzero +
                ", tempaverage=" + tempaverage +
                ", tempmax=" + tempmax +
                ", tempmin=" + tempmin +
                ", tempmedian=" + tempmedian +
                '}';
    }
}
