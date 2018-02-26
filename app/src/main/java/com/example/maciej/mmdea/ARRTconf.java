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
import android.text.TextUtils;
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
import java.util.Objects;

public class ARRTconf extends AppCompatActivity {

    String PatID, Date, Event, Session,
            AARTTime1, AARTTime2, AARTTime3, AARTTime4, AARTTime5, AARTTime6, AARTTime7, AARTTime8, AARTTime9,
            AARTTime10, AARTTime11, AARTTime12, AARTTime13, AARTTime14, AARTTime15, AARTTime16, AARTTime17, AARTTime18, AARTTime19;

    JSONObject record;

    HttpResponse response;

    double  AARTQA1, AARTQA2, AARTQA3, AARTQA4, AARTQA5, AARTQA6,
            AARTQB1, AARTQB2, AARTQB3, AARTQB4,
            AARTQC1, AARTQC2, AARTQC3, AARTQC4, AARTQC5, AARTQC6,
            AARTQD1, AARTQD2, AARTQD3,


    AARTQA, AARTQB, AARTQC, AARTQD, AARTQTotal
            ;

    String[] comments;
    ArrayList Affected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrtconf);


        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }
        
        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");


        AARTQA1 = Answers.getDoubleExtra("AARTQA1", 0);
        AARTQA2 = Answers.getDoubleExtra("AARTQA2", 0);
        AARTQA3 = Answers.getDoubleExtra("AARTQA3", 0);
        AARTQA4 = Answers.getDoubleExtra("AARTQA4", 0);
        AARTQA5 = Answers.getDoubleExtra("AARTQA5", 0);
        AARTQA6 = Answers.getDoubleExtra("AARTQA6", 0);

        AARTQB1 = Answers.getDoubleExtra("AARTQB1", 0);
        AARTQB2 = Answers.getDoubleExtra("AARTQB2", 0);
        AARTQB3 = Answers.getDoubleExtra("AARTQB3", 0);
        AARTQB4 = Answers.getDoubleExtra("AARTQB4", 0);

        AARTQC1 = Answers.getDoubleExtra("AARTQC1", 0);
        AARTQC2 = Answers.getDoubleExtra("AARTQC2", 0);
        AARTQC3 = Answers.getDoubleExtra("AARTQC3", 0);
        AARTQC4 = Answers.getDoubleExtra("AARTQC4", 0);
        AARTQC5 = Answers.getDoubleExtra("AARTQC5", 0);
        AARTQC6 = Answers.getDoubleExtra("AARTQC6", 0);

        AARTQD1 = Answers.getDoubleExtra("AARTQD1", 0);
        AARTQD2 = Answers.getDoubleExtra("AARTQD2", 0);
        AARTQD3 = Answers.getDoubleExtra("AARTQD3", 0);

        AARTQA = Answers.getDoubleExtra("AARTQA", 0);
        AARTQB = Answers.getDoubleExtra("AARTQB", 0);
        AARTQC = Answers.getDoubleExtra("AARTQC", 0);
        AARTQD = Answers.getDoubleExtra("AARTQD", 0);
        AARTQTotal = Answers.getDoubleExtra("AARTQTotal", 0);

        AARTTime1 = Answers.getStringExtra("AARTTime1");
        AARTTime2 = Answers.getStringExtra("AARTTime2");
        AARTTime3 = Answers.getStringExtra("AARTTime3");
        AARTTime4 = Answers.getStringExtra("AARTTime4");
        AARTTime5 = Answers.getStringExtra("AARTTime5");
        AARTTime6 = Answers.getStringExtra("AARTTime6");
        AARTTime7 = Answers.getStringExtra("AARTTime7");
        AARTTime8 = Answers.getStringExtra("AARTTime8");
        AARTTime9 = Answers.getStringExtra("AARTTime9");
        AARTTime10 = Answers.getStringExtra("AARTTime10");
        AARTTime11 = Answers.getStringExtra("AARTTime11");
        AARTTime12 = Answers.getStringExtra("AARTTime12");
        AARTTime13 = Answers.getStringExtra("AARTTime13");
        AARTTime14 = Answers.getStringExtra("AARTTime14");
        AARTTime15 = Answers.getStringExtra("AARTTime15");
        AARTTime16 = Answers.getStringExtra("AARTTime16");
        AARTTime17 = Answers.getStringExtra("AARTTime17");
        AARTTime18 = Answers.getStringExtra("AARTTime18");
        AARTTime19 = Answers.getStringExtra("AARTTime19");


        comments = Answers.getStringArrayExtra("comments");
        Affected = Answers.getCharSequenceArrayListExtra("Affected");


        if (Objects.equals(null, AARTTime1)) {
            AARTTime1 = "0.000";
        }
        if (Objects.equals(null, AARTTime2)) {
            AARTTime2 = "0.000";
        }
        if (Objects.equals(null, AARTTime3)) {
            AARTTime3 = "0.000";
        }
        if (Objects.equals(null, AARTTime4)) {
            AARTTime4 = "0.000";
        }
        if (Objects.equals(null, AARTTime5)) {
            AARTTime5 = "0.000";
        }
        if (Objects.equals(null, AARTTime6)) {
            AARTTime6 = "0.000";
        }
        if (Objects.equals(null, AARTTime7)) {
            AARTTime7 = "0.000";
        }
        if (Objects.equals(null, AARTTime8)) {
            AARTTime8 = "0.000";
        }
        if (Objects.equals(null, AARTTime9)) {
            AARTTime9 = "0.000";
        }
        if (Objects.equals(null, AARTTime10)) {
            AARTTime10 = "0.000";
        }
        if (Objects.equals(null, AARTTime11)) {
            AARTTime11 = "0.000";
        }
        if (Objects.equals(null, AARTTime12)) {
            AARTTime12 = "0.000";
        }
        if (Objects.equals(null, AARTTime13)) {
            AARTTime13 = "0.000";
        }
        if (Objects.equals(null, AARTTime14)) {
            AARTTime14 = "0.000";
        }
        if (Objects.equals(null, AARTTime15)) {
            AARTTime15 = "0.000";
        }
        if (Objects.equals(null, AARTTime16)) {
            AARTTime16 = "0.000";
        }
        if (Objects.equals(null, AARTTime17)) {
            AARTTime17 = "0.000";
        }
        if (Objects.equals(null, AARTTime18)) {
            AARTTime18 = "0.000";
        }
        if (Objects.equals(null, AARTTime19)) {
            AARTTime19 = "0.000";
        }





        if (Objects.equals("fu_arm_1", Event)){
            Session = "FU";
        } else if (Objects.equals("adm_arm_1", Event)){
            Session = "ADM";
        } else if (Objects.equals("dc_arm_1", Event)){
            Session = "DC";
        } else if (Objects.equals("mp_arm_1", Event)){
            Session = "MP";
        }

        ((TextView) findViewById(R.id.conDate)).setText("Date: " + Date);
        ((TextView) findViewById(R.id.conPatID)).setText(PatID);
        ((TextView) findViewById(R.id.conSession)).setText(Session);


        ((TextView) findViewById(R.id.AARTQA1)).setText(String.valueOf(AARTQA1));
        ((TextView) findViewById(R.id.AARTQA2)).setText(String.valueOf(AARTQA2));
        ((TextView) findViewById(R.id.AARTQA3)).setText(String.valueOf(AARTQA3));
        ((TextView) findViewById(R.id.AARTQA4)).setText(String.valueOf(AARTQA4));
        ((TextView) findViewById(R.id.AARTQA5)).setText(String.valueOf(AARTQA5));
        ((TextView) findViewById(R.id.AARTQA6)).setText(String.valueOf(AARTQA6));

        ((TextView) findViewById(R.id.AARTQB1)).setText(String.valueOf(AARTQB1));
        ((TextView) findViewById(R.id.AARTQB2)).setText(String.valueOf(AARTQB2));
        ((TextView) findViewById(R.id.AARTQB3)).setText(String.valueOf(AARTQB3));
        ((TextView) findViewById(R.id.AARTQB4)).setText(String.valueOf(AARTQB4));

        ((TextView) findViewById(R.id.AARTQC1)).setText(String.valueOf(AARTQC1));
        ((TextView) findViewById(R.id.AARTQC2)).setText(String.valueOf(AARTQC2));
        ((TextView) findViewById(R.id.AARTQC3)).setText(String.valueOf(AARTQC3));
        ((TextView) findViewById(R.id.AARTQC4)).setText(String.valueOf(AARTQC4));
        ((TextView) findViewById(R.id.AARTQC5)).setText(String.valueOf(AARTQC5));
        ((TextView) findViewById(R.id.AARTQC6)).setText(String.valueOf(AARTQC6));

        ((TextView) findViewById(R.id.AARTQD1)).setText(String.valueOf(AARTQD1));
        ((TextView) findViewById(R.id.AARTQD2)).setText(String.valueOf(AARTQD2));
        ((TextView) findViewById(R.id.AARTQD3)).setText(String.valueOf(AARTQD3));

        ((TextView) findViewById(R.id.ARRTA)).setText(String.valueOf(AARTQA));
        ((TextView) findViewById(R.id.ARRTB)).setText(String.valueOf(AARTQB));
        ((TextView) findViewById(R.id.ARRTC)).setText(String.valueOf(AARTQC));
        ((TextView) findViewById(R.id.ARRTD)).setText(String.valueOf(AARTQD));
        ((TextView) findViewById(R.id.ARRTTotal)).setText(String.valueOf(AARTQTotal));



        ((TextView) findViewById(R.id.AARTTime1)).setText(String.valueOf(AARTTime1));
        ((TextView) findViewById(R.id.AARTTime2)).setText(String.valueOf(AARTTime2));
        ((TextView) findViewById(R.id.AARTTime3)).setText(String.valueOf(AARTTime3));
        ((TextView) findViewById(R.id.AARTTime4)).setText(String.valueOf(AARTTime4));
        ((TextView) findViewById(R.id.AARTTime5)).setText(String.valueOf(AARTTime5));
        ((TextView) findViewById(R.id.AARTTime6)).setText(String.valueOf(AARTTime6));
        ((TextView) findViewById(R.id.AARTTime7)).setText(String.valueOf(AARTTime7));
        ((TextView) findViewById(R.id.AARTTime8)).setText(String.valueOf(AARTTime8));
        ((TextView) findViewById(R.id.AARTTime9)).setText(String.valueOf(AARTTime9));
        ((TextView) findViewById(R.id.AARTTime10)).setText(String.valueOf(AARTTime10));
        ((TextView) findViewById(R.id.AARTTime11)).setText(String.valueOf(AARTTime11));
        ((TextView) findViewById(R.id.AARTTime12)).setText(String.valueOf(AARTTime12));
        ((TextView) findViewById(R.id.AARTTime13)).setText(String.valueOf(AARTTime13));
        ((TextView) findViewById(R.id.AARTTime14)).setText(String.valueOf(AARTTime14));
        ((TextView) findViewById(R.id.AARTTime15)).setText(String.valueOf(AARTTime15));
        ((TextView) findViewById(R.id.AARTTime16)).setText(String.valueOf(AARTTime16));
        ((TextView) findViewById(R.id.AARTTime17)).setText(String.valueOf(AARTTime17));
        ((TextView) findViewById(R.id.AARTTime18)).setText(String.valueOf(AARTTime18));
        ((TextView) findViewById(R.id.AARTTime19)).setText(String.valueOf(AARTTime19));

        ((TextView) findViewById(R.id.affected)).setText(TextUtils.join(", ", Affected));
        ((TextView) findViewById(R.id.comments)).setText(TextUtils.join(" ", comments));



        record = new JSONObject();
        record.put("record_id", PatID);

        record.put("aratimp", TextUtils.join(", ", Affected));
        record.put("aratcomments", TextUtils.join(" ", comments));


        record.put("aratqa1t", AARTQA1);
        record.put("aratqa2t", AARTQA2);
        record.put("aratqa3t", AARTQA3);
        record.put("aratqa4t", AARTQA4);
        record.put("aratqa5t", AARTQA5);
        record.put("aratqa6t", AARTQA6);
        
        record.put("aratqb1t", AARTQB1);
        record.put("aratqb2t", AARTQB2);
        record.put("aratqb3t", AARTQB3);
        record.put("aratqb4t", AARTQB4);
        
        record.put("aratqc1t", AARTQC1);
        record.put("aratqc2t", AARTQC2);
        record.put("aratqc3t", AARTQC3);
        record.put("aratqc4t", AARTQC4);
        record.put("aratqc5t", AARTQC5);
        record.put("aratqc6t", AARTQC6);
        
        record.put("aratqd1t", AARTQD1);
        record.put("aratqd2t", AARTQD2);
        record.put("aratqd3t", AARTQD3);



        record.put("aratqa1s", AARTTime1);
        record.put("aratqa2s", AARTTime2);
        record.put("aratqa3s", AARTTime3);
        record.put("aratqa4s", AARTTime4);
        record.put("aratqa5s", AARTTime5);
        record.put("aratqa6s", AARTTime6);
        record.put("aratqb1s", AARTTime7);
        record.put("aratqb2s", AARTTime8);
        record.put("aratqb3s", AARTTime9);
        record.put("aratqb4s", AARTTime10);
        record.put("aratqc1s", AARTTime11);
        record.put("aratqc2s", AARTTime12);
        record.put("aratqc3s", AARTTime13);
        record.put("aratqc4s", AARTTime14);
        record.put("aratqc5s", AARTTime15);
        record.put("aratqc6s", AARTTime16);
        record.put("aratqd1s", AARTTime17);
        record.put("aratqd2s", AARTTime18);
        record.put("aratqd3s", AARTTime19);


        record.put("aratqatotal", AARTQA);
        record.put("aratqbtotal", AARTQB);
        record.put("aratqctotal", AARTQC);
        record.put("aratqdtotal", AARTQD);

        record.put("arattotal", AARTQTotal);






        record.put("redcap_event_name", Event);

        record.put("action_research_arm_test_complete", "2");


    }


    //Return to Forms List

    public void ReturnToForms(View view) {
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Action Research Arm Test");
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
                                Intent PID = new Intent(ARRTconf.this, Forms.class);
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

    public void UploadREDCap(View view) {

        response = null;


        makePostRequest();

        if (response == null) {
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
        public int totalpages = 3;

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
                canvas.drawText("Action Research Arm Test", leftMargin + 55, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(10);
                canvas.drawText("A. 5 Finger Grip", 15, titleBaseLine + 357, paint);
                canvas.drawText("Time (s)", 15 + pageWidth / 4 + 30, titleBaseLine + 357, paint);
                canvas.drawText("Time Cut-Off Right/Left", 15 + 2 * pageWidth / 4, titleBaseLine + 357, paint);
                canvas.drawText("Score", 15 + 3 * pageWidth / 4 + 50, titleBaseLine + 357, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 35, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 3 * 32, paint);
                canvas.drawText("Impaired Limb: " + TextUtils.join(", ", Affected), 15, titleBaseLine + 4 * 32, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);

                canvas.drawText("1. Block 10cm", 15, titleBaseLine + 357 + 20, paint);
                canvas.drawText(" (If score = 3 then total A = 18", 15, titleBaseLine + 357 + 20 + 13, paint);
                canvas.drawText("go to subset B.)", 15, titleBaseLine + 357 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime1, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 357 + 20 + 13, paint);
                canvas.drawText("4.1/4.3 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 357 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA1), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 357 + 20 + 13, paint);



                canvas.drawText("2. Block 2.5cm", 15, titleBaseLine + 407 + 20, paint);
                canvas.drawText("(If score = 0 then total A = 0", 15, titleBaseLine + 407 + 20 + 13, paint);
                canvas.drawText("go to subset B.)", 15, titleBaseLine + 407 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime2, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 407 + 20 + 13, paint);
                canvas.drawText("3.6/3.5 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 407 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA2), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 407 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 457 + 20, paint);
                canvas.drawText("3. Block 5 cm", 15, titleBaseLine + 457 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 457 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime3, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 457 + 20 + 13, paint);
                canvas.drawText("3.6/3.5 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 457 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA3), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 457 + 20 + 13, paint);


                canvas.drawText("", 15, titleBaseLine + 507 + 20, paint);
                canvas.drawText("4. Block 7.5 cm", 15, titleBaseLine + 507 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 507 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime4, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 507 + 20 + 13, paint);
                canvas.drawText("3.8/3.9 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 507 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA4), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 507 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 557 + 20, paint);
                canvas.drawText("5. Ball", 15, titleBaseLine + 557 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 557 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime5, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 557 + 20 + 13, paint);
                canvas.drawText("3.7/3.9 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 557 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA5), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 557 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 607 + 20, paint);
                canvas.drawText("6. Metal Rectangle", 15, titleBaseLine + 607 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 607 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime6, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 607 + 20 + 13, paint);
                canvas.drawText("3.5/3.8 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 607 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQA6), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 607 + 20 + 13, paint);

                canvas.drawText("Total A Section: " + AARTQA, 15, titleBaseLine + 657 + 20, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC));
                canvas.drawText("Instruction: ", 15, titleBaseLine + 158, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("There are four subtests: Grasp, Grip, Pinch, Gross Movement. Items in each are ordered so that:", 15, titleBaseLine + 158 + 13, paint);
                canvas.drawText("• If the subject passes the first,(scored a 3) no more need to be administered and he scores top marks for that subtest;", 30, titleBaseLine + 158 + 2 * 13, paint);
                canvas.drawText("• If the subject fails the first and fails the second, he scores zero, and again no more tests need to be performed that subtest; All", 30, titleBaseLine + 158 + 3 * 13, paint);
                canvas.drawText("tests are timed with stopwatch", 30, titleBaseLine + 158 + 4 * 13, paint);

                canvas.drawText("• otherwise he needs to complete all tasks within the subtest", 30, titleBaseLine + 158 + 5 * 13, paint);
                canvas.drawText("Scoring:", 50, titleBaseLine + 158 + 6 * 13, paint);
                canvas.drawText("3 = Performs test normally", 100, titleBaseLine + 158 + 7 * 13, paint);
                canvas.drawText("2 = Completes test, but takes abnormally long or has great difficulty", 100, titleBaseLine + 158 + 8 * 13, paint);
                canvas.drawText("1 = Performs test partially", 100, titleBaseLine + 158 + 9 * 13, paint);
                canvas.drawText("0 = Can perform no part of the test", 100, titleBaseLine + 158 + 10 * 13, paint);

                canvas.drawText("Time: enter the amount of time it takes the subject to freeform. The maximum amount of time is 60 sec. If the subject cannot", 15, titleBaseLine + 158 + 12 * 13, paint);
                canvas.drawText("perform the task 60 sec is entered in time", 15, titleBaseLine + 158 + 13 * 13, paint);



            } else if (pagenumber == 2) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(10);
                canvas.drawText("B. Cylindrical Grasp", 15, titleBaseLine, paint);
                canvas.drawText("Time (s)", 15 + pageWidth / 4 + 30, titleBaseLine, paint);
                canvas.drawText("Time Cut-Off Right/Left", 15 + 2 * pageWidth / 4, titleBaseLine, paint);
                canvas.drawText("Score", 15 + 3 * pageWidth / 4 + 50, titleBaseLine, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);

                canvas.drawText("1. Cup with water", 15, titleBaseLine + 20, paint);
                canvas.drawText(" (If score = 3 then total B = 12", 15, titleBaseLine + 20 + 13, paint);
                canvas.drawText("go to subset C.)", 15, titleBaseLine + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime7, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 20 + 13, paint);
                canvas.drawText("7.8/7.9 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQB1), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 20 + 13, paint);



                canvas.drawText("2. Tube 2.5cm", 15, titleBaseLine + 50 + 20, paint);
                canvas.drawText("(If score = 0 then total B = 0", 15, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText("go to subset C.)", 15, titleBaseLine + 50 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime8, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText("4.1/4.2 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQB2), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 50 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 100 + 20, paint);
                canvas.drawText("3. Tube 1 cm", 15, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 100 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime9, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText("4.1/4.4 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQB3), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 100 + 20 + 13, paint);


                canvas.drawText("", 15, titleBaseLine + 150 + 20, paint);
                canvas.drawText("4. Ring (3.5 cm) with synthetic", 15, titleBaseLine + 150 + 20 + 13, paint);
                canvas.drawText("hold", 15, titleBaseLine + 150 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime10, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 150 + 20 + 13, paint);
                canvas.drawText("3.9/4.1 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 150 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQB4), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 150 + 20 + 13, paint);

                canvas.drawText("Total B Section: " + AARTQB, 15, titleBaseLine + 200 + 20, paint);



                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(10);
                canvas.drawText("C. Pincer Grip", 15, titleBaseLine + 270, paint);
                canvas.drawText("Time (s)", 15 + pageWidth / 4 + 30, titleBaseLine + 270, paint);
                canvas.drawText("Time Cut-Off Right/Left", 15 + 2 * pageWidth / 4, titleBaseLine + 270, paint);
                canvas.drawText("Score", 15 + 3 * pageWidth / 4 + 50, titleBaseLine + 270, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("1.  Ball bearing, 6mm, 3rd", 15, titleBaseLine + 270 + 20, paint);
                canvas.drawText("(thumb ring-finger)(If score = 3", 15, titleBaseLine + 270 + 20 + 13, paint);
                canvas.drawText("then total c = 18 go to subset D.)", 15, titleBaseLine + 270 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime11, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 270 + 20 + 13, paint);
                canvas.drawText("4.4/4.5 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 270 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC1), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 270 + 20 + 13, paint);



                canvas.drawText("2. Marble, 1.5cm, (thumb to", 15, titleBaseLine + 320 + 20, paint);
                canvas.drawText("index finger)(If score = 0 then", 15, titleBaseLine + 320 + 20 + 13, paint);
                canvas.drawText("total C = 0 go to subset D.)", 15, titleBaseLine + 320 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime12, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 320 + 20 + 13, paint);
                canvas.drawText("3.9/3.7 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 320 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC2), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 320 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 370 + 20, paint);
                canvas.drawText("3. Marble 1.5 cm", 15, titleBaseLine + 370 + 20 + 13, paint);
                canvas.drawText("(thumb and middle finger)", 15, titleBaseLine + 370 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime13, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 370 + 20 + 13, paint);
                canvas.drawText("3.8/3.9 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 370 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC3), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 370 + 20 + 13, paint);


                canvas.drawText("", 15, titleBaseLine + 420 + 20, paint);
                canvas.drawText("4. Marble 1.5 cm", 15, titleBaseLine + 420 + 20 + 13, paint);
                canvas.drawText("(thumb and ring finger)", 15, titleBaseLine + 420 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime14, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 420 + 20 + 13, paint);
                canvas.drawText("3.8/4.2 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 420 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC4), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 420 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 470 + 20, paint);
                canvas.drawText("5. Ball bearing 6 mm", 15, titleBaseLine + 470 + 20 + 13, paint);
                canvas.drawText("(thumb-index finger)", 15, titleBaseLine + 470 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime15, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 470 + 20 + 13, paint);
                canvas.drawText("3.8/4.2 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 470 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC5), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 470 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 520 + 20, paint);
                canvas.drawText("6. Ball bearing 6 mm", 15, titleBaseLine + 520 + 20 + 13, paint);
                canvas.drawText("(thumb-middle finger)", 15, titleBaseLine + 520 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime16, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 520 + 20 + 13, paint);
                canvas.drawText("4.0/4.1 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 520 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQC6), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 520 + 20 + 13, paint);

                canvas.drawText("Total C Section: " + AARTQC, 15, titleBaseLine + 570 + 20, paint);


            }

            else if (pagenumber == 3) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(10);
                canvas.drawText("D. Gross Movements", 15, titleBaseLine, paint);
                canvas.drawText("Time (s)", 15 + pageWidth / 4 + 30, titleBaseLine, paint);
                canvas.drawText("Time Cut-Off Right/Left", 15 + 2 * pageWidth / 4, titleBaseLine, paint);
                canvas.drawText("Score", 15 + 3 * pageWidth / 4 + 50, titleBaseLine, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);

                canvas.drawText("1. Hand to back of head", 15, titleBaseLine + 20, paint);
                canvas.drawText("(If score = 3 then total D = 9;", 15, titleBaseLine + 20 + 13, paint);
                canvas.drawText("end test)", 15, titleBaseLine + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime17, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 20 + 13, paint);
                canvas.drawText("2.6/2.8 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQD1), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 20 + 13, paint);



                canvas.drawText("2. Hand to mouth", 15, titleBaseLine + 50 + 20, paint);
                canvas.drawText("(If score = 0 then total D = 0;", 15, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText("end test)", 15, titleBaseLine + 50 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime18, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText("2.4/2.5 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 50 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQD2), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 50 + 20 + 13, paint);



                canvas.drawText("", 15, titleBaseLine + 100 + 20, paint);
                canvas.drawText("3. Hand on top of head", 15, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText("", 15, titleBaseLine + 100 + 20 + 2 * 13, paint);

                canvas.drawText(AARTTime19, 15 + pageWidth / 4 + 30 + 5, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText("2.6/2.8 sec", 15 + 2 * pageWidth / 4 + 38, titleBaseLine + 100 + 20 + 13, paint);
                canvas.drawText(String.valueOf(AARTQD3), 15 + 3 * pageWidth / 4 + 50 + 10, titleBaseLine + 100 + 20 + 13, paint);

                canvas.drawText("Total D Section: " + AARTQD, 15, titleBaseLine + 150 + 20, paint);

                canvas.drawText("Total Score on ARA Test: " + AARTQTotal, 15, titleBaseLine + 200 + 20, paint);


                canvas.drawText("Comments: ", 15, titleBaseLine + 270, paint);
                for (int i = 0; i < comments.length; i++) {
                    canvas.drawText(comments[i], 15, titleBaseLine + 282 + 12 * i, paint);
                }
            }
            }

        }




    public void printDocument(View view) {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Action Research Arm Test " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }


    // Excel Stuff Below

    public void Excel(View view) {

        saveExcelFile(this, PatID + " Action Research Arm Test " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Action Research Arm Test");

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

        Q = rowQ.createCell(3);
        Q.setCellValue("Impaired Limb");
        A = rowA.createCell(3);
        A.setCellValue(TextUtils.join(", ", Affected));

        Q = rowQ.createCell(4);
        Q.setCellValue("A1");
        A = rowA.createCell(4);
        A.setCellValue(AARTQA1);

        Q = rowQ.createCell(5);
        Q.setCellValue("Time A1");
        A = rowA.createCell(5);
        A.setCellValue(AARTTime1);

        Q = rowQ.createCell(6);
        Q.setCellValue("A2");
        A = rowA.createCell(6);
        A.setCellValue(AARTQA2);

        Q = rowQ.createCell(7);
        Q.setCellValue("Time A2");
        A = rowA.createCell(7);
        A.setCellValue(AARTTime2);

        Q = rowQ.createCell(8);
        Q.setCellValue("A3");
        A = rowA.createCell(8);
        A.setCellValue(AARTQA3);

        Q = rowQ.createCell(9);
        Q.setCellValue("Time A3");
        A = rowA.createCell(9);
        A.setCellValue(AARTTime3);

        Q = rowQ.createCell(10);
        Q.setCellValue("A4");
        A = rowA.createCell(10);
        A.setCellValue(AARTQA4);

        Q = rowQ.createCell(11);
        Q.setCellValue("Time A4");
        A = rowA.createCell(11);
        A.setCellValue(AARTTime4);

        Q = rowQ.createCell(12);
        Q.setCellValue("A5");
        A = rowA.createCell(12);
        A.setCellValue(AARTQA5);

        Q = rowQ.createCell(13);
        Q.setCellValue("Time A5");
        A = rowA.createCell(13);
        A.setCellValue(AARTTime5);

        Q = rowQ.createCell(14);
        Q.setCellValue("A6");
        A = rowA.createCell(14);
        A.setCellValue(AARTQA6);

        Q = rowQ.createCell(15);
        Q.setCellValue("Time A6");
        A = rowA.createCell(15);
        A.setCellValue(AARTTime6);


        Q = rowQ.createCell(16);
        Q.setCellValue("Total A Section");
        A = rowA.createCell(16);
        A.setCellValue(AARTQA);


        Q = rowQ.createCell(17);
        Q.setCellValue("B1");
        A = rowA.createCell(17);
        A.setCellValue(AARTQB1);

        Q = rowQ.createCell(18);
        Q.setCellValue("Time B1");
        A = rowA.createCell(18);
        A.setCellValue(AARTTime7);

        Q = rowQ.createCell(19);
        Q.setCellValue("B2");
        A = rowA.createCell(19);
        A.setCellValue(AARTQB2);

        Q = rowQ.createCell(20);
        Q.setCellValue("Time B2");
        A = rowA.createCell(20);
        A.setCellValue(AARTTime8);

        Q = rowQ.createCell(21);
        Q.setCellValue("B3");
        A = rowA.createCell(21);
        A.setCellValue(AARTQB3);

        Q = rowQ.createCell(22);
        Q.setCellValue("Time B3");
        A = rowA.createCell(22);
        A.setCellValue(AARTTime9);

        Q = rowQ.createCell(23);
        Q.setCellValue("B4");
        A = rowA.createCell(23);
        A.setCellValue(AARTQB4);

        Q = rowQ.createCell(24);
        Q.setCellValue("Time B4");
        A = rowA.createCell(24);
        A.setCellValue(AARTTime10);

        Q = rowQ.createCell(25);
        Q.setCellValue("Total B Section");
        A = rowA.createCell(25);
        A.setCellValue(AARTQB);


        Q = rowQ.createCell(26);
        Q.setCellValue("C1");
        A = rowA.createCell(26);
        A.setCellValue(AARTQC1);

        Q = rowQ.createCell(27);
        Q.setCellValue("Time C1");
        A = rowA.createCell(27);
        A.setCellValue(AARTTime11);

        Q = rowQ.createCell(28);
        Q.setCellValue("C2");
        A = rowA.createCell(28);
        A.setCellValue(AARTQC2);

        Q = rowQ.createCell(29);
        Q.setCellValue("Time C2");
        A = rowA.createCell(29);
        A.setCellValue(AARTTime12);

        Q = rowQ.createCell(30);
        Q.setCellValue("C3");
        A = rowA.createCell(30);
        A.setCellValue(AARTQC3);

        Q = rowQ.createCell(31);
        Q.setCellValue("Time C3");
        A = rowA.createCell(31);
        A.setCellValue(AARTTime13);

        Q = rowQ.createCell(32);
        Q.setCellValue("C4");
        A = rowA.createCell(32);
        A.setCellValue(AARTQC4);

        Q = rowQ.createCell(33);
        Q.setCellValue("Time C4");
        A = rowA.createCell(33);
        A.setCellValue(AARTTime14);

        Q = rowQ.createCell(34);
        Q.setCellValue("C5");
        A = rowA.createCell(34);
        A.setCellValue(AARTQC5);

        Q = rowQ.createCell(35);
        Q.setCellValue("Time C5");
        A = rowA.createCell(35);
        A.setCellValue(AARTTime15);

        Q = rowQ.createCell(36);
        Q.setCellValue("C6");
        A = rowA.createCell(36);
        A.setCellValue(AARTQC6);

        Q = rowQ.createCell(37);
        Q.setCellValue("Time C6");
        A = rowA.createCell(37);
        A.setCellValue(AARTTime16);

        Q = rowQ.createCell(38);
        Q.setCellValue("Total C Section");
        A = rowA.createCell(38);
        A.setCellValue(AARTQC);



        Q = rowQ.createCell(39);
        Q.setCellValue("D1");
        A = rowA.createCell(39);
        A.setCellValue(AARTQD1);

        Q = rowQ.createCell(40);
        Q.setCellValue("Time D1");
        A = rowA.createCell(40);
        A.setCellValue(AARTTime17);

        Q = rowQ.createCell(41);
        Q.setCellValue("D2");
        A = rowA.createCell(41);
        A.setCellValue(AARTQD2);

        Q = rowQ.createCell(42);
        Q.setCellValue("Time D2");
        A = rowA.createCell(42);
        A.setCellValue(AARTTime18);

        Q = rowQ.createCell(43);
        Q.setCellValue("D3");
        A = rowA.createCell(43);
        A.setCellValue(AARTQD3);

        Q = rowQ.createCell(44);
        Q.setCellValue("Time D3");
        A = rowA.createCell(44);
        A.setCellValue(AARTTime19);


        Q = rowQ.createCell(45);
        Q.setCellValue("Total D Section");
        A = rowA.createCell(45);
        A.setCellValue(AARTQD);

        Q = rowQ.createCell(46);
        Q.setCellValue("Total Score on ARA Test");
        A = rowA.createCell(46);
        A.setCellValue(AARTQTotal);


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
