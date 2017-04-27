package sg.edu.rp.c347.p02_holiday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvSType;
    ArrayAdapter ha;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) this.findViewById(R.id.lvHols);
        tvSType = (TextView) findViewById(R.id.tvSType);

        Intent i = getIntent();
        String type = i.getStringExtra("types");
        tvSType.setText(type);

        holiday = new ArrayList<>();

        if(type.equals("Secular")) {
            holiday.add(new Holiday("New Year's Day", "1 Jan 2017"));
            holiday.add(new Holiday("Labour Day", "1 May 2017"));
        }
        else if(type.equals("Ethnic & Relision")){
            holiday.add(new Holiday("Chinese New Year", "28-29 Jan 2017"));
            holiday.add(new Holiday("Good Friday", "14 April 2017"));
        }

        ha = new HolidayAdaptor(this, R.layout.row, holiday);
        lv.setAdapter(ha);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                + " is on " + selectedHoliday.getDate(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
