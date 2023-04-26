import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class WeatherRegion {
    private ArrayList<Weather> weather;
    private int startmilage;
    private int endmilage;


    public WeatherRegion(File fileloc) {
        Scanner scan = null;
        ArrayList<Weather> weatherrunners = new ArrayList<Weather>();
        try {
            scan = new Scanner(fileloc);
            int i = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                if (i == 0) {
                    this.startmilage = Integer.parseInt(lineArray[1]);
                    this.endmilage = Integer.parseInt(lineArray[3]);
                } else {

                    String tempaverage = lineArray[1];
                    String tempmax = lineArray[2];
                    String tempmin = lineArray[3];
                    String tempmedian = lineArray[4];
                    String rainaverage = lineArray[5];
                    String rainmax = lineArray[6];
                    String rainmedian = lineArray[7];
                    String rainzero = lineArray[8];

                    Weather weatherrunner = new Weather(rainaverage, rainmax, rainmedian, rainzero, tempaverage, tempmax, tempmin, tempmedian);
                    weatherrunners.add(weatherrunner);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }

        this.weather = weatherrunners;
    }
    boolean inregion(int milage){
        if (milage>startmilage&& milage<=endmilage)
            return true;
        return false;

    }
    double setrain(int day){
        int week = day/7;
        return weather.get(week).getrain();
    }
    int settemp(int day){
        int week = day/7;
        return weather.get(week).gettemp();
    }
    @Override
    public String toString() {
        return "WeatherRegion{" +
                "weather=" + weather +
                ", startmilage=" + startmilage +
                ", endmilage=" + endmilage +
                '}';
    }
}
