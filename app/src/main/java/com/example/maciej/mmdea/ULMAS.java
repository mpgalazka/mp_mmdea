package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ULMAS extends AppCompatActivity implements View.OnClickListener{

    String PatID, Date, Event, joined;

    Button bDone;

    TextView patientID, currentDateTimeString;
    
    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
                ULMAS1a, ULMAS1b, ULMAS1c, ULMAS1d, ULMAS1f, ULMAS1e, 
                ULMAS2a, ULMAS2b, ULMAS2c, ULMAS2d, ULMAS2f, ULMAS2e,
                ULMAS3a, ULMAS3b, ULMAS3c, ULMAS3d, ULMAS3f, ULMAS3e,
                ULMAS4a, ULMAS4b, ULMAS4c, ULMAS4d, ULMAS4f, ULMAS4e;

    String  QULMAS1,
            QULMAS2,
            QULMAS3,
            QULMAS4;

    ArrayList<String> inputcheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulmas);

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
        
        ULMAS1a = (RadioButton) findViewById(R.id.ULMAS1a);
        ULMAS1b = (RadioButton) findViewById(R.id.ULMAS1b);
        ULMAS1c = (RadioButton) findViewById(R.id.ULMAS1c);
        ULMAS1d = (RadioButton) findViewById(R.id.ULMAS1d);
        ULMAS1e = (RadioButton) findViewById(R.id.ULMAS1e);
        ULMAS1f = (RadioButton) findViewById(R.id.ULMAS1f);

        ULMAS2a = (RadioButton) findViewById(R.id.ULMAS2a);
        ULMAS2b = (RadioButton) findViewById(R.id.ULMAS2b);
        ULMAS2c = (RadioButton) findViewById(R.id.ULMAS2c);
        ULMAS2d = (RadioButton) findViewById(R.id.ULMAS2d);
        ULMAS2e = (RadioButton) findViewById(R.id.ULMAS2e);
        ULMAS2f = (RadioButton) findViewById(R.id.ULMAS2f);

        ULMAS3a = (RadioButton) findViewById(R.id.ULMAS3a);
        ULMAS3b = (RadioButton) findViewById(R.id.ULMAS3b);
        ULMAS3c = (RadioButton) findViewById(R.id.ULMAS3c);
        ULMAS3d = (RadioButton) findViewById(R.id.ULMAS3d);
        ULMAS3e = (RadioButton) findViewById(R.id.ULMAS3e);
        ULMAS3f = (RadioButton) findViewById(R.id.ULMAS3f);

        ULMAS4a = (RadioButton) findViewById(R.id.ULMAS4a);
        ULMAS4b = (RadioButton) findViewById(R.id.ULMAS4b);
        ULMAS4c = (RadioButton) findViewById(R.id.ULMAS4c);
        ULMAS4d = (RadioButton) findViewById(R.id.ULMAS4d);
        ULMAS4e = (RadioButton) findViewById(R.id.ULMAS4e);
        ULMAS4f = (RadioButton) findViewById(R.id.ULMAS4f);

        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);

        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);
    }


    public void Ulmas (View view){

        switch (view.getId()){

            case R.id.ULMAS1a:
                QULMAS1 = "0";
                break;
            case R.id.ULMAS1b:
                QULMAS1 = "1";
                break;
            case R.id.ULMAS1c:
                QULMAS1 = "1+";
                break;
            case R.id.ULMAS1d:
                QULMAS1 = "2";
                break;
            case R.id.ULMAS1e:
                QULMAS1 = "3";
                break;
            case R.id.ULMAS1f:
                QULMAS1 = "4";
                break;
        }

        switch (view.getId()){

            case R.id.ULMAS2a:
                QULMAS2 = "0";
                break;
            case R.id.ULMAS2b:
                QULMAS2 = "1";
                break;
            case R.id.ULMAS2c:
                QULMAS2 = "1+";
                break;
            case R.id.ULMAS2d:
                QULMAS2 = "2";
                break;
            case R.id.ULMAS2e:
                QULMAS2 = "3";
                break;
            case R.id.ULMAS2f:
                QULMAS2 = "4";
                break;
        }

        switch (view.getId()){

            case R.id.ULMAS3a:
                QULMAS3 = "0";
                break;
            case R.id.ULMAS3b:
                QULMAS3 = "1";
                break;
            case R.id.ULMAS3c:
                QULMAS3 = "1+";
                break;
            case R.id.ULMAS3d:
                QULMAS3 = "2";
                break;
            case R.id.ULMAS3e:
                QULMAS3 = "3";
                break;
            case R.id.ULMAS3f:
                QULMAS3 = "4";
                break;
        }

        switch (view.getId()){

            case R.id.ULMAS4a:
                QULMAS4 = "0";
                break;
            case R.id.ULMAS4b:
                QULMAS4 = "1";
                break;
            case R.id.ULMAS4c:
                QULMAS4 = "1+";
                break;
            case R.id.ULMAS4d:
                QULMAS4 = "2";
                break;
            case R.id.ULMAS4e:
                QULMAS4 = "3";
                break;
            case R.id.ULMAS4f:
                QULMAS4 = "4";
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

                    if (!ULMAS1a.isChecked() && !ULMAS1b.isChecked() && !ULMAS1c.isChecked() && !ULMAS1d.isChecked() && !ULMAS1e.isChecked() && !ULMAS1f.isChecked()){
                        inputcheck.add("1");
                    }

                    if (!ULMAS2a.isChecked() && !ULMAS2b.isChecked() && !ULMAS2c.isChecked() && !ULMAS2d.isChecked() && !ULMAS2e.isChecked() && !ULMAS2f.isChecked()){
                        inputcheck.add("2");
                    }

                    if (!ULMAS3a.isChecked() && !ULMAS3b.isChecked() && !ULMAS3c.isChecked() && !ULMAS3d.isChecked() && !ULMAS3e.isChecked() && !ULMAS3f.isChecked()){
                        inputcheck.add("3");
                    }

                    if (!ULMAS4a.isChecked() && !ULMAS4b.isChecked() && !ULMAS4c.isChecked() && !ULMAS4d.isChecked() && !ULMAS4e.isChecked() && !ULMAS4f.isChecked()){
                        inputcheck.add("4");
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
                        Intent Answers = new Intent(ULMAS.this, ULMASconf.class);
                        Answers.putExtra("QULMAS1", QULMAS1);
                        Answers.putExtra("QULMAS2", QULMAS2);
                        Answers.putExtra("QULMAS3", QULMAS3);
                        Answers.putExtra("QULMAS4", QULMAS4);
                        Answers.putExtra("Event", Event);
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
}
