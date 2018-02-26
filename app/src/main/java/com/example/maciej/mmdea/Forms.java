package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Forms extends AppCompatActivity implements View.OnClickListener {

    String PatID;
    TextView patientID;
    Button demo, FuglMyer, Barthel, NIH, SF36, mp, wolf, ULMAS, ARRT, tdcs, sisv3, BAB, lextreme;
    List<NameValuePair> params;
    HttpPost post;
    HttpResponse resp;
    HttpClient client;
    int respCode;
    BufferedReader reader;
    StringBuffer result;
    String line;
    JSONArray DC, PP1, PP2, MP, FU, ADM;

    String  FMPP1, FMPP2, FMDC, FMFU, FMMP, FMADM,
            BarthelADM, BarthelFU, BarthelDC, BarthelMP,
            DEMOADM,
            SF36ADM,
            NIHFU, NIHADM, NIHDC, NIHMP,
            MPFU, MPADM, MPDC, MPMP,
            WolfFU, WolfADM, WolfDC, WolfMP,
            ULMASFU, ULMASADM, ULMASDC, ULMASMP,
            ARRTFU, ARRTADM, ARRTDC, ARRTMP,
            tdcsFU, tdcsADM, tdcsDC, tdcsMP,
            sisv3FU, sisv3ADM, sisv3DC, sisv3MP,
            BABPP1, BABPP2, BABDC, BABFU, BABMP, BABADM,
            LMPP1, LMPP2, LMDC, LMFU, LMMP, LMADM
    ;


    String[] Events, devai;

    CheckBox CFMPP1, CFMPP2, CFMDC, CFMFU, CFMMP, CFMADM,
             CBarthelFU, CBarthelADM, CBarthelDC, CBarthelMP,
             DemoADM,
             CSF36ADM,
             CNIHFU, CNIHADM, CNIHDC, CNIHMP,
             CMPFU, CMPADM, CMPDC, CMPMP,
             CWolfFU, CWolfADM, CWolfDC, CWolfMP,
             CULMASFU, CULMASADM, CULMASDC, CULMASMP,
             CARRTFU, CARRTADM, CARRTDC, CARRTMP,
             CtdcsFU, CtdcsADM, CtdcsDC, CtdcsMP,
             Csisv3FU, Csisv3ADM, Csisv3DC, Csisv3MP,
            CBABPP1, CBABPP2, CBABDC, CBABFU, CBABMP, CBABADM,
            CLMPP1, CLMPP2, CLMDC, CLMFU, CLMMP, CLMADM
            ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }


        Intent PID = this.getIntent();
        patientID = (TextView) findViewById(R.id.patientID);
        PatID = PID.getStringExtra("PatientID");
        patientID.setText("Patient ID: " + PatID);

        demo = (Button) findViewById(R.id.demo);
        demo.setOnClickListener(this);

        FuglMyer = (Button) findViewById(R.id.FuglMyer);
        FuglMyer.setOnClickListener(this);

        Barthel = (Button) findViewById(R.id.Barthel);
        Barthel.setOnClickListener(this);

        SF36 = (Button) findViewById(R.id.SF36);
        SF36.setOnClickListener(this);

        NIH = (Button) findViewById(R.id.NIH);
        NIH.setOnClickListener(this);

        mp = (Button) findViewById(R.id.mp);
        mp.setOnClickListener(this);

        wolf = (Button) findViewById(R.id.wolf);
        wolf.setOnClickListener(this);

        ULMAS = (Button) findViewById(R.id.ULMAS);
        ULMAS.setOnClickListener(this);

        ARRT = (Button) findViewById(R.id.ARRT);
        ARRT.setOnClickListener(this);

        tdcs = (Button) findViewById(R.id.tdcs);
        tdcs.setOnClickListener(this);

        sisv3 = (Button) findViewById(R.id.sisv3);
        sisv3.setOnClickListener(this);

        BAB = (Button) findViewById(R.id.BAB);
        BAB.setOnClickListener(this);

        lextreme = (Button) findViewById(R.id.lextreme);
        lextreme.setOnClickListener(this);



        //Demo
        DemoADM = (CheckBox) findViewById(R.id.DemoADM);

        //FuglMyer
        CFMPP1 = (CheckBox) findViewById(R.id.FMPP1);
        CFMPP2 = (CheckBox) findViewById(R.id.FMPP2);
        CFMDC = (CheckBox) findViewById(R.id.FMDC);
        CFMFU = (CheckBox) findViewById(R.id.FMFU);
        CFMMP = (CheckBox) findViewById(R.id.FMMP);
        CFMADM = (CheckBox) findViewById(R.id.FMADM);


        //Barthel
        CBarthelFU = (CheckBox) findViewById(R.id.BarthelFU);
        CBarthelADM = (CheckBox) findViewById(R.id.BarthelADM);
        CBarthelDC = (CheckBox) findViewById(R.id.BarthelDC);
        CBarthelMP = (CheckBox) findViewById(R.id.BarthelMP);


        //SF36
        CSF36ADM = (CheckBox) findViewById(R.id.SF36ADM);

        //NIH
        CNIHFU = (CheckBox) findViewById(R.id.NIHFU);
        CNIHADM = (CheckBox) findViewById(R.id.NIHADM);
        CNIHDC = (CheckBox) findViewById(R.id.NIHDC);
        CNIHMP = (CheckBox) findViewById(R.id.NIHMP);

        //MP
        CMPFU = (CheckBox) findViewById(R.id.MPFU);
        CMPADM = (CheckBox) findViewById(R.id.MPADM);
        CMPDC = (CheckBox) findViewById(R.id.MPDC);
        CMPMP = (CheckBox) findViewById(R.id.MPMP);


        //Wolf
        CWolfFU = (CheckBox) findViewById(R.id.WolfFU);
        CWolfADM = (CheckBox) findViewById(R.id.WolfADM);
        CWolfDC = (CheckBox) findViewById(R.id.WolfDC);
        CWolfMP = (CheckBox) findViewById(R.id.WolfMP);

        //ULMAS
        CULMASFU = (CheckBox) findViewById(R.id.ULMASFU);
        CULMASADM = (CheckBox) findViewById(R.id.ULMASADM);
        CULMASDC = (CheckBox) findViewById(R.id.ULMASDC);
        CULMASMP = (CheckBox) findViewById(R.id.ULMASMP);

        //ARAT
        CARRTFU = (CheckBox) findViewById(R.id.ARRTFU);
        CARRTADM = (CheckBox) findViewById(R.id.ARRTADM);
        CARRTDC = (CheckBox) findViewById(R.id.ARRTDC);
        CARRTMP = (CheckBox) findViewById(R.id.ARRTMP);

        //tdcs
        CtdcsFU = (CheckBox) findViewById(R.id.tdcsFU);
        CtdcsADM = (CheckBox) findViewById(R.id.tdcsADM);
        CtdcsDC = (CheckBox) findViewById(R.id.tdcsDC);
        CtdcsMP = (CheckBox) findViewById(R.id.tdcsMP);

        //sisv3
        Csisv3FU = (CheckBox) findViewById(R.id.sisv3FU);
        Csisv3ADM = (CheckBox) findViewById(R.id.sisv3ADM);
        Csisv3DC = (CheckBox) findViewById(R.id.sisv3DC);
        Csisv3MP = (CheckBox) findViewById(R.id.sisv3MP);


        //Box and Blocks
        CBABPP1 = (CheckBox) findViewById(R.id.BABPP1);
        CBABPP2 = (CheckBox) findViewById(R.id.BABPP2);
        CBABADM = (CheckBox) findViewById(R.id.BABADM);
        CBABDC = (CheckBox) findViewById(R.id.BABDC);
        CBABFU = (CheckBox) findViewById(R.id.BABFU);
        CBABMP = (CheckBox) findViewById(R.id.BABMP);

        //Lower Extremity
        CLMPP1 = (CheckBox) findViewById(R.id.LMPP1);
        CLMPP2 = (CheckBox) findViewById(R.id.LMPP2);
        CLMDC = (CheckBox) findViewById(R.id.LMDC);
        CLMFU = (CheckBox) findViewById(R.id.LMFU);
        CLMMP = (CheckBox) findViewById(R.id.LMMP);
        CLMADM = (CheckBox) findViewById(R.id.LMADM);

        //Demo
        DemoADM.setEnabled(false);

        //FuglMyer
        CFMPP1.setEnabled(false);
        CFMPP2.setEnabled(false);
        CFMDC.setEnabled(false);
        CFMFU.setEnabled(false);
        CFMMP.setEnabled(false);
        CFMADM.setEnabled(false);

        //Barthel
        CBarthelFU.setEnabled(false);
        CBarthelADM.setEnabled(false);
        CBarthelDC.setEnabled(false);
        CBarthelMP.setEnabled(false);

        //SF36
        CSF36ADM.setEnabled(false);

        //NIH
        CNIHFU.setEnabled(false);
        CNIHADM.setEnabled(false);
        CNIHDC.setEnabled(false);
        CNIHMP.setEnabled(false);

        //MP
        CMPFU.setEnabled(false);
        CMPADM.setEnabled(false);
        CMPDC.setEnabled(false);
        CMPMP.setEnabled(false);

        //Wolf
        CWolfFU.setEnabled(false);
        CWolfADM.setEnabled(false);
        CWolfDC.setEnabled(false);
        CWolfMP.setEnabled(false);

        //ULMAS
        CULMASFU.setEnabled(false);
        CULMASADM.setEnabled(false);
        CULMASDC.setEnabled(false);
        CULMASMP.setEnabled(false);

        //ARRT
        CARRTFU.setEnabled(false);
        CARRTADM.setEnabled(false);
        CARRTDC.setEnabled(false);
        CARRTMP.setEnabled(false);

        //tdcs
        CtdcsFU.setEnabled(false);
        CtdcsADM.setEnabled(false);
        CtdcsDC.setEnabled(false);
        CtdcsMP.setEnabled(false);

        //sisv3
        Csisv3FU.setEnabled(false);
        Csisv3ADM.setEnabled(false);
        Csisv3DC.setEnabled(false);
        Csisv3MP.setEnabled(false);

        //Box and Blocks
        CBABPP1.setEnabled(false);
        CBABPP2.setEnabled(false);
        CBABADM.setEnabled(false);
        CBABDC.setEnabled(false);
        CBABFU.setEnabled(false);
        CBABMP.setEnabled(false);

        //Lower Extremity
        CLMPP1.setEnabled(false);
        CLMPP2.setEnabled(false);
        CLMDC.setEnabled(false);
        CLMFU.setEnabled(false);
        CLMMP.setEnabled(false);
        CLMADM.setEnabled(false);

        DEMOADM = "";

        FMPP1 = "";
        FMPP2 = "";
        FMDC = "";
        FMFU = "";
        FMMP = "";
        FMADM = "";

        BarthelFU = "";
        BarthelADM = "";
        BarthelDC = "";
        BarthelMP = "";

        SF36ADM = "";

        NIHFU = "";
        NIHADM = "";
        NIHDC = "";
        NIHMP = "";

        MPFU = "";
        MPADM = "";
        MPDC = "";
        MPMP = "";

        WolfFU = "";
        WolfADM = "";
        WolfDC = "";
        WolfMP = "";

        ULMASFU = "";
        ULMASADM = "";
        ULMASDC = "";
        ULMASMP = "";

        ARRTFU = "";
        ARRTADM = "";
        ARRTDC = "";
        ARRTMP = "";

        tdcsFU = "";
        tdcsADM = "";
        tdcsDC = "";
        tdcsMP = "";

        sisv3FU = "";
        sisv3ADM = "";
        sisv3DC = "";
        sisv3MP = "";

        BABPP1 = "";
        BABPP2 = "";
        BABADM = "";
        BABDC = "";
        BABFU = "";
        BABMP = "";

        LMPP1 = "";
        LMPP2 = "";
        LMDC = "";
        LMFU = "";
        LMMP = "";
        LMADM = "";


        Events = new String[6];
        Events[0] = "dc_arm_1";
        Events[1] = "pp1_arm_1";
        Events[2] = "pp2_arm_1";
        Events[3] = "mp_arm_1";
        Events[4] = "fu_arm_1";
        Events[5] = "adm_arm_1";

        devai = new String[6];

        devai[0] = "";

            for (int i = 0; i < 6; i++) {

                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("token", getString(R.string.API_TOKEN)));
                params.add(new BasicNameValuePair("content", "record"));
                params.add(new BasicNameValuePair("format", "json"));
                params.add(new BasicNameValuePair("type", "flat"));
                params.add(new BasicNameValuePair("events", Events[i]));
                params.add(new BasicNameValuePair("records", PatID));
                params.add(new BasicNameValuePair("fields[0]", "fugl_meyer_complete"));
                params.add(new BasicNameValuePair("fields[1]", "barthel_complete"));
                params.add(new BasicNameValuePair("fields[2]", "patient_demographics_complete"));
                params.add(new BasicNameValuePair("fields[3]", "sf36_questionnaire_complete"));
                params.add(new BasicNameValuePair("fields[4]", "nih_stroke_scale_complete"));
                params.add(new BasicNameValuePair("fields[5]", "motor_power_complete"));
                params.add(new BasicNameValuePair("fields[6]", "wolf_motor_function_complete"));
                params.add(new BasicNameValuePair("fields[7]", "stroke_impact_scale_complete"));
                params.add(new BasicNameValuePair("fields[8]", "tdcs_complete"));
                params.add(new BasicNameValuePair("fields[9]", "upper_limb_modified_ashworth_score_complete"));
                params.add(new BasicNameValuePair("fields[10]", "action_research_arm_test_complete"));
                params.add(new BasicNameValuePair("fields[11]", "box_and_blocks_complete"));
                params.add(new BasicNameValuePair("fields[12]", "lower_extremity_complete"));
                params.add(new BasicNameValuePair("rawOrLabel", "raw"));
                params.add(new BasicNameValuePair("rawOrLabelHeaders", "raw"));
                params.add(new BasicNameValuePair("exportCheckboxLabel", "false"));
                params.add(new BasicNameValuePair("exportSurveyFields", "false"));
                params.add(new BasicNameValuePair("exportDataAccessGroups", "false"));
                params.add(new BasicNameValuePair("returnFormat", "json"));


                post = new HttpPost("https://redcap.ctsc.med.cornell.edu/redcap_protocols/api/");
                post.setHeader("Content-Type", "application/x-www-form-urlencoded");

                HttpParams httpParameters = new BasicHttpParams();
                int timeoutConnection = 1000;
                HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
                int timeoutSocket = 1500;
                HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

                client = new DefaultHttpClient(httpParameters);


                try {
                    post.setEntity(new UrlEncodedFormEntity(params));
                } catch (final Exception e) {
                    e.printStackTrace();
                }

                result = new StringBuffer();
                respCode = -1;
                reader = null;
                line = null;

                doPost();

                devai[i] = result.toString();

            }
       






        if (resp != null && !Objects.equals(devai[0], "[]")){
            Toast.makeText(this, "Successfully loaded checklist complete from REDCap", Toast.LENGTH_LONG).show();

            try {
                DC = new JSONArray(devai[0]);
                PP1 = new JSONArray(devai[1]);
                PP2 = new JSONArray(devai[2]);
                MP = new JSONArray(devai[3]);
                FU = new JSONArray(devai[4]);
                ADM = new JSONArray(devai[5]);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                DEMOADM = ADM.getJSONObject(0).getString("patient_demographics_complete");

                FMDC = DC.getJSONObject(0).getString("fugl_meyer_complete");
                FMPP1 = PP1.getJSONObject(0).getString("fugl_meyer_complete");
                FMPP2 = PP2.getJSONObject(0).getString("fugl_meyer_complete");
                FMMP = MP.getJSONObject(0).getString("fugl_meyer_complete");
                FMFU = FU.getJSONObject(0).getString("fugl_meyer_complete");
                FMADM = ADM.getJSONObject(0).getString("fugl_meyer_complete");

                BarthelDC = DC.getJSONObject(0).getString("barthel_complete");
                BarthelFU = FU.getJSONObject(0).getString("barthel_complete");
                BarthelADM = ADM.getJSONObject(0).getString("barthel_complete");
                BarthelMP = MP.getJSONObject(0).getString("barthel_complete");


                SF36ADM = ADM.getJSONObject(0).getString("sf36_questionnaire_complete");

                NIHDC = DC.getJSONObject(0).getString("nih_stroke_scale_complete");
                NIHFU = FU.getJSONObject(0).getString("nih_stroke_scale_complete");
                NIHADM = ADM.getJSONObject(0).getString("nih_stroke_scale_complete");
                NIHMP = MP.getJSONObject(0).getString("nih_stroke_scale_complete");


                MPDC = DC.getJSONObject(0).getString("motor_power_complete");
                MPFU = FU.getJSONObject(0).getString("motor_power_complete");
                MPADM = ADM.getJSONObject(0).getString("motor_power_complete");
                MPMP = MP.getJSONObject(0).getString("motor_power_complete");


                WolfDC = DC.getJSONObject(0).getString("wolf_motor_function_complete");
                WolfFU = FU.getJSONObject(0).getString("wolf_motor_function_complete");
                WolfADM = ADM.getJSONObject(0).getString("wolf_motor_function_complete");
                WolfMP = MP.getJSONObject(0).getString("wolf_motor_function_complete");

                sisv3DC = DC.getJSONObject(0).getString("stroke_impact_scale_complete");
                sisv3FU = FU.getJSONObject(0).getString("stroke_impact_scale_complete");
                sisv3ADM = ADM.getJSONObject(0).getString("stroke_impact_scale_complete");
                sisv3MP = MP.getJSONObject(0).getString("stroke_impact_scale_complete");

                tdcsDC = DC.getJSONObject(0).getString("tdcs_complete");
                tdcsFU = FU.getJSONObject(0).getString("tdcs_complete");
                tdcsADM = ADM.getJSONObject(0).getString("tdcs_complete");
                tdcsMP = MP.getJSONObject(0).getString("tdcs_complete");

                ULMASDC = DC.getJSONObject(0).getString("upper_limb_modified_ashworth_score_complete");
                ULMASFU = FU.getJSONObject(0).getString("upper_limb_modified_ashworth_score_complete");
                ULMASADM = ADM.getJSONObject(0).getString("upper_limb_modified_ashworth_score_complete");
                ULMASMP = MP.getJSONObject(0).getString("upper_limb_modified_ashworth_score_complete");


                ARRTDC = DC.getJSONObject(0).getString("action_research_arm_test_complete");
                ARRTFU = FU.getJSONObject(0).getString("action_research_arm_test_complete");
                ARRTADM = ADM.getJSONObject(0).getString("action_research_arm_test_complete");
                ARRTMP = MP.getJSONObject(0).getString("action_research_arm_test_complete");

                BABDC = DC.getJSONObject(0).getString("box_and_blocks_complete");
                BABPP1 = PP1.getJSONObject(0).getString("box_and_blocks_complete");
                BABPP2 = PP2.getJSONObject(0).getString("box_and_blocks_complete");
                BABMP = MP.getJSONObject(0).getString("box_and_blocks_complete");
                BABFU = FU.getJSONObject(0).getString("box_and_blocks_complete");
                BABADM = ADM.getJSONObject(0).getString("box_and_blocks_complete");

                LMDC = DC.getJSONObject(0).getString("lower_extremity_complete");
                LMPP1 = PP1.getJSONObject(0).getString("lower_extremity_complete");
                LMPP2 = PP2.getJSONObject(0).getString("lower_extremity_complete");
                LMMP = MP.getJSONObject(0).getString("lower_extremity_complete");
                LMFU = FU.getJSONObject(0).getString("lower_extremity_complete");
                LMADM = ADM.getJSONObject(0).getString("lower_extremity_complete");



            } catch (JSONException e) {
                e.printStackTrace();
            }
            

        }else if(Objects.equals(devai[0], "[]")){
            Toast.makeText(this, "New Patient ID Entered", Toast.LENGTH_LONG).show();
        }else if(resp == null){
            Toast.makeText(this, "Could not retrieve checklist complete from REDCap", Toast.LENGTH_LONG).show();
        }


        if (DEMOADM.equals("2")) {
            DemoADM.setChecked(true);
        }else {DemoADM.setChecked(false);
        }


        if (FMPP1.equals("2")) {
            CFMPP1.setChecked(true);
        }else {CFMPP1.setChecked(false);
        }
        if (FMPP2.equals("2")) {
            CFMPP2.setChecked(true);
        }else {CFMPP2.setChecked(false);
        }
        if (FMDC.equals("2")) {
            CFMDC.setChecked(true);
        }else {CFMDC.setChecked(false);
        }
        if (FMMP.equals("2")) {
            CFMMP.setChecked(true);
        }else {CFMMP.setChecked(false);
        }
        if (FMFU.equals("2")) {
            CFMFU.setChecked(true);
        }else {CFMFU.setChecked(false);
        }
        if (FMADM.equals("2")) {
            CFMADM.setChecked(true);
        }else {CFMADM.setChecked(false);
        }



        if (BarthelFU.equals("2")) {
            CBarthelFU.setChecked(true);
        }else {CBarthelFU.setChecked(false);
        }
        if (BarthelADM.equals("2")) {
            CBarthelADM.setChecked(true);
        }else {CBarthelADM.setChecked(false);
        }
        if (BarthelDC.equals("2")) {
            CBarthelDC.setChecked(true);
        }else {CBarthelDC.setChecked(false);
        }
        if (BarthelMP.equals("2")) {
            CBarthelMP.setChecked(true);
        }else {CBarthelMP.setChecked(false);
        }


        if (SF36ADM.equals("2")) {
            CSF36ADM.setChecked(true);
        }else {CSF36ADM.setChecked(false);
        }


        if (NIHFU.equals("2")) {
            CNIHFU.setChecked(true);
        }else {CNIHFU.setChecked(false);
        }
        if (NIHADM.equals("2")) {
            CNIHADM.setChecked(true);
        }else {CNIHADM.setChecked(false);
        }
        if (NIHDC.equals("2")) {
            CNIHDC.setChecked(true);
        }else {CNIHDC.setChecked(false);
        }        
        if (NIHMP.equals("2")) {
            CNIHMP.setChecked(true);
        }else {CNIHMP.setChecked(false);
        }


        if (MPFU.equals("2")) {
            CMPFU.setChecked(true);
        }else {CMPFU.setChecked(false);
        }
        if (MPADM.equals("2")) {
            CMPADM.setChecked(true);
        }else {CMPADM.setChecked(false);
        }
        if (MPDC.equals("2")) {
            CMPDC.setChecked(true);
        }else {CMPDC.setChecked(false);
        }
        if (MPMP.equals("2")) {
            CMPMP.setChecked(true);
        }else {CMPMP.setChecked(false);
        }
        
        

        if (WolfFU.equals("2")) {
            CWolfFU.setChecked(true);
        }else {CWolfFU.setChecked(false);
        }
        if (WolfADM.equals("2")) {
            CWolfADM.setChecked(true);
        }else {CWolfADM.setChecked(false);
        }
        if (WolfDC.equals("2")) {
            CWolfDC.setChecked(true);
        }else {CWolfDC.setChecked(false);
        }
        if (WolfMP.equals("2")) {
            CWolfMP.setChecked(true);
        }else {CWolfMP.setChecked(false);
        }



        if (sisv3FU.equals("2")) {
            Csisv3FU.setChecked(true);
        }else {Csisv3FU.setChecked(false);
        }
        if (sisv3ADM.equals("2")) {
            Csisv3ADM.setChecked(true);
        }else {Csisv3ADM.setChecked(false);
        }
        if (sisv3DC.equals("2")) {
            Csisv3DC.setChecked(true);
        }else {Csisv3DC.setChecked(false);
        }
        if (sisv3MP.equals("2")) {
            Csisv3MP.setChecked(true);
        }else {Csisv3MP.setChecked(false);
        }


        if (tdcsFU.equals("2")) {
            CtdcsFU.setChecked(true);
        }else {CtdcsFU.setChecked(false);
        }
        if (tdcsADM.equals("2")) {
            CtdcsADM.setChecked(true);
        }else {CtdcsADM.setChecked(false);
        }
        if (tdcsDC.equals("2")) {
            CtdcsDC.setChecked(true);
        }else {CtdcsDC.setChecked(false);
        }
        if (tdcsMP.equals("2")) {
            CtdcsMP.setChecked(true);
        }else {CtdcsMP.setChecked(false);
        }


        if (ULMASFU.equals("2")) {
            CULMASFU.setChecked(true);
        }else {CULMASFU.setChecked(false);
        }
        if (ULMASADM.equals("2")) {
            CULMASADM.setChecked(true);
        }else {CULMASADM.setChecked(false);
        }
        if (ULMASDC.equals("2")) {
            CULMASDC.setChecked(true);
        }else {CULMASDC.setChecked(false);
        }
        if (ULMASMP.equals("2")) {
            CULMASMP.setChecked(true);
        }else {CULMASMP.setChecked(false);
        }

        if (ARRTFU.equals("2")) {
            CARRTFU.setChecked(true);
        }else {CARRTFU.setChecked(false);
        }
        if (ARRTADM.equals("2")) {
            CARRTADM.setChecked(true);
        }else {CARRTADM.setChecked(false);
        }
        if (ARRTDC.equals("2")) {
            CARRTDC.setChecked(true);
        }else {CARRTDC.setChecked(false);
        }
        if (ARRTMP.equals("2")) {
            CARRTMP.setChecked(true);
        }else {CARRTMP.setChecked(false);
        }


        if (BABPP1.equals("2")) {
            CBABPP1.setChecked(true);
        }else {CBABPP1.setChecked(false);
        }
        if (BABPP2.equals("2")) {
            CBABPP2.setChecked(true);
        }else {CBABPP2.setChecked(false);
        }
        if (BABDC.equals("2")) {
            CBABDC.setChecked(true);
        }else {CBABDC.setChecked(false);
        }
        if (BABMP.equals("2")) {
            CBABMP.setChecked(true);
        }else {CBABMP.setChecked(false);
        }
        if (BABFU.equals("2")) {
            CBABFU.setChecked(true);
        }else {CBABFU.setChecked(false);
        }
        if (BABADM.equals("2")) {
            CBABADM.setChecked(true);
        }else {CBABADM.setChecked(false);
        }

        if (LMPP1.equals("2")) {
            CLMPP1.setChecked(true);
        }else {CLMPP1.setChecked(false);
        }
        if (LMPP2.equals("2")) {
            CLMPP2.setChecked(true);
        }else {CLMPP2.setChecked(false);
        }
        if (LMDC.equals("2")) {
            CLMDC.setChecked(true);
        }else {CLMDC.setChecked(false);
        }
        if (LMMP.equals("2")) {
            CLMMP.setChecked(true);
        }else {CLMMP.setChecked(false);
        }
        if (LMFU.equals("2")) {
            CLMFU.setChecked(true);
        }else {CLMFU.setChecked(false);
        }
        if (LMADM.equals("2")) {
            CLMADM.setChecked(true);
        }else {CLMADM.setChecked(false);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.demo:
                Intent PID = new Intent(Forms.this, demo.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.FuglMyer:
                Intent PID = new Intent(Forms.this, fuglmyer.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }
        switch (v.getId()){
            case R.id.Barthel:
                Intent PID = new Intent(Forms.this, barthel.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }
        switch (v.getId()){
            case R.id.SF36:
                Intent PID = new Intent(Forms.this, sf36.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }
        switch (v.getId()){
            case R.id.NIH:
                Intent PID = new Intent(Forms.this, NIH_Stroke_Scale.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.mp:
                Intent PID = new Intent(Forms.this, mp.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.wolf:
                Intent PID = new Intent(Forms.this, wolfmotor.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.ULMAS:
                Intent PID = new Intent(Forms.this, ULMAS.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.ARRT:
                Intent PID = new Intent(Forms.this, ARRT.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.tdcs:
                Intent PID = new Intent(Forms.this, tdcs.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.sisv3:
                Intent PID = new Intent(Forms.this, stroke_impact.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.BAB:
                Intent PID = new Intent(Forms.this, boxandblocks.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }

        switch (v.getId()){
            case R.id.lextreme:
                Intent PID = new Intent(Forms.this, Lextremity.class);
                PID.putExtra("PatientID", PatID);
                startActivity(PID);
                break;
        }
    }


    public void ReturnToPatID(View view){

        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Return To Patient ID Selection");
        alertclose.setMessage("Are you sure you want to change the patient ID?");
        alertclose.setCancelable(true);

        alertclose.setButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        startActivity(new Intent(Forms.this, PatientID.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                });

        alertclose.setButton2(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertclose.setIcon(R.mipmap.ic_launcher4);
        alertclose.show();

    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit App")
                .setMessage("Are you sure you want exit the application?")
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







    public void doPost() {
        resp = null;

        try {
            resp = client.execute(post);
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (resp != null) {
            respCode = resp.getStatusLine().getStatusCode();

            try {
                reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        if (reader != null) {
            try {
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

    }


}
