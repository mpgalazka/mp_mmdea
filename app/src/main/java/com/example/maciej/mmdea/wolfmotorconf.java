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
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
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

public class wolfmotorconf extends AppCompatActivity {


    double WolfmotorQ1, WolfmotorQ2, WolfmotorQ3, WolfmotorQ4, WolfmotorQ5, WolfmotorQ6, WolfmotorQ8, WolfmotorQ9, WolfmotorQ10,
            WolfmotorQ11, WolfmotorQ12, WolfmotorQ13, WolfmotorQ14, WolfmotorQ15, WolfmotorQ16, WolfmotorQ17, WolfmotorQTotal, WolfmotorQTotalwithweight,
            handboxweight1, Wolfmotortimetotal,
            Time1, Time2, Time3, Time4, Time5, Time6, Time7, Time8, Time9, Time10, Time11, Time12, Time13, Time14, Time15,
            wolfmotortime1, wolfmotortime2, wolfmotortime3, wolfmotortime4, wolfmotortime5, wolfmotortime6, wolfmotortime7, wolfmotortime8, wolfmotortime9, wolfmotortime10, wolfmotortime11, wolfmotortime12, wolfmotortime13, wolfmotortime14, wolfmotortime15;


    String PatID, Date, Event, Session, affected1, unaffected1,WolfmotorQ7,WolfmotorQ14r, WolfmotorQ14l,numleft1a, numleft2a, numleft3a, avgleft, avgright, numright1a, numright2a, numright3a;

    JSONObject record;

    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolfmotorconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }



        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");
        affected1 = Answers.getStringExtra("affected");
        unaffected1 = Answers.getStringExtra("unaffected");
        WolfmotorQ7 = Answers.getStringExtra("WolfmotorQ7");
        WolfmotorQ14r = Answers.getStringExtra("WolfmotorQ14r");
        WolfmotorQ14l = Answers.getStringExtra("WolfmotorQ14l");

        numleft1a = Answers.getStringExtra("numleft1");
        numleft2a = Answers.getStringExtra("numleft2");
        numleft3a = Answers.getStringExtra("numleft3");
        numright1a = Answers.getStringExtra("numright1");
        numright2a = Answers.getStringExtra("numright2");
        numright3a = Answers.getStringExtra("numright3");

        WolfmotorQ1 = Answers.getDoubleExtra("WolfmotorQ1", 0);
        WolfmotorQ2 = Answers.getDoubleExtra("WolfmotorQ2", 0);
        WolfmotorQ3 = Answers.getDoubleExtra("WolfmotorQ3", 0);
        WolfmotorQ4 = Answers.getDoubleExtra("WolfmotorQ4", 0);
        WolfmotorQ5 = Answers.getDoubleExtra("WolfmotorQ5", 0);
        WolfmotorQ6 = Answers.getDoubleExtra("WolfmotorQ6", 0);
        WolfmotorQ8 = Answers.getDoubleExtra("WolfmotorQ8", 0);
        WolfmotorQ9 = Answers.getDoubleExtra("WolfmotorQ9", 0);
        WolfmotorQ10 = Answers.getDoubleExtra("WolfmotorQ10", 0);
        WolfmotorQ11 = Answers.getDoubleExtra("WolfmotorQ11", 0);
        WolfmotorQ12 = Answers.getDoubleExtra("WolfmotorQ12", 0);
        WolfmotorQ13 = Answers.getDoubleExtra("WolfmotorQ13", 0);
        WolfmotorQ15 = Answers.getDoubleExtra("WolfmotorQ15", 0);
        WolfmotorQ16 = Answers.getDoubleExtra("WolfmotorQ16", 0);
        WolfmotorQ17 = Answers.getDoubleExtra("WolfmotorQ17", 0);
        WolfmotorQTotal = Answers.getDoubleExtra("WolfmotorQTotal", 0);
        handboxweight1 = Answers.getDoubleExtra("WolfmotorQ7",0);
        Time1 = Answers.getDoubleExtra("wolfmotortime1",0);
        Time2 = Answers.getDoubleExtra("wolfmotortime2",0);
        Time3 = Answers.getDoubleExtra("wolfmotortime3",0);
        Time4 = Answers.getDoubleExtra("wolfmotortime4",0);
        Time5 = Answers.getDoubleExtra("wolfmotortime5",0);
        Time6 = Answers.getDoubleExtra("wolfmotortime6",0);
        Time7 = Answers.getDoubleExtra("wolfmotortime7",0);
        Time8 = Answers.getDoubleExtra("wolfmotortime8",0);
        Time9 = Answers.getDoubleExtra("wolfmotortime9",0);
        Time10 = Answers.getDoubleExtra("wolfmotortime10",0);
        Time11 = Answers.getDoubleExtra("wolfmotortime11",0);
        Time12 = Answers.getDoubleExtra("wolfmotortime12",0);
        Time13 = Answers.getDoubleExtra("wolfmotortime13",0);
        Time14 = Answers.getDoubleExtra("wolfmotortime14",0);
        Time15 = Answers.getDoubleExtra("wolfmotortime15",0);
        Wolfmotortimetotal = Answers.getDoubleExtra("Wolfmotortimetotal",0);




        if (Objects.equals("fu_arm_1", Event)){
            Session = "FU";
        } else if (Objects.equals("adm_arm_1", Event)){
            Session = "ADM";
        } else if (Objects.equals("dc_arm_1", Event)){
            Session = "DC";
        } else if (Objects.equals("mp_arm_1", Event)){
            Session = "MP";
        }

        ((TextView)findViewById(R.id.conDate)).setText("Date: " + Date);
        ((TextView)findViewById(R.id.conPatID)).setText(PatID);
        ((TextView)findViewById(R.id.conSession)).setText(Session);
        ((TextView)findViewById(R.id.affected)).setText(affected1);
        ((TextView)findViewById(R.id.unaffected)).setText(unaffected1);


        ((TextView)findViewById(R.id.wolfmotor1)).setText(String.valueOf(WolfmotorQ1));
        ((TextView)findViewById(R.id.wolfmotor2)).setText(String.valueOf(WolfmotorQ2));
        ((TextView)findViewById(R.id.wolfmotor3)).setText(String.valueOf(WolfmotorQ3));
        ((TextView)findViewById(R.id.wolfmotor4)).setText(String.valueOf(WolfmotorQ4));
        ((TextView)findViewById(R.id.wolfmotor5)).setText(String.valueOf(WolfmotorQ5));
        ((TextView)findViewById(R.id.wolfmotor6)).setText(String.valueOf(WolfmotorQ6));
        ((TextView)findViewById(R.id.Wolfmotor7)).setText(String.valueOf(WolfmotorQ7));
        ((TextView)findViewById(R.id.wolfmotor8)).setText(String.valueOf(WolfmotorQ8));
        ((TextView)findViewById(R.id.wolfmotor9)).setText(String.valueOf(WolfmotorQ9));
        ((TextView)findViewById(R.id.wolfmotor10)).setText(String.valueOf(WolfmotorQ10));
        ((TextView)findViewById(R.id.wolfmotor11)).setText(String.valueOf(WolfmotorQ11));
        ((TextView)findViewById(R.id.wolfmotor12)).setText(String.valueOf(WolfmotorQ12));
        ((TextView)findViewById(R.id.wolfmotor13)).setText(String.valueOf(WolfmotorQ13));
        ((TextView)findViewById(R.id.numleft1)).setText(String.valueOf(numleft1a));
        ((TextView)findViewById(R.id.numleft2)).setText(String.valueOf(numleft2a));
        ((TextView)findViewById(R.id.numleft3)).setText(String.valueOf(numleft3a));
        ((TextView)findViewById(R.id.numright1)).setText(String.valueOf(numright1a));
        ((TextView)findViewById(R.id.numright2)).setText(String.valueOf(numright2a));
        ((TextView)findViewById(R.id.numright3)).setText(String.valueOf(numright3a));
        ((TextView)findViewById(R.id.wolfmotor14r)).setText(String.valueOf(WolfmotorQ14r));
        ((TextView)findViewById(R.id.wolfmotor14l)).setText(String.valueOf(WolfmotorQ14l));
        ((TextView)findViewById(R.id.wolfmotor15)).setText(String.valueOf(WolfmotorQ15));
        ((TextView)findViewById(R.id.wolfmotor16)).setText(String.valueOf(WolfmotorQ16));
        ((TextView)findViewById(R.id.wolfmotor17)).setText(String.valueOf(WolfmotorQ17));
        ((TextView)findViewById(R.id.wolfmotortotal)).setText(String.valueOf(WolfmotorQTotal));
        ((TextView)findViewById(R.id.wolfmotortime1)).setText(String.valueOf(Time1/1000));
        ((TextView)findViewById(R.id.wolfmotortime2)).setText(String.valueOf(Time2/1000));
        ((TextView)findViewById(R.id.wolfmotortime3)).setText(String.valueOf(Time3/1000));
        ((TextView)findViewById(R.id.wolfmotortime4)).setText(String.valueOf(Time4/1000));
        ((TextView)findViewById(R.id.wolfmotortime5)).setText(String.valueOf(Time5/1000));
        ((TextView)findViewById(R.id.wolfmotortime6)).setText(String.valueOf(Time6/1000));
        ((TextView)findViewById(R.id.wolfmotortime7)).setText(String.valueOf(Time7/1000));
        ((TextView)findViewById(R.id.wolfmotortime8)).setText(String.valueOf(Time8/1000));
        ((TextView)findViewById(R.id.wolfmotortime9)).setText(String.valueOf(Time9/1000));
        ((TextView)findViewById(R.id.wolfmotortime10)).setText(String.valueOf(Time10/1000));
        ((TextView)findViewById(R.id.wolfmotortime11)).setText(String.valueOf(Time11/1000));
        ((TextView)findViewById(R.id.wolfmotortime12)).setText(String.valueOf(Time12/1000));
        ((TextView)findViewById(R.id.wolfmotortime13)).setText(String.valueOf(Time13/1000));
        ((TextView)findViewById(R.id.wolfmotortime14)).setText(String.valueOf(Time14/1000));
        ((TextView)findViewById(R.id.wolfmotortime15)).setText(String.valueOf(Time15/1000));
        ((TextView)findViewById(R.id.Wolfmotortimetotal)).setText(String.valueOf(Wolfmotortimetotal / 1000));

        record = new JSONObject();

        record.put("record_id", PatID);
        record.put("wolfmotoraffected", affected1);
        record.put("wolfmotorunaffected", unaffected1);
        record.put("wolfmotorq1", WolfmotorQ1);
        record.put("wolfmotorq2", WolfmotorQ2);
        record.put("wolfmotorq3", WolfmotorQ3);
        record.put("wolfmotorq4", WolfmotorQ4);
        record.put("wolfmotorq5", WolfmotorQ5);
        record.put("wolfmotorq6", WolfmotorQ6);
        record.put("wolfmotorq7", WolfmotorQ7);
        record.put("wolfmotorq8", WolfmotorQ8);
        record.put("wolfmotorq9", WolfmotorQ9);
        record.put("wolfmotorq10", WolfmotorQ10);
        record.put("wolfmotorq11", WolfmotorQ11);
        record.put("wolfmotorq12", WolfmotorQ12);
        record.put("wolfmotorq13", WolfmotorQ13);
        record.put("wolfmotorq14r", WolfmotorQ14r);
        record.put("wolfmotorq14l", WolfmotorQ14l);
        record.put("wolfmotorq15", WolfmotorQ15);
        record.put("wolfmotorq16", WolfmotorQ16);
        record.put("wolfmotorq17", WolfmotorQ17);
        record.put("wolfmotorqtotal", WolfmotorQTotal);
        record.put("wolfmotortime1", String.valueOf(Time1/1000));
        record.put("wolfmotortime2", String.valueOf(Time2/1000));
        record.put("wolfmotortime3", String.valueOf(Time3/1000));
        record.put("wolfmotortime4", String.valueOf(Time4/1000));
        record.put("wolfmotortime5", String.valueOf(Time5/1000));
        record.put("wolfmotortime6", String.valueOf(Time6/1000));
        record.put("wolfmotortime7", String.valueOf(Time7/1000));
        record.put("wolfmotortime8", String.valueOf(Time8/1000));
        record.put("wolfmotortime9", String.valueOf(Time9/1000));
        record.put("wolfmotortime10", String.valueOf(Time10/1000));
        record.put("wolfmotortime11", String.valueOf(Time11/1000));
        record.put("wolfmotortime12", String.valueOf(Time12/1000));
        record.put("wolfmotortime13", String.valueOf(Time13/1000));
        record.put("wolfmotortime14", String.valueOf(Time14/1000));
        record.put("wolfmotortime15", String.valueOf(Time15/1000));
        record.put("wolfmotortimetotal", String.valueOf(Wolfmotortimetotal/1000));


        record.put("redcap_event_name", Event);
        record.put("wolf_motor_function_complete", "2");

    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Wolf Motor Function Test");
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
                                Intent PID = new Intent(wolfmotorconf.this, Forms.class);
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
        public int totalpages = 2;

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

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("Wolf Motor Function Test", leftMargin + 100, titleBaseLine, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 70, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 90 , paint);
                canvas.drawText("Affected: " + affected1, 15, titleBaseLine + 110, paint);
                canvas.drawText("Unaffected: " + unaffected1, 15, titleBaseLine + 130, paint);

                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = No attempt to perform task", 15, titleBaseLine + 3 * 50 + 13, paint);
                canvas.drawText("1 = Attempt made to perform task", 15, titleBaseLine + 3 * 50 + 2 * 13, paint);
                canvas.drawText("2 = Task completed with minor assist of unaffected limb or two attempts required", 15, titleBaseLine + 3 * 50 + 3 * 13, paint);
                canvas.drawText("3 = Task completed slowly or with synergistic movement pattern", 15, titleBaseLine + 3 * 50 + 4 * 13, paint);
                canvas.drawText("4 = Task completed, however slightly slower or lack fluidity or precision", 15, titleBaseLine + 3 * 50 + 5 * 13, paint);
                canvas.drawText("5 = Task completed, normally.", 15, titleBaseLine + 3 * 50 + 6 * 13, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("Task 1" , 15, titleBaseLine + 8 * 35, paint);
                canvas.drawText("    1. Forearm to table:  " + WolfmotorQ1 + "   " + (Time1/1000) + " secs", 15, titleBaseLine + 9 * 35, paint);
                canvas.drawText("    2. Forearm to box:  " + WolfmotorQ2 + "   " + (Time2/1000) + " secs", 15, titleBaseLine + 10 * 35, paint);

                canvas.drawText("Task II" , 15, titleBaseLine + 11 * 35, paint);
                canvas.drawText("    3. Extend elbow:  " + WolfmotorQ3 + "   " + (Time3/1000) + " secs", 15, titleBaseLine + 12 * 35, paint);
                canvas.drawText("    4. Extend elbow (weighted):  " + WolfmotorQ4 + "   " + (Time4/1000) + " secs", 15, titleBaseLine + 13 * 35, paint);

                canvas.drawText("Task III" , 15, titleBaseLine + 14 * 35, paint);
                canvas.drawText("    5. Hand to table:  " + WolfmotorQ5+ "   " + (Time5/1000) + " secs", 15, titleBaseLine + 15 * 35, paint);
                canvas.drawText("    6. Hand to box:  " + WolfmotorQ6 + "   " + (Time6/1000) + " secs", 15, titleBaseLine + 16 * 35, paint);
                canvas.drawText("    7. Hand to box (weighted):  " + WolfmotorQ7 + " lbs", 15, titleBaseLine + 17 * 35, paint);

                canvas.drawText("Task IV" , 15, titleBaseLine + 18 * 35, paint);
                canvas.drawText("    8. Reach and retrieve:  " + WolfmotorQ8 + "   " + (Time7/1000) + " secs", 15, titleBaseLine + 19 * 35, paint);

            }

            else if (pagenumber == 2){

                paint.setTextSize(20);
                canvas.drawText("Task V:", 15, titleBaseLine + 1 * 35, paint);
                canvas.drawText("     9. Lift can:  " + WolfmotorQ9  + "   " + (Time8/1000) + " secs" , 15, titleBaseLine + 2 * 35, paint);
                canvas.drawText("    10. Lift pencil:  " + WolfmotorQ10  + "   " + (Time9/1000) + " secs", 15, titleBaseLine + 3 * 35, paint);
                canvas.drawText("    11. Lift paper clip:  " + WolfmotorQ11  + "   " + (Time10/1000) + " secs", 15, titleBaseLine + 4 * 35, paint);
                canvas.drawText("    12. Stack checkers:  " + WolfmotorQ12  + "   " + (Time11/1000) + " secs", 15, titleBaseLine + 5 * 35, paint);
                canvas.drawText("    13. Flip cards:  " + WolfmotorQ13  + "   " + (Time12/1000) + " secs", 15, titleBaseLine + 6 * 35, paint);
                canvas.drawText("    14. Lift paper clip (Right): " + numright1a + ", " + numright2a + ", " + numright3a + " Average: " + WolfmotorQ14r + " lbs", 15, titleBaseLine + 7 * 35, paint);
                canvas.drawText("          Lift paper clip (Left): " + numleft1a + ", " + numleft2a + ", " + numleft3a + " Average: " + WolfmotorQ14l + " lbs", 15, titleBaseLine + 8 * 35, paint);
                canvas.drawText("    15. Stack checkers:  " + WolfmotorQ15  + "   " + (Time13/1000) + " secs" , 15, titleBaseLine + 9 * 35, paint);
                canvas.drawText("    16. Flip cards:  " + WolfmotorQ16  + "   " + (Time14/1000) + " secs" , 15, titleBaseLine + 10 * 35, paint);
                canvas.drawText("    17. Lift paper clip:  " + WolfmotorQ17  + "   " + (Time15/1000) + " secs", 15, titleBaseLine + 11 * 35, paint);


                canvas.drawText("    Total:  " + WolfmotorQTotal + "  Total Time: " + (Wolfmotortimetotal/1000) + " secs", 15, titleBaseLine + 19 * 35, paint);

            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Wolf Motor Function Test " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }


    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Wolf Motor Function Test " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Wolf Motor Function Test");

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
        Q.setCellValue("affected");
        A = rowA.createCell(3);
        A.setCellValue(affected1);

        Q = rowQ.createCell(4);
        Q.setCellValue("unaffected");
        A = rowA.createCell(4);
        A.setCellValue(unaffected1);

        Q = rowQ.createCell(5);
        Q.setCellValue("Wolfmotorq1");
        A = rowA.createCell(5);
        A.setCellValue(WolfmotorQ1);

        Q = rowQ.createCell(6);
        Q.setCellValue("Wolfmotortime1");
        A = rowA.createCell(6);
        A.setCellValue(Time1/1000);

        Q = rowQ.createCell(7);
        Q.setCellValue("Wolfmotorq2");
        A = rowA.createCell(7);
        A.setCellValue(WolfmotorQ2);

        Q = rowQ.createCell(8);
        Q.setCellValue("wolfmotortime2");
        A = rowA.createCell(8);
        A.setCellValue(Time2/1000);

        Q = rowQ.createCell(9);
        Q.setCellValue("Wolfmotorq3");
        A = rowA.createCell(9);
        A.setCellValue(WolfmotorQ3);

        Q = rowQ.createCell(10);
        Q.setCellValue("Wolfmotortime3");
        A = rowA.createCell(10);
        A.setCellValue(Time3/1000);

        Q = rowQ.createCell(11);
        Q.setCellValue("Wolfmotorq4");
        A = rowA.createCell(11);
        A.setCellValue(WolfmotorQ4);

        Q = rowQ.createCell(12);
        Q.setCellValue("Wolfmotortime4");
        A = rowA.createCell(12);
        A.setCellValue(Time4/1000);

        Q = rowQ.createCell(13);
        Q.setCellValue("Wolfmotorq5");
        A = rowA.createCell(13);
        A.setCellValue(WolfmotorQ5);

        Q = rowQ.createCell(14);
        Q.setCellValue("Wolfmotortime5");
        A = rowA.createCell(14);
        A.setCellValue(Time5/1000);

        Q = rowQ.createCell(15);
        Q.setCellValue("Wolfmotorq6");
        A = rowA.createCell(15);
        A.setCellValue(WolfmotorQ6);


        Q = rowQ.createCell(16);
        Q.setCellValue("Wolfmotortime6");
        A = rowA.createCell(16);
        A.setCellValue(Time6/1000);

        Q = rowQ.createCell(17);
        Q.setCellValue("Wolfmotorq7");
        A = rowA.createCell(17);
        A.setCellValue(WolfmotorQ7);

        Q = rowQ.createCell(18);
        Q.setCellValue("Wolfmotorq8");
        A = rowA.createCell(18);
        A.setCellValue(WolfmotorQ8);


        Q = rowQ.createCell(19);
        Q.setCellValue("Wolfmotortime8");
        A = rowA.createCell(19);
        A.setCellValue(Time7/1000);

        Q = rowQ.createCell(20);
        Q.setCellValue("Wolfmotorq9");
        A = rowA.createCell(20);
        A.setCellValue(WolfmotorQ9);

        Q = rowQ.createCell(21);
        Q.setCellValue("Wolfmotortime9");
        A = rowA.createCell(21);
        A.setCellValue(Time8/1000);

        Q = rowQ.createCell(22);
        Q.setCellValue("Wolfmotorq10");
        A = rowA.createCell(22);
        A.setCellValue(WolfmotorQ10);

        Q = rowQ.createCell(23);
        Q.setCellValue("Wolfmotortime10");
        A = rowA.createCell(23);
        A.setCellValue(Time9/1000);

        Q = rowQ.createCell(24);
        Q.setCellValue("Wolfmotorq11");
        A = rowA.createCell(24);
        A.setCellValue(WolfmotorQ11);

        Q = rowQ.createCell(25);
        Q.setCellValue("Wolfmotortime11");
        A = rowA.createCell(25);
        A.setCellValue(Time10/1000);

        Q = rowQ.createCell(26);
        Q.setCellValue("Wolfmotorq12");
        A = rowA.createCell(26);
        A.setCellValue(WolfmotorQ12);

        Q = rowQ.createCell(27);
        Q.setCellValue("Wolfmotortime12");
        A = rowA.createCell(27);
        A.setCellValue(Time11/1000);

        Q = rowQ.createCell(28);
        Q.setCellValue("Wolfmotorq13");
        A = rowA.createCell(28);
        A.setCellValue(WolfmotorQ13);

        Q = rowQ.createCell(29);
        Q.setCellValue("Wolfmotortime13");
        A = rowA.createCell(29);
        A.setCellValue(Time12/1000);

        Q = rowQ.createCell(30);
        Q.setCellValue("Wolfmotorq14rightavg");
        A = rowA.createCell(30);
        A.setCellValue(WolfmotorQ14r);

        Q = rowQ.createCell(31);
        Q.setCellValue("Wolfmotor14leftavg");
        A = rowA.createCell(31);
        A.setCellValue(WolfmotorQ14l);

        Q = rowQ.createCell(32);
        Q.setCellValue("Wolfmotorq15");
        A = rowA.createCell(32);
        A.setCellValue(WolfmotorQ15);

        Q = rowQ.createCell(33);
        Q.setCellValue("Wolfmotortime15");
        A = rowA.createCell(33);
        A.setCellValue(Time13/1000);

        Q = rowQ.createCell(34);
        Q.setCellValue("Wolfmotorq16");
        A = rowA.createCell(34);
        A.setCellValue(WolfmotorQ16);

        Q = rowQ.createCell(35);
        Q.setCellValue("Wolfmotortime16");
        A = rowA.createCell(35);
        A.setCellValue(Time14/1000);

        Q = rowQ.createCell(36);
        Q.setCellValue("Wolfmotorq17");
        A = rowA.createCell(36);
        A.setCellValue(WolfmotorQ17);

        Q = rowQ.createCell(37);
        Q.setCellValue("Wolfmotortime17");
        A = rowA.createCell(37);
        A.setCellValue(Time15/1000);


        Q = rowQ.createCell(38);
        Q.setCellValue("Wolfmotorqtotal");
        A = rowA.createCell(38);
        A.setCellValue(WolfmotorQTotal);


        Q = rowQ.createCell(39);
        Q.setCellValue("Wolfmotortimetotal");
        A = rowA.createCell(39);
        A.setCellValue(Wolfmotortimetotal/1000);
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

