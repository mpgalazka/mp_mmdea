package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class sf36 extends AppCompatActivity implements View.OnClickListener {

    Button bDone;
    String PatID, Date, joined;
    TextView currentDateTimeString, patientID;

    RadioButton csfq1a, csfq1b, csfq1c, csfq1d, csfq1e,
            csfq2a, csfq2b, csfq2c, csfq2d, csfq2e,
            csfq3a, csfq3b, csfq3c,
            csfq4a, csfq4b, csfq4c,
            csfq5a, csfq5b, csfq5c,
            csfq6a, csfq6b, csfq6c,
            csfq7a, csfq7b, csfq7c,
            csfq8a, csfq8b, csfq8c,
            csfq9a, csfq9b, csfq9c,
            csfq10a, csfq10b, csfq10c,
            csfq11a, csfq11b, csfq11c,
            csfq12a, csfq12b, csfq12c,
            csfq13a, csfq13b,
            csfq14a, csfq14b,
            csfq15a, csfq15b,
            csfq16a, csfq16b,
            csfq17a, csfq17b,
            csfq18a, csfq18b,
            csfq19a, csfq19b,
            csfq20a, csfq20b, csfq20c, csfq20d, csfq20e,
            csfq21a, csfq21b, csfq21c, csfq21d, csfq21e, csfq21f,
            csfq22a, csfq22b, csfq22c, csfq22d, csfq22e, csfq22f,
            csfq23a, csfq23b, csfq23c, csfq23d, csfq23e, csfq23f,
            csfq24a, csfq24b, csfq24c, csfq24d, csfq24e, csfq24f,
            csfq25a, csfq25b, csfq25c, csfq25d, csfq25e, csfq25f,
            csfq26a, csfq26b, csfq26c, csfq26d, csfq26e, csfq26f,
            csfq27a, csfq27b, csfq27c, csfq27d, csfq27e, csfq27f,
            csfq28a, csfq28b, csfq28c, csfq28d, csfq28e, csfq28f,
            csfq29a, csfq29b, csfq29c, csfq29d, csfq29e, csfq29f,
            csfq30a, csfq30b, csfq30c, csfq30d, csfq30e, csfq30f,
            csfq31a, csfq31b, csfq31c, csfq31d, csfq31e, csfq31f,
            csfq32a, csfq32b, csfq32c, csfq32d, csfq32e,
            csfq33a, csfq33b, csfq33c, csfq33d, csfq33e,
            csfq34a, csfq34b, csfq34c, csfq34d, csfq34e,
            csfq35a, csfq35b, csfq35c, csfq35d, csfq35e,
            csfq36a, csfq36b, csfq36c, csfq36d, csfq36e;

    Double  sfq1,
            sfq2,
            sfq3,
            sfq4,
            sfq5,
            sfq6,
            sfq7,
            sfq8,
            sfq9,
            sfq10,
            sfq11,
            sfq12,
            sfq13,
            sfq14,
            sfq15,
            sfq16,
            sfq17,
            sfq18,
            sfq19,
            sfq20,
            sfq21,
            sfq22,
            sfq23,
            sfq24,
            sfq25,
            sfq26,
            sfq27,
            sfq28,
            sfq29,
            sfq30,
            sfq31,
            sfq32,
            sfq33,
            sfq34,
            sfq35,
            sfq36,
            physicalfunction, limitation_due_to_physical_health,limitation_due_to_emotional_problem,
            energy_fatigue,emotional_wellbeing, social_functioning, pain, generalhealth;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sf36);

        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Index Date: " + Date);

        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);


        csfq1a = (RadioButton) findViewById(R.id.csfq1a);
        csfq1b = (RadioButton) findViewById(R.id.csfq1b);
        csfq1c = (RadioButton) findViewById(R.id.csfq1c);
        csfq1d = (RadioButton) findViewById(R.id.csfq1d);
        csfq1e = (RadioButton) findViewById(R.id.csfq1e);

        csfq2a = (RadioButton) findViewById(R.id.csfq2a);
        csfq2b = (RadioButton) findViewById(R.id.csfq2b);
        csfq2c = (RadioButton) findViewById(R.id.csfq2c);
        csfq2d = (RadioButton) findViewById(R.id.csfq2d);
        csfq2e = (RadioButton) findViewById(R.id.csfq2e);

        csfq3a = (RadioButton) findViewById(R.id.csfq3a);
        csfq3b = (RadioButton) findViewById(R.id.csfq3b);
        csfq3c = (RadioButton) findViewById(R.id.csfq3c);

        csfq4a = (RadioButton) findViewById(R.id.csfq4a);
        csfq4b = (RadioButton) findViewById(R.id.csfq4b);
        csfq4c = (RadioButton) findViewById(R.id.csfq4c);

        csfq5a = (RadioButton) findViewById(R.id.csfq5a);
        csfq5b = (RadioButton) findViewById(R.id.csfq5b);
        csfq5c = (RadioButton) findViewById(R.id.csfq5c);

        csfq6a = (RadioButton) findViewById(R.id.csfq6a);
        csfq6b = (RadioButton) findViewById(R.id.csfq6b);
        csfq6c = (RadioButton) findViewById(R.id.csfq6c);

        csfq7a = (RadioButton) findViewById(R.id.csfq7a);
        csfq7b = (RadioButton) findViewById(R.id.csfq7b);
        csfq7c = (RadioButton) findViewById(R.id.csfq7c);

        csfq8a = (RadioButton) findViewById(R.id.csfq8a);
        csfq8b = (RadioButton) findViewById(R.id.csfq8b);
        csfq8c = (RadioButton) findViewById(R.id.csfq8c);

        csfq9a = (RadioButton) findViewById(R.id.csfq9a);
        csfq9b = (RadioButton) findViewById(R.id.csfq9b);
        csfq9c = (RadioButton) findViewById(R.id.csfq9c);

        csfq10a = (RadioButton) findViewById(R.id.csfq10a);
        csfq10b = (RadioButton) findViewById(R.id.csfq10b);
        csfq10c = (RadioButton) findViewById(R.id.csfq10c);

        csfq11a = (RadioButton) findViewById(R.id.csfq11a);
        csfq11b = (RadioButton) findViewById(R.id.csfq11b);
        csfq11c = (RadioButton) findViewById(R.id.csfq11c);

        csfq12a = (RadioButton) findViewById(R.id.csfq12a);
        csfq12b = (RadioButton) findViewById(R.id.csfq12b);
        csfq12c = (RadioButton) findViewById(R.id.csfq12c);

        csfq13a = (RadioButton) findViewById(R.id.csfq13a);
        csfq13b = (RadioButton) findViewById(R.id.csfq13b);

        csfq14a = (RadioButton) findViewById(R.id.csfq14a);
        csfq14b = (RadioButton) findViewById(R.id.csfq14b);

        csfq15a = (RadioButton) findViewById(R.id.csfq15a);
        csfq15b = (RadioButton) findViewById(R.id.csfq15b);

        csfq16a = (RadioButton) findViewById(R.id.csfq16a);
        csfq16b = (RadioButton) findViewById(R.id.csfq16b);

        csfq17a = (RadioButton) findViewById(R.id.csfq17a);
        csfq17b = (RadioButton) findViewById(R.id.csfq17b);

        csfq18a = (RadioButton) findViewById(R.id.csfq18a);
        csfq18b = (RadioButton) findViewById(R.id.csfq18b);

        csfq19a = (RadioButton) findViewById(R.id.csfq19a);
        csfq19b = (RadioButton) findViewById(R.id.csfq19b);

        csfq20a = (RadioButton) findViewById(R.id.csfq20a);
        csfq20b = (RadioButton) findViewById(R.id.csfq20b);
        csfq20c = (RadioButton) findViewById(R.id.csfq20c);
        csfq20d = (RadioButton) findViewById(R.id.csfq20d);
        csfq20e = (RadioButton) findViewById(R.id.csfq20e);

        csfq21a = (RadioButton) findViewById(R.id.csfq21a);
        csfq21b = (RadioButton) findViewById(R.id.csfq21b);
        csfq21c = (RadioButton) findViewById(R.id.csfq21c);
        csfq21d = (RadioButton) findViewById(R.id.csfq21d);
        csfq21e = (RadioButton) findViewById(R.id.csfq21e);
        csfq21f = (RadioButton) findViewById(R.id.csfq21f);

        csfq22a = (RadioButton) findViewById(R.id.csfq22a);
        csfq22b = (RadioButton) findViewById(R.id.csfq22b);
        csfq22c = (RadioButton) findViewById(R.id.csfq22c);
        csfq22d = (RadioButton) findViewById(R.id.csfq22d);
        csfq22e = (RadioButton) findViewById(R.id.csfq22e);

        csfq23a = (RadioButton) findViewById(R.id.csfq23a);
        csfq23b = (RadioButton) findViewById(R.id.csfq23b);
        csfq23c = (RadioButton) findViewById(R.id.csfq23c);
        csfq23d = (RadioButton) findViewById(R.id.csfq23d);
        csfq23e = (RadioButton) findViewById(R.id.csfq23e);
        csfq23f = (RadioButton) findViewById(R.id.csfq23f);

        csfq24a = (RadioButton) findViewById(R.id.csfq24a);
        csfq24b = (RadioButton) findViewById(R.id.csfq24b);
        csfq24c = (RadioButton) findViewById(R.id.csfq24c);
        csfq24d = (RadioButton) findViewById(R.id.csfq24d);
        csfq24e = (RadioButton) findViewById(R.id.csfq24e);
        csfq24f = (RadioButton) findViewById(R.id.csfq24f);

        csfq25a = (RadioButton) findViewById(R.id.csfq25a);
        csfq25b = (RadioButton) findViewById(R.id.csfq25b);
        csfq25c = (RadioButton) findViewById(R.id.csfq25c);
        csfq25d = (RadioButton) findViewById(R.id.csfq25d);
        csfq25e = (RadioButton) findViewById(R.id.csfq25e);
        csfq25f = (RadioButton) findViewById(R.id.csfq25f);

        csfq26a = (RadioButton) findViewById(R.id.csfq26a);
        csfq26b = (RadioButton) findViewById(R.id.csfq26b);
        csfq26c = (RadioButton) findViewById(R.id.csfq26c);
        csfq26d = (RadioButton) findViewById(R.id.csfq26d);
        csfq26e = (RadioButton) findViewById(R.id.csfq26e);
        csfq26f = (RadioButton) findViewById(R.id.csfq26f);

        csfq27a = (RadioButton) findViewById(R.id.csfq27a);
        csfq27b = (RadioButton) findViewById(R.id.csfq27b);
        csfq27c = (RadioButton) findViewById(R.id.csfq27c);
        csfq27d = (RadioButton) findViewById(R.id.csfq27d);
        csfq27e = (RadioButton) findViewById(R.id.csfq27e);
        csfq27f = (RadioButton) findViewById(R.id.csfq27f);

        csfq28a = (RadioButton) findViewById(R.id.csfq28a);
        csfq28b = (RadioButton) findViewById(R.id.csfq28b);
        csfq28c = (RadioButton) findViewById(R.id.csfq28c);
        csfq28d = (RadioButton) findViewById(R.id.csfq28d);
        csfq28e = (RadioButton) findViewById(R.id.csfq28e);
        csfq28f = (RadioButton) findViewById(R.id.csfq28f);

        csfq29a = (RadioButton) findViewById(R.id.csfq29a);
        csfq29b = (RadioButton) findViewById(R.id.csfq29b);
        csfq29c = (RadioButton) findViewById(R.id.csfq29c);
        csfq29d = (RadioButton) findViewById(R.id.csfq29d);
        csfq29e = (RadioButton) findViewById(R.id.csfq29e);
        csfq29f = (RadioButton) findViewById(R.id.csfq29f);

        csfq30a = (RadioButton) findViewById(R.id.csfq30a);
        csfq30b = (RadioButton) findViewById(R.id.csfq30b);
        csfq30c = (RadioButton) findViewById(R.id.csfq30c);
        csfq30d = (RadioButton) findViewById(R.id.csfq30d);
        csfq30e = (RadioButton) findViewById(R.id.csfq30e);
        csfq30f = (RadioButton) findViewById(R.id.csfq30f);

        csfq31a = (RadioButton) findViewById(R.id.csfq31a);
        csfq31b = (RadioButton) findViewById(R.id.csfq31b);
        csfq31c = (RadioButton) findViewById(R.id.csfq31c);
        csfq31d = (RadioButton) findViewById(R.id.csfq31d);
        csfq31e = (RadioButton) findViewById(R.id.csfq31e);
        csfq31f = (RadioButton) findViewById(R.id.csfq31f);

        csfq32a = (RadioButton) findViewById(R.id.csfq32a);
        csfq32b = (RadioButton) findViewById(R.id.csfq32b);
        csfq32c = (RadioButton) findViewById(R.id.csfq32c);
        csfq32d = (RadioButton) findViewById(R.id.csfq32d);
        csfq32e = (RadioButton) findViewById(R.id.csfq32e);

        csfq33a = (RadioButton) findViewById(R.id.csfq33a);
        csfq33b = (RadioButton) findViewById(R.id.csfq33b);
        csfq33c = (RadioButton) findViewById(R.id.csfq33c);
        csfq33d = (RadioButton) findViewById(R.id.csfq33d);
        csfq33e = (RadioButton) findViewById(R.id.csfq33e);

        csfq34a = (RadioButton) findViewById(R.id.csfq34a);
        csfq34b = (RadioButton) findViewById(R.id.csfq34b);
        csfq34c = (RadioButton) findViewById(R.id.csfq34c);
        csfq34d = (RadioButton) findViewById(R.id.csfq34d);
        csfq34e = (RadioButton) findViewById(R.id.csfq34e);

        csfq35a = (RadioButton) findViewById(R.id.csfq35a);
        csfq35b = (RadioButton) findViewById(R.id.csfq35b);
        csfq35c = (RadioButton) findViewById(R.id.csfq35c);
        csfq35d = (RadioButton) findViewById(R.id.csfq35d);
        csfq35e = (RadioButton) findViewById(R.id.csfq35e);

        csfq36a = (RadioButton) findViewById(R.id.csfq36a);
        csfq36b = (RadioButton) findViewById(R.id.csfq36b);
        csfq36c = (RadioButton) findViewById(R.id.csfq36c);
        csfq36d = (RadioButton) findViewById(R.id.csfq36d);
        csfq36e = (RadioButton) findViewById(R.id.csfq36e);

        sfq1 = Double.parseDouble("0");
        sfq2 = Double.parseDouble("0");
        sfq3 = Double.parseDouble("0");
        sfq4 = Double.parseDouble("0");
        sfq5 = Double.parseDouble("0");
        sfq6 = Double.parseDouble("0");
        sfq7 = Double.parseDouble("0");
        sfq8 = Double.parseDouble("0");
        sfq9 = Double.parseDouble("0");
        sfq10 = Double.parseDouble("0");
        sfq11 = Double.parseDouble("0");
        sfq12 = Double.parseDouble("0");
        sfq13 = Double.parseDouble("0");
        sfq14 = Double.parseDouble("0");
        sfq15 = Double.parseDouble("0");
        sfq16 = Double.parseDouble("0");
        sfq17 = Double.parseDouble("0");
        sfq18 = Double.parseDouble("0");
        sfq19 = Double.parseDouble("0");
        sfq20 = Double.parseDouble("0");
        sfq21 = Double.parseDouble("0");
        sfq22 = Double.parseDouble("0");
        sfq23 = Double.parseDouble("0");
        sfq24 = Double.parseDouble("0");
        sfq25 = Double.parseDouble("0");
        sfq26 = Double.parseDouble("0");
        sfq27 = Double.parseDouble("0");
        sfq28 = Double.parseDouble("0");
        sfq29 = Double.parseDouble("0");
        sfq30 = Double.parseDouble("0");
        sfq31 = Double.parseDouble("0");
        sfq32 = Double.parseDouble("0");
        sfq33 = Double.parseDouble("0");
        sfq34 = Double.parseDouble("0");
        sfq35 = Double.parseDouble("0");
        sfq36 = Double.parseDouble("0");

        physicalfunction = Double.parseDouble("0");
        limitation_due_to_physical_health = Double.parseDouble("0");
        limitation_due_to_emotional_problem = Double.parseDouble("0");
        energy_fatigue = Double.parseDouble("0");
        emotional_wellbeing = Double.parseDouble("0");
        social_functioning = Double.parseDouble("0");
        pain = Double.parseDouble("0");
        generalhealth = Double.parseDouble("0");



        csfq1a.setOnClickListener(this);
        csfq1b.setOnClickListener(this);
        csfq1c.setOnClickListener(this);
        csfq1d.setOnClickListener(this);
        csfq1e.setOnClickListener(this);

        csfq2a.setOnClickListener(this);
        csfq2b.setOnClickListener(this);
        csfq2c.setOnClickListener(this);
        csfq2d.setOnClickListener(this);
        csfq2e.setOnClickListener(this);

        csfq3a.setOnClickListener(this);
        csfq3b.setOnClickListener(this);
        csfq3c.setOnClickListener(this);

        csfq4a.setOnClickListener(this);
        csfq4b.setOnClickListener(this);
        csfq4c.setOnClickListener(this);

        csfq5a.setOnClickListener(this);
        csfq5b.setOnClickListener(this);
        csfq5c.setOnClickListener(this);

        csfq6a.setOnClickListener(this);
        csfq6b.setOnClickListener(this);
        csfq6c.setOnClickListener(this);

        csfq7a.setOnClickListener(this);
        csfq7b.setOnClickListener(this);
        csfq7c.setOnClickListener(this);

        csfq8a.setOnClickListener(this);
        csfq8b.setOnClickListener(this);
        csfq8c.setOnClickListener(this);

        csfq9a.setOnClickListener(this);
        csfq9b.setOnClickListener(this);
        csfq9c.setOnClickListener(this);

        csfq10a.setOnClickListener(this);
        csfq10b.setOnClickListener(this);
        csfq10c.setOnClickListener(this);

        csfq11a.setOnClickListener(this);
        csfq11b.setOnClickListener(this);
        csfq11c.setOnClickListener(this);

        csfq12a.setOnClickListener(this);
        csfq12b.setOnClickListener(this);
        csfq12c.setOnClickListener(this);

        csfq13a.setOnClickListener(this);
        csfq13b.setOnClickListener(this);

        csfq14a.setOnClickListener(this);
        csfq14b.setOnClickListener(this);

        csfq15a.setOnClickListener(this);
        csfq15b.setOnClickListener(this);

        csfq16a.setOnClickListener(this);
        csfq16b.setOnClickListener(this);

        csfq17a.setOnClickListener(this);
        csfq17b.setOnClickListener(this);

        csfq18a.setOnClickListener(this);
        csfq18b.setOnClickListener(this);

        csfq19a.setOnClickListener(this);
        csfq19b.setOnClickListener(this);

        csfq20a.setOnClickListener(this);
        csfq20b.setOnClickListener(this);
        csfq20c.setOnClickListener(this);
        csfq20d.setOnClickListener(this);
        csfq20e.setOnClickListener(this);

        csfq21a.setOnClickListener(this);
        csfq21b.setOnClickListener(this);
        csfq21c.setOnClickListener(this);
        csfq21d.setOnClickListener(this);
        csfq21e.setOnClickListener(this);
        csfq21f.setOnClickListener(this);

        csfq22a.setOnClickListener(this);
        csfq22b.setOnClickListener(this);
        csfq22c.setOnClickListener(this);
        csfq22d.setOnClickListener(this);
        csfq22e.setOnClickListener(this);

        csfq23a.setOnClickListener(this);
        csfq23b.setOnClickListener(this);
        csfq23c.setOnClickListener(this);
        csfq23d.setOnClickListener(this);
        csfq23e.setOnClickListener(this);
        csfq23f.setOnClickListener(this);

        csfq24a.setOnClickListener(this);
        csfq24b.setOnClickListener(this);
        csfq24c.setOnClickListener(this);
        csfq24d.setOnClickListener(this);
        csfq24e.setOnClickListener(this);
        csfq24f.setOnClickListener(this);

        csfq25a.setOnClickListener(this);
        csfq25b.setOnClickListener(this);
        csfq25c.setOnClickListener(this);
        csfq25d.setOnClickListener(this);
        csfq25e.setOnClickListener(this);
        csfq25f.setOnClickListener(this);

        csfq26a.setOnClickListener(this);
        csfq26b.setOnClickListener(this);
        csfq26c.setOnClickListener(this);
        csfq26d.setOnClickListener(this);
        csfq26e.setOnClickListener(this);
        csfq26f.setOnClickListener(this);

        csfq27a.setOnClickListener(this);
        csfq27b.setOnClickListener(this);
        csfq27c.setOnClickListener(this);
        csfq27d.setOnClickListener(this);
        csfq27e.setOnClickListener(this);
        csfq27f.setOnClickListener(this);

        csfq28a.setOnClickListener(this);
        csfq28b.setOnClickListener(this);
        csfq28c.setOnClickListener(this);
        csfq28d.setOnClickListener(this);
        csfq28e.setOnClickListener(this);
        csfq28f.setOnClickListener(this);

        csfq29a.setOnClickListener(this);
        csfq29b.setOnClickListener(this);
        csfq29c.setOnClickListener(this);
        csfq29d.setOnClickListener(this);
        csfq29e.setOnClickListener(this);
        csfq29f.setOnClickListener(this);

        csfq30a.setOnClickListener(this);
        csfq30b.setOnClickListener(this);
        csfq30c.setOnClickListener(this);
        csfq30d.setOnClickListener(this);
        csfq30e.setOnClickListener(this);
        csfq30f.setOnClickListener(this);

        csfq31a.setOnClickListener(this);
        csfq31b.setOnClickListener(this);
        csfq31c.setOnClickListener(this);
        csfq31d.setOnClickListener(this);
        csfq31e.setOnClickListener(this);
        csfq31f.setOnClickListener(this);

        csfq32a.setOnClickListener(this);
        csfq32b.setOnClickListener(this);
        csfq32c.setOnClickListener(this);
        csfq32d.setOnClickListener(this);
        csfq32e.setOnClickListener(this);

        csfq33a.setOnClickListener(this);
        csfq33b.setOnClickListener(this);
        csfq33c.setOnClickListener(this);
        csfq33d.setOnClickListener(this);
        csfq33e.setOnClickListener(this);

        csfq34a.setOnClickListener(this);
        csfq34b.setOnClickListener(this);
        csfq34c.setOnClickListener(this);
        csfq34d.setOnClickListener(this);
        csfq34e.setOnClickListener(this);

        csfq35a.setOnClickListener(this);
        csfq35b.setOnClickListener(this);
        csfq35c.setOnClickListener(this);
        csfq35d.setOnClickListener(this);
        csfq35e.setOnClickListener(this);

        csfq36a.setOnClickListener(this);
        csfq36b.setOnClickListener(this);
        csfq36c.setOnClickListener(this);
        csfq36d.setOnClickListener(this);
        csfq36e.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.csfq1a:
                csfq1b.setChecked(false);
                csfq1c.setChecked(false);
                csfq1d.setChecked(false);
                csfq1e.setChecked(false);
                if (csfq1a.isChecked()){
                    sfq1 = Double.parseDouble("100");
                }
                else sfq1 = Double.parseDouble("0");
                break;
            case R.id.csfq1b:
                csfq1a.setChecked(false);
                csfq1c.setChecked(false);
                csfq1d.setChecked(false);
                csfq1e.setChecked(false);
                if (csfq1b.isChecked()){
                    sfq1 = Double.parseDouble("75");
                }
                else sfq1 = Double.parseDouble("0");
                break;
            case R.id.csfq1c:
                csfq1a.setChecked(false);
                csfq1b.setChecked(false);
                csfq1d.setChecked(false);
                csfq1e.setChecked(false);
                if (csfq1c.isChecked()){
                    sfq1 = Double.parseDouble("50");
                }
                else sfq1 = Double.parseDouble("0");
                break;
            case R.id.csfq1d:
                csfq1a.setChecked(false);
                csfq1b.setChecked(false);
                csfq1c.setChecked(false);
                csfq1e.setChecked(false);
                if (csfq1d.isChecked()){
                    sfq1 = Double.parseDouble("25");
                }
                else sfq1 = Double.parseDouble("0");
                break;
            case R.id.csfq1e:
                csfq1a.setChecked(false);
                csfq1b.setChecked(false);
                csfq1c.setChecked(false);
                csfq1d.setChecked(false);
                if (csfq1e.isChecked()){
                    sfq1 = Double.parseDouble("0");
                }
                else sfq1 = Double.parseDouble("0");
                break;

            case R.id.csfq2a:
                csfq2b.setChecked(false);
                csfq2c.setChecked(false);
                csfq2d.setChecked(false);
                csfq2e.setChecked(false);
                if (csfq2a.isChecked()){
                    sfq2 = Double.parseDouble("100");
                }
                else sfq2 = Double.parseDouble("0");
                break;
            case R.id.csfq2b:
                csfq2a.setChecked(false);
                csfq2c.setChecked(false);
                csfq2d.setChecked(false);
                csfq2e.setChecked(false);
                if (csfq2b.isChecked()){
                    sfq2 = Double.parseDouble("75");
                }
                else sfq2 = Double.parseDouble("0");
                break;
            case R.id.csfq2c:
                csfq2a.setChecked(false);
                csfq2b.setChecked(false);
                csfq2d.setChecked(false);
                csfq2e.setChecked(false);
                if (csfq2c.isChecked()){
                    sfq2 = Double.parseDouble("50");
                }
                else sfq2 = Double.parseDouble("0");
                break;
            case R.id.csfq2d:
                csfq2a.setChecked(false);
                csfq2b.setChecked(false);
                csfq2c.setChecked(false);
                csfq2e.setChecked(false);
                if (csfq2d.isChecked()){
                    sfq2 = Double.parseDouble("25");
                }
                else sfq2 = Double.parseDouble("0");
                break;
            case R.id.csfq2e:
                csfq2a.setChecked(false);
                csfq2b.setChecked(false);
                csfq2c.setChecked(false);
                csfq2d.setChecked(false);
                if (csfq2e.isChecked()){
                    sfq2 = Double.parseDouble("0");
                }
                else sfq2 = Double.parseDouble("0");
                break;

            case R.id.csfq3a:
                csfq3b.setChecked(false);
                csfq3c.setChecked(false);
                if (csfq3a.isChecked()){
                    sfq3 = Double.parseDouble("0");
                }
                else sfq3 = Double.parseDouble("0");
                break;
            case R.id.csfq3b:
                csfq3a.setChecked(false);
                csfq3c.setChecked(false);
                if (csfq3b.isChecked()){
                    sfq3 = Double.parseDouble("50");
                }
                else sfq3 = Double.parseDouble("0");
                break;
            case R.id.csfq3c:
                csfq3a.setChecked(false);
                csfq3b.setChecked(false);
                if (csfq3c.isChecked()){
                    sfq3 = Double.parseDouble("100");
                }
                else sfq3 = Double.parseDouble("0");
                break;

            case R.id.csfq4a:
                csfq4b.setChecked(false);
                csfq4c.setChecked(false);
                if (csfq4a.isChecked()){
                    sfq4 = Double.parseDouble("0");
                }
                else sfq4 = Double.parseDouble("0");
                break;
            case R.id.csfq4b:
                csfq4a.setChecked(false);
                csfq4c.setChecked(false);
                if (csfq4b.isChecked()){
                    sfq4 = Double.parseDouble("50");
                }
                else sfq4 = Double.parseDouble("0");
                break;
            case R.id.csfq4c:
                csfq4a.setChecked(false);
                csfq4b.setChecked(false);
                if (csfq4c.isChecked()){
                    sfq4 = Double.parseDouble("100");
                }
                else sfq4 = Double.parseDouble("0");
                break;

            case R.id.csfq5a:
                csfq5b.setChecked(false);
                csfq5c.setChecked(false);
                if (csfq5a.isChecked()){
                    sfq5 = Double.parseDouble("0");
                }
                else sfq5 = Double.parseDouble("0");
                break;
            case R.id.csfq5b:
                csfq5a.setChecked(false);
                csfq5c.setChecked(false);
                if (csfq5b.isChecked()){
                    sfq5 = Double.parseDouble("50");
                }
                else sfq5 = Double.parseDouble("0");
                break;
            case R.id.csfq5c:
                csfq5a.setChecked(false);
                csfq5b.setChecked(false);
                if (csfq5c.isChecked()){
                    sfq5 = Double.parseDouble("100");
                }
                else sfq5 = Double.parseDouble("0");
                break;

            case R.id.csfq6a:
                csfq6b.setChecked(false);
                csfq6c.setChecked(false);
                if (csfq6a.isChecked()){
                    sfq6 = Double.parseDouble("0");
                }
                else sfq6 = Double.parseDouble("0");
                break;
            case R.id.csfq6b:
                csfq6a.setChecked(false);
                csfq6c.setChecked(false);
                if (csfq6b.isChecked()){
                    sfq6 = Double.parseDouble("50");
                }
                else sfq6 = Double.parseDouble("0");
                break;
            case R.id.csfq6c:
                csfq6a.setChecked(false);
                csfq6b.setChecked(false);
                if (csfq6c.isChecked()){
                    sfq6 = Double.parseDouble("100");
                }
                else sfq6 = Double.parseDouble("0");
                break;

            case R.id.csfq7a:
                csfq7b.setChecked(false);
                csfq7c.setChecked(false);
                if (csfq7a.isChecked()){
                    sfq7 = Double.parseDouble("0");
                }
                else sfq7 = Double.parseDouble("0");
                break;
            case R.id.csfq7b:
                csfq7a.setChecked(false);
                csfq7c.setChecked(false);
                if (csfq7b.isChecked()){
                    sfq7 = Double.parseDouble("50");
                }
                else sfq7 = Double.parseDouble("0");
                break;
            case R.id.csfq7c:
                csfq7a.setChecked(false);
                csfq7b.setChecked(false);
                if (csfq7c.isChecked()){
                    sfq7 = Double.parseDouble("100");
                }
                else sfq7 = Double.parseDouble("0");
                break;

            case R.id.csfq8a:
                csfq8b.setChecked(false);
                csfq8c.setChecked(false);
                if (csfq8a.isChecked()){
                    sfq8 = Double.parseDouble("0");
                }
                else sfq8 = Double.parseDouble("0");
                break;
            case R.id.csfq8b:
                csfq8a.setChecked(false);
                csfq8c.setChecked(false);
                if (csfq8b.isChecked()){
                    sfq8 = Double.parseDouble("50");
                }
                else sfq8 = Double.parseDouble("0");
                break;
            case R.id.csfq8c:
                csfq8a.setChecked(false);
                csfq8b.setChecked(false);
                if (csfq8c.isChecked()){
                    sfq8 = Double.parseDouble("100");
                }
                else sfq8 = Double.parseDouble("0");
                break;

            case R.id.csfq9a:
                csfq9b.setChecked(false);
                csfq9c.setChecked(false);
                if (csfq9a.isChecked()){
                    sfq9 = Double.parseDouble("0");
                }
                else sfq9 = Double.parseDouble("0");
                break;
            case R.id.csfq9b:
                csfq9a.setChecked(false);
                csfq9c.setChecked(false);
                if (csfq9b.isChecked()){
                    sfq9 = Double.parseDouble("50");
                }
                else sfq9 = Double.parseDouble("0");
                break;
            case R.id.csfq9c:
                csfq9a.setChecked(false);
                csfq9b.setChecked(false);
                if (csfq9c.isChecked()){
                    sfq9 = Double.parseDouble("100");
                }
                else sfq9 = Double.parseDouble("0");
                break;

            case R.id.csfq10a:
                csfq10b.setChecked(false);
                csfq10c.setChecked(false);
                if (csfq10a.isChecked()){
                    sfq10 = Double.parseDouble("0");
                }
                else sfq10 = Double.parseDouble("0");
                break;
            case R.id.csfq10b:
                csfq10a.setChecked(false);
                csfq10c.setChecked(false);
                if (csfq10b.isChecked()){
                    sfq10 = Double.parseDouble("50");
                }
                else sfq10 = Double.parseDouble("0");
                break;
            case R.id.csfq10c:
                csfq10a.setChecked(false);
                csfq10b.setChecked(false);
                if (csfq10c.isChecked()){
                    sfq10 = Double.parseDouble("100");
                }
                else sfq10 = Double.parseDouble("0");
                break;

            case R.id.csfq11a:
                csfq11b.setChecked(false);
                csfq11c.setChecked(false);
                if (csfq11a.isChecked()){
                    sfq11 = Double.parseDouble("0");
                }
                else sfq11 = Double.parseDouble("0");
                break;
            case R.id.csfq11b:
                csfq11a.setChecked(false);
                csfq11c.setChecked(false);
                if (csfq11b.isChecked()){
                    sfq11 = Double.parseDouble("50");
                }
                else sfq11 = Double.parseDouble("0");
                break;
            case R.id.csfq11c:
                csfq11a.setChecked(false);
                csfq11b.setChecked(false);
                if (csfq11c.isChecked()){
                    sfq11 = Double.parseDouble("100");
                }
                else sfq11 = Double.parseDouble("0");
                break;

            case R.id.csfq12a:
                csfq12b.setChecked(false);
                csfq12c.setChecked(false);
                if (csfq12a.isChecked()){
                    sfq12 = Double.parseDouble("0");
                }
                else sfq12 = Double.parseDouble("0");
                break;
            case R.id.csfq12b:
                csfq12a.setChecked(false);
                csfq12c.setChecked(false);
                if (csfq12b.isChecked()){
                    sfq12 = Double.parseDouble("50");
                }
                else sfq12 = Double.parseDouble("0");
                break;
            case R.id.csfq12c:
                csfq12a.setChecked(false);
                csfq12b.setChecked(false);
                if (csfq12c.isChecked()){
                    sfq12 = Double.parseDouble("100");
                }
                else sfq12 = Double.parseDouble("0");
                break;

            case R.id.csfq13a:
                csfq13b.setChecked(false);
                if (csfq13a.isChecked()){
                    sfq13 = Double.parseDouble("0");
                }
                else sfq13 = Double.parseDouble("0");
                break;
            case R.id.csfq13b:
                csfq13a.setChecked(false);
                if (csfq13b.isChecked()){
                    sfq13 = Double.parseDouble("100");
                }
                else sfq13 = Double.parseDouble("0");
                break;

            case R.id.csfq14a:
                csfq14b.setChecked(false);
                if (csfq14a.isChecked()){
                    sfq14 = Double.parseDouble("0");
                }
                else sfq14 = Double.parseDouble("0");
                break;
            case R.id.csfq14b:
                csfq14a.setChecked(false);
                if (csfq14b.isChecked()){
                    sfq14 = Double.parseDouble("100");
                }
                else sfq14 = Double.parseDouble("0");
                break;

            case R.id.csfq15a:
                csfq15b.setChecked(false);
                if (csfq15a.isChecked()){
                    sfq15 = Double.parseDouble("0");
                }
                else sfq15 = Double.parseDouble("0");
                break;
            case R.id.csfq15b:
                csfq15a.setChecked(false);
                if (csfq15b.isChecked()){
                    sfq15 = Double.parseDouble("100");
                }
                else sfq15 = Double.parseDouble("0");
                break;

            case R.id.csfq16a:
                csfq16b.setChecked(false);
                if (csfq16a.isChecked()){
                    sfq16 = Double.parseDouble("0");
                }
                else sfq16 = Double.parseDouble("0");
                break;
            case R.id.csfq16b:
                csfq16a.setChecked(false);
                if (csfq16b.isChecked()){
                    sfq16 = Double.parseDouble("100");
                }
                else sfq16 = Double.parseDouble("0");
                break;

            case R.id.csfq17a:
                csfq17b.setChecked(false);
                if (csfq17a.isChecked()){
                    sfq17 = Double.parseDouble("0");
                }
                else sfq17 = Double.parseDouble("0");
                break;
            case R.id.csfq17b:
                csfq17a.setChecked(false);
                if (csfq17b.isChecked()){
                    sfq17 = Double.parseDouble("100");
                }
                else sfq17 = Double.parseDouble("0");
                break;

            case R.id.csfq18a:
                csfq18b.setChecked(false);
                if (csfq18a.isChecked()){
                    sfq18 = Double.parseDouble("0");
                }
                else sfq18 = Double.parseDouble("0");
                break;
            case R.id.csfq18b:
                csfq18a.setChecked(false);
                if (csfq18b.isChecked()){
                    sfq18 = Double.parseDouble("100");
                }
                else sfq18 = Double.parseDouble("0");
                break;

            case R.id.csfq19a:
                csfq19b.setChecked(false);
                if (csfq19a.isChecked()){
                    sfq19 = Double.parseDouble("0");
                }
                else sfq19 = Double.parseDouble("0");
                break;
            case R.id.csfq19b:
                csfq19a.setChecked(false);
                if (csfq19b.isChecked()){
                    sfq19 = Double.parseDouble("100");
                }
                else sfq19 = Double.parseDouble("0");
                break;

            case R.id.csfq20a:
                csfq20b.setChecked(false);
                csfq20c.setChecked(false);
                csfq20d.setChecked(false);
                csfq20e.setChecked(false);
                if (csfq20a.isChecked()){
                    sfq20 = Double.parseDouble("100");
                }
                else sfq20 = Double.parseDouble("0");
                break;
            case R.id.csfq20b:
                csfq20a.setChecked(false);
                csfq20c.setChecked(false);
                csfq20d.setChecked(false);
                csfq20e.setChecked(false);
                if (csfq20b.isChecked()){
                    sfq20 = Double.parseDouble("75");
                }
                else sfq20 = Double.parseDouble("0");
                break;
            case R.id.csfq20c:
                csfq20a.setChecked(false);
                csfq20b.setChecked(false);
                csfq20d.setChecked(false);
                csfq20e.setChecked(false);
                if (csfq20c.isChecked()){
                    sfq20 = Double.parseDouble("50");
                }
                else sfq20 = Double.parseDouble("0");
                break;
            case R.id.csfq20d:
                csfq20a.setChecked(false);
                csfq20b.setChecked(false);
                csfq20c.setChecked(false);
                csfq20e.setChecked(false);
                if (csfq20d.isChecked()){
                    sfq20 = Double.parseDouble("25");
                }
                else sfq20 = Double.parseDouble("0");
                break;
            case R.id.csfq20e:
                csfq20a.setChecked(false);
                csfq20b.setChecked(false);
                csfq20c.setChecked(false);
                csfq20d.setChecked(false);
                if (csfq20e.isChecked()){
                    sfq20 = Double.parseDouble("0");
                }
                else sfq20 = Double.parseDouble("0");
                break;

            case R.id.csfq21a:
                csfq21b.setChecked(false);
                csfq21c.setChecked(false);
                csfq21d.setChecked(false);
                csfq21e.setChecked(false);
                csfq21f.setChecked(false);
                if (csfq21a.isChecked()){
                    sfq21 = Double.parseDouble("100");
                }
                else sfq21 = Double.parseDouble("0");
                break;
            case R.id.csfq21b:
                csfq21a.setChecked(false);
                csfq21c.setChecked(false);
                csfq21d.setChecked(false);
                csfq21e.setChecked(false);
                csfq21f.setChecked(false);
                if (csfq21b.isChecked()){
                    sfq21 = Double.parseDouble("80");
                }
                else sfq21 = Double.parseDouble("0");
                break;
            case R.id.csfq21c:
                csfq21a.setChecked(false);
                csfq21b.setChecked(false);
                csfq21d.setChecked(false);
                csfq21e.setChecked(false);
                csfq21f.setChecked(false);
                if (csfq21c.isChecked()){
                    sfq21 = Double.parseDouble("60");
                }
                else sfq21 = Double.parseDouble("0");
                break;
            case R.id.csfq21d:
                csfq21a.setChecked(false);
                csfq21b.setChecked(false);
                csfq21c.setChecked(false);
                csfq21e.setChecked(false);
                if (csfq21d.isChecked()){
                    sfq21 = Double.parseDouble("40");
                }
                else sfq21 = Double.parseDouble("0");
                break;
            case R.id.csfq21e:
                csfq21a.setChecked(false);
                csfq21b.setChecked(false);
                csfq21c.setChecked(false);
                csfq21d.setChecked(false);
                csfq21f.setChecked(false);
                if (csfq21e.isChecked()){
                    sfq21 = Double.parseDouble("20");
                }
                else sfq21 = Double.parseDouble("0");
                break;
            case R.id.csfq21f:
                csfq21a.setChecked(false);
                csfq21b.setChecked(false);
                csfq21c.setChecked(false);
                csfq21d.setChecked(false);
                csfq21e.setChecked(false);
                if (csfq21f.isChecked()){
                    sfq21 = Double.parseDouble("0");
                }
                else sfq21 = Double.parseDouble("0");
                break;

            case R.id.csfq22a:
                csfq22b.setChecked(false);
                csfq22c.setChecked(false);
                csfq22d.setChecked(false);
                csfq22e.setChecked(false);
                if (csfq22a.isChecked()){
                    sfq22 = Double.parseDouble("100");
                }
                else sfq22 = Double.parseDouble("0");
                break;
            case R.id.csfq22b:
                csfq22a.setChecked(false);
                csfq22c.setChecked(false);
                csfq22d.setChecked(false);
                csfq22e.setChecked(false);
                if (csfq22b.isChecked()){
                    sfq22 = Double.parseDouble("75");
                }
                else sfq22 = Double.parseDouble("0");
                break;
            case R.id.csfq22c:
                csfq22a.setChecked(false);
                csfq22b.setChecked(false);
                csfq22d.setChecked(false);
                csfq22e.setChecked(false);
                if (csfq22c.isChecked()){
                    sfq22 = Double.parseDouble("50");
                }
                else sfq22 = Double.parseDouble("0");
                break;
            case R.id.csfq22d:
                csfq22a.setChecked(false);
                csfq22b.setChecked(false);
                csfq22c.setChecked(false);
                csfq22e.setChecked(false);
                if (csfq22d.isChecked()){
                    sfq22 = Double.parseDouble("25");
                }
                else sfq22 = Double.parseDouble("0");
                break;
            case R.id.csfq22e:
                csfq22a.setChecked(false);
                csfq22b.setChecked(false);
                csfq22c.setChecked(false);
                csfq22d.setChecked(false);
                if (csfq22e.isChecked()){
                    sfq22 = Double.parseDouble("0");
                }
                else sfq22 = Double.parseDouble("0");
                break;

            case R.id.csfq23a:
                csfq23b.setChecked(false);
                csfq23c.setChecked(false);
                csfq23d.setChecked(false);
                csfq23e.setChecked(false);
                csfq23f.setChecked(false);
                if (csfq23a.isChecked()){
                    sfq23 = Double.parseDouble("100");
                }
                else sfq23 = Double.parseDouble("0");
                break;
            case R.id.csfq23b:
                csfq23a.setChecked(false);
                csfq23c.setChecked(false);
                csfq23d.setChecked(false);
                csfq23e.setChecked(false);
                csfq23f.setChecked(false);
                if (csfq23b.isChecked()){
                    sfq23 = Double.parseDouble("80");
                }
                else sfq23 = Double.parseDouble("0");
                break;
            case R.id.csfq23c:
                csfq23a.setChecked(false);
                csfq23b.setChecked(false);
                csfq23d.setChecked(false);
                csfq23e.setChecked(false);
                csfq23f.setChecked(false);
                if (csfq23c.isChecked()){
                    sfq23 = Double.parseDouble("60");
                }
                else sfq23 = Double.parseDouble("0");
                break;
            case R.id.csfq23d:
                csfq23a.setChecked(false);
                csfq23b.setChecked(false);
                csfq23c.setChecked(false);
                csfq23e.setChecked(false);
                csfq23f.setChecked(false);
                if (csfq23d.isChecked()){
                    sfq23 = Double.parseDouble("40");
                }
                else sfq23 = Double.parseDouble("0");
                break;
            case R.id.csfq23e:
                csfq23a.setChecked(false);
                csfq23b.setChecked(false);
                csfq23c.setChecked(false);
                csfq23d.setChecked(false);
                csfq23f.setChecked(false);
                if (csfq23e.isChecked()){
                    sfq23 = Double.parseDouble("20");
                }
                else sfq23 = Double.parseDouble("0");
                break;
            case R.id.csfq23f:
                csfq23a.setChecked(false);
                csfq23b.setChecked(false);
                csfq23c.setChecked(false);
                csfq23d.setChecked(false);
                csfq23e.setChecked(false);
                if (csfq23f.isChecked()){
                    sfq23 = Double.parseDouble("0");
                }
                else sfq23 = Double.parseDouble("0");
                break;

            case R.id.csfq24a:
                csfq24b.setChecked(false);
                csfq24c.setChecked(false);
                csfq24d.setChecked(false);
                csfq24e.setChecked(false);
                csfq24f.setChecked(false);
                if (csfq24a.isChecked()){
                    sfq24 = Double.parseDouble("0");
                }
                else sfq24 = Double.parseDouble("0");
                break;
            case R.id.csfq24b:
                csfq24a.setChecked(false);
                csfq24c.setChecked(false);
                csfq24d.setChecked(false);
                csfq24e.setChecked(false);
                csfq24f.setChecked(false);
                if (csfq24b.isChecked()){
                    sfq24 = Double.parseDouble("20");
                }
                else sfq24 = Double.parseDouble("0");
                break;
            case R.id.csfq24c:
                csfq24a.setChecked(false);
                csfq24b.setChecked(false);
                csfq24d.setChecked(false);
                csfq24e.setChecked(false);
                csfq24f.setChecked(false);
                if (csfq24c.isChecked()){
                    sfq24 = Double.parseDouble("40");
                }
                else sfq24 = Double.parseDouble("0");
                break;
            case R.id.csfq24d:
                csfq24a.setChecked(false);
                csfq24b.setChecked(false);
                csfq24c.setChecked(false);
                csfq24e.setChecked(false);
                csfq24f.setChecked(false);
                if (csfq24d.isChecked()){
                    sfq24 = Double.parseDouble("60");
                }
                else sfq24 = Double.parseDouble("0");
                break;
            case R.id.csfq24e:
                csfq24a.setChecked(false);
                csfq24b.setChecked(false);
                csfq24c.setChecked(false);
                csfq24d.setChecked(false);
                csfq24f.setChecked(false);
                if (csfq24e.isChecked()){
                    sfq24 = Double.parseDouble("80");
                }
                else sfq24 = Double.parseDouble("0");
                break;
            case R.id.csfq24f:
                csfq24a.setChecked(false);
                csfq24b.setChecked(false);
                csfq24c.setChecked(false);
                csfq24d.setChecked(false);
                csfq24e.setChecked(false);
                if (csfq24f.isChecked()){
                    sfq24 = Double.parseDouble("100");
                }
                else sfq24 = Double.parseDouble("0");
                break;

            case R.id.csfq25a:
                csfq25b.setChecked(false);
                csfq25c.setChecked(false);
                csfq25d.setChecked(false);
                csfq25e.setChecked(false);
                csfq25f.setChecked(false);
                if (csfq25a.isChecked()){
                    sfq25 = Double.parseDouble("0");
                }
                else sfq25 = Double.parseDouble("0");
                break;
            case R.id.csfq25b:
                csfq25a.setChecked(false);
                csfq25c.setChecked(false);
                csfq25d.setChecked(false);
                csfq25e.setChecked(false);
                csfq25f.setChecked(false);
                if (csfq25b.isChecked()){
                    sfq25 = Double.parseDouble("20");
                }
                else sfq25 = Double.parseDouble("0");
                break;
            case R.id.csfq25c:
                csfq25a.setChecked(false);
                csfq25b.setChecked(false);
                csfq25d.setChecked(false);
                csfq25e.setChecked(false);
                csfq25f.setChecked(false);
                if (csfq25c.isChecked()){
                    sfq25 = Double.parseDouble("40");
                }
                else sfq25 = Double.parseDouble("0");
                break;
            case R.id.csfq25d:
                csfq25a.setChecked(false);
                csfq25b.setChecked(false);
                csfq25c.setChecked(false);
                csfq25e.setChecked(false);
                csfq25f.setChecked(false);
                if (csfq25d.isChecked()){
                    sfq25 = Double.parseDouble("60");
                }
                else sfq25 = Double.parseDouble("0");
                break;
            case R.id.csfq25e:
                csfq25a.setChecked(false);
                csfq25b.setChecked(false);
                csfq25c.setChecked(false);
                csfq25d.setChecked(false);
                csfq25f.setChecked(false);
                if (csfq25e.isChecked()){
                    sfq25 = Double.parseDouble("80");
                }
                else sfq25 = Double.parseDouble("0");
                break;
            case R.id.csfq25f:
                csfq25a.setChecked(false);
                csfq25b.setChecked(false);
                csfq25c.setChecked(false);
                csfq25d.setChecked(false);
                csfq25e.setChecked(false);
                if (csfq25f.isChecked()){
                    sfq25 = Double.parseDouble("100");
                }
                else sfq25 = Double.parseDouble("0");
                break;

            case R.id.csfq26a:
                csfq26b.setChecked(false);
                csfq26c.setChecked(false);
                csfq26d.setChecked(false);
                csfq26e.setChecked(false);
                csfq26f.setChecked(false);
                if (csfq26a.isChecked()){
                    sfq26 = Double.parseDouble("100");
                }
                else sfq26 = Double.parseDouble("0");
                break;
            case R.id.csfq26b:
                csfq26a.setChecked(false);
                csfq26c.setChecked(false);
                csfq26d.setChecked(false);
                csfq26e.setChecked(false);
                csfq26f.setChecked(false);
                if (csfq26b.isChecked()){
                    sfq26 = Double.parseDouble("80");
                }
                else sfq26 = Double.parseDouble("0");
                break;
            case R.id.csfq26c:
                csfq26a.setChecked(false);
                csfq26b.setChecked(false);
                csfq26d.setChecked(false);
                csfq26e.setChecked(false);
                csfq26f.setChecked(false);
                if (csfq26c.isChecked()){
                    sfq26 = Double.parseDouble("60");
                }
                else sfq26 = Double.parseDouble("0");
                break;
            case R.id.csfq26d:
                csfq26a.setChecked(false);
                csfq26b.setChecked(false);
                csfq26c.setChecked(false);
                csfq26e.setChecked(false);
                csfq26f.setChecked(false);
                if (csfq26d.isChecked()){
                    sfq26 = Double.parseDouble("40");
                }
                else sfq26 = Double.parseDouble("0");
                break;
            case R.id.csfq26e:
                csfq26a.setChecked(false);
                csfq26b.setChecked(false);
                csfq26c.setChecked(false);
                csfq26d.setChecked(false);
                csfq26f.setChecked(false);
                if (csfq26e.isChecked()){
                    sfq26 = Double.parseDouble("20");
                }
                else sfq26 = Double.parseDouble("0");
                break;
            case R.id.csfq26f:
                csfq26a.setChecked(false);
                csfq26b.setChecked(false);
                csfq26c.setChecked(false);
                csfq26d.setChecked(false);
                csfq26e.setChecked(false);
                if (csfq26f.isChecked()){
                    sfq26 = Double.parseDouble("0");
                }
                else sfq26 = Double.parseDouble("0");
                break;

            case R.id.csfq27a:
                csfq27b.setChecked(false);
                csfq27c.setChecked(false);
                csfq27d.setChecked(false);
                csfq27e.setChecked(false);
                csfq27f.setChecked(false);
                if (csfq27a.isChecked()){
                    sfq27 = Double.parseDouble("100");
                }
                else sfq27 = Double.parseDouble("0");
                break;
            case R.id.csfq27b:
                csfq27a.setChecked(false);
                csfq27c.setChecked(false);
                csfq27d.setChecked(false);
                csfq27e.setChecked(false);
                csfq27f.setChecked(false);
                if (csfq27b.isChecked()){
                    sfq27 = Double.parseDouble("80");
                }
                else sfq27 = Double.parseDouble("0");
                break;
            case R.id.csfq27c:
                csfq27a.setChecked(false);
                csfq27b.setChecked(false);
                csfq27d.setChecked(false);
                csfq27e.setChecked(false);
                csfq27f.setChecked(false);
                if (csfq27c.isChecked()){
                    sfq27 = Double.parseDouble("60");
                }
                else sfq27 = Double.parseDouble("0");
                break;
            case R.id.csfq27d:
                csfq27a.setChecked(false);
                csfq27b.setChecked(false);
                csfq27c.setChecked(false);
                csfq27e.setChecked(false);
                csfq27f.setChecked(false);
                if (csfq27d.isChecked()){
                    sfq27 = Double.parseDouble("40");
                }
                else sfq27 = Double.parseDouble("0");
                break;
            case R.id.csfq27e:
                csfq27a.setChecked(false);
                csfq27b.setChecked(false);
                csfq27c.setChecked(false);
                csfq27d.setChecked(false);
                csfq27f.setChecked(false);
                if (csfq27e.isChecked()){
                    sfq27 = Double.parseDouble("20");
                }
                else sfq27 = Double.parseDouble("0");
                break;
            case R.id.csfq27f:
                csfq27a.setChecked(false);
                csfq27b.setChecked(false);
                csfq27c.setChecked(false);
                csfq27d.setChecked(false);
                csfq27e.setChecked(false);
                if (csfq27f.isChecked()){
                    sfq27 = Double.parseDouble("0");
                }
                else sfq27 = Double.parseDouble("0");
                break;

            case R.id.csfq28a:
                csfq28b.setChecked(false);
                csfq28c.setChecked(false);
                csfq28d.setChecked(false);
                csfq28e.setChecked(false);
                csfq28f.setChecked(false);
                if (csfq28a.isChecked()){
                    sfq28 = Double.parseDouble("0");
                }
                else sfq28 = Double.parseDouble("0");
                break;
            case R.id.csfq28b:
                csfq28a.setChecked(false);
                csfq28c.setChecked(false);
                csfq28d.setChecked(false);
                csfq28e.setChecked(false);
                csfq28f.setChecked(false);
                if (csfq28b.isChecked()){
                    sfq28 = Double.parseDouble("20");
                }
                else sfq28 = Double.parseDouble("0");
                break;
            case R.id.csfq28c:
                csfq28a.setChecked(false);
                csfq28b.setChecked(false);
                csfq28d.setChecked(false);
                csfq28e.setChecked(false);
                csfq28f.setChecked(false);
                if (csfq28c.isChecked()){
                    sfq28 = Double.parseDouble("40");
                }
                else sfq28 = Double.parseDouble("0");
                break;
            case R.id.csfq28d:
                csfq28a.setChecked(false);
                csfq28b.setChecked(false);
                csfq28c.setChecked(false);
                csfq28e.setChecked(false);
                csfq28f.setChecked(false);
                if (csfq28d.isChecked()){
                    sfq28 = Double.parseDouble("60");
                }
                else sfq28 = Double.parseDouble("0");
                break;
            case R.id.csfq28e:
                csfq28a.setChecked(false);
                csfq28b.setChecked(false);
                csfq28c.setChecked(false);
                csfq28d.setChecked(false);
                csfq28f.setChecked(false);
                if (csfq28e.isChecked()){
                    sfq28 = Double.parseDouble("80");
                }
                else sfq28 = Double.parseDouble("0");
                break;
            case R.id.csfq28f:
                csfq28a.setChecked(false);
                csfq28b.setChecked(false);
                csfq28c.setChecked(false);
                csfq28d.setChecked(false);
                csfq28e.setChecked(false);
                if (csfq28f.isChecked()){
                    sfq28 = Double.parseDouble("100");
                }
                else sfq28 = Double.parseDouble("0");
                break;

            case R.id.csfq29a:
                csfq29b.setChecked(false);
                csfq29c.setChecked(false);
                csfq29d.setChecked(false);
                csfq29e.setChecked(false);
                csfq29f.setChecked(false);
                if (csfq29a.isChecked()){
                    sfq29 = Double.parseDouble("0");
                }
                else sfq29 = Double.parseDouble("0");
                break;
            case R.id.csfq29b:
                csfq29a.setChecked(false);
                csfq29c.setChecked(false);
                csfq29d.setChecked(false);
                csfq29e.setChecked(false);
                csfq29f.setChecked(false);
                if (csfq29b.isChecked()){
                    sfq29 = Double.parseDouble("20");
                }
                else sfq29 = Double.parseDouble("0");
                break;
            case R.id.csfq29c:
                csfq29a.setChecked(false);
                csfq29b.setChecked(false);
                csfq29d.setChecked(false);
                csfq29e.setChecked(false);
                csfq29f.setChecked(false);
                if (csfq29c.isChecked()){
                    sfq29 = Double.parseDouble("40");
                }
                else sfq29 = Double.parseDouble("0");
                break;
            case R.id.csfq29d:
                csfq29a.setChecked(false);
                csfq29b.setChecked(false);
                csfq29c.setChecked(false);
                csfq29e.setChecked(false);
                csfq29f.setChecked(false);
                if (csfq29d.isChecked()){
                    sfq29 = Double.parseDouble("60");
                }
                else sfq29 = Double.parseDouble("0");
                break;
            case R.id.csfq29e:
                csfq29a.setChecked(false);
                csfq29b.setChecked(false);
                csfq29c.setChecked(false);
                csfq29d.setChecked(false);
                csfq29f.setChecked(false);
                if (csfq29e.isChecked()){
                    sfq29 = Double.parseDouble("80");
                }
                else sfq29 = Double.parseDouble("0");
                break;
            case R.id.csfq29f:
                csfq29a.setChecked(false);
                csfq29b.setChecked(false);
                csfq29c.setChecked(false);
                csfq29d.setChecked(false);
                csfq29e.setChecked(false);
                if (csfq29f.isChecked()){
                    sfq29 = Double.parseDouble("100");
                }
                else sfq29 = Double.parseDouble("0");
                break;

            case R.id.csfq30a:
                csfq30b.setChecked(false);
                csfq30c.setChecked(false);
                csfq30d.setChecked(false);
                csfq30e.setChecked(false);
                csfq30f.setChecked(false);
                if (csfq30a.isChecked()){
                    sfq30 = Double.parseDouble("100");
                }
                else sfq30 = Double.parseDouble("0");
                break;
            case R.id.csfq30b:
                csfq30a.setChecked(false);
                csfq30c.setChecked(false);
                csfq30d.setChecked(false);
                csfq30e.setChecked(false);
                csfq30f.setChecked(false);
                if (csfq30b.isChecked()){
                    sfq30 = Double.parseDouble("80");
                }
                else sfq30 = Double.parseDouble("0");
                break;
            case R.id.csfq30c:
                csfq30a.setChecked(false);
                csfq30b.setChecked(false);
                csfq30d.setChecked(false);
                csfq30e.setChecked(false);
                csfq30f.setChecked(false);
                if (csfq30c.isChecked()){
                    sfq30 = Double.parseDouble("60");
                }
                else sfq30 = Double.parseDouble("0");
                break;
            case R.id.csfq30d:
                csfq30a.setChecked(false);
                csfq30b.setChecked(false);
                csfq30c.setChecked(false);
                csfq30e.setChecked(false);
                csfq30f.setChecked(false);
                if (csfq30d.isChecked()){
                    sfq30 = Double.parseDouble("40");
                }
                else sfq30 = Double.parseDouble("0");
                break;
            case R.id.csfq30e:
                csfq30a.setChecked(false);
                csfq30b.setChecked(false);
                csfq30c.setChecked(false);
                csfq30d.setChecked(false);
                csfq30f.setChecked(false);
                if (csfq30e.isChecked()){
                    sfq30 = Double.parseDouble("20");
                }
                else sfq30 = Double.parseDouble("0");
                break;
            case R.id.csfq30f:
                csfq30a.setChecked(false);
                csfq30b.setChecked(false);
                csfq30c.setChecked(false);
                csfq30d.setChecked(false);
                csfq30e.setChecked(false);
                if (csfq30f.isChecked()){
                    sfq30 = Double.parseDouble("0");
                }
                else sfq30 = Double.parseDouble("0");
                break;

            case R.id.csfq31a:
                csfq31b.setChecked(false);
                csfq31c.setChecked(false);
                csfq31d.setChecked(false);
                csfq31e.setChecked(false);
                csfq31f.setChecked(false);
                if (csfq31a.isChecked()){
                    sfq31 = Double.parseDouble("0");
                }
                else sfq31 = Double.parseDouble("0");
                break;
            case R.id.csfq31b:
                csfq31a.setChecked(false);
                csfq31c.setChecked(false);
                csfq31d.setChecked(false);
                csfq31e.setChecked(false);
                csfq31f.setChecked(false);
                if (csfq31b.isChecked()){
                    sfq31 = Double.parseDouble("20");
                }
                else sfq31 = Double.parseDouble("0");
                break;
            case R.id.csfq31c:
                csfq31a.setChecked(false);
                csfq31b.setChecked(false);
                csfq31d.setChecked(false);
                csfq31e.setChecked(false);
                csfq31f.setChecked(false);
                if (csfq31c.isChecked()){
                    sfq31 = Double.parseDouble("40");
                }
                else sfq31 = Double.parseDouble("0");
                break;
            case R.id.csfq31d:
                csfq31a.setChecked(false);
                csfq31b.setChecked(false);
                csfq31c.setChecked(false);
                csfq31e.setChecked(false);
                csfq31f.setChecked(false);
                if (csfq31d.isChecked()){
                    sfq31 = Double.parseDouble("60");
                }
                else sfq31 = Double.parseDouble("0");
                break;
            case R.id.csfq31e:
                csfq31a.setChecked(false);
                csfq31b.setChecked(false);
                csfq31c.setChecked(false);
                csfq31d.setChecked(false);
                csfq31f.setChecked(false);
                if (csfq31e.isChecked()){
                    sfq31 = Double.parseDouble("80");
                }
                else sfq31 = Double.parseDouble("0");
                break;
            case R.id.csfq31f:
                csfq31a.setChecked(false);
                csfq31b.setChecked(false);
                csfq31c.setChecked(false);
                csfq31d.setChecked(false);
                csfq31e.setChecked(false);
                if (csfq31f.isChecked()){
                    sfq31 = Double.parseDouble("100");
                }
                else sfq31 = Double.parseDouble("0");
                break;

            case R.id.csfq32a:
                csfq32b.setChecked(false);
                csfq32c.setChecked(false);
                csfq32d.setChecked(false);
                csfq32e.setChecked(false);
                if (csfq32a.isChecked()){
                    sfq32 = Double.parseDouble("0");
                }
                else sfq32 = Double.parseDouble("0");
                break;
            case R.id.csfq32b:
                csfq32a.setChecked(false);
                csfq32c.setChecked(false);
                csfq32d.setChecked(false);
                csfq32e.setChecked(false);
                if (csfq32b.isChecked()){
                    sfq32 = Double.parseDouble("25");
                }
                else sfq32 = Double.parseDouble("0");
                break;
            case R.id.csfq32c:
                csfq32a.setChecked(false);
                csfq32b.setChecked(false);
                csfq32d.setChecked(false);
                csfq32e.setChecked(false);
                if (csfq32c.isChecked()){
                    sfq32 = Double.parseDouble("50");
                }
                else sfq32 = Double.parseDouble("0");
                break;
            case R.id.csfq32d:
                csfq32a.setChecked(false);
                csfq32b.setChecked(false);
                csfq32c.setChecked(false);
                csfq32e.setChecked(false);
                if (csfq32d.isChecked()){
                    sfq32 = Double.parseDouble("75");
                }
                else sfq32 = Double.parseDouble("0");
                break;
            case R.id.csfq32e:
                csfq32a.setChecked(false);
                csfq32b.setChecked(false);
                csfq32c.setChecked(false);
                csfq32d.setChecked(false);
                if (csfq32e.isChecked()){
                    sfq32 = Double.parseDouble("100");
                }
                else sfq32 = Double.parseDouble("0");
                break;

            case R.id.csfq33a:
                csfq33b.setChecked(false);
                csfq33c.setChecked(false);
                csfq33d.setChecked(false);
                csfq33e.setChecked(false);
                if (csfq33a.isChecked()){
                    sfq33 = Double.parseDouble("0");
                }
                else sfq33 = Double.parseDouble("0");
                break;
            case R.id.csfq33b:
                csfq33a.setChecked(false);
                csfq33c.setChecked(false);
                csfq33d.setChecked(false);
                csfq33e.setChecked(false);
                if (csfq33b.isChecked()){
                    sfq33 = Double.parseDouble("25");
                }
                else sfq33 = Double.parseDouble("0");
                break;
            case R.id.csfq33c:
                csfq33a.setChecked(false);
                csfq33b.setChecked(false);
                csfq33d.setChecked(false);
                csfq33e.setChecked(false);
                if (csfq33c.isChecked()){
                    sfq33 = Double.parseDouble("50");
                }
                else sfq33 = Double.parseDouble("0");
                break;
            case R.id.csfq33d:
                csfq33a.setChecked(false);
                csfq33b.setChecked(false);
                csfq33c.setChecked(false);
                csfq33e.setChecked(false);
                if (csfq33d.isChecked()){
                    sfq33 = Double.parseDouble("75");
                }
                else sfq33 = Double.parseDouble("0");
                break;
            case R.id.csfq33e:
                csfq33a.setChecked(false);
                csfq33b.setChecked(false);
                csfq33c.setChecked(false);
                csfq33d.setChecked(false);
                if (csfq33e.isChecked()){
                    sfq33 = Double.parseDouble("100");
                }
                else sfq33 = Double.parseDouble("0");
                break;

            case R.id.csfq34a:
                csfq34b.setChecked(false);
                csfq34c.setChecked(false);
                csfq34d.setChecked(false);
                csfq34e.setChecked(false);
                if (csfq34a.isChecked()){
                    sfq34 = Double.parseDouble("100");
                }
                else sfq34 = Double.parseDouble("0");
                break;
            case R.id.csfq34b:
                csfq34a.setChecked(false);
                csfq34c.setChecked(false);
                csfq34d.setChecked(false);
                csfq34e.setChecked(false);
                if (csfq34b.isChecked()){
                    sfq34 = Double.parseDouble("75");
                }
                else sfq34 = Double.parseDouble("0");
                break;
            case R.id.csfq34c:
                csfq34a.setChecked(false);
                csfq34b.setChecked(false);
                csfq34d.setChecked(false);
                csfq34e.setChecked(false);
                if (csfq34c.isChecked()){
                    sfq34 = Double.parseDouble("50");
                }
                else sfq34 = Double.parseDouble("0");
                break;
            case R.id.csfq34d:
                csfq34a.setChecked(false);
                csfq34b.setChecked(false);
                csfq34c.setChecked(false);
                csfq34e.setChecked(false);
                if (csfq34d.isChecked()){
                    sfq34 = Double.parseDouble("25");
                }
                else sfq34 = Double.parseDouble("0");
                break;
            case R.id.csfq34e:
                csfq34a.setChecked(false);
                csfq34b.setChecked(false);
                csfq34c.setChecked(false);
                csfq34d.setChecked(false);
                if (csfq34e.isChecked()){
                    sfq34 = Double.parseDouble("0");
                }
                else sfq34 = Double.parseDouble("0");
                break;

            case R.id.csfq35a:
                csfq35b.setChecked(false);
                csfq35c.setChecked(false);
                csfq35d.setChecked(false);
                csfq35e.setChecked(false);
                if (csfq35a.isChecked()){
                    sfq35 = Double.parseDouble("0");
                }
                else sfq35 = Double.parseDouble("0");
                break;
            case R.id.csfq35b:
                csfq35a.setChecked(false);
                csfq35c.setChecked(false);
                csfq35d.setChecked(false);
                csfq35e.setChecked(false);
                if (csfq35b.isChecked()){
                    sfq35 = Double.parseDouble("25");
                }
                else sfq35 = Double.parseDouble("0");
                break;
            case R.id.csfq35c:
                csfq35a.setChecked(false);
                csfq35b.setChecked(false);
                csfq35d.setChecked(false);
                csfq35e.setChecked(false);
                if (csfq35c.isChecked()){
                    sfq35 = Double.parseDouble("50");
                }
                else sfq35 = Double.parseDouble("0");
                break;
            case R.id.csfq35d:
                csfq35a.setChecked(false);
                csfq35b.setChecked(false);
                csfq35c.setChecked(false);
                csfq35e.setChecked(false);
                if (csfq35d.isChecked()){
                    sfq35 = Double.parseDouble("75");
                }
                else sfq35 = Double.parseDouble("0");
                break;
            case R.id.csfq35e:
                csfq35a.setChecked(false);
                csfq35b.setChecked(false);
                csfq35c.setChecked(false);
                csfq35d.setChecked(false);
                if (csfq35e.isChecked()){
                    sfq35 = Double.parseDouble("100");
                }
                else sfq35 = Double.parseDouble("0");
                break;

            case R.id.csfq36a:
                csfq36b.setChecked(false);
                csfq36c.setChecked(false);
                csfq36d.setChecked(false);
                csfq36e.setChecked(false);
                if (csfq36a.isChecked()){
                    sfq36 = Double.parseDouble("100");
                }
                else sfq36 = Double.parseDouble("0");
                break;
            case R.id.csfq36b:
                csfq36a.setChecked(false);
                csfq36c.setChecked(false);
                csfq36d.setChecked(false);
                csfq36e.setChecked(false);
                if (csfq36b.isChecked()){
                    sfq36 = Double.parseDouble("75");
                }
                else sfq36 = Double.parseDouble("0");
                break;
            case R.id.csfq36c:
                csfq36a.setChecked(false);
                csfq36b.setChecked(false);
                csfq36d.setChecked(false);
                csfq36e.setChecked(false);
                if (csfq36c.isChecked()){
                    sfq36 = Double.parseDouble("50");
                }
                else sfq36 = Double.parseDouble("0");
                break;
            case R.id.csfq36d:
                csfq36a.setChecked(false);
                csfq36b.setChecked(false);
                csfq36c.setChecked(false);
                csfq36e.setChecked(false);
                if (csfq36d.isChecked()){
                    sfq36 = Double.parseDouble("25");
                }
                else sfq36 = Double.parseDouble("0");
                break;
            case R.id.csfq36e:
                csfq36a.setChecked(false);
                csfq36b.setChecked(false);
                csfq36c.setChecked(false);
                csfq36d.setChecked(false);
                if (csfq36e.isChecked()){
                    sfq36 = Double.parseDouble("0");
                }
                else sfq36 = Double.parseDouble("0");
                break;

        }
        switch (v.getId()) {
            case R.id.bDone:

                inputcheck = new ArrayList<>();

                if (!csfq1a.isChecked() && !csfq1b.isChecked() && !csfq1c.isChecked() && !csfq1d.isChecked() && !csfq1e.isChecked()) {
                    inputcheck.add("1");
                }

                if (!csfq2a.isChecked() && !csfq2b.isChecked() && !csfq2c.isChecked() && !csfq2d.isChecked() && !csfq2e.isChecked()) {
                    inputcheck.add("2");
                }

                if (!csfq3a.isChecked() && !csfq3b.isChecked() && !csfq3c.isChecked()) {
                    inputcheck.add("3");
                }

                if (!csfq4a.isChecked() && !csfq4b.isChecked() && !csfq4c.isChecked()) {
                    inputcheck.add("4");
                }

                if (!csfq5a.isChecked() && !csfq5b.isChecked() && !csfq5c.isChecked()) {
                    inputcheck.add("5");
                }

                if (!csfq6a.isChecked() && !csfq6b.isChecked() && !csfq6c.isChecked()) {
                    inputcheck.add("6");
                }

                if (!csfq7a.isChecked() && !csfq7b.isChecked() && !csfq7c.isChecked()) {
                    inputcheck.add("7");
                }

                if (!csfq8a.isChecked() && !csfq8b.isChecked() && !csfq8c.isChecked()) {
                    inputcheck.add("8");
                }

                if (!csfq9a.isChecked() && !csfq9b.isChecked() && !csfq9c.isChecked()) {
                    inputcheck.add("9");
                }

                if (!csfq10a.isChecked() && !csfq10b.isChecked() && !csfq10c.isChecked()) {
                    inputcheck.add("10");
                }

                if (!csfq11a.isChecked() && !csfq11b.isChecked() && !csfq11c.isChecked()) {
                    inputcheck.add("11");
                }
                
                if (!csfq12a.isChecked() && !csfq12b.isChecked() && !csfq12c.isChecked()) {
                    inputcheck.add("12");
                }

                if (!csfq13a.isChecked() && !csfq13b.isChecked()) {
                    inputcheck.add("13");
                }

                if (!csfq14a.isChecked() && !csfq14b.isChecked()) {
                    inputcheck.add("14");
                }

                if (!csfq15a.isChecked() && !csfq15b.isChecked()) {
                    inputcheck.add("15");
                }

                if (!csfq16a.isChecked() && !csfq16b.isChecked()) {
                    inputcheck.add("16");
                }

                if (!csfq17a.isChecked() && !csfq17b.isChecked()) {
                    inputcheck.add("17");
                }

                if (!csfq18a.isChecked() && !csfq18b.isChecked()) {
                    inputcheck.add("18");
                }

                if (!csfq19a.isChecked() && !csfq19b.isChecked()) {
                    inputcheck.add("19");
                }

                if (!csfq20a.isChecked() && !csfq20b.isChecked() && !csfq20c.isChecked() && !csfq20d.isChecked() && !csfq20e.isChecked()) {
                    inputcheck.add("20");
                }


                if (!csfq21a.isChecked() && !csfq21b.isChecked() && !csfq21c.isChecked() && !csfq21d.isChecked() && !csfq21e.isChecked() && !csfq21f.isChecked()) {
                    inputcheck.add("21");
                }

                if (!csfq22a.isChecked() && !csfq22b.isChecked() && !csfq22c.isChecked() && !csfq22d.isChecked() && !csfq22e.isChecked()) {
                    inputcheck.add("22");
                }

                if (!csfq23a.isChecked() && !csfq23b.isChecked() && !csfq23c.isChecked() && !csfq23d.isChecked() && !csfq23e.isChecked() && !csfq23f.isChecked()) {
                    inputcheck.add("23");
                }

                if (!csfq24a.isChecked() && !csfq24b.isChecked() && !csfq24c.isChecked() && !csfq24d.isChecked() && !csfq24e.isChecked() && !csfq24f.isChecked()) {
                    inputcheck.add("24");
                }

                if (!csfq25a.isChecked() && !csfq25b.isChecked() && !csfq25c.isChecked() && !csfq25d.isChecked() && !csfq25e.isChecked() && !csfq25f.isChecked()) {
                    inputcheck.add("25");
                }

                if (!csfq26a.isChecked() && !csfq26b.isChecked() && !csfq26c.isChecked() && !csfq26d.isChecked() && !csfq26e.isChecked() && !csfq26f.isChecked()) {
                    inputcheck.add("26");
                }

                if (!csfq27a.isChecked() && !csfq27b.isChecked() && !csfq27c.isChecked() && !csfq27d.isChecked() && !csfq27e.isChecked() && !csfq27f.isChecked()) {
                    inputcheck.add("27");
                }

                if (!csfq28a.isChecked() && !csfq28b.isChecked() && !csfq28c.isChecked() && !csfq28d.isChecked() && !csfq28e.isChecked() && !csfq28f.isChecked()) {
                    inputcheck.add("28");
                }

                if (!csfq29a.isChecked() && !csfq29b.isChecked() && !csfq29c.isChecked() && !csfq29d.isChecked() && !csfq29e.isChecked() && !csfq29f.isChecked()) {
                    inputcheck.add("29");
                }

                if (!csfq30a.isChecked() && !csfq30b.isChecked() && !csfq30c.isChecked() && !csfq30d.isChecked() && !csfq30e.isChecked() && !csfq30f.isChecked()) {
                    inputcheck.add("30");
                }

                if (!csfq31a.isChecked() && !csfq31b.isChecked() && !csfq31c.isChecked() && !csfq31d.isChecked() && !csfq31e.isChecked() && !csfq31f.isChecked()) {
                    inputcheck.add("31");
                }

                if (!csfq32a.isChecked() && !csfq32b.isChecked() && !csfq32c.isChecked() && !csfq32d.isChecked() && !csfq32e.isChecked()) {
                    inputcheck.add("32");
                }

                if (!csfq33a.isChecked() && !csfq33b.isChecked() && !csfq33c.isChecked() && !csfq33d.isChecked() && !csfq33e.isChecked()) {
                    inputcheck.add("33");
                }

                if (!csfq34a.isChecked() && !csfq34b.isChecked() && !csfq34c.isChecked() && !csfq34d.isChecked() && !csfq34e.isChecked()) {
                    inputcheck.add("34");
                }

                if (!csfq35a.isChecked() && !csfq35b.isChecked() && !csfq35c.isChecked() && !csfq35d.isChecked() && !csfq35e.isChecked()) {
                    inputcheck.add("35");
                }

                if (!csfq36a.isChecked() && !csfq36b.isChecked() && !csfq36c.isChecked() && !csfq36d.isChecked() && !csfq36e.isChecked()) {
                    inputcheck.add("36");
                }

                joined = TextUtils.join(", ", inputcheck);

                if (inputcheck.size() > 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Please choose an answer for: " + joined);
                    alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // here you can add functions
                        }
                    });
                    alertDialog.setIcon(R.mipmap.ic_launcher2);
                    alertDialog.show();
                } else {

                    Intent Answers = new Intent(sf36.this, sf36conf.class);
                    Answers.putExtra("sfq1", sfq1);
                    Answers.putExtra("sfq2", sfq2);
                    Answers.putExtra("sfq3", sfq3);
                    Answers.putExtra("sfq4", sfq4);
                    Answers.putExtra("sfq5", sfq5);
                    Answers.putExtra("sfq6", sfq6);
                    Answers.putExtra("sfq7", sfq7);
                    Answers.putExtra("sfq8", sfq8);
                    Answers.putExtra("sfq9", sfq9);
                    Answers.putExtra("sfq10", sfq10);
                    Answers.putExtra("sfq11", sfq11);
                    Answers.putExtra("sfq12", sfq12);
                    Answers.putExtra("sfq13", sfq13);
                    Answers.putExtra("sfq14", sfq14);
                    Answers.putExtra("sfq15", sfq15);
                    Answers.putExtra("sfq16", sfq16);
                    Answers.putExtra("sfq17", sfq17);
                    Answers.putExtra("sfq18", sfq18);
                    Answers.putExtra("sfq19", sfq19);
                    Answers.putExtra("sfq20", sfq20);
                    Answers.putExtra("sfq21", sfq21);
                    Answers.putExtra("sfq22", sfq22);
                    Answers.putExtra("sfq23", sfq23);
                    Answers.putExtra("sfq24", sfq24);
                    Answers.putExtra("sfq25", sfq25);
                    Answers.putExtra("sfq26", sfq26);
                    Answers.putExtra("sfq27", sfq27);
                    Answers.putExtra("sfq28", sfq28);
                    Answers.putExtra("sfq29", sfq29);
                    Answers.putExtra("sfq30", sfq30);
                    Answers.putExtra("sfq31", sfq31);
                    Answers.putExtra("sfq32", sfq32);
                    Answers.putExtra("sfq33", sfq33);
                    Answers.putExtra("sfq34", sfq34);
                    Answers.putExtra("sfq35", sfq35);
                    Answers.putExtra("sfq36", sfq36);
                    Answers.putExtra("physicalfunction", physicalfunction);
                    Answers.putExtra("limitation_due_to_physical_health", limitation_due_to_physical_health);
                    Answers.putExtra("limitation_due_to_emotional_problem", limitation_due_to_emotional_problem);
                    Answers.putExtra("energy_fatigue", energy_fatigue);
                    Answers.putExtra("emotional_wellbeing", emotional_wellbeing);
                    Answers.putExtra("social_functioning", social_functioning);
                    Answers.putExtra("pain", pain);
                    Answers.putExtra("generalhealth", generalhealth);
                    Answers.putExtra("PatientID", PatID);
                    Answers.putExtra("Date", Date);
                    startActivity(Answers);

                }
                break;
        }
        physicalfunction = (sfq3 + sfq4 + sfq5 + sfq6 + sfq7 + sfq8 + sfq9 + sfq10 + sfq11 + sfq12) / 10;
        limitation_due_to_physical_health = (sfq13 + sfq14 + sfq15 + sfq16) / 4;
        limitation_due_to_emotional_problem = (sfq17 + sfq18 + sfq19) / 3;
        energy_fatigue = (sfq23 + sfq27 + sfq29 + sfq31) / 4;
        emotional_wellbeing = (sfq24 + sfq25 + sfq26 + sfq28 + sfq30) / 5;
        social_functioning = (sfq20 + sfq32) / 2;
        pain = (sfq21 + sfq22) / 2;
        generalhealth = (sfq1 + sfq33 + sfq34 + sfq35 + sfq36) / 5;


        ((TextView)findViewById(R.id.PhyFunc)).setText(String.format("%.2f", physicalfunction));
        ((TextView)findViewById(R.id.LimPhyHeal)).setText(String.format("%.2f", limitation_due_to_physical_health));
        ((TextView)findViewById(R.id.LimEmoPro)).setText(String.format("%.2f", limitation_due_to_emotional_problem));
        ((TextView)findViewById(R.id.EnFat)).setText(String.format("%.2f", energy_fatigue));
        ((TextView)findViewById(R.id.EmoWell)).setText(String.format("%.2f", emotional_wellbeing));
        ((TextView)findViewById(R.id.SocFunc)).setText(String.format("%.2f", social_functioning));
        ((TextView)findViewById(R.id.Pain)).setText(String.format("%.2f", pain));
        ((TextView) findViewById(R.id.GenHeal)).setText(String.format("%.2f", generalhealth));



    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Form")
                .setMessage("Are you sure you want to return to list of forms?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}