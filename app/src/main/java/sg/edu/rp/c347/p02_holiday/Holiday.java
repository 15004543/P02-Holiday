package sg.edu.rp.c347.p02_holiday;

/**
 * Created by 15004543 on 27/4/2017.
 */

public class Holiday {
    private String name, date;

    public Holiday(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
