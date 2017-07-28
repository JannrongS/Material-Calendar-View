package com.applandeo.materialcalendarsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnSelectDateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openCalendarButton = (Button) findViewById(R.id.openCalendarButton);

        openCalendarButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        });


        Button openDatePicker = (Button) findViewById(R.id.openDatePickerButton);

        openDatePicker.setOnClickListener(v -> {
            Intent intent = new Intent(this, DatePickerActivity.class);
            startActivity(intent);
        });

        Button openDatePickerDialog = (Button) findViewById(R.id.openDatePickerDialogButton);

        openDatePickerDialog.setOnClickListener(v -> {
            DatePicker.Builder builder = new DatePicker.Builder(this, this)
                    .setDate(getRandomCalendar())
                    .setHeaderColor(R.color.colorPrimaryDark)
                    .setHeaderLabelColor(R.color.currentMonthDayColor)
                    .setSelectionColor(R.color.daysLabelColor)
                    .setTodayLabelColor(R.color.colorAccent)
                    .setDialogButtonsColor(R.color.colorAccent)
                    .setCancelButtonLabel(R.string.cancel)
                    .setOkButtonLabel(R.string.ok)
                    .setPreviousButtonSrc(R.drawable.ic_chevron_left_black_24dp)
                    .setForwardButtonSrc(R.drawable.ic_chevron_right_black_24dp)
                    .setDaysNames(R.array.days_names_symbol_array)
                    .setMonthsNames(R.array.polish_months_array);

            DatePicker datePicker = builder.build();
            datePicker.show();
        });
    }

    @Override
    public void onSelect(Calendar calendar) {
        Toast.makeText(getApplicationContext(), calendar.getTime().toString(), Toast.LENGTH_LONG).show();
    }

    private Calendar getRandomCalendar() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, random.nextInt(99));

        return calendar;
    }
}
