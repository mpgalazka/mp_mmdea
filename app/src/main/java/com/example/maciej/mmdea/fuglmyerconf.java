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
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.graphics.pdf.PdfDocument.PageInfo;
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
import java.util.Objects;


public class fuglmyerconf extends AppCompatActivity{


    double FMSE, FMWH, total, Q1a, Q1b, Q2a, Q2b, Q2c, Q2d, Q2e, Q2f, Q3a, Q3b, Q3c, Q4a, Q4b, Q4c, Q5a, Q5b, Q5c, Q6a,
            Q7a, Q8a, Q9a, Q10a, Q11a, Q12a, Q12b, Q13a, Q14a, Q14b, Q14c, Q14d, Q15a, Q15b, Q15c, TimeE1, TimeE2, TimeDiff;

    String PatID, Date, Event, Session;

    JSONObject record;

    HttpResponse response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuglmyerconf);



        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }



        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");
        Q1a = Answers.getDoubleExtra("Q1a", 0);
        Q1b = Answers.getDoubleExtra("Q1b", 0);
        Q2a = Answers.getDoubleExtra("Q2a", 0);
        Q2b = Answers.getDoubleExtra("Q2b", 0);
        Q2c = Answers.getDoubleExtra("Q2c", 0);
        Q2d = Answers.getDoubleExtra("Q2d", 0);
        Q2e = Answers.getDoubleExtra("Q2e", 0);
        Q2f = Answers.getDoubleExtra("Q2f", 0);
        Q3a = Answers.getDoubleExtra("Q3a", 0);
        Q3b = Answers.getDoubleExtra("Q3b", 0);
        Q3c = Answers.getDoubleExtra("Q3c", 0);
        Q4a = Answers.getDoubleExtra("Q4a", 0);
        Q4b = Answers.getDoubleExtra("Q4b", 0);
        Q4c = Answers.getDoubleExtra("Q4c", 0);
        Q5a = Answers.getDoubleExtra("Q5a", 0);
        Q5b = Answers.getDoubleExtra("Q5b", 0);
        Q5c = Answers.getDoubleExtra("Q5c", 0);
        Q6a = Answers.getDoubleExtra("Q6a", 0);
        Q7a = Answers.getDoubleExtra("Q7a", 0);
        Q8a = Answers.getDoubleExtra("Q8a", 0);
        Q9a = Answers.getDoubleExtra("Q9a", 0);
        Q10a = Answers.getDoubleExtra("Q10a", 0);
        Q11a = Answers.getDoubleExtra("Q11a", 0);
        Q12a = Answers.getDoubleExtra("Q12a", 0);
        Q12b = Answers.getDoubleExtra("Q12b", 0);
        Q13a = Answers.getDoubleExtra("Q13a", 0);
        Q14a = Answers.getDoubleExtra("Q14a", 0);
        Q14b = Answers.getDoubleExtra("Q14b", 0);
        Q14c = Answers.getDoubleExtra("Q14c", 0);
        Q14d = Answers.getDoubleExtra("Q14d", 0);
        Q15a = Answers.getDoubleExtra("Q15a", 0);
        Q15b = Answers.getDoubleExtra("Q15b", 0);
        Q15c = Answers.getDoubleExtra("Q15c", 0);
        FMSE = Answers.getDoubleExtra("FMSE", 0);
        FMWH = Answers.getDoubleExtra("FMWH", 0);
        total = Answers.getDoubleExtra("total", 0);
        TimeE1 = Answers.getDoubleExtra("TimeE1", TimeE1)/1000;
        TimeE2 = Answers.getDoubleExtra("TimeE2", TimeE2)/1000;
        TimeDiff = Answers.getDoubleExtra("TimeDiff", TimeDiff);



        if (Objects.equals("pp1_arm_1", Event)){
            Session = "PP1";
        } else if (Objects.equals("pp2_arm_1", Event)){
            Session = "PP2";
        } else if (Objects.equals("dc_arm_1", Event)){
            Session = "DC";
        }else if (Objects.equals("mp_arm_1", Event)){
            Session = "MP";
        }else if (Objects.equals("fu_arm_1", Event)){
            Session = "FU";
        }else if (Objects.equals("adm_arm_1", Event)){
            Session = "ADM";
        }



        ((TextView)findViewById(R.id.conDate)).setText("Date: " + Date);
        ((TextView)findViewById(R.id.conPatID)).setText(PatID);
        ((TextView)findViewById(R.id.conSession)).setText(Session);
        ((TextView)findViewById(R.id.conQ1a)).setText(String.valueOf(Q1a));
        ((TextView)findViewById(R.id.conQ1b)).setText(String.valueOf(Q1b));
        ((TextView)findViewById(R.id.conQ2a)).setText(String.valueOf(Q2a));
        ((TextView)findViewById(R.id.conQ2b)).setText(String.valueOf(Q2b));
        ((TextView)findViewById(R.id.conQ2c)).setText(String.valueOf(Q2c));
        ((TextView)findViewById(R.id.conQ2d)).setText(String.valueOf(Q2d));
        ((TextView)findViewById(R.id.conQ2e)).setText(String.valueOf(Q2e));
        ((TextView)findViewById(R.id.conQ2f)).setText(String.valueOf(Q2f));
        ((TextView)findViewById(R.id.conQ3a)).setText(String.valueOf(Q3a));
        ((TextView)findViewById(R.id.conQ3b)).setText(String.valueOf(Q3b));
        ((TextView)findViewById(R.id.conQ3c)).setText(String.valueOf(Q3c));
        ((TextView)findViewById(R.id.conQ4a)).setText(String.valueOf(Q4a));
        ((TextView)findViewById(R.id.conQ4b)).setText(String.valueOf(Q4b));
        ((TextView)findViewById(R.id.conQ4c)).setText(String.valueOf(Q4c));
        ((TextView)findViewById(R.id.conQ5a)).setText(String.valueOf(Q5a));
        ((TextView)findViewById(R.id.conQ5b)).setText(String.valueOf(Q5b));
        ((TextView)findViewById(R.id.conQ5c)).setText(String.valueOf(Q5c));
        ((TextView)findViewById(R.id.conQ6a)).setText(String.valueOf(Q6a));
        ((TextView)findViewById(R.id.conQ7a)).setText(String.valueOf(Q7a));
        ((TextView)findViewById(R.id.conQ8a)).setText(String.valueOf(Q8a));
        ((TextView)findViewById(R.id.conQ9a)).setText(String.valueOf(Q9a));
        ((TextView)findViewById(R.id.conQ10a)).setText(String.valueOf(Q10a));
        ((TextView)findViewById(R.id.conQ11a)).setText(String.valueOf(Q11a));
        ((TextView)findViewById(R.id.conQ12a)).setText(String.valueOf(Q12a));
        ((TextView)findViewById(R.id.conQ12b)).setText(String.valueOf(Q12b));
        ((TextView)findViewById(R.id.conQ13a)).setText(String.valueOf(Q13a));
        ((TextView)findViewById(R.id.conQ14a)).setText(String.valueOf(Q14a));
        ((TextView)findViewById(R.id.conQ14b)).setText(String.valueOf(Q14b));
        ((TextView)findViewById(R.id.conQ14c)).setText(String.valueOf(Q14c));
        ((TextView)findViewById(R.id.conQ14d)).setText(String.valueOf(Q14d));
        ((TextView)findViewById(R.id.conQ15a)).setText(String.valueOf(Q15a));
        ((TextView)findViewById(R.id.conQ15b)).setText(String.valueOf(Q15b));
        ((TextView)findViewById(R.id.conQ15c)).setText(String.valueOf(Q15c));
        ((TextView)findViewById(R.id.conFMSE)).setText(String.valueOf(FMSE));
        ((TextView)findViewById(R.id.conFMWH)).setText(String.valueOf(FMWH));
        ((TextView)findViewById(R.id.conTotal)).setText(String.valueOf(total));

        ((TextView)findViewById(R.id.TimeDiff)).setText(String.format("%.3f", TimeDiff) + " seconds");
        ((TextView)findViewById(R.id.TimeE1)).setText(String.format("%.3f", TimeE1) + " seconds");
        ((TextView)findViewById(R.id.TimeE2)).setText(String.format("%.3f", TimeE2) + " seconds");



        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("q1a", Q1a);
        record.put("q1b", Q1b);
        record.put("q2a", Q2a);
        record.put("q2b", Q2b);
        record.put("q2c", Q2c);
        record.put("q2d", Q2d);
        record.put("q2e", Q2e);
        record.put("q2f", Q2f);
        record.put("q3a", Q3a);
        record.put("q3b", Q3b);
        record.put("q3c", Q3c);
        record.put("q4a", Q4a);
        record.put("q4b", Q4b);
        record.put("q4c", Q4c);
        record.put("q5a", Q5a);
        record.put("q5b", Q5b);
        record.put("q5c", Q5c);
        record.put("q6a", Q6a);
        record.put("q7a", Q7a);
        record.put("q8a", Q8a);
        record.put("q9a", Q9a);
        record.put("q10a", Q10a);
        record.put("q11a", Q11a);
        record.put("q12a", Q12a);
        record.put("q12b", Q12b);
        record.put("q13a", Q13a);
        record.put("q14a", Q14a);
        record.put("q14b", Q14b);
        record.put("q14c", Q14c);
        record.put("q14d", Q14d);
        record.put("q15a", Q15a);
        record.put("q15b", Q15b);
        record.put("q15c", Q15c);
        record.put("fmse", FMSE);
        record.put("fmwh", FMWH);
        record.put("total", total);

        record.put("timeright", String.format("%.3f", TimeE1) + " seconds");
        record.put("timeleft", String.format("%.3f", TimeE2) + " seconds");
        record.put("timediff", String.format("%.3f", TimeDiff) + " seconds");
        record.put("redcap_event_name", Event);

        record.put("fugl_meyer_complete", "2");


    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Fugl-Meyer");
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
                                Intent PID = new Intent(fuglmyerconf.this, Forms.class);
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

        HttpClient httpClient = new DefaultHttpClient(httpParameters);
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
        public int totalpages = 3;

        public MyPrintDocumentAdapter(Context context)
        {
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
                if (pageInRange(pageRanges, i))
                {
                    PageInfo newPage = new PageInfo.Builder(pageWidth,
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

        private boolean pageInRange(PageRange[] pageRanges, int page)
        {
            for (int i = 0; i<pageRanges.length; i++)
            {
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


            if (pagenumber == 1){

                //Spacing between end of question and start of new question is 30, spacing between each description is 13 and spacing between each subquestion is 2*13


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("Upper Extremity Fugl-Meyer Scale", leftMargin, titleBaseLine - 2, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("FM/SE", 15, titleBaseLine + 130, paint);
                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 35, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 2 * 35 + 25, paint);

                canvas.drawText("1. Reflexes", 15, titleBaseLine + 155, paint);
                canvas.drawText("2. Flexor Synergy", 15, titleBaseLine + 263, paint);
                canvas.drawText("3. Extensor Synergy", 15, titleBaseLine + 488, paint);
                canvas.drawText("4. Mixed Synergy", 15, titleBaseLine + 635, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = no reflex elicited", 15, titleBaseLine + 155 + 13, paint);
                canvas.drawText("2 = reflex elicited", 15, titleBaseLine + 155 + 2 * 13, paint);

                canvas.drawText("0 = cannot perform", 15, titleBaseLine + 263 + 13, paint);
                canvas.drawText("1 = performs partly", 15, titleBaseLine + 263 + 2 * 13, paint);
                canvas.drawText("2 = performs faultlessly", 15, titleBaseLine + 263 + 3 * 13, paint);

                canvas.drawText("0 = cannot perform", 15, titleBaseLine + 488 + 13, paint);
                canvas.drawText("1 = performs partly", 15, titleBaseLine + 488 + 2 * 13, paint);
                canvas.drawText("2 = performs faultlessly", 15, titleBaseLine + 488 + 3 * 13, paint);

                canvas.drawText("0 = synergy begins at onset", 15, titleBaseLine + 635 + 13, paint);
                canvas.drawText("1 = synergy begins later in movement", 15, titleBaseLine + 635 + 2 * 13, paint);
                canvas.drawText("2 = no synergy", 15, titleBaseLine + 635 + 3 * 13, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                //Question 1
                canvas.drawText("a. Biceps of Finger Flexors = " + Q1a, 30, titleBaseLine + 155 + 4*13, paint);
                canvas.drawText("b. Triceps = " + Q1b, 30, titleBaseLine + 155 + 6 * 13, paint);
                //Question 2
                canvas.drawText("a. Retraction = " + Q2a, 30, titleBaseLine + 263 + 5 * 13, paint);
                canvas.drawText("b. Elevation = " + Q2b,30, titleBaseLine + 263 + 7 * 13, paint);
                canvas.drawText("c. Abduction = " + Q2c,30, titleBaseLine + 263 + 9 * 13, paint);
                canvas.drawText("d. External Rotation = " + Q2d, 30, titleBaseLine + 263 + 11 * 13, paint);
                canvas.drawText("e. Elbow Flexion = " + Q2e,30, titleBaseLine + 263 + 13 * 13, paint);
                canvas.drawText("f. Forearm Supination = " + Q2f,30, titleBaseLine + 263 + 15 * 13, paint);
                //Question 3
                canvas.drawText("a. Adduction and Internal Rotation = " + Q3a,30, titleBaseLine + 488 + 5 * 13, paint);
                canvas.drawText("b. Elbow Extension = " + Q3b,30, titleBaseLine + 488 + 7 * 13, paint);
                canvas.drawText("c. Forearm Pronation = " + Q3c,30, titleBaseLine + 488 + 9 * 13, paint);







            }

            else if (pagenumber == 2){

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("FM/WH", 15, titleBaseLine + 324, paint);

                paint.setTextSize(14);
                canvas.drawText("5, Isolated Movement Without Synergy", 15, titleBaseLine + 82, paint);
                canvas.drawText("6. Normal Reflex Activity", 15, titleBaseLine + 229, paint);
                //fmhw
                canvas.drawText("1. Wrist Flexion / Extension With Shoulder at 0, Elbow at 90 = " + Q7a, 15, titleBaseLine + 354, paint);
                canvas.drawText("2. Wrist Stability With Elbow at 90 = " + Q8a, 15, titleBaseLine + 423, paint);
                canvas.drawText("3. Wrist Flexion / Extension With Shoulder at 30-90, Elbow at 0 = " + Q9a, 15, titleBaseLine + 492, paint);
                canvas.drawText("4. Wrist Stability With Shoulder 30-90, Elbow at 0 = " + Q10a, 15, titleBaseLine + 561, paint);
                canvas.drawText("5. Wrist Circumduction With Shoulder at 0, Elbow at 90 = " + Q11a, 15, titleBaseLine + 630, paint);



                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = synergy begins at onset", 15, titleBaseLine + 82 + 13, paint);
                canvas.drawText("1 = synergy begins later in movement", 15, titleBaseLine + 82 + 2 * 13, paint);
                canvas.drawText("2 = no synergy", 15, titleBaseLine + 82 + 3 * 13, paint);

                canvas.drawText("0 = 2+ reflexes hyperactive", 15, titleBaseLine + 229 + 13, paint);
                canvas.drawText("1 = 1 reflex hyperactive", 15, titleBaseLine + 229 + 2 * 13, paint);
                canvas.drawText("2 = no reflex hyperactive", 15, titleBaseLine + 229 + 3 * 13, paint);

                canvas.drawText("0 = no volitional movement", 15, titleBaseLine + 354 + 13, paint);
                canvas.drawText("1 = partial movement", 15, titleBaseLine + 354 + 2 * 13, paint);
                canvas.drawText("2 = full, controlled movement", 15, titleBaseLine + 354 + 3 * 13, paint);

                canvas.drawText("0 = unable to extend wrist to 15", 15, titleBaseLine + 423 + 13, paint);
                canvas.drawText("1 = extend wrist to 15 without resistance", 15, titleBaseLine + 423 + 2 * 13, paint);
                canvas.drawText("2 = extend wrist to 15 with resistance", 15, titleBaseLine + 423 + 3 * 13, paint);

                canvas.drawText("0 = no volitional movement", 15, titleBaseLine + 492 + 13, paint);
                canvas.drawText("1 = partial movement", 15, titleBaseLine + 492 + 2 * 13, paint);
                canvas.drawText("2 = full, controlled movement", 15, titleBaseLine + 492 + 3 * 13, paint);

                canvas.drawText("0 = unable to extend wrist to 15", 15, titleBaseLine + 561 + 13, paint);
                canvas.drawText("1 = extend wrist to 15 without resistance", 15, titleBaseLine + 561 + 2 * 13, paint);
                canvas.drawText("2 = extend wrist to 15 with resistance", 15, titleBaseLine + 561 + 3 * 13, paint);

                canvas.drawText("0 = no volitional movement", 15, titleBaseLine + 630 + 13, paint);
                canvas.drawText("1 = partial movement", 15, titleBaseLine + 630 + 2 * 13, paint);
                canvas.drawText("2 = full, controlled movement", 15, titleBaseLine + 630 + 3 * 13, paint);



                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                //Question 4
                canvas.drawText("a. Hand To Lumbar Spine = " + Q4a, 30, titleBaseLine , paint);
                canvas.drawText("b. Shoulder Flexion To 90 With Extended Elbow = " + Q4b,30, titleBaseLine + 2 * 13, paint);
                canvas.drawText("c. Forearm Supination / Pronation With Elbow At 90 = " + Q4c, 30, titleBaseLine + 4 * 13, paint);

                //Question 5
                canvas.drawText("a. Shoulder Abduction To 90 With Extended Elbow = " + Q5a, 30, titleBaseLine + 82 + 5 * 13, paint);
                canvas.drawText("b. Shoulder Flexion 90-180 With Extended Elbow = " + Q5b,30, titleBaseLine + 82 + 7 * 13, paint);
                canvas.drawText("c. Forearm Supination / Pronation With Elbow Extended = " + Q5c, 30, titleBaseLine + 82 + 9 * 13, paint);

                //Question 6


                canvas.drawText("a. Biceps, Finger Flexors, Triceps = " + Q6a, 30, titleBaseLine + 229 + 5 * 13, paint);





            }
            else if (pagenumber == 3){


                paint.setTextSize(14);
                canvas.drawText("6. Fingers", 15, titleBaseLine, paint);
                canvas.drawText("7. PIP-DIP Hook Grasp = " + Q13a, 15, titleBaseLine + 121, paint);
                canvas.drawText("8. Functional Hand Use", 15, titleBaseLine + 190, paint);
                canvas.drawText("9. Coordination and Speed", 15, titleBaseLine + 363, paint);






                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = cannot perform", 15, titleBaseLine + 13, paint);
                canvas.drawText("1 = performs partially", 15, titleBaseLine + 2 * 13, paint);
                canvas.drawText("2 = performs faultlessly", 15, titleBaseLine + 3 * 13, paint);

                canvas.drawText("0 = unable", 15, titleBaseLine + 121 + 13, paint);
                canvas.drawText("1 = performs without resistance", 15, titleBaseLine + 121 + 2 * 13, paint);
                canvas.drawText("2 = performs with resistance", 15, titleBaseLine + 121 + 3 * 13, paint);

                canvas.drawText("0 = unable", 15, titleBaseLine + 190 + 13, paint);
                canvas.drawText("1 = holds with slight tug", 15, titleBaseLine + 190 + 2 * 13, paint);
                canvas.drawText("2 = holds firmly with tug", 15, titleBaseLine + 190 + 3 * 13, paint);

                canvas.drawText("0 = marked tremor", 15, titleBaseLine + 363 + 3 * 13, paint);
                canvas.drawText("1 = slight tremor", 15, titleBaseLine + 363 + 4 * 13, paint);
                canvas.drawText("2 = no tremor", 15, titleBaseLine + 363 + 5 * 13, paint);

                canvas.drawText("0 = marked dysmetria", 15, titleBaseLine + 363 + 8 * 13, paint);
                canvas.drawText("1 = slight dysmetria", 15, titleBaseLine + 363 + 9 * 13, paint);
                canvas.drawText("2 = no dysmetria", 15, titleBaseLine + 363 + 10 * 13, paint);

                canvas.drawText("0 = greater than 6 second difference", 15, titleBaseLine + 363 + 13 * 13, paint);
                canvas.drawText("1 = 2-5 second difference", 15, titleBaseLine + 363 + 14 * 13, paint);
                canvas.drawText("2 = less than 2 second difference", 15, titleBaseLine + 363 + 15 * 13, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                //Question 6 new
                canvas.drawText("a. Mass Flexion = " + Q12a,30, titleBaseLine + 5 * 13, paint);
                canvas.drawText("b. Mass Extension = " + Q12b, 30, titleBaseLine + 7 * 13, paint);
                //Question 8 new
                canvas.drawText("a. Thumb Abduction With Paper = " + Q14a, 30, titleBaseLine + 190 + 5 * 13, paint);
                canvas.drawText("b. Pincer Grasp With Pencil = " + Q14b, 30, titleBaseLine + 190 + 7 * 13, paint);
                canvas.drawText("c. Cylinder Grasp With Small Can = " + Q14c,30, titleBaseLine + 190 + 9 * 13, paint);
                canvas.drawText("d. Spherical Grasp With Tennis Ball = " + Q14d,30, titleBaseLine + 190 + 11 * 13, paint);

                //9 new
                canvas.drawText("a. Tremor = " + Q15a, 30, titleBaseLine + 363 + 2 * 13, paint);
                canvas.drawText("b. Dysmetria = " + Q15b, 30, titleBaseLine + 363 + 7 * 13, paint);
                canvas.drawText("c. Time = " + Q15c,30, titleBaseLine + 363 + 12 * 13, paint);

                canvas.drawText("Time Right = " + String.format("%.3f", TimeE1) + " seconds",30, titleBaseLine + 363 + 17 * 13, paint);
                canvas.drawText("Time Left = " + String.format("%.3f", TimeE2) + " seconds",30, titleBaseLine + 363 + 18 * 13, paint);
                canvas.drawText("Time Difference = " + String.format("%.3f", TimeDiff) + " seconds",30, titleBaseLine + 363 + 19 * 13, paint);

                paint.setTextSize(25);
                canvas.drawText("         FM/SE = " + FMSE + "     FM/WH = " + FMWH + "     Total = " + total, 15, titleBaseLine + 363 + 22 * 13, paint);





            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Fugl Meyer " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Fugl Meyer " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Fugl Meyer");

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
        A.setCellValue(Session);
        //continue with questions

        Q = rowQ.createCell(3);
        Q.setCellValue("Q1a");
        A = rowA.createCell(3);
        A.setCellValue(Q1a);

        Q = rowQ.createCell(4);
        Q.setCellValue("Q1b");
        A = rowA.createCell(4);
        A.setCellValue(Q1b);

        Q = rowQ.createCell(5);
        Q.setCellValue("Q2a");
        A = rowA.createCell(5);
        A.setCellValue(Q2a);

        Q = rowQ.createCell(6);
        Q.setCellValue("Q2b");
        A = rowA.createCell(6);
        A.setCellValue(Q2b);

        Q = rowQ.createCell(7);
        Q.setCellValue("Q2c");
        A = rowA.createCell(7);
        A.setCellValue(Q2c);

        Q = rowQ.createCell(8);
        Q.setCellValue("Q2d");
        A = rowA.createCell(8);
        A.setCellValue(Q2d);

        Q = rowQ.createCell(9);
        Q.setCellValue("Q2e");
        A = rowA.createCell(9);
        A.setCellValue(Q2e);

        Q = rowQ.createCell(10);
        Q.setCellValue("Q2f");
        A = rowA.createCell(10);
        A.setCellValue(Q2f);

        Q = rowQ.createCell(11);
        Q.setCellValue("Q3a");
        A = rowA.createCell(11);
        A.setCellValue(Q3a);

        Q = rowQ.createCell(12);
        Q.setCellValue("Q3b");
        A = rowA.createCell(12);
        A.setCellValue(Q3b);

        Q = rowQ.createCell(13);
        Q.setCellValue("Q3c");
        A = rowA.createCell(13);
        A.setCellValue(Q3c);

        Q = rowQ.createCell(14);
        Q.setCellValue("Q4a");
        A = rowA.createCell(14);
        A.setCellValue(Q4a);

        Q = rowQ.createCell(15);
        Q.setCellValue("Q4b");
        A = rowA.createCell(15);
        A.setCellValue(Q4b);

        Q = rowQ.createCell(16);
        Q.setCellValue("Q4c");
        A = rowA.createCell(16);
        A.setCellValue(Q4c);

        Q = rowQ.createCell(17);
        Q.setCellValue("Q5a");
        A = rowA.createCell(17);
        A.setCellValue(Q5a);

        Q = rowQ.createCell(18);
        Q.setCellValue("Q5b");
        A = rowA.createCell(18);
        A.setCellValue(Q5b);

        Q = rowQ.createCell(19);
        Q.setCellValue("Q5c");
        A = rowA.createCell(19);
        A.setCellValue(Q5c);


        Q = rowQ.createCell(20);
        Q.setCellValue("Q6a");
        A = rowA.createCell(20);
        A.setCellValue(Q6a);



        Q = rowQ.createCell(21);
        Q.setCellValue("Q7a");
        A = rowA.createCell(21);
        A.setCellValue(Q7a);

        Q = rowQ.createCell(22);
        Q.setCellValue("Q8a");
        A = rowA.createCell(22);
        A.setCellValue(Q8a);

        Q = rowQ.createCell(23);
        Q.setCellValue("Q9a");
        A = rowA.createCell(23);
        A.setCellValue(Q9a);

        Q = rowQ.createCell(24);
        Q.setCellValue("Q10a");
        A = rowA.createCell(24);
        A.setCellValue(Q10a);

        Q = rowQ.createCell(25);
        Q.setCellValue("Q11a");
        A = rowA.createCell(25);
        A.setCellValue(Q11a);

        Q = rowQ.createCell(26);
        Q.setCellValue("Q12a");
        A = rowA.createCell(26);
        A.setCellValue(Q12a);

        Q = rowQ.createCell(27);
        Q.setCellValue("Q12b");
        A = rowA.createCell(27);
        A.setCellValue(Q12b);

        Q = rowQ.createCell(28);
        Q.setCellValue("Q13a");
        A = rowA.createCell(28);
        A.setCellValue(Q13a);

        Q = rowQ.createCell(29);
        Q.setCellValue("Q14a");
        A = rowA.createCell(29);
        A.setCellValue(Q14a);

        Q = rowQ.createCell(30);
        Q.setCellValue("Q14b");
        A = rowA.createCell(30);
        A.setCellValue(Q14b);

        Q = rowQ.createCell(31);
        Q.setCellValue("Q14c");
        A = rowA.createCell(31);
        A.setCellValue(Q14c);

        Q = rowQ.createCell(32);
        Q.setCellValue("Q14d");
        A = rowA.createCell(32);
        A.setCellValue(Q14d);

        Q = rowQ.createCell(33);
        Q.setCellValue("Q15a");
        A = rowA.createCell(33);
        A.setCellValue(Q15a);

        Q = rowQ.createCell(34);
        Q.setCellValue("Q15b");
        A = rowA.createCell(34);
        A.setCellValue(Q15b);

        Q = rowQ.createCell(35);
        Q.setCellValue("Q15c");
        A = rowA.createCell(35);
        A.setCellValue(Q15c);

        Q = rowQ.createCell(36);
        Q.setCellValue("Time Right");
        A = rowA.createCell(36);
        A.setCellValue(TimeE1);

        Q = rowQ.createCell(37);
        Q.setCellValue("Time Left");
        A = rowA.createCell(37);
        A.setCellValue(TimeE2);

        Q = rowQ.createCell(38);
        Q.setCellValue("TimeDiff");
        A = rowA.createCell(38);
        A.setCellValue(TimeDiff);

        Q = rowQ.createCell(39);
        Q.setCellValue("FMSE");
        A = rowA.createCell(39);
        A.setCellValue(FMSE);

        Q = rowQ.createCell(40);
        Q.setCellValue("FMWH");
        A = rowA.createCell(40);
        A.setCellValue(FMWH);


        Q = rowQ.createCell(41);
        Q.setCellValue("total");
        A = rowA.createCell(41);
        A.setCellValue(total);

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
        //File file = new File(Environment.getExternalStorageDirectory() + "/My Documents", fileName);
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

