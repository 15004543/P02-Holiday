package sg.edu.rp.c347.p02_holiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15004543 on 27/4/2017.
 */

public class HolidayAdaptor extends ArrayAdapter<Holiday>{
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoliday, tvDate;
    private ImageView ivHols;

    public HolidayAdaptor(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHols = (ImageView) rowView.findViewById(R.id.ivHoliday);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food

        tvHoliday.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if(currentHoliday.getName().equals("New Year's Day")) {
            ivHols.setImageResource(R.drawable.newyear);
        }
        else if(currentHoliday.getName().equals("Labour Day")) {
            ivHols.setImageResource(R.drawable.labourday);
        }
        else if(currentHoliday.getName().equals("Chinese New Year")) {
            ivHols.setImageResource(R.drawable.cny);
        }
        else if(currentHoliday.getName().equals("Good Friday")) {
            ivHols.setImageResource(R.drawable.goodfriday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
