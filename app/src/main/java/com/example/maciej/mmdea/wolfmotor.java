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
import java.util.Objects;

/**
 * Created by Kenneth on 3/28/2016.
 */
public class wolfmotor extends AppCompatActivity implements  View.OnClickListener {

    EditText gripstrengthleftfirstnumber,gripstrengthleftsecondnumber, gripstrengthleftthirdnumber, gripstrengthrightfirstnumber, gripstrengthrightsecondnumber,gripstrengthrightthirdnumber, handboxweight;
    String PatID, Date, Event, joined, joined1, joined2, WolfmotorQ7, stringavgleft, stringavgright, stringnumleft1, stringnumleft2, stringnumleft3, stringnumright1, stringnumright2, stringnumright3;

    Button bDone, btnAvgleft, btnAvgright;

    CheckBox Unaffectedleft, Unaffectedright, Affectedleft, Affectedright;

    TextView wolfmotortotal, patientID, currentDateTimeString, avgleftResult, avgrightResult, wolfmotortotalwithweight, wolfmotortimetotal, numleft1result, numleft2result, numleft3result, numright1result, numright2result, numright3result;

    double WolfmotorQ1, WolfmotorQ2, WolfmotorQ3, WolfmotorQ4, WolfmotorQ5, WolfmotorQ6, WolfmotorQ8, WolfmotorQ9, WolfmotorQ10,
            WolfmotorQ11, WolfmotorQ12, WolfmotorQ13, WolfmotorQ14, WolfmotorQ15, WolfmotorQ16, WolfmotorQ17, WolfmotorQTotal, WolfmotorQTotalwithweight,
            numleft1, numleft2, numleft3, avgleft, avgright, numright1, numright2, numright3, handboxweight1, Wolfmotortimetotal, time_display1a,
            Time1, Time2, Time3, Time4, Time5, Time6, Time7, Time8, Time9, Time10, Time11, Time12, Time13, Time14, Time15, MSeconds;
    
    
    RadioButton radioButtonADM, radioButtonDC, radioButtonFU,radioButtonMP,
            Wolfmotor1a, Wolfmotor1b, Wolfmotor1c, Wolfmotor1d, Wolfmotor1e, Wolfmotor1f,
            Wolfmotor2a, Wolfmotor2b, Wolfmotor2c, Wolfmotor2d, Wolfmotor2e, Wolfmotor2f,
            Wolfmotor3a, Wolfmotor3b, Wolfmotor3c, Wolfmotor3d, Wolfmotor3e, Wolfmotor3f,
            Wolfmotor4a, Wolfmotor4b, Wolfmotor4c, Wolfmotor4d, Wolfmotor4e, Wolfmotor4f,
            Wolfmotor5a, Wolfmotor5b, Wolfmotor5c, Wolfmotor5d, Wolfmotor5e, Wolfmotor5f,
            Wolfmotor6a, Wolfmotor6b, Wolfmotor6c, Wolfmotor6d, Wolfmotor6e, Wolfmotor6f,
            Wolfmotor8a, Wolfmotor8b, Wolfmotor8c, Wolfmotor8d, Wolfmotor8e, Wolfmotor8f,
            Wolfmotor9a, Wolfmotor9b, Wolfmotor9c, Wolfmotor9d, Wolfmotor9e, Wolfmotor9f,
            Wolfmotor10a, Wolfmotor10b, Wolfmotor10c, Wolfmotor10d, Wolfmotor10e, Wolfmotor10f,
            Wolfmotor11a, Wolfmotor11b, Wolfmotor11c, Wolfmotor11d, Wolfmotor11e, Wolfmotor11f,
            Wolfmotor12a, Wolfmotor12b, Wolfmotor12c, Wolfmotor12d, Wolfmotor12e, Wolfmotor12f,
            Wolfmotor13a, Wolfmotor13b, Wolfmotor13c, Wolfmotor13d, Wolfmotor13e, Wolfmotor13f,
            Wolfmotor15a, Wolfmotor15b, Wolfmotor15c, Wolfmotor15d, Wolfmotor15e, Wolfmotor15f,
            Wolfmotor16a, Wolfmotor16b, Wolfmotor16c, Wolfmotor16d, Wolfmotor16e, Wolfmotor16f,
            Wolfmotor17a, Wolfmotor17b, Wolfmotor17c, Wolfmotor17d, Wolfmotor17e, Wolfmotor17f;


    Chronometer Wolfchronometer1, Wolfchronometer2, Wolfchronometer3, Wolfchronometer4, Wolfchronometer5, Wolfchronometer6,
            Wolfchronometer7, Wolfchronometer8, Wolfchronometer9, Wolfchronometer10, Wolfchronometer11, Wolfchronometer12,
            Wolfchronometer13, Wolfchronometer14, Wolfchronometer15;

    Button bStart1, bStart2, bStart3, bStart4, bStart5, bStart6,
            bStart7, bStart8, bStart9, bStart10, bStart11, bStart12,
            bStart13, bStart14, bStart15,
            bStop1, bStop2, bStop3, bStop4, bStop5, bStop6,
            bStop7, bStop8, bStop9, bStop10, bStop11, bStop12,
            bStop13, bStop14, bStop15, b1201, b1202, b1203, b1204, b1205, b1206, b1207, b1208, b1209, b12010, b12011, b12012, b12013, b12014, b12015;

    ArrayList<String> inputcheck, affected, unaffected;

    String[] Times;
    Chronometer[] chronometers;
    double[] fTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolfmotor);

        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Index Date: " + Date);


        affected = new ArrayList<>();
        unaffected = new ArrayList<>();



        Wolfchronometer1 = (Chronometer) findViewById(R.id.Wolfchronometer1);
        Wolfchronometer2 = (Chronometer) findViewById(R.id.Wolfchronometer2);
        Wolfchronometer3 = (Chronometer) findViewById(R.id.Wolfchronometer3);
        Wolfchronometer4 = (Chronometer) findViewById(R.id.Wolfchronometer4);
        Wolfchronometer5 = (Chronometer) findViewById(R.id.Wolfchronometer5);
        Wolfchronometer6 = (Chronometer) findViewById(R.id.Wolfchronometer6);
        Wolfchronometer7 = (Chronometer) findViewById(R.id.Wolfchronometer7);
        Wolfchronometer8 = (Chronometer) findViewById(R.id.Wolfchronometer8);
        Wolfchronometer9 = (Chronometer) findViewById(R.id.Wolfchronometer9);
        Wolfchronometer10 = (Chronometer) findViewById(R.id.Wolfchronometer10);
        Wolfchronometer11 = (Chronometer) findViewById(R.id.Wolfchronometer11);
        Wolfchronometer12 = (Chronometer) findViewById(R.id.Wolfchronometer12);
        Wolfchronometer13 = (Chronometer) findViewById(R.id.Wolfchronometer13);
        Wolfchronometer14 = (Chronometer) findViewById(R.id.Wolfchronometer14);
        Wolfchronometer15 = (Chronometer) findViewById(R.id.Wolfchronometer15);

        chronometers = new Chronometer[15];
        chronometers[0] = Wolfchronometer1;
        chronometers[1] = Wolfchronometer2;
        chronometers[2] = Wolfchronometer3;
        chronometers[3] = Wolfchronometer4;
        chronometers[4] = Wolfchronometer5;
        chronometers[5] = Wolfchronometer6;
        chronometers[6] = Wolfchronometer7;
        chronometers[7] = Wolfchronometer8;
        chronometers[8] = Wolfchronometer9;
        chronometers[9] = Wolfchronometer10;
        chronometers[10] = Wolfchronometer11;
        chronometers[11] = Wolfchronometer12;
        chronometers[12] = Wolfchronometer13;
        chronometers[13] = Wolfchronometer14;
        chronometers[14] = Wolfchronometer15;

        Wolfchronometer1.setOnClickListener(this);
        Wolfchronometer2.setOnClickListener(this);
        Wolfchronometer3.setOnClickListener(this);
        Wolfchronometer4.setOnClickListener(this);
        Wolfchronometer5.setOnClickListener(this);
        Wolfchronometer6.setOnClickListener(this);
        Wolfchronometer7.setOnClickListener(this);
        Wolfchronometer8.setOnClickListener(this);
        Wolfchronometer9.setOnClickListener(this);
        Wolfchronometer10.setOnClickListener(this);
        Wolfchronometer11.setOnClickListener(this);
        Wolfchronometer12.setOnClickListener(this);
        Wolfchronometer13.setOnClickListener(this);
        Wolfchronometer14.setOnClickListener(this);
        Wolfchronometer15.setOnClickListener(this);

        b1201 = (Button) findViewById(R.id.b1201);
        b1202 = (Button) findViewById(R.id.b1202);
        b1203 = (Button) findViewById(R.id.b1203);
        b1204 = (Button) findViewById(R.id.b1204);
        b1205 = (Button) findViewById(R.id.b1205);
        b1206 = (Button) findViewById(R.id.b1206);
        b1207 = (Button) findViewById(R.id.b1207);
        b1208 = (Button) findViewById(R.id.b1208);
        b1209 = (Button) findViewById(R.id.b1209);
        b12010 = (Button) findViewById(R.id.b12010);
        b12011 = (Button) findViewById(R.id.b12011);
        b12012 = (Button) findViewById(R.id.b12012);
        b12013 = (Button) findViewById(R.id.b12013);
        b12014 = (Button) findViewById(R.id.b12014);
        b12015 = (Button) findViewById(R.id.b12015);

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

        b1201.setOnClickListener(this);
        b1202.setOnClickListener(this);
        b1203.setOnClickListener(this);
        b1204.setOnClickListener(this);
        b1205.setOnClickListener(this);
        b1206.setOnClickListener(this);
        b1207.setOnClickListener(this);
        b1208.setOnClickListener(this);
        b1209.setOnClickListener(this);
        b12010.setOnClickListener(this);
        b12011.setOnClickListener(this);
        b12012.setOnClickListener(this);
        b12013.setOnClickListener(this);
        b12014.setOnClickListener(this);
        b12015.setOnClickListener(this);



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


        Time1 = Double.parseDouble("0");
        Time2 = Double.parseDouble("0");
        Time3 = Double.parseDouble("0");
        Time4 = Double.parseDouble("0");
        Time5 = Double.parseDouble("0");
        Time6 = Double.parseDouble("0");
        Time7 = Double.parseDouble("0");
        Time8 = Double.parseDouble("0");
        Time9 = Double.parseDouble("0");
        Time10 = Double.parseDouble("0");
        Time11 = Double.parseDouble("0");
        Time12 = Double.parseDouble("0");
        Time13 = Double.parseDouble("0");
        Time14 = Double.parseDouble("0");
        Time15 = Double.parseDouble("0");

        fTimes = new double[15];
        fTimes[0] = Time1;
        fTimes[1] = Time2;
        fTimes[2] = Time3;
        fTimes[3] = Time4;
        fTimes[4] = Time5;
        fTimes[5] = Time6;
        fTimes[6] = Time7;
        fTimes[7] = Time8;
        fTimes[8] = Time9;
        fTimes[9] = Time10;
        fTimes[10] = Time11;
        fTimes[11] = Time12;
        fTimes[12] = Time13;
        fTimes[13] = Time14;
        fTimes[14] = Time15;



        handboxweight = (EditText)findViewById(R.id.Wolfmotor7);
        gripstrengthleftfirstnumber = (EditText)findViewById(R.id.gripstrengthleft1);
        gripstrengthleftsecondnumber = (EditText)findViewById(R.id.gripstrengthleft2);
        gripstrengthleftthirdnumber = (EditText)findViewById(R.id.gripstrengthleft3);
        gripstrengthrightfirstnumber = (EditText)findViewById(R.id.gripstrengthright1);
        gripstrengthrightsecondnumber = (EditText)findViewById(R.id.gripstrengthright2);
        gripstrengthrightthirdnumber = (EditText)findViewById(R.id.gripstrengthright3);

        avgleftResult = (TextView)findViewById(R.id.txtResultleft);
        avgrightResult = (TextView)findViewById(R.id.txtResultright);

        btnAvgleft = (Button)findViewById(R.id.btnAvgleft);
        btnAvgright = (Button)findViewById(R.id.btnAvgRight);

        Event = "NULL";


        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);

        wolfmotortotal = (TextView) findViewById(R.id.wolfmotortotal);
        wolfmotortimetotal = (TextView) findViewById(R.id.wolfmotortimetotal);

        Wolfmotortimetotal = Double.parseDouble("0");


        numleft1 = Double.parseDouble("0");
        numleft2 = Double.parseDouble("0");
        numleft3 = Double.parseDouble("0");
        numright1 = Double.parseDouble("0");
        numright2 = Double.parseDouble("0");
        numright3 = Double.parseDouble("0");
        WolfmotorQ1 = Double.parseDouble("0");
        WolfmotorQ2 = Double.parseDouble("0");
        WolfmotorQ3 = Double.parseDouble("0");
        WolfmotorQ4 = Double.parseDouble("0");
        WolfmotorQ5 = Double.parseDouble("0");
        WolfmotorQ6 = Double.parseDouble("0");
        WolfmotorQ8 = Double.parseDouble("0");
        WolfmotorQ9 = Double.parseDouble("0");
        WolfmotorQ10 = Double.parseDouble("0");
        WolfmotorQ11 = Double.parseDouble("0");
        WolfmotorQ12 = Double.parseDouble("0");
        WolfmotorQ13 = Double.parseDouble("0");
        WolfmotorQ14 = Double.parseDouble("0");
        WolfmotorQ15 = Double.parseDouble("0");
        WolfmotorQ16 = Double.parseDouble("0");
        WolfmotorQ17 = Double.parseDouble("0");

        Wolfmotor1a = (RadioButton) findViewById(R.id.Wolfmotor1a);
        Wolfmotor1b = (RadioButton) findViewById(R.id.Wolfmotor1b);
        Wolfmotor1c = (RadioButton) findViewById(R.id.Wolfmotor1c);
        Wolfmotor1d = (RadioButton) findViewById(R.id.Wolfmotor1d);
        Wolfmotor1e = (RadioButton) findViewById(R.id.Wolfmotor1e);
        Wolfmotor1f = (RadioButton) findViewById(R.id.Wolfmotor1f);
        Wolfmotor2a = (RadioButton) findViewById(R.id.Wolfmotor2a);
        Wolfmotor2b = (RadioButton) findViewById(R.id.Wolfmotor2b);
        Wolfmotor2c = (RadioButton) findViewById(R.id.Wolfmotor2c);
        Wolfmotor2d = (RadioButton) findViewById(R.id.Wolfmotor2d);
        Wolfmotor2e = (RadioButton) findViewById(R.id.Wolfmotor2e);
        Wolfmotor2f = (RadioButton) findViewById(R.id.Wolfmotor2f);
        Wolfmotor3a = (RadioButton) findViewById(R.id.Wolfmotor3a);
        Wolfmotor3b = (RadioButton) findViewById(R.id.Wolfmotor3b);
        Wolfmotor3c = (RadioButton) findViewById(R.id.Wolfmotor3c);
        Wolfmotor3d = (RadioButton) findViewById(R.id.Wolfmotor3d);
        Wolfmotor3e = (RadioButton) findViewById(R.id.Wolfmotor3e);
        Wolfmotor3f = (RadioButton) findViewById(R.id.Wolfmotor3f);
        Wolfmotor4a = (RadioButton) findViewById(R.id.Wolfmotor4a);
        Wolfmotor4b = (RadioButton) findViewById(R.id.Wolfmotor4b);
        Wolfmotor4c = (RadioButton) findViewById(R.id.Wolfmotor4c);
        Wolfmotor4d = (RadioButton) findViewById(R.id.Wolfmotor4d);
        Wolfmotor4e = (RadioButton) findViewById(R.id.Wolfmotor4e);
        Wolfmotor4f = (RadioButton) findViewById(R.id.Wolfmotor4f);
        Wolfmotor5a = (RadioButton) findViewById(R.id.Wolfmotor5a);
        Wolfmotor5b = (RadioButton) findViewById(R.id.Wolfmotor5b);
        Wolfmotor5c = (RadioButton) findViewById(R.id.Wolfmotor5c);
        Wolfmotor5d = (RadioButton) findViewById(R.id.Wolfmotor5d);
        Wolfmotor5e = (RadioButton) findViewById(R.id.Wolfmotor5e);
        Wolfmotor5f = (RadioButton) findViewById(R.id.Wolfmotor5f);
        Wolfmotor6a = (RadioButton) findViewById(R.id.Wolfmotor6a);
        Wolfmotor6b = (RadioButton) findViewById(R.id.Wolfmotor6b);
        Wolfmotor6c = (RadioButton) findViewById(R.id.Wolfmotor6c);
        Wolfmotor6d = (RadioButton) findViewById(R.id.Wolfmotor6d);
        Wolfmotor6e = (RadioButton) findViewById(R.id.Wolfmotor6e);
        Wolfmotor6f = (RadioButton) findViewById(R.id.Wolfmotor6f);
        Wolfmotor8a = (RadioButton) findViewById(R.id.Wolfmotor8a);
        Wolfmotor8b = (RadioButton) findViewById(R.id.Wolfmotor8b);
        Wolfmotor8c = (RadioButton) findViewById(R.id.Wolfmotor8c);
        Wolfmotor8d = (RadioButton) findViewById(R.id.Wolfmotor8d);
        Wolfmotor8e = (RadioButton) findViewById(R.id.Wolfmotor8e);
        Wolfmotor8f = (RadioButton) findViewById(R.id.Wolfmotor8f);
        Wolfmotor9a = (RadioButton) findViewById(R.id.Wolfmotor9a);
        Wolfmotor9b = (RadioButton) findViewById(R.id.Wolfmotor9b);
        Wolfmotor9c = (RadioButton) findViewById(R.id.Wolfmotor9c);
        Wolfmotor9d = (RadioButton) findViewById(R.id.Wolfmotor9d);
        Wolfmotor9e = (RadioButton) findViewById(R.id.Wolfmotor9e);
        Wolfmotor9f = (RadioButton) findViewById(R.id.Wolfmotor9f);
        Wolfmotor10a = (RadioButton) findViewById(R.id.Wolfmotor10a);
        Wolfmotor10b = (RadioButton) findViewById(R.id.Wolfmotor10b);
        Wolfmotor10c = (RadioButton) findViewById(R.id.Wolfmotor10c);
        Wolfmotor10d = (RadioButton) findViewById(R.id.Wolfmotor10d);
        Wolfmotor10e = (RadioButton) findViewById(R.id.Wolfmotor10e);
        Wolfmotor10f = (RadioButton) findViewById(R.id.Wolfmotor10f);
        Wolfmotor11a = (RadioButton) findViewById(R.id.Wolfmotor11a);
        Wolfmotor11b = (RadioButton) findViewById(R.id.Wolfmotor11b);
        Wolfmotor11c = (RadioButton) findViewById(R.id.Wolfmotor11c);
        Wolfmotor11d = (RadioButton) findViewById(R.id.Wolfmotor11d);
        Wolfmotor11e = (RadioButton) findViewById(R.id.Wolfmotor11e);
        Wolfmotor11f = (RadioButton) findViewById(R.id.Wolfmotor11f);
        Wolfmotor12a = (RadioButton) findViewById(R.id.Wolfmotor12a);
        Wolfmotor12b = (RadioButton) findViewById(R.id.Wolfmotor12b);
        Wolfmotor12c = (RadioButton) findViewById(R.id.Wolfmotor12c);
        Wolfmotor12d = (RadioButton) findViewById(R.id.Wolfmotor12d);
        Wolfmotor12e = (RadioButton) findViewById(R.id.Wolfmotor12e);
        Wolfmotor12f = (RadioButton) findViewById(R.id.Wolfmotor12f);
        Wolfmotor13a = (RadioButton) findViewById(R.id.Wolfmotor13a);
        Wolfmotor13b = (RadioButton) findViewById(R.id.Wolfmotor13b);
        Wolfmotor13c = (RadioButton) findViewById(R.id.Wolfmotor13c);
        Wolfmotor13d = (RadioButton) findViewById(R.id.Wolfmotor13d);
        Wolfmotor13e = (RadioButton) findViewById(R.id.Wolfmotor13e);
        Wolfmotor13f = (RadioButton) findViewById(R.id.Wolfmotor13f);
        Wolfmotor15a = (RadioButton) findViewById(R.id.Wolfmotor15a);
        Wolfmotor15b = (RadioButton) findViewById(R.id.Wolfmotor15b);
        Wolfmotor15c = (RadioButton) findViewById(R.id.Wolfmotor15c);
        Wolfmotor15d = (RadioButton) findViewById(R.id.Wolfmotor15d);
        Wolfmotor15e = (RadioButton) findViewById(R.id.Wolfmotor15e);
        Wolfmotor15f = (RadioButton) findViewById(R.id.Wolfmotor15f);
        Wolfmotor16a = (RadioButton) findViewById(R.id.Wolfmotor16a);
        Wolfmotor16b = (RadioButton) findViewById(R.id.Wolfmotor16b);
        Wolfmotor16c = (RadioButton) findViewById(R.id.Wolfmotor16c);
        Wolfmotor16d = (RadioButton) findViewById(R.id.Wolfmotor16d);
        Wolfmotor16e = (RadioButton) findViewById(R.id.Wolfmotor16e);
        Wolfmotor16f = (RadioButton) findViewById(R.id.Wolfmotor16f);
        Wolfmotor17a = (RadioButton) findViewById(R.id.Wolfmotor17a);
        Wolfmotor17b = (RadioButton) findViewById(R.id.Wolfmotor17b);
        Wolfmotor17c = (RadioButton) findViewById(R.id.Wolfmotor17c);
        Wolfmotor17d = (RadioButton) findViewById(R.id.Wolfmotor17d);
        Wolfmotor17e = (RadioButton) findViewById(R.id.Wolfmotor17e);
        Wolfmotor17f = (RadioButton) findViewById(R.id.Wolfmotor17f);


        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);


        Unaffectedleft = (CheckBox) findViewById(R.id.Unaffectedleft);
        Unaffectedleft.setOnClickListener(this);
        Unaffectedright = (CheckBox) findViewById(R.id.Unaffectedright);
        Unaffectedright.setOnClickListener(this);
        Affectedleft = (CheckBox) findViewById(R.id.Affectedleft);
        Affectedleft.setOnClickListener(this);
        Affectedright = (CheckBox) findViewById(R.id.Affectedright);
        Affectedright.setOnClickListener(this);


        btnAvgleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(gripstrengthleftfirstnumber.getText().toString(),"")){

                }

                else if (Objects.equals(gripstrengthleftsecondnumber.getText().toString(),"")) {
                }

                else if(Objects.equals(gripstrengthleftthirdnumber.getText().toString(),"")) {
                }

                else {
                    numleft1 = Double.parseDouble(gripstrengthleftfirstnumber.getText().toString());
                    numleft2 = Double.parseDouble(gripstrengthleftsecondnumber.getText().toString());
                    numleft3 = Double.parseDouble(gripstrengthleftthirdnumber.getText().toString());
                    stringavgleft = String.format("%.3f", ((numleft1 + numleft2 + numleft3)/3));
                    avgleftResult.setText(stringavgleft);




                }





            }
        });
        btnAvgright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(gripstrengthrightfirstnumber.getText().toString(),"")){

                }
                else if (Objects.equals(gripstrengthrightsecondnumber.getText().toString(),"")){

                }
                else if (Objects.equals(gripstrengthrightthirdnumber.getText().toString(), "")) {

                }
                else {
                    numright1 = Double.parseDouble(gripstrengthrightfirstnumber.getText().toString());
                    numright2 = Double.parseDouble(gripstrengthrightsecondnumber.getText().toString());
                    numright3 = Double.parseDouble(gripstrengthrightthirdnumber.getText().toString());
                    stringavgright = String.format("%.3f",((numright1 + numright2 + numright3) / 3));
                    avgrightResult.setText(stringavgright);


                }

            }
        });
    }




    public void Wolfmotor(View view) {


        switch (view.getId()) {

            case R.id.Wolfmotor1a:
                WolfmotorQ1 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor1b:
                WolfmotorQ1 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor1c:
                WolfmotorQ1 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor1d:
                WolfmotorQ1 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor1e:
                WolfmotorQ1 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor1f:
                WolfmotorQ1 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor2a:
                WolfmotorQ2 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor2b:
                WolfmotorQ2 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor2c:
                WolfmotorQ2 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor2d:
                WolfmotorQ2 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor2e:
                WolfmotorQ2 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor2f:
                WolfmotorQ2 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor3a:
                WolfmotorQ3 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor3b:
                WolfmotorQ3 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor3c:
                WolfmotorQ3 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor3d:
                WolfmotorQ3 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor3e:
                WolfmotorQ3 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor3f:
                WolfmotorQ3 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor4a:
                WolfmotorQ4 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor4b:
                WolfmotorQ4 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor4c:
                WolfmotorQ4 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor4d:
                WolfmotorQ4 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor4e:
                WolfmotorQ4 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor4f:
                WolfmotorQ4 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor5a:
                WolfmotorQ5 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor5b:
                WolfmotorQ5 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor5c:
                WolfmotorQ5 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor5d:
                WolfmotorQ5 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor5e:
                WolfmotorQ5 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor5f:
                WolfmotorQ5 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor6a:
                WolfmotorQ6 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor6b:
                WolfmotorQ6 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor6c:
                WolfmotorQ6 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor6d:
                WolfmotorQ6 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor6e:
                WolfmotorQ6 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor6f:
                WolfmotorQ6 = Double.parseDouble("5");
                break;
        }

        switch (view.getId()) {

            case R.id.Wolfmotor8a:
                WolfmotorQ8 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor8b:
                WolfmotorQ8 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor8c:
                WolfmotorQ8 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor8d:
                WolfmotorQ8 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor8e:
                WolfmotorQ8 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor8f:
                WolfmotorQ8 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor9a:
                WolfmotorQ9 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor9b:
                WolfmotorQ9 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor9c:
                WolfmotorQ9 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor9d:
                WolfmotorQ9 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor9e:
                WolfmotorQ9 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor9f:
                WolfmotorQ9 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor9a:
                WolfmotorQ9 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor9b:
                WolfmotorQ9 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor9c:
                WolfmotorQ9 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor9d:
                WolfmotorQ9 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor9e:
                WolfmotorQ9 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor9f:
                WolfmotorQ9 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor10a:
                WolfmotorQ10 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor10b:
                WolfmotorQ10 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor10c:
                WolfmotorQ10 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor10d:
                WolfmotorQ10 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor10e:
                WolfmotorQ10 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor10f:
                WolfmotorQ10 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor11a:
                WolfmotorQ11 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor11b:
                WolfmotorQ11 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor11c:
                WolfmotorQ11 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor11d:
                WolfmotorQ11 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor11e:
                WolfmotorQ11 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor11f:
                WolfmotorQ11 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor12a:
                WolfmotorQ12 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor12b:
                WolfmotorQ12 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor12c:
                WolfmotorQ12 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor12d:
                WolfmotorQ12 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor12e:
                WolfmotorQ12 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor12f:
                WolfmotorQ12 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor13a:
                WolfmotorQ13 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor13b:
                WolfmotorQ13 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor13c:
                WolfmotorQ13 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor13d:
                WolfmotorQ13 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor13e:
                WolfmotorQ13 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor13f:
                WolfmotorQ13 = Double.parseDouble("5");
                break;
        }

        switch (view.getId()) {

            case R.id.Wolfmotor15a:
                WolfmotorQ15 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor15b:
                WolfmotorQ15 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor15c:
                WolfmotorQ15 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor15d:
                WolfmotorQ15 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor15e:
                WolfmotorQ15 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor15f:
                WolfmotorQ15 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor16a:
                WolfmotorQ16 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor16b:
                WolfmotorQ16 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor16c:
                WolfmotorQ16 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor16d:
                WolfmotorQ16 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor16e:
                WolfmotorQ16 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor16f:
                WolfmotorQ16 = Double.parseDouble("5");
                break;
        }
        switch (view.getId()) {

            case R.id.Wolfmotor17a:
                WolfmotorQ17 = Double.parseDouble("0");
                break;
            case R.id.Wolfmotor17b:
                WolfmotorQ17 = Double.parseDouble("1");
                break;
            case R.id.Wolfmotor17c:
                WolfmotorQ17 = Double.parseDouble("2");
                break;
            case R.id.Wolfmotor17d:
                WolfmotorQ17 = Double.parseDouble("3");
                break;
            case R.id.Wolfmotor17e:
                WolfmotorQ17 = Double.parseDouble("4");
                break;
            case R.id.Wolfmotor17f:
                WolfmotorQ17 = Double.parseDouble("5");
                break;
        }

        WolfmotorQTotal = WolfmotorQ1 + WolfmotorQ2 + WolfmotorQ3 + WolfmotorQ4 + WolfmotorQ5 + WolfmotorQ6 + WolfmotorQ8 + WolfmotorQ9 + WolfmotorQ10 + WolfmotorQ11 + WolfmotorQ12 + WolfmotorQ13 + WolfmotorQ15 + WolfmotorQ16 + WolfmotorQ17;
        wolfmotortotal.setText(String.valueOf(WolfmotorQTotal) );

    }

    @Override
    public void onClick(View v) {


        switch(v.getId()) {
            case R.id.bStart1:
                Wolfchronometer1.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer1.start();
                bStart1.setEnabled(false);
                bStop1.setEnabled(true);
                Wolfchronometer1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart1.setEnabled(true);
                            bStop1.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer1.setText("02:00:0");
                            fTimes[0] = Wolfchronometer1.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop1:
                Wolfchronometer1.stop();
                bStart1.setEnabled(true);
                bStop1.setEnabled(false);
                fTimes[0] = Wolfchronometer1.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1201:
                Wolfchronometer1.setText("02:00:0");
                fTimes[0] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart2:
                Wolfchronometer2.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer2.start();
                bStart2.setEnabled(false);
                bStop2.setEnabled(true);
                Wolfchronometer2.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart2.setEnabled(true);
                            bStop2.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer2.setText("02:00:0");
                            fTimes[1] = Wolfchronometer2.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop2:
                Wolfchronometer2.stop();
                bStart2.setEnabled(true);
                bStop2.setEnabled(false);
                fTimes[1] = Wolfchronometer2.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1202:
                Wolfchronometer2.setText("02:00:0");
                fTimes[1] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart3:
                Wolfchronometer3.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer3.start();
                bStart3.setEnabled(false);
                bStop3.setEnabled(true);
                Wolfchronometer3.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart3.setEnabled(true);
                            bStop3.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer3.setText("02:00:0");
                            fTimes[2] = Wolfchronometer3.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop3:
                Wolfchronometer3.stop();
                bStart3.setEnabled(true);
                bStop3.setEnabled(false);
                fTimes[2] = Wolfchronometer3.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1203:
                Wolfchronometer3.setText("02:00:0");
                fTimes[2] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart4:
                Wolfchronometer4.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer4.start();
                bStart4.setEnabled(false);
                bStop4.setEnabled(true);
                Wolfchronometer4.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart4.setEnabled(true);
                            bStop4.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer4.setText("02:00:0");
                            fTimes[3] = Wolfchronometer4.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop4:
                Wolfchronometer4.stop();
                bStart4.setEnabled(true);
                bStop4.setEnabled(false);
                fTimes[3] = Wolfchronometer4.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1204:
                Wolfchronometer4.setText("02:00:0");
                fTimes[3] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart5:
                Wolfchronometer5.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer5.start();
                bStart5.setEnabled(false);
                bStop5.setEnabled(true);
                Wolfchronometer5.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart5.setEnabled(true);
                            bStop5.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer5.setText("02:00:0");
                            fTimes[4] = Wolfchronometer2.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop5:
                Wolfchronometer5.stop();
                bStart5.setEnabled(true);
                bStop5.setEnabled(false);
                fTimes[4] = Wolfchronometer5.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1205:
                Wolfchronometer5.setText("02:00:0");
                fTimes[4] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart6:
                Wolfchronometer6.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer6.start();
                bStart6.setEnabled(false);
                bStop6.setEnabled(true);
                Wolfchronometer6.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart6.setEnabled(true);
                            bStop6.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer6.setText("02:00:0");
                            fTimes[5] = Wolfchronometer6.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop6:
                Wolfchronometer6.stop();
                bStart6.setEnabled(true);
                bStop6.setEnabled(false);
                fTimes[5] = Wolfchronometer6.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1206:
                Wolfchronometer6.setText("02:00:0");
                fTimes[5] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart7:
                Wolfchronometer7.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer7.start();
                bStart7.setEnabled(false);
                bStop7.setEnabled(true);
                Wolfchronometer7.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart7.setEnabled(true);
                            bStop7.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer7.setText("02:00:0");
                            fTimes[6] = Wolfchronometer7.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop7:
                Wolfchronometer7.stop();
                bStart7.setEnabled(true);
                bStop7.setEnabled(false);
                fTimes[6] = Wolfchronometer7.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1207:
                Wolfchronometer7.setText("02:00:0");
                fTimes[6] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart8:
                Wolfchronometer8.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer8.start();
                bStart8.setEnabled(false);
                bStop8.setEnabled(true);
                Wolfchronometer8.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart8.setEnabled(true);
                            bStop8.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer8.setText("02:00:0");
                            fTimes[7] = Wolfchronometer8.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop8:
                Wolfchronometer8.stop();
                bStart8.setEnabled(true);
                bStop8.setEnabled(false);
                fTimes[7] = Wolfchronometer8.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1208:
                Wolfchronometer8.setText("02:00:0");
                fTimes[7] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart9:
                Wolfchronometer9.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer9.start();
                bStart9.setEnabled(false);
                bStop9.setEnabled(true);
                Wolfchronometer9.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart9.setEnabled(true);
                            bStop9.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer9.setText("02:00:0");
                            fTimes[8] = Wolfchronometer9.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop9:
                Wolfchronometer9.stop();
                bStart9.setEnabled(true);
                bStop9.setEnabled(false);
                fTimes[8] = Wolfchronometer9.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b1209:
                Wolfchronometer9.setText("02:00:0");
                fTimes[8] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart10:
                Wolfchronometer10.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer10.start();
                bStart10.setEnabled(false);
                bStop10.setEnabled(true);
                Wolfchronometer10.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart10.setEnabled(true);
                            bStop10.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer10.setText("02:00:0");
                            fTimes[9] = Wolfchronometer10.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop10:
                Wolfchronometer10.stop();
                bStart10.setEnabled(true);
                bStop10.setEnabled(false);
                fTimes[9] = Wolfchronometer10.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12010:
                Wolfchronometer10.setText("02:00:0");
                fTimes[9] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart11:
                Wolfchronometer11.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer11.start();
                bStart11.setEnabled(false);
                bStop11.setEnabled(true);
                Wolfchronometer11.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart11.setEnabled(true);
                            bStop11.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer11.setText("02:00:0");
                            fTimes[10] = Wolfchronometer11.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop11:
                Wolfchronometer11.stop();
                bStart11.setEnabled(true);
                bStop11.setEnabled(false);
                fTimes[10] = Wolfchronometer11.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12011:
                Wolfchronometer11.setText("02:00:0");
                fTimes[10] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart12:
                Wolfchronometer12.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer12.start();
                bStart12.setEnabled(false);
                bStop12.setEnabled(true);
                Wolfchronometer12.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart12.setEnabled(true);
                            bStop12.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer12.setText("02:00:0");
                            fTimes[11] = Wolfchronometer12.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop12:
                Wolfchronometer12.stop();
                bStart12.setEnabled(true);
                bStop12.setEnabled(false);
                fTimes[11] = Wolfchronometer12.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12012:
                Wolfchronometer12.setText("02:00:0");
                fTimes[11] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart13:
                Wolfchronometer13.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer13.start();
                bStart13.setEnabled(false);
                bStop13.setEnabled(true);
                Wolfchronometer13.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart13.setEnabled(true);
                            bStop13.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer13.setText("02:00:0");
                            fTimes[12] = Wolfchronometer13.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop13:
                Wolfchronometer13.stop();
                bStart13.setEnabled(true);
                bStop13.setEnabled(false);
                fTimes[12] = Wolfchronometer13.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12013:
                Wolfchronometer13.setText("02:00:0");
                fTimes[12] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart14:
                Wolfchronometer14.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer14.start();
                bStart14.setEnabled(false);
                bStop14.setEnabled(true);
                Wolfchronometer14.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart14.setEnabled(true);
                            bStop14.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer14.setText("02:00:0");
                            fTimes[13] = Wolfchronometer14.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop14:
                Wolfchronometer14.stop();
                bStart14.setEnabled(true);
                bStop14.setEnabled(false);
                fTimes[13] = Wolfchronometer14.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12014:
                Wolfchronometer14.setText("02:00:0");
                fTimes[13] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.bStart15:
                Wolfchronometer15.setBase(SystemClock.elapsedRealtime());
                Wolfchronometer15.start();
                bStart15.setEnabled(false);
                bStop15.setEnabled(true);
                Wolfchronometer15.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    public void onChronometerTick(Chronometer chronometer) {
                        if (chronometer.getText().toString().equalsIgnoreCase("02:00:0")) {
                            chronometer.stop();
                            bStart15.setEnabled(true);
                            bStop15.setEnabled(false);
                            Toast.makeText(getBaseContext(), "Reached 120 second time limit.", Toast.LENGTH_LONG).show();
                            Wolfchronometer15.setText("02:00:0");
                            fTimes[14] = Wolfchronometer15.getTimeElapsed();
                            Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];                            wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                        }
                    }
                });
                break;
            case R.id.bStop15:
                Wolfchronometer15.stop();
                bStart15.setEnabled(true);
                bStop15.setEnabled(false);
                fTimes[14] = Wolfchronometer15.getTimeElapsed();
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;
            case R.id.b12015:
                Wolfchronometer15.setText("02:00:0");
                fTimes[14] = 120000;
                Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal/1000) + " seconds");
                break;

            case R.id.Wolfchronometer1:
                WMinputTimes(0);
                break;
            case R.id.Wolfchronometer2:
                WMinputTimes(1);
                break;
            case R.id.Wolfchronometer3:
                WMinputTimes(2);
                break;
            case R.id.Wolfchronometer4:
                WMinputTimes(3);
                break;
            case R.id.Wolfchronometer5:
                WMinputTimes(4);
                break;
            case R.id.Wolfchronometer6:
                WMinputTimes(5);
                break;
            case R.id.Wolfchronometer7:
                WMinputTimes(6);
                break;
            case R.id.Wolfchronometer8:
                WMinputTimes(7);
                break;
            case R.id.Wolfchronometer9:
                WMinputTimes(8);
                break;
            case R.id.Wolfchronometer10:
                WMinputTimes(9);
                break;
            case R.id.Wolfchronometer11:
                WMinputTimes(10);
                break;
            case R.id.Wolfchronometer12:
                WMinputTimes(11);
                break;
            case R.id.Wolfchronometer13:
                WMinputTimes(12);
                break;
            case R.id.Wolfchronometer14:
                WMinputTimes(13);
                break;
            case R.id.Wolfchronometer15:
                WMinputTimes(14);
                break;





        }


        switch (v.getId()) {
            case R.id.Unaffectedleft:
                if (Unaffectedleft.isChecked()) {
                    unaffected.add("left");
                } else {
                    unaffected.remove("left");
                }
                break;
            case R.id.Unaffectedright:
                if (Unaffectedright.isChecked()) {
                    unaffected.add("right");
                } else {
                    unaffected.remove("right");
                }
                break;
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
            case R.id.bDone:


                Double boxweight = Double.parseDouble("0");
                if (!Objects.equals(handboxweight.getText().toString(), "")) {
                    boxweight = Double.parseDouble(handboxweight.getText().toString());
                }


                inputcheck = new ArrayList<>();

                if (!Unaffectedleft.isChecked() && !Unaffectedright.isChecked() && !Affectedleft.isChecked() && !Affectedright.isChecked()) {
                    inputcheck.add("Affected/ Unaffected");
                }


                if (!radioButtonADM.isChecked() && !radioButtonDC.isChecked() && !radioButtonFU.isChecked() && !radioButtonMP.isChecked()) {
                    inputcheck.add("Session");
                }

                if (!Wolfmotor1a.isChecked() && !Wolfmotor1b.isChecked() && !Wolfmotor1c.isChecked() && !Wolfmotor1d.isChecked() && !Wolfmotor1e.isChecked() && !Wolfmotor1f.isChecked()) {
                    inputcheck.add("1");
                }

                if (!Wolfmotor2a.isChecked() && !Wolfmotor2b.isChecked() && !Wolfmotor2c.isChecked() && !Wolfmotor2d.isChecked() && !Wolfmotor2e.isChecked() && !Wolfmotor2f.isChecked()) {
                    inputcheck.add("2");
                }

                if (!Wolfmotor3a.isChecked() && !Wolfmotor3b.isChecked() && !Wolfmotor3c.isChecked() && !Wolfmotor3d.isChecked() && !Wolfmotor3e.isChecked() && !Wolfmotor3f.isChecked()) {
                    inputcheck.add("3");
                }

                if (!Wolfmotor4a.isChecked() && !Wolfmotor4b.isChecked() && !Wolfmotor4c.isChecked() && !Wolfmotor4d.isChecked() && !Wolfmotor4e.isChecked() && !Wolfmotor4f.isChecked()) {
                    inputcheck.add("4");
                }

                if (!Wolfmotor5a.isChecked() && !Wolfmotor5b.isChecked() && !Wolfmotor5c.isChecked() && !Wolfmotor5d.isChecked() && !Wolfmotor5e.isChecked() && !Wolfmotor5f.isChecked()) {
                    inputcheck.add("5");
                }

                if (!Wolfmotor6a.isChecked() && !Wolfmotor6b.isChecked() && !Wolfmotor6c.isChecked() && !Wolfmotor6d.isChecked() && !Wolfmotor6e.isChecked() && !Wolfmotor6f.isChecked()) {
                    inputcheck.add("6");
                }

                if (boxweight > 20) {
                    inputcheck.add("7(Value too large)");
                }

                if (boxweight < 1) {
                    inputcheck.add("7(Value too small)");
                }

                if (TextUtils.isEmpty(handboxweight.getText())){
                    inputcheck.add("7");
                }

                if (!Wolfmotor8a.isChecked() && !Wolfmotor8b.isChecked() && !Wolfmotor8c.isChecked() && !Wolfmotor8d.isChecked() && !Wolfmotor8e.isChecked() && !Wolfmotor8f.isChecked()) {
                    inputcheck.add("8");
                }

                if (!Wolfmotor9a.isChecked() && !Wolfmotor9b.isChecked() && !Wolfmotor9c.isChecked() && !Wolfmotor9d.isChecked() && !Wolfmotor9e.isChecked() && !Wolfmotor9f.isChecked()) {
                    inputcheck.add("9");
                }

                if (!Wolfmotor10a.isChecked() && !Wolfmotor10b.isChecked() && !Wolfmotor10c.isChecked() && !Wolfmotor10d.isChecked() && !Wolfmotor10e.isChecked() && !Wolfmotor10f.isChecked()) {
                    inputcheck.add("10");
                }

                if (!Wolfmotor11a.isChecked() && !Wolfmotor11b.isChecked() && !Wolfmotor11c.isChecked() && !Wolfmotor11d.isChecked() && !Wolfmotor11e.isChecked() && !Wolfmotor11f.isChecked()) {
                    inputcheck.add("11");
                }
                if (!Wolfmotor12a.isChecked() && !Wolfmotor12b.isChecked() && !Wolfmotor12c.isChecked() && !Wolfmotor12d.isChecked() && !Wolfmotor12e.isChecked() && !Wolfmotor12f.isChecked()) {
                    inputcheck.add("12");
                }
                if (!Wolfmotor13a.isChecked() && !Wolfmotor13b.isChecked() && !Wolfmotor13c.isChecked() && !Wolfmotor13d.isChecked() && !Wolfmotor13e.isChecked() && !Wolfmotor13f.isChecked()) {
                    inputcheck.add("13");
                }

                if (stringavgright == null) {
                    inputcheck.add("14(Right)");
                }
                if (stringavgleft == null) {
                    inputcheck.add("14(Left)");
                }


                if (!Wolfmotor15a.isChecked() && !Wolfmotor15b.isChecked() && !Wolfmotor15c.isChecked() && !Wolfmotor15d.isChecked() && !Wolfmotor15e.isChecked() && !Wolfmotor15f.isChecked()) {
                    inputcheck.add("15");
                }
                if (!Wolfmotor16a.isChecked() && !Wolfmotor16b.isChecked() && !Wolfmotor16c.isChecked() && !Wolfmotor16d.isChecked() && !Wolfmotor16e.isChecked() && !Wolfmotor16f.isChecked()) {
                    inputcheck.add("16");
                }
                if (!Wolfmotor17a.isChecked() && !Wolfmotor17b.isChecked() && !Wolfmotor17c.isChecked() && !Wolfmotor17d.isChecked() && !Wolfmotor17e.isChecked() && !Wolfmotor17f.isChecked()) {
                    inputcheck.add("17");
                }

                joined = TextUtils.join(", ", inputcheck);
                joined1 = TextUtils.join(", ", affected);
                joined2 = TextUtils.join(", ", unaffected);

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
                    Intent Answers = new Intent(wolfmotor.this, wolfmotorconf.class);
                    Answers.putExtra("WolfmotorQ14r", stringavgright);
                    Answers.putExtra("WolfmotorQ14l", stringavgleft);
                    Answers.putExtra("numright1", gripstrengthrightfirstnumber.getText().toString());
                    Answers.putExtra("numright2", gripstrengthrightsecondnumber.getText().toString());
                    Answers.putExtra("numright3", gripstrengthrightthirdnumber.getText().toString());
                    Answers.putExtra("numleft1", gripstrengthleftfirstnumber.getText().toString());
                    Answers.putExtra("numleft2", gripstrengthleftsecondnumber.getText().toString());
                    Answers.putExtra("numleft3", gripstrengthleftthirdnumber.getText().toString());
                    Answers.putExtra("WolfmotorQ7", handboxweight.getText().toString());
                    Answers.putExtra("WolfmotorQ1", WolfmotorQ1);
                    Answers.putExtra("WolfmotorQ2", WolfmotorQ2);
                    Answers.putExtra("WolfmotorQ3", WolfmotorQ3);
                    Answers.putExtra("WolfmotorQ4", WolfmotorQ4);
                    Answers.putExtra("WolfmotorQ5", WolfmotorQ5);
                    Answers.putExtra("WolfmotorQ6", WolfmotorQ6);
                    Answers.putExtra("WolfmotorQ8", WolfmotorQ8);
                    Answers.putExtra("WolfmotorQ9", WolfmotorQ9);
                    Answers.putExtra("WolfmotorQ10", WolfmotorQ10);
                    Answers.putExtra("WolfmotorQ11", WolfmotorQ11);
                    Answers.putExtra("WolfmotorQ12", WolfmotorQ12);
                    Answers.putExtra("WolfmotorQ13", WolfmotorQ13);
                    Answers.putExtra("WolfmotorQ15", WolfmotorQ15);
                    Answers.putExtra("WolfmotorQ16", WolfmotorQ16);
                    Answers.putExtra("WolfmotorQ17", WolfmotorQ17);
                    Answers.putExtra("WolfmotorQTotal", WolfmotorQTotal);
                    Answers.putExtra("Event", Event);
                    Answers.putExtra("affected", joined1);
                    Answers.putExtra("unaffected", joined2);
                    Answers.putExtra("wolfmotortime1", fTimes[0]);
                    Answers.putExtra("wolfmotortime2", fTimes[1]);
                    Answers.putExtra("wolfmotortime3", fTimes[2]);
                    Answers.putExtra("wolfmotortime4", fTimes[3]);
                    Answers.putExtra("wolfmotortime5", fTimes[4]);
                    Answers.putExtra("wolfmotortime6", fTimes[5]);
                    Answers.putExtra("wolfmotortime7", fTimes[6]);
                    Answers.putExtra("wolfmotortime8", fTimes[7]);
                    Answers.putExtra("wolfmotortime9", fTimes[8]);
                    Answers.putExtra("wolfmotortime10", fTimes[9]);
                    Answers.putExtra("wolfmotortime11", fTimes[10]);
                    Answers.putExtra("wolfmotortime12", fTimes[11]);
                    Answers.putExtra("wolfmotortime13", fTimes[12]);
                    Answers.putExtra("wolfmotortime14", fTimes[13]);
                    Answers.putExtra("wolfmotortime15", fTimes[14]);
                    Answers.putExtra("Wolfmotortimetotal", Wolfmotortimetotal);


                    Answers.putExtra("PatientID", PatID);
                    Answers.putExtra("Date", Date);
                    startActivity(Answers);
                }


                break;
        }
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

    public void WMinputTimes(final int i){
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(wolfmotor.this);
        View promptView = layoutInflater.inflate(R.layout.input_time, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(wolfmotor.this);
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
                                    Wolfmotortimetotal = fTimes[0] + fTimes[1] + fTimes[2] + fTimes[3] + fTimes[4] + fTimes[5] + fTimes[6] + fTimes[7] + fTimes[8] + fTimes[9] + fTimes[10] + fTimes[11] + fTimes[12] + fTimes[13] + fTimes[14];
                                    wolfmotortimetotal.setText(String.format("%.3f", Wolfmotortimetotal / 1000) + " seconds");
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

