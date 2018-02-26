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

public class barthel extends AppCompatActivity implements  View.OnClickListener{

    String PatID, Date, Event, joined;

    Button bDone;

    TextView bartheltotal, patientID, currentDateTimeString;

    Double BarthelQ1, BarthelQ2, BarthelQ3, BarthelQ4, BarthelQ5, BarthelQ6, BarthelQ7, BarthelQ8, BarthelQ9, BarthelQ10, BarthelQTotal;

    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
                Barthel1a, Barthel1b, Barthel1c, Barthel2a,Barthel2b, Barthel3a, Barthel3b, Barthel4a, Barthel4b, Barthel4c, Barthel5a, Barthel5b, Barthel5c, Barthel6a, Barthel6b,
                Barthel6c, Barthel7a, Barthel7b, Barthel7c, Barthel8a, Barthel8b, Barthel8c, Barthel8d, Barthel9a, Barthel9b, Barthel9c, Barthel9d, Barthel10a, Barthel10b, Barthel10c;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barthel);

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

        bartheltotal = (TextView) findViewById(R.id.bartheltotal);

        BarthelQ1 = Double.parseDouble("0");
        BarthelQ2 = Double.parseDouble("0");
        BarthelQ3 = Double.parseDouble("0");
        BarthelQ4 = Double.parseDouble("0");
        BarthelQ5 = Double.parseDouble("0");
        BarthelQ6 = Double.parseDouble("0");
        BarthelQ7 = Double.parseDouble("0");
        BarthelQ8 = Double.parseDouble("0");
        BarthelQ9 = Double.parseDouble("0");
        BarthelQ10 = Double.parseDouble("0");

        Barthel1a = (RadioButton) findViewById(R.id.Barthel1a);
        Barthel1b = (RadioButton) findViewById(R.id.Barthel1b);
        Barthel1c = (RadioButton) findViewById(R.id.Barthel1c);
        Barthel2a = (RadioButton) findViewById(R.id.Barthel2a);
        Barthel2b = (RadioButton) findViewById(R.id.Barthel2b);
        Barthel3a = (RadioButton) findViewById(R.id.Barthel3a);
        Barthel3b = (RadioButton) findViewById(R.id.Barthel3b);
        Barthel4a = (RadioButton) findViewById(R.id.Barthel4a);
        Barthel4b = (RadioButton) findViewById(R.id.Barthel4b);
        Barthel4c = (RadioButton) findViewById(R.id.Barthel4c);
        Barthel5a = (RadioButton) findViewById(R.id.Barthel5a);
        Barthel5b = (RadioButton) findViewById(R.id.Barthel5b);
        Barthel5c = (RadioButton) findViewById(R.id.Barthel5c);
        Barthel6a = (RadioButton) findViewById(R.id.Barthel6a);
        Barthel6b = (RadioButton) findViewById(R.id.Barthel6b);
        Barthel6c = (RadioButton) findViewById(R.id.Barthel6c);
        Barthel7a = (RadioButton) findViewById(R.id.Barthel7a);
        Barthel7b = (RadioButton) findViewById(R.id.Barthel7b);
        Barthel7c = (RadioButton) findViewById(R.id.Barthel7c);
        Barthel8a = (RadioButton) findViewById(R.id.Barthel8a);
        Barthel8b = (RadioButton) findViewById(R.id.Barthel8b);
        Barthel8c = (RadioButton) findViewById(R.id.Barthel8c);
        Barthel8d = (RadioButton) findViewById(R.id.Barthel8d);
        Barthel9a = (RadioButton) findViewById(R.id.Barthel9a);
        Barthel9b = (RadioButton) findViewById(R.id.Barthel9b);
        Barthel9c = (RadioButton) findViewById(R.id.Barthel9c);
        Barthel9d = (RadioButton) findViewById(R.id.Barthel9d);
        Barthel10a = (RadioButton) findViewById(R.id.Barthel10a);
        Barthel10b = (RadioButton) findViewById(R.id.Barthel10b);
        Barthel10c = (RadioButton) findViewById(R.id.Barthel10c);



        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);


    }



    public void Barthel(View view){


        switch (view.getId()){

            case R.id.Barthel1a:
                BarthelQ1 = Double.parseDouble("0");
                break;
            case R.id.Barthel1b:
                BarthelQ1 = Double.parseDouble("5");
                break;
            case R.id.Barthel1c:
                BarthelQ1 = Double.parseDouble("10");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel2a:
                BarthelQ2 = Double.parseDouble("0");
                break;
            case R.id.Barthel2b:
                BarthelQ2 = Double.parseDouble("5");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel3a:
                BarthelQ3 = Double.parseDouble("0");
                break;
            case R.id.Barthel3b:
                BarthelQ3 = Double.parseDouble("5");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel4a:
                BarthelQ4 = Double.parseDouble("0");
                break;
            case R.id.Barthel4b:
                BarthelQ4 = Double.parseDouble("5");
                break;
            case R.id.Barthel4c:
                BarthelQ4 = Double.parseDouble("10");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel5a:
                BarthelQ5 = Double.parseDouble("0");
                break;
            case R.id.Barthel5b:
                BarthelQ5 = Double.parseDouble("5");
                break;
            case R.id.Barthel5c:
                BarthelQ5 = Double.parseDouble("10");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel6a:
                BarthelQ6 = Double.parseDouble("0");
                break;
            case R.id.Barthel6b:
                BarthelQ6 = Double.parseDouble("5");
                break;
            case R.id.Barthel6c:
                BarthelQ6 = Double.parseDouble("10");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel7a:
                BarthelQ7 = Double.parseDouble("0");
                break;
            case R.id.Barthel7b:
                BarthelQ7 = Double.parseDouble("5");
                break;
            case R.id.Barthel7c:
                BarthelQ7 = Double.parseDouble("10");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel8a:
                BarthelQ8 = Double.parseDouble("0");
                break;
            case R.id.Barthel8b:
                BarthelQ8 = Double.parseDouble("5");
                break;
            case R.id.Barthel8c:
                BarthelQ8 = Double.parseDouble("10");
                break;
            case R.id.Barthel8d:
                BarthelQ8 = Double.parseDouble("15");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel9a:
                BarthelQ9 = Double.parseDouble("0");
                break;
            case R.id.Barthel9b:
                BarthelQ9 = Double.parseDouble("5");
                break;
            case R.id.Barthel9c:
                BarthelQ9 = Double.parseDouble("10");
                break;
            case R.id.Barthel9d:
                BarthelQ9 = Double.parseDouble("15");
                break;
        }

        switch (view.getId()){

            case R.id.Barthel10a:
                BarthelQ10 = Double.parseDouble("0");
                break;
            case R.id.Barthel10b:
                BarthelQ10 = Double.parseDouble("5");
                break;
            case R.id.Barthel10c:
                BarthelQ10 = Double.parseDouble("10");
                break;
        }

        BarthelQTotal = BarthelQ1 + BarthelQ2 + BarthelQ3 + BarthelQ4 + BarthelQ5 + BarthelQ6 + BarthelQ7 + BarthelQ8 + BarthelQ9 + BarthelQ10;
        bartheltotal.setText(String.valueOf(BarthelQTotal) + "/100.0");

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

                if (!Barthel1a.isChecked() && !Barthel1b.isChecked() && !Barthel1c.isChecked()){
                    inputcheck.add("1");
                }

                if (!Barthel2a.isChecked() && !Barthel2b.isChecked()){
                    inputcheck.add("2");
                }

                if (!Barthel3a.isChecked() && !Barthel3b.isChecked()){
                    inputcheck.add("3");
                }

                if (!Barthel4a.isChecked() && !Barthel4b.isChecked() && !Barthel4c.isChecked()){
                    inputcheck.add("4");
                }

                if (!Barthel5a.isChecked() && !Barthel5b.isChecked() && !Barthel5c.isChecked()){
                    inputcheck.add("5");
                }

                if (!Barthel6a.isChecked() && !Barthel6b.isChecked() && !Barthel6c.isChecked()){
                    inputcheck.add("6");
                }

                if (!Barthel7a.isChecked() && !Barthel7b.isChecked() && !Barthel7c.isChecked()){
                    inputcheck.add("7");
                }

                if (!Barthel8a.isChecked() && !Barthel8b.isChecked() && !Barthel8c.isChecked() && !Barthel8d.isChecked()){
                    inputcheck.add("8");
                }

                if (!Barthel9a.isChecked() && !Barthel9b.isChecked() && !Barthel9c.isChecked() && !Barthel9d.isChecked()){
                    inputcheck.add("9");
                }

                if (!Barthel10a.isChecked() && !Barthel10b.isChecked() && !Barthel10c.isChecked()){
                    inputcheck.add("10");
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
                    Intent Answers = new Intent(barthel.this, barthelconf.class);
                    Answers.putExtra("BarthelQ1", BarthelQ1);
                    Answers.putExtra("BarthelQ2", BarthelQ2);
                    Answers.putExtra("BarthelQ3", BarthelQ3);
                    Answers.putExtra("BarthelQ4", BarthelQ4);
                    Answers.putExtra("BarthelQ5", BarthelQ5);
                    Answers.putExtra("BarthelQ6", BarthelQ6);
                    Answers.putExtra("BarthelQ7", BarthelQ7);
                    Answers.putExtra("BarthelQ8", BarthelQ8);
                    Answers.putExtra("BarthelQ9", BarthelQ9);
                    Answers.putExtra("BarthelQ10", BarthelQ10);
                    Answers.putExtra("BarthelQTotal", BarthelQTotal);
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
