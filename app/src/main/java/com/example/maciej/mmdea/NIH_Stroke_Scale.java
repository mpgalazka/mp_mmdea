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

public class NIH_Stroke_Scale extends AppCompatActivity implements View.OnClickListener, TextWatcher{

    String PatID, Date, Event, joined,
            NIHQ5RT, NIHQ5LT, NIHQ6RT, NIHQ6LT, NIHQ7T, NIHQ10T,
            notes1a,notes2a,notes3a,notes4a,notes5a,notes6a;
    TextView patientID, currentDateTimeString, NIHTotal;

    Button bDone;

    Double NIHQ1a, NIHQ1b, NIHQ1c, NIHQ2, NIHQ3, NIHQ4, NIHQ5R, NIHQ5L, NIHQ6R, NIHQ6L, NIHQ7, NIHQ8, NIHQ9, NIHQ10, NIHQ11, NIHQTotal;

    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
            NIH1aa, NIH1ab, NIH1ac, NIH1ad,
            NIH1ba, NIH1bb, NIH1bc,
            NIH1ca, NIH1cb, NIH1cc,
            NIH2a, NIH2b, NIH2c,
            NIH3a, NIH3b, NIH3c, NIH3d,
            NIH4a, NIH4b, NIH4c, NIH4d,
            NIH5Ra, NIH5Rb, NIH5Rc, NIH5Rd, NIH5Re, NIH5Rf,
            NIH5La, NIH5Lb, NIH5Lc, NIH5Ld, NIH5Le, NIH5Lf,
            NIH6Ra, NIH6Rb, NIH6Rc, NIH6Rd, NIH6Re, NIH6Rf,
            NIH6La, NIH6Lb, NIH6Lc, NIH6Ld, NIH6Le, NIH6Lf,
            NIH7a, NIH7b, NIH7c, NIH7d,
            NIH8a, NIH8b, NIH8c,
            NIH9a, NIH9b, NIH9c, NIH9d,
            NIH10a, NIH10b, NIH10c, NIH10d,
            NIH11a, NIH11b, NIH11c;

    ArrayList<String> inputcheck, NIHUN;

    EditText notes1,notes2,notes3,notes4,notes5,notes6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nih__stroke__scale);

        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Date: " + Date);

        NIHTotal = (TextView) findViewById(R.id.NIHTotal);

        Event = "NULL";

        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);
        
        NIHUN = new ArrayList<>();


        NIHTotal = (TextView) findViewById(R.id.NIHTotal);

        NIHQ1a = Double.parseDouble("0");
        NIHQ1b = Double.parseDouble("0");
        NIHQ1c = Double.parseDouble("0");
        NIHQ2 = Double.parseDouble("0");
        NIHQ3 = Double.parseDouble("0");
        NIHQ4 = Double.parseDouble("0");
        NIHQ5R = Double.parseDouble("0");
        NIHQ5L = Double.parseDouble("0");
        NIHQ6R = Double.parseDouble("0");
        NIHQ6L = Double.parseDouble("0");
        NIHQ7 = Double.parseDouble("0");
        NIHQ8 = Double.parseDouble("0");
        NIHQ9 = Double.parseDouble("0");
        NIHQ10 = Double.parseDouble("0");
        NIHQ11 = Double.parseDouble("0");
        NIHQTotal = Double.parseDouble("0");

        NIHQ5RT = "";
        NIHQ5LT = "";
        NIHQ6RT = "";
        NIHQ6LT = "";
        NIHQ7T = "";
        NIHQ10T = "";

        notes1= (EditText)findViewById(R.id.notes1);
        notes2= (EditText)findViewById(R.id.notes2);
        notes3= (EditText)findViewById(R.id.notes3);
        notes4= (EditText)findViewById(R.id.notes4);
        notes5= (EditText)findViewById(R.id.notes5);
        notes6= (EditText)findViewById(R.id.notes6);

        notes1.addTextChangedListener(this);
        notes2.addTextChangedListener(this);
        notes3.addTextChangedListener(this);
        notes4.addTextChangedListener(this);
        notes5.addTextChangedListener(this);
        notes6.addTextChangedListener(this);

        NIH1aa = (RadioButton) findViewById(R.id.NIH1aa);
        NIH1ab = (RadioButton) findViewById(R.id.NIH1ab);
        NIH1ac = (RadioButton) findViewById(R.id.NIH1ac);
        NIH1ad = (RadioButton) findViewById(R.id.NIH1ad);


        NIH1ba = (RadioButton) findViewById(R.id.NIH1ba);
        NIH1bb = (RadioButton) findViewById(R.id.NIH1bb);
        NIH1bc = (RadioButton) findViewById(R.id.NIH1bc);

        NIH1ca = (RadioButton) findViewById(R.id.NIH1ca);
        NIH1cb = (RadioButton) findViewById(R.id.NIH1cb);
        NIH1cc = (RadioButton) findViewById(R.id.NIH1cc);
        
        NIH2a = (RadioButton) findViewById(R.id.NIH2a);
        NIH2b = (RadioButton) findViewById(R.id.NIH2b);
        NIH2c = (RadioButton) findViewById(R.id.NIH2c);

        NIH3a = (RadioButton) findViewById(R.id.NIH3a);
        NIH3b = (RadioButton) findViewById(R.id.NIH3b);
        NIH3c = (RadioButton) findViewById(R.id.NIH3c);
        NIH3d = (RadioButton) findViewById(R.id.NIH3d);

        NIH4a = (RadioButton) findViewById(R.id.NIH4a);
        NIH4b = (RadioButton) findViewById(R.id.NIH4b);
        NIH4c = (RadioButton) findViewById(R.id.NIH4c);
        NIH4d = (RadioButton) findViewById(R.id.NIH4d);
        
        NIH5Ra = (RadioButton) findViewById(R.id.NIH5Ra);
        NIH5Rb = (RadioButton) findViewById(R.id.NIH5Rb);
        NIH5Rc = (RadioButton) findViewById(R.id.NIH5Rc);
        NIH5Rd = (RadioButton) findViewById(R.id.NIH5Rd);
        NIH5Re = (RadioButton) findViewById(R.id.NIH5Re);
        NIH5Rf = (RadioButton) findViewById(R.id.NIH5Rf);

        NIH5La = (RadioButton) findViewById(R.id.NIH5La);
        NIH5Lb = (RadioButton) findViewById(R.id.NIH5Lb);
        NIH5Lc = (RadioButton) findViewById(R.id.NIH5Lc);
        NIH5Ld = (RadioButton) findViewById(R.id.NIH5Ld);
        NIH5Le = (RadioButton) findViewById(R.id.NIH5Le);
        NIH5Lf = (RadioButton) findViewById(R.id.NIH5Lf);

        NIH6Ra = (RadioButton) findViewById(R.id.NIH6Ra);
        NIH6Rb = (RadioButton) findViewById(R.id.NIH6Rb);
        NIH6Rc = (RadioButton) findViewById(R.id.NIH6Rc);
        NIH6Rd = (RadioButton) findViewById(R.id.NIH6Rd);
        NIH6Re = (RadioButton) findViewById(R.id.NIH6Re);
        NIH6Rf = (RadioButton) findViewById(R.id.NIH6Rf);

        NIH6La = (RadioButton) findViewById(R.id.NIH6La);
        NIH6Lb = (RadioButton) findViewById(R.id.NIH6Lb);
        NIH6Lc = (RadioButton) findViewById(R.id.NIH6Lc);
        NIH6Ld = (RadioButton) findViewById(R.id.NIH6Ld);
        NIH6Le = (RadioButton) findViewById(R.id.NIH6Le);
        NIH6Lf = (RadioButton) findViewById(R.id.NIH6Lf);
        
        NIH7a = (RadioButton) findViewById(R.id.NIH7a);
        NIH7b = (RadioButton) findViewById(R.id.NIH7b);
        NIH7c = (RadioButton) findViewById(R.id.NIH7c);
        NIH7d = (RadioButton) findViewById(R.id.NIH7d);

        NIH8a = (RadioButton) findViewById(R.id.NIH8a);
        NIH8b = (RadioButton) findViewById(R.id.NIH8b);
        NIH8c = (RadioButton) findViewById(R.id.NIH8c);
        
        NIH9a = (RadioButton) findViewById(R.id.NIH9a);
        NIH9b = (RadioButton) findViewById(R.id.NIH9b);
        NIH9c = (RadioButton) findViewById(R.id.NIH9c);
        NIH9d = (RadioButton) findViewById(R.id.NIH9d);
        
        NIH10a = (RadioButton) findViewById(R.id.NIH10a);
        NIH10b = (RadioButton) findViewById(R.id.NIH10b);
        NIH10c = (RadioButton) findViewById(R.id.NIH10c);
        NIH10d = (RadioButton) findViewById(R.id.NIH10d);

        NIH11a = (RadioButton) findViewById(R.id.NIH11a);
        NIH11b = (RadioButton) findViewById(R.id.NIH11b);
        NIH11c = (RadioButton) findViewById(R.id.NIH11c);




        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);

    }


    public void NIH(View view){


        switch (view.getId()){

            case R.id.NIH1aa:
                NIHQ1a = Double.parseDouble("0");
                break;
            case R.id.NIH1ab:
                NIHQ1a = Double.parseDouble("1");
                break;
            case R.id.NIH1ac:
                NIHQ1a = Double.parseDouble("2");
                break;
            case R.id.NIH1ad:
                NIHQ1a = Double.parseDouble("3");
                break;
        }

        switch (view.getId()){

            case R.id.NIH1ba:
                NIHQ1b = Double.parseDouble("0");
                break;
            case R.id.NIH1bb:
                NIHQ1b = Double.parseDouble("1");
                break;
            case R.id.NIH1bc:
                NIHQ1b = Double.parseDouble("2");
                break;
        }

        switch (view.getId()){

            case R.id.NIH1ca:
                NIHQ1c = Double.parseDouble("0");
                break;
            case R.id.NIH1cb:
                NIHQ1c = Double.parseDouble("1");
                break;
            case R.id.NIH1cc:
                NIHQ1c = Double.parseDouble("2");
                break;
        }

        switch (view.getId()){

            case R.id.NIH2a:
                NIHQ2 = Double.parseDouble("0");
                break;
            case R.id.NIH2b:
                NIHQ2 = Double.parseDouble("1");
                break;
            case R.id.NIH2c:
                NIHQ2 = Double.parseDouble("2");
                break;
        }

        switch (view.getId()){

            case R.id.NIH3a:
                NIHQ3 = Double.parseDouble("0");
                break;
            case R.id.NIH3b:
                NIHQ3 = Double.parseDouble("1");
                break;
            case R.id.NIH3c:
                NIHQ3 = Double.parseDouble("2");
                break;
            case R.id.NIH3d:
                NIHQ3 = Double.parseDouble("3");
                break;
        }

        switch (view.getId()){

            case R.id.NIH4a:
                NIHQ4 = Double.parseDouble("0");
                break;
            case R.id.NIH4b:
                NIHQ4 = Double.parseDouble("1");
                break;
            case R.id.NIH4c:
                NIHQ4 = Double.parseDouble("2");
                break;
            case R.id.NIH4d:
                NIHQ4 = Double.parseDouble("3");
                break;
        }

        switch (view.getId()){

            case R.id.NIH5Ra:
                NIHQ5RT = "";
                NIHQ5R = Double.parseDouble("0");
                break;
            case R.id.NIH5Rb:
                NIHQ5RT = "";
                NIHQ5R = Double.parseDouble("1");
                break;
            case R.id.NIH5Rc:
                NIHQ5RT = "";
                NIHQ5R = Double.parseDouble("2");
                break;
            case R.id.NIH5Rd:
                NIHQ5RT = "";
                NIHQ5R = Double.parseDouble("3");
                break;
            case R.id.NIH5Re:
                NIHQ5RT = "";
                NIHQ5R = Double.parseDouble("4");
                break;
            case R.id.NIH5Rf:
                NIHQ5RT = "UN";
                NIHQ5R = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH5La:
                NIHQ5LT = "";
                NIHQ5L = Double.parseDouble("0");
                break;
            case R.id.NIH5Lb:
                NIHQ5LT = "";
                NIHQ5L = Double.parseDouble("1");
                break;
            case R.id.NIH5Lc:
                NIHQ5LT = "";
                NIHQ5L = Double.parseDouble("2");
                break;
            case R.id.NIH5Ld:
                NIHQ5LT = "";
                NIHQ5L = Double.parseDouble("3");
                break;
            case R.id.NIH5Le:
                NIHQ5LT = "";
                NIHQ5L = Double.parseDouble("4");
                break;
            case R.id.NIH5Lf:
                NIHQ5LT = "UN";
                NIHQ5L = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH6Ra:
                NIHQ6RT = "";
                NIHQ6R = Double.parseDouble("0");
                break;
            case R.id.NIH6Rb:
                NIHQ6RT = "";
                NIHQ6R = Double.parseDouble("1");
                break;
            case R.id.NIH6Rc:
                NIHQ6RT = "";
                NIHQ6R = Double.parseDouble("2");
                break;
            case R.id.NIH6Rd:
                NIHQ6RT = "";
                NIHQ6R = Double.parseDouble("3");
                break;
            case R.id.NIH6Re:
                NIHQ6RT = "";
                NIHQ6R = Double.parseDouble("4");
                break;
            case R.id.NIH6Rf:
                NIHQ6RT = "UN";
                NIHQ6R = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH6La:
                NIHQ6LT = "";
                NIHQ6L = Double.parseDouble("0");
                break;
            case R.id.NIH6Lb:
                NIHQ6LT = "";
                NIHQ6L = Double.parseDouble("1");
                break;
            case R.id.NIH6Lc:
                NIHQ6LT = "";
                NIHQ6L = Double.parseDouble("2");
                break;
            case R.id.NIH6Ld:
                NIHQ6LT = "";
                NIHQ6L = Double.parseDouble("3");
                break;
            case R.id.NIH6Le:
                NIHQ6LT = "";
                NIHQ6L = Double.parseDouble("4");
                break;
            case R.id.NIH6Lf:
                NIHQ6LT = "UN";
                NIHQ6L = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH7a:
                NIHQ7T = "";
                NIHQ7 = Double.parseDouble("0");
                break;
            case R.id.NIH7b:
                NIHQ7T = "";
                NIHQ7 = Double.parseDouble("1");
                break;
            case R.id.NIH7c:
                NIHQ7T = "";
                NIHQ7 = Double.parseDouble("2");
                break;
            case R.id.NIH7d:
                NIHQ7T = "UN";
                NIHQ7 = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH8a:
                NIHQ8 = Double.parseDouble("0");
                break;
            case R.id.NIH8b:
                NIHQ8 = Double.parseDouble("1");
                break;
            case R.id.NIH8c:
                NIHQ8 = Double.parseDouble("2");
                break;
        }

        switch (view.getId()){

            case R.id.NIH9a:
                NIHQ9 = Double.parseDouble("0");
                break;
            case R.id.NIH9b:
                NIHQ9 = Double.parseDouble("1");
                break;
            case R.id.NIH9c:
                NIHQ9 = Double.parseDouble("2");
                break;
            case R.id.NIH9d:
                NIHQ9 = Double.parseDouble("3");
                break;
        }

        switch (view.getId()){

            case R.id.NIH10a:
                NIHQ10T = "";
                NIHQ10 = Double.parseDouble("0");
                break;
            case R.id.NIH10b:
                NIHQ10T = "";
                NIHQ10 = Double.parseDouble("1");
                break;
            case R.id.NIH10c:
                NIHQ10T = "";
                NIHQ10 = Double.parseDouble("2");
                break;
            case R.id.NIH10d:
                NIHQ10T = "UN";
                NIHQ10 = Double.parseDouble("0");
                break;
        }

        switch (view.getId()){

            case R.id.NIH11a:
                NIHQ11 = Double.parseDouble("0");
                break;
            case R.id.NIH11b:
                NIHQ11 = Double.parseDouble("1");
                break;
            case R.id.NIH11c:
                NIHQ11 = Double.parseDouble("2");
                break;
        }



        if (NIH5Rf.isChecked() && !NIHUN.contains("5R")) {
            NIHUN.add("5R");
        } else if (NIH5Rf.isChecked()){

        } else{
            NIHUN.remove("5R");
        }

        if (NIH5Lf.isChecked() && !NIHUN.contains("5L")) {
            NIHUN.add("5L");
        } else if (NIH5Lf.isChecked()){

        } else {
            NIHUN.remove("5L");
        }

        if (NIH6Rf.isChecked() && !NIHUN.contains("6R")) {
            NIHUN.add("6R");
        } else if (NIH6Rf.isChecked()){

        } else {
            NIHUN.remove("6R");
        }

        if (NIH6Lf.isChecked() && !NIHUN.contains("6L")) {
            NIHUN.add("6L");
        }else if (NIH6Lf.isChecked()){

        } else {
            NIHUN.remove("6L");
        }

        if (NIH7d.isChecked() && !NIHUN.contains("7")) {
            NIHUN.add("7");
        }else if (NIH7d.isChecked()){

        } else {
            NIHUN.remove("7");
        }

        if (NIH10d.isChecked() && !NIHUN.contains("10")) {
            NIHUN.add("10");
        }else if (NIH10d.isChecked()){

        } else {
            NIHUN.remove("10");
        }
        

        ((TextView) findViewById(R.id.NIHUN)).setText(TextUtils.join(", ", (NIHUN)));
        
        
        NIHQTotal = NIHQ1a + NIHQ1b + NIHQ1c + NIHQ2 + NIHQ3 + NIHQ4 + NIHQ5R + NIHQ5L + NIHQ6R + NIHQ6L + NIHQ7 + NIHQ8 + NIHQ9 + NIHQ10 + NIHQ11;
        NIHTotal.setText(String.valueOf(NIHQTotal));

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

                if (!NIH1aa.isChecked() && !NIH1ab.isChecked() && !NIH1ac.isChecked() && !NIH1ad.isChecked()){
                    inputcheck.add("1a");
                }

                if (!NIH1ba.isChecked() && !NIH1bb.isChecked() && !NIH1bc.isChecked()){
                    inputcheck.add("1b");
                }

                if (!NIH1ca.isChecked() && !NIH1cb.isChecked() && !NIH1cc.isChecked()){
                    inputcheck.add("1c");
                }
                
                if (!NIH2a.isChecked() && !NIH2b.isChecked() && !NIH2c.isChecked()){
                    inputcheck.add("2");
                }

                if (!NIH3a.isChecked() && !NIH3b.isChecked() && !NIH3c.isChecked() && !NIH3d.isChecked()){
                    inputcheck.add("3");
                }

                if (!NIH4a.isChecked() && !NIH4b.isChecked() && !NIH4c.isChecked() && !NIH4d.isChecked()){
                    inputcheck.add("4");
                }

                if (!NIH5Ra.isChecked() && !NIH5Rb.isChecked() && !NIH5Rc.isChecked() && !NIH5Rd.isChecked() && !NIH5Re.isChecked() && !NIH5Rf.isChecked()){
                    inputcheck.add("5 (Right)");
                }

                if (!NIH5La.isChecked() && !NIH5Lb.isChecked() && !NIH5Lc.isChecked() && !NIH5Ld.isChecked() && !NIH5Le.isChecked() && !NIH5Lf.isChecked()){
                    inputcheck.add("5 (Left)");
                }

                if (!NIH6Ra.isChecked() && !NIH6Rb.isChecked() && !NIH6Rc.isChecked() && !NIH6Rd.isChecked() && !NIH6Re.isChecked() && !NIH6Rf.isChecked()){
                    inputcheck.add("6 (Right)");
                }

                if (!NIH6La.isChecked() && !NIH6Lb.isChecked() && !NIH6Lc.isChecked() && !NIH6Ld.isChecked() && !NIH6Le.isChecked() && !NIH6Lf.isChecked()){
                    inputcheck.add("6 (Left)");
                }

                if (!NIH7a.isChecked() && !NIH7b.isChecked() && !NIH7c.isChecked() && !NIH7d.isChecked()){
                    inputcheck.add("7");
                }

                if (!NIH8a.isChecked() && !NIH8b.isChecked() && !NIH8c.isChecked()){
                    inputcheck.add("8");
                }

                if (!NIH9a.isChecked() && !NIH9b.isChecked() && !NIH9c.isChecked() && !NIH9d.isChecked()){
                    inputcheck.add("9");
                }

                if (!NIH10a.isChecked() && !NIH10b.isChecked() && !NIH10c.isChecked() && !NIH10d.isChecked()){
                    inputcheck.add("10");
                }

                if (!NIH11a.isChecked() && !NIH11b.isChecked() && !NIH11c.isChecked()){
                    inputcheck.add("11");
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
                    Intent Answers = new Intent(NIH_Stroke_Scale.this, NIH_Stroke_Scaleconf.class);
                    Answers.putExtra("NIHQ1a", NIHQ1a);
                    Answers.putExtra("NIHQ1b", NIHQ1b);
                    Answers.putExtra("NIHQ1c", NIHQ1c);

                    Answers.putExtra("NIHQ2", NIHQ2);
                    Answers.putExtra("NIHQ3", NIHQ3);
                    Answers.putExtra("NIHQ4", NIHQ4);
                    Answers.putExtra("NIHQ5R", NIHQ5R);
                    Answers.putExtra("NIHQ5L", NIHQ5L);
                    Answers.putExtra("NIHQ5RT", NIHQ5RT);
                    Answers.putExtra("NIHQ5LT", NIHQ5LT);

                    Answers.putExtra("NIHQ6R", NIHQ6R);
                    Answers.putExtra("NIHQ6L", NIHQ6L);
                    Answers.putExtra("NIHQ6RT", NIHQ6RT);
                    Answers.putExtra("NIHQ6LT", NIHQ6LT);

                    Answers.putExtra("NIHQ7", NIHQ7);
                    Answers.putExtra("NIHQ7T", NIHQ7T);

                    Answers.putExtra("NIHQ8", NIHQ8);
                    Answers.putExtra("NIHQ9", NIHQ9);
                    Answers.putExtra("NIHQ10", NIHQ10);
                    Answers.putExtra("NIHQ10T", NIHQ10T);

                    Answers.putExtra("NIHQ11", NIHQ11);

                    Answers.putExtra("NIHQTotal", NIHQTotal);
                    Answers.putExtra("NIHUN", NIHUN);

                    Answers.putExtra("Event", Event);

                    Answers.putExtra("PatientID", PatID);
                    Answers.putExtra("Date", Date);


                    notes1a = notes1.getText().toString();
                    notes2a = notes2.getText().toString();
                    notes3a = notes3.getText().toString();
                    notes4a = notes4.getText().toString();
                    notes5a = notes5.getText().toString();
                    notes6a = notes6.getText().toString();

                    Answers.putExtra("notes1a", notes1a);
                    Answers.putExtra("notes2a", notes2a);
                    Answers.putExtra("notes3a", notes3a);
                    Answers.putExtra("notes4a", notes4a);
                    Answers.putExtra("notes5a", notes5a);
                    Answers.putExtra("notes6a", notes6a);


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


    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}


