package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static java.lang.String.valueOf;

public class fuglmyer extends AppCompatActivity implements View.OnClickListener {

    Button bDone, bStart, bStop, bStart2, bStop2;

    Chronometer FuglMyerchronometer, FuglMyerchronometer2;

    String PatID, Date, Event, joined;

    TextView currentDateTimeString, patientID;
    
    
    double FMSE, FMWH, total, Q1a, Q1b, Q2a, Q2b, Q2c, Q2d, Q2e, Q2f, Q3a, Q3b, Q3c, Q4a, Q4b, Q4c, Q5a, Q5b, Q5c, Q6a,
            Q7a, Q8a, Q9a, Q10a, Q11a, Q12a, Q12b, Q13a, Q14a, Q14b, Q14c, Q14d, Q15a, Q15b, Q15c,
            TimeE1, TimeE2, TimeDiff, MSeconds;

    String[] Times;
    Chronometer[] chronometers;
    double[] fTimes;

    RadioButton radiobutton1a0, radiobutton1a2, radiobutton1b0, radiobutton1b2, radiobutton2a0,
            radiobutton2a1, radiobutton2a2, radiobutton2b0, radiobutton2b1, radiobutton2b2, radiobutton2c0, radiobutton2c1, radiobutton2c2,
            radiobutton2d0, radiobutton2d1, radiobutton2d2, radiobutton2e0, radiobutton2e1, radiobutton2e2, radiobutton2f0, radiobutton2f1,
            radiobutton2f2, radiobutton3a0, radiobutton3a1, radiobutton3a2, radiobutton3b0, radiobutton3b1, radiobutton3b2, radiobutton3c0,
            radiobutton3c1, radiobutton3c2, radiobutton4a0, radiobutton4a1, radiobutton4a2, radiobutton4b0, radiobutton4b1, radiobutton4b2,
            radiobutton4c0, radiobutton4c1, radiobutton4c2, radiobutton5a0, radiobutton5a1, radiobutton5a2, radiobutton5b0, radiobutton5b1,
            radiobutton5b2, radiobutton5c0, radiobutton5c1,
            radiobutton5c2, radiobutton6a0, radiobutton6a1, radiobutton6a2, radiobutton7a0, radiobutton7a1, radiobutton7a2, radiobutton8a0,
            radiobutton8a1, radiobutton8a2, radiobutton9a0, radiobutton9a1, radiobutton9a2, radiobutton10a0, radiobutton10a1, radiobutton10a2,
            radiobutton11a0, radiobutton11a1, radiobutton11a2, radiobutton12a0, radiobutton12a1, radiobutton12a2, radiobutton12b0, radiobutton12b1,
            radiobutton12b2, radiobutton13a0, radiobutton13a1, radiobutton13a2, radiobutton14a0, radiobutton14a1, radiobutton14a2, radiobutton14b0,
            radiobutton14b1, radiobutton14b2, radiobutton14c0, radiobutton14c1, radiobutton14c2, radiobutton14d0, radiobutton14d1, radiobutton14d2,
            radiobutton15a0, radiobutton15a1, radiobutton15a2, radiobutton15b0, radiobutton15b1, radiobutton15b2, radiobutton15c0, radiobutton15c1,
            radiobutton15c2, 
            RadioButtonADM, RadioButtonDC, RadioButtonFU, RadioButtonMP, RadioButtonPP1, RadioButtonPP2;

    ArrayList<String> inputcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuglmyer);




        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);


        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Date: " + Date);

        FuglMyerchronometer = (Chronometer) findViewById(R.id.FuglMyerchronometer);
        FuglMyerchronometer2 = (Chronometer) findViewById(R.id.FuglMyerchronometer2);

        chronometers = new Chronometer[2];
        chronometers[0] = FuglMyerchronometer;
        chronometers[1] = FuglMyerchronometer2;

        FuglMyerchronometer.setOnClickListener(this);
        FuglMyerchronometer2.setOnClickListener(this);

        Event = "NULL";

        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);
        bStart = (Button) findViewById(R.id.bStart);
        bStart.setOnClickListener(this);
        bStop = (Button) findViewById(R.id.bStop);
        bStop.setOnClickListener(this);
        bStop.setEnabled(false);
        bStart2 = (Button) findViewById(R.id.bStart2);
        bStart2.setOnClickListener(this);
        bStop2 = (Button) findViewById(R.id.bStop2);
        bStop2.setOnClickListener(this);
        bStop2.setEnabled(false);

        TimeE1 = Double.parseDouble("0");
        TimeE2 = Double.parseDouble("0");

        fTimes = new double[2];
        fTimes[0] = TimeE1;
        fTimes[1] = TimeE2;

        RadioButtonADM = (RadioButton) findViewById(R.id.RadioButtonADM);
        RadioButtonPP1 = (RadioButton) findViewById(R.id.RadioButtonPP1);
        RadioButtonPP2 = (RadioButton) findViewById(R.id.RadioButtonPP2);
        RadioButtonMP = (RadioButton) findViewById(R.id.RadioButtonMP);
        RadioButtonFU = (RadioButton) findViewById(R.id.RadioButtonFU);
        RadioButtonDC = (RadioButton) findViewById(R.id.RadioButtonDC);


        {
            radiobutton1a0 = (RadioButton) findViewById(R.id.RadioButton1a0);
            radiobutton1a2 = (RadioButton) findViewById(R.id.RadioButton1a2);
            radiobutton1b0 = (RadioButton) findViewById(R.id.RadioButton1b0);
            radiobutton1b2 = (RadioButton) findViewById(R.id.RadioButton1b2);
            radiobutton2a0 = (RadioButton) findViewById(R.id.RadioButton2a0);
            radiobutton2a1 = (RadioButton) findViewById(R.id.RadioButton2a1);
            radiobutton2a2 = (RadioButton) findViewById(R.id.RadioButton2a2);
            radiobutton2b0 = (RadioButton) findViewById(R.id.RadioButton2b0);
            radiobutton2b1 = (RadioButton) findViewById(R.id.RadioButton2b1);
            radiobutton2b2 = (RadioButton) findViewById(R.id.RadioButton2b2);
            radiobutton2c0 = (RadioButton) findViewById(R.id.RadioButton2c0);
            radiobutton2c1 = (RadioButton) findViewById(R.id.RadioButton2c1);
            radiobutton2c2 = (RadioButton) findViewById(R.id.RadioButton2c2);
            radiobutton2d0 = (RadioButton) findViewById(R.id.RadioButton2d0);
            radiobutton2d1 = (RadioButton) findViewById(R.id.RadioButton2d1);
            radiobutton2d2 = (RadioButton) findViewById(R.id.RadioButton2d2);
            radiobutton2e0 = (RadioButton) findViewById(R.id.RadioButton2e0);
            radiobutton2e1 = (RadioButton) findViewById(R.id.RadioButton2e1);
            radiobutton2e2 = (RadioButton) findViewById(R.id.RadioButton2e2);
            radiobutton2f0 = (RadioButton) findViewById(R.id.RadioButton2f0);
            radiobutton2f1 = (RadioButton) findViewById(R.id.RadioButton2f1);
            radiobutton2f2 = (RadioButton) findViewById(R.id.RadioButton2f2);
            radiobutton3a0 = (RadioButton) findViewById(R.id.RadioButton3a0);
            radiobutton3a1 = (RadioButton) findViewById(R.id.RadioButton3a1);
            radiobutton3a2 = (RadioButton) findViewById(R.id.RadioButton3a2);
            radiobutton3b0 = (RadioButton) findViewById(R.id.RadioButton3b0);
            radiobutton3b1 = (RadioButton) findViewById(R.id.RadioButton3b1);
            radiobutton3b2 = (RadioButton) findViewById(R.id.RadioButton3b2);
            radiobutton3c0 = (RadioButton) findViewById(R.id.RadioButton3c0);
            radiobutton3c1 = (RadioButton) findViewById(R.id.RadioButton3c1);
            radiobutton3c2 = (RadioButton) findViewById(R.id.RadioButton3c2);
            radiobutton4a0 = (RadioButton) findViewById(R.id.RadioButton4a0);
            radiobutton4a1 = (RadioButton) findViewById(R.id.RadioButton4a1);
            radiobutton4a2 = (RadioButton) findViewById(R.id.RadioButton4a2);
            radiobutton4b0 = (RadioButton) findViewById(R.id.RadioButton4b0);
            radiobutton4b1 = (RadioButton) findViewById(R.id.RadioButton4b1);
            radiobutton4b2 = (RadioButton) findViewById(R.id.RadioButton4b2);
            radiobutton4c0 = (RadioButton) findViewById(R.id.RadioButton4c0);
            radiobutton4c1 = (RadioButton) findViewById(R.id.RadioButton4c1);
            radiobutton4c2 = (RadioButton) findViewById(R.id.RadioButton4c2);
            radiobutton5a0 = (RadioButton) findViewById(R.id.RadioButton5a0);
            radiobutton5a1 = (RadioButton) findViewById(R.id.RadioButton5a1);
            radiobutton5a2 = (RadioButton) findViewById(R.id.RadioButton5a2);
            radiobutton5b0 = (RadioButton) findViewById(R.id.RadioButton5b0);
            radiobutton5b1 = (RadioButton) findViewById(R.id.RadioButton5b1);
            radiobutton5b2 = (RadioButton) findViewById(R.id.RadioButton5b2);
            radiobutton5c0 = (RadioButton) findViewById(R.id.RadioButton5c0);
            radiobutton5c1 = (RadioButton) findViewById(R.id.RadioButton5c1);
            radiobutton5c2 = (RadioButton) findViewById(R.id.RadioButton5c2);
            radiobutton6a0 = (RadioButton) findViewById(R.id.RadioButton6a0);
            radiobutton6a1 = (RadioButton) findViewById(R.id.RadioButton6a1);
            radiobutton6a2 = (RadioButton) findViewById(R.id.RadioButton6a2);
            radiobutton7a0 = (RadioButton) findViewById(R.id.RadioButton7a0);
            radiobutton7a1 = (RadioButton) findViewById(R.id.RadioButton7a1);
            radiobutton7a2 = (RadioButton) findViewById(R.id.RadioButton7a2);
            radiobutton8a0 = (RadioButton) findViewById(R.id.RadioButton8a0);
            radiobutton8a1 = (RadioButton) findViewById(R.id.RadioButton8a1);
            radiobutton8a2 = (RadioButton) findViewById(R.id.RadioButton8a2);
            radiobutton9a0 = (RadioButton) findViewById(R.id.RadioButton9a0);
            radiobutton9a1 = (RadioButton) findViewById(R.id.RadioButton9a1);
            radiobutton9a2 = (RadioButton) findViewById(R.id.RadioButton9a2);
            radiobutton10a0 = (RadioButton) findViewById(R.id.RadioButton10a0);
            radiobutton10a1 = (RadioButton) findViewById(R.id.RadioButton10a1);
            radiobutton10a2 = (RadioButton) findViewById(R.id.RadioButton10a2);
            radiobutton11a0 = (RadioButton) findViewById(R.id.RadioButton11a0);
            radiobutton11a1 = (RadioButton) findViewById(R.id.RadioButton11a1);
            radiobutton11a2 = (RadioButton) findViewById(R.id.RadioButton11a2);
            radiobutton12a0 = (RadioButton) findViewById(R.id.RadioButton12a0);
            radiobutton12a1 = (RadioButton) findViewById(R.id.RadioButton12a1);
            radiobutton12a2 = (RadioButton) findViewById(R.id.RadioButton12a2);
            radiobutton12b0 = (RadioButton) findViewById(R.id.RadioButton12b0);
            radiobutton12b1 = (RadioButton) findViewById(R.id.RadioButton12b1);
            radiobutton12b2 = (RadioButton) findViewById(R.id.RadioButton12b2);
            radiobutton13a0 = (RadioButton) findViewById(R.id.RadioButton13a0);
            radiobutton13a1 = (RadioButton) findViewById(R.id.RadioButton13a1);
            radiobutton13a2 = (RadioButton) findViewById(R.id.RadioButton13a2);
            radiobutton14a0 = (RadioButton) findViewById(R.id.RadioButton14a0);
            radiobutton14a1 = (RadioButton) findViewById(R.id.RadioButton14a1);
            radiobutton14a2 = (RadioButton) findViewById(R.id.RadioButton14a2);
            radiobutton14b0 = (RadioButton) findViewById(R.id.RadioButton14b0);
            radiobutton14b1 = (RadioButton) findViewById(R.id.RadioButton14b1);
            radiobutton14b2 = (RadioButton) findViewById(R.id.RadioButton14b2);
            radiobutton14c0 = (RadioButton) findViewById(R.id.RadioButton14c0);
            radiobutton14c1 = (RadioButton) findViewById(R.id.RadioButton14c1);
            radiobutton14c2 = (RadioButton) findViewById(R.id.RadioButton14c2);
            radiobutton14d0 = (RadioButton) findViewById(R.id.RadioButton14d0);
            radiobutton14d1 = (RadioButton) findViewById(R.id.RadioButton14d1);
            radiobutton14d2 = (RadioButton) findViewById(R.id.RadioButton14d2);
            radiobutton15a0 = (RadioButton) findViewById(R.id.RadioButton15a0);
            radiobutton15a1 = (RadioButton) findViewById(R.id.RadioButton15a1);
            radiobutton15a2 = (RadioButton) findViewById(R.id.RadioButton15a2);
            radiobutton15b0 = (RadioButton) findViewById(R.id.RadioButton15b0);
            radiobutton15b1 = (RadioButton) findViewById(R.id.RadioButton15b1);
            radiobutton15b2 = (RadioButton) findViewById(R.id.RadioButton15b2);
            radiobutton15c0 = (RadioButton) findViewById(R.id.RadioButton15c0);
            radiobutton15c1 = (RadioButton) findViewById(R.id.RadioButton15c1);
            radiobutton15c2 = (RadioButton) findViewById(R.id.RadioButton15c2);



        }

        {
            radiobutton1a0.setOnClickListener(this);
            radiobutton1a2.setOnClickListener(this);
            radiobutton1b0.setOnClickListener(this);
            radiobutton1b2.setOnClickListener(this);
            radiobutton2a0.setOnClickListener(this);
            radiobutton2a1.setOnClickListener(this);
            radiobutton2a2.setOnClickListener(this);
            radiobutton2b0.setOnClickListener(this);
            radiobutton2b1.setOnClickListener(this);
            radiobutton2b2.setOnClickListener(this);
            radiobutton2c0.setOnClickListener(this);
            radiobutton2c1.setOnClickListener(this);
            radiobutton2c2.setOnClickListener(this);
            radiobutton2d0.setOnClickListener(this);
            radiobutton2d1.setOnClickListener(this);
            radiobutton2d2.setOnClickListener(this);
            radiobutton2e0.setOnClickListener(this);
            radiobutton2e1.setOnClickListener(this);
            radiobutton2e2.setOnClickListener(this);
            radiobutton2f0.setOnClickListener(this);
            radiobutton2f1.setOnClickListener(this);
            radiobutton2f2.setOnClickListener(this);
            radiobutton3a0.setOnClickListener(this);
            radiobutton3a1.setOnClickListener(this);
            radiobutton3a2.setOnClickListener(this);
            radiobutton3b0.setOnClickListener(this);
            radiobutton3b1.setOnClickListener(this);
            radiobutton3b2.setOnClickListener(this);
            radiobutton3c0.setOnClickListener(this);
            radiobutton3c1.setOnClickListener(this);
            radiobutton3c2.setOnClickListener(this);
            radiobutton4a0.setOnClickListener(this);
            radiobutton4a1.setOnClickListener(this);
            radiobutton4a2.setOnClickListener(this);
            radiobutton4b0.setOnClickListener(this);
            radiobutton4b1.setOnClickListener(this);
            radiobutton4b2.setOnClickListener(this);
            radiobutton4c0.setOnClickListener(this);
            radiobutton4c1.setOnClickListener(this);
            radiobutton4c2.setOnClickListener(this);
            radiobutton5a0.setOnClickListener(this);
            radiobutton5a1.setOnClickListener(this);
            radiobutton5a2.setOnClickListener(this);
            radiobutton5b0.setOnClickListener(this);
            radiobutton5b1.setOnClickListener(this);
            radiobutton5b2.setOnClickListener(this);
            radiobutton5c0.setOnClickListener(this);
            radiobutton5c1.setOnClickListener(this);
            radiobutton5c2.setOnClickListener(this);
            radiobutton6a0.setOnClickListener(this);
            radiobutton6a1.setOnClickListener(this);
            radiobutton6a2.setOnClickListener(this);
            radiobutton7a0.setOnClickListener(this);
            radiobutton7a1.setOnClickListener(this);
            radiobutton7a2.setOnClickListener(this);
            radiobutton8a0.setOnClickListener(this);
            radiobutton8a1.setOnClickListener(this);
            radiobutton8a2.setOnClickListener(this);
            radiobutton9a0.setOnClickListener(this);
            radiobutton9a1.setOnClickListener(this);
            radiobutton9a2.setOnClickListener(this);
            radiobutton10a0.setOnClickListener(this);
            radiobutton10a1.setOnClickListener(this);
            radiobutton10a2.setOnClickListener(this);
            radiobutton11a0.setOnClickListener(this);
            radiobutton11a1.setOnClickListener(this);
            radiobutton11a2.setOnClickListener(this);
            radiobutton12a0.setOnClickListener(this);
            radiobutton12a1.setOnClickListener(this);
            radiobutton12a2.setOnClickListener(this);
            radiobutton12b0.setOnClickListener(this);
            radiobutton12b1.setOnClickListener(this);
            radiobutton12b2.setOnClickListener(this);
            radiobutton13a0.setOnClickListener(this);
            radiobutton13a1.setOnClickListener(this);
            radiobutton13a2.setOnClickListener(this);
            radiobutton14a0.setOnClickListener(this);
            radiobutton14a1.setOnClickListener(this);
            radiobutton14a2.setOnClickListener(this);
            radiobutton14b0.setOnClickListener(this);
            radiobutton14b1.setOnClickListener(this);
            radiobutton14b2.setOnClickListener(this);
            radiobutton14c0.setOnClickListener(this);
            radiobutton14c1.setOnClickListener(this);
            radiobutton14c2.setOnClickListener(this);
            radiobutton14d0.setOnClickListener(this);
            radiobutton14d1.setOnClickListener(this);
            radiobutton14d2.setOnClickListener(this);
            radiobutton15a0.setOnClickListener(this);
            radiobutton15a1.setOnClickListener(this);
            radiobutton15a2.setOnClickListener(this);
            radiobutton15b0.setOnClickListener(this);
            radiobutton15b1.setOnClickListener(this);
            radiobutton15b2.setOnClickListener(this);
            radiobutton15c0.setOnClickListener(this);
            radiobutton15c1.setOnClickListener(this);
            radiobutton15c2.setOnClickListener(this);



        }




    }

    public void Event(View view){

        switch (view.getId()){

            case R.id.RadioButtonPP1:
                Event = "pp1_arm_1";
                break;
            case R.id.RadioButtonPP2:
                Event = "pp2_arm_1";
                break;
            case R.id.RadioButtonFU:
                Event = "fu_arm_1";
                break;
            case R.id.RadioButtonDC:
                Event = "dc_arm_1";
                break;
            case R.id.RadioButtonMP:
                Event = "mp_arm_1";
                break;
            case R.id.RadioButtonADM:
                Event = "adm_arm_1";
                break;
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.bStart:
                FuglMyerchronometer.setBase(SystemClock.elapsedRealtime());
                FuglMyerchronometer.start();
                bStop.setEnabled(true);
                bStart.setEnabled(false);
                break;
            case R.id.bStop:
                FuglMyerchronometer.stop();
                bStop.setEnabled(false);
                bStart.setEnabled(true);
                fTimes[0] = FuglMyerchronometer.getTimeElapsed();
                TimeDiff = fTimes[0] / 1000 - fTimes[1] / 1000;
                TimeDiff = (TimeDiff < 0) ? -TimeDiff : TimeDiff;
                ((TextView)findViewById(R.id.TimeDifference)).setText(String.format("%.3f", TimeDiff) + " seconds");
                break;

            case R.id.bStart2:
                FuglMyerchronometer2.setBase(SystemClock.elapsedRealtime());
                FuglMyerchronometer2.start();
                bStop2.setEnabled(true);
                bStart2.setEnabled(false);
                break;
            case R.id.bStop2:
                FuglMyerchronometer2.stop();
                bStop2.setEnabled(false);
                bStart2.setEnabled(true);
                fTimes[1] = FuglMyerchronometer2.getTimeElapsed();
                TimeDiff = fTimes[0] / 1000 - fTimes[1] / 1000;
                TimeDiff = (TimeDiff < 0) ? -TimeDiff : TimeDiff;
                ((TextView)findViewById(R.id.TimeDifference)).setText(String.format("%.3f", TimeDiff) + " seconds");
                break;

            case R.id.FuglMyerchronometer:
                FMinputTimes(0);
                break;
            case R.id.FuglMyerchronometer2:
                FMinputTimes(1);
                break;

        }


        switch (v.getId()){
            case R.id.bDone:



                inputcheck = new ArrayList<>();

                if (!RadioButtonADM.isChecked() && !RadioButtonDC.isChecked() && !RadioButtonFU.isChecked() &&!RadioButtonMP.isChecked() && !RadioButtonPP1.isChecked() && !RadioButtonPP2.isChecked()) {
                    inputcheck.add("Session");
                }

                if (!radiobutton1a0.isChecked() && !radiobutton1a2.isChecked()) {
                    inputcheck.add("FM/SE 1a");
                }

                if (!radiobutton1b0.isChecked() && !radiobutton1b2.isChecked()) {
                    inputcheck.add("FM/SE 1b");
                }

                if (!radiobutton2a0.isChecked() && !radiobutton2a1.isChecked() && !radiobutton2a2.isChecked()) {
                    inputcheck.add("FM/SE 2a");
                }

                if (!radiobutton2b0.isChecked() && !radiobutton2b1.isChecked() && !radiobutton2b2.isChecked()) {
                    inputcheck.add("FM/SE 2b");
                }

                if (!radiobutton2c0.isChecked() && !radiobutton2c1.isChecked() && !radiobutton2c2.isChecked()) {
                    inputcheck.add("FM/SE 2c");
                }

                if (!radiobutton2d0.isChecked() && !radiobutton2d1.isChecked() && !radiobutton2d2.isChecked()) {
                    inputcheck.add("FM/SE 2d");
                }

                if (!radiobutton2e0.isChecked() && !radiobutton2e1.isChecked() && !radiobutton2e2.isChecked()) {
                    inputcheck.add("FM/SE 2e");
                }

                if (!radiobutton2f0.isChecked() && !radiobutton2f1.isChecked() && !radiobutton2f2.isChecked()) {
                    inputcheck.add("FM/SE 2f");
                }

                if (!radiobutton3a0.isChecked() && !radiobutton3a1.isChecked() && !radiobutton3a2.isChecked()) {
                    inputcheck.add("FM/SE 3a");
                }

                if (!radiobutton3b0.isChecked() && !radiobutton3b1.isChecked() && !radiobutton3b2.isChecked()) {
                    inputcheck.add("FM/SE 3b");
                }

                if (!radiobutton3c0.isChecked() && !radiobutton3c1.isChecked() && !radiobutton3c2.isChecked()) {
                    inputcheck.add("FM/SE 3c");
                }

                if (!radiobutton4a0.isChecked() && !radiobutton4a1.isChecked() && !radiobutton4a2.isChecked()) {
                    inputcheck.add("FM/SE 4a");
                }

                if (!radiobutton4b0.isChecked() && !radiobutton4b1.isChecked() && !radiobutton4b2.isChecked()) {
                    inputcheck.add("FM/SE 4b");
                }

                if (!radiobutton4c0.isChecked() && !radiobutton4c1.isChecked() && !radiobutton4c2.isChecked()) {
                    inputcheck.add("FM/SE 4c");
                }

                if (!radiobutton5a0.isChecked() && !radiobutton5a1.isChecked() && !radiobutton5a2.isChecked()) {
                    inputcheck.add("FM/SE 5a");
                }

                if (!radiobutton5b0.isChecked() && !radiobutton5b1.isChecked() && !radiobutton5b2.isChecked()) {
                    inputcheck.add("FM/SE 5b");
                }

                if (!radiobutton5c0.isChecked() && !radiobutton5c1.isChecked() && !radiobutton5c2.isChecked()) {
                    inputcheck.add("FM/SE 5c");
                }

                
                
                if (!radiobutton6a0.isChecked() && !radiobutton6a1.isChecked() && !radiobutton6a2.isChecked()) {
                    inputcheck.add("FM/SE 6a");
                }


                if (!radiobutton7a0.isChecked() && !radiobutton7a1.isChecked() && !radiobutton7a2.isChecked()) {
                    inputcheck.add("FM/WH 1");
                }

                if (!radiobutton8a0.isChecked() && !radiobutton8a1.isChecked() && !radiobutton8a2.isChecked()) {
                    inputcheck.add("FM/WH 2");
                }

                if (!radiobutton9a0.isChecked() && !radiobutton9a1.isChecked() && !radiobutton9a2.isChecked()) {
                    inputcheck.add("FM/WH 3");
                }

                if (!radiobutton10a0.isChecked() && !radiobutton10a1.isChecked() && !radiobutton10a2.isChecked()) {
                    inputcheck.add("FM/WH 4");
                }

                if (!radiobutton11a0.isChecked() && !radiobutton11a1.isChecked() && !radiobutton11a2.isChecked()) {
                    inputcheck.add("FM/WH 5");
                }


                if (!radiobutton12a0.isChecked() && !radiobutton12a1.isChecked() && !radiobutton12a2.isChecked()) {
                    inputcheck.add("FM/WH 6a");
                }

                if (!radiobutton12b0.isChecked() && !radiobutton12b1.isChecked() && !radiobutton12b2.isChecked()) {
                    inputcheck.add("FM/WH 6b");
                }

                if (!radiobutton13a0.isChecked() && !radiobutton13a1.isChecked() && !radiobutton13a2.isChecked()) {
                    inputcheck.add("FM/WH 7");
                }


                if (!radiobutton14a0.isChecked() && !radiobutton14a1.isChecked() && !radiobutton14a2.isChecked()) {
                    inputcheck.add("FM/WH 8a");
                }

                if (!radiobutton14b0.isChecked() && !radiobutton14b1.isChecked() && !radiobutton14b2.isChecked()) {
                    inputcheck.add("FM/WH 8b");
                }

                if (!radiobutton14c0.isChecked() && !radiobutton14c1.isChecked() && !radiobutton14c2.isChecked()) {
                    inputcheck.add("FM/WH 8c");
                }

                if (!radiobutton14d0.isChecked() && !radiobutton14d1.isChecked() && !radiobutton14d2.isChecked()) {
                    inputcheck.add("FM/WH 8d");
                }

                if (!radiobutton15a0.isChecked() && !radiobutton15a1.isChecked() && !radiobutton15a2.isChecked()) {
                    inputcheck.add("FM/WH 9a");
                }

                if (!radiobutton15b0.isChecked() && !radiobutton15b1.isChecked() && !radiobutton15b2.isChecked()) {
                    inputcheck.add("FM/WH 9b");
                }

                if (!radiobutton15c0.isChecked() && !radiobutton15c1.isChecked() && !radiobutton15c2.isChecked()) {
                    inputcheck.add("FM/WH 9c");
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
                    Intent Answers = new Intent(fuglmyer.this, fuglmyerconf.class);
                    Answers.putExtra("Q1a", Q1a);
                    Answers.putExtra("Q1b", Q1b);
                    Answers.putExtra("Q2a", Q2a);
                    Answers.putExtra("Q2b", Q2b);
                    Answers.putExtra("Q2c", Q2c);
                    Answers.putExtra("Q2d", Q2d);
                    Answers.putExtra("Q2e", Q2e);
                    Answers.putExtra("Q2f", Q2f);
                    Answers.putExtra("Q3a", Q3a);
                    Answers.putExtra("Q3b", Q3b);
                    Answers.putExtra("Q3c", Q3c);
                    Answers.putExtra("Q4a", Q4a);
                    Answers.putExtra("Q4b", Q4b);
                    Answers.putExtra("Q4c", Q4c);
                    Answers.putExtra("Q5a", Q5a);
                    Answers.putExtra("Q5b", Q5b);
                    Answers.putExtra("Q5c", Q5c);
                    Answers.putExtra("Q6a", Q6a);
                    Answers.putExtra("Q7a", Q7a);
                    Answers.putExtra("Q8a", Q8a);
                    Answers.putExtra("Q9a", Q9a);
                    Answers.putExtra("Q10a", Q10a);
                    Answers.putExtra("Q11a", Q11a);
                    Answers.putExtra("Q12a", Q12a);
                    Answers.putExtra("Q12b", Q12b);
                    Answers.putExtra("Q13a", Q13a);
                    Answers.putExtra("Q14a", Q14a);
                    Answers.putExtra("Q14b", Q14b);
                    Answers.putExtra("Q14c", Q14c);
                    Answers.putExtra("Q14d", Q14d);
                    Answers.putExtra("Q15a", Q15a);
                    Answers.putExtra("Q15b", Q15b);
                    Answers.putExtra("Q15c", Q15c);
                    Answers.putExtra("FMSE", FMSE);
                    Answers.putExtra("FMWH", FMWH);
                    Answers.putExtra("total", total);
                    Answers.putExtra("TimeE1", fTimes[0]);
                    Answers.putExtra("TimeE2", fTimes[1]);
                    Answers.putExtra("TimeDiff", TimeDiff);

                    Answers.putExtra("PatientID", PatID);
                    Answers.putExtra("Date", Date);
                    Answers.putExtra("Event", Event);
                    startActivity(Answers);
                }

                break;
        }

        switch (v.getId()){
            case R.id.RadioButton1a0:
                radiobutton1a2.setChecked(false);
                if (radiobutton1a0.isChecked()){
                    Q1a = Double.parseDouble("0");
                }
                else {Q1a = Double.parseDouble("0");}

                break;
            case R.id.RadioButton1a2:
                radiobutton1a0.setChecked(false);
                if (radiobutton1a2.isChecked()){
                    Q1a = Double.parseDouble("2");
                }
                else {Q1a = Double.parseDouble("0");}
                break;
        }
        switch (v.getId()){
            case R.id.RadioButton1b0:
                radiobutton1b2.setChecked(false);
                if (radiobutton1b0.isChecked()){
                    Q1b = Double.parseDouble("0");
                }
                else {Q1b = Double.parseDouble("0");}
                break;
            case R.id.RadioButton1b2:
                radiobutton1b0.setChecked(false);
                if (radiobutton1b2.isChecked()){
                    Q1b = Double.parseDouble("2");
                }
                else {Q1b = Double.parseDouble("0");}
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2a0:
                radiobutton2a1.setChecked(false);
                radiobutton2a2.setChecked(false);
                if (radiobutton2a0.isChecked()) {
                    Q2a = Double.parseDouble("0");
                } else {
                    Q2a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2a1:
                radiobutton2a0.setChecked(false);
                radiobutton2a2.setChecked(false);
                if (radiobutton2a1.isChecked()) {
                    Q2a = Double.parseDouble("1");
                } else {
                    Q2a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2a2:
                radiobutton2a1.setChecked(false);
                radiobutton2a0.setChecked(false);
                if (radiobutton2a2.isChecked()) {
                    Q2a = Double.parseDouble("2");
                } else {
                    Q2a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2b0:
                radiobutton2b1.setChecked(false);
                radiobutton2b2.setChecked(false);
                if (radiobutton2b0.isChecked()) {
                    Q2b = Double.parseDouble("0");
                } else {
                    Q2b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2b1:
                radiobutton2b0.setChecked(false);
                radiobutton2b2.setChecked(false);
                if (radiobutton2b1.isChecked()) {
                    Q2b = Double.parseDouble("1");
                } else {
                    Q2b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2b2:
                radiobutton2b1.setChecked(false);
                radiobutton2b0.setChecked(false);
                if (radiobutton2b2.isChecked()) {
                    Q2b = Double.parseDouble("2");
                } else {
                    Q2b = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2c0:
                radiobutton2c1.setChecked(false);
                radiobutton2c2.setChecked(false);
                if (radiobutton2c0.isChecked()) {
                    Q2c = Double.parseDouble("0");
                } else {
                    Q2c = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2c1:
                radiobutton2c0.setChecked(false);
                radiobutton2c2.setChecked(false);
                if (radiobutton2c1.isChecked()) {
                    Q2c = Double.parseDouble("1");
                } else {
                    Q2c = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2c2:
                radiobutton2c1.setChecked(false);
                radiobutton2c0.setChecked(false);
                if (radiobutton2c2.isChecked()) {
                    Q2c = Double.parseDouble("2");
                } else {
                    Q2c = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2d0:
                radiobutton2d1.setChecked(false);
                radiobutton2d2.setChecked(false);
                if (radiobutton2d0.isChecked()) {
                    Q2d = Double.parseDouble("0");
                } else {
                    Q2d = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2d1:
                radiobutton2d0.setChecked(false);
                radiobutton2d2.setChecked(false);
                if (radiobutton2d1.isChecked()) {
                    Q2d = Double.parseDouble("1");
                } else {
                    Q2d = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2d2:
                radiobutton2d1.setChecked(false);
                radiobutton2d0.setChecked(false);
                if (radiobutton2d2.isChecked()) {
                    Q2d = Double.parseDouble("2");
                } else {
                    Q2d = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2e0:
                radiobutton2e1.setChecked(false);
                radiobutton2e2.setChecked(false);
                if (radiobutton2e0.isChecked()) {
                    Q2e = Double.parseDouble("0");
                } else {
                    Q2e = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2e1:
                radiobutton2e0.setChecked(false);
                radiobutton2e2.setChecked(false);
                if (radiobutton2e1.isChecked()) {
                    Q2e = Double.parseDouble("1");
                } else {
                    Q2e = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2e2:
                radiobutton2e1.setChecked(false);
                radiobutton2e0.setChecked(false);
                if (radiobutton2e2.isChecked()) {
                    Q2e = Double.parseDouble("2");
                } else {
                    Q2e = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton2f0:
                radiobutton2f1.setChecked(false);
                radiobutton2f2.setChecked(false);
                if (radiobutton2f0.isChecked()) {
                    Q2f = Double.parseDouble("0");
                } else {
                    Q2f = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2f1:
                radiobutton2f0.setChecked(false);
                radiobutton2f2.setChecked(false);
                if (radiobutton2f1.isChecked()) {
                    Q2f = Double.parseDouble("1");
                } else {
                    Q2f = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton2f2:
                radiobutton2f1.setChecked(false);
                radiobutton2f0.setChecked(false);
                if (radiobutton2f2.isChecked()) {
                    Q2f = Double.parseDouble("2");
                } else {
                    Q2f = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton3a0:
                radiobutton3a1.setChecked(false);
                radiobutton3a2.setChecked(false);
                if (radiobutton3a0.isChecked()) {
                    Q3a = Double.parseDouble("0");
                } else {
                    Q3a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton3a1:
                radiobutton3a0.setChecked(false);
                radiobutton3a2.setChecked(false);
                if (radiobutton3a1.isChecked()) {
                    Q3a = Double.parseDouble("1");
                } else {
                    Q3a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton3a2:
                radiobutton3a0.setChecked(false);
                radiobutton3a1.setChecked(false);
                if (radiobutton3a2.isChecked()) {
                    Q3a = Double.parseDouble("2");
                } else {
                    Q3a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton3b0:
                radiobutton3b1.setChecked(false);
                radiobutton3b2.setChecked(false);
                if (radiobutton3b0.isChecked()) {
                    Q3b = Double.parseDouble("0");
                } else {
                    Q3b = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton3b1:
                radiobutton3b0.setChecked(false);
                radiobutton3b2.setChecked(false);
                if (radiobutton3b1.isChecked()) {
                    Q3b = Double.parseDouble("1");
                } else {
                    Q3b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton3b2:
                radiobutton3b0.setChecked(false);
                radiobutton3b1.setChecked(false);
                if (radiobutton3b2.isChecked()) {
                    Q3b = Double.parseDouble("2");
                } else {
                    Q3b = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton3c0:
                radiobutton3c1.setChecked(false);
                radiobutton3c2.setChecked(false);
                if (radiobutton3c0.isChecked()) {
                    Q3c = Double.parseDouble("0");
                } else {
                    Q3c = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton3c1:
                radiobutton3c0.setChecked(false);
                radiobutton3c2.setChecked(false);
                if (radiobutton3c1.isChecked()) {
                    Q3c = Double.parseDouble("1");
                } else {
                    Q3c = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton3c2:
                radiobutton3c0.setChecked(false);
                radiobutton3c1.setChecked(false);
                if (radiobutton3c2.isChecked()) {
                    Q3c = Double.parseDouble("2");
                } else {
                    Q3c = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton4a0:
                radiobutton4a1.setChecked(false);
                radiobutton4a2.setChecked(false);
                if (radiobutton4a0.isChecked()) {
                    Q4a = Double.parseDouble("0");
                } else {
                    Q4a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton4a1:
                radiobutton4a0.setChecked(false);
                radiobutton4a2.setChecked(false);
                if (radiobutton4a1.isChecked()) {
                    Q4a = Double.parseDouble("1");
                } else {
                    Q4a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton4a2:
                radiobutton4a0.setChecked(false);
                radiobutton4a1.setChecked(false);
                if (radiobutton4a2.isChecked()) {
                    Q4a = Double.parseDouble("2");
                } else {
                    Q4a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton4b0:
                radiobutton4b1.setChecked(false);
                radiobutton4b2.setChecked(false);
                if (radiobutton4b0.isChecked()) {
                    Q4b = Double.parseDouble("0");
                } else {
                    Q4b = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton4b1:
                radiobutton4b0.setChecked(false);
                radiobutton4b2.setChecked(false);
                if (radiobutton4b1.isChecked()) {
                    Q4b = Double.parseDouble("1");
                } else {
                    Q4b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton4b2:
                radiobutton4b0.setChecked(false);
                radiobutton4b1.setChecked(false);
                if (radiobutton4b2.isChecked()) {
                    Q4b = Double.parseDouble("2");
                } else {
                    Q4b = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton4c0:
                radiobutton4c1.setChecked(false);
                radiobutton4c2.setChecked(false);
                if (radiobutton4c0.isChecked()) {
                    Q4c = Double.parseDouble("0");
                } else {
                    Q4c = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton4c1:
                radiobutton4c0.setChecked(false);
                radiobutton4c2.setChecked(false);
                if (radiobutton4c1.isChecked()) {
                    Q4c = Double.parseDouble("1");
                } else {
                    Q4c = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton4c2:
                radiobutton4c0.setChecked(false);
                radiobutton4c1.setChecked(false);
                if (radiobutton4c2.isChecked()) {
                    Q4c = Double.parseDouble("2");
                } else {
                    Q4c = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton5a0:
                radiobutton5a1.setChecked(false);
                radiobutton5a2.setChecked(false);
                if (radiobutton5a0.isChecked()) {
                    Q5a = Double.parseDouble("0");
                } else {
                    Q5a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton5a1:
                radiobutton5a0.setChecked(false);
                radiobutton5a2.setChecked(false);
                if (radiobutton5a1.isChecked()) {
                    Q5a = Double.parseDouble("1");
                } else {
                    Q5a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton5a2:
                radiobutton5a0.setChecked(false);
                radiobutton5a1.setChecked(false);
                if (radiobutton5a2.isChecked()) {
                    Q5a = Double.parseDouble("2");
                } else {
                    Q5a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton5b0:
                radiobutton5b1.setChecked(false);
                radiobutton5b2.setChecked(false);
                if (radiobutton5b0.isChecked()) {
                    Q5b = Double.parseDouble("0");
                } else {
                    Q5b = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton5b1:
                radiobutton5b0.setChecked(false);
                radiobutton5b2.setChecked(false);
                if (radiobutton5b1.isChecked()) {
                    Q5b = Double.parseDouble("1");
                } else {
                    Q5b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton5b2:
                radiobutton5b0.setChecked(false);
                radiobutton5b1.setChecked(false);
                if (radiobutton5b2.isChecked()) {
                    Q5b = Double.parseDouble("2");
                } else {
                    Q5b = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton5c0:
                radiobutton5c1.setChecked(false);
                radiobutton5c2.setChecked(false);
                if (radiobutton5c0.isChecked()) {
                    Q5c = Double.parseDouble("0");
                } else {
                    Q5c = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton5c1:
                radiobutton5c0.setChecked(false);
                radiobutton5c2.setChecked(false);
                if (radiobutton5c1.isChecked()) {
                    Q5c = Double.parseDouble("1");
                } else {
                    Q5c = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton5c2:
                radiobutton5c0.setChecked(false);
                radiobutton5c1.setChecked(false);
                if (radiobutton5c2.isChecked()) {
                    Q5c = Double.parseDouble("2");
                } else {
                    Q5c = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton6a0:
                radiobutton6a1.setChecked(false);
                radiobutton6a2.setChecked(false);
                if (radiobutton6a0.isChecked()) {
                    Q6a = Double.parseDouble("0");
                } else {
                    Q6a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton6a1:
                radiobutton6a0.setChecked(false);
                radiobutton6a2.setChecked(false);
                if (radiobutton6a1.isChecked()) {
                    Q6a = Double.parseDouble("1");
                } else {
                    Q6a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton6a2:
                radiobutton6a0.setChecked(false);
                radiobutton6a1.setChecked(false);
                if (radiobutton6a2.isChecked()) {
                    Q6a = Double.parseDouble("2");
                } else {
                    Q6a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton7a0:
                radiobutton7a1.setChecked(false);
                radiobutton7a2.setChecked(false);
                if (radiobutton7a0.isChecked()) {
                    Q7a = Double.parseDouble("0");
                } else {
                    Q7a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton7a1:
                radiobutton7a0.setChecked(false);
                radiobutton7a2.setChecked(false);
                if (radiobutton7a1.isChecked()) {
                    Q7a = Double.parseDouble("1");
                } else {
                    Q7a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton7a2:
                radiobutton7a0.setChecked(false);
                radiobutton7a1.setChecked(false);
                if (radiobutton7a2.isChecked()) {
                    Q7a = Double.parseDouble("2");
                } else {
                    Q7a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton8a0:
                radiobutton8a1.setChecked(false);
                radiobutton8a2.setChecked(false);
                if (radiobutton8a0.isChecked()) {
                    Q8a = Double.parseDouble("0");
                } else {
                    Q8a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton8a1:
                radiobutton8a0.setChecked(false);
                radiobutton8a2.setChecked(false);
                if (radiobutton8a1.isChecked()) {
                    Q8a = Double.parseDouble("1");
                } else {
                    Q8a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton8a2:
                radiobutton8a0.setChecked(false);
                radiobutton8a1.setChecked(false);
                if (radiobutton8a2.isChecked()) {
                    Q8a = Double.parseDouble("2");
                } else {
                    Q8a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton9a0:
                radiobutton9a1.setChecked(false);
                radiobutton9a2.setChecked(false);
                if (radiobutton9a0.isChecked()) {
                    Q9a = Double.parseDouble("0");
                } else {
                    Q9a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton9a1:
                radiobutton9a0.setChecked(false);
                radiobutton9a2.setChecked(false);
                if (radiobutton9a1.isChecked()) {
                    Q9a = Double.parseDouble("1");
                } else {
                    Q9a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton9a2:
                radiobutton9a0.setChecked(false);
                radiobutton9a1.setChecked(false);
                if (radiobutton9a2.isChecked()) {
                    Q9a = Double.parseDouble("2");
                } else {
                    Q9a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton10a0:
                radiobutton10a1.setChecked(false);
                radiobutton10a2.setChecked(false);
                if (radiobutton10a0.isChecked()) {
                    Q10a = Double.parseDouble("0");
                } else {
                    Q10a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton10a1:
                radiobutton10a0.setChecked(false);
                radiobutton10a2.setChecked(false);
                if (radiobutton10a1.isChecked()) {
                    Q10a = Double.parseDouble("1");
                } else {
                    Q10a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton10a2:
                radiobutton10a0.setChecked(false);
                radiobutton10a1.setChecked(false);
                if (radiobutton10a2.isChecked()) {
                    Q10a = Double.parseDouble("2");
                } else {
                    Q10a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()){
            case R.id.RadioButton11a0:
                radiobutton11a1.setChecked(false);
                radiobutton11a2.setChecked(false);
                if (radiobutton11a0.isChecked()){
                    Q11a = Double.parseDouble("0");
                }
                else {Q11a = Double.parseDouble("0");}

                break;
            case R.id.RadioButton11a1:
                radiobutton11a0.setChecked(false);
                radiobutton11a2.setChecked(false);
                if (radiobutton11a1.isChecked()){
                    Q11a = Double.parseDouble("1");
                }
                else {Q11a = Double.parseDouble("0");}
                break;
            case R.id.RadioButton11a2:
                radiobutton11a0.setChecked(false);
                radiobutton11a1.setChecked(false);
                if (radiobutton11a2.isChecked()){
                    Q11a = Double.parseDouble("2");
                }
                else {Q11a = Double.parseDouble("0");}
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton12a0:
                radiobutton12a1.setChecked(false);
                radiobutton12a2.setChecked(false);
                if (radiobutton12a0.isChecked()) {
                    Q12a = Double.parseDouble("0");
                } else {
                    Q12a = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton12a1:
                radiobutton12a0.setChecked(false);
                radiobutton12a2.setChecked(false);
                if (radiobutton12a1.isChecked()) {
                    Q12a = Double.parseDouble("1");
                } else {
                    Q12a = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton12a2:
                radiobutton12a0.setChecked(false);
                radiobutton12a1.setChecked(false);
                if (radiobutton12a2.isChecked()) {
                    Q12a = Double.parseDouble("2");
                } else {
                    Q12a = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()) {
            case R.id.RadioButton12b0:
                radiobutton12b1.setChecked(false);
                radiobutton12b2.setChecked(false);
                if (radiobutton12b0.isChecked()) {
                    Q12b = Double.parseDouble("0");
                } else {
                    Q12b = Double.parseDouble("0");
                }

                break;
            case R.id.RadioButton12b1:
                radiobutton12b0.setChecked(false);
                radiobutton12b2.setChecked(false);
                if (radiobutton12b1.isChecked()) {
                    Q12b = Double.parseDouble("1");
                } else {
                    Q12b = Double.parseDouble("0");
                }
                break;
            case R.id.RadioButton12b2:
                radiobutton12b0.setChecked(false);
                radiobutton12b1.setChecked(false);
                if (radiobutton12b2.isChecked()) {
                    Q12b = Double.parseDouble("2");
                } else {
                    Q12b = Double.parseDouble("0");
                }
                break;
        }
        switch (v.getId()){
            case R.id.RadioButton13a0:
                radiobutton13a1.setChecked(false);
                radiobutton13a2.setChecked(false);
                if (radiobutton13a0.isChecked()){
                    Q13a = Double.parseDouble("0");
                }
                else {Q13a = Double.parseDouble("0");}

                break;
            case R.id.RadioButton13a1:
                radiobutton13a0.setChecked(false);
                radiobutton13a2.setChecked(false);
                if (radiobutton13a1.isChecked()){
                    Q13a = Double.parseDouble("1");
                }
                else {Q13a = Double.parseDouble("0");}
                break;
            case R.id.RadioButton13a2:
                radiobutton13a0.setChecked(false);
                radiobutton13a1.setChecked(false);
                if (radiobutton13a2.isChecked()){
                    Q13a = Double.parseDouble("2");
                }
                else {Q13a = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton14a0:
                radiobutton14a1.setChecked(false);
                radiobutton14a2.setChecked(false);
                if (radiobutton14a0.isChecked()){
                    Q14a = Double.parseDouble("0");
                }
                else {Q14a = Double.parseDouble("0");}

                break;
            case R.id.RadioButton14a1:
                radiobutton14a0.setChecked(false);
                radiobutton14a2.setChecked(false);
                if (radiobutton14a1.isChecked()){
                    Q14a = Double.parseDouble("1");
                }
                else {Q14a = Double.parseDouble("0");}
                break;
            case R.id.RadioButton14a2:
                radiobutton14a0.setChecked(false);
                radiobutton14a1.setChecked(false);
                if (radiobutton14a2.isChecked()){
                    Q14a = Double.parseDouble("2");
                }
                else {Q14a = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton14b0:
                radiobutton14b1.setChecked(false);
                radiobutton14b2.setChecked(false);
                if (radiobutton14b0.isChecked()){
                    Q14b = Double.parseDouble("0");
                }
                else {Q14b = Double.parseDouble("0");}

                break;
            case R.id.RadioButton14b1:
                radiobutton14b0.setChecked(false);
                radiobutton14b2.setChecked(false);
                if (radiobutton14b1.isChecked()){
                    Q14b = Double.parseDouble("1");
                }
                else {Q14b = Double.parseDouble("0");}
                break;
            case R.id.RadioButton14b2:
                radiobutton14b0.setChecked(false);
                radiobutton14b1.setChecked(false);
                if (radiobutton14b2.isChecked()){
                    Q14b = Double.parseDouble("2");
                }
                else {Q14b = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton14c0:
                radiobutton14c1.setChecked(false);
                radiobutton14c2.setChecked(false);
                if (radiobutton14c0.isChecked()){
                    Q14c = Double.parseDouble("0");
                }
                else {Q14c = Double.parseDouble("0");}

                break;
            case R.id.RadioButton14c1:
                radiobutton14c0.setChecked(false);
                radiobutton14c2.setChecked(false);
                if (radiobutton14c1.isChecked()){
                    Q14c = Double.parseDouble("1");
                }
                else {Q14c = Double.parseDouble("0");}
                break;
            case R.id.RadioButton14c2:
                radiobutton14c0.setChecked(false);
                radiobutton14c1.setChecked(false);
                if (radiobutton14c2.isChecked()){
                    Q14c = Double.parseDouble("2");
                }
                else {Q14c = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton14d0:
                radiobutton14d1.setChecked(false);
                radiobutton14d2.setChecked(false);
                if (radiobutton14d0.isChecked()){
                    Q14d = Double.parseDouble("0");
                }
                else {Q14d = Double.parseDouble("0");}

                break;
            case R.id.RadioButton14d1:
                radiobutton14d0.setChecked(false);
                radiobutton14d2.setChecked(false);
                if (radiobutton14d1.isChecked()){
                    Q14d = Double.parseDouble("1");
                }
                else {Q14d = Double.parseDouble("0");}
                break;
            case R.id.RadioButton14d2:
                radiobutton14d0.setChecked(false);
                radiobutton14d1.setChecked(false);
                if (radiobutton14d2.isChecked()){
                    Q14d = Double.parseDouble("2");
                }
                else {Q14d = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton15a0:
                radiobutton15a1.setChecked(false);
                radiobutton15a2.setChecked(false);
                if (radiobutton15a0.isChecked()){
                    Q15a = Double.parseDouble("0");
                }
                else {Q15a = Double.parseDouble("0");}

                break;
            case R.id.RadioButton15a1:
                radiobutton15a0.setChecked(false);
                radiobutton15a2.setChecked(false);
                if (radiobutton15a1.isChecked()){
                    Q15a = Double.parseDouble("1");
                }
                else {Q15a = Double.parseDouble("0");}
                break;
            case R.id.RadioButton15a2:
                radiobutton15a0.setChecked(false);
                radiobutton15a1.setChecked(false);
                if (radiobutton15a2.isChecked()){
                    Q15a = Double.parseDouble("2");
                }
                else {Q15a = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton15b0:
                radiobutton15b1.setChecked(false);
                radiobutton15b2.setChecked(false);
                if (radiobutton15b0.isChecked()){
                    Q15b = Double.parseDouble("0");
                }
                else {Q15b = Double.parseDouble("0");}

                break;
            case R.id.RadioButton15b1:
                radiobutton15b0.setChecked(false);
                radiobutton15b2.setChecked(false);
                if (radiobutton15b1.isChecked()){
                    Q15b = Double.parseDouble("1");
                }
                else {Q15b = Double.parseDouble("0");}
                break;
            case R.id.RadioButton15b2:
                radiobutton15b0.setChecked(false);
                radiobutton15b1.setChecked(false);
                if (radiobutton15b2.isChecked()){
                    Q15b = Double.parseDouble("2");
                }
                else {Q15b = Double.parseDouble("0");}
                break;
        }

        switch (v.getId()){
            case R.id.RadioButton15c0:
                radiobutton15c1.setChecked(false);
                radiobutton15c2.setChecked(false);
                if (radiobutton15c0.isChecked()){
                    Q15c = Double.parseDouble("0");
                }
                else {Q15c = Double.parseDouble("0");}

                break;
            case R.id.RadioButton15c1:
                radiobutton15c0.setChecked(false);
                radiobutton15c2.setChecked(false);
                if (radiobutton15c1.isChecked()){
                    Q15c = Double.parseDouble("1");
                }
                else {Q15c = Double.parseDouble("0");}
                break;
            case R.id.RadioButton15c2:
                radiobutton15c0.setChecked(false);
                radiobutton15c1.setChecked(false);
                if (radiobutton15c2.isChecked()){
                    Q15c = Double.parseDouble("2");
                }
                else {Q15c = Double.parseDouble("0");}
                break;
        }


        FMSE = Q1a + Q1b + Q2a + Q2b + Q2c + Q2d + Q2e + Q2f + Q3a + Q3b + Q3c + Q4a + Q4b + Q4c + Q5a + Q5b + Q5c + Q6a;
        FMWH = Q7a + Q8a + Q9a + Q10a + Q11a + Q12a + Q12b + Q13a + Q14a + Q14b + Q14c + Q14d + Q15a + Q15b + Q15c;
        total = FMSE + FMWH;
        ((TextView)findViewById(R.id.Total1)).setText(valueOf(FMSE));
        ((TextView)findViewById(R.id.Total2)).setText(valueOf(FMWH));
        ((TextView)findViewById(R.id.Total3)).setText(valueOf(total));




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


    public void FMinputTimes(final int i){
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(fuglmyer.this);
        View promptView = layoutInflater.inflate(R.layout.input_time, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(fuglmyer.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (!TextUtils.isEmpty(editText.getText())) {

                                    Times = new String[2];
                                    String text = "";
                                    if (editText.getText().toString().contains(".")) {
                                        Times = editText.getText().toString().split("\\.");
                                    } else {
                                        Times[0] = editText.getText().toString();
                                    }
                                    Log.d("@@@@@@@", Arrays.toString(Times));

                                    if (!Times[0].isEmpty()) {
                                        MSeconds = Double.parseDouble(Times[0]);
                                        DecimalFormat df = new DecimalFormat("00");

                                        int hours = (int) (MSeconds / (3600));
                                        int remaining = (int) (MSeconds % (3600));

                                        int minutes = (int) (remaining / (60));
                                        remaining = (int) (remaining % (60));

                                        int seconds = (int) (remaining);

                                        if (hours > 0) {
                                            text += df.format(hours) + ":";
                                        }
                                        text += df.format(minutes) + ":";
                                        text += df.format(seconds) + ":";
                                    } else {
                                        text = "00:00:";
                                    }
                                    if (Times.length > 1) {
                                        if (Times[1] != null) {
                                            text += Integer.toString((int) Double.parseDouble(Times[1]));
                                            fTimes[i] = (MSeconds + Double.parseDouble(Times[1]) / 10) * 1000;
                                        } else {
                                            text += Integer.toString(0);
                                            fTimes[i] = MSeconds * 1000;
                                        }
                                    } else {
                                        text += Integer.toString(0);
                                        fTimes[i] = MSeconds * 1000;
                                    }
                                    chronometers[i].setText(text);
                                    TimeDiff = fTimes[0] / 1000 - fTimes[1] / 1000;
                                    TimeDiff = (TimeDiff < 0) ? -TimeDiff : TimeDiff;
                                    ((TextView) findViewById(R.id.TimeDifference)).setText(String.format("%.3f", TimeDiff) + " seconds");
                                }
                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}



