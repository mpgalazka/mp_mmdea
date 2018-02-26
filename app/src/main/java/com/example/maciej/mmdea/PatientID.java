package com.example.maciej.mmdea;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;


public class PatientID extends AppCompatActivity implements View.OnClickListener {

    Button bEnter, bContactUs, bCreateAs;
    EditText etPatientID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_id);

        etPatientID = (EditText) findViewById(R.id.etPatientID);
        bEnter = (Button) findViewById(R.id.bEnter);
        bContactUs = (Button) findViewById(R.id.bContactUs);
        bCreateAs = (Button) findViewById(R.id.bCreateAs);
        bEnter.setOnClickListener(this);
        bContactUs.setOnClickListener(this);
        bCreateAs.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bContactUs:
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Contact Us");
                alertDialog.setMessage("Developers:                                                                                                                    " +
                        "Kenneth Ng: kenng792@gmail.com                                                                                                                " +
                        "Maciej Galazka: mpgalazka@gmail.com ");
                alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });
                alertDialog.show();
        }


        switch (v.getId()) {
            case R.id.bCreateAs:
                Intent myIntent = new Intent(PatientID.this, Redcapdictionary.class);
                startActivityForResult(myIntent, 0);
        }

        switch (v.getId()) {
            case R.id.bEnter:
                if (Objects.equals(etPatientID.getText().toString(), "")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Please enter a Patient ID");
                    alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // here you can add functions
                        }
                    });
                    alertDialog.setIcon(R.mipmap.ic_launcher2);
                    alertDialog.show();

                } else {

                    Toast toast = Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    new CountDownTimer(1, 1000) {
                        public void onFinish() {
                            String PatID = etPatientID.getText().toString();
                            Intent PID = new Intent(PatientID.this, Forms.class);
                            PID.putExtra("PatientID", PatID);
                            PID.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(PID);

                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                }


        }

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Return to Login?")
                .setMessage("Are you sure you want to return to login?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


}
