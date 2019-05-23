package com.quantum.drinkwater;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.quantum.drinkwater.activity.BaseActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends BaseActivity {
    @BindView(R.id.weight_number)
    TextView mWeight;
    @BindView(R.id.wakeup_time)
            TextView mWakeupTime;
    int weightNewValue, weightOldValue;


    @OnClick(R.id.weight_number)
    void setWeight() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Your Weight");
        final NumberPicker numberPicker = new NumberPicker(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        numberPicker.setLayoutParams(lp);
        builder.setView(numberPicker);
        numberPicker.setMinValue(30);
        numberPicker.setMaxValue(200);
        numberPicker.setValue(weightNewValue);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                weightNewValue = newVal;
                weightOldValue = oldVal;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mWeight.setText(weightNewValue + " " + "Kg");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mWeight.setText(weightOldValue + " " + "Kg");
            }
        });
        builder.show();
    }


    @OnClick(R.id.wakeup_time)
    void setWakeUpTime(){

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker ;

        mTimePicker = new TimePickerDialog(DashboardActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                mWakeupTime.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Wake Up Time");
        mTimePicker.updateTime(8,0);
        mTimePicker.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setUpToolBar();
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_dashboard;
    }
}
