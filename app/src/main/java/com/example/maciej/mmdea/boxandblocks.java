package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class boxandblocks extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    Button bDone, bStart1, bStop1, bStart2, bStop2;

    String PatID, Date, Event, joined;

    TextView currentDateTimeString, patientID, BABTR, BABTL;

    EditText notes1, notes2, BABR, BABL;
    CountDownTimer TimeR, TimeL;

    ArrayList<String> inputcheck, affected;

    RadioButton RadioButtonADM, RadioButtonDC, RadioButtonFU, RadioButtonMP, RadioButtonPP1, RadioButtonPP2;

    CheckBox Affectedleft, Affectedright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxandblocks);


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

        bStart1 = (Button) findViewById(R.id.bStart1);
        bStart1.setOnClickListener(this);
        bStop1 = (Button) findViewById(R.id.bStop1);
        bStop1.setOnClickListener(this);
        bStop1.setEnabled(false);
        bStart2 = (Button) findViewById(R.id.bStart2);
        bStart2.setOnClickListener(this);
        bStop2 = (Button) findViewById(R.id.bStop2);
        bStop2.setOnClickListener(this);
        bStop2.setEnabled(false);

        notes1 = (EditText) findViewById(R.id.notes1);
        notes2 = (EditText) findViewById(R.id.notes2);
        BABR = (EditText) findViewById(R.id.BABR);
        BABL = (EditText) findViewById(R.id.BABL);

        BABTR = (TextView) findViewById(R.id.BABTR);
        BABTL = (TextView) findViewById(R.id.BABTL);


        notes1.addTextChangedListener(this);
        notes2.addTextChangedListener(this);

        Affectedleft = (CheckBox) findViewById(R.id.Affectedleft);
        Affectedleft.setOnClickListener(this);
        Affectedright = (CheckBox) findViewById(R.id.Affectedright);
        Affectedright.setOnClickListener(this);

        RadioButtonADM = (RadioButton) findViewById(R.id.RadioButtonADM);
        RadioButtonPP1 = (RadioButton) findViewById(R.id.RadioButtonPP1);
        RadioButtonPP2 = (RadioButton) findViewById(R.id.RadioButtonPP2);
        RadioButtonMP = (RadioButton) findViewById(R.id.RadioButtonMP);
        RadioButtonFU = (RadioButton) findViewById(R.id.RadioButtonFU);
        RadioButtonDC = (RadioButton) findViewById(R.id.RadioButtonDC);

        affected = new ArrayList<>();


        TimeR = new CountDownTimer(60000, 100) {

            public void onTick(long millisUntilFinished) {
                BABTR.setText(millisUntilFinished / 1000 + ":" + (millisUntilFinished % 1000) / 100);
            }

            public void onFinish() {
                bStop1.setEnabled(false);
                bStart1.setEnabled(true);
                BABTR.setText("Done!");
            }
        };

        TimeL = new CountDownTimer(60000, 100) {

            public void onTick(long millisUntilFinished) {
                BABTL.setText(millisUntilFinished / 1000 + ":" + (millisUntilFinished % 1000) / 100);
            }

            public void onFinish() {
                bStop2.setEnabled(false);
                bStart2.setEnabled(true);
                BABTL.setText("Done!");
            }
        };


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
            case R.id.bStart1:
                bStop1.setEnabled(true);
                bStart1.setEnabled(false);
                TimeR.start();
                break;
        }
        switch (v.getId()) {
            case R.id.bStop1:
                bStop1.setEnabled(false);
                bStart1.setEnabled(true);
                TimeR.cancel();
                break;
        }

        switch (v.getId()) {
            case R.id.bStart2:
                bStop2.setEnabled(true);
                bStart2.setEnabled(false);
                TimeL.start();
                break;
        }
        switch (v.getId()) {
            case R.id.bStop2:
                bStop2.setEnabled(false);
                bStart2.setEnabled(true);
                TimeL.cancel();
                break;
        }



        switch (v.getId()) {
        case R.id.bDone:

        inputcheck = new ArrayList<>();

        if (!RadioButtonADM.isChecked() && !RadioButtonDC.isChecked() && !RadioButtonFU.isChecked() &&!RadioButtonMP.isChecked() && !RadioButtonPP1.isChecked() && !RadioButtonPP2.isChecked()) {
            inputcheck.add("Session");
        }

        if (!Affectedleft.isChecked() && !Affectedright.isChecked()) {
            inputcheck.add("Affected Hand");
        }

        if (TextUtils.isEmpty(BABR.getText())){
            inputcheck.add("Right");
        }

        if (TextUtils.isEmpty(BABL.getText())){
            inputcheck.add("Left");
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
            Intent Answers = new Intent(boxandblocks.this, boxandblocksconf.class);

            Answers.putExtra("CountR", BABR.getText().toString());
            Answers.putExtra("CountL", BABL.getText().toString());
            Answers.putExtra("notes1", notes1.getText().toString());
            Answers.putExtra("notes2", notes2.getText().toString());


            Answers.putExtra("Affected", affected);

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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        ((TextView) findViewById(R.id.Cnotes1)).setText(String.valueOf(notes1.getText().length()) + "/100");
        ((TextView) findViewById(R.id.Cnotes2)).setText(String.valueOf(notes2.getText().length()) + "/100");



    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
