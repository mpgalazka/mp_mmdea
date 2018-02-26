package com.example.maciej.mmdea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Lextremity extends AppCompatActivity implements View.OnClickListener{

    String PatID, Date, Event, joined,
            LExtrmt_1a, LExtrmt_1b, LExtrmt_2a, LExtrmt_2b, LExtrmt_2c, LExtrmt_3a, LExtrmt_3b, LExtrmt_3c, LExtrmt_3d, LExtrmt_4a, LExtrmt_4b, LExtrmt_5a, LExtrmt_5b, LExtrmt_6a, LExtrmt_7a, LExtrmt_7b, LExtrmt_7c;
    TextView patientID, currentDateTimeString, LExtrmt_total, LExtrmt_totalconf, BABTR, BABTL;

    Button bDone, bStart1, bStop1, bStart2, bStop2;
    CountDownTimer TimeR, TimeL;
    Double LExtrmt_Q1, LExtrmt_Q2, LExtrmt_Q3, LExtrmt_Q4, LExtrmt_Q5, LExtrmt_Q6, LExtrmt_Q7, LExtrmt_Q8, LExtrmt_Q9, LExtrmt_Q10,LExtrmt_Q11, LExtrmt_Q12, LExtrmt_Q13, LExtrmt_Q14, LExtrmt_Q15, LExtrmt_Q16, LExtrmt_Q17, LExtrmt_QTotal;

    RadioButton
            RadioButtonPP1, RadioButtonPP2, RadioButtonADM, RadioButtonDC, RadioButtonFU, RadioButtonMP,
            LExtrmt_1a0pre, LExtrmt_1a1pre, LExtrmt_1a2pre, LExtrmt_3d0pre, LExtrmt_1b0pre, LExtrmt_1b1pre, LExtrmt_1b2pre, LExtrmt_1bd, LExtrmt_1be,
            LExtrmt_2a0pre, LExtrmt_2a1pre, LExtrmt_2a2pre, LExtrmt_3d1pre, LExtrmt_2b0pre, LExtrmt_2b1pre, LExtrmt_2b2pre, LExtrmt_2bd, LExtrmt_2be,
            LExtrmt_3a0pre, LExtrmt_3a1pre, LExtrmt_3a2pre, LExtrmt_3d2pre, LExtrmt_3b0pre, LExtrmt_3b1pre, LExtrmt_3b2pre, LExtrmt_3bd, LExtrmt_3be,
            LExtrmt_4a0pre, LExtrmt_4a1pre, LExtrmt_4a2pre, LExtrmt_7c0pre, LExtrmt_4b0pre, LExtrmt_4b1pre, LExtrmt_4b2pre, LExtrmt_4bd, LExtrmt_4be,
            LExtrmt_5a0pre, LExtrmt_5a1pre, LExtrmt_5a2pre, LExtrmt_7c1pre, LExtrmt_5b0pre, LExtrmt_5b1pre, LExtrmt_5b2pre, LExtrmt_5bd, LExtrmt_5be,
            LExtrmt_6a0pre, LExtrmt_6a1pre, LExtrmt_6a2pre, LExtrmt_7c2pre, LExtrmt_6b0pre, LExtrmt_6b1pre, LExtrmt_6b2pre, LExtrmt_6bd, LExtrmt_6be,
            LExtrmt_7a0pre, LExtrmt_7a1pre, LExtrmt_7a2pre, LExtrmt_7b0pre, LExtrmt_7b1pre, LExtrmt_7b2pre, LExtrmt_7bd, LExtrmt_7be,
            LExtrmt_2c0pre, LExtrmt_2c1pre, LExtrmt_2c2pre, LExtrmt_8ad, LExtrmt_8ba, LExtrmt_8bb, LExtrmt_8bc, LExtrmt_8bd, LExtrmt_8be,
            LExtrmt_3c0pre, LExtrmt_3c1pre, LExtrmt_3c2pre, LExtrmt_9ba, LExtrmt_9bb, LExtrmt_9bc, LExtrmt_9bd, LExtrmt_9be;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lextremity);



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

        bStart1 = (Button) findViewById(R.id.bStart2);
        bStart1.setOnClickListener(this);
        bStop1 = (Button) findViewById(R.id.bStop2);
        bStop1.setOnClickListener(this);
        bStop1.setEnabled(false);

        LExtrmt_1a = "0";

        LExtrmt_Q1 = Double.parseDouble("0");
        LExtrmt_Q2 = Double.parseDouble("0");
        LExtrmt_Q3 = Double.parseDouble("0");
        LExtrmt_Q4 = Double.parseDouble("0");
        LExtrmt_Q5 = Double.parseDouble("0");
        LExtrmt_Q6 = Double.parseDouble("0");

        LExtrmt_Q7 = Double.parseDouble("0");
        LExtrmt_Q8 = Double.parseDouble("0");
        LExtrmt_Q9 = Double.parseDouble("0");
        LExtrmt_Q10 = Double.parseDouble("0");

        LExtrmt_Q11 = Double.parseDouble("0");
        LExtrmt_Q12 = Double.parseDouble("0");
        LExtrmt_Q13 = Double.parseDouble("0");
        LExtrmt_Q14 = Double.parseDouble("0");

        LExtrmt_Q15 = Double.parseDouble("0");
        LExtrmt_Q16 = Double.parseDouble("0");
        LExtrmt_Q17 = Double.parseDouble("0");

        LExtrmt_QTotal = Double.parseDouble("0");

        LExtrmt_1b = "None";

        LExtrmt_2a = "0";
        LExtrmt_2b = "None";
        LExtrmt_2c = "None";

        LExtrmt_3a = "0";
        LExtrmt_3b = "None";
        LExtrmt_3c = "0";
        LExtrmt_3d = "None";

        LExtrmt_4a = "0";
        LExtrmt_4b = "None";

        LExtrmt_5a = "0";
        LExtrmt_5b = "None";

        LExtrmt_6a = "0";

        LExtrmt_7a = "0";
        LExtrmt_7b = "None";
        LExtrmt_7c = "None";


        LExtrmt_1a0pre = (RadioButton) findViewById(R.id.LExtrmt_1a0pre);

        LExtrmt_1a2pre = (RadioButton) findViewById(R.id.LExtrmt_1a2pre);

        LExtrmt_1b0pre = (RadioButton) findViewById(R.id.LExtrmt_1b0pre);

        LExtrmt_1b2pre = (RadioButton) findViewById(R.id.LExtrmt_1b2pre);


        LExtrmt_2a0pre = (RadioButton) findViewById(R.id.LExtrmt_2a0pre);
        LExtrmt_2a1pre = (RadioButton) findViewById(R.id.LExtrmt_2a1pre);
        LExtrmt_2a2pre = (RadioButton) findViewById(R.id.LExtrmt_2a2pre);

        LExtrmt_2b0pre = (RadioButton) findViewById(R.id.LExtrmt_2b0pre);
        LExtrmt_2b1pre = (RadioButton) findViewById(R.id.LExtrmt_2b1pre);
        LExtrmt_2b2pre = (RadioButton) findViewById(R.id.LExtrmt_2b2pre);


        LExtrmt_2c0pre = (RadioButton) findViewById(R.id.LExtrmt_2c0pre);
        LExtrmt_2c1pre = (RadioButton) findViewById(R.id.LExtrmt_2c1pre);
        LExtrmt_2c2pre = (RadioButton) findViewById(R.id.LExtrmt_2c2pre);


        LExtrmt_3a0pre = (RadioButton) findViewById(R.id.LExtrmt_3a0pre);
        LExtrmt_3a1pre = (RadioButton) findViewById(R.id.LExtrmt_3a1pre);
        LExtrmt_3a2pre = (RadioButton) findViewById(R.id.LExtrmt_3a2pre);

        LExtrmt_3b0pre = (RadioButton) findViewById(R.id.LExtrmt_3b0pre);
        LExtrmt_3b1pre = (RadioButton) findViewById(R.id.LExtrmt_3b1pre);
        LExtrmt_3b2pre = (RadioButton) findViewById(R.id.LExtrmt_3b2pre);

        LExtrmt_3c0pre = (RadioButton) findViewById(R.id.LExtrmt_3c0pre);
        LExtrmt_3c1pre = (RadioButton) findViewById(R.id.LExtrmt_3c1pre);
        LExtrmt_3c2pre = (RadioButton) findViewById(R.id.LExtrmt_3c2pre);

        LExtrmt_3d0pre = (RadioButton) findViewById(R.id.LExtrmt_3d0pre);
        LExtrmt_3d1pre = (RadioButton) findViewById(R.id.LExtrmt_3d1pre);
        LExtrmt_3d2pre = (RadioButton) findViewById(R.id.LExtrmt_3d2pre);

        LExtrmt_4a0pre = (RadioButton) findViewById(R.id.LExtrmt_4a0pre);
        LExtrmt_4a1pre = (RadioButton) findViewById(R.id.LExtrmt_4a1pre);
        LExtrmt_4a2pre = (RadioButton) findViewById(R.id.LExtrmt_4a2pre);

        LExtrmt_4b0pre = (RadioButton) findViewById(R.id.LExtrmt_4b0pre);
        LExtrmt_4b1pre = (RadioButton) findViewById(R.id.LExtrmt_4b1pre);
        LExtrmt_4b2pre = (RadioButton) findViewById(R.id.LExtrmt_4b2pre);


        LExtrmt_5a0pre = (RadioButton) findViewById(R.id.LExtrmt_5a0pre);
        LExtrmt_5a1pre = (RadioButton) findViewById(R.id.LExtrmt_5a1pre);
        LExtrmt_5a2pre = (RadioButton) findViewById(R.id.LExtrmt_5a2pre);

        LExtrmt_5b0pre = (RadioButton) findViewById(R.id.LExtrmt_5b0pre);
        LExtrmt_5b1pre = (RadioButton) findViewById(R.id.LExtrmt_5b1pre);
        LExtrmt_5b2pre = (RadioButton) findViewById(R.id.LExtrmt_5b2pre);

        LExtrmt_6a0pre = (RadioButton) findViewById(R.id.LExtrmt_6a0pre);
        LExtrmt_6a1pre = (RadioButton) findViewById(R.id.LExtrmt_6a1pre);
        LExtrmt_6a2pre = (RadioButton) findViewById(R.id.LExtrmt_6a2pre);


        LExtrmt_7a0pre = (RadioButton) findViewById(R.id.LExtrmt_7a0pre);
        LExtrmt_7a1pre = (RadioButton) findViewById(R.id.LExtrmt_7a1pre);
        LExtrmt_7a2pre = (RadioButton) findViewById(R.id.LExtrmt_7a2pre);

        LExtrmt_7b0pre = (RadioButton) findViewById(R.id.LExtrmt_7b0pre);
        LExtrmt_7b1pre = (RadioButton) findViewById(R.id.LExtrmt_7b1pre);
        LExtrmt_7b2pre = (RadioButton) findViewById(R.id.LExtrmt_7b2pre);

        LExtrmt_7c0pre = (RadioButton) findViewById(R.id.LExtrmt_7c0pre);
        LExtrmt_7c1pre = (RadioButton) findViewById(R.id.LExtrmt_7c1pre);
        LExtrmt_7c2pre = (RadioButton) findViewById(R.id.LExtrmt_7c2pre);

        RadioButtonPP1 = (RadioButton) findViewById(R.id.RadioButtonPP1);
        RadioButtonPP2 = (RadioButton) findViewById(R.id.RadioButtonPP2);
        RadioButtonADM = (RadioButton) findViewById(R.id.RadioButtonADM);
        RadioButtonFU = (RadioButton) findViewById(R.id.RadioButtonFU);
        RadioButtonDC = (RadioButton) findViewById(R.id.RadioButtonDC);

        RadioButtonPP1.setOnClickListener(this);
        RadioButtonPP2.setOnClickListener(this);
        RadioButtonADM.setOnClickListener(this);
        RadioButtonFU.setOnClickListener(this);
        RadioButtonDC.setOnClickListener(this);

        BABTR = (TextView) findViewById(R.id.BABTR);
        LExtrmt_total = (TextView) findViewById(R.id.LExtrmt_Total);

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


        RadioButtonMP = (RadioButton) findViewById(R.id.RadioButtonMP);
        RadioButtonMP.setOnClickListener(this);


    }



    public void LM(View view) {

//Ia

        switch (view.getId()) {
            case R.id.LExtrmt_1a0pre:
                if (LExtrmt_1a0pre.isChecked()) {
                    LExtrmt_1a = "0";
                    LExtrmt_Q1 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_1a2pre:
                if (LExtrmt_1a2pre.isChecked()) {
                    LExtrmt_1a = "2";
                    LExtrmt_Q1 = Double.parseDouble("2");

                }
                break;

//                Ib
        }
        switch (view.getId()) {
            case R.id.LExtrmt_1b0pre:
                if (LExtrmt_1b0pre.isChecked()) {

                    LExtrmt_1b = "0";
                    LExtrmt_Q2 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_1b2pre:
                if (LExtrmt_1b2pre.isChecked()) {
                    LExtrmt_1b = "2";
                    LExtrmt_Q2= Double.parseDouble("2");
                }
                break;


//                    IIa

        }
        switch (view.getId()) {
            case R.id.LExtrmt_2a0pre:
                if (LExtrmt_2a0pre.isChecked()) {

                    LExtrmt_2a = "0";
                    LExtrmt_Q3 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_2a1pre:
                if (LExtrmt_2a1pre.isChecked()) {

                    LExtrmt_2a = "1";
                    LExtrmt_Q3 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_2a2pre:
                if (LExtrmt_2a2pre.isChecked()) {

                    LExtrmt_2a = "2";
                    LExtrmt_Q3 = Double.parseDouble("2");

                }
                break;
//                        IIb
        }
        switch (view.getId()) {
            case R.id.LExtrmt_2b0pre:
                if (LExtrmt_2b0pre.isChecked()) {
                    LExtrmt_1b = "0";
                    LExtrmt_Q4 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_2b1pre:
                if (LExtrmt_2b1pre.isChecked()) {
                    LExtrmt_2b = "1";
                    LExtrmt_Q4 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_2b2pre:
                if (LExtrmt_2b2pre.isChecked()) {
                    LExtrmt_2b = "2";
                    LExtrmt_Q4 = Double.parseDouble("2");

                }
                break;

        }
        switch (view.getId()) {
//                            IIC

            case R.id.LExtrmt_2c0pre:
                if (LExtrmt_2c0pre.isChecked()) {
                    LExtrmt_2c = "0";
                    LExtrmt_Q5 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_2c1pre:
                if (LExtrmt_2c1pre.isChecked()) {
                    LExtrmt_2c = "1";
                    LExtrmt_Q5 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_2c2pre:
                if (LExtrmt_2c2pre.isChecked()) {
                    LExtrmt_2c = "2";
                    LExtrmt_Q5 = Double.parseDouble("2");

                }
                break;


//                                IIIa

        }
        switch (view.getId()) {
            case R.id.LExtrmt_3a0pre:
                if (LExtrmt_3a0pre.isChecked()) {
                    LExtrmt_3a = "0";
                    LExtrmt_Q6 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_3a1pre:
                if (LExtrmt_3a1pre.isChecked()) {
                    LExtrmt_3a = "1";
                    LExtrmt_Q6 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_3a2pre:
                if (LExtrmt_3a2pre.isChecked()) {
                    LExtrmt_3a = "2";
                    LExtrmt_Q6 = Double.parseDouble("2");
                }
                break;
//                        IIIb
        }
        switch (view.getId()) {
            case R.id.LExtrmt_3b0pre:
                if (LExtrmt_3b0pre.isChecked()) {
                    LExtrmt_3b = "0";
                    LExtrmt_Q7 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_3b1pre:
                if (LExtrmt_3b1pre.isChecked()) {
                    LExtrmt_3b = "1";
                    LExtrmt_Q7 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_3b2pre:
                if (LExtrmt_3b2pre.isChecked()) {
                    LExtrmt_3b = "2";
                    LExtrmt_Q7 = Double.parseDouble("2");
                }
                break;


//                            IIIC
        }
        switch (view.getId()) {
            case R.id.LExtrmt_3c0pre:
                if (LExtrmt_3c0pre.isChecked()) {
                    LExtrmt_3c = "0";
                    LExtrmt_Q8 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_3c1pre:
                if (LExtrmt_3d1pre.isChecked()) {
                    LExtrmt_3c = "1";
                    LExtrmt_Q8 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_3c2pre:
                if (LExtrmt_3c2pre.isChecked()) {
                    LExtrmt_3c = "2";
                    LExtrmt_Q8 = Double.parseDouble("2");

                }
                break;


//                            IIId
        }
        switch (view.getId()) {
            case R.id.LExtrmt_3d0pre:
                if (LExtrmt_3d0pre.isChecked()) {
                    LExtrmt_3d = "0";
                    LExtrmt_Q9 = Double.parseDouble("0");

                }
                break;


            case R.id.LExtrmt_3d1pre:
                if (LExtrmt_3d1pre.isChecked()) {
                    LExtrmt_3d = "1";
                    LExtrmt_Q9 = Double.parseDouble("1");

                }
                break;

            case R.id.LExtrmt_3d2pre:
                if (LExtrmt_3d2pre.isChecked()) {
                    LExtrmt_3d = "2";
                    LExtrmt_Q9 = Double.parseDouble("2");

                }
                break;

//                                                IV

//                    IVa

        }
        switch (view.getId()) {
            case R.id.LExtrmt_4a0pre:
                if (LExtrmt_4a0pre.isChecked()) {
                    LExtrmt_4a = "0";
                    LExtrmt_Q10 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_4a1pre:
                if (LExtrmt_4a1pre.isChecked()) {
                    Event = "1";
                    LExtrmt_4a = "1";
                    LExtrmt_Q10 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_4a2pre:
                if (LExtrmt_4a2pre.isChecked()) {
                    LExtrmt_4a = "2";
                    LExtrmt_Q10 = Double.parseDouble("2");
                }
                break;
//                        IVb
        }
        switch (view.getId()) {
            case R.id.LExtrmt_4b0pre:
                if (LExtrmt_4b0pre.isChecked()) {
                    Event = "0";
                    LExtrmt_4b = "0";
                    LExtrmt_Q11 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_4b1pre:
                if (LExtrmt_4b1pre.isChecked()) {
                    LExtrmt_4b = "1";
                    LExtrmt_Q11 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_4b2pre:
                if (LExtrmt_4b2pre.isChecked()) {
                    LExtrmt_4b = "2";
                    LExtrmt_Q11 = Double.parseDouble("2");
                }
                break;


//                                                V

//                    Va
        }
        switch (view.getId()) {

            case R.id.LExtrmt_5a0pre:
                if (LExtrmt_5a0pre.isChecked()) {
                    LExtrmt_5a = "0";
                    LExtrmt_Q12 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_5a1pre:
                if (LExtrmt_5a1pre.isChecked()) {
                    LExtrmt_5a = "1";
                    LExtrmt_Q12 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_5a2pre:
                if (LExtrmt_5a2pre.isChecked()) {
                    LExtrmt_5a = "2";
                    LExtrmt_Q12 = Double.parseDouble("2");
                }
                break;
//                       Vb
        }
        switch (view.getId()) {
            case R.id.LExtrmt_5b0pre:
                if (LExtrmt_5b0pre.isChecked()) {
                    LExtrmt_5b = "0";
                    LExtrmt_Q13 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_5b1pre:
                if (LExtrmt_5b1pre.isChecked()) {
                    LExtrmt_5b = "1";
                    LExtrmt_Q13 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_5b2pre:

                if (LExtrmt_5b2pre.isChecked()) {
                    LExtrmt_5b = "2";
                    LExtrmt_Q13 = Double.parseDouble("2");
                }
                break;


//                    Via

        }
        switch (view.getId()) {
            case R.id.LExtrmt_6a0pre:

                if (LExtrmt_6a0pre.isChecked()) {
                    LExtrmt_6a = "0";
                    LExtrmt_Q14 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_6a1pre:

                if (LExtrmt_6a1pre.isChecked()) {
                    LExtrmt_6a = "1";
                    LExtrmt_Q14 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_6a2pre:
                if (LExtrmt_6a2pre.isChecked()) {
                    LExtrmt_6a = "2";
                    LExtrmt_Q14 = Double.parseDouble("2");
                }
                break;


            //                   V IIa

        }
        switch (view.getId()) {
            case R.id.LExtrmt_7a0pre:
                if (LExtrmt_7a0pre.isChecked()) {
                    LExtrmt_7a = "0";
                    LExtrmt_Q15 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_7a1pre:

                if (LExtrmt_7a1pre.isChecked()) {
                    LExtrmt_7a = "1";
                    LExtrmt_Q15 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_7a2pre:
                if (LExtrmt_7a2pre.isChecked()) {
                    LExtrmt_7a = "2";
                    LExtrmt_Q15 = Double.parseDouble("2");
                }
                break;
//                        VIIb
        }
        switch (view.getId()) {
            case R.id.LExtrmt_7b0pre:

                if (LExtrmt_7b0pre.isChecked()) {
                    LExtrmt_7b = "0";
                    LExtrmt_Q16 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_7b1pre:

                if (LExtrmt_7b1pre.isChecked()) {
                    LExtrmt_7b = "1";
                    LExtrmt_Q16 = Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_7b2pre:

                if (LExtrmt_7b2pre.isChecked()) {
                    LExtrmt_7b = "2";
                    LExtrmt_Q16 = Double.parseDouble("2");
                }
                break;


//                            VIIC
        }
        switch (view.getId()) {
            case R.id.LExtrmt_7c0pre:

                if (LExtrmt_7c0pre.isChecked()) {
                    LExtrmt_7c = "0";
                    LExtrmt_Q17 = Double.parseDouble("0");
                }
                break;


            case R.id.LExtrmt_7c1pre:

                if (LExtrmt_7c1pre.isChecked()) {
                    LExtrmt_7c = "1";
                    LExtrmt_Q17= Double.parseDouble("1");
                }
                break;

            case R.id.LExtrmt_7c2pre:

                if (LExtrmt_7c2pre.isChecked()) {
                    LExtrmt_7c = "2";
                    LExtrmt_Q17 = Double.parseDouble("2");
                }
                break;
        }

//     Addition stuff

        LExtrmt_QTotal = LExtrmt_Q1 + LExtrmt_Q2 + LExtrmt_Q3 + LExtrmt_Q4 + LExtrmt_Q5 + LExtrmt_Q6 + LExtrmt_Q7 + LExtrmt_Q8 + LExtrmt_Q9 + LExtrmt_Q10 + LExtrmt_Q11 + LExtrmt_Q12 + LExtrmt_Q13 + LExtrmt_Q14 + LExtrmt_Q15 + LExtrmt_Q16 + LExtrmt_Q17;
        LExtrmt_total.setText(String.valueOf(LExtrmt_QTotal));


//        LExtrmt_totalconf.setText(String.valueOf(LExtrmt_7a+LExtrmt_7b+LExtrmt_7c) );

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.RadioButtonPP1:
                if (RadioButtonPP1.isChecked()) {
                    Event = "pp1_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.RadioButtonPP2:
                if (RadioButtonPP2.isChecked()) {
                    Event = "pp2_arm_1";
                } else {
                    Event = "NULL";
                }
                break;

            case R.id.RadioButtonADM:
                if (RadioButtonADM.isChecked()) {
                    Event = "adm_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.RadioButtonFU:
                if (RadioButtonFU.isChecked()) {
                    Event = "fu_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.RadioButtonDC:
                if (RadioButtonDC.isChecked()) {
                    Event = "dc_arm_1";
                } else {
                    Event = "NULL";
                }
                break;
            case R.id.RadioButtonMP:
                if (RadioButtonMP.isChecked()) {
                    Event = "mp_arm_1";
                } else {
                    Event = "NULL";
                }
                break;


        }
        switch (v.getId()) {
            case R.id.bStart2:
                bStop1.setEnabled(true);
                bStart1.setEnabled(false);
                TimeR.start();
                break;
        }
        switch (v.getId()) {
            case R.id.bStop2:
                bStop1.setEnabled(false);
                bStart1.setEnabled(true);
                TimeR.cancel();
                break;
        }

        switch (v.getId()) {
            case R.id.bDone:

                inputcheck = new ArrayList<>();

                if (!RadioButtonPP1.isChecked() && !RadioButtonPP2.isChecked() && !RadioButtonADM.isChecked() && !RadioButtonDC.isChecked() && !RadioButtonFU.isChecked() && !RadioButtonMP.isChecked()) {
                    inputcheck.add("Session");
                }


                if (!LExtrmt_1a0pre.isChecked() && !LExtrmt_1a2pre.isChecked()) {
                    inputcheck.add("1a");
                }

                if (!LExtrmt_1b0pre.isChecked() && !LExtrmt_1b2pre.isChecked()) {
                    inputcheck.add("1b");
                }

                if (!LExtrmt_2a0pre.isChecked() && !LExtrmt_2a1pre.isChecked() && !LExtrmt_2a2pre.isChecked()) {
                    inputcheck.add("2a");
                }

                if (!LExtrmt_2b0pre.isChecked() && !LExtrmt_2b1pre.isChecked() && !LExtrmt_2b2pre.isChecked()) {
                    inputcheck.add("2b");
                }
                if (!LExtrmt_2c0pre.isChecked() && !LExtrmt_2c1pre.isChecked() && !LExtrmt_2c2pre.isChecked()) {
                    inputcheck.add("2c");
                }

                if (!LExtrmt_3a0pre.isChecked() && !LExtrmt_3a1pre.isChecked() && !LExtrmt_3a2pre.isChecked()) {
                    inputcheck.add("3a");
                }

                if (!LExtrmt_3b0pre.isChecked() && !LExtrmt_3b1pre.isChecked() && !LExtrmt_3b2pre.isChecked()) {
                    inputcheck.add("3b");
                }
                if (!LExtrmt_3c0pre.isChecked() && !LExtrmt_3c1pre.isChecked() && !LExtrmt_3c2pre.isChecked()) {
                    inputcheck.add("3c");
                }

                if (!LExtrmt_3d0pre.isChecked() && !LExtrmt_3d1pre.isChecked() && !LExtrmt_3d2pre.isChecked()) {
                    inputcheck.add("3d");
                }

                if (!LExtrmt_4a0pre.isChecked() && !LExtrmt_4a1pre.isChecked() && !LExtrmt_4a2pre.isChecked()) {
                    inputcheck.add("4a");
                }

                if (!LExtrmt_4b0pre.isChecked() && !LExtrmt_4b1pre.isChecked() && !LExtrmt_4b2pre.isChecked()) {
                    inputcheck.add("4b");
                }

                if (!LExtrmt_5a0pre.isChecked() && !LExtrmt_5a1pre.isChecked() && !LExtrmt_5a2pre.isChecked()) {
                    inputcheck.add("5a");
                }

                if (!LExtrmt_5b0pre.isChecked() && !LExtrmt_5b1pre.isChecked() && !LExtrmt_5b2pre.isChecked()) {
                    inputcheck.add("5b");
                }

                if (!LExtrmt_6a0pre.isChecked() && !LExtrmt_6a1pre.isChecked() && !LExtrmt_6a2pre.isChecked()) {
                    inputcheck.add("6a");
                }


                if (!LExtrmt_7a0pre.isChecked() && !LExtrmt_7a1pre.isChecked() && !LExtrmt_7a2pre.isChecked()) {
                    inputcheck.add("7a");
                }

                if (!LExtrmt_7b0pre.isChecked() && !LExtrmt_7b1pre.isChecked() && !LExtrmt_7b2pre.isChecked()) {
                    inputcheck.add("7b");
                }
                if (!LExtrmt_7c0pre.isChecked() && !LExtrmt_7c1pre.isChecked() && !LExtrmt_7c2pre.isChecked()) {
                    inputcheck.add("7c");
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
                    alertDialog.setIcon(R.mipmap.ic_launcher);
                    alertDialog.show();
                } else {

                     Intent Answers = new Intent(Lextremity.this, Lextremityconf.class);
                     Answers.putExtra("LExtrmt_1a", LExtrmt_Q1);
                     Answers.putExtra("LExtrmt_1b", LExtrmt_Q2);
                     Answers.putExtra("LExtrmt_2a", LExtrmt_Q3);
                     Answers.putExtra("LExtrmt_2b", LExtrmt_Q4);
                     Answers.putExtra("LExtrmt_2c", LExtrmt_Q5);
                     Answers.putExtra("LExtrmt_3a", LExtrmt_Q6);
                     Answers.putExtra("LExtrmt_3b", LExtrmt_Q7);
                     Answers.putExtra("LExtrmt_3c", LExtrmt_Q8);
                     Answers.putExtra("LExtrmt_3d", LExtrmt_Q9);
                     Answers.putExtra("LExtrmt_4a", LExtrmt_Q10);
                     Answers.putExtra("LExtrmt_4b", LExtrmt_Q11);
                     Answers.putExtra("LExtrmt_5a", LExtrmt_Q12);
                     Answers.putExtra("LExtrmt_5b", LExtrmt_Q13);
                     Answers.putExtra("LExtrmt_6a", LExtrmt_Q14);
                     Answers.putExtra("LExtrmt_7a", LExtrmt_Q15);
                     Answers.putExtra("LExtrmt_7b", LExtrmt_Q16);
                     Answers.putExtra("LExtrmt_7c", LExtrmt_Q17);

                     Answers.putExtra("LExtrmt_QTotal", LExtrmt_QTotal);

                     Answers.putExtra("Event", Event);
                     Answers.putExtra("PatientID", PatID);
                     Answers.putExtra("Date", Date);
                     startActivity(Answers);

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
