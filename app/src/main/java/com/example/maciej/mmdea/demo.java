package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class demo extends AppCompatActivity implements View.OnClickListener
{
    EditText name,address1,address2,phone,dob,email,emergencyname,emergencynumber,numberofstrokes, strokedates, braininjdate, spineinjdate,neuroillness,admdate,
            comorbid, pharmameds,interest6,
    //dont have to define>>
    handednessa,stroketypea,lesionlocationa,bodyweaknessa,weaklimba,veterana,exsmokera,smokera,cholesterola,alcohola,dieia,dieiia,prestrokea,hypertensiona,
            famstrokea,atrialfa,testinga;

    Button donebutton;

    CheckBox interest1,interest2,interest3,interest4,interest5, handright,handleft, stroketype1, stroketype2,lesloc1,lesloc2,lesloc3,lesloc4,bodweak1,bodweak2,weaklimb1,weaklimb2, diagtest1, diagtest2, diagtest3;
    RadioButton vetyes,vetno,smokeryes,smokerno,exsmokeryes,
            exsmokerno,alcoholyes, alcoholno ,highcolyes,highcolno,diabetes1yes,diabetes1no,diabetes2yes,diabetes2no, prevstrokeyes,prevstrokeno,hbpyes,hbpno,famstrokeyes,
            famstrokeno,atrialyes,atrialno;

    //textboxes
    String PatientName, phonea,doba,address1a,address2a,emaila,emergencynamea,emergencynumbera,numberofstrokesa,strokedatesa,braininjdatea,spineinjdatea,neuroillnessa,
            admdatea,comorbida,pharmamedsa,interest6a, PatID,
    //checkboxes
    veteran,exsmoker,smoker,cholesterol,alcohol,diei,dieii,prestroke,hypertension,famstroke,atrialf;

    ArrayList<String> handedness,stroketype,lesionlocation,bodyweakness,weaklimb,interests,testing;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);


        Intent PID = this.getIntent();
        PatID = PID.getStringExtra("PatientID");

        handedness = new ArrayList<>();
        stroketype = new ArrayList<>();
        lesionlocation = new ArrayList<>();
        bodyweakness = new ArrayList<>();
        weaklimb = new ArrayList<>();
        interests = new ArrayList<>();
        testing = new ArrayList<>();


        //textboxex
        name = (EditText)findViewById(R.id.name);
        address1 = (EditText)findViewById(R.id.address1);
        address2 = (EditText)findViewById(R.id.address2);
        phone= (EditText)findViewById(R.id.phone);
        dob= (EditText)findViewById(R.id.dob);
        email= (EditText)findViewById(R.id.email);
        emergencyname= (EditText)findViewById(R.id.emergencyname);
        emergencynumber= (EditText)findViewById(R.id.emergencynumber);

        numberofstrokes= (EditText)findViewById(R.id.numberofstrokes);
        strokedates= (EditText)findViewById(R.id.strokedates);
        braininjdate= (EditText)findViewById(R.id.braininjdate);
        spineinjdate= (EditText)findViewById(R.id.spineinjdate);
        neuroillness= (EditText)findViewById(R.id.neuroillness);
        admdate= (EditText)findViewById(R.id.admdate);
        comorbid= (EditText)findViewById(R.id.comorbid);
        pharmameds= (EditText)findViewById(R.id.pharmameds);

        interest6= (EditText)findViewById(R.id.interest6);



        //RadioButtones

        handright=(CheckBox)findViewById(R.id.handright);
        handright.setOnClickListener(this);

        handleft=(CheckBox)findViewById(R.id.handleft);
        handleft.setOnClickListener(this);

        stroketype1=(CheckBox)findViewById(R.id.stroketype1);
        stroketype1.setOnClickListener(this);

        stroketype2=(CheckBox)findViewById(R.id.stroketype2);
        stroketype2.setOnClickListener(this);

        lesloc1 =(CheckBox)findViewById(R.id.lesloc1);
        lesloc1.setOnClickListener(this);

        lesloc2=(CheckBox)findViewById(R.id.lesloc2);
        lesloc2.setOnClickListener(this);

        lesloc3=(CheckBox)findViewById(R.id.lesloc3);
        lesloc3.setOnClickListener(this);

        lesloc4=(CheckBox)findViewById(R.id.lesloc4);
        lesloc4.setOnClickListener(this);

        bodweak1=(CheckBox)findViewById(R.id.bodweak1);
        bodweak1.setOnClickListener(this);

        bodweak2=(CheckBox)findViewById(R.id.bodweak2);
        bodweak2.setOnClickListener(this);


        weaklimb1=(CheckBox)findViewById(R.id.weaklimb1);
        weaklimb1.setOnClickListener(this);

        weaklimb2=(CheckBox)findViewById(R.id.weaklimb2);
        weaklimb2.setOnClickListener(this);




        vetyes=(RadioButton)findViewById(R.id.vetyes);
        vetyes.setOnClickListener(this);

        vetno=(RadioButton)findViewById(R.id.vetno);
        vetno.setOnClickListener(this);

        smokeryes=(RadioButton)findViewById(R.id.smokeryes);
        smokeryes.setOnClickListener(this);

        smokerno=(RadioButton)findViewById(R.id.smokerno);
        smokerno.setOnClickListener(this);

        exsmokeryes=(RadioButton)findViewById(R.id.exsmokeryes);
        exsmokeryes.setOnClickListener(this);

        exsmokerno=(RadioButton)findViewById(R.id.exsmokerno);
        exsmokerno.setOnClickListener(this);

        alcoholyes=(RadioButton)findViewById(R.id.alcoholyes);
        alcoholyes.setOnClickListener(this);

        alcoholno=(RadioButton)findViewById(R.id.alcoholno);
        alcoholno.setOnClickListener(this);

        highcolyes=(RadioButton)findViewById(R.id.highcolyes);
        highcolyes.setOnClickListener(this);

        highcolno=(RadioButton)findViewById(R.id.highcolno);
        highcolno.setOnClickListener(this);

        diabetes1yes=(RadioButton)findViewById(R.id.diabetes1yes);
        diabetes1yes.setOnClickListener(this);

        diabetes1no=(RadioButton)findViewById(R.id.diabetes1no);
        diabetes1no.setOnClickListener(this);

        diabetes2yes=(RadioButton)findViewById(R.id.diabetes2yes);
        diabetes2yes.setOnClickListener(this);

        diabetes2no=(RadioButton)findViewById(R.id.diabetes2no);
        diabetes2no.setOnClickListener(this);

        prevstrokeyes=(RadioButton)findViewById(R.id.prevstrokeyes);
        prevstrokeyes.setOnClickListener(this);

        prevstrokeno=(RadioButton)findViewById(R.id.prevstrokeno);
        prevstrokeno.setOnClickListener(this);

        hbpyes=(RadioButton)findViewById(R.id.hbpyes);
        hbpyes.setOnClickListener(this);

        hbpno=(RadioButton)findViewById(R.id.hbpno);
        hbpno.setOnClickListener(this);

        famstrokeyes=(RadioButton)findViewById(R.id.famstrokeyes);
        famstrokeyes .setOnClickListener(this);

        famstrokeno=(RadioButton)findViewById(R.id.famstrokeno);
        famstrokeno.setOnClickListener(this);

        atrialyes=(RadioButton)findViewById(R.id.atrialyes);
        atrialyes.setOnClickListener(this);

        atrialno=(RadioButton)findViewById(R.id.atrialno);
        atrialno.setOnClickListener(this);

        diagtest1=(CheckBox)findViewById(R.id.diagtest1);
        diagtest1.setOnClickListener(this);

        diagtest2=(CheckBox)findViewById(R.id.diagtest2);
        diagtest2.setOnClickListener(this);

        diagtest3=(CheckBox)findViewById(R.id.diagtest3);
        diagtest3.setOnClickListener(this);

        interest1=(CheckBox)findViewById(R.id.interest1);
        interest1.setOnClickListener(this);

        interest2=(CheckBox)findViewById(R.id.interest2);
        interest2.setOnClickListener(this);

        interest3=(CheckBox)findViewById(R.id.interest3);
        interest3.setOnClickListener(this);

        interest4=(CheckBox)findViewById(R.id.interest4);
        interest4.setOnClickListener(this);

        interest5=(CheckBox)findViewById(R.id.interest5);
        interest5.setOnClickListener(this);




        //buttons
        donebutton=(Button)findViewById(R.id.donebutton);
        donebutton.setOnClickListener(this);


        //strings

    }

    @Override
    public void onClick (View v)
    {//when implements View.OnClickListener is added this comes also

        switch (v.getId()) {
            case R.id.donebutton: //When the person presses the Done button, do this...

                //the answer to patient name is PatientName String, its equal to the editText "name" and we get the text and turn it into a string.
                // After you do this to all the edit texts the button will also then transfer the data into next activity that's why we doing it here.
                PatientName = name.getText().toString();

                address1a=address1.getText().toString();

                address2a=address2.getText().toString();

                phonea=phone.getText().toString();

                doba=dob.getText().toString();

                emaila=email.getText().toString();

                emergencynamea=emergencyname.getText().toString();

                emergencynumbera=emergencynumber.getText().toString();

                numberofstrokesa=numberofstrokes.getText().toString();

                strokedatesa=strokedates.getText().toString();

                braininjdatea=braininjdate.getText().toString();

                spineinjdatea=spineinjdate.getText().toString();

                neuroillnessa=neuroillness.getText().toString();

                admdatea=admdate.getText().toString();

                comorbida=comorbid.getText().toString();

                pharmamedsa=pharmameds.getText().toString();

                interest6a=interest6.getText().toString();



                // This makes something called an Intent, it basically stores values from MainActivity and will transfer them to Main2Activity
                // (that you will make later as confirmation page I just wrote it out for you in advance)
                Intent Answers = new Intent(demo.this, democonf.class);

                //Now we say what we wanna put in this Intent, put all the answer here in this format, literally copy and paste and just change the text to fit each answer
                //textboxes
                Answers.putExtra("PatientName", PatientName);
                Answers.putExtra("address1a", address1a);
                Answers.putExtra("address2a", address2a);
                Answers.putExtra("phonea", phonea);
                Answers.putExtra("doba", doba);
                Answers.putExtra("emaila", emaila);
                Answers.putExtra("emergencynamea", emergencynamea);
                Answers.putExtra("emergencynumbera", emergencynumbera);
                Answers.putExtra("numberofstrokesa", numberofstrokesa);
                Answers.putExtra("strokedatesa", strokedatesa);
                Answers.putExtra("braininjdatea", braininjdatea);
                Answers.putExtra("spineinjdatea", spineinjdatea);
                Answers.putExtra("neuroillnessa", neuroillnessa);
                Answers.putExtra("admdatea", admdatea);
                Answers.putExtra("comorbida", comorbida);
                Answers.putExtra("pharmamedsa", pharmamedsa);
                Answers.putExtra("interest6a", interest6a);
                Answers.putExtra("PatientID", PatID);




                //checkboxes
                Answers.putExtra("handedness", handedness);  //ETC.......
                Answers.putExtra("lesionlocation", lesionlocation);
                Answers.putExtra("stroketype", stroketype);
                Answers.putExtra("bodyweakness", bodyweakness);
                Answers.putExtra("weaklimb", weaklimb);
                Answers.putExtra("veteran", veteran);
                Answers.putExtra("exsmoker", exsmoker);
                Answers.putExtra("smoker", smoker);
                Answers.putExtra("cholesterol", cholesterol);
                Answers.putExtra("alcohol", alcohol);
                Answers.putExtra("diei", diei);
                Answers.putExtra("dieii", dieii);
                Answers.putExtra("prestroke", prestroke);
                Answers.putExtra("famstroke", famstroke);
                Answers.putExtra("atrialf", atrialf);
                Answers.putExtra("testing", testing);
                Answers.putExtra("hypertension", hypertension);

//last checkboxes
                Answers.putExtra("interests", interests);



                //Now we gonna start the next activity we stated in the Intent, with the answers transferring over, this part is done.
                startActivity(Answers);

        }


        switch (v.getId()) //if then statements
        {
            case R.id.handright:
                if (handright.isChecked()) {
                    handedness.add("Right");
                } else {
                    handedness.remove("Right");
                }
                break;
            case R.id.handleft:
                if (handleft.isChecked()) {
                    handedness.add("Left");
                } else {
                    handedness.remove("Left");
                }
                break;


        }


        switch (v.getId()) //if then statements
        {
            case R.id.stroketype1:
                if (stroketype1.isChecked()) {
                    stroketype.add("Ischemic (Blood Clot)");
                } else {
                    stroketype.remove("Ischemic (Blood Clot)");
                }
                break;
            case R.id.stroketype2:
                if (stroketype2.isChecked()) {
                    stroketype.add("Hemorrhagic");
                } else {
                    stroketype.remove("Hemorrhagic");
                }
                break;


        }
        switch (v.getId()) //if then statements
        {
            case R.id.lesloc1:
                if (lesloc1.isChecked()) {
                    lesionlocation.add("Cortical");
                } else {
                    lesionlocation.remove("Cortical");
                }

                break;
            case R.id.lesloc2:
                if (lesloc2.isChecked()) {
                    lesionlocation.add("Subcortical");
                } else {
                    lesionlocation.remove("Subcortical");
                }

                break;

            case R.id.lesloc3:
                if (lesloc3.isChecked()) {
                    lesionlocation.add("Mixed");
                } else {
                    lesionlocation.remove("Mixed");
                }

                break;
            case R.id.lesloc4:
                if (lesloc4.isChecked()) {
                    lesionlocation.add("Other");
                } else {
                    lesionlocation.remove("Other");
                }

                break;


        }


        switch (v.getId()) //if then statements
        {
            case R.id.bodweak1:
                if (bodweak1.isChecked()) {
                    bodyweakness.add("Right");
                } else {
                    bodyweakness.remove("Right");
                }
                break;
            case R.id.bodweak2:
                if (bodweak2.isChecked()) {
                    bodyweakness.add("Left");
                } else {
                    bodyweakness.remove("Left");
                }
                break;


        }


        switch (v.getId()) //if then statements
        {
            case R.id.weaklimb1:
                if (weaklimb1.isChecked()) {
                    weaklimb.add("Arm/Hand");
                } else {
                    weaklimb.remove("Arm/Hand");
                }
                break;
            case R.id.weaklimb2:
                if (weaklimb2.isChecked()) {
                    weaklimb.add("Leg");
                } else {
                    weaklimb.remove("Leg");
                }
                break;


        }


        switch (v.getId()) //if then statements
        {
            case R.id.vetyes:
                vetno.setChecked(false);
                if (vetyes.isChecked()) {
                    veteran = "Yes";
                } else {
                    veteran = "No";
                }
                break;
            case R.id.vetno:
                vetyes.setChecked(false);
                if (vetno.isChecked()) {
                    veteran = "No";
                } else {
                    veteran = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.smokeryes:
                smokerno.setChecked(false);
                if (smokeryes.isChecked()) {
                    smoker = "Yes";
                } else {
                    smoker = "No";
                }
                break;
            case R.id.smokerno:
                smokeryes.setChecked(false);
                if (smokerno.isChecked()) {
                    smoker = "No";
                } else {
                    smoker = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.exsmokeryes:
                exsmokerno.setChecked(false);
                if (exsmokeryes.isChecked()) {
                    exsmoker = "Yes";
                } else {
                    exsmoker = "No";
                }
                break;
            case R.id.exsmokerno:
                exsmokeryes.setChecked(false);
                if (exsmokerno.isChecked()) {
                    exsmoker = "No";
                } else {
                    exsmoker = "Yes";
                }
                break;

        }




        switch (v.getId()) //if then statements
        {
            case R.id.alcoholyes:
                alcoholno.setChecked(false);
                if (alcoholyes.isChecked()) {
                    alcohol = "Yes";
                } else {
                    alcohol = "No";
                }
                break;
            case R.id.alcoholno:
                alcoholyes.setChecked(false);
                if (alcoholno.isChecked()) {
                    alcohol = "No";
                } else {
                    alcohol = "Yes";
                }
                break;

        }

        switch (v.getId()) //if then statements
        {
            case R.id.highcolyes:
                highcolno.setChecked(false);
                if (highcolyes.isChecked()) {
                    cholesterol = "Yes";
                } else {
                    cholesterol = "No";
                }
                break;
            case R.id.highcolno:
                highcolyes.setChecked(false);
                if (highcolno.isChecked()) {
                    cholesterol = "No";
                } else {
                    cholesterol = "Yes";
                }
                break;

        }

        switch (v.getId()) //if then statements
        {
            case R.id.diabetes1yes:
                diabetes1no.setChecked(false);
                if (diabetes1yes.isChecked()) {
                    diei = "Yes";
                } else {
                    diei = "No";
                }
                break;
            case R.id.diabetes1no:
                diabetes1yes.setChecked(false);
                if (diabetes1no.isChecked()) {
                    diei = "No";
                } else {
                    diei = "Yes";
                }
                break;

        }

        switch (v.getId()) //if then statements
        {
            case R.id.diabetes2yes:
                diabetes2no.setChecked(false);
                if (diabetes2yes.isChecked()) {
                    dieii = "Yes";
                } else {
                    dieii = "No";
                }
                break;
            case R.id.diabetes2no:
                diabetes2yes.setChecked(false);
                if (diabetes2no.isChecked()) {
                    dieii = "No";
                } else {
                    dieii = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.prevstrokeyes:
                prevstrokeno.setChecked(false);
                if (prevstrokeyes.isChecked()) {
                    prestroke = "Yes";
                } else {
                    prestroke = "No";
                }
                break;
            case R.id.prevstrokeno:
                prevstrokeyes.setChecked(false);
                if (prevstrokeno.isChecked()) {
                    prestroke = "No";
                } else {
                    prestroke = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.hbpyes:
                hbpno.setChecked(false);
                if (hbpyes.isChecked()) {
                    hypertension = "Yes";
                } else {
                    hypertension = "No";
                }
                break;
            case R.id.hbpno:
                hbpyes.setChecked(false);
                if (hbpno.isChecked()) {
                    hypertension = "No";
                } else {
                    hypertension = "Yes";
                }
                break;

        }

        switch (v.getId()) //if then statements
        {
            case R.id.famstrokeyes:
                famstrokeno.setChecked(false);
                if (famstrokeyes.isChecked()) {
                    famstroke = "Yes";
                } else {
                    famstroke = "No";
                }
                break;
            case R.id.famstrokeno:
                famstrokeyes.setChecked(false);
                if (famstrokeno.isChecked()) {
                    famstroke = "No";
                } else {
                    famstroke = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.atrialyes:
                atrialno.setChecked(false);
                if (atrialyes.isChecked()) {
                    atrialf = "Yes";
                } else {
                    atrialf = "No";
                }
                break;
            case R.id.atrialno:
                atrialyes.setChecked(false);
                if (atrialno.isChecked()) {
                    atrialf = "No";
                } else {
                    atrialf = "Yes";
                }
                break;

        }


        switch (v.getId()) //if then statements
        {
            case R.id.diagtest1:
                if (diagtest1.isChecked()) {
                    testing.add("CT scan");
                }else {
                    testing.remove("CT scan");
                }
                break;

            case R.id.diagtest2:
                if (diagtest2.isChecked()) {
                    testing.add("MRI");
                }else {
                    testing.remove("MRI");
                }
                break;

            case R.id.diagtest3:
                if (diagtest3.isChecked()) {
                    testing.add("Other");
                }else {
                    testing.remove("Other");
                }
                break;

        }



        switch (v.getId()) //if then statements
        {
            case R.id.interest1:

                if (interest1.isChecked()) {
                    interests.add("Upper Limb robotics");
                } else {
                    interests.remove("Upper Limb robotics");
                }
                break;
            case R.id.interest2:
                if (interest2.isChecked()) {
                    interests.add("Anklebot");
                } else {
                    interests.remove("Anklebot");
                }
                break;
            case R.id.interest3:
                if (interest3.isChecked()) {
                    interests.add("EKSO");
                } else {
                    interests.remove("EKSO");
                }
                break;
            case R.id.interest4:
                if (interest4.isChecked()) {
                    interests.add("Graduated Member Upper Limb");
                } else {
                    interests.remove("Graduated Member Upper Limb");
                }
                break;
            case R.id.interest5:
                if (interest5.isChecked()) {
                    interests.add("Graduated Member Lower Limb");
                } else {
                    interests.remove("Graduated Member Lower Limb");
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
