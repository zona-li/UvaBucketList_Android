package edu.virginia.hl3fm.uvabucketlist;

import android.content.Intent;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    private EditText mName;
    private  EditText mDescription;
    private  EditText mLatitude;
    private EditText mLongitude;
    private CalendarView mCal;
    private String dateFromCalendar;
    private Button mSaveButton;
    private ListItems newListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        // Get view and button instance from the activity
        mName = (EditText) findViewById(R.id.editTextName);
        mDescription = (EditText) findViewById(R.id.editTextDescription);
        mLatitude = (EditText) findViewById(R.id.editTextLatitude);
        mLongitude = (EditText) findViewById(R.id.editTextLongitude);
        mCal = (CalendarView) findViewById(R.id.calendar);
        mSaveButton = (Button) findViewById(R.id.button);

        // Get the date from the calendar and convert it into String
        mCal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dateFromCalendar = String.valueOf(month) + String.valueOf(dayOfMonth) + String.valueOf(year);
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), BucketListActivity.class);
//                newListItem = new ListItems(false, dateFromCalendar, mName.getText().toString());
//                i.putExtra("txtData", (Parcelable) newListItem);
                startActivity(new Intent(getBaseContext(), BucketListActivity.class));
            }
        });
    }


}
