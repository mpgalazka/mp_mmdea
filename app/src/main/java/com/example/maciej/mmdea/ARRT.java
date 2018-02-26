package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ARRT extends AppCompatActivity implements View.OnClickListener{





    String PatID, Date, Event, joined;

    Button bDone;

    EditText comments;

    TextView patientID, currentDateTimeString;

    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
                AARTA10, AARTA11, AARTA12, AARTA13,
                AARTA20, AARTA21, AARTA22, AARTA23,
                AARTA30, AARTA31, AARTA32, AARTA33,
                AARTA40, AARTA41, AARTA42, AARTA43,
                AARTA50, AARTA51, AARTA52, AARTA53,
                AARTA60, AARTA61, AARTA62, AARTA63,

                AARTB10, AARTB11, AARTB12, AARTB13,
                AARTB20, AARTB21, AARTB22, AARTB23,
                AARTB30, AARTB31, AARTB32, AARTB33,
                AARTB40, AARTB41, AARTB42, AARTB43,

                AARTC10, AARTC11, AARTC12, AARTC13,
                AARTC20, AARTC21, AARTC22, AARTC23,
                AARTC30, AARTC31, AARTC32, AARTC33,
                AARTC40, AARTC41, AARTC42, AARTC43,
                AARTC50, AARTC51, AARTC52, AARTC53,
                AARTC60, AARTC61, AARTC62, AARTC63,

                AARTD10, AARTD11, AARTD12, AARTD13,
                AARTD20, AARTD21, AARTD22, AARTD23,
                AARTD30, AARTD31, AARTD32, AARTD33;


    double  AARTQA1, AARTQA2, AARTQA3, AARTQA4, AARTQA5, AARTQA6,
            AARTQB1, AARTQB2, AARTQB3, AARTQB4,
            AARTQC1, AARTQC2, AARTQC3, AARTQC4, AARTQC5, AARTQC6,
            AARTQD1, AARTQD2, AARTQD3,


            AARTQA, AARTQB, AARTQC, AARTQD, AARTQTotal, MSeconds
    ;


    Chronometer ARRTchronometer1, ARRTchronometer2, ARRTchronometer3, ARRTchronometer4, ARRTchronometer5, ARRTchronometer6,
            ARRTchronometer7, ARRTchronometer8, ARRTchronometer9, ARRTchronometer10, ARRTchronometer11, ARRTchronometer12,
            ARRTchronometer13, ARRTchronometer14, ARRTchronometer15, ARRTchronometer16, ARRTchronometer17, ARRTchronometer18, ARRTchronometer19;

    Button bStart1, bStart2, bStart3, bStart4, bStart5, bStart6,
            bStart7, bStart8, bStart9, bStart10, bStart11, bStart12,
            bStart13, bStart14, bStart15, bStart16, bStart17, bStart18, bStart19,

            bStop1, bStop2, bStop3, bStop4, bStop5, bStop6,
            bStop7, bStop8, bStop9, bStop10, bStop11, bStop12,
            bStop13, bStop14, bStop15, bStop16, bStop17, bStop18, bStop19,

            b601, b602, b603, b604, b605, b606,
            b607, b608, b609, b6010, b6011, b6012,
            b6013, b6014, b6015, b6016, b6017, b6018, b6019;

    CheckBox Affectedleft, Affectedright;

    ArrayList<String> inputcheck, affected;

    String[] Times, SfTimes;
    Chronometer[] chronometers;
    double[] fTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrt);


        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Index Date: " + Date);

        Event = "NULL";

        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);

        affected = new ArrayList<>();

        Affectedleft = (CheckBox) findViewById(R.id.Affectedleft);
        Affectedleft.setOnClickListener(this);
        Affectedright = (CheckBox) findViewById(R.id.Affectedright);
        Affectedright.setOnClickListener(this);

        comments = (EditText) findViewById(R.id.comments);

        AARTQA1 = Double.parseDouble("0");
        AARTQA2 = Double.parseDouble("0");
        AARTQA3 = Double.parseDouble("0");
        AARTQA4 = Double.parseDouble("0");
        AARTQA5 = Double.parseDouble("0");
        AARTQA6 = Double.parseDouble("0");

        AARTQB1 = Double.parseDouble("0");
        AARTQB2 = Double.parseDouble("0");
        AARTQB3 = Double.parseDouble("0");
        AARTQB4 = Double.parseDouble("0");


        AARTQC1 = Double.parseDouble("0");
        AARTQC2 = Double.parseDouble("0");
        AARTQC3 = Double.parseDouble("0");
        AARTQC4 = Double.parseDouble("0");
        AARTQC5 = Double.parseDouble("0");
        AARTQC6 = Double.parseDouble("0");

        AARTQD1 = Double.parseDouble("0");
        AARTQD2 = Double.parseDouble("0");
        AARTQD3 = Double.parseDouble("0");




        ARRTchronometer1 = (Chronometer) findViewById(R.id.ARRTchronometer1);
        ARRTchronometer2 = (Chronometer) findViewById(R.id.ARRTchronometer2);
        ARRTchronometer3 = (Chronometer) findViewById(R.id.ARRTchronometer3);
        ARRTchronometer4 = (Chronometer) findViewById(R.id.ARRTchronometer4);
        ARRTchronometer5 = (Chronometer) findViewById(R.id.ARRTchronometer5);
        ARRTchronometer6 = (Chronometer) findViewById(R.id.ARRTchronometer6);
        ARRTchronometer7 = (Chronometer) findViewById(R.id.ARRTchronometer7);
        ARRTchronometer8 = (Chronometer) findViewById(R.id.ARRTchronometer8);
        ARRTchronometer9 = (Chronometer) findViewById(R.id.ARRTchronometer9);
        ARRTchronometer10 = (Chronometer) findViewById(R.id.ARRTchronometer10);
        ARRTchronometer11 = (Chronometer) findViewById(R.id.ARRTchronometer11);
        ARRTchronometer12 = (Chronometer) findViewById(R.id.ARRTchronometer12);
        ARRTchronometer13 = (Chronometer) findViewById(R.id.ARRTchronometer13);
        ARRTchronometer14 = (Chronometer) findViewById(R.id.ARRTchronometer14);
        ARRTchronometer15 = (Chronometer) findViewById(R.id.ARRTchronometer15);
        ARRTchronometer16 = (Chronometer) findViewById(R.id.ARRTchronometer16);
        ARRTchronometer17 = (Chronometer) findViewById(R.id.ARRTchronometer17);
        ARRTchronometer18 = (Chronometer) findViewById(R.id.ARRTchronometer18);
        ARRTchronometer19 = (Chronometer) findViewById(R.id.ARRTchronometer19);

        chronometers = new Chronometer[19];
        chronometers[0] = ARRTchronometer1;
        chronometers[1] = ARRTchronometer2;
        chronometers[2] = ARRTchronometer3;
        chronometers[3] = ARRTchronometer4;
        chronometers[4] = ARRTchronometer5;
        chronometers[5] = ARRTchronometer6;
        chronometers[6] = ARRTchronometer7;
        chronometers[7] = ARRTchronometer8;
        chronometers[8] = ARRTchronometer9;
        chronometers[9] = ARRTchronometer10;
        chronometers[10] = ARRTchronometer11;
        chronometers[11] = ARRTchronometer12;
        chronometers[12] = ARRTchronometer13;
        chronometers[13] = ARRTchronometer14;
        chronometers[14] = ARRTchronometer15;
        chronometers[15] = ARRTchronometer16;
        chronometers[16] = ARRTchronometer17;
        chronometers[17] = ARRTchronometer18;
        chronometers[18] = ARRTchronometer19;


        bStart1 = (Button) findViewById(R.id.bStart1);
        bStart2 = (Button) findViewById(R.id.bStart2);
        bStart3 = (Button) findViewById(R.id.bStart3);
        bStart4 = (Button) findViewById(R.id.bStart4);
        bStart5 = (Button) findViewById(R.id.bStart5);
        bStart6 = (Button) findViewById(R.id.bStart6);
        bStart7 = (Button) findViewById(R.id.bStart7);
        bStart8 = (Button) findViewById(R.id.bStart8);
        bStart9 = (Button) findViewById(R.id.bStart9);
        bStart10 = (Button) findViewById(R.id.bStart10);
        bStart11 = (Button) findViewById(R.id.bStart11);
        bStart12 = (Button) findViewById(R.id.bStart12);
        bStart13 = (Button) findViewById(R.id.bStart13);
        bStart14 = (Button) findViewById(R.id.bStart14);
        bStart15 = (Button) findViewById(R.id.bStart15);
        bStart16 = (Button) findViewById(R.id.bStart16);
        bStart17 = (Button) findViewById(R.id.bStart17);
        bStart18 = (Button) findViewById(R.id.bStart18);
        bStart19 = (Button) findViewById(R.id.bStart19);

        ARRTchronometer1.setOnClickListener(this);
        ARRTchronometer2.setOnClickListener(this);
        ARRTchronometer3.setOnClickListener(this);
        ARRTchronometer4.setOnClickListener(this);
        ARRTchronometer5.setOnClickListener(this);
        ARRTchronometer6.setOnClickListener(this);
        ARRTchronometer7.setOnClickListener(this);
        ARRTchronometer8.setOnClickListener(this);
        ARRTchronometer9.setOnClickListener(this);
        ARRTchronometer10.setOnClickListener(this);
        ARRTchronometer11.setOnClickListener(this);
        ARRTchronometer12.setOnClickListener(this);
        ARRTchronometer13.setOnClickListener(this);
        ARRTchronometer14.setOnClickListener(this);
        ARRTchronometer15.setOnClickListener(this);
        ARRTchronometer16.setOnClickListener(this);
        ARRTchronometer17.setOnClickListener(this);
        ARRTchronometer18.setOnClickListener(this);
        ARRTchronometer19.setOnClickListener(this);
        

        bStart1.setOnClickListener(this);
        bStart2.setOnClickListener(this);
        bStart3.setOnClickListener(this);
        bStart4.setOnClickListener(this);
        bStart5.setOnClickListener(this);
        bStart6.setOnClickListener(this);
        bStart7.setOnClickListener(this);
        bStart8.setOnClickListener(this);
        bStart9.setOnClickListener(this);
        bStart10.setOnClickListener(this);
        bStart11.setOnClickListener(this);
        bStart12.setOnClickListener(this);
        bStart13.setOnClickListener(this);
        bStart14.setOnClickListener(this);
        bStart15.setOnClickListener(this);
        bStart16.setOnClickListener(this);
        bStart17.setOnClickListener(this);
        bStart18.setOnClickListener(this);
        bStart19.setOnClickListener(this);


        bStop1 = (Button) findViewById(R.id.bStop1);
        bStop2 = (Button) findViewById(R.id.bStop2);
        bStop3 = (Button) findViewById(R.id.bStop3);
        bStop4 = (Button) findViewById(R.id.bStop4);
        bStop5 = (Button) findViewById(R.id.bStop5);
        bStop6 = (Button) findViewById(R.id.bStop6);
        bStop7 = (Button) findViewById(R.id.bStop7);
        bStop8 = (Button) findViewById(R.id.bStop8);
        bStop9 = (Button) findViewById(R.id.bStop9);
        bStop10 = (Button) findViewById(R.id.bStop10);
        bStop11 = (Button) findViewById(R.id.bStop11);
        bStop12 = (Button) findViewById(R.id.bStop12);
        bStop13 = (Button) findViewById(R.id.bStop13);
        bStop14 = (Button) findViewById(R.id.bStop14);
        bStop15 = (Button) findViewById(R.id.bStop15);
        bStop16 = (Button) findViewById(R.id.bStop16);
        bStop17 = (Button) findViewById(R.id.bStop17);
        bStop18 = (Button) findViewById(R.id.bStop18);
        bStop19 = (Button) findViewById(R.id.bStop19);

        bStop1.setOnClickListener(this);
        bStop2.setOnClickListener(this);
        bStop3.setOnClickListener(this);
        bStop4.setOnClickListener(this);
        bStop5.setOnClickListener(this);
        bStop6.setOnClickListener(this);
        bStop7.setOnClickListener(this);
        bStop8.setOnClickListener(this);
        bStop9.setOnClickListener(this);
        bStop10.setOnClickListener(this);
        bStop11.setOnClickListener(this);
        bStop12.setOnClickListener(this);
        bStop13.setOnClickListener(this);
        bStop14.setOnClickListener(this);
        bStop15.setOnClickListener(this);
        bStop16.setOnClickListener(this);
        bStop17.setOnClickListener(this);
        bStop18.setOnClickListener(this);
        bStop19.setOnClickListener(this);


        bStop1.setEnabled(false);
        bStop2.setEnabled(false);
        bStop3.setEnabled(false);
        bStop4.setEnabled(false);
        bStop5.setEnabled(false);
        bStop6.setEnabled(false);
        bStop7.setEnabled(false);
        bStop8.setEnabled(false);
        bStop9.setEnabled(false);
        bStop10.setEnabled(false);
        bStop11.setEnabled(false);
        bStop12.setEnabled(false);
        bStop13.setEnabled(false);
        bStop14.setEnabled(false);
        bStop15.setEnabled(false);
        bStop16.setEnabled(false);
        bStop17.setEnabled(false);
        bStop18.setEnabled(false);
        bStop19.setEnabled(false);


        b601 = (Button) findViewById(R.id.b601);
        b602 = (Button) findViewById(R.id.b602);
        b603 = (Button) findViewById(R.id.b603);
        b604 = (Button) findViewById(R.id.b604);
        b605 = (Button) findViewById(R.id.b605);
        b606 = (Button) findViewById(R.id.b606);
        b607 = (Button) findViewById(R.id.b607);
        b608 = (Button) findViewById(R.id.b608);
        b609 = (Button) findViewById(R.id.b609);
        b6010 = (Button) findViewById(R.id.b6010);
        b6011 = (Button) findViewById(R.id.b6011);
        b6012 = (Button) findViewById(R.id.b6012);
        b6013 = (Button) findViewById(R.id.b6013);
        b6014 = (Button) findViewById(R.id.b6014);
        b6015 = (Button) findViewById(R.id.b6015);
        b6016 = (Button) findViewById(R.id.b6016);
        b6017 = (Button) findViewById(R.id.b6017);
        b6018 = (Button) findViewById(R.id.b6018);
        b6019 = (Button) findViewById(R.id.b6019);

        b601.setOnClickListener(this);
        b602.setOnClickListener(this);
        b603.setOnClickListener(this);
        b604.setOnClickListener(this);
        b605.setOnClickListener(this);
        b606.setOnClickListener(this);
        b607.setOnClickListener(this);
        b608.setOnClickListener(this);
        b609.setOnClickListener(this);
        b6010.setOnClickListener(this);
        b6011.setOnClickListener(this);
        b6012.setOnClickListener(this);
        b6013.setOnClickListener(this);
        b6014.setOnClickListener(this);
        b6015.setOnClickListener(this);
        b6016.setOnClickListener(this);
        b6017.setOnClickListener(this);
        b6018.setOnClickListener(this);
        b6019.setOnClickListener(this);


        AARTA10 = (RadioButton) findViewById(R.id.AARTA10);
        AARTA11 = (RadioButton) findViewById(R.id.AARTA11);
        AARTA12 = (RadioButton) findViewById(R.id.AARTA12);
        AARTA13 = (RadioButton) findViewById(R.id.AARTA13);

        AARTA20 = (RadioButton) findViewById(R.id.AARTA20);
        AARTA21 = (RadioButton) findViewById(R.id.AARTA21);
        AARTA22 = (RadioButton) findViewById(R.id.AARTA22);
        AARTA23 = (RadioButton) findViewById(R.id.AARTA23);

        AARTA30 = (RadioButton) findViewById(R.id.AARTA30);
        AARTA31 = (RadioButton) findViewById(R.id.AARTA31);
        AARTA32 = (RadioButton) findViewById(R.id.AARTA32);
        AARTA33 = (RadioButton) findViewById(R.id.AARTA33);

        AARTA40 = (RadioButton) findViewById(R.id.AARTA40);
        AARTA41 = (RadioButton) findViewById(R.id.AARTA41);
        AARTA42 = (RadioButton) findViewById(R.id.AARTA42);
        AARTA43 = (RadioButton) findViewById(R.id.AARTA43);

        AARTA50 = (RadioButton) findViewById(R.id.AARTA50);
        AARTA51 = (RadioButton) findViewById(R.id.AARTA51);
        AARTA52 = (RadioButton) findViewById(R.id.AARTA52);
        AARTA53 = (RadioButton) findViewById(R.id.AARTA53);

        AARTA60 = (RadioButton) findViewById(R.id.AARTA60);
        AARTA61 = (RadioButton) findViewById(R.id.AARTA61);
        AARTA62 = (RadioButton) findViewById(R.id.AARTA62);
        AARTA63 = (RadioButton) findViewById(R.id.AARTA63);


        AARTB10 = (RadioButton) findViewById(R.id.AARTB10);
        AARTB11 = (RadioButton) findViewById(R.id.AARTB11);
        AARTB12 = (RadioButton) findViewById(R.id.AARTB12);
        AARTB13 = (RadioButton) findViewById(R.id.AARTB13);

        AARTB20 = (RadioButton) findViewById(R.id.AARTB20);
        AARTB21 = (RadioButton) findViewById(R.id.AARTB21);
        AARTB22 = (RadioButton) findViewById(R.id.AARTB22);
        AARTB23 = (RadioButton) findViewById(R.id.AARTB23);

        AARTB30 = (RadioButton) findViewById(R.id.AARTB30);
        AARTB31 = (RadioButton) findViewById(R.id.AARTB31);
        AARTB32 = (RadioButton) findViewById(R.id.AARTB32);
        AARTB33 = (RadioButton) findViewById(R.id.AARTB33);

        AARTB40 = (RadioButton) findViewById(R.id.AARTB40);
        AARTB41 = (RadioButton) findViewById(R.id.AARTB41);
        AARTB42 = (RadioButton) findViewById(R.id.AARTB42);
        AARTB43 = (RadioButton) findViewById(R.id.AARTB43);


        AARTC10 = (RadioButton) findViewById(R.id.AARTC10);
        AARTC11 = (RadioButton) findViewById(R.id.AARTC11);
        AARTC12 = (RadioButton) findViewById(R.id.AARTC12);
        AARTC13 = (RadioButton) findViewById(R.id.AARTC13);

        AARTC20 = (RadioButton) findViewById(R.id.AARTC20);
        AARTC21 = (RadioButton) findViewById(R.id.AARTC21);
        AARTC22 = (RadioButton) findViewById(R.id.AARTC22);
        AARTC23 = (RadioButton) findViewById(R.id.AARTC23);

        AARTC30 = (RadioButton) findViewById(R.id.AARTC30);
        AARTC31 = (RadioButton) findViewById(R.id.AARTC31);
        AARTC32 = (RadioButton) findViewById(R.id.AARTC32);
        AARTC33 = (RadioButton) findViewById(R.id.AARTC33);

        AARTC40 = (RadioButton) findViewById(R.id.AARTC40);
        AARTC41 = (RadioButton) findViewById(R.id.AARTC41);
        AARTC42 = (RadioButton) findViewById(R.id.AARTC42);
        AARTC43 = (RadioButton) findViewById(R.id.AARTC43);

        AARTC50 = (RadioButton) findViewById(R.id.AARTC50);
        AARTC51 = (RadioButton) findViewById(R.id.AARTC51);
        AARTC52 = (RadioButton) findViewById(R.id.AARTC52);
        AARTC53 = (RadioButton) findViewById(R.id.AARTC53);

        AARTC60 = (RadioButton) findViewById(R.id.AARTC60);
        AARTC61 = (RadioButton) findViewById(R.id.AARTC61);
        AARTC62 = (RadioButton) findViewById(R.id.AARTC62);
        AARTC63 = (RadioButton) findViewById(R.id.AARTC63);


        AARTD10 = (RadioButton) findViewById(R.id.AARTD10);
        AARTD11 = (RadioButton) findViewById(R.id.AARTD11);
        AARTD12 = (RadioButton) findViewById(R.id.AARTD12);
        AARTD13 = (RadioButton) findViewById(R.id.AARTD13);

        AARTD20 = (RadioButton) findViewById(R.id.AARTD20);
        AARTD21 = (RadioButton) findViewById(R.id.AARTD21);
        AARTD22 = (RadioButton) findViewById(R.id.AARTD22);
        AARTD23 = (RadioButton) findViewById(R.id.AARTD23);

        AARTD30 = (RadioButton) findViewById(R.id.AARTD30);
        AARTD31 = (RadioButton) findViewById(R.id.AARTD31);
        AARTD32 = (RadioButton) findViewById(R.id.AARTD32);
        AARTD33 = (RadioButton) findViewById(R.id.AARTD33);



        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);


        SfTimes = new String[19];
        SfTimes[0] = "";
        SfTimes[1] = "";
        SfTimes[2] = "";
        SfTimes[3] = "";
        SfTimes[4] = "";
        SfTimes[5] = "";
        SfTimes[6] = "";
        SfTimes[7] = "";
        SfTimes[8] = "";
        SfTimes[9] = "";
        SfTimes[10] = "";
        SfTimes[11] = "";
        SfTimes[12] = "";
        SfTimes[13] = "";
        SfTimes[14] = "";
        SfTimes[15] = "";
        SfTimes[16] = "";
        SfTimes[17] = "";
        SfTimes[18] = "";

        fTimes = new double[19];
        fTimes[0] = Double.parseDouble("0");
        fTimes[1] = Double.parseDouble("0");
        fTimes[2] = Double.parseDouble("0");
        fTimes[3] = Double.parseDouble("0");
        fTimes[4] = Double.parseDouble("0");
        fTimes[5] = Double.parseDouble("0");
        fTimes[6] = Double.parseDouble("0");
        fTimes[7] = Double.parseDouble("0");
        fTimes[8] = Double.parseDouble("0");
        fTimes[9] = Double.parseDouble("0");
        fTimes[10] = Double.parseDouble("0");
        fTimes[11] = Double.parseDouble("0");
        fTimes[12] = Double.parseDouble("0");
        fTimes[13] = Double.parseDouble("0");
        fTimes[14] = Double.parseDouble("0");
        fTimes[15] = Double.parseDouble("0");
        fTimes[16] = Double.parseDouble("0");
        fTimes[17] = Double.parseDouble("0");
        fTimes[18] = Double.parseDouble("0");

    }



    public void ActionResearchArmTest(View view) {


        Log.d("@@@@@@@", String.valueOf(AARTQA));

        switch (view.getId()) {

            case R.id.AARTA10:
                AARTQA1 = Double.parseDouble("0");
                AARTA20.setEnabled(true);
                AARTA21.setEnabled(true);
                AARTA22.setEnabled(true);
                AARTA23.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);

                if (AARTA20.isChecked()) {
                    AARTA30.setChecked(true);
                    AARTA40.setChecked(true);
                    AARTA50.setChecked(true);
                    AARTA60.setChecked(true);

                    AARTA30.setEnabled(false);
                    AARTA31.setEnabled(false);
                    AARTA32.setEnabled(false);
                    AARTA33.setEnabled(false);

                    AARTA40.setEnabled(false);
                    AARTA41.setEnabled(false);
                    AARTA42.setEnabled(false);
                    AARTA43.setEnabled(false);

                    AARTA50.setEnabled(false);
                    AARTA51.setEnabled(false);
                    AARTA52.setEnabled(false);
                    AARTA53.setEnabled(false);

                    AARTA60.setEnabled(false);
                    AARTA61.setEnabled(false);
                    AARTA62.setEnabled(false);
                    AARTA63.setEnabled(false);
                }

                break;
            case R.id.AARTA11:
                AARTQA1 = Double.parseDouble("1");
                AARTA20.setEnabled(true);
                AARTA21.setEnabled(true);
                AARTA22.setEnabled(true);
                AARTA23.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);
                break;
            case R.id.AARTA12:
                AARTQA1 = Double.parseDouble("2");
                AARTA20.setEnabled(true);
                AARTA21.setEnabled(true);
                AARTA22.setEnabled(true);
                AARTA23.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);
                break;
            case R.id.AARTA13:
                AARTQA1 = Double.parseDouble("3");

                AARTA23.setChecked(true);
                AARTA33.setChecked(true);
                AARTA43.setChecked(true);
                AARTA53.setChecked(true);
                AARTA63.setChecked(true);

                AARTA20.setEnabled(false);
                AARTA21.setEnabled(false);
                AARTA22.setEnabled(false);
                AARTA23.setEnabled(false);

                AARTA30.setEnabled(false);
                AARTA31.setEnabled(false);
                AARTA32.setEnabled(false);
                AARTA33.setEnabled(false);

                AARTA40.setEnabled(false);
                AARTA41.setEnabled(false);
                AARTA42.setEnabled(false);
                AARTA43.setEnabled(false);

                AARTA50.setEnabled(false);
                AARTA51.setEnabled(false);
                AARTA52.setEnabled(false);
                AARTA53.setEnabled(false);

                AARTA60.setEnabled(false);
                AARTA61.setEnabled(false);
                AARTA62.setEnabled(false);
                AARTA63.setEnabled(false);

                break;


            case R.id.AARTA20:
                AARTQA2 = Double.parseDouble("0");

                if (AARTA10.isChecked()) {
                    AARTA30.setChecked(true);
                    AARTA40.setChecked(true);
                    AARTA50.setChecked(true);
                    AARTA60.setChecked(true);

                    AARTA30.setEnabled(false);
                    AARTA31.setEnabled(false);
                    AARTA32.setEnabled(false);
                    AARTA33.setEnabled(false);

                    AARTA40.setEnabled(false);
                    AARTA41.setEnabled(false);
                    AARTA42.setEnabled(false);
                    AARTA43.setEnabled(false);

                    AARTA50.setEnabled(false);
                    AARTA51.setEnabled(false);
                    AARTA52.setEnabled(false);
                    AARTA53.setEnabled(false);

                    AARTA60.setEnabled(false);
                    AARTA61.setEnabled(false);
                    AARTA62.setEnabled(false);
                    AARTA63.setEnabled(false);
                }
                break;
            case R.id.AARTA21:
                AARTQA2 = Double.parseDouble("1");
                AARTA10.setEnabled(true);
                AARTA11.setEnabled(true);
                AARTA12.setEnabled(true);
                AARTA13.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);
                break;
            case R.id.AARTA22:
                AARTQA2 = Double.parseDouble("2");
                AARTA10.setEnabled(true);
                AARTA11.setEnabled(true);
                AARTA12.setEnabled(true);
                AARTA13.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);
                break;
            case R.id.AARTA23:
                AARTQA2 = Double.parseDouble("3");
                AARTA10.setEnabled(true);
                AARTA11.setEnabled(true);
                AARTA12.setEnabled(true);
                AARTA13.setEnabled(true);

                AARTA30.setEnabled(true);
                AARTA31.setEnabled(true);
                AARTA32.setEnabled(true);
                AARTA33.setEnabled(true);

                AARTA40.setEnabled(true);
                AARTA41.setEnabled(true);
                AARTA42.setEnabled(true);
                AARTA43.setEnabled(true);

                AARTA50.setEnabled(true);
                AARTA51.setEnabled(true);
                AARTA52.setEnabled(true);
                AARTA53.setEnabled(true);

                AARTA60.setEnabled(true);
                AARTA61.setEnabled(true);
                AARTA62.setEnabled(true);
                AARTA63.setEnabled(true);
                break;


            case R.id.AARTA30:
                AARTQA3 = Double.parseDouble("0");
                break;
            case R.id.AARTA31:
                AARTQA3 = Double.parseDouble("1");
                break;
            case R.id.AARTA32:
                AARTQA3 = Double.parseDouble("2");
                break;
            case R.id.AARTA33:
                AARTQA3 = Double.parseDouble("3");
                break;


            case R.id.AARTA40:
                AARTQA4 = Double.parseDouble("0");
                break;
            case R.id.AARTA41:
                AARTQA4 = Double.parseDouble("1");
                break;
            case R.id.AARTA42:
                AARTQA4 = Double.parseDouble("2");
                break;
            case R.id.AARTA43:
                AARTQA4 = Double.parseDouble("3");
                break;


            case R.id.AARTA50:
                AARTQA5 = Double.parseDouble("0");
                break;
            case R.id.AARTA51:
                AARTQA5 = Double.parseDouble("1");
                break;
            case R.id.AARTA52:
                AARTQA5 = Double.parseDouble("2");
                break;
            case R.id.AARTA53:
                AARTQA5 = Double.parseDouble("3");
                break;


            case R.id.AARTA60:
                AARTQA6 = Double.parseDouble("0");
                break;
            case R.id.AARTA61:
                AARTQA6 = Double.parseDouble("1");
                break;
            case R.id.AARTA62:
                AARTQA6 = Double.parseDouble("2");
                break;
            case R.id.AARTA63:
                AARTQA6 = Double.parseDouble("3");
                break;
        }


        switch (view.getId()) {

            case R.id.AARTB10:
                AARTQB1 = Double.parseDouble("0");
                AARTB20.setEnabled(true);
                AARTB21.setEnabled(true);
                AARTB22.setEnabled(true);
                AARTB23.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);

                if (AARTB20.isChecked()) {
                    AARTB30.setChecked(true);
                    AARTB40.setChecked(true);

                    AARTB30.setEnabled(false);
                    AARTB31.setEnabled(false);
                    AARTB32.setEnabled(false);
                    AARTB33.setEnabled(false);

                    AARTB40.setEnabled(false);
                    AARTB41.setEnabled(false);
                    AARTB42.setEnabled(false);
                    AARTB43.setEnabled(false);
                }
                break;
            case R.id.AARTB11:
                AARTQB1 = Double.parseDouble("1");
                AARTB20.setEnabled(true);
                AARTB21.setEnabled(true);
                AARTB22.setEnabled(true);
                AARTB23.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);
                break;
            case R.id.AARTB12:
                AARTQB1 = Double.parseDouble("2");
                AARTB20.setEnabled(true);
                AARTB21.setEnabled(true);
                AARTB22.setEnabled(true);
                AARTB23.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);
                break;
            case R.id.AARTB13:
                AARTQB1 = Double.parseDouble("3");

                AARTB23.setChecked(true);
                AARTB33.setChecked(true);
                AARTB43.setChecked(true);

                AARTB20.setEnabled(false);
                AARTB21.setEnabled(false);
                AARTB22.setEnabled(false);
                AARTB23.setEnabled(false);

                AARTB30.setEnabled(false);
                AARTB31.setEnabled(false);
                AARTB32.setEnabled(false);
                AARTB33.setEnabled(false);

                AARTB40.setEnabled(false);
                AARTB41.setEnabled(false);
                AARTB42.setEnabled(false);
                AARTB43.setEnabled(false);
                break;


            case R.id.AARTB20:
                AARTQB2 = Double.parseDouble("0");
                
                if (AARTB10.isChecked()) {
                    AARTB30.setChecked(true);
                    AARTB40.setChecked(true);
                    
                    AARTB30.setEnabled(false);
                    AARTB31.setEnabled(false);
                    AARTB32.setEnabled(false);
                    AARTB33.setEnabled(false);

                    AARTB40.setEnabled(false);
                    AARTB41.setEnabled(false);
                    AARTB42.setEnabled(false);
                    AARTB43.setEnabled(false);
                }
                break;
            case R.id.AARTB21:
                AARTQB2 = Double.parseDouble("1");
                AARTB10.setEnabled(true);
                AARTB11.setEnabled(true);
                AARTB12.setEnabled(true);
                AARTB13.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);
                break;
            case R.id.AARTB22:
                AARTQB2 = Double.parseDouble("2");
                AARTB10.setEnabled(true);
                AARTB11.setEnabled(true);
                AARTB12.setEnabled(true);
                AARTB13.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);
                break;
            case R.id.AARTB23:
                AARTQB2 = Double.parseDouble("3");
                AARTB10.setEnabled(true);
                AARTB11.setEnabled(true);
                AARTB12.setEnabled(true);
                AARTB13.setEnabled(true);

                AARTB30.setEnabled(true);
                AARTB31.setEnabled(true);
                AARTB32.setEnabled(true);
                AARTB33.setEnabled(true);

                AARTB40.setEnabled(true);
                AARTB41.setEnabled(true);
                AARTB42.setEnabled(true);
                AARTB43.setEnabled(true);
                break;


            case R.id.AARTB30:
                AARTQB3 = Double.parseDouble("0");
                break;
            case R.id.AARTB31:
                AARTQB3 = Double.parseDouble("1");
                break;
            case R.id.AARTB32:
                AARTQB3 = Double.parseDouble("2");
                break;
            case R.id.AARTB33:
                AARTQB3 = Double.parseDouble("3");
                break;


            case R.id.AARTB40:
                AARTQB4 = Double.parseDouble("0");
                break;
            case R.id.AARTB41:
                AARTQB4 = Double.parseDouble("1");
                break;
            case R.id.AARTB42:
                AARTQB4 = Double.parseDouble("2");
                break;
            case R.id.AARTB43:
                AARTQB4 = Double.parseDouble("3");
                break;

        }


        switch (view.getId()) {

            case R.id.AARTC10:
                AARTQC1 = Double.parseDouble("0");
                AARTC20.setEnabled(true);
                AARTC21.setEnabled(true);
                AARTC22.setEnabled(true);
                AARTC23.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);

                if (AARTC20.isChecked()) {
                    AARTC30.setChecked(true);
                    AARTC40.setChecked(true);
                    AARTC50.setChecked(true);
                    AARTC60.setChecked(true);

                    AARTC30.setEnabled(false);
                    AARTC31.setEnabled(false);
                    AARTC32.setEnabled(false);
                    AARTC33.setEnabled(false);

                    AARTC40.setEnabled(false);
                    AARTC41.setEnabled(false);
                    AARTC42.setEnabled(false);
                    AARTC43.setEnabled(false);

                    AARTC50.setEnabled(false);
                    AARTC51.setEnabled(false);
                    AARTC52.setEnabled(false);
                    AARTC53.setEnabled(false);

                    AARTC60.setEnabled(false);
                    AARTC61.setEnabled(false);
                    AARTC62.setEnabled(false);
                    AARTC63.setEnabled(false);
                }
                
                break;
            case R.id.AARTC11:
                AARTQC1 = Double.parseDouble("1");
                AARTC20.setEnabled(true);
                AARTC21.setEnabled(true);
                AARTC22.setEnabled(true);
                AARTC23.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);
                break;
            case R.id.AARTC12:
                AARTQC1 = Double.parseDouble("2");
                AARTC20.setEnabled(true);
                AARTC21.setEnabled(true);
                AARTC22.setEnabled(true);
                AARTC23.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);
                break;
            case R.id.AARTC13:
                AARTQC1 = Double.parseDouble("3");
                AARTC23.setChecked(true);
                AARTC33.setChecked(true);
                AARTC43.setChecked(true);
                AARTC53.setChecked(true);
                AARTC63.setChecked(true);

                AARTC20.setEnabled(false);
                AARTC21.setEnabled(false);
                AARTC22.setEnabled(false);
                AARTC23.setEnabled(false);

                AARTC30.setEnabled(false);
                AARTC31.setEnabled(false);
                AARTC32.setEnabled(false);
                AARTC33.setEnabled(false);

                AARTC40.setEnabled(false);
                AARTC41.setEnabled(false);
                AARTC42.setEnabled(false);
                AARTC43.setEnabled(false);

                AARTC50.setEnabled(false);
                AARTC51.setEnabled(false);
                AARTC52.setEnabled(false);
                AARTC53.setEnabled(false);

                AARTC60.setEnabled(false);
                AARTC61.setEnabled(false);
                AARTC62.setEnabled(false);
                AARTC63.setEnabled(false);
                break;


            case R.id.AARTC20:
                AARTQC2 = Double.parseDouble("0");
                if (AARTC10.isChecked()) {
                    AARTC30.setChecked(true);
                    AARTC40.setChecked(true);
                    AARTC50.setChecked(true);
                    AARTC60.setChecked(true);

                    AARTC30.setEnabled(false);
                    AARTC31.setEnabled(false);
                    AARTC32.setEnabled(false);
                    AARTC33.setEnabled(false);

                    AARTC40.setEnabled(false);
                    AARTC41.setEnabled(false);
                    AARTC42.setEnabled(false);
                    AARTC43.setEnabled(false);

                    AARTC50.setEnabled(false);
                    AARTC51.setEnabled(false);
                    AARTC52.setEnabled(false);
                    AARTC53.setEnabled(false);

                    AARTC60.setEnabled(false);
                    AARTC61.setEnabled(false);
                    AARTC62.setEnabled(false);
                    AARTC63.setEnabled(false);
                }
                break;
            case R.id.AARTC21:
                AARTQC2 = Double.parseDouble("1");
                AARTC10.setEnabled(true);
                AARTC11.setEnabled(true);
                AARTC12.setEnabled(true);
                AARTC13.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);
                break;
            case R.id.AARTC22:
                AARTQC2 = Double.parseDouble("2");
                AARTC10.setEnabled(true);
                AARTC11.setEnabled(true);
                AARTC12.setEnabled(true);
                AARTC13.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);
                break;
            case R.id.AARTC23:
                AARTQC2 = Double.parseDouble("3");
                AARTC10.setEnabled(true);
                AARTC11.setEnabled(true);
                AARTC12.setEnabled(true);
                AARTC13.setEnabled(true);

                AARTC30.setEnabled(true);
                AARTC31.setEnabled(true);
                AARTC32.setEnabled(true);
                AARTC33.setEnabled(true);

                AARTC40.setEnabled(true);
                AARTC41.setEnabled(true);
                AARTC42.setEnabled(true);
                AARTC43.setEnabled(true);

                AARTC50.setEnabled(true);
                AARTC51.setEnabled(true);
                AARTC52.setEnabled(true);
                AARTC53.setEnabled(true);

                AARTC60.setEnabled(true);
                AARTC61.setEnabled(true);
                AARTC62.setEnabled(true);
                AARTC63.setEnabled(true);
                break;


            case R.id.AARTC30:
                AARTQC3 = Double.parseDouble("0");
                break;
            case R.id.AARTC31:
                AARTQC3 = Double.parseDouble("1");
                break;
            case R.id.AARTC32:
                AARTQC3 = Double.parseDouble("2");
                break;
            case R.id.AARTC33:
                AARTQC3 = Double.parseDouble("3");
                break;


            case R.id.AARTC40:
                AARTQC4 = Double.parseDouble("0");
                break;
            case R.id.AARTC41:
                AARTQC4 = Double.parseDouble("1");
                break;
            case R.id.AARTC42:
                AARTQC4 = Double.parseDouble("2");
                break;
            case R.id.AARTC43:
                AARTQC4 = Double.parseDouble("3");
                break;


            case R.id.AARTC50:
                AARTQC5 = Double.parseDouble("0");
                break;
            case R.id.AARTC51:
                AARTQC5 = Double.parseDouble("1");
                break;
            case R.id.AARTC52:
                AARTQC5 = Double.parseDouble("2");
                break;
            case R.id.AARTC53:
                AARTQC5 = Double.parseDouble("3");
                break;


            case R.id.AARTC60:
                AARTQC6 = Double.parseDouble("0");
                break;
            case R.id.AARTC61:
                AARTQC6 = Double.parseDouble("1");
                break;
            case R.id.AARTC62:
                AARTQC6 = Double.parseDouble("2");
                break;
            case R.id.AARTC63:
                AARTQC6 = Double.parseDouble("3");
                break;
        }


        switch (view.getId()) {

            case R.id.AARTD10:
                AARTQD1 = Double.parseDouble("0");
                AARTD20.setEnabled(true);
                AARTD21.setEnabled(true);
                AARTD22.setEnabled(true);
                AARTD23.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);

                if (AARTD20.isChecked()) {
                    AARTD30.setChecked(true);


                    AARTD30.setEnabled(false);
                    AARTD31.setEnabled(false);
                    AARTD32.setEnabled(false);
                    AARTD33.setEnabled(false);
                }
                break;
            case R.id.AARTD11:
                AARTQD1 = Double.parseDouble("1");
                AARTD20.setEnabled(true);
                AARTD21.setEnabled(true);
                AARTD22.setEnabled(true);
                AARTD23.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);
                break;
            case R.id.AARTD12:
                AARTQD1 = Double.parseDouble("2");
                AARTD20.setEnabled(true);
                AARTD21.setEnabled(true);
                AARTD22.setEnabled(true);
                AARTD23.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);
                break;
            case R.id.AARTD13:
                AARTQD1 = Double.parseDouble("3");
                AARTD23.setChecked(true);
                AARTD33.setChecked(true);

                AARTD20.setEnabled(false);
                AARTD21.setEnabled(false);
                AARTD22.setEnabled(false);
                AARTD23.setEnabled(false);

                AARTD30.setEnabled(false);
                AARTD31.setEnabled(false);
                AARTD32.setEnabled(false);
                AARTD33.setEnabled(false);
                break;


            case R.id.AARTD20:
                AARTQD2 = Double.parseDouble("0");
                if (AARTD10.isChecked()) {
                    AARTD30.setChecked(true);


                    AARTD30.setEnabled(false);
                    AARTD31.setEnabled(false);
                    AARTD32.setEnabled(false);
                    AARTD33.setEnabled(false);
                }
                break;
            case R.id.AARTD21:
                AARTQD2 = Double.parseDouble("1");
                AARTD10.setEnabled(true);
                AARTD11.setEnabled(true);
                AARTD12.setEnabled(true);
                AARTD13.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);
                break;
            case R.id.AARTD22:
                AARTQD2 = Double.parseDouble("2");
                AARTD10.setEnabled(true);
                AARTD11.setEnabled(true);
                AARTD12.setEnabled(true);
                AARTD13.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);
                break;
            case R.id.AARTD23:
                AARTQD2 = Double.parseDouble("3");
                AARTD10.setEnabled(true);
                AARTD11.setEnabled(true);
                AARTD12.setEnabled(true);
                AARTD13.setEnabled(true);

                AARTD30.setEnabled(true);
                AARTD31.setEnabled(true);
                AARTD32.setEnabled(true);
                AARTD33.setEnabled(true);
                break;


            case R.id.AARTD30:
                AARTQD3 = Double.parseDouble("0");
                break;
            case R.id.AARTD31:
                AARTQD3 = Double.parseDouble("1");
                break;
            case R.id.AARTD32:
                AARTQD3 = Double.parseDouble("2");
                break;
            case R.id.AARTD33:
                AARTQD3 = Double.parseDouble("3");
                break;

        }


        if (AARTA13.isChecked()) {
            AARTQA = Double.parseDouble("18");
            AARTQA1 = Double.parseDouble("3");
            AARTQA2 = Double.parseDouble("3");
            AARTQA3 = Double.parseDouble("3");
            AARTQA4 = Double.parseDouble("3");
            AARTQA5 = Double.parseDouble("3");
            AARTQA6 = Double.parseDouble("3");
        } else if (AARTA20.isChecked() && AARTA10.isChecked()){
            AARTQA = Double.parseDouble("0");
            AARTQA1 = Double.parseDouble("0");
            AARTQA2 = Double.parseDouble("0");
            AARTQA3 = Double.parseDouble("0");
            AARTQA4 = Double.parseDouble("0");
            AARTQA5 = Double.parseDouble("0");
            AARTQA6 = Double.parseDouble("0");
        }else {
            AARTQA = AARTQA1 + AARTQA2 + AARTQA3 + AARTQA4 + AARTQA5 + AARTQA6;
        }


        if (AARTB13.isChecked()) {
            AARTQB = Double.parseDouble("12");
            AARTQB1 = Double.parseDouble("3");
            AARTQB2 = Double.parseDouble("3");
            AARTQB3 = Double.parseDouble("3");
            AARTQB4 = Double.parseDouble("3");
        } else if (AARTB20.isChecked() && AARTB10.isChecked()) {
            AARTQB = Double.parseDouble("0");
            AARTQB1 = Double.parseDouble("0");
            AARTQB2 = Double.parseDouble("0");
            AARTQB3 = Double.parseDouble("0");
            AARTQB4 = Double.parseDouble("0");
        } else {
            AARTQB = AARTQB1 + AARTQB2 + AARTQB3 + AARTQB4;
        }


        if (AARTC13.isChecked()) {
            AARTQC = Double.parseDouble("18");
            AARTQC1 = Double.parseDouble("3");
            AARTQC2 = Double.parseDouble("3");
            AARTQC3 = Double.parseDouble("3");
            AARTQC4 = Double.parseDouble("3");
            AARTQC5 = Double.parseDouble("3");
            AARTQC6 = Double.parseDouble("3");
        } else if (AARTC20.isChecked() && AARTC10.isChecked()) {
            AARTQC = Double.parseDouble("0");
            AARTQC1 = Double.parseDouble("0");
            AARTQC2 = Double.parseDouble("0");
            AARTQC3 = Double.parseDouble("0");
            AARTQC4 = Double.parseDouble("0");
            AARTQC5 = Double.parseDouble("0");
            AARTQC6 = Double.parseDouble("0");
        } else {
            AARTQC = AARTQC1 + AARTQC2 + AARTQC3 + AARTQC4 + AARTQC5 + AARTQC6;
        }


        if (AARTD13.isChecked()) {
            AARTQD = Double.parseDouble("9");
            AARTQD1 = Double.parseDouble("3");
            AARTQD2 = Double.parseDouble("3");
            AARTQD3 = Double.parseDouble("3");
        } else if (AARTD20.isChecked() && AARTD10.isChecked()) {
            AARTQD = Double.parseDouble("0");
            AARTQD1 = Double.parseDouble("0");
            AARTQD2 = Double.parseDouble("0");
            AARTQD3 = Double.parseDouble("0");
        } else {
            AARTQD = AARTQD1 + AARTQD2 + AARTQD3;
        }

        AARTQTotal = AARTQA + AARTQB + AARTQC + AARTQD;


        ((TextView) findViewById(R.id.ARRTA)).setText("Total A Section: " + String.valueOf(AARTQA));
        ((TextView) findViewById(R.id.ARRTB)).setText("Total B Section: " + String.valueOf(AARTQB));
        ((TextView) findViewById(R.id.ARRTC)).setText("Total C Section: " + String.valueOf(AARTQC));
        ((TextView) findViewById(R.id.ARRTD)).setText("Total D Section: " + String.valueOf(AARTQD));

        ((TextView) findViewById(R.id.ARRTTotal)).setText("Total Score on ARA Test: " + String.valueOf(AARTQTotal));

    }





    @Override
    public void onClick(View v) {


        switch(v.getId()) {
            case R.id.bStart1:
                ARRTchronometer1.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer1.start();
                bStart1.setEnabled(false);
                bStop1.setEnabled(true);
                ARRTchronometer1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart1.setEnabled(true);
                            bStop1.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[0] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop1:
                ARRTchronometer1.stop();
                bStart1.setEnabled(true);
                bStop1.setEnabled(false);
                SfTimes[0] = String.format("%.3f", (double)ARRTchronometer1.getTimeElapsed() / 1000);
                break;
            case R.id.b601:
                ARRTchronometer1.setText("01:00:0");
                SfTimes[0] = "60.000";
                break;
            case R.id.ARRTchronometer1:
                ARRTinputTimes(0);
                break;
        }


        switch(v.getId()) {
            case R.id.bStart2:
                ARRTchronometer2.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer2.start();
                bStart2.setEnabled(false);
                bStop2.setEnabled(true);
                ARRTchronometer2.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart2.setEnabled(true);
                            bStop2.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[1] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop2:
                ARRTchronometer2.stop();
                bStart2.setEnabled(true);
                bStop2.setEnabled(false);
                SfTimes[1] = String.format("%.3f", (double)ARRTchronometer2.getTimeElapsed() / 1000);
                break;
            case R.id.b602:
                ARRTchronometer2.setText("01:00:0");
                SfTimes[1] = "60.000";
                break;
            case R.id.ARRTchronometer2:
                ARRTinputTimes(1);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart3:
                ARRTchronometer3.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer3.start();
                bStart3.setEnabled(false);
                bStop3.setEnabled(true);
                ARRTchronometer3.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart3.setEnabled(true);
                            bStop3.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[2] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop3:
                ARRTchronometer3.stop();
                bStart3.setEnabled(true);
                bStop3.setEnabled(false);
                SfTimes[2] = String.format("%.3f", (double)ARRTchronometer3.getTimeElapsed() / 1000);
                break;
            case R.id.b603:
                ARRTchronometer3.setText("01:00:0");
                SfTimes[2] = "60.000";
                break;
            case R.id.ARRTchronometer3:
                ARRTinputTimes(2);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart4:
                ARRTchronometer4.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer4.start();
                bStart4.setEnabled(false);
                bStop4.setEnabled(true);
                ARRTchronometer4.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart4.setEnabled(true);
                            bStop4.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[3] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop4:
                ARRTchronometer4.stop();
                bStart4.setEnabled(true);
                bStop4.setEnabled(false);
                SfTimes[3] = String.format("%.3f", (double)ARRTchronometer4.getTimeElapsed() / 1000);
                break;
            case R.id.b604:
                ARRTchronometer4.setText("01:00:0");
                SfTimes[3] = "60.000";
                break;
            case R.id.ARRTchronometer4:
                ARRTinputTimes(3);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart5:
                ARRTchronometer5.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer5.start();
                bStart5.setEnabled(false);
                bStop5.setEnabled(true);
                ARRTchronometer5.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart5.setEnabled(true);
                            bStop5.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[4] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop5:
                ARRTchronometer5.stop();
                bStart5.setEnabled(true);
                bStop5.setEnabled(false);
                SfTimes[4] = String.format("%.3f", (double)ARRTchronometer5.getTimeElapsed() / 1000);
                break;
            case R.id.b605:
                ARRTchronometer5.setText("01:00:0");
                SfTimes[4] = "60.000";
                break;
            case R.id.ARRTchronometer5:
                ARRTinputTimes(4);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart6:
                ARRTchronometer6.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer6.start();
                bStart6.setEnabled(false);
                bStop6.setEnabled(true);
                ARRTchronometer6.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart6.setEnabled(true);
                            bStop6.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[5] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop6:
                ARRTchronometer6.stop();
                bStart6.setEnabled(true);
                bStop6.setEnabled(false);
                SfTimes[5] = String.format("%.3f", (double)ARRTchronometer6.getTimeElapsed() / 1000);
                break;
            case R.id.b606:
                ARRTchronometer6.setText("01:00:0");
                SfTimes[5] = "60.000";
                break;
            case R.id.ARRTchronometer6:
                ARRTinputTimes(5);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart7:
                ARRTchronometer7.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer7.start();
                bStart7.setEnabled(false);
                bStop7.setEnabled(true);
                ARRTchronometer7.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart7.setEnabled(true);
                            bStop7.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[6] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop7:
                ARRTchronometer7.stop();
                bStart7.setEnabled(true);
                bStop7.setEnabled(false);
                SfTimes[6] = String.format("%.3f", (double)ARRTchronometer7.getTimeElapsed() / 1000);
                break;
            case R.id.b607:
                ARRTchronometer7.setText("01:00:0");
                SfTimes[6] = "60.000";
                break;
            case R.id.ARRTchronometer7:
                ARRTinputTimes(6);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart8:
                ARRTchronometer8.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer8.start();
                bStart8.setEnabled(false);
                bStop8.setEnabled(true);
                ARRTchronometer8.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart8.setEnabled(true);
                            bStop8.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[7] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop8:
                ARRTchronometer8.stop();
                bStart8.setEnabled(true);
                bStop8.setEnabled(false);
                SfTimes[7] = String.format("%.3f", (double)ARRTchronometer8.getTimeElapsed() / 1000);
                break;
            case R.id.b608:
                ARRTchronometer8.setText("01:00:0");
                SfTimes[7] = "60.000";
                break;
            case R.id.ARRTchronometer8:
                ARRTinputTimes(7);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart9:
                ARRTchronometer9.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer9.start();
                bStart9.setEnabled(false);
                bStop9.setEnabled(true);
                ARRTchronometer9.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart9.setEnabled(true);
                            bStop9.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[8] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop9:
                ARRTchronometer9.stop();
                bStart9.setEnabled(true);
                bStop9.setEnabled(false);
                SfTimes[8] = String.format("%.3f", (double)ARRTchronometer9.getTimeElapsed() / 1000);
                break;
            case R.id.b609:
                ARRTchronometer9.setText("01:00:0");
                SfTimes[8] = "60.000";
                break;
            case R.id.ARRTchronometer9:
                ARRTinputTimes(8);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart10:
                ARRTchronometer10.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer10.start();
                bStart10.setEnabled(false);
                bStop10.setEnabled(true);
                ARRTchronometer10.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart10.setEnabled(true);
                            bStop10.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[9] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop10:
                ARRTchronometer10.stop();
                bStart10.setEnabled(true);
                bStop10.setEnabled(false);
                SfTimes[9] = String.format("%.3f", (double)ARRTchronometer10.getTimeElapsed() / 1000);
                break;
            case R.id.b6010:
                ARRTchronometer10.setText("01:00:0");
                SfTimes[9] = "60.000";
                break;
            case R.id.ARRTchronometer10:
                ARRTinputTimes(9);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart11:
                ARRTchronometer11.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer11.start();
                bStart11.setEnabled(false);
                bStop11.setEnabled(true);
                ARRTchronometer11.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart11.setEnabled(true);
                            bStop11.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[10] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop11:
                ARRTchronometer11.stop();
                bStart11.setEnabled(true);
                bStop11.setEnabled(false);
                SfTimes[10] = String.format("%.3f", (double)ARRTchronometer11.getTimeElapsed() / 1000);
                break;
            case R.id.b6011:
                ARRTchronometer11.setText("01:00:0");
                SfTimes[10] = "60.000";
                break;
            case R.id.ARRTchronometer11:
                ARRTinputTimes(10);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart12:
                ARRTchronometer12.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer12.start();
                bStart12.setEnabled(false);
                bStop12.setEnabled(true);
                ARRTchronometer12.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart12.setEnabled(true);
                            bStop12.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[11] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop12:
                ARRTchronometer12.stop();
                bStart12.setEnabled(true);
                bStop12.setEnabled(false);
                SfTimes[11] = String.format("%.3f", (double)ARRTchronometer12.getTimeElapsed() / 1000);
                break;
            case R.id.b6012:
                ARRTchronometer12.setText("01:00:0");
                SfTimes[11] = "60.000";
                break;
            case R.id.ARRTchronometer12:
                ARRTinputTimes(11);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart13:
                ARRTchronometer13.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer13.start();
                bStart13.setEnabled(false);
                bStop13.setEnabled(true);
                ARRTchronometer13.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart13.setEnabled(true);
                            bStop13.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[12] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop13:
                ARRTchronometer13.stop();
                bStart13.setEnabled(true);
                bStop13.setEnabled(false);
                SfTimes[12] = String.format("%.3f", (double)ARRTchronometer13.getTimeElapsed() / 1000);
                break;
            case R.id.b6013:
                ARRTchronometer13.setText("01:00:0");
                SfTimes[12] = "60.000";
                break;
            case R.id.ARRTchronometer13:
                ARRTinputTimes(12);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart14:
                ARRTchronometer14.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer14.start();
                bStart14.setEnabled(false);
                bStop14.setEnabled(true);
                ARRTchronometer14.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart14.setEnabled(true);
                            bStop14.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[13] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop14:
                ARRTchronometer14.stop();
                bStart14.setEnabled(true);
                bStop14.setEnabled(false);
                SfTimes[13] = String.format("%.3f", (double)ARRTchronometer14.getTimeElapsed() / 1000);
                break;
            case R.id.b6014:
                ARRTchronometer14.setText("01:00:0");
                SfTimes[13] = "60.000";
                break;
            case R.id.ARRTchronometer14:
                ARRTinputTimes(13);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart15:
                ARRTchronometer15.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer15.start();
                bStart15.setEnabled(false);
                bStop15.setEnabled(true);
                ARRTchronometer15.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart15.setEnabled(true);
                            bStop15.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[14] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop15:
                ARRTchronometer15.stop();
                bStart15.setEnabled(true);
                bStop15.setEnabled(false);
                SfTimes[14] = String.format("%.3f", (double)ARRTchronometer15.getTimeElapsed() / 1000);
                break;
            case R.id.b6015:
                ARRTchronometer15.setText("01:00:0");
                SfTimes[14] = "60.000";
                break;
            case R.id.ARRTchronometer15:
                ARRTinputTimes(14);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart16:
                ARRTchronometer16.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer16.start();
                bStart16.setEnabled(false);
                bStop16.setEnabled(true);
                ARRTchronometer16.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart16.setEnabled(true);
                            bStop16.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[15] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop16:
                ARRTchronometer16.stop();
                bStart16.setEnabled(true);
                bStop16.setEnabled(false);
                SfTimes[15] = String.format("%.3f", (double)ARRTchronometer16.getTimeElapsed() / 1000);
                break;
            case R.id.b6016:
                ARRTchronometer16.setText("01:00:0");
                SfTimes[15] = "60.000";
                break;
            case R.id.ARRTchronometer16:
                ARRTinputTimes(15);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart17:
                ARRTchronometer17.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer17.start();
                bStart17.setEnabled(false);
                bStop17.setEnabled(true);
                ARRTchronometer17.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart17.setEnabled(true);
                            bStop17.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[16] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop17:
                ARRTchronometer17.stop();
                bStart17.setEnabled(true);
                bStop17.setEnabled(false);
                SfTimes[16] = String.format("%.3f", (double)ARRTchronometer17.getTimeElapsed() / 1000);
                break;
            case R.id.b6017:
                ARRTchronometer17.setText("01:00:0");
                SfTimes[16] = "60.000";
                break;
            case R.id.ARRTchronometer17:
                ARRTinputTimes(16);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart18:
                ARRTchronometer18.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer18.start();
                bStart18.setEnabled(false);
                bStop18.setEnabled(true);
                ARRTchronometer18.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart18.setEnabled(true);
                            bStop18.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[17] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop18:
                ARRTchronometer18.stop();
                bStart18.setEnabled(true);
                bStop18.setEnabled(false);
                SfTimes[17] = String.format("%.3f", (double)ARRTchronometer18.getTimeElapsed() / 1000);
                break;
            case R.id.b6018:
                ARRTchronometer18.setText("01:00:0");
                SfTimes[17] = "60.000";
                break;
            case R.id.ARRTchronometer18:
                ARRTinputTimes(17);
                break;
        }

        switch(v.getId()) {
            case R.id.bStart19:
                ARRTchronometer19.setBase(SystemClock.elapsedRealtime());
                ARRTchronometer19.start();
                bStart19.setEnabled(false);
                bStop19.setEnabled(true);
                ARRTchronometer19.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("01:00:0")) {
                            chronometer.stop();
                            bStart19.setEnabled(true);
                            bStop19.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 60 second time limit.", Toast.LENGTH_LONG).show();
                            SfTimes[18] = "60.000";
                        }
                    }
                });
                break;
            case R.id.bStop19:
                ARRTchronometer19.stop();
                bStart19.setEnabled(true);
                bStop19.setEnabled(false);
                SfTimes[18] = String.format("%.3f", (double)ARRTchronometer19.getTimeElapsed() / 1000);
                break;
            case R.id.b6019:
                ARRTchronometer19.setText("01:00:0");
                SfTimes[18] = "60.000";
                break;
            case R.id.ARRTchronometer19:
                ARRTinputTimes(18);
                break;
        }




        switch (v.getId()) {
            case R.id.radioButtonADM:
                radioButtonFU.setChecked(false);
                radioButtonDC.setChecked(false);
                radioButtonMP.setChecked(false);
                if (radioButtonADM.isChecked()) {
                    Event = "adm_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.radioButtonFU:
                radioButtonADM.setChecked(false);
                radioButtonDC.setChecked(false);
                radioButtonMP.setChecked(false);
                if (radioButtonFU.isChecked()) {
                    Event = "fu_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.radioButtonDC:
                radioButtonADM.setChecked(false);
                radioButtonFU.setChecked(false);
                radioButtonMP.setChecked(false);
                if (radioButtonDC.isChecked()) {
                    Event = "dc_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.radioButtonMP:
                radioButtonADM.setChecked(false);
                radioButtonFU.setChecked(false);
                radioButtonDC.setChecked(false);
                if (radioButtonMP.isChecked()) {
                    Event = "mp_arm_1";
                } else {
                    Event = "NULL";
                }
                break;

        }


        switch (v.getId()) {
            case R.id.Affectedleft:
                if (Affectedleft.isChecked()) {
                    affected.add("left");
                } else {
                    affected.remove("left");
                }
                break;
            case R.id.Affectedright:
                if (Affectedright.isChecked()) {
                    affected.add("right");
                } else {
                    affected.remove("right");
                }
                break;
        }



        switch (v.getId()) {
            case R.id.bDone:

                inputcheck = new ArrayList<>();

                if (!radioButtonADM.isChecked() && !radioButtonDC.isChecked() && !radioButtonFU.isChecked() &&!radioButtonMP.isChecked()) {
                    inputcheck.add("Session");
                }

                if (!Affectedleft.isChecked() && !Affectedright.isChecked()) {
                    inputcheck.add("Impaired Limb");
                }

                if (!AARTA10.isChecked() && !AARTA11.isChecked() && !AARTA12.isChecked() && !AARTA13.isChecked()) {
                    inputcheck.add("A1");
                }
                if (!AARTA20.isChecked() && !AARTA21.isChecked() && !AARTA22.isChecked() && !AARTA23.isChecked()) {
                    inputcheck.add("A2");
                }
                if (!AARTA30.isChecked() && !AARTA31.isChecked() && !AARTA32.isChecked() && !AARTA33.isChecked()) {
                    inputcheck.add("A3");
                }
                if (!AARTA40.isChecked() && !AARTA41.isChecked() && !AARTA42.isChecked() && !AARTA43.isChecked()) {
                    inputcheck.add("A4");
                }
                if (!AARTA50.isChecked() && !AARTA51.isChecked() && !AARTA52.isChecked() && !AARTA53.isChecked()) {
                    inputcheck.add("A5");
                }
                if (!AARTA60.isChecked() && !AARTA61.isChecked() && !AARTA62.isChecked() && !AARTA63.isChecked()) {
                    inputcheck.add("A6");
                }

                if (!AARTB10.isChecked() && !AARTB11.isChecked() && !AARTB12.isChecked() && !AARTB13.isChecked()) {
                    inputcheck.add("B1");
                }
                if (!AARTB20.isChecked() && !AARTB21.isChecked() && !AARTB22.isChecked() && !AARTB23.isChecked()) {
                    inputcheck.add("B2");
                }
                if (!AARTB30.isChecked() && !AARTB31.isChecked() && !AARTB32.isChecked() && !AARTB33.isChecked()) {
                    inputcheck.add("B3");
                }
                if (!AARTB40.isChecked() && !AARTB41.isChecked() && !AARTB42.isChecked() && !AARTB43.isChecked()) {
                    inputcheck.add("B4");
                }

                if (!AARTC10.isChecked() && !AARTC11.isChecked() && !AARTC12.isChecked() && !AARTC13.isChecked()) {
                    inputcheck.add("C1");
                }
                if (!AARTC20.isChecked() && !AARTC21.isChecked() && !AARTC22.isChecked() && !AARTC23.isChecked()) {
                    inputcheck.add("C2");
                }
                if (!AARTC30.isChecked() && !AARTC31.isChecked() && !AARTC32.isChecked() && !AARTC33.isChecked()) {
                    inputcheck.add("C3");
                }
                if (!AARTC40.isChecked() && !AARTC41.isChecked() && !AARTC42.isChecked() && !AARTC43.isChecked()) {
                    inputcheck.add("C4");
                }
                if (!AARTC50.isChecked() && !AARTC51.isChecked() && !AARTC52.isChecked() && !AARTC53.isChecked()) {
                    inputcheck.add("C5");
                }
                if (!AARTC60.isChecked() && !AARTC61.isChecked() && !AARTC62.isChecked() && !AARTC63.isChecked()) {
                    inputcheck.add("C6");
                }

                if (!AARTD10.isChecked() && !AARTD11.isChecked() && !AARTD12.isChecked() && !AARTD13.isChecked()) {
                    inputcheck.add("D1");
                }
                if (!AARTD20.isChecked() && !AARTD21.isChecked() && !AARTD22.isChecked() && !AARTD23.isChecked()) {
                    inputcheck.add("D2");
                }
                if (!AARTD30.isChecked() && !AARTD31.isChecked() && !AARTD32.isChecked() && !AARTD33.isChecked()) {
                    inputcheck.add("D3");
                }


                joined = TextUtils.join(", ", inputcheck);

                if (inputcheck.size() > 0) {
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



                    String multiLines = String.valueOf(getLines(comments));
                    String FinalLine = multiLines.substring(1, multiLines.length()-1);
                    String[] commentSplit;
                    String delimiter = ", ";
                    commentSplit = FinalLine.split(delimiter);

                    for (int i = 0; i < commentSplit.length; i++){
                        Log.d("@@@@@@", commentSplit[i]);
                    }



                    if (AARTA13.isChecked()){
                        SfTimes[1] = "N/A";
                        SfTimes[2] = "N/A";
                        SfTimes[3] = "N/A";
                        SfTimes[4] = "N/A";
                        SfTimes[5] = "N/A";
                    }
                    if (AARTB13.isChecked()){
                        SfTimes[7] = "N/A";
                        SfTimes[8] = "N/A";
                        SfTimes[9] = "N/A";
                    }
                    if (AARTC13.isChecked()){
                        SfTimes[11] = "N/A";
                        SfTimes[12] = "N/A";
                        SfTimes[13] = "N/A";
                        SfTimes[14] = "N/A";
                        SfTimes[15] = "N/A";
                    }
                    if (AARTD13.isChecked()){
                        SfTimes[17] = "N/A";
                        SfTimes[18] = "N/A";
                    }


                    if (AARTA20.isChecked() && AARTA10.isChecked()){
                        SfTimes[2] = "N/A";
                        SfTimes[3] = "N/A";
                        SfTimes[4] = "N/A";
                        SfTimes[5] = "N/A";
                    }
                    if (AARTB20.isChecked() && AARTB10.isChecked()){
                        SfTimes[8] = "N/A";
                        SfTimes[9] = "N/A";
                    }
                    if (AARTC20.isChecked() && AARTC10.isChecked()){
                        SfTimes[12] = "N/A";
                        SfTimes[13] = "N/A";
                        SfTimes[14] = "N/A";
                        SfTimes[15] = "N/A";
                    }
                    if (AARTD20.isChecked() && AARTD10.isChecked()){
                        SfTimes[18] = "N/A";
                    }


                     Intent Answers = new Intent(ARRT.this, ARRTconf.class);
                     Answers.putExtra("AARTQA1", AARTQA1);
                     Answers.putExtra("AARTQA2", AARTQA2);
                     Answers.putExtra("AARTQA3", AARTQA3);
                     Answers.putExtra("AARTQA4", AARTQA4);
                     Answers.putExtra("AARTQA5", AARTQA5);
                     Answers.putExtra("AARTQA6", AARTQA6);

                     Answers.putExtra("AARTQB1", AARTQB1);
                     Answers.putExtra("AARTQB2", AARTQB2);
                     Answers.putExtra("AARTQB3", AARTQB3);
                     Answers.putExtra("AARTQB4", AARTQB4);

                     Answers.putExtra("AARTQC1", AARTQC1);
                     Answers.putExtra("AARTQC2", AARTQC2);
                     Answers.putExtra("AARTQC3", AARTQC3);
                     Answers.putExtra("AARTQC4", AARTQC4);
                     Answers.putExtra("AARTQC5", AARTQC5);
                     Answers.putExtra("AARTQC6", AARTQC6);

                     Answers.putExtra("AARTQD1", AARTQD1);
                     Answers.putExtra("AARTQD2", AARTQD2);
                     Answers.putExtra("AARTQD3", AARTQD3);

                    Answers.putExtra("AARTQA", AARTQA);
                    Answers.putExtra("AARTQB", AARTQB);
                    Answers.putExtra("AARTQC", AARTQC);
                    Answers.putExtra("AARTQD", AARTQD);
                    Answers.putExtra("AARTQTotal", AARTQTotal);


                     Answers.putExtra("AARTTime1", SfTimes[0]);
                     Answers.putExtra("AARTTime2", SfTimes[1]);
                     Answers.putExtra("AARTTime3", SfTimes[2]);
                     Answers.putExtra("AARTTime4", SfTimes[3]);
                     Answers.putExtra("AARTTime5", SfTimes[4]);
                     Answers.putExtra("AARTTime6", SfTimes[5]);
                     Answers.putExtra("AARTTime7", SfTimes[6]);
                     Answers.putExtra("AARTTime8", SfTimes[7]);
                     Answers.putExtra("AARTTime9", SfTimes[8]);
                     Answers.putExtra("AARTTime10",SfTimes[9]);
                     Answers.putExtra("AARTTime11", SfTimes[10]);
                     Answers.putExtra("AARTTime12", SfTimes[11]);
                     Answers.putExtra("AARTTime13", SfTimes[12]);
                     Answers.putExtra("AARTTime14", SfTimes[13]);
                     Answers.putExtra("AARTTime15", SfTimes[14]);
                     Answers.putExtra("AARTTime16", SfTimes[15]);
                     Answers.putExtra("AARTTime17", SfTimes[16]);
                     Answers.putExtra("AARTTime18", SfTimes[17]);
                     Answers.putExtra("AARTTime19", SfTimes[18]);

                     Answers.putExtra("comments", commentSplit);

                     Answers.putExtra("Affected", affected);

                     Answers.putExtra("Event", Event);
                     Answers.putExtra("PatientID", PatID);
                     Answers.putExtra("Date", Date);
                     startActivity(Answers);
                }

                break;

        }
    }





    public static List<CharSequence> getLines(EditText view) {
        final List<CharSequence> lines = new ArrayList<>();
        final Layout layout = view.getLayout();

        if (layout != null) {
            final int lineCount = layout.getLineCount();
            final CharSequence text = layout.getText();

            for (int i = 0, startIndex = 0; i < lineCount; i++) {
                final int endIndex = layout.getLineEnd(i);
                lines.add(text.subSequence(startIndex, endIndex));
                startIndex = endIndex;
            }
        }
        return lines;
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


    public void ARRTinputTimes(final int i){
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(ARRT.this);
        View promptView = layoutInflater.inflate(R.layout.input_time, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ARRT.this);
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
                                    SfTimes[i] = String.valueOf(fTimes[i]/1000);
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
