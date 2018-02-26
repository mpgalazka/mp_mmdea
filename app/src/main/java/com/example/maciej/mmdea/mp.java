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

public class mp extends AppCompatActivity implements View.OnClickListener{

    String PatID, Date, Event, joined;
    TextView patientID, currentDateTimeString, mpTotal,mpTotal1,mpTotal2;

    Button bDone;

    Double mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20, mpqTotal,mpqTotal1,mpqTotal2;

    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
            mp1a, mp1b, mp1c, mp1d,mp1e, mp1f,
            mp2a, mp2b, mp2c, mp2d,mp2e, mp2f,
            mp3a, mp3b, mp3c, mp3d,mp3e, mp3f,
            mp4a, mp4b, mp4c, mp4d,mp4e, mp4f,
            mp5a, mp5b, mp5c, mp5d,mp5e, mp5f,
            mp6a, mp6b, mp6c, mp6d,mp6e, mp6f,
            mp7a, mp7b, mp7c, mp7d,mp7e, mp7f,
            mp8a, mp8b, mp8c, mp8d,mp8e, mp8f,
            mp9a, mp9b, mp9c, mp9d,mp9e, mp9f,
            mp10a, mp10b, mp10c, mp10d,mp10e, mp10f,
            mp11a, mp11b, mp11c, mp11d,mp11e, mp11f,
            mp12a, mp12b, mp12c, mp12d,mp12e, mp12f,
            mp13a, mp13b, mp13c, mp13d,mp13e, mp13f,
            mp14a, mp14b, mp14c, mp14d,mp14e, mp14f,
            mp15a, mp15b, mp15c, mp15d,mp15e, mp15f,
            mp16a, mp16b, mp16c, mp16d,mp16e, mp16f,
            mp17a, mp17b, mp17c, mp17d,mp17e, mp17f,
            mp18a, mp18b, mp18c, mp18d,mp18e, mp18f,
            mp19a, mp19b, mp19c, mp19d,mp19e, mp19f,
            mp20a, mp20b, mp20c, mp20d,mp20e, mp20f;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);

        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        currentDateTimeString = (TextView) findViewById(R.id.txtDate);
        Date = DateFormat.getDateTimeInstance().format(new Date());
        currentDateTimeString.setText("Date: " + Date);

        mpTotal = (TextView) findViewById(R.id.mpTotal);

        Event = "NULL";

        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(this);


        mpTotal = (TextView) findViewById(R.id.mpTotal);
        mpTotal1 = (TextView) findViewById(R.id.mpTotal1);
        mpTotal2 = (TextView) findViewById(R.id.mpTotal2);

        mp1 = Double.parseDouble("0");
        mp2 = Double.parseDouble("0");
        mp3 = Double.parseDouble("0");
        mp4 = Double.parseDouble("0");
        mp5 = Double.parseDouble("0");
        mp6 = Double.parseDouble("0");
        mp7 = Double.parseDouble("0");
        mp8 = Double.parseDouble("0");
        mp9 = Double.parseDouble("0");
        mp10 = Double.parseDouble("0");
        mp11 = Double.parseDouble("0");
        mp12 = Double.parseDouble("0");
        mp13 = Double.parseDouble("0");
        mp14 = Double.parseDouble("0");
        mp15 = Double.parseDouble("0");
        mp16 = Double.parseDouble("0");
        mp17 = Double.parseDouble("0");
        mp18 = Double.parseDouble("0");
        mp19 = Double.parseDouble("0");
        mp20 = Double.parseDouble("0");
        mpqTotal1 = Double.parseDouble("0");
        mpqTotal2 = Double.parseDouble("0");
        mpqTotal = Double.parseDouble("0");




        mp1a = (RadioButton) findViewById(R.id.mp1a);
        mp1b = (RadioButton) findViewById(R.id.mp1b);
        mp1c= (RadioButton) findViewById(R.id.mp1c);
        mp1d = (RadioButton) findViewById(R.id.mp1d);
        mp1e = (RadioButton) findViewById(R.id.mp1e);
        mp1f = (RadioButton) findViewById(R.id.mp1f);

        mp2a = (RadioButton) findViewById(R.id.mp2a);
        mp2b = (RadioButton) findViewById(R.id.mp2b);
        mp2c= (RadioButton) findViewById(R.id.mp2c);
        mp2d = (RadioButton) findViewById(R.id.mp2d);
        mp2e = (RadioButton) findViewById(R.id.mp2e);
        mp2f = (RadioButton) findViewById(R.id.mp2f);

        mp3a = (RadioButton) findViewById(R.id.mp3a);
        mp3b = (RadioButton) findViewById(R.id.mp3b);
        mp3c= (RadioButton) findViewById(R.id.mp3c);
        mp3d = (RadioButton) findViewById(R.id.mp3d);
        mp3e = (RadioButton) findViewById(R.id.mp3e);
        mp3f = (RadioButton) findViewById(R.id.mp3f);

        mp4a = (RadioButton) findViewById(R.id.mp4a);
        mp4b = (RadioButton) findViewById(R.id.mp4b);
        mp4c= (RadioButton) findViewById(R.id.mp4c);
        mp4d = (RadioButton) findViewById(R.id.mp4d);
        mp4e = (RadioButton) findViewById(R.id.mp4e);
        mp4f = (RadioButton) findViewById(R.id.mp4f);

        mp5a = (RadioButton) findViewById(R.id.mp5a);
        mp5b = (RadioButton) findViewById(R.id.mp5b);
        mp5c= (RadioButton) findViewById(R.id.mp5c);
        mp5d = (RadioButton) findViewById(R.id.mp5d);
        mp5e = (RadioButton) findViewById(R.id.mp5e);
        mp5f = (RadioButton) findViewById(R.id.mp5f);

        mp6a = (RadioButton) findViewById(R.id.mp6a);
        mp6b = (RadioButton) findViewById(R.id.mp6b);
        mp6c= (RadioButton) findViewById(R.id.mp6c);
        mp6d = (RadioButton) findViewById(R.id.mp6d);
        mp6e = (RadioButton) findViewById(R.id.mp6e);
        mp6f = (RadioButton) findViewById(R.id.mp6f);

        mp7a = (RadioButton) findViewById(R.id.mp7a);
        mp7b = (RadioButton) findViewById(R.id.mp7b);
        mp7c= (RadioButton) findViewById(R.id.mp7c);
        mp7d = (RadioButton) findViewById(R.id.mp7d);
        mp7e = (RadioButton) findViewById(R.id.mp7e);
        mp7f = (RadioButton) findViewById(R.id.mp7f);

        mp8a = (RadioButton) findViewById(R.id.mp8a);
        mp8b = (RadioButton) findViewById(R.id.mp8b);
        mp8c= (RadioButton) findViewById(R.id.mp8c);
        mp8d = (RadioButton) findViewById(R.id.mp8d);
        mp8e = (RadioButton) findViewById(R.id.mp8e);
        mp8f = (RadioButton) findViewById(R.id.mp8f);

        mp9a = (RadioButton) findViewById(R.id.mp9a);
        mp9b = (RadioButton) findViewById(R.id.mp9b);
        mp9c= (RadioButton) findViewById(R.id.mp9c);
        mp9d = (RadioButton) findViewById(R.id.mp9d);
        mp9e = (RadioButton) findViewById(R.id.mp9e);
        mp9f = (RadioButton) findViewById(R.id.mp9f);

        mp10a = (RadioButton) findViewById(R.id.mp10a);
        mp10b = (RadioButton) findViewById(R.id.mp10b);
        mp10c= (RadioButton) findViewById(R.id.mp10c);
        mp10d = (RadioButton) findViewById(R.id.mp10d);
        mp10e = (RadioButton) findViewById(R.id.mp10e);
        mp10f = (RadioButton) findViewById(R.id.mp10f);

        mp11a = (RadioButton) findViewById(R.id.mp11a);
        mp11b = (RadioButton) findViewById(R.id.mp11b);
        mp11c= (RadioButton) findViewById(R.id.mp11c);
        mp11d = (RadioButton) findViewById(R.id.mp11d);
        mp11e = (RadioButton) findViewById(R.id.mp11e);
        mp11f = (RadioButton) findViewById(R.id.mp11f);

        mp12a = (RadioButton) findViewById(R.id.mp12a);
        mp12b = (RadioButton) findViewById(R.id.mp12b);
        mp12c= (RadioButton) findViewById(R.id.mp12c);
        mp12d = (RadioButton) findViewById(R.id.mp12d);
        mp12e = (RadioButton) findViewById(R.id.mp12e);
        mp12f = (RadioButton) findViewById(R.id.mp12f);

        mp13a = (RadioButton) findViewById(R.id.mp13a);
        mp13b = (RadioButton) findViewById(R.id.mp13b);
        mp13c= (RadioButton) findViewById(R.id.mp13c);
        mp13d = (RadioButton) findViewById(R.id.mp13d);
        mp13e = (RadioButton) findViewById(R.id.mp13e);
        mp13f = (RadioButton) findViewById(R.id.mp13f);

        mp14a = (RadioButton) findViewById(R.id.mp14a);
        mp14b = (RadioButton) findViewById(R.id.mp14b);
        mp14c= (RadioButton) findViewById(R.id.mp14c);
        mp14d = (RadioButton) findViewById(R.id.mp14d);
        mp14e = (RadioButton) findViewById(R.id.mp14e);
        mp14f = (RadioButton) findViewById(R.id.mp14f);

        mp15a = (RadioButton) findViewById(R.id.mp15a);
        mp15b = (RadioButton) findViewById(R.id.mp15b);
        mp15c= (RadioButton) findViewById(R.id.mp15c);
        mp15d = (RadioButton) findViewById(R.id.mp15d);
        mp15e = (RadioButton) findViewById(R.id.mp15e);
        mp15f = (RadioButton) findViewById(R.id.mp15f);

        mp16a = (RadioButton) findViewById(R.id.mp16a);
        mp16b = (RadioButton) findViewById(R.id.mp16b);
        mp16c= (RadioButton) findViewById(R.id.mp16c);
        mp16d = (RadioButton) findViewById(R.id.mp16d);
        mp16e = (RadioButton) findViewById(R.id.mp16e);
        mp16f = (RadioButton) findViewById(R.id.mp16f);

        mp17a = (RadioButton) findViewById(R.id.mp17a);
        mp17b = (RadioButton) findViewById(R.id.mp17b);
        mp17c= (RadioButton) findViewById(R.id.mp17c);
        mp17d = (RadioButton) findViewById(R.id.mp17d);
        mp17e = (RadioButton) findViewById(R.id.mp17e);
        mp17f = (RadioButton) findViewById(R.id.mp17f);

        mp18a = (RadioButton) findViewById(R.id.mp18a);
        mp18b = (RadioButton) findViewById(R.id.mp18b);
        mp18c= (RadioButton) findViewById(R.id.mp18c);
        mp18d = (RadioButton) findViewById(R.id.mp18d);
        mp18e = (RadioButton) findViewById(R.id.mp18e);
        mp18f = (RadioButton) findViewById(R.id.mp18f);

        mp19a = (RadioButton) findViewById(R.id.mp19a);
        mp19b = (RadioButton) findViewById(R.id.mp19b);
        mp19c= (RadioButton) findViewById(R.id.mp19c);
        mp19d = (RadioButton) findViewById(R.id.mp19d);
        mp19e = (RadioButton) findViewById(R.id.mp19e);
        mp19f = (RadioButton) findViewById(R.id.mp19f);

        mp20a = (RadioButton) findViewById(R.id.mp20a);
        mp20b = (RadioButton) findViewById(R.id.mp20b);
        mp20c= (RadioButton) findViewById(R.id.mp20c);
        mp20d = (RadioButton) findViewById(R.id.mp20d);
        mp20e = (RadioButton) findViewById(R.id.mp20e);
        mp20f = (RadioButton) findViewById(R.id.mp20f);














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

            case R.id.mp1a:
                mp1 = Double.parseDouble("0");
                break;
            case R.id.mp1b:
                mp1 = Double.parseDouble("1");
                break;
            case R.id.mp1c:
                mp1 = Double.parseDouble("2");
                break;
            case R.id.mp1d:
                mp1 = Double.parseDouble("3");
                break;
            case R.id.mp1e:
                mp1 = Double.parseDouble("4");
                break;
            case R.id.mp1f:
                mp1 = Double.parseDouble("5");
                break;

        }




        switch (view.getId()){

            case R.id.mp2a:
                mp2 = Double.parseDouble("0");
                break;
            case R.id.mp2b:
                mp2 = Double.parseDouble("1");
                break;
            case R.id.mp2c:
                mp2 = Double.parseDouble("2");
                break;
            case R.id.mp2d:
                mp2 = Double.parseDouble("3");
                break;
            case R.id.mp2e:
                mp2 = Double.parseDouble("4");
                break;
            case R.id.mp2f:
                mp2 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp3a:
                mp3 = Double.parseDouble("0");
                break;
            case R.id.mp3b:
                mp3 = Double.parseDouble("1");
                break;
            case R.id.mp3c:
                mp3 = Double.parseDouble("2");
                break;
            case R.id.mp3d:
                mp3 = Double.parseDouble("3");
                break;
            case R.id.mp3e:
                mp3 = Double.parseDouble("4");
                break;
            case R.id.mp3f:
                mp3 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp4a:
                mp4 = Double.parseDouble("0");
                break;
            case R.id.mp4b:
                mp4 = Double.parseDouble("1");
                break;
            case R.id.mp4c:
                mp4 = Double.parseDouble("2");
                break;
            case R.id.mp4d:
                mp4 = Double.parseDouble("3");
                break;
            case R.id.mp4e:
                mp4 = Double.parseDouble("4");
                break;
            case R.id.mp4f:
                mp4 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp5a:
                mp5 = Double.parseDouble("0");
                break;
            case R.id.mp5b:
                mp5 = Double.parseDouble("1");
                break;
            case R.id.mp5c:
                mp5 = Double.parseDouble("2");
                break;
            case R.id.mp5d:
                mp5 = Double.parseDouble("3");
                break;
            case R.id.mp5e:
                mp5 = Double.parseDouble("4");
                break;
            case R.id.mp5f:
                mp5 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp6a:
                mp6 = Double.parseDouble("0");
                break;
            case R.id.mp6b:
                mp6 = Double.parseDouble("1");
                break;
            case R.id.mp6c:
                mp6 = Double.parseDouble("2");
                break;
            case R.id.mp6d:
                mp6 = Double.parseDouble("3");
                break;
            case R.id.mp6e:
                mp6 = Double.parseDouble("4");
                break;
            case R.id.mp6f:
                mp6 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp7a:
                mp7 = Double.parseDouble("0");
                break;
            case R.id.mp7b:
                mp7 = Double.parseDouble("1");
                break;
            case R.id.mp7c:
                mp7 = Double.parseDouble("2");
                break;
            case R.id.mp7d:
                mp7 = Double.parseDouble("3");
                break;
            case R.id.mp7e:
                mp7 = Double.parseDouble("4");
                break;
            case R.id.mp7f:
                mp7 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp8a:
                mp8 = Double.parseDouble("0");
                break;
            case R.id.mp8b:
                mp8 = Double.parseDouble("1");
                break;
            case R.id.mp8c:
                mp8 = Double.parseDouble("2");
                break;
            case R.id.mp8d:
                mp8 = Double.parseDouble("3");
                break;
            case R.id.mp8e:
                mp8 = Double.parseDouble("4");
                break;
            case R.id.mp8f:
                mp8 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp9a:
                mp9 = Double.parseDouble("0");
                break;
            case R.id.mp9b:
                mp9 = Double.parseDouble("1");
                break;
            case R.id.mp9c:
                mp9 = Double.parseDouble("2");
                break;
            case R.id.mp9d:
                mp9 = Double.parseDouble("3");
                break;
            case R.id.mp9e:
                mp9 = Double.parseDouble("4");
                break;
            case R.id.mp9f:
                mp9 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp10a:
                mp10 = Double.parseDouble("0");
                break;
            case R.id.mp10b:
                mp10 = Double.parseDouble("1");
                break;
            case R.id.mp10c:
                mp10 = Double.parseDouble("2");
                break;
            case R.id.mp10d:
                mp10 = Double.parseDouble("3");
                break;
            case R.id.mp10e:
                mp10 = Double.parseDouble("4");
                break;
            case R.id.mp10f:
                mp10 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp11a:
                mp11 = Double.parseDouble("0");
                break;
            case R.id.mp11b:
                mp11 = Double.parseDouble("1");
                break;
            case R.id.mp11c:
                mp11 = Double.parseDouble("2");
                break;
            case R.id.mp11d:
                mp11 = Double.parseDouble("3");
                break;
            case R.id.mp11e:
                mp11 = Double.parseDouble("4");
                break;
            case R.id.mp11f:
                mp11 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp12a:
                mp12 = Double.parseDouble("0");
                break;
            case R.id.mp12b:
                mp12 = Double.parseDouble("1");
                break;
            case R.id.mp12c:
                mp12 = Double.parseDouble("2");
                break;
            case R.id.mp12d:
                mp12 = Double.parseDouble("3");
                break;
            case R.id.mp12e:
                mp12 = Double.parseDouble("4");
                break;
            case R.id.mp12f:
                mp12 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp13a:
                mp13 = Double.parseDouble("0");
                break;
            case R.id.mp13b:
                mp13 = Double.parseDouble("1");
                break;
            case R.id.mp13c:
                mp13 = Double.parseDouble("2");
                break;
            case R.id.mp13d:
                mp13 = Double.parseDouble("3");
                break;
            case R.id.mp13e:
                mp13 = Double.parseDouble("4");
                break;
            case R.id.mp13f:
                mp13 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp14a:
                mp14 = Double.parseDouble("0");
                break;
            case R.id.mp14b:
                mp14 = Double.parseDouble("1");
                break;
            case R.id.mp14c:
                mp14 = Double.parseDouble("2");
                break;
            case R.id.mp14d:
                mp14 = Double.parseDouble("3");
                break;
            case R.id.mp14e:
                mp14 = Double.parseDouble("4");
                break;
            case R.id.mp14f:
                mp14 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp15a:
                mp15 = Double.parseDouble("0");
                break;
            case R.id.mp15b:
                mp15 = Double.parseDouble("1");
                break;
            case R.id.mp15c:
                mp15 = Double.parseDouble("2");
                break;
            case R.id.mp15d:
                mp15 = Double.parseDouble("3");
                break;
            case R.id.mp15e:
                mp15 = Double.parseDouble("4");
                break;
            case R.id.mp15f:
                mp15 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp16a:
                mp16 = Double.parseDouble("0");
                break;
            case R.id.mp16b:
                mp16 = Double.parseDouble("1");
                break;
            case R.id.mp16c:
                mp16 = Double.parseDouble("2");
                break;
            case R.id.mp16d:
                mp16 = Double.parseDouble("3");
                break;
            case R.id.mp16e:
                mp16 = Double.parseDouble("4");
                break;
            case R.id.mp16f:
                mp16 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp17a:
                mp17 = Double.parseDouble("0");
                break;
            case R.id.mp17b:
                mp17 = Double.parseDouble("1");
                break;
            case R.id.mp17c:
                mp17 = Double.parseDouble("2");
                break;
            case R.id.mp17d:
                mp17 = Double.parseDouble("3");
                break;
            case R.id.mp17e:
                mp17 = Double.parseDouble("4");
                break;
            case R.id.mp17f:
                mp17 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp18a:
                mp18 = Double.parseDouble("0");
                break;
            case R.id.mp18b:
                mp18 = Double.parseDouble("1");
                break;
            case R.id.mp18c:
                mp18 = Double.parseDouble("2");
                break;
            case R.id.mp18d:
                mp18 = Double.parseDouble("3");
                break;
            case R.id.mp18e:
                mp18 = Double.parseDouble("4");
                break;
            case R.id.mp18f:
                mp18 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp19a:
                mp19 = Double.parseDouble("0");
                break;
            case R.id.mp19b:
                mp19 = Double.parseDouble("1");
                break;
            case R.id.mp19c:
                mp19 = Double.parseDouble("2");
                break;
            case R.id.mp19d:
                mp19 = Double.parseDouble("3");
                break;
            case R.id.mp19e:
                mp19 = Double.parseDouble("4");
                break;
            case R.id.mp19f:
                mp19 = Double.parseDouble("5");
                break;

        }

        switch (view.getId()){

            case R.id.mp20a:
                mp20 = Double.parseDouble("0");
                break;
            case R.id.mp20b:
                mp20 = Double.parseDouble("1");
                break;
            case R.id.mp20c:
                mp20 = Double.parseDouble("2");
                break;
            case R.id.mp20d:
                mp20 = Double.parseDouble("3");
                break;
            case R.id.mp20e:
                mp20 = Double.parseDouble("4");
                break;
            case R.id.mp20f:
                mp20 = Double.parseDouble("5");
                break;

        }




        mpqTotal1=mp1+mp2+mp3+mp4+mp5+mp6+mp7+mp8+mp9+mp10+mp11+mp12+mp13+mp14;
        mpqTotal2=mp15+mp16+mp17+mp18+mp19+mp20;
        mpqTotal = mp1+mp2+mp3+mp4+mp5+mp6+mp7+mp8+mp9+mp10+mp11+mp12+mp13+mp14+mp15+mp16+mp17+mp18+mp19+mp20;
        mpTotal.setText(String.valueOf(mpqTotal));
        mpTotal1.setText(String.valueOf(mpqTotal1));
        mpTotal2.setText(String.valueOf(mpqTotal2));

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

                if (!mp1a.isChecked() && !mp1b.isChecked() && !mp1c.isChecked() && !mp1d.isChecked() && !mp1e.isChecked()&& !mp1f.isChecked()){
                    inputcheck.add("1");
                }

                if (!mp2a.isChecked() && !mp2b.isChecked() && !mp2c.isChecked() && !mp2d.isChecked() && !mp2e.isChecked()&& !mp2f.isChecked()){
                    inputcheck.add("2");
                }

                if (!mp3a.isChecked() && !mp3b.isChecked() && !mp3c.isChecked() && !mp3d.isChecked() && !mp3e.isChecked()&& !mp3f.isChecked()){
                    inputcheck.add("3");
                }

                if (!mp4a.isChecked() && !mp4b.isChecked() && !mp4c.isChecked() && !mp4d.isChecked() && !mp4e.isChecked()&& !mp4f.isChecked()){
                    inputcheck.add("4");
                }

                if (!mp5a.isChecked() && !mp5b.isChecked() && !mp5c.isChecked() && !mp5d.isChecked() && !mp5e.isChecked()&& !mp5f.isChecked()){
                    inputcheck.add("5");
                }

                if (!mp6a.isChecked() && !mp6b.isChecked() && !mp6c.isChecked() && !mp6d.isChecked() && !mp6e.isChecked()&& !mp6f.isChecked()){
                    inputcheck.add("6");
                }

                if (!mp7a.isChecked() && !mp7b.isChecked() && !mp7c.isChecked() && !mp7d.isChecked() && !mp7e.isChecked()&& !mp7f.isChecked()){
                    inputcheck.add("7");
                }

                if (!mp8a.isChecked() && !mp8b.isChecked() && !mp8c.isChecked() && !mp8d.isChecked() && !mp8e.isChecked()&& !mp8f.isChecked()){
                    inputcheck.add("8");
                }

                if (!mp9a.isChecked() && !mp9b.isChecked() && !mp9c.isChecked() && !mp9d.isChecked() && !mp9e.isChecked()&& !mp9f.isChecked()){
                    inputcheck.add("9");
                }

                if (!mp10a.isChecked() && !mp10b.isChecked() && !mp10c.isChecked() && !mp10d.isChecked() && !mp10e.isChecked()&& !mp10f.isChecked()){
                    inputcheck.add("10");
                }

                if (!mp11a.isChecked() && !mp11b.isChecked() && !mp11c.isChecked() && !mp11d.isChecked() && !mp11e.isChecked()&& !mp11f.isChecked()){
                    inputcheck.add("11");
                }

                if (!mp12a.isChecked() && !mp12b.isChecked() && !mp12c.isChecked() && !mp12d.isChecked() && !mp12e.isChecked()&& !mp12f.isChecked()){
                    inputcheck.add("12");
                }

                if (!mp13a.isChecked() && !mp13b.isChecked() && !mp13c.isChecked() && !mp13d.isChecked() && !mp13e.isChecked()&& !mp13f.isChecked()){
                    inputcheck.add("13");
                }

                if (!mp14a.isChecked() && !mp14b.isChecked() && !mp14c.isChecked() && !mp14d.isChecked() && !mp14e.isChecked()&& !mp14f.isChecked()){
                    inputcheck.add("14");
                }

                if (!mp15a.isChecked() && !mp15b.isChecked() && !mp15c.isChecked() && !mp15d.isChecked() && !mp15e.isChecked()&& !mp15f.isChecked()){
                    inputcheck.add("15");
                }

                if (!mp16a.isChecked() && !mp16b.isChecked() && !mp16c.isChecked() && !mp16d.isChecked() && !mp16e.isChecked()&& !mp16f.isChecked()){
                    inputcheck.add("16");
                }

                if (!mp17a.isChecked() && !mp17b.isChecked() && !mp17c.isChecked() && !mp17d.isChecked() && !mp17e.isChecked()&& !mp17f.isChecked()){
                    inputcheck.add("17");
                }

                if (!mp18a.isChecked() && !mp18b.isChecked() && !mp18c.isChecked() && !mp18d.isChecked() && !mp18e.isChecked()&& !mp18f.isChecked()){
                    inputcheck.add("18");
                }

                if (!mp19a.isChecked() && !mp19b.isChecked() && !mp19c.isChecked() && !mp19d.isChecked() && !mp19e.isChecked()&& !mp19f.isChecked()){
                    inputcheck.add("19");
                }

                if (!mp20a.isChecked() && !mp20b.isChecked() && !mp20c.isChecked() && !mp20d.isChecked() && !mp20e.isChecked()&& !mp20f.isChecked()){
                    inputcheck.add("20");
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
                    Intent Answers = new Intent(mp.this, mpconf.class);
                    Answers.putExtra("mp1", mp1);
                    Answers.putExtra("mp2", mp2);
                    Answers.putExtra("mp3", mp3);
                    Answers.putExtra("mp4", mp4);
                    Answers.putExtra("mp5", mp5);
                    Answers.putExtra("mp6", mp6);
                    Answers.putExtra("mp7", mp7);
                    Answers.putExtra("mp8", mp8);
                    Answers.putExtra("mp9", mp9);
                    Answers.putExtra("mp10", mp10);
                    Answers.putExtra("mp11", mp11);
                    Answers.putExtra("mp12", mp12);
                    Answers.putExtra("mp13", mp13);
                    Answers.putExtra("mp14", mp14);
                    Answers.putExtra("mp15", mp15);
                    Answers.putExtra("mp16", mp16);
                    Answers.putExtra("mp17", mp17);
                    Answers.putExtra("mp18", mp18);
                    Answers.putExtra("mp19", mp19);
                    Answers.putExtra("mp20", mp20);




                    Answers.putExtra("mpqTotal", mpqTotal);
                    Answers.putExtra("mpqTotal1", mpqTotal1);
                    Answers.putExtra("mpqTotal2", mpqTotal2);
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


