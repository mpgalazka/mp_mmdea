package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class sf36conf extends AppCompatActivity {

    Double sfq1,
            sfq2,
            sfq3,
            sfq4,
            sfq5,
            sfq6,
            sfq7,
            sfq8,
            sfq9,
            sfq10,
            sfq11,
            sfq12,
            sfq13,
            sfq14,
            sfq15,
            sfq16,
            sfq17,
            sfq18,
            sfq19,
            sfq20,
            sfq21,
            sfq22,
            sfq23,
            sfq24,
            sfq25,
            sfq26,
            sfq27,
            sfq28,
            sfq29,
            sfq30,
            sfq31,
            sfq32,
            sfq33,
            sfq34,
            sfq35,
            sfq36,
            physicalfunction, limitation_due_to_physical_health, limitation_due_to_emotional_problem,
            energy_fatigue, emotional_wellbeing, social_functioning, pain, generalhealth;
    String PatID, Date, Event,
            ssfq1,
            ssfq2,
            ssfq3,
            ssfq4,
            ssfq5,
            ssfq6,
            ssfq7,
            ssfq8,
            ssfq9,
            ssfq10,
            ssfq11,
            ssfq12,
            ssfq13,
            ssfq14,
            ssfq15,
            ssfq16,
            ssfq17,
            ssfq18,
            ssfq19,
            ssfq20,
            ssfq21,
            ssfq22,
            ssfq23,
            ssfq24,
            ssfq25,
            ssfq26,
            ssfq27,
            ssfq28,
            ssfq29,
            ssfq30,
            ssfq31,
            ssfq32,
            ssfq33,
            ssfq34,
            ssfq35,
            ssfq36;

    JSONObject record;

    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sf36conf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }
        Intent Answers = this.getIntent();

        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        sfq1 = Answers.getDoubleExtra("sfq1", 0);
        sfq2 = Answers.getDoubleExtra("sfq2", 0);
        sfq3 = Answers.getDoubleExtra("sfq3", 0);
        sfq4 = Answers.getDoubleExtra("sfq4", 0);
        sfq5 = Answers.getDoubleExtra("sfq5", 0);
        sfq6 = Answers.getDoubleExtra("sfq6", 0);
        sfq7 = Answers.getDoubleExtra("sfq7", 0);
        sfq8 = Answers.getDoubleExtra("sfq8", 0);
        sfq9 = Answers.getDoubleExtra("sfq9", 0);
        sfq10 = Answers.getDoubleExtra("sfq10", 0);
        sfq11 = Answers.getDoubleExtra("sfq11", 0);
        sfq12 = Answers.getDoubleExtra("sfq12", 0);
        sfq13 = Answers.getDoubleExtra("sfq13", 0);
        sfq14 = Answers.getDoubleExtra("sfq14", 0);
        sfq15 = Answers.getDoubleExtra("sfq15", 0);
        sfq16 = Answers.getDoubleExtra("sfq16", 0);
        sfq17 = Answers.getDoubleExtra("sfq17", 0);
        sfq18 = Answers.getDoubleExtra("sfq18", 0);
        sfq19 = Answers.getDoubleExtra("sfq19", 0);
        sfq20 = Answers.getDoubleExtra("sfq20", 0);
        sfq21 = Answers.getDoubleExtra("sfq21", 0);
        sfq22 = Answers.getDoubleExtra("sfq22", 0);
        sfq23 = Answers.getDoubleExtra("sfq23", 0);
        sfq24 = Answers.getDoubleExtra("sfq24", 0);
        sfq25 = Answers.getDoubleExtra("sfq25", 0);
        sfq26 = Answers.getDoubleExtra("sfq26", 0);
        sfq27 = Answers.getDoubleExtra("sfq27", 0);
        sfq28 = Answers.getDoubleExtra("sfq28", 0);
        sfq29 = Answers.getDoubleExtra("sfq29", 0);
        sfq30 = Answers.getDoubleExtra("sfq30", 0);
        sfq31 = Answers.getDoubleExtra("sfq31", 0);
        sfq32 = Answers.getDoubleExtra("sfq32", 0);
        sfq33 = Answers.getDoubleExtra("sfq33", 0);
        sfq34 = Answers.getDoubleExtra("sfq34", 0);
        sfq35 = Answers.getDoubleExtra("sfq35", 0);
        sfq36 = Answers.getDoubleExtra("sfq36", 0);
        physicalfunction = Answers.getDoubleExtra("physicalfunction", 0);
        limitation_due_to_physical_health = Answers.getDoubleExtra("limitation_due_to_physical_health", 0);
        limitation_due_to_emotional_problem = Answers.getDoubleExtra("limitation_due_to_emotional_problem", 0);
        energy_fatigue = Answers.getDoubleExtra("energy_fatigue", 0);
        emotional_wellbeing = Answers.getDoubleExtra("emotional_wellbeing", 0);
        social_functioning = Answers.getDoubleExtra("social_functioning", 0);
        pain = Answers.getDoubleExtra("pain", 0);
        generalhealth = Answers.getDoubleExtra("generalhealth", 0);


        ((TextView)findViewById(R.id.conDate)).setText("Date: " + Date);
        ((TextView)findViewById(R.id.conPatID)).setText(PatID);

        if (sfq1 == 100) {
            ssfq1 = getResources().getString(R.string.ans1a);
        } else if (sfq1 == 75) {
            ssfq1 = getResources().getString(R.string.ans1b);
        } else if (sfq1 == 50) {
            ssfq1 = getResources().getString(R.string.ans1c);
        } else if (sfq1 == 25) {
            ssfq1 = getResources().getString(R.string.ans1d);
        } else if (sfq1 == 0) {
            ssfq1 = getResources().getString(R.string.ans1e);
        }

        if (sfq2 == 100) {
            ssfq2 = getResources().getString(R.string.ans2a);
        } else if (sfq2 == 75) {
            ssfq2 = getResources().getString(R.string.ans2b);
        } else if (sfq2 == 50) {
            ssfq2 = getResources().getString(R.string.ans2c);
        } else if (sfq2 == 25) {
            ssfq2 = getResources().getString(R.string.ans2d);
        } else if (sfq2 == 0) {
            ssfq2 = getResources().getString(R.string.ans2e);
        }
        if (sfq20 == 100) {
            ssfq20 = getResources().getString(R.string.ans20a);
        } else if (sfq20 == 75) {
            ssfq20 = getResources().getString(R.string.ans20b);
        } else if (sfq20 == 50) {
            ssfq20 = getResources().getString(R.string.ans20c);
        } else if (sfq20 == 25) {
            ssfq20 = getResources().getString(R.string.ans20d);
        } else if (sfq20 == 0) {
            ssfq20 = getResources().getString(R.string.ans20e);
        }
        if (sfq22 == 100) {
            ssfq22 = getResources().getString(R.string.ans22a);
        } else if (sfq22 == 75) {
            ssfq22 = getResources().getString(R.string.ans22b);
        } else if (sfq22 == 50) {
            ssfq22 = getResources().getString(R.string.ans22c);
        } else if (sfq22 == 25) {
            ssfq22 = getResources().getString(R.string.ans22d);
        } else if (sfq22 == 0) {
            ssfq22 = getResources().getString(R.string.ans22e);
        }
        if (sfq34 == 100) {
            ssfq34 = getResources().getString(R.string.ans33_36a);
        } else if (sfq34 == 75) {
            ssfq34 = getResources().getString(R.string.ans33_36b);
        } else if (sfq34 == 50) {
            ssfq34 = getResources().getString(R.string.ans33_36c);
        } else if (sfq34 == 25) {
            ssfq34 = getResources().getString(R.string.ans33_36d);
        } else if (sfq34 == 0) {
            ssfq34 = getResources().getString(R.string.ans33_36e);
        }
        if (sfq36 == 100) {
            ssfq36 = getResources().getString(R.string.ans33_36a);
        } else if (sfq36 == 75) {
            ssfq36 = getResources().getString(R.string.ans33_36b);
        } else if (sfq36 == 50) {
            ssfq36 = getResources().getString(R.string.ans33_36c);
        } else if (sfq36 == 25) {
            ssfq36 = getResources().getString(R.string.ans33_36d);
        } else if (sfq36 == 0) {
            ssfq36 = getResources().getString(R.string.ans33_36e);
        }


        if (sfq3 == 0) {
            ssfq3 = getResources().getString(R.string.ans3_12a);
        } else if (sfq3 == 50) {
            ssfq3 = getResources().getString(R.string.ans3_12b);
        } else if (sfq3 == 100) {
            ssfq3 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq4 == 0) {
            ssfq4 = getResources().getString(R.string.ans3_12a);
        } else if (sfq4 == 50) {
            ssfq4 = getResources().getString(R.string.ans3_12b);
        } else if (sfq4 == 100) {
            ssfq4 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq5 == 0) {
            ssfq5 = getResources().getString(R.string.ans3_12a);
        } else if (sfq5 == 50) {
            ssfq5 = getResources().getString(R.string.ans3_12b);
        } else if (sfq5 == 100) {
            ssfq5 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq6 == 0) {
            ssfq6 = getResources().getString(R.string.ans3_12a);
        } else if (sfq6 == 50) {
            ssfq6 = getResources().getString(R.string.ans3_12b);
        } else if (sfq6 == 100) {
            ssfq6 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq7 == 0) {
            ssfq7 = getResources().getString(R.string.ans3_12a);
        } else if (sfq7 == 50) {
            ssfq7 = getResources().getString(R.string.ans3_12b);
        } else if (sfq7 == 100) {
            ssfq7 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq8 == 0) {
            ssfq8 = getResources().getString(R.string.ans3_12a);
        } else if (sfq8 == 50) {
            ssfq8 = getResources().getString(R.string.ans3_12b);
        } else if (sfq8 == 100) {
            ssfq8 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq9 == 0) {
            ssfq9 = getResources().getString(R.string.ans3_12a);
        } else if (sfq9 == 50) {
            ssfq9 = getResources().getString(R.string.ans3_12b);
        } else if (sfq9 == 100) {
            ssfq9 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq10 == 0) {
            ssfq10 = getResources().getString(R.string.ans3_12a);
        } else if (sfq10 == 50) {
            ssfq10 = getResources().getString(R.string.ans3_12b);
        } else if (sfq10 == 100) {
            ssfq10 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq11 == 0) {
            ssfq11 = getResources().getString(R.string.ans3_12a);
        } else if (sfq11 == 50) {
            ssfq11 = getResources().getString(R.string.ans3_12b);
        } else if (sfq11 == 100) {
            ssfq11 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq12 == 0) {
            ssfq12 = getResources().getString(R.string.ans3_12a);
        } else if (sfq12 == 50) {
            ssfq12 = getResources().getString(R.string.ans3_12b);
        } else if (sfq12 == 100) {
            ssfq12 = getResources().getString(R.string.ans3_12c);
        }
        if (sfq13 == 0) {
            ssfq13 = getResources().getString(R.string.ans13_19a);
        } else if (sfq13 == 100) {
            ssfq13 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq14 == 0) {
            ssfq14 = getResources().getString(R.string.ans13_19a);
        } else if (sfq14 == 100) {
            ssfq14 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq15 == 0) {
            ssfq15 = getResources().getString(R.string.ans13_19a);
        } else if (sfq15 == 100) {
            ssfq15 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq16 == 0) {
            ssfq16 = getResources().getString(R.string.ans13_19a);
        } else if (sfq16 == 100) {
            ssfq16 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq17 == 0) {
            ssfq17 = getResources().getString(R.string.ans13_19a);
        } else if (sfq17 == 100) {
            ssfq17 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq18 == 0) {
            ssfq18 = getResources().getString(R.string.ans13_19a);
        } else if (sfq18 == 100) {
            ssfq18 = getResources().getString(R.string.ans13_19b);
        }
        if (sfq19 == 0) {
            ssfq19 = getResources().getString(R.string.ans13_19a);
        } else if (sfq19 == 100) {
            ssfq19 = getResources().getString(R.string.ans13_19b);
        }


        if (sfq21 == 100) {
            ssfq21 = getResources().getString(R.string.ans21a);
        } else if (sfq21 == 80) {
            ssfq21 = getResources().getString(R.string.ans21b);
        } else if (sfq21 == 60) {
            ssfq21 = getResources().getString(R.string.ans21c);
        } else if (sfq21 == 40) {
            ssfq21 = getResources().getString(R.string.ans21d);
        } else if (sfq21 == 20) {
            ssfq21 = getResources().getString(R.string.ans21e);
        } else if (sfq21 == 0) {
            ssfq21 = getResources().getString(R.string.ans21f);
        }
        if (sfq23 == 100) {
            ssfq23 = getResources().getString(R.string.ans23_31a);
        } else if (sfq23 == 80) {
            ssfq23 = getResources().getString(R.string.ans23_31b);
        } else if (sfq23 == 60) {
            ssfq23 = getResources().getString(R.string.ans23_31c);
        } else if (sfq23 == 40) {
            ssfq23 = getResources().getString(R.string.ans23_31d);
        } else if (sfq23 == 20) {
            ssfq23 = getResources().getString(R.string.ans23_31e);
        } else if (sfq23 == 0) {
            ssfq23 = getResources().getString(R.string.ans23_31f);
        }

        if (sfq26 == 100) {
            ssfq26 = getResources().getString(R.string.ans23_31a);
        } else if (sfq26 == 80) {
            ssfq26 = getResources().getString(R.string.ans23_31b);
        } else if (sfq26 == 60) {
            ssfq26 = getResources().getString(R.string.ans23_31c);
        } else if (sfq26 == 40) {
            ssfq26 = getResources().getString(R.string.ans23_31d);
        } else if (sfq26 == 20) {
            ssfq26 = getResources().getString(R.string.ans23_31e);
        } else if (sfq26 == 0) {
            ssfq26 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq27 == 100) {
            ssfq27 = getResources().getString(R.string.ans23_31a);
        } else if (sfq27 == 80) {
            ssfq27 = getResources().getString(R.string.ans23_31b);
        } else if (sfq27 == 60) {
            ssfq27 = getResources().getString(R.string.ans23_31c);
        } else if (sfq27 == 40) {
            ssfq27 = getResources().getString(R.string.ans23_31d);
        } else if (sfq27 == 20) {
            ssfq27 = getResources().getString(R.string.ans23_31e);
        } else if (sfq27 == 0) {
            ssfq27 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq30 == 100) {
            ssfq30 = getResources().getString(R.string.ans23_31a);
        } else if (sfq30 == 80) {
            ssfq30 = getResources().getString(R.string.ans23_31b);
        } else if (sfq30 == 60) {
            ssfq30 = getResources().getString(R.string.ans23_31c);
        } else if (sfq30 == 40) {
            ssfq30 = getResources().getString(R.string.ans23_31d);
        } else if (sfq30 == 20) {
            ssfq30 = getResources().getString(R.string.ans23_31e);
        } else if (sfq30 == 0) {
            ssfq30 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq24 == 0) {
            ssfq24 = getResources().getString(R.string.ans23_31a);
        } else if (sfq24 == 20) {
            ssfq24 = getResources().getString(R.string.ans23_31b);
        } else if (sfq24 == 40) {
            ssfq24 = getResources().getString(R.string.ans23_31c);
        } else if (sfq24 == 60) {
            ssfq24 = getResources().getString(R.string.ans23_31d);
        } else if (sfq24 == 80) {
            ssfq24 = getResources().getString(R.string.ans23_31e);
        } else if (sfq24 == 100) {
            ssfq24 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq25 == 0) {
            ssfq25 = getResources().getString(R.string.ans23_31a);
        } else if (sfq25 == 20) {
            ssfq25 = getResources().getString(R.string.ans23_31b);
        } else if (sfq25 == 40) {
            ssfq25 = getResources().getString(R.string.ans23_31c);
        } else if (sfq25 == 60) {
            ssfq25 = getResources().getString(R.string.ans23_31d);
        } else if (sfq25 == 80) {
            ssfq25 = getResources().getString(R.string.ans23_31e);
        } else if (sfq25 == 100) {
            ssfq25 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq28 == 0) {
            ssfq28 = getResources().getString(R.string.ans23_31a);
        } else if (sfq28 == 20) {
            ssfq28 = getResources().getString(R.string.ans23_31b);
        } else if (sfq28 == 40) {
            ssfq28 = getResources().getString(R.string.ans23_31c);
        } else if (sfq28 == 60) {
            ssfq28 = getResources().getString(R.string.ans23_31d);
        } else if (sfq28 == 80) {
            ssfq28 = getResources().getString(R.string.ans23_31e);
        } else if (sfq28 == 100) {
            ssfq28 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq29 == 0) {
            ssfq29 = getResources().getString(R.string.ans23_31a);
        } else if (sfq29 == 20) {
            ssfq29 = getResources().getString(R.string.ans23_31b);
        } else if (sfq29 == 40) {
            ssfq29 = getResources().getString(R.string.ans23_31c);
        } else if (sfq29 == 60) {
            ssfq29 = getResources().getString(R.string.ans23_31d);
        } else if (sfq29 == 80) {
            ssfq29 = getResources().getString(R.string.ans23_31e);
        } else if (sfq29 == 100) {
            ssfq29 = getResources().getString(R.string.ans23_31f);
        }
        if (sfq31 == 0) {
            ssfq31 = getResources().getString(R.string.ans23_31a);
        } else if (sfq31 == 20) {
            ssfq31 = getResources().getString(R.string.ans23_31b);
        } else if (sfq31 == 40) {
            ssfq31 = getResources().getString(R.string.ans23_31c);
        } else if (sfq31 == 60) {
            ssfq31 = getResources().getString(R.string.ans23_31d);
        } else if (sfq31 == 80) {
            ssfq31 = getResources().getString(R.string.ans23_31e);
        } else if (sfq31 == 100) {
            ssfq31 = getResources().getString(R.string.ans23_31f);
        }


        if (sfq32 == 0) {
            ssfq32 = getResources().getString(R.string.ans32a);
        } else if (sfq32 == 25) {
            ssfq32 = getResources().getString(R.string.ans32b);
        } else if (sfq32 == 50) {
            ssfq32 = getResources().getString(R.string.ans32c);
        } else if (sfq32 == 75) {
            ssfq32 = getResources().getString(R.string.ans32d);
        } else if (sfq32 == 100) {
            ssfq32 = getResources().getString(R.string.ans32e);
        }
        if (sfq33 == 0) {
            ssfq33 = getResources().getString(R.string.ans33_36a);
        } else if (sfq33 == 25) {
            ssfq33 = getResources().getString(R.string.ans33_36b);
        } else if (sfq33 == 50) {
            ssfq33 = getResources().getString(R.string.ans33_36c);
        } else if (sfq33 == 75) {
            ssfq33 = getResources().getString(R.string.ans33_36d);
        } else if (sfq33 == 100) {
            ssfq33 = getResources().getString(R.string.ans33_36e);
        }
        if (sfq35 == 0) {
            ssfq35 = getResources().getString(R.string.ans33_36a);
        } else if (sfq35 == 25) {
            ssfq35 = getResources().getString(R.string.ans33_36b);
        } else if (sfq35 == 50) {
            ssfq35 = getResources().getString(R.string.ans33_36c);
        } else if (sfq35 == 75) {
            ssfq35 = getResources().getString(R.string.ans33_36d);
        } else if (sfq35 == 100) {
            ssfq35 = getResources().getString(R.string.ans33_36e);
        }


        ((TextView) findViewById(R.id.sfq1)).setText(ssfq1);
        ((TextView) findViewById(R.id.sfq2)).setText(ssfq2);
        ((TextView) findViewById(R.id.sfq3)).setText(ssfq3);
        ((TextView) findViewById(R.id.sfq4)).setText(ssfq4);
        ((TextView) findViewById(R.id.sfq5)).setText(ssfq5);
        ((TextView) findViewById(R.id.sfq6)).setText(ssfq6);
        ((TextView) findViewById(R.id.sfq7)).setText(ssfq7);
        ((TextView) findViewById(R.id.sfq8)).setText(ssfq8);
        ((TextView) findViewById(R.id.sfq9)).setText(ssfq9);
        ((TextView) findViewById(R.id.sfq10)).setText(ssfq10);
        ((TextView) findViewById(R.id.sfq11)).setText(ssfq11);
        ((TextView) findViewById(R.id.sfq12)).setText(ssfq12);
        ((TextView) findViewById(R.id.sfq13)).setText(ssfq13);
        ((TextView) findViewById(R.id.sfq14)).setText(ssfq14);
        ((TextView) findViewById(R.id.sfq15)).setText(ssfq15);
        ((TextView) findViewById(R.id.sfq16)).setText(ssfq16);
        ((TextView) findViewById(R.id.sfq17)).setText(ssfq17);
        ((TextView) findViewById(R.id.sfq18)).setText(ssfq18);
        ((TextView) findViewById(R.id.sfq19)).setText(ssfq19);
        ((TextView) findViewById(R.id.sfq20)).setText(ssfq20);
        ((TextView) findViewById(R.id.sfq21)).setText(ssfq21);
        ((TextView) findViewById(R.id.sfq22)).setText(ssfq22);
        ((TextView) findViewById(R.id.sfq23)).setText(ssfq23);
        ((TextView) findViewById(R.id.sfq24)).setText(ssfq24);
        ((TextView) findViewById(R.id.sfq25)).setText(ssfq25);
        ((TextView) findViewById(R.id.sfq26)).setText(ssfq26);
        ((TextView) findViewById(R.id.sfq27)).setText(ssfq27);
        ((TextView) findViewById(R.id.sfq28)).setText(ssfq28);
        ((TextView) findViewById(R.id.sfq29)).setText(ssfq29);
        ((TextView) findViewById(R.id.sfq30)).setText(ssfq30);
        ((TextView) findViewById(R.id.sfq31)).setText(ssfq31);
        ((TextView) findViewById(R.id.sfq32)).setText(ssfq32);
        ((TextView) findViewById(R.id.sfq33)).setText(ssfq33);
        ((TextView) findViewById(R.id.sfq34)).setText(ssfq34);
        ((TextView) findViewById(R.id.sfq35)).setText(ssfq35);
        ((TextView) findViewById(R.id.sfq36)).setText(ssfq36);

        ((TextView)findViewById(R.id.PhyFunc)).setText(String.format("%.2f", physicalfunction));
        ((TextView)findViewById(R.id.LimPhyHeal)).setText(String.format("%.2f", limitation_due_to_physical_health));
        ((TextView)findViewById(R.id.LimEmoPro)).setText(String.format("%.2f", limitation_due_to_emotional_problem));
        ((TextView)findViewById(R.id.EnFat)).setText(String.format("%.2f", energy_fatigue));
        ((TextView)findViewById(R.id.EmoWell)).setText(String.format("%.2f", emotional_wellbeing));
        ((TextView)findViewById(R.id.SocFunc)).setText(String.format("%.2f", social_functioning));
        ((TextView)findViewById(R.id.Pain)).setText(String.format("%.2f", pain));
        ((TextView) findViewById(R.id.GenHeal)).setText(String.format("%.2f", generalhealth));

        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("sf1", sfq1);
        record.put("sf2", sfq2);
        record.put("sf3", sfq3);
        record.put("sf4", sfq4);
        record.put("sf5", sfq5);
        record.put("sf6", sfq6);
        record.put("sf7", sfq7);
        record.put("sf8", sfq8);
        record.put("sf9", sfq9);
        record.put("sf10", sfq10);
        record.put("sf11", sfq11);
        record.put("sf12", sfq12);
        record.put("sf13", sfq13);
        record.put("sf14", sfq14);
        record.put("sf15", sfq15);
        record.put("sf16", sfq16);
        record.put("sf17", sfq17);
        record.put("sf18", sfq18);
        record.put("sf19", sfq19);
        record.put("sf20", sfq20);
        record.put("sf21", sfq21);
        record.put("sf22", sfq22);
        record.put("sf23", sfq23);
        record.put("sf24", sfq24);
        record.put("sf25", sfq25);
        record.put("sf26", sfq26);
        record.put("sf27", sfq27);
        record.put("sf28", sfq28);
        record.put("sf29", sfq29);
        record.put("sf30", sfq30);
        record.put("sf31", sfq31);
        record.put("sf32", sfq32);
        record.put("sf33", sfq33);
        record.put("sf34", sfq34);
        record.put("sf35", sfq35);
        record.put("sf36", sfq36);
        record.put("sf37", physicalfunction);
        record.put("sf38", limitation_due_to_physical_health);
        record.put("sf39", limitation_due_to_emotional_problem);
        record.put("sf40", energy_fatigue);
        record.put("sf41", emotional_wellbeing);
        record.put("sf42", social_functioning);
        record.put("sf43", pain);
        record.put("sf44", generalhealth);
        record.put("redcap_event_name", "adm_arm_1");
        record.put("sf36_questionnaire_complete", "2");
    }

    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close SF-36 Questionnaire");
        alertclose.setMessage("Are you sure you want to return to the list of forms?");
        alertclose.setCancelable(true);

        alertclose.setButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast toast = Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                        new CountDownTimer(1, 1000) {
                            public void onFinish() {
                                Intent PID = new Intent(sf36conf.this, Forms.class);
                                PID.putExtra("PatientID", PatID);
                                PID.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(PID);

                            }

                            public void onTick(long millisUntilFinished) {
                                // millisUntilFinished    The amount of time until finished.
                            }
                        }.start();
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

    //HTTP post for REDCap stuff

    public void UploadREDCap (View view){

        response = null;


        makePostRequest();

        if (response == null){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("There was an error uploading to REDCap");
            alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.setIcon(R.mipmap.ic_launcher2);
            alertDialog.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Success");
            alertDialog.setMessage("Successfully uploaded to REDCap");
            alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.setIcon(R.mipmap.ic_launcher3);
            alertDialog.show();
        }
    }



    private void makePostRequest() {

        JSONArray data = new JSONArray();
        data.add(record);


        //Timeout Stuff
        HttpParams httpParameters = new BasicHttpParams();
        int timeoutConnection = 1000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        int timeoutSocket = 1500;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpClient httpClient = new DefaultHttpClient();
        // replace with your url
        HttpPost httpPost = new HttpPost("https://redcap.ctsc.med.cornell.edu/redcap_protocols/api/");


        //Post Data
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
        nameValuePair.add(new BasicNameValuePair("token", getString(R.string.API_TOKEN)));
        nameValuePair.add(new BasicNameValuePair("content", "record"));
        nameValuePair.add(new BasicNameValuePair("format", "json"));
        nameValuePair.add(new BasicNameValuePair("type", "flat"));
        nameValuePair.add(new BasicNameValuePair("data", data.toJSONString()));


        //Encoding POST data
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            // log exception
            e.printStackTrace();
        }

        //making POST request.
        try {
            response = httpClient.execute(httpPost);
            // write response to log
            Log.d("Http Post Response:", response.toString());
        } catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception
            e.printStackTrace();
        }

    }


    //PDF stuff below

    public class MyPrintDocumentAdapter extends PrintDocumentAdapter {

        Context context;
        private int pageHeight;
        private int pageWidth;
        public PdfDocument myPdfDocument;
        public int totalpages = 4;

        public MyPrintDocumentAdapter(Context context) {
            this.context = context;
        }

        @Override
        public void onLayout(PrintAttributes oldAttributes,
                             PrintAttributes newAttributes,
                             CancellationSignal cancellationSignal,
                             LayoutResultCallback callback,
                             Bundle metadata) {

            myPdfDocument = new PrintedPdfDocument(context, newAttributes);

            pageHeight =
                    newAttributes.getMediaSize().getHeightMils() / 1000 * 72;
            pageWidth =
                    newAttributes.getMediaSize().getWidthMils() / 1000 * 72;

            if (cancellationSignal.isCanceled()) {
                callback.onLayoutCancelled();
                return;
            }

            if (totalpages > 0) {
                PrintDocumentInfo.Builder builder = new PrintDocumentInfo
                        .Builder("print_output.pdf")
                        .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                        .setPageCount(totalpages);

                PrintDocumentInfo info = builder.build();
                callback.onLayoutFinished(info, true);
            } else {
                callback.onLayoutFailed("Page count is zero.");
            }
        }


        @Override
        public void onWrite(final PageRange[] pageRanges,
                            final ParcelFileDescriptor destination,
                            final CancellationSignal cancellationSignal,
                            final WriteResultCallback callback) {

            for (int i = 0; i < totalpages; i++) {
                if (pageInRange(pageRanges, i)) {
                    PdfDocument.PageInfo newPage = new PdfDocument.PageInfo.Builder(pageWidth,
                            pageHeight, i).create();

                    PdfDocument.Page page =
                            myPdfDocument.startPage(newPage);

                    if (cancellationSignal.isCanceled()) {
                        callback.onWriteCancelled();
                        myPdfDocument.close();
                        myPdfDocument = null;
                        return;
                    }
                    drawPage(page, i);
                    myPdfDocument.finishPage(page);
                }
            }

            try {
                myPdfDocument.writeTo(new FileOutputStream(
                        destination.getFileDescriptor()));
            } catch (IOException e) {
                callback.onWriteFailed(e.toString());
                return;
            } finally {
                myPdfDocument.close();
                myPdfDocument = null;
            }

            callback.onWriteFinished(pageRanges);

        }

        private boolean pageInRange(PageRange[] pageRanges, int page) {
            for (int i = 0; i < pageRanges.length; i++) {
                if ((page >= pageRanges[i].getStart()) &&
                        (page <= pageRanges[i].getEnd()))
                    return true;
            }
            return false;
        }

        private void drawPage(PdfDocument.Page page,
                              int pagenumber) {
            Canvas canvas = page.getCanvas();

            pagenumber++; // Make sure page numbers start at 1

            int titleBaseLine = 72;
            int leftMargin = 54;

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);


            if (pagenumber == 1) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("           SF-36 Questionnaire", leftMargin, titleBaseLine, paint);



                paint.setTextSize(20);
                canvas.drawText("General Health ", 15, titleBaseLine + 4 * 25 + 5, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2*35, paint);


                paint.setTextSize(10);
                canvas.drawText("1. In general, would you say your health is:", 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("              " + ssfq1, 15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("2. Compared to one year ago, how would you rate your health in general now?", 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("              " + ssfq2, 15, titleBaseLine + 8 * 25, paint);
                paint.setTextSize(20);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                canvas.drawText("Limitations of Acitivites ", 15, titleBaseLine + 9 * 25 + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                paint.setTextSize(10);
                canvas.drawText("The following items are about acitivities you might do during a typical day. ", 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("Does your health now limit you in these activities? If so, how much? ", 15, titleBaseLine + 11 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("3. Vigorous activities, such as running, lifting heavy objects, participating in strenuous sports.", 15, titleBaseLine + 12 * 25, paint);
                canvas.drawText("              " + ssfq3, 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("4. Moderate activities, such as moving a talbe, pushing a vacuum cleaner, bowling, or playing golf", 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("              " + ssfq4, 15, titleBaseLine + 15 * 25, paint);
                canvas.drawText("5. Lifting or carrying groceries", 15, titleBaseLine + 16 * 25, paint);
                canvas.drawText("              " + ssfq5, 15, titleBaseLine + 17 * 25, paint);
                canvas.drawText("6. Climbing several flights of stairs", 15, titleBaseLine + 18 * 25, paint);
                canvas.drawText("              " + ssfq6, 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("7. Climbing one flight of stairs. ", 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("              " + ssfq7, 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("8. Bending, kneeling, or stooping", 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("              " + ssfq8, 15, titleBaseLine + 23 * 25, paint);
                canvas.drawText("9. Walking more than a mile.", 15, titleBaseLine + 24 * 25, paint);
                canvas.drawText("              " + ssfq9, 15, titleBaseLine + 25 * 25, paint);
                canvas.drawText("10. Walking several blocks.", 15, titleBaseLine + 26 * 25, paint);
                canvas.drawText("              " + ssfq10, 15, titleBaseLine + 27 * 25, paint);

                //new page

            } else if (pagenumber == 2) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("11. Walking one block.", 15, titleBaseLine, paint);
                canvas.drawText("              " + ssfq11, 15, titleBaseLine + 1 * 25, paint);
                canvas.drawText("12. Bathing or dressing yourself", 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("              " + ssfq12, 15, titleBaseLine + 3 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Physical Health Problems ", 15, titleBaseLine + 4 * 25 + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                paint.setTextSize(10);
                canvas.drawText("During the past 4 weeks, have you had any of the following problems with your work or other regular daily activities as a result of your", 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("physical health?", 15, titleBaseLine + 6 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("13. Cut down the amount of time you spent on work or other activities", 16, titleBaseLine + 7 * 25, paint);
                canvas.drawText("              " + ssfq13, 15, titleBaseLine + 8 * 25, paint);
                canvas.drawText("14. Accomplished less than you would like ", 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("              " + ssfq14, 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("15. Were limited in the kind of work or other activities.", 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("              " + ssfq15, 15, titleBaseLine + 12 * 25, paint);
                canvas.drawText("16. Had difficulty performing the work or other activities (for example, it took extra effort).", 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("              " + ssfq16, 15, titleBaseLine + 14 * 25, paint);

                paint.setTextSize(20);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                canvas.drawText("Emotional Health Problems ", 15, titleBaseLine + 15 * 25 + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                paint.setTextSize(10);
                canvas.drawText("During the past 4 weeks, have you had any of the following problems with your work or other regular daily activities as a result of", 15, titleBaseLine + 16 * 25, paint);
                canvas.drawText("any emotional problems (such as feeling depressed or anxious)? ", 15, titleBaseLine + 17 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                canvas.drawText("17. Cut down the amount of time you spent on work or other activities", 15, titleBaseLine + 18 * 25, paint);
                canvas.drawText("              " + ssfq17, 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("18. Accomplished less than you would like. ", 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("              " + ssfq18, 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("19. Didn't do work or other activities as carefully as usual.", 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("              " + ssfq19, 15, titleBaseLine + 23 * 25, paint);

                paint.setTextSize(20);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                canvas.drawText("Social Activities", 15, titleBaseLine + 24 * 25 + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("20. Emotional problems interfered with your normal social activities with family, friends, neighbors or groups?", 15, titleBaseLine + 25 * 25, paint);
                canvas.drawText("              " + ssfq20, 15, titleBaseLine + 26 * 25, paint);



            } else if (pagenumber == 3) {
                paint.setTextSize(20);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                canvas.drawText("Pain: ", 15, titleBaseLine + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("21. How much bodily pain have you had during the past 4 weeks?", 15, titleBaseLine + 1 * 25, paint);
                canvas.drawText("              " + ssfq21, 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("22. During the past 4 weeks, how much did pain interfere with your normal work (including both work outside", 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("the home and housework)?", 15, titleBaseLine + 4 * 25, paint);
                canvas.drawText("              " + ssfq22, 15, titleBaseLine + 5 * 25, paint);

                paint.setTextSize(20);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                canvas.drawText("Energy and Emotions ", 15, titleBaseLine + 6 * 25, paint);
                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("These questions are about how you feel and how things have been during the last 4 weeks. For each question, please give the answer", 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("that comes closest to the way you have been feeling. ", 15, titleBaseLine + 8 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                canvas.drawText("23. Did you feel full of pep? ", 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("              " + ssfq23, 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("24. Have you been a very nervous person? ", 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("              " + ssfq24, 15, titleBaseLine + 12 * 25, paint);
                canvas.drawText("25. Have you felt so down in the dumps that nothing could cheer you up?", 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("              " + ssfq25, 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("26. Have you felt calm and peaceful?", 15, titleBaseLine + 15 * 25, paint);
                canvas.drawText("              " + ssfq26, 15, titleBaseLine + 16 * 25, paint);
                canvas.drawText("27. Did you have a lot of energy?", 15, titleBaseLine + 17 * 25, paint);
                canvas.drawText("              " + ssfq27, 15, titleBaseLine + 18 * 25, paint);
                canvas.drawText("28. Have you felt downhearted and blue?", 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("              " + ssfq28, 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("29. Did you feel worn out?", 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("              " + ssfq29, 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("30. Have you been a happy person?", 15, titleBaseLine + 23 * 25, paint);
                canvas.drawText("              " + ssfq30, 15, titleBaseLine + 24 * 25, paint);
                canvas.drawText("31. Did you feel tired?", 15, titleBaseLine + 25 * 25, paint);
                canvas.drawText("              " + ssfq31, 15, titleBaseLine + 26 * 25, paint);



            }

            else if (pagenumber == 4) {
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Social Activities ", 15, titleBaseLine + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("32. During the past 4 weeks, how much of the time has your physical health or emotional problems interfered with", 15, titleBaseLine + 1 * 25, paint);
                canvas.drawText("your social activities (like visiting with friends, relatives, etc.)? ", 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("              " + ssfq32, 15, titleBaseLine + 3 * 25, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("General Health", 15, titleBaseLine + 4 * 25 + 5, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                paint.setTextSize(10);
                canvas.drawText("How true or false is each of the following statements for you? ", 15, titleBaseLine + 5 * 25, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                canvas.drawText("33. I seem to get sick a little easier than other people.",15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("              " + ssfq33, 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("34. I am as healthy as anybody I know", 15, titleBaseLine + 8 * 25, paint);
                canvas.drawText("              " + ssfq34, 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("35. I expect my health to get worse.", 8, titleBaseLine + 10 * 25, paint);
                canvas.drawText("              " + ssfq25, 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("36. My health is excellent.", 8, titleBaseLine + 12 * 25, paint);
                canvas.drawText("              " + ssfq36, 15, titleBaseLine + 13 * 25, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(18);
                canvas.drawText("Physical functioning: " + String.format("%.2f", physicalfunction), 15, titleBaseLine + 18 * 25, paint);
                canvas.drawText("Role Limitations due to physical health: " + String.format("%.2f", limitation_due_to_physical_health), 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("Role Limitations due to emotional problems: " + String.format("%.2f", limitation_due_to_emotional_problem), 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("Energy/ Fatigue: " + String.format("%.2f", energy_fatigue), 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("Emotional Well-Being: " + String.format("%.2f", emotional_wellbeing), 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("Social Functioning: " + String.format("%.2f", social_functioning), 15, titleBaseLine + 23 * 25, paint);
                canvas.drawText("Pain: " + String.format("%.2f", pain), 15, titleBaseLine + 24 * 25, paint);
                canvas.drawText("General Health: " + String.format("%.2f", generalhealth), 15, titleBaseLine + 25 * 25, paint);

            }


        }

    }

    public void printDocument(View view) {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " SF36_Questionnaire" + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " SF36 Questionnaire " + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("SF-36 Questionnaire");

        // Generate column headings
        Row rowQ = sheet1.createRow(0);
        Row rowA = sheet1.createRow(1);


        Q = rowQ.createCell(0);
        Q.setCellValue("Patient ID");
        A = rowA.createCell(0);
        A.setCellValue(PatID);

        Q = rowQ.createCell(1);
        Q.setCellValue("Date");
        A = rowA.createCell(1);
        A.setCellValue(Date);

        Q = rowQ.createCell(2);
        Q.setCellValue("Session");
        A = rowA.createCell(2);
        A.setCellValue("ADM");

        Q = rowQ.createCell(3);
        Q.setCellValue("sf1");
        A = rowA.createCell(3);
        A.setCellValue(ssfq1);

        Q = rowQ.createCell(4);
        Q.setCellValue("sf2");
        A = rowA.createCell(4);
        A.setCellValue(ssfq2);

        Q = rowQ.createCell(5);
        Q.setCellValue("sf3");
        A = rowA.createCell(5);
        A.setCellValue(ssfq3);

        Q = rowQ.createCell(6);
        Q.setCellValue("sf4");
        A = rowA.createCell(6);
        A.setCellValue(ssfq4);

        Q = rowQ.createCell(7);
        Q.setCellValue("sf5");
        A = rowA.createCell(7);
        A.setCellValue(ssfq5);

        Q = rowQ.createCell(8);
        Q.setCellValue("sf6");
        A = rowA.createCell(8);
        A.setCellValue(ssfq6);

        Q = rowQ.createCell(9);
        Q.setCellValue("sf7");
        A = rowA.createCell(9);
        A.setCellValue(ssfq7);

        Q = rowQ.createCell(10);
        Q.setCellValue("sf8");
        A = rowA.createCell(10);
        A.setCellValue(ssfq8);

        Q = rowQ.createCell(11);
        Q.setCellValue("sf9");
        A = rowA.createCell(11);
        A.setCellValue(ssfq9);

        Q = rowQ.createCell(12);
        Q.setCellValue("sf10");
        A = rowA.createCell(12);
        A.setCellValue(ssfq10);

        Q = rowQ.createCell(13);
        Q.setCellValue("sf11");
        A = rowA.createCell(13);
        A.setCellValue(ssfq11);

        Q = rowQ.createCell(14);
        Q.setCellValue("sf12");
        A = rowA.createCell(14);
        A.setCellValue(ssfq12);

        Q = rowQ.createCell(15);
        Q.setCellValue("sf13");
        A = rowA.createCell(15);
        A.setCellValue(ssfq13);

        Q = rowQ.createCell(16);
        Q.setCellValue("sf14");
        A = rowA.createCell(16);
        A.setCellValue(ssfq14);

        Q = rowQ.createCell(17);
        Q.setCellValue("sf15");
        A = rowA.createCell(17);
        A.setCellValue(ssfq15);

        Q = rowQ.createCell(18);
        Q.setCellValue("sf16");
        A = rowA.createCell(18);
        A.setCellValue(ssfq16);

        Q = rowQ.createCell(19);
        Q.setCellValue("sf17");
        A = rowA.createCell(19);
        A.setCellValue(ssfq17);

        Q = rowQ.createCell(20);
        Q.setCellValue("sf18");
        A = rowA.createCell(20);
        A.setCellValue(ssfq18);

        Q = rowQ.createCell(21);
        Q.setCellValue("sf19");
        A = rowA.createCell(21);
        A.setCellValue(ssfq19);

        Q = rowQ.createCell(22);
        Q.setCellValue("sf20");
        A = rowA.createCell(22);
        A.setCellValue(ssfq20);

        Q = rowQ.createCell(23);
        Q.setCellValue("sf21");
        A = rowA.createCell(23);
        A.setCellValue(ssfq21);

        Q = rowQ.createCell(24);
        Q.setCellValue("sf22");
        A = rowA.createCell(24);
        A.setCellValue(ssfq22);

        Q = rowQ.createCell(25);
        Q.setCellValue("sf23");
        A = rowA.createCell(25);
        A.setCellValue(ssfq23);

        Q = rowQ.createCell(26);
        Q.setCellValue("sf24");
        A = rowA.createCell(26);
        A.setCellValue(ssfq24);

        Q = rowQ.createCell(27);
        Q.setCellValue("sf25");
        A = rowA.createCell(27);
        A.setCellValue(ssfq25);

        Q = rowQ.createCell(28);
        Q.setCellValue("sf26");
        A = rowA.createCell(28);
        A.setCellValue(ssfq26);

        Q = rowQ.createCell(29);
        Q.setCellValue("sf27");
        A = rowA.createCell(29);
        A.setCellValue(ssfq27);

        Q = rowQ.createCell(30);
        Q.setCellValue("sf28");
        A = rowA.createCell(30);
        A.setCellValue(ssfq28);

        Q = rowQ.createCell(31);
        Q.setCellValue("sf29");
        A = rowA.createCell(31);
        A.setCellValue(ssfq29);

        Q = rowQ.createCell(32);
        Q.setCellValue("sf30");
        A = rowA.createCell(32);
        A.setCellValue(ssfq30);

        Q = rowQ.createCell(33);
        Q.setCellValue("sf31");
        A = rowA.createCell(33);
        A.setCellValue(ssfq31);

        Q = rowQ.createCell(34);
        Q.setCellValue("sf32");
        A = rowA.createCell(34);
        A.setCellValue(ssfq32);

        Q = rowQ.createCell(35);
        Q.setCellValue("sf33");
        A = rowA.createCell(35);
        A.setCellValue(ssfq33);

        Q = rowQ.createCell(36);
        Q.setCellValue("sf34");
        A = rowA.createCell(36);
        A.setCellValue(ssfq34);

        Q = rowQ.createCell(37);
        Q.setCellValue("sf35");
        A = rowA.createCell(37);
        A.setCellValue(ssfq35);

        Q = rowQ.createCell(38);
        Q.setCellValue("sf36");
        A = rowA.createCell(38);
        A.setCellValue(ssfq36);

        Q = rowQ.createCell(39);
        Q.setCellValue("Physical_function");
        A = rowA.createCell(39);
        A.setCellValue(physicalfunction);

        Q = rowQ.createCell(40);
        Q.setCellValue("Limitation_due_to_physical_health");
        A = rowA.createCell(40);
        A.setCellValue(limitation_due_to_physical_health);

        Q = rowQ.createCell(41);
        Q.setCellValue("Limitation_due_to_emotional_problen");
        A = rowA.createCell(41);
        A.setCellValue(limitation_due_to_emotional_problem);

        Q = rowQ.createCell(42);
        Q.setCellValue("Energy_fatigue");
        A = rowA.createCell(42);
        A.setCellValue(energy_fatigue);

        Q = rowQ.createCell(43);
        Q.setCellValue("emotional_wellbeing");
        A = rowA.createCell(43);
        A.setCellValue(emotional_wellbeing);

        Q = rowQ.createCell(44);
        Q.setCellValue("social_functioning");
        A = rowA.createCell(44);
        A.setCellValue(social_functioning);

        Q = rowQ.createCell(45);
        Q.setCellValue("pain");
        A = rowA.createCell(45);
        A.setCellValue(pain);

        Q = rowQ.createCell(46);
        Q.setCellValue("generalhealth");
        A = rowA.createCell(46);
        A.setCellValue(generalhealth);
        //continue with questions


        File[] fs = context.getExternalFilesDirs(null); // Retrieving device external storage directory
        String extPath = ""; // Creating empty string that is defined below

// at index 0 you have the internal storage and at index 1 the real external SD card...
        if (fs != null && fs.length >= 2)
        {
            extPath = fs[1].getPath(); //Defining path string
            // at index 0 you have the internal storage and at index 1 (fs[1]) the real external SD card...
            Log.e("SD Path",fs[1].getPath());

        }

        File file = new File(extPath, fileName);

        // Create a path where we will place our List of objects on external storage
       // File file = new File(Environment.getExternalStorageDirectory() + "/My Documents", fileName);
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(file);
            wb.write(os);
            Log.w("FileUtils", "Writing file" + file);
            Toast toast1 = Toast.makeText(getApplicationContext(), "Excel Generated", Toast.LENGTH_SHORT);
            toast1.show();
            success = true;
        } catch (IOException e) {
            Log.w("FileUtils", "Error writing " + file, e);
            Toast toast1 = Toast.makeText(getApplicationContext(), "Error writing", Toast.LENGTH_SHORT);
            toast1.show();
        } catch (Exception e) {
            Log.w("FileUtils", "Failed to save file", e);
            Toast toast1 = Toast.makeText(getApplicationContext(), "Failed to save file", Toast.LENGTH_SHORT);
            toast1.show();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception ex) {
            }
        }

        return success;
    }


}
