package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class stroke_impact extends AppCompatActivity implements  View.OnClickListener{

    String PatID, Date, Event, joined, Sisiii9;

    EditText Sisiii9a;

    Button bDone;

    TextView sisiiitotal, patientID, currentDateTimeString;

    Double Sisiii1a, Sisiii1b, Sisiii1c, Sisiii1d, Sisiii2a, Sisiii2b, Sisiii2c, Sisiii2d, Sisiii2e, Sisiii2f, Sisiii2g, Sisiii3a, Sisiii3b, Sisiii3c, Sisiii3d, Sisiii3e, Sisiii3f, Sisiii3g, Sisiii3h, Sisiii3i, Sisiii4a, Sisiii4b, Sisiii4c, Sisiii4d, Sisiii4e, Sisiii4f, Sisiii4g, Sisiii5a, Sisiii5b, Sisiii5c, Sisiii5d, Sisiii5e, Sisiii5f, Sisiii5g, Sisiii5h, Sisiii5i, Sisiii5j, Sisiii6a, Sisiii6b, Sisiii6c, Sisiii6d, Sisiii6e, Sisiii6f, Sisiii6g, Sisiii6h, Sisiii6i, Sisiii7a, Sisiii7b, Sisiii7c, Sisiii7d, Sisiii7e, Sisiii8a, Sisiii8b, Sisiii8c, Sisiii8d, Sisiii8e, Sisiii8f, Sisiii8g, Sisiii8h, SisiiiQTotal;

    RadioButton radioButtonADM, radioButtonDC, radioButtonFU, radioButtonMP,
            Sisiii1aa, Sisiii1ab, Sisiii1ac, Sisiii1ad, Sisiii1ae, Sisiii1ba, Sisiii1bb, Sisiii1bc, Sisiii1bd, Sisiii1be, Sisiii1ca, Sisiii1cb, Sisiii1cc, Sisiii1cd, Sisiii1ce, Sisiii1da, Sisiii1db, Sisiii1dc, Sisiii1dd, Sisiii1de, Sisiii2aa, Sisiii2ab, Sisiii2ac, Sisiii2ad, Sisiii2ae, Sisiii2ba, Sisiii2bb, Sisiii2bc, Sisiii2bd, Sisiii2be, Sisiii2ca, Sisiii2cb, Sisiii2cc, Sisiii2cd, Sisiii2ce, Sisiii2da, Sisiii2db, Sisiii2dc, Sisiii2dd, Sisiii2de, Sisiii2ea, Sisiii2eb, Sisiii2ec, Sisiii2ed, Sisiii2ee, Sisiii2fa, Sisiii2fb, Sisiii2fc, Sisiii2fd, Sisiii2fe, Sisiii2ga, Sisiii2gb, Sisiii2gc, Sisiii2gd, Sisiii2ge, Sisiii3aa, Sisiii3ab, Sisiii3ac, Sisiii3ad, Sisiii3ae, Sisiii3ba, Sisiii3bb, Sisiii3bc, Sisiii3bd, Sisiii3be, Sisiii3ca, Sisiii3cb, Sisiii3cc, Sisiii3cd, Sisiii3ce, Sisiii3da, Sisiii3db, Sisiii3dc, Sisiii3dd, Sisiii3de, Sisiii3ea, Sisiii3eb, Sisiii3ec, Sisiii3ed, Sisiii3ee, Sisiii3fa, Sisiii3fb, Sisiii3fc, Sisiii3fd, Sisiii3fe, Sisiii3ga, Sisiii3gb, Sisiii3gc, Sisiii3gd, Sisiii3ge, Sisiii3ha, Sisiii3hb, Sisiii3hc, Sisiii3hd, Sisiii3he, Sisiii3ia, Sisiii3ib, Sisiii3ic, Sisiii3id, Sisiii3ie, Sisiii4aa, Sisiii4ab, Sisiii4ac, Sisiii4ad, Sisiii4ae, Sisiii4ba, Sisiii4bb, Sisiii4bc, Sisiii4bd, Sisiii4be, Sisiii4ca, Sisiii4cb, Sisiii4cc, Sisiii4cd, Sisiii4ce, Sisiii4da, Sisiii4db, Sisiii4dc, Sisiii4dd, Sisiii4de, Sisiii4ea, Sisiii4eb, Sisiii4ec, Sisiii4ed, Sisiii4ee, Sisiii4fa, Sisiii4fb, Sisiii4fc, Sisiii4fd, Sisiii4fe, Sisiii4ga, Sisiii4gb, Sisiii4gc, Sisiii4gd, Sisiii4ge, Sisiii5aa, Sisiii5ab, Sisiii5ac, Sisiii5ad, Sisiii5ae, Sisiii5ba, Sisiii5bb, Sisiii5bc, Sisiii5bd, Sisiii5be, Sisiii5ca, Sisiii5cb, Sisiii5cc, Sisiii5cd, Sisiii5ce, Sisiii5da, Sisiii5db, Sisiii5dc, Sisiii5dd, Sisiii5de, Sisiii5ea, Sisiii5eb, Sisiii5ec, Sisiii5ed, Sisiii5ee, Sisiii5fa, Sisiii5fb, Sisiii5fc, Sisiii5fd, Sisiii5fe, Sisiii5ga, Sisiii5gb, Sisiii5gc, Sisiii5gd, Sisiii5ge, Sisiii5ha, Sisiii5hb, Sisiii5hc, Sisiii5hd, Sisiii5he, Sisiii5ia, Sisiii5ib, Sisiii5ic, Sisiii5id, Sisiii5ie, Sisiii5ja, Sisiii5jb, Sisiii5jc, Sisiii5jd, Sisiii5je, Sisiii6aa, Sisiii6ab, Sisiii6ac, Sisiii6ad, Sisiii6ae, Sisiii6ba, Sisiii6bb, Sisiii6bc, Sisiii6bd, Sisiii6be, Sisiii6ca, Sisiii6cb, Sisiii6cc, Sisiii6cd, Sisiii6ce, Sisiii6da, Sisiii6db, Sisiii6dc, Sisiii6dd, Sisiii6de, Sisiii6ea, Sisiii6eb, Sisiii6ec, Sisiii6ed, Sisiii6ee, Sisiii6fa, Sisiii6fb, Sisiii6fc, Sisiii6fd, Sisiii6fe, Sisiii6ga, Sisiii6gb, Sisiii6gc, Sisiii6gd, Sisiii6ge, Sisiii6ha, Sisiii6hb, Sisiii6hc, Sisiii6hd, Sisiii6he, Sisiii6ia, Sisiii6ib, Sisiii6ic, Sisiii6id, Sisiii6ie, Sisiii7aa, Sisiii7ab, Sisiii7ac, Sisiii7ad, Sisiii7ae, Sisiii7ba, Sisiii7bb, Sisiii7bc, Sisiii7bd, Sisiii7be, Sisiii7ca, Sisiii7cb, Sisiii7cc, Sisiii7cd, Sisiii7ce, Sisiii7da, Sisiii7db, Sisiii7dc, Sisiii7dd, Sisiii7de, Sisiii7ea, Sisiii7eb, Sisiii7ec, Sisiii7ed, Sisiii7ee, Sisiii8aa, Sisiii8ab, Sisiii8ac, Sisiii8ad, Sisiii8ae, Sisiii8ba, Sisiii8bb, Sisiii8bc, Sisiii8bd, Sisiii8be, Sisiii8ca, Sisiii8cb, Sisiii8cc, Sisiii8cd, Sisiii8ce, Sisiii8da, Sisiii8db, Sisiii8dc, Sisiii8dd, Sisiii8de, Sisiii8ea, Sisiii8eb, Sisiii8ec, Sisiii8ed, Sisiii8ee, Sisiii8fa, Sisiii8fb, Sisiii8fc, Sisiii8fd, Sisiii8fe, Sisiii8ga, Sisiii8gb, Sisiii8gc, Sisiii8gd, Sisiii8ge, Sisiii8ha, Sisiii8hb, Sisiii8hc, Sisiii8hd, Sisiii8he;

    ArrayList<String> inputcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_impact);

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

        sisiiitotal = (TextView) findViewById(R.id.sisiiitotal);


        Sisiii1a = Double.parseDouble("0");
        Sisiii1b = Double.parseDouble("0");
        Sisiii1c = Double.parseDouble("0");
        Sisiii1d = Double.parseDouble("0");
        Sisiii2a = Double.parseDouble("0");
        Sisiii2b = Double.parseDouble("0");
        Sisiii2c = Double.parseDouble("0");
        Sisiii2d = Double.parseDouble("0");
        Sisiii2e = Double.parseDouble("0");
        Sisiii2f = Double.parseDouble("0");
        Sisiii2g = Double.parseDouble("0");
        Sisiii3a = Double.parseDouble("0");
        Sisiii3b = Double.parseDouble("0");
        Sisiii3c = Double.parseDouble("0");
        Sisiii3d = Double.parseDouble("0");
        Sisiii3e = Double.parseDouble("0");
        Sisiii3f = Double.parseDouble("0");
        Sisiii3g = Double.parseDouble("0");
        Sisiii3h = Double.parseDouble("0");
        Sisiii3i = Double.parseDouble("0");
        Sisiii4a = Double.parseDouble("0");
        Sisiii4b = Double.parseDouble("0");
        Sisiii4c = Double.parseDouble("0");
        Sisiii4d = Double.parseDouble("0");
        Sisiii4e = Double.parseDouble("0");
        Sisiii4f = Double.parseDouble("0");
        Sisiii4g = Double.parseDouble("0");
        Sisiii5a = Double.parseDouble("0");
        Sisiii5b = Double.parseDouble("0");
        Sisiii5c = Double.parseDouble("0");
        Sisiii5d = Double.parseDouble("0");
        Sisiii5e = Double.parseDouble("0");
        Sisiii5f = Double.parseDouble("0");
        Sisiii5g = Double.parseDouble("0");
        Sisiii5h = Double.parseDouble("0");
        Sisiii5i = Double.parseDouble("0");
        Sisiii5j = Double.parseDouble("0");
        Sisiii6a = Double.parseDouble("0");
        Sisiii6b = Double.parseDouble("0");
        Sisiii6c = Double.parseDouble("0");
        Sisiii6d = Double.parseDouble("0");
        Sisiii6e = Double.parseDouble("0");
        Sisiii6f = Double.parseDouble("0");
        Sisiii6g = Double.parseDouble("0");
        Sisiii6h = Double.parseDouble("0");
        Sisiii6i = Double.parseDouble("0");
        Sisiii7a = Double.parseDouble("0");
        Sisiii7b = Double.parseDouble("0");
        Sisiii7c = Double.parseDouble("0");
        Sisiii7d = Double.parseDouble("0");
        Sisiii7e = Double.parseDouble("0");
        Sisiii8a = Double.parseDouble("0");
        Sisiii8b = Double.parseDouble("0");
        Sisiii8c = Double.parseDouble("0");
        Sisiii8d = Double.parseDouble("0");
        Sisiii8e = Double.parseDouble("0");
        Sisiii8f = Double.parseDouble("0");
        Sisiii8g = Double.parseDouble("0");
        Sisiii8h = Double.parseDouble("0");


        Sisiii1aa = (RadioButton) findViewById(R.id.Sisiii1aa);
        Sisiii1ab = (RadioButton) findViewById(R.id.Sisiii1ab);
        Sisiii1ac = (RadioButton) findViewById(R.id.Sisiii1ac);
        Sisiii1ad = (RadioButton) findViewById(R.id.Sisiii1ad);
        Sisiii1ae = (RadioButton) findViewById(R.id.Sisiii1ae);
        Sisiii1ba = (RadioButton) findViewById(R.id.Sisiii1ba);
        Sisiii1bb = (RadioButton) findViewById(R.id.Sisiii1bb);
        Sisiii1bc = (RadioButton) findViewById(R.id.Sisiii1bc);
        Sisiii1bd = (RadioButton) findViewById(R.id.Sisiii1bd);
        Sisiii1be = (RadioButton) findViewById(R.id.Sisiii1be);
        Sisiii1ca = (RadioButton) findViewById(R.id.Sisiii1ca);
        Sisiii1cb = (RadioButton) findViewById(R.id.Sisiii1cb);
        Sisiii1cc = (RadioButton) findViewById(R.id.Sisiii1cc);
        Sisiii1cd = (RadioButton) findViewById(R.id.Sisiii1cd);
        Sisiii1ce = (RadioButton) findViewById(R.id.Sisiii1ce);
        Sisiii1da = (RadioButton) findViewById(R.id.Sisiii1da);
        Sisiii1db = (RadioButton) findViewById(R.id.Sisiii1db);
        Sisiii1dc = (RadioButton) findViewById(R.id.Sisiii1dc);
        Sisiii1dd = (RadioButton) findViewById(R.id.Sisiii1dd);
        Sisiii1de = (RadioButton) findViewById(R.id.Sisiii1de);
        Sisiii2aa = (RadioButton) findViewById(R.id.Sisiii2aa);
        Sisiii2ab = (RadioButton) findViewById(R.id.Sisiii2ab);
        Sisiii2ac = (RadioButton) findViewById(R.id.Sisiii2ac);
        Sisiii2ad = (RadioButton) findViewById(R.id.Sisiii2ad);
        Sisiii2ae = (RadioButton) findViewById(R.id.Sisiii2ae);
        Sisiii2ba = (RadioButton) findViewById(R.id.Sisiii2ba);
        Sisiii2bb = (RadioButton) findViewById(R.id.Sisiii2bb);
        Sisiii2bc = (RadioButton) findViewById(R.id.Sisiii2bc);
        Sisiii2bd = (RadioButton) findViewById(R.id.Sisiii2bd);
        Sisiii2be = (RadioButton) findViewById(R.id.Sisiii2be);
        Sisiii2ca = (RadioButton) findViewById(R.id.Sisiii2ca);
        Sisiii2cb = (RadioButton) findViewById(R.id.Sisiii2cb);
        Sisiii2cc = (RadioButton) findViewById(R.id.Sisiii2cc);
        Sisiii2cd = (RadioButton) findViewById(R.id.Sisiii2cd);
        Sisiii2ce = (RadioButton) findViewById(R.id.Sisiii2ce);
        Sisiii2da = (RadioButton) findViewById(R.id.Sisiii2da);
        Sisiii2db = (RadioButton) findViewById(R.id.Sisiii2db);
        Sisiii2dc = (RadioButton) findViewById(R.id.Sisiii2dc);
        Sisiii2dd = (RadioButton) findViewById(R.id.Sisiii2dd);
        Sisiii2de = (RadioButton) findViewById(R.id.Sisiii2de);
        Sisiii2ea = (RadioButton) findViewById(R.id.Sisiii2ea);
        Sisiii2eb = (RadioButton) findViewById(R.id.Sisiii2eb);
        Sisiii2ec = (RadioButton) findViewById(R.id.Sisiii2ec);
        Sisiii2ed = (RadioButton) findViewById(R.id.Sisiii2ed);
        Sisiii2ee = (RadioButton) findViewById(R.id.Sisiii2ee);
        Sisiii2fa = (RadioButton) findViewById(R.id.Sisiii2fa);
        Sisiii2fb = (RadioButton) findViewById(R.id.Sisiii2fb);
        Sisiii2fc = (RadioButton) findViewById(R.id.Sisiii2fc);
        Sisiii2fd = (RadioButton) findViewById(R.id.Sisiii2fd);
        Sisiii2fe = (RadioButton) findViewById(R.id.Sisiii2fe);
        Sisiii2ga = (RadioButton) findViewById(R.id.Sisiii2ga);
        Sisiii2gb = (RadioButton) findViewById(R.id.Sisiii2gb);
        Sisiii2gc = (RadioButton) findViewById(R.id.Sisiii2gc);
        Sisiii2gd = (RadioButton) findViewById(R.id.Sisiii2gd);
        Sisiii2ge = (RadioButton) findViewById(R.id.Sisiii2ge);
        Sisiii3aa = (RadioButton) findViewById(R.id.Sisiii3aa);
        Sisiii3ab = (RadioButton) findViewById(R.id.Sisiii3ab);
        Sisiii3ac = (RadioButton) findViewById(R.id.Sisiii3ac);
        Sisiii3ad = (RadioButton) findViewById(R.id.Sisiii3ad);
        Sisiii3ae = (RadioButton) findViewById(R.id.Sisiii3ae);
        Sisiii3ba = (RadioButton) findViewById(R.id.Sisiii3ba);
        Sisiii3bb = (RadioButton) findViewById(R.id.Sisiii3bb);
        Sisiii3bc = (RadioButton) findViewById(R.id.Sisiii3bc);
        Sisiii3bd = (RadioButton) findViewById(R.id.Sisiii3bd);
        Sisiii3be = (RadioButton) findViewById(R.id.Sisiii3be);
        Sisiii3ca = (RadioButton) findViewById(R.id.Sisiii3ca);
        Sisiii3cb = (RadioButton) findViewById(R.id.Sisiii3cb);
        Sisiii3cc = (RadioButton) findViewById(R.id.Sisiii3cc);
        Sisiii3cd = (RadioButton) findViewById(R.id.Sisiii3cd);
        Sisiii3ce = (RadioButton) findViewById(R.id.Sisiii3ce);
        Sisiii3da = (RadioButton) findViewById(R.id.Sisiii3da);
        Sisiii3db = (RadioButton) findViewById(R.id.Sisiii3db);
        Sisiii3dc = (RadioButton) findViewById(R.id.Sisiii3dc);
        Sisiii3dd = (RadioButton) findViewById(R.id.Sisiii3dd);
        Sisiii3de = (RadioButton) findViewById(R.id.Sisiii3de);
        Sisiii3ea = (RadioButton) findViewById(R.id.Sisiii3ea);
        Sisiii3eb = (RadioButton) findViewById(R.id.Sisiii3eb);
        Sisiii3ec = (RadioButton) findViewById(R.id.Sisiii3ec);
        Sisiii3ed = (RadioButton) findViewById(R.id.Sisiii3ed);
        Sisiii3ee = (RadioButton) findViewById(R.id.Sisiii3ee);
        Sisiii3fa = (RadioButton) findViewById(R.id.Sisiii3fa);
        Sisiii3fb = (RadioButton) findViewById(R.id.Sisiii3fb);
        Sisiii3fc = (RadioButton) findViewById(R.id.Sisiii3fc);
        Sisiii3fd = (RadioButton) findViewById(R.id.Sisiii3fd);
        Sisiii3fe = (RadioButton) findViewById(R.id.Sisiii3fe);
        Sisiii3ga = (RadioButton) findViewById(R.id.Sisiii3ga);
        Sisiii3gb = (RadioButton) findViewById(R.id.Sisiii3gb);
        Sisiii3gc = (RadioButton) findViewById(R.id.Sisiii3gc);
        Sisiii3gd = (RadioButton) findViewById(R.id.Sisiii3gd);
        Sisiii3ge = (RadioButton) findViewById(R.id.Sisiii3ge);
        Sisiii3ha = (RadioButton) findViewById(R.id.Sisiii3ga);
        Sisiii3hb = (RadioButton) findViewById(R.id.Sisiii3gb);
        Sisiii3hc = (RadioButton) findViewById(R.id.Sisiii3gc);
        Sisiii3hd = (RadioButton) findViewById(R.id.Sisiii3gd);
        Sisiii3he = (RadioButton) findViewById(R.id.Sisiii3ge);
        Sisiii3ia = (RadioButton) findViewById(R.id.Sisiii3ia);
        Sisiii3ib = (RadioButton) findViewById(R.id.Sisiii3ib);
        Sisiii3ic = (RadioButton) findViewById(R.id.Sisiii3ic);
        Sisiii3id = (RadioButton) findViewById(R.id.Sisiii3id);
        Sisiii3ie = (RadioButton) findViewById(R.id.Sisiii3ie);
        Sisiii4aa = (RadioButton) findViewById(R.id.Sisiii4aa);
        Sisiii4ab = (RadioButton) findViewById(R.id.Sisiii4ab);
        Sisiii4ac = (RadioButton) findViewById(R.id.Sisiii4ac);
        Sisiii4ad = (RadioButton) findViewById(R.id.Sisiii4ad);
        Sisiii4ae = (RadioButton) findViewById(R.id.Sisiii4ae);
        Sisiii4ba = (RadioButton) findViewById(R.id.Sisiii4ba);
        Sisiii4bb = (RadioButton) findViewById(R.id.Sisiii4bb);
        Sisiii4bc = (RadioButton) findViewById(R.id.Sisiii4bc);
        Sisiii4bd = (RadioButton) findViewById(R.id.Sisiii4bd);
        Sisiii4be = (RadioButton) findViewById(R.id.Sisiii4be);
        Sisiii4ca = (RadioButton) findViewById(R.id.Sisiii4ca);
        Sisiii4cb = (RadioButton) findViewById(R.id.Sisiii4cb);
        Sisiii4cc = (RadioButton) findViewById(R.id.Sisiii4cc);
        Sisiii4cd = (RadioButton) findViewById(R.id.Sisiii4cd);
        Sisiii4ce = (RadioButton) findViewById(R.id.Sisiii4ce);
        Sisiii4da = (RadioButton) findViewById(R.id.Sisiii4da);
        Sisiii4db = (RadioButton) findViewById(R.id.Sisiii4db);
        Sisiii4dc = (RadioButton) findViewById(R.id.Sisiii4dc);
        Sisiii4dd = (RadioButton) findViewById(R.id.Sisiii4dd);
        Sisiii4de = (RadioButton) findViewById(R.id.Sisiii4de);
        Sisiii4ea = (RadioButton) findViewById(R.id.Sisiii4ea);
        Sisiii4eb = (RadioButton) findViewById(R.id.Sisiii4eb);
        Sisiii4ec = (RadioButton) findViewById(R.id.Sisiii4ec);
        Sisiii4ed = (RadioButton) findViewById(R.id.Sisiii4ed);
        Sisiii4ee = (RadioButton) findViewById(R.id.Sisiii4ee);
        Sisiii4fa = (RadioButton) findViewById(R.id.Sisiii4fa);
        Sisiii4fb = (RadioButton) findViewById(R.id.Sisiii4fb);
        Sisiii4fc = (RadioButton) findViewById(R.id.Sisiii4fc);
        Sisiii4fd = (RadioButton) findViewById(R.id.Sisiii4fd);
        Sisiii4fe = (RadioButton) findViewById(R.id.Sisiii4fe);
        Sisiii4ga = (RadioButton) findViewById(R.id.Sisiii4ga);
        Sisiii4gb = (RadioButton) findViewById(R.id.Sisiii4gb);
        Sisiii4gc = (RadioButton) findViewById(R.id.Sisiii4gc);
        Sisiii4gd = (RadioButton) findViewById(R.id.Sisiii4gd);
        Sisiii4ge = (RadioButton) findViewById(R.id.Sisiii4ge);
        Sisiii5aa = (RadioButton) findViewById(R.id.Sisiii5aa);
        Sisiii5ab = (RadioButton) findViewById(R.id.Sisiii5ab);
        Sisiii5ac = (RadioButton) findViewById(R.id.Sisiii5ac);
        Sisiii5ad = (RadioButton) findViewById(R.id.Sisiii5ad);
        Sisiii5ae = (RadioButton) findViewById(R.id.Sisiii5ae);
        Sisiii5ba = (RadioButton) findViewById(R.id.Sisiii5ba);
        Sisiii5bb = (RadioButton) findViewById(R.id.Sisiii5bb);
        Sisiii5bc = (RadioButton) findViewById(R.id.Sisiii5bc);
        Sisiii5bd = (RadioButton) findViewById(R.id.Sisiii5bd);
        Sisiii5be = (RadioButton) findViewById(R.id.Sisiii5be);
        Sisiii5ca = (RadioButton) findViewById(R.id.Sisiii5ca);
        Sisiii5cb = (RadioButton) findViewById(R.id.Sisiii5cb);
        Sisiii5cc = (RadioButton) findViewById(R.id.Sisiii5cc);
        Sisiii5cd = (RadioButton) findViewById(R.id.Sisiii5cd);
        Sisiii5ce = (RadioButton) findViewById(R.id.Sisiii5ce);
        Sisiii5da = (RadioButton) findViewById(R.id.Sisiii5da);
        Sisiii5db = (RadioButton) findViewById(R.id.Sisiii5db);
        Sisiii5dc = (RadioButton) findViewById(R.id.Sisiii5dc);
        Sisiii5dd = (RadioButton) findViewById(R.id.Sisiii5dd);
        Sisiii5de = (RadioButton) findViewById(R.id.Sisiii5de);
        Sisiii5ea = (RadioButton) findViewById(R.id.Sisiii5ea);
        Sisiii5eb = (RadioButton) findViewById(R.id.Sisiii5eb);
        Sisiii5ec = (RadioButton) findViewById(R.id.Sisiii5ec);
        Sisiii5ed = (RadioButton) findViewById(R.id.Sisiii5ed);
        Sisiii5ee = (RadioButton) findViewById(R.id.Sisiii5ee);
        Sisiii5fa = (RadioButton) findViewById(R.id.Sisiii5fa);
        Sisiii5fb = (RadioButton) findViewById(R.id.Sisiii5fb);
        Sisiii5fc = (RadioButton) findViewById(R.id.Sisiii5fc);
        Sisiii5fd = (RadioButton) findViewById(R.id.Sisiii5fd);
        Sisiii5fe = (RadioButton) findViewById(R.id.Sisiii5fe);
        Sisiii5ga = (RadioButton) findViewById(R.id.Sisiii5ga);
        Sisiii5gb = (RadioButton) findViewById(R.id.Sisiii5gb);
        Sisiii5gc = (RadioButton) findViewById(R.id.Sisiii5gc);
        Sisiii5gd = (RadioButton) findViewById(R.id.Sisiii5gd);
        Sisiii5ge = (RadioButton) findViewById(R.id.Sisiii5ge);
        Sisiii5ha = (RadioButton) findViewById(R.id.Sisiii5ha);
        Sisiii5hb = (RadioButton) findViewById(R.id.Sisiii5hb);
        Sisiii5hc = (RadioButton) findViewById(R.id.Sisiii5hc);
        Sisiii5hd = (RadioButton) findViewById(R.id.Sisiii5hd);
        Sisiii5he = (RadioButton) findViewById(R.id.Sisiii5he);
        Sisiii5ia = (RadioButton) findViewById(R.id.Sisiii5ia);
        Sisiii5ib = (RadioButton) findViewById(R.id.Sisiii5ib);
        Sisiii5ic = (RadioButton) findViewById(R.id.Sisiii5ic);
        Sisiii5id = (RadioButton) findViewById(R.id.Sisiii5id);
        Sisiii5ie = (RadioButton) findViewById(R.id.Sisiii5ie);
        Sisiii5ja = (RadioButton) findViewById(R.id.Sisiii5ja);
        Sisiii5jb = (RadioButton) findViewById(R.id.Sisiii5jb);
        Sisiii5jc = (RadioButton) findViewById(R.id.Sisiii5jc);
        Sisiii5jd = (RadioButton) findViewById(R.id.Sisiii5jd);
        Sisiii5je = (RadioButton) findViewById(R.id.Sisiii5je);
        Sisiii6aa = (RadioButton) findViewById(R.id.Sisiii6aa);
        Sisiii6ab = (RadioButton) findViewById(R.id.Sisiii6ab);
        Sisiii6ac = (RadioButton) findViewById(R.id.Sisiii6ac);
        Sisiii6ad = (RadioButton) findViewById(R.id.Sisiii6ad);
        Sisiii6ae = (RadioButton) findViewById(R.id.Sisiii6ae);
        Sisiii6ba = (RadioButton) findViewById(R.id.Sisiii6ba);
        Sisiii6bb = (RadioButton) findViewById(R.id.Sisiii6bb);
        Sisiii6bc = (RadioButton) findViewById(R.id.Sisiii6bc);
        Sisiii6bd = (RadioButton) findViewById(R.id.Sisiii6bd);
        Sisiii6be = (RadioButton) findViewById(R.id.Sisiii6be);
        Sisiii6ca = (RadioButton) findViewById(R.id.Sisiii6ca);
        Sisiii6cb = (RadioButton) findViewById(R.id.Sisiii6cb);
        Sisiii6cc = (RadioButton) findViewById(R.id.Sisiii6cc);
        Sisiii6cd = (RadioButton) findViewById(R.id.Sisiii6cd);
        Sisiii6ce = (RadioButton) findViewById(R.id.Sisiii6ce);
        Sisiii6da = (RadioButton) findViewById(R.id.Sisiii6da);
        Sisiii6db = (RadioButton) findViewById(R.id.Sisiii6db);
        Sisiii6dc = (RadioButton) findViewById(R.id.Sisiii6dc);
        Sisiii6dd = (RadioButton) findViewById(R.id.Sisiii6dd);
        Sisiii6de = (RadioButton) findViewById(R.id.Sisiii6de);
        Sisiii6ea = (RadioButton) findViewById(R.id.Sisiii6ea);
        Sisiii6eb = (RadioButton) findViewById(R.id.Sisiii6eb);
        Sisiii6ec = (RadioButton) findViewById(R.id.Sisiii6ec);
        Sisiii6ed = (RadioButton) findViewById(R.id.Sisiii6ed);
        Sisiii6ee = (RadioButton) findViewById(R.id.Sisiii6ee);
        Sisiii6fa = (RadioButton) findViewById(R.id.Sisiii6fa);
        Sisiii6fb = (RadioButton) findViewById(R.id.Sisiii6fb);
        Sisiii6fc = (RadioButton) findViewById(R.id.Sisiii6fc);
        Sisiii6fd = (RadioButton) findViewById(R.id.Sisiii6fd);
        Sisiii6fe = (RadioButton) findViewById(R.id.Sisiii6fe);
        Sisiii6ga = (RadioButton) findViewById(R.id.Sisiii6fa);
        Sisiii6gb = (RadioButton) findViewById(R.id.Sisiii6fb);
        Sisiii6gc = (RadioButton) findViewById(R.id.Sisiii6fc);
        Sisiii6gd = (RadioButton) findViewById(R.id.Sisiii6fd);
        Sisiii6ge = (RadioButton) findViewById(R.id.Sisiii6fe);
        Sisiii6ha = (RadioButton) findViewById(R.id.Sisiii6ha);
        Sisiii6hb = (RadioButton) findViewById(R.id.Sisiii6hb);
        Sisiii6hc = (RadioButton) findViewById(R.id.Sisiii6hc);
        Sisiii6hd = (RadioButton) findViewById(R.id.Sisiii6hd);
        Sisiii6he = (RadioButton) findViewById(R.id.Sisiii6he);
        Sisiii6ia = (RadioButton) findViewById(R.id.Sisiii6ga);
        Sisiii6ib = (RadioButton) findViewById(R.id.Sisiii6gb);
        Sisiii6ic = (RadioButton) findViewById(R.id.Sisiii6gc);
        Sisiii6id = (RadioButton) findViewById(R.id.Sisiii6gd);
        Sisiii6ie = (RadioButton) findViewById(R.id.Sisiii6ge);
        Sisiii7aa = (RadioButton) findViewById(R.id.Sisiii7aa);
        Sisiii7ab = (RadioButton) findViewById(R.id.Sisiii7ab);
        Sisiii7ac = (RadioButton) findViewById(R.id.Sisiii7ac);
        Sisiii7ad = (RadioButton) findViewById(R.id.Sisiii7ad);
        Sisiii7ae = (RadioButton) findViewById(R.id.Sisiii7ae);
        Sisiii7ba = (RadioButton) findViewById(R.id.Sisiii7ba);
        Sisiii7bb = (RadioButton) findViewById(R.id.Sisiii7bb);
        Sisiii7bc = (RadioButton) findViewById(R.id.Sisiii7bc);
        Sisiii7bd = (RadioButton) findViewById(R.id.Sisiii7bd);
        Sisiii7be = (RadioButton) findViewById(R.id.Sisiii7be);
        Sisiii7ca = (RadioButton) findViewById(R.id.Sisiii7ca);
        Sisiii7cb = (RadioButton) findViewById(R.id.Sisiii7cb);
        Sisiii7cc = (RadioButton) findViewById(R.id.Sisiii7cc);
        Sisiii7cd = (RadioButton) findViewById(R.id.Sisiii7cd);
        Sisiii7ce = (RadioButton) findViewById(R.id.Sisiii7ce);
        Sisiii7da = (RadioButton) findViewById(R.id.Sisiii7da);
        Sisiii7db = (RadioButton) findViewById(R.id.Sisiii7db);
        Sisiii7dc = (RadioButton) findViewById(R.id.Sisiii7dc);
        Sisiii7dd = (RadioButton) findViewById(R.id.Sisiii7dd);
        Sisiii7de = (RadioButton) findViewById(R.id.Sisiii7de);
        Sisiii7ea = (RadioButton) findViewById(R.id.Sisiii7ea);
        Sisiii7eb = (RadioButton) findViewById(R.id.Sisiii7eb);
        Sisiii7ec = (RadioButton) findViewById(R.id.Sisiii7ec);
        Sisiii7ed = (RadioButton) findViewById(R.id.Sisiii7ed);
        Sisiii7ee = (RadioButton) findViewById(R.id.Sisiii7ee);
        Sisiii8aa = (RadioButton) findViewById(R.id.Sisiii8aa);
        Sisiii8ab = (RadioButton) findViewById(R.id.Sisiii8ab);
        Sisiii8ac = (RadioButton) findViewById(R.id.Sisiii8ac);
        Sisiii8ad = (RadioButton) findViewById(R.id.Sisiii8ad);
        Sisiii8ae = (RadioButton) findViewById(R.id.Sisiii8ae);
        Sisiii8ba = (RadioButton) findViewById(R.id.Sisiii8ba);
        Sisiii8bb = (RadioButton) findViewById(R.id.Sisiii8bb);
        Sisiii8bc = (RadioButton) findViewById(R.id.Sisiii8bc);
        Sisiii8bd = (RadioButton) findViewById(R.id.Sisiii8bd);
        Sisiii8be = (RadioButton) findViewById(R.id.Sisiii8be);
        Sisiii8ca = (RadioButton) findViewById(R.id.Sisiii8ca);
        Sisiii8cb = (RadioButton) findViewById(R.id.Sisiii8cb);
        Sisiii8cc = (RadioButton) findViewById(R.id.Sisiii8cc);
        Sisiii8cd = (RadioButton) findViewById(R.id.Sisiii8cd);
        Sisiii8ce = (RadioButton) findViewById(R.id.Sisiii8ce);
        Sisiii8da = (RadioButton) findViewById(R.id.Sisiii8da);
        Sisiii8db = (RadioButton) findViewById(R.id.Sisiii8db);
        Sisiii8dc = (RadioButton) findViewById(R.id.Sisiii8dc);
        Sisiii8dd = (RadioButton) findViewById(R.id.Sisiii8dd);
        Sisiii8de = (RadioButton) findViewById(R.id.Sisiii8de);
        Sisiii8ea = (RadioButton) findViewById(R.id.Sisiii8ea);
        Sisiii8eb = (RadioButton) findViewById(R.id.Sisiii8eb);
        Sisiii8ec = (RadioButton) findViewById(R.id.Sisiii8ec);
        Sisiii8ed = (RadioButton) findViewById(R.id.Sisiii8ed);
        Sisiii8ee = (RadioButton) findViewById(R.id.Sisiii8ee);
        Sisiii8fa = (RadioButton) findViewById(R.id.Sisiii8fa);
        Sisiii8fb = (RadioButton) findViewById(R.id.Sisiii8fb);
        Sisiii8fc = (RadioButton) findViewById(R.id.Sisiii8fc);
        Sisiii8fd = (RadioButton) findViewById(R.id.Sisiii8fd);
        Sisiii8fe = (RadioButton) findViewById(R.id.Sisiii8fe);
        Sisiii8ga = (RadioButton) findViewById(R.id.Sisiii8ga);
        Sisiii8gb = (RadioButton) findViewById(R.id.Sisiii8gb);
        Sisiii8gc = (RadioButton) findViewById(R.id.Sisiii8gc);
        Sisiii8gd = (RadioButton) findViewById(R.id.Sisiii8gd);
        Sisiii8ge = (RadioButton) findViewById(R.id.Sisiii8ge);
        Sisiii8ha = (RadioButton) findViewById(R.id.Sisiii8ha);
        Sisiii8hb = (RadioButton) findViewById(R.id.Sisiii8hb);
        Sisiii8hc = (RadioButton) findViewById(R.id.Sisiii8hc);
        Sisiii8hd = (RadioButton) findViewById(R.id.Sisiii8hd);
        Sisiii8he = (RadioButton) findViewById(R.id.Sisiii8he);
        Sisiii9a = (EditText)findViewById(R.id.Sisiii9);


        radioButtonADM = (RadioButton) findViewById(R.id.radioButtonADM);
        radioButtonFU = (RadioButton) findViewById(R.id.radioButtonFU);
        radioButtonDC = (RadioButton) findViewById(R.id.radioButtonDC);
        radioButtonADM.setOnClickListener(this);
        radioButtonFU.setOnClickListener(this);
        radioButtonDC.setOnClickListener(this);
        radioButtonMP = (RadioButton) findViewById(R.id.radioButtonMP);
        radioButtonMP.setOnClickListener(this);


    }



    public void Sisiii(View view){


        switch (view.getId()){

            case R.id.Sisiii1aa:
                Sisiii1a = Double.parseDouble("5");
                break;
            case R.id.Sisiii1ab:
                Sisiii1a = Double.parseDouble("4");
                break;
            case R.id.Sisiii1ac:
                Sisiii1a = Double.parseDouble("3");
                break;
            case R.id.Sisiii1ad:
                Sisiii1a = Double.parseDouble("2");
                break;
            case R.id.Sisiii1ae:
                Sisiii1a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii1ba:
                Sisiii1b = Double.parseDouble("5");
                break;
            case R.id.Sisiii1bb:
                Sisiii1b = Double.parseDouble("4");
                break;
            case R.id.Sisiii1bc:
                Sisiii1b = Double.parseDouble("3");
                break;
            case R.id.Sisiii1bd:
                Sisiii1b = Double.parseDouble("2");
                break;
            case R.id.Sisiii1be:
                Sisiii1b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii1ca:
                Sisiii1c = Double.parseDouble("5");
                break;
            case R.id.Sisiii1cb:
                Sisiii1c = Double.parseDouble("4");
                break;
            case R.id.Sisiii1cc:
                Sisiii1c = Double.parseDouble("3");
                break;
            case R.id.Sisiii1cd:
                Sisiii1c = Double.parseDouble("2");
                break;
            case R.id.Sisiii1ce:
                Sisiii1c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii1da:
                Sisiii1d = Double.parseDouble("5");
                break;
            case R.id.Sisiii1db:
                Sisiii1d = Double.parseDouble("4");
                break;
            case R.id.Sisiii1dc:
                Sisiii1d = Double.parseDouble("3");
                break;
            case R.id.Sisiii1dd:
                Sisiii1d = Double.parseDouble("2");
                break;
            case R.id.Sisiii1de:
                Sisiii1d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2aa:
                Sisiii2a = Double.parseDouble("5");
                break;
            case R.id.Sisiii2ab:
                Sisiii2a = Double.parseDouble("4");
                break;
            case R.id.Sisiii2ac:
                Sisiii2a = Double.parseDouble("3");
                break;
            case R.id.Sisiii2ad:
                Sisiii2a = Double.parseDouble("2");
                break;
            case R.id.Sisiii2ae:
                Sisiii2a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2ba:
                Sisiii2b = Double.parseDouble("5");
                break;
            case R.id.Sisiii2bb:
                Sisiii2b = Double.parseDouble("4");
                break;
            case R.id.Sisiii2bc:
                Sisiii2b = Double.parseDouble("3");
                break;
            case R.id.Sisiii2bd:
                Sisiii2b = Double.parseDouble("2");
                break;
            case R.id.Sisiii2be:
                Sisiii2b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2ca:
                Sisiii2c = Double.parseDouble("5");
                break;
            case R.id.Sisiii2cb:
                Sisiii2c = Double.parseDouble("4");
                break;
            case R.id.Sisiii2cc:
                Sisiii2c = Double.parseDouble("3");
                break;
            case R.id.Sisiii2cd:
                Sisiii2c = Double.parseDouble("2");
                break;
            case R.id.Sisiii2ce:
                Sisiii2c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2da:
                Sisiii2d = Double.parseDouble("5");
                break;
            case R.id.Sisiii2db:
                Sisiii2d = Double.parseDouble("4");
                break;
            case R.id.Sisiii2dc:
                Sisiii2d = Double.parseDouble("3");
                break;
            case R.id.Sisiii2dd:
                Sisiii2d = Double.parseDouble("2");
                break;
            case R.id.Sisiii2de:
                Sisiii2d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2ea:
                Sisiii2e = Double.parseDouble("5");
                break;
            case R.id.Sisiii2eb:
                Sisiii2e = Double.parseDouble("4");
                break;
            case R.id.Sisiii2ec:
                Sisiii2e = Double.parseDouble("3");
                break;
            case R.id.Sisiii2ed:
                Sisiii2e = Double.parseDouble("2");
                break;
            case R.id.Sisiii2ee:
                Sisiii2e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2fa:
                Sisiii2f = Double.parseDouble("5");
                break;
            case R.id.Sisiii2fb:
                Sisiii2f = Double.parseDouble("4");
                break;
            case R.id.Sisiii2fc:
                Sisiii2f = Double.parseDouble("3");
                break;
            case R.id.Sisiii2fd:
                Sisiii2f = Double.parseDouble("2");
                break;
            case R.id.Sisiii2fe:
                Sisiii2f = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii2ga:
                Sisiii2g = Double.parseDouble("5");
                break;
            case R.id.Sisiii2gb:
                Sisiii2g = Double.parseDouble("4");
                break;
            case R.id.Sisiii2gc:
                Sisiii2g = Double.parseDouble("3");
                break;
            case R.id.Sisiii2gd:
                Sisiii2g = Double.parseDouble("2");
                break;
            case R.id.Sisiii2ge:
                Sisiii2g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3aa:
                Sisiii3a = Double.parseDouble("5");
                break;
            case R.id.Sisiii3ab:
                Sisiii3a = Double.parseDouble("4");
                break;
            case R.id.Sisiii3ac:
                Sisiii3a = Double.parseDouble("3");
                break;
            case R.id.Sisiii3ad:
                Sisiii3a = Double.parseDouble("2");
                break;
            case R.id.Sisiii3ae:
                Sisiii3a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ba:
                Sisiii3b = Double.parseDouble("5");
                break;
            case R.id.Sisiii3bb:
                Sisiii3b = Double.parseDouble("4");
                break;
            case R.id.Sisiii3bc:
                Sisiii3b = Double.parseDouble("3");
                break;
            case R.id.Sisiii3bd:
                Sisiii3b = Double.parseDouble("2");
                break;
            case R.id.Sisiii3be:
                Sisiii3b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ca:
                Sisiii3c = Double.parseDouble("5");
                break;
            case R.id.Sisiii3cb:
                Sisiii3c = Double.parseDouble("4");
                break;
            case R.id.Sisiii3cc:
                Sisiii3c = Double.parseDouble("3");
                break;
            case R.id.Sisiii3cd:
                Sisiii3c = Double.parseDouble("2");
                break;
            case R.id.Sisiii3ce:
                Sisiii3c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3da:
                Sisiii3d = Double.parseDouble("5");
                break;
            case R.id.Sisiii3db:
                Sisiii3d = Double.parseDouble("4");
                break;
            case R.id.Sisiii3dc:
                Sisiii3d = Double.parseDouble("3");
                break;
            case R.id.Sisiii3dd:
                Sisiii3d = Double.parseDouble("2");
                break;
            case R.id.Sisiii3de:
                Sisiii3d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ea:
                Sisiii3e = Double.parseDouble("5");
                break;
            case R.id.Sisiii3eb:
                Sisiii3e = Double.parseDouble("4");
                break;
            case R.id.Sisiii3ec:
                Sisiii3e = Double.parseDouble("3");
                break;
            case R.id.Sisiii3ed:
                Sisiii3e = Double.parseDouble("2");
                break;
            case R.id.Sisiii3ee:
                Sisiii3e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3fa:
                Sisiii3f = Double.parseDouble("1");
                break;
            case R.id.Sisiii3fb:
                Sisiii3f = Double.parseDouble("2");
                break;
            case R.id.Sisiii3fc:
                Sisiii3f = Double.parseDouble("3");
                break;
            case R.id.Sisiii3fd:
                Sisiii3f = Double.parseDouble("4");
                break;
            case R.id.Sisiii3fe:
                Sisiii3f = Double.parseDouble("5");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ga:
                Sisiii3g = Double.parseDouble("5");
                break;
            case R.id.Sisiii3gb:
                Sisiii3g = Double.parseDouble("4");
                break;
            case R.id.Sisiii3gc:
                Sisiii3g = Double.parseDouble("3");
                break;
            case R.id.Sisiii3gd:
                Sisiii3g = Double.parseDouble("2");
                break;
            case R.id.Sisiii3ge:
                Sisiii3g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ha:
                Sisiii3h = Double.parseDouble("1");
                break;
            case R.id.Sisiii3hb:
                Sisiii3h = Double.parseDouble("2");
                break;
            case R.id.Sisiii3hc:
                Sisiii3h = Double.parseDouble("3");
                break;
            case R.id.Sisiii3hd:
                Sisiii3h = Double.parseDouble("4");
                break;
            case R.id.Sisiii3he:
                Sisiii3h = Double.parseDouble("5");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii3ia:
                Sisiii3i = Double.parseDouble("1");
                break;
            case R.id.Sisiii3ib:
                Sisiii3i = Double.parseDouble("2");
                break;
            case R.id.Sisiii3ic:
                Sisiii3i = Double.parseDouble("3");
                break;
            case R.id.Sisiii3id:
                Sisiii3i = Double.parseDouble("4");
                break;
            case R.id.Sisiii3ie:
                Sisiii3i = Double.parseDouble("5");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4aa:
                Sisiii4a = Double.parseDouble("5");
                break;
            case R.id.Sisiii4ab:
                Sisiii4a = Double.parseDouble("4");
                break;
            case R.id.Sisiii4ac:
                Sisiii4a = Double.parseDouble("3");
                break;
            case R.id.Sisiii4ad:
                Sisiii4a = Double.parseDouble("2");
                break;
            case R.id.Sisiii4ae:
                Sisiii4a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4ba:
                Sisiii4b = Double.parseDouble("5");
                break;
            case R.id.Sisiii4bb:
                Sisiii4b = Double.parseDouble("4");
                break;
            case R.id.Sisiii4bc:
                Sisiii4b = Double.parseDouble("3");
                break;
            case R.id.Sisiii4bd:
                Sisiii4b = Double.parseDouble("2");
                break;
            case R.id.Sisiii4be:
                Sisiii4b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4ca:
                Sisiii4c = Double.parseDouble("5");
                break;
            case R.id.Sisiii4cb:
                Sisiii4c = Double.parseDouble("4");
                break;
            case R.id.Sisiii4cc:
                Sisiii4c = Double.parseDouble("3");
                break;
            case R.id.Sisiii4cd:
                Sisiii4c = Double.parseDouble("2");
                break;
            case R.id.Sisiii4ce:
                Sisiii4c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4da:
                Sisiii4d = Double.parseDouble("5");
                break;
            case R.id.Sisiii4db:
                Sisiii4d = Double.parseDouble("4");
                break;
            case R.id.Sisiii4dc:
                Sisiii4d = Double.parseDouble("3");
                break;
            case R.id.Sisiii4dd:
                Sisiii4d = Double.parseDouble("2");
                break;
            case R.id.Sisiii4de:
                Sisiii4d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4ea:
                Sisiii4e = Double.parseDouble("5");
                break;
            case R.id.Sisiii4eb:
                Sisiii4e = Double.parseDouble("4");
                break;
            case R.id.Sisiii4ec:
                Sisiii4e = Double.parseDouble("3");
                break;
            case R.id.Sisiii4ed:
                Sisiii4e = Double.parseDouble("2");
                break;
            case R.id.Sisiii4ee:
                Sisiii4e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4fa:
                Sisiii4f = Double.parseDouble("5");
                break;
            case R.id.Sisiii4fb:
                Sisiii4f = Double.parseDouble("4");
                break;
            case R.id.Sisiii4fc:
                Sisiii4f = Double.parseDouble("3");
                break;
            case R.id.Sisiii4fd:
                Sisiii4f = Double.parseDouble("2");
                break;
            case R.id.Sisiii4fe:
                Sisiii4f = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii4ga:
                Sisiii4g = Double.parseDouble("5");
                break;
            case R.id.Sisiii4gb:
                Sisiii4g = Double.parseDouble("4");
                break;
            case R.id.Sisiii4gc:
                Sisiii4g = Double.parseDouble("3");
                break;
            case R.id.Sisiii4gd:
                Sisiii4g = Double.parseDouble("2");
                break;
            case R.id.Sisiii4ge:
                Sisiii4g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5aa:
                Sisiii5a = Double.parseDouble("5");
                break;
            case R.id.Sisiii5ab:
                Sisiii5a = Double.parseDouble("4");
                break;
            case R.id.Sisiii5ac:
                Sisiii5a = Double.parseDouble("3");
                break;
            case R.id.Sisiii5ad:
                Sisiii5a = Double.parseDouble("2");
                break;
            case R.id.Sisiii5ae:
                Sisiii5a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ba:
                Sisiii5b = Double.parseDouble("5");
                break;
            case R.id.Sisiii5bb:
                Sisiii5b = Double.parseDouble("4");
                break;
            case R.id.Sisiii5bc:
                Sisiii5b = Double.parseDouble("3");
                break;
            case R.id.Sisiii5bd:
                Sisiii5b = Double.parseDouble("2");
                break;
            case R.id.Sisiii5be:
                Sisiii5b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ca:
                Sisiii5c = Double.parseDouble("5");
                break;
            case R.id.Sisiii5cb:
                Sisiii5c = Double.parseDouble("4");
                break;
            case R.id.Sisiii5cc:
                Sisiii5c = Double.parseDouble("3");
                break;
            case R.id.Sisiii5cd:
                Sisiii5c = Double.parseDouble("2");
                break;
            case R.id.Sisiii5ce:
                Sisiii5c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5da:
                Sisiii5d = Double.parseDouble("5");
                break;
            case R.id.Sisiii5db:
                Sisiii5d = Double.parseDouble("4");
                break;
            case R.id.Sisiii5dc:
                Sisiii5d = Double.parseDouble("3");
                break;
            case R.id.Sisiii5dd:
                Sisiii5d = Double.parseDouble("2");
                break;
            case R.id.Sisiii5de:
                Sisiii5d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ea:
                Sisiii5e = Double.parseDouble("5");
                break;
            case R.id.Sisiii5eb:
                Sisiii5e = Double.parseDouble("4");
                break;
            case R.id.Sisiii5ec:
                Sisiii5e = Double.parseDouble("3");
                break;
            case R.id.Sisiii5ed:
                Sisiii5e = Double.parseDouble("2");
                break;
            case R.id.Sisiii5ee:
                Sisiii5e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5fa:
                Sisiii5f = Double.parseDouble("5");
                break;
            case R.id.Sisiii5fb:
                Sisiii5f = Double.parseDouble("4");
                break;
            case R.id.Sisiii5fc:
                Sisiii5f = Double.parseDouble("3");
                break;
            case R.id.Sisiii5fd:
                Sisiii5f = Double.parseDouble("2");
                break;
            case R.id.Sisiii5fe:
                Sisiii5f = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ga:
                Sisiii5g = Double.parseDouble("5");
                break;
            case R.id.Sisiii5gb:
                Sisiii5g = Double.parseDouble("4");
                break;
            case R.id.Sisiii5gc:
                Sisiii5g = Double.parseDouble("3");
                break;
            case R.id.Sisiii5gd:
                Sisiii5g = Double.parseDouble("2");
                break;
            case R.id.Sisiii5ge:
                Sisiii5g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ha:
                Sisiii5h = Double.parseDouble("5");
                break;
            case R.id.Sisiii5hb:
                Sisiii5h = Double.parseDouble("4");
                break;
            case R.id.Sisiii5hc:
                Sisiii5h = Double.parseDouble("3");
                break;
            case R.id.Sisiii5hd:
                Sisiii5h = Double.parseDouble("2");
                break;
            case R.id.Sisiii5he:
                Sisiii5h = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ia:
                Sisiii5i = Double.parseDouble("5");
                break;
            case R.id.Sisiii5ib:
                Sisiii5i = Double.parseDouble("4");
                break;
            case R.id.Sisiii5ic:
                Sisiii5i = Double.parseDouble("3");
                break;
            case R.id.Sisiii5id:
                Sisiii5i = Double.parseDouble("2");
                break;
            case R.id.Sisiii5ie:
                Sisiii5i = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii5ja:
                Sisiii5j = Double.parseDouble("5");
                break;
            case R.id.Sisiii5jb:
                Sisiii5j = Double.parseDouble("4");
                break;
            case R.id.Sisiii5jc:
                Sisiii5j = Double.parseDouble("3");
                break;
            case R.id.Sisiii5jd:
                Sisiii5j = Double.parseDouble("2");
                break;
            case R.id.Sisiii5je:
                Sisiii5j = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6aa:
                Sisiii6a = Double.parseDouble("5");
                break;
            case R.id.Sisiii6ab:
                Sisiii6a = Double.parseDouble("4");
                break;
            case R.id.Sisiii6ac:
                Sisiii6a = Double.parseDouble("3");
                break;
            case R.id.Sisiii6ad:
                Sisiii6a = Double.parseDouble("2");
                break;
            case R.id.Sisiii6ae:
                Sisiii6a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ba:
                Sisiii6b = Double.parseDouble("5");
                break;
            case R.id.Sisiii6bb:
                Sisiii6b = Double.parseDouble("4");
                break;
            case R.id.Sisiii6bc:
                Sisiii6b = Double.parseDouble("3");
                break;
            case R.id.Sisiii6bd:
                Sisiii6b = Double.parseDouble("2");
                break;
            case R.id.Sisiii6be:
                Sisiii6b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ca:
                Sisiii6c = Double.parseDouble("5");
                break;
            case R.id.Sisiii6cb:
                Sisiii6c = Double.parseDouble("4");
                break;
            case R.id.Sisiii6cc:
                Sisiii6c = Double.parseDouble("3");
                break;
            case R.id.Sisiii6cd:
                Sisiii6c = Double.parseDouble("2");
                break;
            case R.id.Sisiii6ce:
                Sisiii6c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6da:
                Sisiii6d = Double.parseDouble("5");
                break;
            case R.id.Sisiii6db:
                Sisiii6d = Double.parseDouble("4");
                break;
            case R.id.Sisiii6dc:
                Sisiii6d = Double.parseDouble("3");
                break;
            case R.id.Sisiii6dd:
                Sisiii6d = Double.parseDouble("2");
                break;
            case R.id.Sisiii6de:
                Sisiii6d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ea:
                Sisiii6e = Double.parseDouble("5");
                break;
            case R.id.Sisiii6eb:
                Sisiii6e = Double.parseDouble("4");
                break;
            case R.id.Sisiii6ec:
                Sisiii6e = Double.parseDouble("3");
                break;
            case R.id.Sisiii6ed:
                Sisiii6e = Double.parseDouble("2");
                break;
            case R.id.Sisiii6ee:
                Sisiii6e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6fa:
                Sisiii6f = Double.parseDouble("5");
                break;
            case R.id.Sisiii6fb:
                Sisiii6f = Double.parseDouble("4");
                break;
            case R.id.Sisiii6fc:
                Sisiii6f = Double.parseDouble("3");
                break;
            case R.id.Sisiii6fd:
                Sisiii6f = Double.parseDouble("2");
                break;
            case R.id.Sisiii6fe:
                Sisiii6f = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ga:
                Sisiii6g = Double.parseDouble("5");
                break;
            case R.id.Sisiii6gb:
                Sisiii6g = Double.parseDouble("4");
                break;
            case R.id.Sisiii6gc:
                Sisiii6g = Double.parseDouble("3");
                break;
            case R.id.Sisiii6gd:
                Sisiii6g = Double.parseDouble("2");
                break;
            case R.id.Sisiii6ge:
                Sisiii6g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ha:
                Sisiii6h = Double.parseDouble("5");
                break;
            case R.id.Sisiii6hb:
                Sisiii6h = Double.parseDouble("4");
                break;
            case R.id.Sisiii6hc:
                Sisiii6h = Double.parseDouble("3");
                break;
            case R.id.Sisiii6hd:
                Sisiii6h = Double.parseDouble("2");
                break;
            case R.id.Sisiii6he:
                Sisiii6h = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii6ia:
                Sisiii6i = Double.parseDouble("5");
                break;
            case R.id.Sisiii6ib:
                Sisiii6i = Double.parseDouble("4");
                break;
            case R.id.Sisiii6ic:
                Sisiii6i = Double.parseDouble("3");
                break;
            case R.id.Sisiii6id:
                Sisiii6i = Double.parseDouble("2");
                break;
            case R.id.Sisiii6ie:
                Sisiii6i = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii7aa:
                Sisiii7a = Double.parseDouble("5");
                break;
            case R.id.Sisiii7ab:
                Sisiii7a = Double.parseDouble("4");
                break;
            case R.id.Sisiii7ac:
                Sisiii7a = Double.parseDouble("3");
                break;
            case R.id.Sisiii7ad:
                Sisiii7a = Double.parseDouble("2");
                break;
            case R.id.Sisiii7ae:
                Sisiii7a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii7ba:
                Sisiii7b = Double.parseDouble("5");
                break;
            case R.id.Sisiii7bb:
                Sisiii7b = Double.parseDouble("4");
                break;
            case R.id.Sisiii7bc:
                Sisiii7b = Double.parseDouble("3");
                break;
            case R.id.Sisiii7bd:
                Sisiii7b = Double.parseDouble("2");
                break;
            case R.id.Sisiii7be:
                Sisiii7b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii7ca:
                Sisiii7c = Double.parseDouble("5");
                break;
            case R.id.Sisiii7cb:
                Sisiii7c = Double.parseDouble("4");
                break;
            case R.id.Sisiii7cc:
                Sisiii7c = Double.parseDouble("3");
                break;
            case R.id.Sisiii7cd:
                Sisiii7c = Double.parseDouble("2");
                break;
            case R.id.Sisiii7ce:
                Sisiii7c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii7da:
                Sisiii7d = Double.parseDouble("5");
                break;
            case R.id.Sisiii7db:
                Sisiii7d = Double.parseDouble("4");
                break;
            case R.id.Sisiii7dc:
                Sisiii7d = Double.parseDouble("3");
                break;
            case R.id.Sisiii7dd:
                Sisiii7d = Double.parseDouble("2");
                break;
            case R.id.Sisiii7de:
                Sisiii7d = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii7ea:
                Sisiii7e = Double.parseDouble("5");
                break;
            case R.id.Sisiii7eb:
                Sisiii7e = Double.parseDouble("4");
                break;
            case R.id.Sisiii7ec:
                Sisiii7e = Double.parseDouble("3");
                break;
            case R.id.Sisiii7ed:
                Sisiii7e = Double.parseDouble("2");
                break;
            case R.id.Sisiii7ee:
                Sisiii7e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8aa:
                Sisiii8a = Double.parseDouble("5");
                break;
            case R.id.Sisiii8ab:
                Sisiii8a = Double.parseDouble("4");
                break;
            case R.id.Sisiii8ac:
                Sisiii8a = Double.parseDouble("3");
                break;
            case R.id.Sisiii8ad:
                Sisiii8a = Double.parseDouble("2");
                break;
            case R.id.Sisiii8ae:
                Sisiii8a = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8ba:
                Sisiii8b = Double.parseDouble("5");
                break;
            case R.id.Sisiii8bb:
                Sisiii8b = Double.parseDouble("4");
                break;
            case R.id.Sisiii8bc:
                Sisiii8b = Double.parseDouble("3");
                break;
            case R.id.Sisiii8bd:
                Sisiii8b = Double.parseDouble("2");
                break;
            case R.id.Sisiii8be:
                Sisiii8b = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8ca:
                Sisiii8c = Double.parseDouble("5");
                break;
            case R.id.Sisiii8cb:
                Sisiii8c = Double.parseDouble("4");
                break;
            case R.id.Sisiii8cc:
                Sisiii8c = Double.parseDouble("3");
                break;
            case R.id.Sisiii8cd:
                Sisiii8c = Double.parseDouble("2");
                break;
            case R.id.Sisiii8ce:
                Sisiii8c = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8da:
                Sisiii8d = Double.parseDouble("5");
                break;
            case R.id.Sisiii8db:
                Sisiii8d = Double.parseDouble("4");
                break;
            case R.id.Sisiii8dc:
                Sisiii8d = Double.parseDouble("3");
                break;
            case R.id.Sisiii8dd:
                Sisiii8d = Double.parseDouble("2");
                break;
            case R.id.Sisiii8de:
                Sisiii8d = Double.parseDouble("1");
                break;
        }
        switch (view.getId()){

            case R.id.Sisiii8ea:
                Sisiii8e = Double.parseDouble("5");
                break;
            case R.id.Sisiii8eb:
                Sisiii8e = Double.parseDouble("4");
                break;
            case R.id.Sisiii8ec:
                Sisiii8e = Double.parseDouble("3");
                break;
            case R.id.Sisiii8ed:
                Sisiii8e = Double.parseDouble("2");
                break;
            case R.id.Sisiii8ee:
                Sisiii8e = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8fa:
                Sisiii8f = Double.parseDouble("5");
                break;
            case R.id.Sisiii8fb:
                Sisiii8f = Double.parseDouble("4");
                break;
            case R.id.Sisiii8fc:
                Sisiii8f = Double.parseDouble("3");
                break;
            case R.id.Sisiii8fd:
                Sisiii8f = Double.parseDouble("2");
                break;
            case R.id.Sisiii8fe:
                Sisiii8f = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8ga:
                Sisiii8g = Double.parseDouble("5");
                break;
            case R.id.Sisiii8gb:
                Sisiii8g = Double.parseDouble("4");
                break;
            case R.id.Sisiii8gc:
                Sisiii8g = Double.parseDouble("3");
                break;
            case R.id.Sisiii8gd:
                Sisiii8g = Double.parseDouble("2");
                break;
            case R.id.Sisiii8ge:
                Sisiii8g = Double.parseDouble("1");
                break;
        }

        switch (view.getId()){

            case R.id.Sisiii8ha:
                Sisiii8h = Double.parseDouble("5");
                break;
            case R.id.Sisiii8hb:
                Sisiii8h = Double.parseDouble("4");
                break;
            case R.id.Sisiii8hc:
                Sisiii8h = Double.parseDouble("3");
                break;
            case R.id.Sisiii8hd:
                Sisiii8h = Double.parseDouble("2");
                break;
            case R.id.Sisiii8he:
                Sisiii8h = Double.parseDouble("1");
                break;
        }



        SisiiiQTotal = Sisiii1a + Sisiii1b + Sisiii1c + Sisiii1d + Sisiii2a + Sisiii2b + Sisiii2c + Sisiii2d + Sisiii2e + Sisiii2f + Sisiii2g + Sisiii3a + Sisiii3b + Sisiii3c + Sisiii3d + Sisiii3e + Sisiii3f + Sisiii3g + Sisiii3h + Sisiii3i + Sisiii4a + Sisiii4b + Sisiii4c + Sisiii4d + Sisiii4e + Sisiii4f + Sisiii4g + Sisiii5a + Sisiii5b + Sisiii5c + Sisiii5d + Sisiii5e + Sisiii5f + Sisiii5g + Sisiii5h + Sisiii5i + Sisiii5j + Sisiii6a + Sisiii6b + Sisiii6c + Sisiii6d + Sisiii6e + Sisiii6f + Sisiii6g + Sisiii6h + Sisiii6i + Sisiii7a + Sisiii7b + Sisiii7c + Sisiii7d + Sisiii7e + Sisiii8a + Sisiii8b + Sisiii8c + Sisiii8d + Sisiii8e + Sisiii8f + Sisiii8g + Sisiii8h;
        sisiiitotal.setText(String.valueOf(SisiiiQTotal) + "/295.0");

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

                if (!Sisiii1aa.isChecked() && !Sisiii1ab.isChecked() && !Sisiii1ac.isChecked() && !Sisiii1ad.isChecked() && !Sisiii1ae.isChecked()){
                    inputcheck.add("1a");
                }

                if (!Sisiii1ba.isChecked() && !Sisiii1bb.isChecked() && !Sisiii1bc.isChecked() && !Sisiii1bd.isChecked() && !Sisiii1be.isChecked()){
                    inputcheck.add("1b");
                }

                if (!Sisiii1ca.isChecked() && !Sisiii1cb.isChecked() && !Sisiii1cc.isChecked() && !Sisiii1cd.isChecked() && !Sisiii1ce.isChecked()){
                    inputcheck.add("1c");
                }

                if (!Sisiii1da.isChecked() && !Sisiii1db.isChecked() && !Sisiii1dc.isChecked() && !Sisiii1dd.isChecked() && !Sisiii1de.isChecked()){
                    inputcheck.add("1d");
                }

                if (!Sisiii2aa.isChecked() && !Sisiii2ab.isChecked() && !Sisiii2ac.isChecked() && !Sisiii2ad.isChecked() && !Sisiii2ae.isChecked()){
                    inputcheck.add("2a");
                }

                if (!Sisiii2ba.isChecked() && !Sisiii2bb.isChecked() && !Sisiii2bc.isChecked() && !Sisiii2bd.isChecked() && !Sisiii2be.isChecked()){
                    inputcheck.add("2b");
                }

                if (!Sisiii2ca.isChecked() && !Sisiii2cb.isChecked() && !Sisiii2cc.isChecked() && !Sisiii2cd.isChecked() && !Sisiii2ce.isChecked()){
                    inputcheck.add("2c");
                }

                if (!Sisiii2da.isChecked() && !Sisiii2db.isChecked() && !Sisiii2dc.isChecked() && !Sisiii2dd.isChecked() && !Sisiii2de.isChecked()){
                    inputcheck.add("2d");
                }

                if (!Sisiii2ea.isChecked() && !Sisiii2eb.isChecked() && !Sisiii2ec.isChecked() && !Sisiii2ed.isChecked() && !Sisiii2ee.isChecked()){
                    inputcheck.add("2e");
                }

                if (!Sisiii2fa.isChecked() && !Sisiii2fb.isChecked() && !Sisiii2fc.isChecked() && !Sisiii2fd.isChecked() && !Sisiii2fe.isChecked()){
                    inputcheck.add("2f");
                }

                if (!Sisiii2ga.isChecked() && !Sisiii2gb.isChecked() && !Sisiii2gc.isChecked() && !Sisiii2gd.isChecked() && !Sisiii2ge.isChecked()){
                    inputcheck.add("2g");
                }

                if (!Sisiii3aa.isChecked() && !Sisiii3ab.isChecked() && !Sisiii3ac.isChecked() && !Sisiii3ad.isChecked() && !Sisiii3ae.isChecked()){
                    inputcheck.add("3a");
                }

                if (!Sisiii3ba.isChecked() && !Sisiii3bb.isChecked() && !Sisiii3bc.isChecked() && !Sisiii3bd.isChecked() && !Sisiii3be.isChecked()){
                    inputcheck.add("3b");
                }

                if (!Sisiii3ca.isChecked() && !Sisiii3cb.isChecked() && !Sisiii3cc.isChecked() && !Sisiii3cd.isChecked() && !Sisiii3ce.isChecked()){
                    inputcheck.add("3c");
                }

                if (!Sisiii3da.isChecked() && !Sisiii3db.isChecked() && !Sisiii3dc.isChecked() && !Sisiii3dd.isChecked() && !Sisiii3de.isChecked()){
                    inputcheck.add("3d");
                }

                if (!Sisiii3ea.isChecked() && !Sisiii3eb.isChecked() && !Sisiii3ec.isChecked() && !Sisiii3ed.isChecked() && !Sisiii3ee.isChecked()){
                    inputcheck.add("3e");
                }

                if (!Sisiii3fa.isChecked() && !Sisiii3fb.isChecked() && !Sisiii3fc.isChecked() && !Sisiii3fd.isChecked() && !Sisiii3fe.isChecked()){
                    inputcheck.add("3f");
                }

                if (!Sisiii3ga.isChecked() && !Sisiii3gb.isChecked() && !Sisiii3gc.isChecked() && !Sisiii3gd.isChecked() && !Sisiii3ge.isChecked()){
                    inputcheck.add("3g");
                }

                if (!Sisiii3ha.isChecked() && !Sisiii3hb.isChecked() && !Sisiii3hc.isChecked() && !Sisiii3hd.isChecked() && !Sisiii3he.isChecked()){
                    inputcheck.add("3h");
                }

                if (!Sisiii3ia.isChecked() && !Sisiii3ib.isChecked() && !Sisiii3ic.isChecked() && !Sisiii3id.isChecked() && !Sisiii3ie.isChecked()){
                    inputcheck.add("3i");
                }

                if (!Sisiii4aa.isChecked() && !Sisiii4ab.isChecked() && !Sisiii4ac.isChecked() && !Sisiii4ad.isChecked() && !Sisiii4ae.isChecked()){
                    inputcheck.add("4a");
                }

                if (!Sisiii4ba.isChecked() && !Sisiii4bb.isChecked() && !Sisiii4bc.isChecked() && !Sisiii4bd.isChecked() && !Sisiii4be.isChecked()){
                    inputcheck.add("4b");
                }

                if (!Sisiii4ca.isChecked() && !Sisiii4cb.isChecked() && !Sisiii4cc.isChecked() && !Sisiii4cd.isChecked() && !Sisiii4ce.isChecked()){
                    inputcheck.add("4c");
                }

                if (!Sisiii4da.isChecked() && !Sisiii4db.isChecked() && !Sisiii4dc.isChecked() && !Sisiii4dd.isChecked() && !Sisiii4de.isChecked()){
                    inputcheck.add("4d");
                }

                if (!Sisiii4ea.isChecked() && !Sisiii4eb.isChecked() && !Sisiii4ec.isChecked() && !Sisiii4ed.isChecked() && !Sisiii4ee.isChecked()){
                    inputcheck.add("4e");
                }

                if (!Sisiii4fa.isChecked() && !Sisiii4fb.isChecked() && !Sisiii4fc.isChecked() && !Sisiii4fd.isChecked() && !Sisiii4fe.isChecked()){
                    inputcheck.add("4f");
                }

                if (!Sisiii4ga.isChecked() && !Sisiii4gb.isChecked() && !Sisiii4gc.isChecked() && !Sisiii4gd.isChecked() && !Sisiii4ge.isChecked()){
                    inputcheck.add("4g");
                }

                if (!Sisiii5aa.isChecked() && !Sisiii5ab.isChecked() && !Sisiii5ac.isChecked() && !Sisiii5ad.isChecked() && !Sisiii5ae.isChecked()){
                    inputcheck.add("5a");
                }

                if (!Sisiii5ba.isChecked() && !Sisiii5bb.isChecked() && !Sisiii5bc.isChecked() && !Sisiii5bd.isChecked() && !Sisiii5be.isChecked()){
                    inputcheck.add("5b");
                }

                if (!Sisiii5ca.isChecked() && !Sisiii5cb.isChecked() && !Sisiii5cc.isChecked() && !Sisiii5cd.isChecked() && !Sisiii5ce.isChecked()){
                    inputcheck.add("5c");
                }

                if (!Sisiii5da.isChecked() && !Sisiii5db.isChecked() && !Sisiii5dc.isChecked() && !Sisiii5dd.isChecked() && !Sisiii5de.isChecked()){
                    inputcheck.add("5d");
                }

                if (!Sisiii5ea.isChecked() && !Sisiii5eb.isChecked() && !Sisiii5ec.isChecked() && !Sisiii5ed.isChecked() && !Sisiii5ee.isChecked()){
                    inputcheck.add("5e");
                }

                if (!Sisiii5fa.isChecked() && !Sisiii5fb.isChecked() && !Sisiii5fc.isChecked() && !Sisiii5fd.isChecked() && !Sisiii5fe.isChecked()){
                    inputcheck.add("5f");
                }

                if (!Sisiii5ga.isChecked() && !Sisiii5gb.isChecked() && !Sisiii5gc.isChecked() && !Sisiii5gd.isChecked() && !Sisiii5ge.isChecked()){
                    inputcheck.add("5g");
                }

                if (!Sisiii5ha.isChecked() && !Sisiii5hb.isChecked() && !Sisiii5hc.isChecked() && !Sisiii5hd.isChecked() && !Sisiii5he.isChecked()){
                    inputcheck.add("5h");
                }

                if (!Sisiii5ia.isChecked() && !Sisiii5ib.isChecked() && !Sisiii5ic.isChecked() && !Sisiii5id.isChecked() && !Sisiii5ie.isChecked()){
                    inputcheck.add("5i");
                }

                if (!Sisiii5ja.isChecked() && !Sisiii5jb.isChecked() && !Sisiii5jc.isChecked() && !Sisiii5jd.isChecked() && !Sisiii5je.isChecked()){
                    inputcheck.add("5j");
                }

                if (!Sisiii6aa.isChecked() && !Sisiii6ab.isChecked() && !Sisiii6ac.isChecked() && !Sisiii6ad.isChecked() && !Sisiii6ae.isChecked()){
                    inputcheck.add("6a");
                }

                if (!Sisiii6ba.isChecked() && !Sisiii6bb.isChecked() && !Sisiii6bc.isChecked() && !Sisiii6bd.isChecked() && !Sisiii6be.isChecked()){
                    inputcheck.add("6b");
                }

                if (!Sisiii6ca.isChecked() && !Sisiii6cb.isChecked() && !Sisiii6cc.isChecked() && !Sisiii6cd.isChecked() && !Sisiii6ce.isChecked()){
                    inputcheck.add("6c");
                }

                if (!Sisiii6da.isChecked() && !Sisiii6db.isChecked() && !Sisiii6dc.isChecked() && !Sisiii6dd.isChecked() && !Sisiii6de.isChecked()){
                    inputcheck.add("6d");
                }

                if (!Sisiii6ea.isChecked() && !Sisiii6eb.isChecked() && !Sisiii6ec.isChecked() && !Sisiii6ed.isChecked() && !Sisiii6ee.isChecked()){
                    inputcheck.add("6e");
                }

                if (!Sisiii6fa.isChecked() && !Sisiii6fb.isChecked() && !Sisiii6fc.isChecked() && !Sisiii6fd.isChecked() && !Sisiii6fe.isChecked()){
                    inputcheck.add("6f");
                }

                if (!Sisiii6ga.isChecked() && !Sisiii6gb.isChecked() && !Sisiii6gc.isChecked() && !Sisiii6gd.isChecked() && !Sisiii6ge.isChecked()){
                    inputcheck.add("6g");
                }

                if (!Sisiii6ha.isChecked() && !Sisiii6hb.isChecked() && !Sisiii6hc.isChecked() && !Sisiii6hd.isChecked() && !Sisiii6he.isChecked()){
                    inputcheck.add("6h");
                }

                if (!Sisiii6ia.isChecked() && !Sisiii6ib.isChecked() && !Sisiii6ic.isChecked() && !Sisiii6id.isChecked() && !Sisiii6ie.isChecked()){
                    inputcheck.add("6i");
                }


                if (!Sisiii7aa.isChecked() && !Sisiii7ab.isChecked() && !Sisiii7ac.isChecked() && !Sisiii7ad.isChecked() && !Sisiii7ae.isChecked()){
                    inputcheck.add("7a");
                }

                if (!Sisiii7ba.isChecked() && !Sisiii7bb.isChecked() && !Sisiii7bc.isChecked() && !Sisiii7bd.isChecked() && !Sisiii7be.isChecked()){
                    inputcheck.add("7b");
                }

                if (!Sisiii7ca.isChecked() && !Sisiii7cb.isChecked() && !Sisiii7cc.isChecked() && !Sisiii7cd.isChecked() && !Sisiii7ce.isChecked()){
                    inputcheck.add("7c");
                }

                if (!Sisiii7da.isChecked() && !Sisiii7db.isChecked() && !Sisiii7dc.isChecked() && !Sisiii7dd.isChecked() && !Sisiii7de.isChecked()){
                    inputcheck.add("7d");
                }

                if (!Sisiii7ea.isChecked() && !Sisiii7eb.isChecked() && !Sisiii7ec.isChecked() && !Sisiii7ed.isChecked() && !Sisiii7ee.isChecked()){
                    inputcheck.add("7e");
                }

                if (!Sisiii8aa.isChecked() && !Sisiii8ab.isChecked() && !Sisiii8ac.isChecked() && !Sisiii8ad.isChecked() && !Sisiii8ae.isChecked()){
                    inputcheck.add("8a");
                }

                if (!Sisiii8ba.isChecked() && !Sisiii8bb.isChecked() && !Sisiii8bc.isChecked() && !Sisiii8bd.isChecked() && !Sisiii8be.isChecked()){
                    inputcheck.add("8b");
                }

                if (!Sisiii8ca.isChecked() && !Sisiii8cb.isChecked() && !Sisiii8cc.isChecked() && !Sisiii8cd.isChecked() && !Sisiii8ce.isChecked()){
                    inputcheck.add("8c");
                }

                if (!Sisiii8da.isChecked() && !Sisiii8db.isChecked() && !Sisiii8dc.isChecked() && !Sisiii8dd.isChecked() && !Sisiii8de.isChecked()){
                    inputcheck.add("8d");
                }

                if (!Sisiii8ea.isChecked() && !Sisiii8eb.isChecked() && !Sisiii8ec.isChecked() && !Sisiii8ed.isChecked() && !Sisiii8ee.isChecked()){
                    inputcheck.add("8e");
                }

                if (!Sisiii8fa.isChecked() && !Sisiii8fb.isChecked() && !Sisiii8fc.isChecked() && !Sisiii8fd.isChecked() && !Sisiii8fe.isChecked()){
                    inputcheck.add("8f");
                }

                if (!Sisiii8ga.isChecked() && !Sisiii8gb.isChecked() && !Sisiii8gc.isChecked() && !Sisiii8gd.isChecked() && !Sisiii8ge.isChecked()){
                    inputcheck.add("8g");
                }

                if (!Sisiii8ha.isChecked() && !Sisiii8hb.isChecked() && !Sisiii8hc.isChecked() && !Sisiii8hd.isChecked() && !Sisiii8he.isChecked()){
                    inputcheck.add("8h");
                }

                if (TextUtils.isEmpty(Sisiii9a.getText())){
                    inputcheck.add("Stroke Recovery");
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
                    alertDialog.setIcon(R.mipmap.ic_launcher2);
                    alertDialog.show();
                }else {
                    Intent Answers = new Intent(stroke_impact.this, stroke_impactconf.class);
                    Answers.putExtra("Sisiii1a", Sisiii1a);
                    Answers.putExtra("Sisiii1b", Sisiii1b);
                    Answers.putExtra("Sisiii1c", Sisiii1c);
                    Answers.putExtra("Sisiii1d", Sisiii1d);
                    Answers.putExtra("Sisiii2a", Sisiii2a);
                    Answers.putExtra("Sisiii2b", Sisiii2b);
                    Answers.putExtra("Sisiii2c", Sisiii2c);
                    Answers.putExtra("Sisiii2d", Sisiii2d);
                    Answers.putExtra("Sisiii2e", Sisiii2e);
                    Answers.putExtra("Sisiii2f", Sisiii2f);
                    Answers.putExtra("Sisiii2g", Sisiii2g);
                    Answers.putExtra("Sisiii3a", Sisiii3a);
                    Answers.putExtra("Sisiii3b", Sisiii3b);
                    Answers.putExtra("Sisiii3c", Sisiii3c);
                    Answers.putExtra("Sisiii3d", Sisiii3d);
                    Answers.putExtra("Sisiii3e", Sisiii3e);
                    Answers.putExtra("Sisiii3f", Sisiii3f);
                    Answers.putExtra("Sisiii3g", Sisiii3g);
                    Answers.putExtra("Sisiii3h", Sisiii3h);
                    Answers.putExtra("Sisiii3i", Sisiii3i);
                    Answers.putExtra("Sisiii4a", Sisiii4a);
                    Answers.putExtra("Sisiii4b", Sisiii4b);
                    Answers.putExtra("Sisiii4c", Sisiii4c);
                    Answers.putExtra("Sisiii4d", Sisiii4d);
                    Answers.putExtra("Sisiii4e", Sisiii4e);
                    Answers.putExtra("Sisiii4f", Sisiii4f);
                    Answers.putExtra("Sisiii4g", Sisiii4g);
                    Answers.putExtra("Sisiii5a", Sisiii5a);
                    Answers.putExtra("Sisiii5b", Sisiii5b);
                    Answers.putExtra("Sisiii5c", Sisiii5c);
                    Answers.putExtra("Sisiii5d", Sisiii5d);
                    Answers.putExtra("Sisiii5e", Sisiii5e);
                    Answers.putExtra("Sisiii5f", Sisiii5f);
                    Answers.putExtra("Sisiii5g", Sisiii5g);
                    Answers.putExtra("Sisiii5h", Sisiii5h);
                    Answers.putExtra("Sisiii5i", Sisiii5i);
                    Answers.putExtra("Sisiii5j", Sisiii5j);
                    Answers.putExtra("Sisiii6a", Sisiii6a);
                    Answers.putExtra("Sisiii6b", Sisiii6b);
                    Answers.putExtra("Sisiii6c", Sisiii6c);
                    Answers.putExtra("Sisiii6d", Sisiii6d);
                    Answers.putExtra("Sisiii6e", Sisiii6e);
                    Answers.putExtra("Sisiii6f", Sisiii6f);
                    Answers.putExtra("Sisiii6g", Sisiii6g);
                    Answers.putExtra("Sisiii6h", Sisiii6h);
                    Answers.putExtra("Sisiii6i", Sisiii6i);
                    Answers.putExtra("Sisiii7a", Sisiii7a);
                    Answers.putExtra("Sisiii7b", Sisiii7b);
                    Answers.putExtra("Sisiii7c", Sisiii7c);
                    Answers.putExtra("Sisiii7d", Sisiii7d);
                    Answers.putExtra("Sisiii7e", Sisiii7e);
                    Answers.putExtra("Sisiii8a", Sisiii8a);
                    Answers.putExtra("Sisiii8b", Sisiii8b);
                    Answers.putExtra("Sisiii8c", Sisiii8c);
                    Answers.putExtra("Sisiii8d", Sisiii8d);
                    Answers.putExtra("Sisiii8e", Sisiii8e);
                    Answers.putExtra("Sisiii8f", Sisiii8f);
                    Answers.putExtra("Sisiii8g", Sisiii8g);
                    Answers.putExtra("Sisiii8h", Sisiii8h);
                    Answers.putExtra("SisiiiQTotal", SisiiiQTotal);
                    Answers.putExtra("Event", Event);
                    Answers.putExtra("Sisiii9a", Sisiii9a.getText().toString());

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

