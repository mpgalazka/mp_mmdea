package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class tdcs extends AppCompatActivity implements View.OnClickListener, TextWatcher{

    String PatID, Date, Event,joined, notes1a,notes2a,notes3a,notes4a,notes5a,notes6a,notes7a,notes8a,notes9a,
            tdcs1a,tdcs1b,tdcs2a,tdcs2b,tdcs3a,tdcs3b,tdcs4a,tdcs4b,tdcs5a,tdcs5b,tdcs6a,tdcs6b,tdcs7a,tdcs7b,tdcs8a,tdcs8b,tdcs9a,tdcs9b;
    TextView patientID, currentDateTimeString;

    Button bDone;


    EditText notes1,notes2,notes3,notes4,notes5,notes6,notes7,notes8,notes9;

    RadioButton
            radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
            tdcs1aa,tdcs1ab,tdcs1ac,tdcs1ad,   tdcs1ba,tdcs1bb,tdcs1bc,tdcs1bd,tdcs1be,
            tdcs2aa,tdcs2ab,tdcs2ac,tdcs2ad,   tdcs2ba,tdcs2bb,tdcs2bc,tdcs2bd,tdcs2be,
            tdcs3aa,tdcs3ab,tdcs3ac,tdcs3ad,   tdcs3ba,tdcs3bb,tdcs3bc,tdcs3bd,tdcs3be,
            tdcs4aa,tdcs4ab,tdcs4ac,tdcs4ad,   tdcs4ba,tdcs4bb,tdcs4bc,tdcs4bd,tdcs4be,
            tdcs5aa,tdcs5ab,tdcs5ac,tdcs5ad,   tdcs5ba,tdcs5bb,tdcs5bc,tdcs5bd,tdcs5be,
            tdcs6aa,tdcs6ab,tdcs6ac,tdcs6ad,   tdcs6ba,tdcs6bb,tdcs6bc,tdcs6bd,tdcs6be,
            tdcs7aa,tdcs7ab,tdcs7ac,tdcs7ad,   tdcs7ba,tdcs7bb,tdcs7bc,tdcs7bd,tdcs7be,
            tdcs8aa,tdcs8ab,tdcs8ac,tdcs8ad,   tdcs8ba,tdcs8bb,tdcs8bc,tdcs8bd,tdcs8be,
            tdcs9aa,tdcs9ab,tdcs9ac,tdcs9ad,   tdcs9ba,tdcs9bb,tdcs9bc,tdcs9bd,tdcs9be;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdcs);

        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Date: " + Date);



        Event = "NULL";



        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);

        notes1= (EditText)findViewById(R.id.notes1);
        notes2= (EditText)findViewById(R.id.notes2);
        notes3= (EditText)findViewById(R.id.notes3);
        notes4= (EditText)findViewById(R.id.notes4);
        notes5= (EditText)findViewById(R.id.notes5);
        notes6= (EditText)findViewById(R.id.notes6);
        notes7= (EditText)findViewById(R.id.notes7);
        notes8= (EditText)findViewById(R.id.notes8);
        notes9= (EditText)findViewById(R.id.notes9);


        notes1.addTextChangedListener(this);
        notes2.addTextChangedListener(this);
        notes3.addTextChangedListener(this);
        notes4.addTextChangedListener(this);
        notes5.addTextChangedListener(this);
        notes6.addTextChangedListener(this);
        notes7.addTextChangedListener(this);
        notes8.addTextChangedListener(this);
        notes9.addTextChangedListener(this);


        tdcs1a = "Absent";
        tdcs1b = "None";

        tdcs2a = "Absent";
        tdcs2b = "None";

        tdcs3a = "Absent";
        tdcs3b = "None";

        tdcs4a = "Absent";
        tdcs4b = "None";

        tdcs5a = "Absent";
        tdcs5b = "None";

        tdcs6a = "Absent";
        tdcs6b = "None";

        tdcs7a = "Absent";
        tdcs7b = "None";

        tdcs8a = "Absent";
        tdcs8b = "None";

        tdcs9a = "Absent";
        tdcs9b = "None";






        tdcs1aa = (RadioButton) findViewById(R.id.tdcs1aa);
        tdcs1ab = (RadioButton) findViewById(R.id.tdcs1ab);
        tdcs1ac = (RadioButton) findViewById(R.id.tdcs1ac);
        tdcs1ad = (RadioButton) findViewById(R.id.tdcs1ad);

        tdcs1ba = (RadioButton) findViewById(R.id.tdcs1ba);
        tdcs1bb = (RadioButton) findViewById(R.id.tdcs1bb);
        tdcs1bc = (RadioButton) findViewById(R.id.tdcs1bc);
        tdcs1bd = (RadioButton) findViewById(R.id.tdcs1bd);
        tdcs1be = (RadioButton) findViewById(R.id.tdcs1be);


        tdcs2aa = (RadioButton) findViewById(R.id.tdcs2aa);
        tdcs2ab = (RadioButton) findViewById(R.id.tdcs2ab);
        tdcs2ac = (RadioButton) findViewById(R.id.tdcs2ac);
        tdcs2ad = (RadioButton) findViewById(R.id.tdcs2ad);
        tdcs2ba = (RadioButton) findViewById(R.id.tdcs2ba);
        tdcs2bb = (RadioButton) findViewById(R.id.tdcs2bb);
        tdcs2bc = (RadioButton) findViewById(R.id.tdcs2bc);
        tdcs2bd = (RadioButton) findViewById(R.id.tdcs2bd);
        tdcs2be = (RadioButton) findViewById(R.id.tdcs2be);



        tdcs3aa = (RadioButton) findViewById(R.id.tdcs3aa);
        tdcs3ab = (RadioButton) findViewById(R.id.tdcs3ab);
        tdcs3ac = (RadioButton) findViewById(R.id.tdcs3ac);
        tdcs3ad = (RadioButton) findViewById(R.id.tdcs3ad);
        tdcs3ba = (RadioButton) findViewById(R.id.tdcs3ba);
        tdcs3bb = (RadioButton) findViewById(R.id.tdcs3bb);
        tdcs3bc = (RadioButton) findViewById(R.id.tdcs3bc);
        tdcs3bd = (RadioButton) findViewById(R.id.tdcs3bd);
        tdcs3be = (RadioButton) findViewById(R.id.tdcs3be);

        tdcs4aa = (RadioButton) findViewById(R.id.tdcs4aa);
        tdcs4ab = (RadioButton) findViewById(R.id.tdcs4ab);
        tdcs4ac = (RadioButton) findViewById(R.id.tdcs4ac);
        tdcs4ad = (RadioButton) findViewById(R.id.tdcs4ad);
        tdcs4ba = (RadioButton) findViewById(R.id.tdcs4ba);
        tdcs4bb = (RadioButton) findViewById(R.id.tdcs4bb);
        tdcs4bc = (RadioButton) findViewById(R.id.tdcs4bc);
        tdcs4bd = (RadioButton) findViewById(R.id.tdcs4bd);
        tdcs4be = (RadioButton) findViewById(R.id.tdcs4be);


        tdcs5aa = (RadioButton) findViewById(R.id.tdcs5aa);
        tdcs5ab = (RadioButton) findViewById(R.id.tdcs5ab);
        tdcs5ac = (RadioButton) findViewById(R.id.tdcs5ac);
        tdcs5ad = (RadioButton) findViewById(R.id.tdcs5ad);
        tdcs5ba = (RadioButton) findViewById(R.id.tdcs5ba);
        tdcs5bb = (RadioButton) findViewById(R.id.tdcs5bb);
        tdcs5bc = (RadioButton) findViewById(R.id.tdcs5bc);
        tdcs5bd = (RadioButton) findViewById(R.id.tdcs5bd);
        tdcs5be = (RadioButton) findViewById(R.id.tdcs5be);


        tdcs6aa = (RadioButton) findViewById(R.id.tdcs6aa);
        tdcs6ab = (RadioButton) findViewById(R.id.tdcs6ab);
        tdcs6ac = (RadioButton) findViewById(R.id.tdcs6ac);
        tdcs6ad = (RadioButton) findViewById(R.id.tdcs6ad);
        tdcs6ba = (RadioButton) findViewById(R.id.tdcs6ba);
        tdcs6bb = (RadioButton) findViewById(R.id.tdcs6bb);
        tdcs6bc = (RadioButton) findViewById(R.id.tdcs6bc);
        tdcs6bd = (RadioButton) findViewById(R.id.tdcs6bd);
        tdcs6be = (RadioButton) findViewById(R.id.tdcs6be);


        tdcs7aa = (RadioButton) findViewById(R.id.tdcs7aa);
        tdcs7ab = (RadioButton) findViewById(R.id.tdcs7ab);
        tdcs7ac = (RadioButton) findViewById(R.id.tdcs7ac);
        tdcs7ad = (RadioButton) findViewById(R.id.tdcs7ad);
        tdcs7ba = (RadioButton) findViewById(R.id.tdcs7ba);
        tdcs7bb = (RadioButton) findViewById(R.id.tdcs7bb);
        tdcs7bc = (RadioButton) findViewById(R.id.tdcs7bc);
        tdcs7bd = (RadioButton) findViewById(R.id.tdcs7bd);
        tdcs7be = (RadioButton) findViewById(R.id.tdcs7be);


        tdcs8aa = (RadioButton) findViewById(R.id.tdcs8aa);
        tdcs8ab = (RadioButton) findViewById(R.id.tdcs8ab);
        tdcs8ac = (RadioButton) findViewById(R.id.tdcs8ac);
        tdcs8ad = (RadioButton) findViewById(R.id.tdcs8ad);
        tdcs8ba = (RadioButton) findViewById(R.id.tdcs8ba);
        tdcs8bb = (RadioButton) findViewById(R.id.tdcs8bb);
        tdcs8bc = (RadioButton) findViewById(R.id.tdcs8bc);
        tdcs8bd = (RadioButton) findViewById(R.id.tdcs8bd);
        tdcs8be = (RadioButton) findViewById(R.id.tdcs8be);


        tdcs9aa = (RadioButton) findViewById(R.id.tdcs9aa);
        tdcs9ab = (RadioButton) findViewById(R.id.tdcs9ab);
        tdcs9ac = (RadioButton) findViewById(R.id.tdcs9ac);
        tdcs9ad = (RadioButton) findViewById(R.id.tdcs9ad);
        tdcs9ba = (RadioButton) findViewById(R.id.tdcs9ba);
        tdcs9bb = (RadioButton) findViewById(R.id.tdcs9bb);
        tdcs9bc = (RadioButton) findViewById(R.id.tdcs9bc);
        tdcs9bd = (RadioButton) findViewById(R.id.tdcs9bd);
        tdcs9be = (RadioButton) findViewById(R.id.tdcs9be);

        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);














    }


    public void MP(View view){


        switch (view.getId()){

            case R.id. tdcs1aa:
                tdcs1a = "Absent";
                tdcs1ba.setEnabled(false);
                tdcs1bb.setEnabled(false);
                tdcs1bc.setEnabled(false);
                tdcs1bd.setEnabled(false);
                tdcs1be.setEnabled(false);

                tdcs1ba.setChecked(false);
                tdcs1bb.setChecked(false);
                tdcs1bc.setChecked(false);
                tdcs1bd.setChecked(false);
                tdcs1be.setChecked(false);

                tdcs1b = "N/A";

                break;
            case R.id. tdcs1ab:
                tdcs1a = "Mild";
                tdcs1ba.setEnabled(true);
                tdcs1bb.setEnabled(true);
                tdcs1bc.setEnabled(true);
                tdcs1bd.setEnabled(true);
                tdcs1be.setEnabled(true);
                break;
            case R.id. tdcs1ac:
                tdcs1a = "Moderate";
                tdcs1ba.setEnabled(true);
                tdcs1bb.setEnabled(true);
                tdcs1bc.setEnabled(true);
                tdcs1bd.setEnabled(true);
                tdcs1be.setEnabled(true);
                break;
            case R.id. tdcs1ad:
                tdcs1a = "Severe";
                tdcs1ba.setEnabled(true);
                tdcs1bb.setEnabled(true);
                tdcs1bc.setEnabled(true);
                tdcs1bd.setEnabled(true);
                tdcs1be.setEnabled(true);
                break;
        }

        switch (view.getId()){

            case R.id.tdcs1ba:
                tdcs1b = "None";
                break;
            case R.id.tdcs1bb:
                tdcs1b = "Remote";
                break;
            case R.id.tdcs1bc:
                tdcs1b = "Possible";
                break;
            case R.id.tdcs1bd:
                tdcs1b = "Probable";
                break;
            case R.id.tdcs1be:
                tdcs1b = "Definite";
                break;

        }








        switch (view.getId()){

            case R.id. tdcs2aa:
                tdcs2a = "Absent";
                tdcs2ba.setEnabled(false);
                tdcs2bb.setEnabled(false);
                tdcs2bc.setEnabled(false);
                tdcs2bd.setEnabled(false);
                tdcs2be.setEnabled(false);

                tdcs2ba.setChecked(false);
                tdcs2bb.setChecked(false);
                tdcs2bc.setChecked(false);
                tdcs2bd.setChecked(false);
                tdcs2be.setChecked(false);

                tdcs2b = "N/A";
                break;
            case R.id. tdcs2ab:
                tdcs2a = "Mild";
                tdcs2ba.setEnabled(true);
                tdcs2bb.setEnabled(true);
                tdcs2bc.setEnabled(true);
                tdcs2bd.setEnabled(true);
                tdcs2be.setEnabled(true);
                break;
            case R.id. tdcs2ac:
                tdcs2a = "Moderate";
                tdcs2ba.setEnabled(true);
                tdcs2bb.setEnabled(true);
                tdcs2bc.setEnabled(true);
                tdcs2bd.setEnabled(true);
                tdcs2be.setEnabled(true);
                break;
            case R.id. tdcs2ad:
                tdcs2a = "Severe";
                tdcs2ba.setEnabled(true);
                tdcs2bb.setEnabled(true);
                tdcs2bc.setEnabled(true);
                tdcs2bd.setEnabled(true);
                tdcs2be.setEnabled(true);
                break;
        }

        switch (view.getId()){

            case R.id.tdcs2ba:
                tdcs2b = "None";
                break;
            case R.id.tdcs2bb:
                tdcs2b = "Remote";
                break;
            case R.id.tdcs2bc:
                tdcs2b = "Possible";
                break;
            case R.id.tdcs2bd:
                tdcs2b = "Probable";
                break;
            case R.id.tdcs2be:
                tdcs2b = "Definite";
                break;

        }





        switch (view.getId()){

            case R.id. tdcs3aa:
                tdcs3a = "Absent";
                tdcs3ba.setEnabled(false);
                tdcs3bb.setEnabled(false);
                tdcs3bc.setEnabled(false);
                tdcs3bd.setEnabled(false);
                tdcs3be.setEnabled(false);


                tdcs3ba.setChecked(false);
                tdcs3bb.setChecked(false);
                tdcs3bc.setChecked(false);
                tdcs3bd.setChecked(false);
                tdcs3be.setChecked(false);

                tdcs3b = "N/A";
                break;
            case R.id. tdcs3ab:
                tdcs3a = "Mild";
                tdcs3ba.setEnabled(true);
                tdcs3bb.setEnabled(true);
                tdcs3bc.setEnabled(true);
                tdcs3bd.setEnabled(true);
                tdcs3be.setEnabled(true);
                break;
            case R.id. tdcs3ac:
                tdcs3a = "Moderate";
                tdcs3ba.setEnabled(true);
                tdcs3bb.setEnabled(true);
                tdcs3bc.setEnabled(true);
                tdcs3bd.setEnabled(true);
                tdcs3be.setEnabled(true);

                break;
            case R.id. tdcs3ad:
                tdcs3a = "Severe";
                tdcs3ba.setEnabled(true);
                tdcs3bb.setEnabled(true);
                tdcs3bc.setEnabled(true);
                tdcs3bd.setEnabled(true);
                tdcs3be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs3ba:
                tdcs3b = "None";
                break;
            case R.id.tdcs3bb:
                tdcs3b = "Remote";
                break;
            case R.id.tdcs3bc:
                tdcs3b = "Possible";
                break;
            case R.id.tdcs3bd:
                tdcs3b = "Probable";
                break;
            case R.id.tdcs3be:
                tdcs3b = "Definite";
                break;

        }





        switch (view.getId()){

            case R.id. tdcs4aa:
                tdcs4a = "Absent";
                tdcs4ba.setEnabled(false);
                tdcs4bb.setEnabled(false);
                tdcs4bc.setEnabled(false);
                tdcs4bd.setEnabled(false);
                tdcs4be.setEnabled(false);

                tdcs4ba.setChecked(false);
                tdcs4bb.setChecked(false);
                tdcs4bc.setChecked(false);
                tdcs4bd.setChecked(false);
                tdcs4be.setChecked(false);

                tdcs4b = "N/A";
                break;
            case R.id. tdcs4ab:
                tdcs4a = "Mild";
                tdcs4ba.setEnabled(true);
                tdcs4bb.setEnabled(true);
                tdcs4bc.setEnabled(true);
                tdcs4bd.setEnabled(true);
                tdcs4be.setEnabled(true);

                break;
            case R.id. tdcs4ac:
                tdcs4a = "Moderate";
                tdcs4ba.setEnabled(true);
                tdcs4bb.setEnabled(true);
                tdcs4bc.setEnabled(true);
                tdcs4bd.setEnabled(true);
                tdcs4be.setEnabled(true);

                break;
            case R.id. tdcs4ad:
                tdcs4a = "Severe";
                tdcs4ba.setEnabled(true);
                tdcs4bb.setEnabled(true);
                tdcs4bc.setEnabled(true);
                tdcs4bd.setEnabled(true);
                tdcs4be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs4ba:
                tdcs4b = "None";
                break;
            case R.id.tdcs4bb:
                tdcs4b = "Remote";
                break;
            case R.id.tdcs4bc:
                tdcs4b = "Possible";
                break;
            case R.id.tdcs4bd:
                tdcs4b = "Probable";
                break;
            case R.id.tdcs4be:
                tdcs4b = "Definite";
                break;

        }





        switch (view.getId()){

            case R.id. tdcs5aa:
                tdcs5a = "Absent";
                tdcs5ba.setEnabled(false);
                tdcs5bb.setEnabled(false);
                tdcs5bc.setEnabled(false);
                tdcs5bd.setEnabled(false);
                tdcs5be.setEnabled(false);

                tdcs5ba.setChecked(false);
                tdcs5bb.setChecked(false);
                tdcs5bc.setChecked(false);
                tdcs5bd.setChecked(false);
                tdcs5be.setChecked(false);

                tdcs5b = "N/A";
                break;
            case R.id. tdcs5ab:
                tdcs5a = "Mild";
                tdcs5ba.setEnabled(true);
                tdcs5bb.setEnabled(true);
                tdcs5bc.setEnabled(true);
                tdcs5bd.setEnabled(true);
                tdcs5be.setEnabled(true);

                break;
            case R.id. tdcs5ac:
                tdcs5a = "Moderate";
                tdcs5ba.setEnabled(true);
                tdcs5bb.setEnabled(true);
                tdcs5bc.setEnabled(true);
                tdcs5bd.setEnabled(true);
                tdcs5be.setEnabled(true);

                break;
            case R.id. tdcs5ad:
                tdcs5a = "Severe";
                tdcs5ba.setEnabled(true);
                tdcs5bb.setEnabled(true);
                tdcs5bc.setEnabled(true);
                tdcs5bd.setEnabled(true);
                tdcs5be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs5ba:
                tdcs5b = "None";
                break;
            case R.id.tdcs5bb:
                tdcs5b = "Remote";
                break;
            case R.id.tdcs5bc:
                tdcs5b = "Possible";
                break;
            case R.id.tdcs5bd:
                tdcs5b = "Probable";
                break;
            case R.id.tdcs5be:
                tdcs5b = "Definite";
                break;

        }







        switch (view.getId()){

            case R.id. tdcs6aa:
                tdcs6a = "Absent";
                tdcs6ba.setEnabled(false);
                tdcs6bb.setEnabled(false);
                tdcs6bc.setEnabled(false);
                tdcs6bd.setEnabled(false);
                tdcs6be.setEnabled(false);

                tdcs6ba.setChecked(false);
                tdcs6bb.setChecked(false);
                tdcs6bc.setChecked(false);
                tdcs6bd.setChecked(false);
                tdcs6be.setChecked(false);

                tdcs6b = "N/A";
                break;
            case R.id. tdcs6ab:
                tdcs6a = "Mild";
                tdcs6ba.setEnabled(true);
                tdcs6bb.setEnabled(true);
                tdcs6bc.setEnabled(true);
                tdcs6bd.setEnabled(true);
                tdcs6be.setEnabled(true);

                break;
            case R.id. tdcs6ac:
                tdcs6a = "Moderate";
                tdcs6ba.setEnabled(true);
                tdcs6bb.setEnabled(true);
                tdcs6bc.setEnabled(true);
                tdcs6bd.setEnabled(true);
                tdcs6be.setEnabled(true);

                break;
            case R.id. tdcs6ad:
                tdcs6a = "Severe";
                tdcs6ba.setEnabled(true);
                tdcs6bb.setEnabled(true);
                tdcs6bc.setEnabled(true);
                tdcs6bd.setEnabled(true);
                tdcs6be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs6ba:
                tdcs6b = "None";
                break;
            case R.id.tdcs6bb:
                tdcs6b = "Remote";
                break;
            case R.id.tdcs6bc:
                tdcs6b = "Possible";
                break;
            case R.id.tdcs6bd:
                tdcs6b = "Probable";
                break;
            case R.id.tdcs6be:
                tdcs6b = "Definite";
                break;

        }






        switch (view.getId()){

            case R.id. tdcs7aa:
                tdcs7a = "Absent";
                tdcs7ba.setEnabled(false);
                tdcs7bb.setEnabled(false);
                tdcs7bc.setEnabled(false);
                tdcs7bd.setEnabled(false);
                tdcs7be.setEnabled(false);

                tdcs7ba.setChecked(false);
                tdcs7bb.setChecked(false);
                tdcs7bc.setChecked(false);
                tdcs7bd.setChecked(false);
                tdcs7be.setChecked(false);

                tdcs7b = "N/A";
                break;
            case R.id. tdcs7ab:
                tdcs7a = "Mild";
                tdcs7ba.setEnabled(true);
                tdcs7bb.setEnabled(true);
                tdcs7bc.setEnabled(true);
                tdcs7bd.setEnabled(true);
                tdcs7be.setEnabled(true);

                break;
            case R.id. tdcs7ac:
                tdcs7a = "Moderate";
                tdcs7ba.setEnabled(true);
                tdcs7bb.setEnabled(true);
                tdcs7bc.setEnabled(true);
                tdcs7bd.setEnabled(true);
                tdcs7be.setEnabled(true);

                break;
            case R.id. tdcs7ad:
                tdcs7a = "Severe";
                tdcs7ba.setEnabled(true);
                tdcs7bb.setEnabled(true);
                tdcs7bc.setEnabled(true);
                tdcs7bd.setEnabled(true);
                tdcs7be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs7ba:
                tdcs7b = "None";
                break;
            case R.id.tdcs7bb:
                tdcs7b = "Remote";
                break;
            case R.id.tdcs7bc:
                tdcs7b = "Possible";
                break;
            case R.id.tdcs7bd:
                tdcs7b = "Probable";
                break;
            case R.id.tdcs7be:
                tdcs7b = "Definite";
                break;

        }






        switch (view.getId()){

            case R.id. tdcs8aa:
                tdcs8a = "Absent";
                tdcs8ba.setEnabled(false);
                tdcs8bb.setEnabled(false);
                tdcs8bc.setEnabled(false);
                tdcs8bd.setEnabled(false);
                tdcs8be.setEnabled(false);

                tdcs8ba.setChecked(false);
                tdcs8bb.setChecked(false);
                tdcs8bc.setChecked(false);
                tdcs8bd.setChecked(false);
                tdcs8be.setChecked(false);

                tdcs8b = "N/A";
                break;
            case R.id. tdcs8ab:
                tdcs8a = "Mild";
                tdcs8ba.setEnabled(true);
                tdcs8bb.setEnabled(true);
                tdcs8bc.setEnabled(true);
                tdcs8bd.setEnabled(true);
                tdcs8be.setEnabled(true);

                break;
            case R.id. tdcs8ac:
                tdcs8a = "Moderate";
                tdcs8ba.setEnabled(true);
                tdcs8bb.setEnabled(true);
                tdcs8bc.setEnabled(true);
                tdcs8bd.setEnabled(true);
                tdcs8be.setEnabled(true);

                break;
            case R.id. tdcs8ad:
                tdcs8a = "Severe";
                tdcs8ba.setEnabled(true);
                tdcs8bb.setEnabled(true);
                tdcs8bc.setEnabled(true);
                tdcs8bd.setEnabled(true);
                tdcs8be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs8ba:
                tdcs8b = "None";
                break;
            case R.id.tdcs8bb:
                tdcs8b = "Remote";
                break;
            case R.id.tdcs8bc:
                tdcs8b = "Possible";
                break;
            case R.id.tdcs8bd:
                tdcs8b = "Probable";
                break;
            case R.id.tdcs8be:
                tdcs8b = "Definite";
                break;

        }






        switch (view.getId()){

            case R.id. tdcs9aa:
                tdcs9a = "Absent";
                tdcs9ba.setEnabled(false);
                tdcs9bb.setEnabled(false);
                tdcs9bc.setEnabled(false);
                tdcs9bd.setEnabled(false);
                tdcs9be.setEnabled(false);

                tdcs9ba.setChecked(false);
                tdcs9bb.setChecked(false);
                tdcs9bc.setChecked(false);
                tdcs9bd.setChecked(false);
                tdcs9be.setChecked(false);

                tdcs9b = "N/A";
                break;
            case R.id. tdcs9ab:
                tdcs9a = "Mild";
                tdcs9ba.setEnabled(true);
                tdcs9bb.setEnabled(true);
                tdcs9bc.setEnabled(true);
                tdcs9bd.setEnabled(true);
                tdcs9be.setEnabled(true);

                break;
            case R.id. tdcs9ac:
                tdcs9a = "Moderate";
                tdcs9ba.setEnabled(true);
                tdcs9bb.setEnabled(true);
                tdcs9bc.setEnabled(true);
                tdcs9bd.setEnabled(true);
                tdcs9be.setEnabled(true);

                break;
            case R.id. tdcs9ad:
                tdcs9a = "Severe";
                tdcs9ba.setEnabled(true);
                tdcs9bb.setEnabled(true);
                tdcs9bc.setEnabled(true);
                tdcs9bd.setEnabled(true);
                tdcs9be.setEnabled(true);

                break;
        }

        switch (view.getId()){

            case R.id.tdcs9ba:
                tdcs9b = "None";
                break;
            case R.id.tdcs9bb:
                tdcs9b = "Remote";
                break;
            case R.id.tdcs9bc:
                tdcs9b = "Possible";
                break;
            case R.id.tdcs9bd:
                tdcs9b = "Probable";
                break;
            case R.id.tdcs9be:
                tdcs9b = "Definite";
                break;

        }










    }


    @Override
    public void onClick(View v) {

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

                inputcheck = new ArrayList<>();

                if (!radioButtonADM.isChecked() && !radioButtonDC.isChecked() && !radioButtonFU.isChecked() &&!radioButtonMP.isChecked()) {
                    inputcheck.add("Session");
                }


                if (!tdcs1aa.isChecked() && !tdcs1ab.isChecked() && !tdcs1ac.isChecked() && !tdcs1ad.isChecked()){
                    inputcheck.add("1a");
                }

                if (!tdcs1ba.isChecked() && !tdcs1bb.isChecked() && !tdcs1bc.isChecked() && !tdcs1bd.isChecked() && !tdcs1be.isChecked() && tdcs1ba.isEnabled()){
                    inputcheck.add("1b");
                }

                if (!tdcs2aa.isChecked() && !tdcs2ab.isChecked() && !tdcs2ac.isChecked() && !tdcs2ad.isChecked()){
                    inputcheck.add("2a");
                }

                if (!tdcs2ba.isChecked() && !tdcs2bb.isChecked() && !tdcs2bc.isChecked() && !tdcs2bd.isChecked() && !tdcs2be.isChecked()&& tdcs2ba.isEnabled()){
                    inputcheck.add("2b");
                }

                if (!tdcs3aa.isChecked() && !tdcs3ab.isChecked() && !tdcs3ac.isChecked() &&  !tdcs3ad.isChecked()){
                    inputcheck.add("3a");
                }

                if (!tdcs3ba.isChecked() && !tdcs3bb.isChecked() && !tdcs3bc.isChecked() && !tdcs3bd.isChecked() && !tdcs3be.isChecked()&& tdcs3ba.isEnabled()){
                    inputcheck.add("3b");
                }

                if (!tdcs4aa.isChecked() && !tdcs4ab.isChecked() && !tdcs4ac.isChecked() && !tdcs4ad.isChecked()){
                    inputcheck.add("4a");
                }

                if (!tdcs4ba.isChecked() && !tdcs4bb.isChecked() && !tdcs4bc.isChecked() && !tdcs4bd.isChecked()&& !tdcs4be.isChecked()&& tdcs4ba.isEnabled()){
                    inputcheck.add("4b");
                }

                if (!tdcs5aa.isChecked() && !tdcs5ab.isChecked() && !tdcs5ac.isChecked() && !tdcs5ad.isChecked()){
                    inputcheck.add("5a");
                }

                if (!tdcs5ba.isChecked() && !tdcs5bb.isChecked() && !tdcs5bc.isChecked() && !tdcs5bd.isChecked()&& !tdcs5be.isChecked()&& tdcs5ba.isEnabled()){
                    inputcheck.add("5b");
                }

                if (!tdcs6aa.isChecked() && !tdcs6ab.isChecked()  && !tdcs6ac.isChecked()&& !tdcs6ad.isChecked()){
                    inputcheck.add("6a");
                }

                if (!tdcs6ba.isChecked() && !tdcs6bb.isChecked() && !tdcs6bc.isChecked()  && !tdcs6bd.isChecked()&& !tdcs6be.isChecked()&& tdcs6ba.isEnabled()){
                    inputcheck.add("6b");
                }

                if (!tdcs7aa.isChecked() && !tdcs7ab.isChecked()  && !tdcs7ac.isChecked()&& !tdcs7ad.isChecked()){
                    inputcheck.add("7a");
                }

                if (!tdcs7ba.isChecked() && !tdcs7bb.isChecked()  && !tdcs7bc.isChecked() && !tdcs7bd.isChecked()&& !tdcs7be.isChecked()&& tdcs7ba.isEnabled()){
                    inputcheck.add("7b");
                }

                if (!tdcs8aa.isChecked()  && !tdcs8ab.isChecked() && !tdcs8ac.isChecked()&& !tdcs8ad.isChecked()){
                    inputcheck.add("8a");
                }

                if (!tdcs8ba.isChecked() && !tdcs8bb.isChecked() && !tdcs8bc.isChecked()  && !tdcs8bd.isChecked()&& !tdcs8be.isChecked()&& tdcs8ba.isEnabled()){
                    inputcheck.add("8b");
                }

                if (!tdcs9aa.isChecked() && !tdcs9ab.isChecked()  && !tdcs9ac.isChecked()&& !tdcs9ad.isChecked()){
                    inputcheck.add("9a");
                }

                if (!tdcs9ba.isChecked() && !tdcs9bb.isChecked()  && !tdcs9bc.isChecked() && !tdcs9bd.isChecked()&& !tdcs9be.isChecked()&& tdcs9ba.isEnabled()){
                    inputcheck.add("9b");
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
                    Intent Answers = new Intent(tdcs.this, tdcsconf.class);
                    Answers.putExtra("tdcs1a", tdcs1a);
                    Answers.putExtra("tdcs1b", tdcs1b);
                    Answers.putExtra("tdcs2a", tdcs2a);
                    Answers.putExtra("tdcs2b", tdcs2b);
                    Answers.putExtra("tdcs3a", tdcs3a);
                    Answers.putExtra("tdcs3b", tdcs3b);
                    Answers.putExtra("tdcs4a", tdcs4a);
                    Answers.putExtra("tdcs4b", tdcs4b);
                    Answers.putExtra("tdcs5a", tdcs5a);
                    Answers.putExtra("tdcs5b", tdcs5b);
                    Answers.putExtra("tdcs6a", tdcs6a);
                    Answers.putExtra("tdcs6b", tdcs6b);
                    Answers.putExtra("tdcs7a", tdcs7a);
                    Answers.putExtra("tdcs7b", tdcs7b);
                    Answers.putExtra("tdcs8a", tdcs8a);
                    Answers.putExtra("tdcs8b", tdcs8b);
                    Answers.putExtra("tdcs9a", tdcs9a);
                    Answers.putExtra("tdcs9b", tdcs9b);









                    Answers.putExtra("Event", Event);

                    Answers.putExtra("PatientID", PatID);
                    Answers.putExtra("Date", Date);





                    notes1a = notes1.getText().toString();
                    notes2a = notes2.getText().toString();
                    notes3a = notes3.getText().toString();
                    notes4a = notes4.getText().toString();
                    notes5a = notes5.getText().toString();
                    notes6a = notes6.getText().toString();
                    notes7a = notes7.getText().toString();
                    notes8a = notes8.getText().toString();
                    notes9a = notes9.getText().toString();

                    Answers.putExtra("notes1a", notes1a);
                    Answers.putExtra("notes2a", notes2a);
                    Answers.putExtra("notes3a", notes3a);
                    Answers.putExtra("notes4a", notes4a);
                    Answers.putExtra("notes5a", notes5a);
                    Answers.putExtra("notes6a", notes6a);
                    Answers.putExtra("notes7a", notes7a);
                    Answers.putExtra("notes8a", notes8a);
                    Answers.putExtra("notes9a", notes9a);





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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        ((TextView) findViewById(R.id.Cnotes1)).setText(String.valueOf(notes1.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes2)).setText(String.valueOf(notes2.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes3)).setText(String.valueOf(notes3.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes4)).setText(String.valueOf(notes4.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes5)).setText(String.valueOf(notes5.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes6)).setText(String.valueOf(notes6.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes7)).setText(String.valueOf(notes7.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes8)).setText(String.valueOf(notes8.getText().length()) + "/110");
        ((TextView) findViewById(R.id.Cnotes9)).setText(String.valueOf(notes9.getText().length()) + "/110");



    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}