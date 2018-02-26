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

public class stroke_impactconf extends AppCompatActivity {


    Double Sisiii1a, Sisiii1b, Sisiii1c, Sisiii1d, Sisiii2a, Sisiii2b, Sisiii2c, Sisiii2d, Sisiii2e, Sisiii2f, Sisiii2g, Sisiii3a, Sisiii3b, Sisiii3c, Sisiii3d, Sisiii3e, Sisiii3f, Sisiii3g, Sisiii3h, Sisiii3i, Sisiii4a, Sisiii4b, Sisiii4c, Sisiii4d, Sisiii4e, Sisiii4f, Sisiii4g, Sisiii5a, Sisiii5b, Sisiii5c, Sisiii5d, Sisiii5e, Sisiii5f, Sisiii5g, Sisiii5h, Sisiii5i, Sisiii5j, Sisiii6a, Sisiii6b, Sisiii6c, Sisiii6d, Sisiii6e, Sisiii6f, Sisiii6g, Sisiii6h, Sisiii6i, Sisiii7a, Sisiii7b, Sisiii7c, Sisiii7d, Sisiii7e, Sisiii8a, Sisiii8b, Sisiii8c, Sisiii8d, Sisiii8e, Sisiii8f, Sisiii8g, Sisiii8h, SisiiiQTotal;

    String PatID, Date, Event, Session, Sisiii9a;

    JSONObject record;

    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_impactconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }



        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");
        Sisiii9a = Answers.getStringExtra("Sisiii9a");


        Sisiii1a = Answers.getDoubleExtra("Sisiii1a", 0);
        Sisiii1b = Answers.getDoubleExtra("Sisiii1b", 0);
        Sisiii1c = Answers.getDoubleExtra("Sisiii1c", 0);
        Sisiii1d = Answers.getDoubleExtra("Sisiii1d", 0);
        Sisiii2a = Answers.getDoubleExtra("Sisiii2a", 0);
        Sisiii2b = Answers.getDoubleExtra("Sisiii2b", 0);
        Sisiii2c = Answers.getDoubleExtra("Sisiii2c", 0);
        Sisiii2d = Answers.getDoubleExtra("Sisiii2d", 0);
        Sisiii2e = Answers.getDoubleExtra("Sisiii2e", 0);
        Sisiii2f = Answers.getDoubleExtra("Sisiii2f", 0);
        Sisiii2g = Answers.getDoubleExtra("Sisiii2g", 0);
        Sisiii3a = Answers.getDoubleExtra("Sisiii3a", 0);
        Sisiii3b = Answers.getDoubleExtra("Sisiii3b", 0);
        Sisiii3c = Answers.getDoubleExtra("Sisiii3c", 0);
        Sisiii3d = Answers.getDoubleExtra("Sisiii3d", 0);
        Sisiii3e = Answers.getDoubleExtra("Sisiii3e", 0);
        Sisiii3f = Answers.getDoubleExtra("Sisiii3f", 0);
        Sisiii3g = Answers.getDoubleExtra("Sisiii3g", 0);
        Sisiii3h = Answers.getDoubleExtra("Sisiii3h", 0);
        Sisiii3i = Answers.getDoubleExtra("Sisiii3i", 0);
        Sisiii4a = Answers.getDoubleExtra("Sisiii4a", 0);
        Sisiii4b = Answers.getDoubleExtra("Sisiii4b", 0);
        Sisiii4c = Answers.getDoubleExtra("Sisiii4c", 0);
        Sisiii4d = Answers.getDoubleExtra("Sisiii4d", 0);
        Sisiii4e = Answers.getDoubleExtra("Sisiii4e", 0);
        Sisiii4f = Answers.getDoubleExtra("Sisiii4f", 0);
        Sisiii4g = Answers.getDoubleExtra("Sisiii4g", 0);
        Sisiii5a = Answers.getDoubleExtra("Sisiii5a", 0);
        Sisiii5b = Answers.getDoubleExtra("Sisiii5b", 0);
        Sisiii5c = Answers.getDoubleExtra("Sisiii5c", 0);
        Sisiii5d = Answers.getDoubleExtra("Sisiii5d", 0);
        Sisiii5e = Answers.getDoubleExtra("Sisiii5e", 0);
        Sisiii5f = Answers.getDoubleExtra("Sisiii5f", 0);
        Sisiii5g = Answers.getDoubleExtra("Sisiii5g", 0);
        Sisiii5h = Answers.getDoubleExtra("Sisiii5h", 0);
        Sisiii5i = Answers.getDoubleExtra("Sisiii5i", 0);
        Sisiii5j = Answers.getDoubleExtra("Sisiii5j", 0);
        Sisiii6a = Answers.getDoubleExtra("Sisiii6a", 0);
        Sisiii6b = Answers.getDoubleExtra("Sisiii6b", 0);
        Sisiii6c = Answers.getDoubleExtra("Sisiii6c", 0);
        Sisiii6d = Answers.getDoubleExtra("Sisiii6d", 0);
        Sisiii6e = Answers.getDoubleExtra("Sisiii6e", 0);
        Sisiii6f = Answers.getDoubleExtra("Sisiii6f", 0);
        Sisiii6g = Answers.getDoubleExtra("Sisiii6g", 0);
        Sisiii6h = Answers.getDoubleExtra("Sisiii6h", 0);
        Sisiii6i = Answers.getDoubleExtra("Sisiii6i", 0);
        Sisiii7a = Answers.getDoubleExtra("Sisiii7a", 0);
        Sisiii7b = Answers.getDoubleExtra("Sisiii7b", 0);
        Sisiii7c = Answers.getDoubleExtra("Sisiii7c", 0);
        Sisiii7d = Answers.getDoubleExtra("Sisiii7d", 0);
        Sisiii7e = Answers.getDoubleExtra("Sisiii7e", 0);
        Sisiii8a = Answers.getDoubleExtra("Sisiii8a", 0);
        Sisiii8b = Answers.getDoubleExtra("Sisiii8b", 0);
        Sisiii8c = Answers.getDoubleExtra("Sisiii8c", 0);
        Sisiii8d = Answers.getDoubleExtra("Sisiii8d", 0);
        Sisiii8e = Answers.getDoubleExtra("Sisiii8e", 0);
        Sisiii8f = Answers.getDoubleExtra("Sisiii8f", 0);
        Sisiii8g = Answers.getDoubleExtra("Sisiii8g", 0);
        Sisiii8h = Answers.getDoubleExtra("Sisiii8h", 0);
        SisiiiQTotal = Answers.getDoubleExtra("SisiiiQTotal", 0);


        

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


        ((TextView)findViewById(R.id.Sisiiiq1a)).setText(String.valueOf(Sisiii1a));
        ((TextView)findViewById(R.id.Sisiiiq1b)).setText(String.valueOf(Sisiii1b));
        ((TextView)findViewById(R.id.Sisiiiq1c)).setText(String.valueOf(Sisiii1c));
        ((TextView)findViewById(R.id.Sisiiiq1d)).setText(String.valueOf(Sisiii1d));
        ((TextView)findViewById(R.id.Sisiiiq2a)).setText(String.valueOf(Sisiii2a));
        ((TextView)findViewById(R.id.Sisiiiq2b)).setText(String.valueOf(Sisiii2b));
        ((TextView)findViewById(R.id.Sisiiiq2c)).setText(String.valueOf(Sisiii2c));
        ((TextView)findViewById(R.id.Sisiiiq2d)).setText(String.valueOf(Sisiii2d));
        ((TextView)findViewById(R.id.Sisiiiq2e)).setText(String.valueOf(Sisiii2e));
        ((TextView)findViewById(R.id.Sisiiiq2f)).setText(String.valueOf(Sisiii2f));
        ((TextView)findViewById(R.id.Sisiiiq2g)).setText(String.valueOf(Sisiii2g));
        ((TextView)findViewById(R.id.Sisiiiq3a)).setText(String.valueOf(Sisiii3a));
        ((TextView)findViewById(R.id.Sisiiiq3b)).setText(String.valueOf(Sisiii3b));
        ((TextView)findViewById(R.id.Sisiiiq3c)).setText(String.valueOf(Sisiii3c));
        ((TextView)findViewById(R.id.Sisiiiq3d)).setText(String.valueOf(Sisiii3d));
        ((TextView)findViewById(R.id.Sisiiiq3e)).setText(String.valueOf(Sisiii3e));
        ((TextView)findViewById(R.id.Sisiiiq3f)).setText(String.valueOf(Sisiii3f));
        ((TextView)findViewById(R.id.Sisiiiq3g)).setText(String.valueOf(Sisiii3g));
        ((TextView)findViewById(R.id.Sisiiiq3h)).setText(String.valueOf(Sisiii3h));
        ((TextView)findViewById(R.id.Sisiiiq3i)).setText(String.valueOf(Sisiii3i));
        ((TextView)findViewById(R.id.Sisiiiq4a)).setText(String.valueOf(Sisiii4a));
        ((TextView)findViewById(R.id.Sisiiiq4b)).setText(String.valueOf(Sisiii4b));
        ((TextView)findViewById(R.id.Sisiiiq4c)).setText(String.valueOf(Sisiii4c));
        ((TextView)findViewById(R.id.Sisiiiq4d)).setText(String.valueOf(Sisiii4d));

        ((TextView)findViewById(R.id.Sisiiiq4e)).setText(String.valueOf(Sisiii4e));
        ((TextView)findViewById(R.id.Sisiiiq4f)).setText(String.valueOf(Sisiii4f));
        ((TextView)findViewById(R.id.Sisiiiq4g)).setText(String.valueOf(Sisiii4g));
        ((TextView)findViewById(R.id.Sisiiiq5a)).setText(String.valueOf(Sisiii5a));
        ((TextView)findViewById(R.id.Sisiiiq5b)).setText(String.valueOf(Sisiii5b));
        ((TextView)findViewById(R.id.Sisiiiq5c)).setText(String.valueOf(Sisiii5c));
        ((TextView)findViewById(R.id.Sisiiiq5d)).setText(String.valueOf(Sisiii5d));
        ((TextView)findViewById(R.id.Sisiiiq5e)).setText(String.valueOf(Sisiii5e));
        ((TextView)findViewById(R.id.Sisiiiq5f)).setText(String.valueOf(Sisiii5f));
        ((TextView)findViewById(R.id.Sisiiiq5g)).setText(String.valueOf(Sisiii5g));
        ((TextView)findViewById(R.id.Sisiiiq5h)).setText(String.valueOf(Sisiii5h));
        ((TextView)findViewById(R.id.Sisiiiq5i)).setText(String.valueOf(Sisiii5i));
        ((TextView)findViewById(R.id.Sisiiiq5j)).setText(String.valueOf(Sisiii5j));

        ((TextView)findViewById(R.id.Sisiiiq6a)).setText(String.valueOf(Sisiii6a));
        ((TextView)findViewById(R.id.Sisiiiq6b)).setText(String.valueOf(Sisiii6b));
        ((TextView)findViewById(R.id.Sisiiiq6c)).setText(String.valueOf(Sisiii6c));
        ((TextView)findViewById(R.id.Sisiiiq6d)).setText(String.valueOf(Sisiii6d));
        ((TextView)findViewById(R.id.Sisiiiq6e)).setText(String.valueOf(Sisiii6e));
        ((TextView)findViewById(R.id.Sisiiiq6f)).setText(String.valueOf(Sisiii6f));
        ((TextView)findViewById(R.id.Sisiiiq6g)).setText(String.valueOf(Sisiii6g));
        ((TextView)findViewById(R.id.Sisiiiq6h)).setText(String.valueOf(Sisiii6h));
        ((TextView)findViewById(R.id.Sisiiiq6i)).setText(String.valueOf(Sisiii6i));

        ((TextView)findViewById(R.id.Sisiiiq7a)).setText(String.valueOf(Sisiii7a));
        ((TextView)findViewById(R.id.Sisiiiq7b)).setText(String.valueOf(Sisiii7b));
        ((TextView)findViewById(R.id.Sisiiiq7c)).setText(String.valueOf(Sisiii7c));
        ((TextView)findViewById(R.id.Sisiiiq7d)).setText(String.valueOf(Sisiii7d));
        ((TextView)findViewById(R.id.Sisiiiq7e)).setText(String.valueOf(Sisiii7e));

        ((TextView)findViewById(R.id.Sisiiiq8a)).setText(String.valueOf(Sisiii8a));
        ((TextView)findViewById(R.id.Sisiiiq8b)).setText(String.valueOf(Sisiii8b));
        ((TextView)findViewById(R.id.Sisiiiq8c)).setText(String.valueOf(Sisiii8c));
        ((TextView)findViewById(R.id.Sisiiiq8d)).setText(String.valueOf(Sisiii8d));
        ((TextView)findViewById(R.id.Sisiiiq8e)).setText(String.valueOf(Sisiii8e));
        ((TextView)findViewById(R.id.Sisiiiq8f)).setText(String.valueOf(Sisiii8f));
        ((TextView)findViewById(R.id.Sisiiiq8g)).setText(String.valueOf(Sisiii8g));
        ((TextView)findViewById(R.id.Sisiiiq8h)).setText(String.valueOf(Sisiii8h));

        ((TextView)findViewById(R.id.Sisiiiq9)).setText(String.valueOf(Sisiii9a));


        ((TextView)findViewById(R.id.consisiiitotal)).setText(String.valueOf(SisiiiQTotal));


        record = new JSONObject();


        record.put("record_id", PatID);
        record.put("redcap_event_name", Event);

        record.put("sisiii1a",Sisiii1a);
        record.put("sisiii1b",Sisiii1b);
        record.put("sisiii1c",Sisiii1c);
        record.put("sisiii1d",Sisiii1d);
        record.put("sisiii2a",Sisiii2a);
        record.put("sisiii2b",Sisiii2b);
        record.put("sisiii2c",Sisiii2c);
        record.put("sisiii2d",Sisiii2d);
        record.put("sisiii2e",Sisiii2e);
        record.put("sisiii2f",Sisiii2f);
        record.put("sisiii2g",Sisiii2g);
        record.put("sisiii3a",Sisiii3a);
        record.put("sisiii3b",Sisiii3b);
        record.put("sisiii3c",Sisiii3c);
        record.put("sisiii3d",Sisiii3d);
        record.put("sisiii3e",Sisiii3e);
        record.put("sisiii3f",Sisiii3f);
        record.put("sisiii3g",Sisiii3g);
        record.put("sisiii3h",Sisiii3h);
        record.put("sisiii3i",Sisiii3i);
        record.put("sisiii4a",Sisiii4a);
        record.put("sisiii4b",Sisiii4b);
        record.put("sisiii4c",Sisiii4c);
        record.put("sisiii4d",Sisiii4d);
        record.put("sisiii4e",Sisiii4e);
        record.put("sisiii4f",Sisiii4f);
        record.put("sisiii4g",Sisiii4g);
        record.put("sisiii5a",Sisiii5a);
        record.put("sisiii5b",Sisiii5b);
        record.put("sisiii5c",Sisiii5c);
        record.put("sisiii5d",Sisiii5d);
        record.put("sisiii5e",Sisiii5e);
        record.put("sisiii5f",Sisiii5f);
        record.put("sisiii5g",Sisiii5g);
        record.put("sisiii5h",Sisiii5h);
        record.put("sisiii5i",Sisiii5i);
        record.put("sisiii5j",Sisiii5j);
        record.put("sisiii6a",Sisiii6a);
        record.put("sisiii6b",Sisiii6b);
        record.put("sisiii6c",Sisiii6c);
        record.put("sisiii6d",Sisiii6d);
        record.put("sisiii6e",Sisiii6e);
        record.put("sisiii6f",Sisiii6f);
        record.put("sisiii6g",Sisiii6g);
        record.put("sisiii6h",Sisiii6h);
        record.put("sisiii6i",Sisiii6i);
        record.put("sisiii7a",Sisiii7a);
        record.put("sisiii7b",Sisiii7b);
        record.put("sisiii7c",Sisiii7c);
        record.put("sisiii7d",Sisiii7d);
        record.put("sisiii7e",Sisiii7e);
        record.put("sisiii8a",Sisiii8a);
        record.put("sisiii8b",Sisiii8b);
        record.put("sisiii8c",Sisiii8c);
        record.put("sisiii8d",Sisiii8d);
        record.put("sisiii8e",Sisiii8e);
        record.put("sisiii8f",Sisiii8f);
        record.put("sisiii8g",Sisiii8g);
        record.put("sisiii8h",Sisiii8h);
        record.put("sisiii9a",Sisiii9a);
        record.put("sisiiiqtotal",SisiiiQTotal);



        record.put("stroke_impact_scale_complete", "2");



    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Stroke Impact Scale Version 3.0");
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
                                Intent PID = new Intent(stroke_impactconf.this, Forms.class);
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
        public int totalpages = 5;

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
                canvas.drawText("Stroke Impact Scale Version 3.0", leftMargin + 20, titleBaseLine, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 70, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 90, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("The purpose of this questionnaire is to evaluate how stroke has impacted your health and life. We want to know from YOUR POINT OF", 15, titleBaseLine + 3 * 30 + 13, paint);
                canvas.drawText("VIEW how stroke has affected you. We will ask you questions about impairments and disabilities caused by your stroke, as well as ", 15, titleBaseLine + 3 * 30 + 2 * 13, paint);
                canvas.drawText("how stroke has affected your quality of life. Finally, we will ask you to rate how much you think have recovered from your stroke.", 15, titleBaseLine + 3 * 30 + 3 * 13, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("These questions are about the physical problems", 15, titleBaseLine + 6 * 28, paint);
                canvas.drawText("which may have occurred as a result of your", 15, titleBaseLine + 6 * 28 + 20, paint);
                canvas.drawText("stroke:", 15, titleBaseLine + 6 * 28 + 2 * 20, paint);
                paint.setTextSize(18);
                canvas.drawText("1. In the past week, how would you rate the strength of your....", 15, titleBaseLine + 8 * 29 + 10, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = A Lot of Strength", 15, titleBaseLine + 15 * 18, paint);
                canvas.drawText("4 = Quite a Bit of Strength", 15, titleBaseLine + 15 * 18 + 15, paint);
                canvas.drawText("3 = Some Strength", 15, titleBaseLine + 15 * 18 + 15 * 2, paint);
                canvas.drawText("2 = A Little Strength", 15, titleBaseLine + 15*18 + 15*3, paint);
                canvas.drawText("1 = No Strength At All", 15, titleBaseLine + 15 * 18 + 15 * 4, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Arm that was MOST affected by your stroke =" + Sisiii1a, 15, titleBaseLine + 15 * 18 + 18 * 5, paint);
                canvas.drawText("   b. Grip of your hand that was MOST affected by your stroke =" + Sisiii1b, 15, titleBaseLine + 15*18 + 18*6, paint);
                canvas.drawText("   c. Leg that was MOST affected by your stroke =" + Sisiii1c, 15, titleBaseLine + 15 * 18 + 18 * 7, paint);
                canvas.drawText("   d. Foot/ankle that was MOST affected by your stroke =" + Sisiii1d, 15, titleBaseLine + 15 * 18 + 18 * 8, paint);
                paint.setTextSize(20);
                canvas.drawText("These questions are about your memory and thinking", 15, titleBaseLine + 16 * 28, paint);
                paint.setTextSize(18);
                canvas.drawText("2. In the past week, how difficult was it for you to....", 15, titleBaseLine + 16 * 30, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = Not Difficult at All", 15, titleBaseLine + 16 * 30 + 15, paint);
                canvas.drawText("4 = A Little Difficult", 15, titleBaseLine + 16 * 30 + 15 * 2, paint);
                canvas.drawText("3 = Somewhat Difficult", 15, titleBaseLine + 16*30 + 15 *3, paint);
                canvas.drawText("2 = Very Difficult", 15, titleBaseLine + 16*30 + 15*4, paint);
                canvas.drawText("1 = Extremely Difficult", 15, titleBaseLine + 16*30 + 15*5, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Remember things that people just told you =" + Sisiii2a, 15, titleBaseLine + 16 * 30 + 18 * 6, paint);
                canvas.drawText("   b. Remember things that happened that day before =" + Sisiii2b, 15, titleBaseLine + 16 * 30 + 18 * 7, paint);
                canvas.drawText("   c. Remember to do things (e.g. keep scheduled appointments or take medication)=" + Sisiii2c, 15, titleBaseLine + 16*30 + 18*8,paint);
                canvas.drawText("   d. Remember the day of the week =" + Sisiii2d, 15, titleBaseLine + 16*30 + 18*9, paint);
                canvas.drawText("   e. Concentrate =" + Sisiii2e, 15, titleBaseLine + 16*30 + 18*10, paint);
                canvas.drawText("   f. Think quickly =" + Sisiii2f, 15, titleBaseLine + 16*30 + 18*11, paint);
                canvas.drawText("   g. Solve everyday problems =" + Sisiii2g, 15, titleBaseLine + 16*30 + 18*12, paint);

            }

            else if (pagenumber == 2){

                paint.setTextSize(20);
                canvas.drawText("These questions are about your how you feel, about changes in ", 15, titleBaseLine + 1 * 28, paint);
                canvas.drawText("your mood and about your ability to control your emotions ", 15, titleBaseLine + 1 * 28 + 20, paint);
                canvas.drawText("since your stroke ", 15, titleBaseLine + 1 * 28 + 20 * 2, paint);

                paint.setTextSize(18);
                canvas.drawText("3. In the past week, how difficult was it for you to...", 15, titleBaseLine + 3 * 29 + 20, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = None of the time", 15, titleBaseLine + 6 * 20 + 15, paint);
                canvas.drawText("4 = A Little of the time", 15, titleBaseLine + 6 * 20 + 2 * 15, paint);
                canvas.drawText("3 = Some of the time", 15, titleBaseLine + 6 * 20 + 15 *3, paint);
                canvas.drawText("2 = Most of the time", 15, titleBaseLine + 6*20 + 15*4, paint);
                canvas.drawText("1 = All of the time", 15, titleBaseLine + 6 * 20 + 15 * 5, paint);
                canvas.drawText("***This scale applies unless otherwise indicated below the question.", 15, titleBaseLine + 6 * 20 + 15 * 6, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Feel sad = " + Sisiii3a, 15, titleBaseLine + 230, paint);
                canvas.drawText("   b. Feel that there is nobody you are close to  = " + Sisiii3b, 15, titleBaseLine + 230+ 18, paint);
                canvas.drawText("   c. Feel that you are a burden to others = " + Sisiii3c, 15, titleBaseLine + 230 + 18*2, paint);
                canvas.drawText("   d. Feel that you have nothing to look forward to = " + Sisiii3d, 15, titleBaseLine + 230 + 18 * 3, paint);
                canvas.drawText("   e. Blame yourself for mistakes that you made = " + Sisiii3e, 15, titleBaseLine + 230 + 18 * 4, paint);
                canvas.drawText("   f. Think quickly = " + Sisiii3f, 15, titleBaseLine + 230 + 18 * 5, paint);
                paint.setTextSize(10);
                canvas.drawText("*** Scale for above question.", 15, titleBaseLine + 350, paint);
                canvas.drawText("1 = None of the time", 15, titleBaseLine + 350+15, paint);
                canvas.drawText("2 = A Little of the time", 15, titleBaseLine + 350+15*2, paint);
                canvas.drawText("3 = Some of the time", 15, titleBaseLine + 350+15*3, paint);
                canvas.drawText("4 = Most of the time", 15, titleBaseLine + 350+15*4, paint);
                canvas.drawText("5 = All of the time", 15, titleBaseLine + 350+15*5, paint);
                paint.setTextSize(14);
                canvas.drawText("   g. Feel quite nervous = " + Sisiii3g, 15, titleBaseLine + 425+20, paint);
                canvas.drawText("   h. Feel that life is worth living = " + Sisiii3h, 15, titleBaseLine + 425+20+18, paint);
                paint.setTextSize(10);
                canvas.drawText("*** Scale for above question.", 15, titleBaseLine + 463+30, paint);
                canvas.drawText("1 = None of the time", 15, titleBaseLine + 463+30+15, paint);
                canvas.drawText("2 = A Little of the time", 15, titleBaseLine + 463+30+15*2, paint);
                canvas.drawText("3 = Some of the time", 15, titleBaseLine + 463+30+15*3, paint);
                canvas.drawText("4 = Most of the time", 15, titleBaseLine + 463+30+15*4, paint);
                canvas.drawText("5 = All of the time", 15, titleBaseLine + 463+30+15*5, paint);
                paint.setTextSize(14);
                canvas.drawText("   i. Smile and laugh at least once a day = " + Sisiii3i, 15, titleBaseLine + 568+20, paint);
                paint.setTextSize(10);
                canvas.drawText("*** Scale for above question.", 15, titleBaseLine + 568+20+30, paint);
                canvas.drawText("1 = None of the time", 15, titleBaseLine + 568+20+30+15, paint);
                canvas.drawText("2 = A Little of the time", 15, titleBaseLine + 568+20+30+15*2, paint);
                canvas.drawText("3 = Some of the time", 15, titleBaseLine + 568+20+30+15*3, paint);
                canvas.drawText("4 = Most of the time", 15, titleBaseLine + 568+20+30+15*4, paint);
                canvas.drawText("5 = All of the time", 15, titleBaseLine + 568+20+30+15*5, paint);

            }
            else if (pagenumber == 3){

                paint.setTextSize(20);
                canvas.drawText("The following questions are about your ability to communicate with", 15, titleBaseLine + 1 * 28, paint);
                canvas.drawText("with other people, as well as our ability to understand what you ", 15, titleBaseLine + 1 * 28 + 20, paint);
                canvas.drawText("read and what you hear in a conversation.", 15, titleBaseLine + 1 * 28 + 20 * 2, paint);

                paint.setTextSize(18);
                canvas.drawText("4. In the past week, how difficult was it to...", 15, titleBaseLine + 3 * 29 + 20, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = Not Difficult at All", 15, titleBaseLine + 6 * 20 + 15, paint);
                canvas.drawText("4 = A Little Difficult", 15, titleBaseLine + 6 * 20 + 2 * 15, paint);
                canvas.drawText("3 = Somewhat Difficult", 15, titleBaseLine + 6 * 20 + 15 * 3, paint);
                canvas.drawText("2 = Very Difficult", 15, titleBaseLine + 6*20 + 15*4, paint);
                canvas.drawText("1 = Extremely Difficult", 15, titleBaseLine + 6 * 20 + 15 * 5, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Say the name of someone who was in front of you = " + Sisiii4a, 15, titleBaseLine + 7 * 20 + 15 * 6, paint);
                canvas.drawText("   b. Understand what was being said to you in conversation  = " + Sisiii4b, 15, titleBaseLine + 7 * 20 + 15 * 7, paint);
                canvas.drawText("   c. Reply to questions = " + Sisiii4c, 15, titleBaseLine + 7 * 20 + 15 * 8, paint);
                canvas.drawText("   d. Correctly name objects = " + Sisiii4d, 15, titleBaseLine + 7 * 20 + 15 * 9, paint);
                canvas.drawText("   e. Participate in a conversation with a group of people = " + Sisiii4e, 15, titleBaseLine + 7 * 20 + 15 * 10, paint);
                canvas.drawText("   f. Have a conversation on the telephone = " + Sisiii4f, 15, titleBaseLine + 7 * 20 + 15 * 11, paint);
                canvas.drawText("   g. Call another person on the telephone, including selecting the correct phone", 15, titleBaseLine + 7 * 20 + 15 * 12, paint);
                canvas.drawText("      number and dialing = " + Sisiii4g, 15, titleBaseLine + 7 * 20 + 15 * 13, paint);

                paint.setTextSize(20);
                canvas.drawText("The following questions ask about activities you might do ", 15, titleBaseLine + 7 * 20 + 15 * 14 + 10, paint);
                canvas.drawText("during a typical day:", 15, titleBaseLine + 7 * 20 + 15 * 15 + 15, paint);

                paint.setTextSize(18);
                canvas.drawText("5. In the past 2 weeks, how difficult was it to...", 15, titleBaseLine + 7 * 20 + 15 * 17 + 10, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = Not Difficult at All", 15, titleBaseLine + 7 * 20 + 15 * 18 + 10, paint);
                canvas.drawText("4 = A Little Difficult", 15, titleBaseLine + 7 * 20 + 15 * 19 + 10, paint);
                canvas.drawText("3 = Somewhat Difficult", 15, titleBaseLine + 7 * 20 + 15 *20+10, paint);
                canvas.drawText("2 = Very Difficult", 15, titleBaseLine + 7 * 20 + 15 * 21 + 10, paint);
                canvas.drawText("1 = Could not do at all", 15, titleBaseLine + 7 * 20 + 15 * 22+10, paint);

                paint.setTextSize(14);
                canvas.drawText("   a. Cut your food with a knife and fork = " + Sisiii5a, 15, titleBaseLine + 7 * 20 + 15 * 23 + 10, paint);
                canvas.drawText("   b. Dress the top part of your body = " + Sisiii5b, 15, titleBaseLine + 7 * 20 + 15 * 24 + 10, paint);
                canvas.drawText("   c. Bathe yourself = " + Sisiii5c, 15, titleBaseLine + 7 * 20 + 15 * 25 + 10, paint);
                canvas.drawText("   d. Clips your toenails = " + Sisiii5d, 15, titleBaseLine + 7 * 20 + 15 * 26 + 10, paint);
                canvas.drawText("   e. Get to the toilet on time = " + Sisiii5e, 15, titleBaseLine + 7 * 20 + 15 * 27 + 10, paint);
                canvas.drawText("   f. Control your bladder (not have an accident) = " + Sisiii5f, 15, titleBaseLine + 7 * 20 + 15 * 28 + 10, paint);
                canvas.drawText("   g. Control your bowels (not have an accident) = " + Sisiii5g, 15, titleBaseLine +7 * 20 + 15 * 29 + 10, paint);
                canvas.drawText("   h. Do light household tasks/ chores (e.g. dust, make a bed, take out garbage,", 15, titleBaseLine + 7 * 20 + 15 * 30 + 10, paint);
                canvas.drawText("   do the dishes) = " + Sisiii5h, 15, titleBaseLine + 7 * 20 + 15 * 31 + 10, paint);
                canvas.drawText("   i. Go shopping = " + Sisiii5i, 15, titleBaseLine + 7 * 20 + 15 * 32 + 10, paint);
                canvas.drawText("   j. Do heavy household chores (e.g. vacuum, laundry, or yard work) = " + Sisiii5j,15, titleBaseLine + 7*20 +15*33+10, paint);


            }
            else if (pagenumber == 4){

                paint.setTextSize(20);
                canvas.drawText("The following questions are about your ability to be mobile,", 15, titleBaseLine + 1 * 28, paint);
                canvas.drawText("at home and in the community: ", 15, titleBaseLine + 1 * 28 + 20+5, paint);

                paint.setTextSize(18);
                canvas.drawText("6. In the past 2 week, how difficult was it to...", 15, titleBaseLine + 3 * 29 + 20, paint);
                paint.setTextSize(10);
                canvas.drawText("5 = Not Difficult at All", 15, titleBaseLine + 6 * 20 + 15, paint);
                canvas.drawText("4 = A Little Difficult", 15, titleBaseLine + 6 * 20 + 2 * 15, paint);
                canvas.drawText("3 = Somewhat Difficult", 15, titleBaseLine + 6 * 20 + 15 * 3, paint);
                canvas.drawText("2 = Very Difficult", 15, titleBaseLine + 6*20 + 15*4, paint);
                canvas.drawText("1 = Could not do at all", 15, titleBaseLine + 6 * 20 + 15 * 5, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Stay sitting without losing your balance = " + Sisiii6a, 15, titleBaseLine + 7 * 20 + 15 * 6, paint);
                canvas.drawText("   b. Stay standing without losing your balance  = " + Sisiii6b, 15, titleBaseLine + 7 * 20 + 15 * 7, paint);
                canvas.drawText("   c. Walk without losing your balance = " + Sisiii6c, 15, titleBaseLine + 7 * 20 + 15 * 8, paint);
                canvas.drawText("   d. Move from a bed to a chair = " + Sisiii6d, 15, titleBaseLine + 7 * 20 + 15 * 9, paint);
                canvas.drawText("   e. Walk one block = " + Sisiii6e, 15, titleBaseLine + 7 * 20 + 15 * 10, paint);
                canvas.drawText("   f. Walk fast = " + Sisiii6f, 15, titleBaseLine + 7 * 20 + 15 * 11, paint);
                canvas.drawText("   g. Climb one flight of stairs = " + Sisiii6g, 15, titleBaseLine + 7 * 20 + 15 * 12, paint);
                canvas.drawText("   h. Climb several flights of stairs = " + Sisiii6h, 15, titleBaseLine + 7 * 20 + 15 * 13, paint);
                canvas.drawText("   i. Get in and out of a car = " + Sisiii6i, 15, titleBaseLine + 7 * 20 + 15 * 14, paint);


                paint.setTextSize(20);
                canvas.drawText("The following questions are about your ability to use your hand ", 15, titleBaseLine + 7 * 20 + 15 * 15 + 10, paint);
                canvas.drawText("that was MOST AFFECTED by your stroke:", 15, titleBaseLine + 7 * 20 + 15 * 16 + 15, paint);

                paint.setTextSize(18);
                canvas.drawText("7. In the past 2 weeks, how difficult was it to use your hand that ", 15, titleBaseLine + 7 * 20 + 15 * 17 + 13+15, paint);
                canvas.drawText("was most affected by your stroke to... ", 15, titleBaseLine + 7 * 20 + 15 * 17 + 13+15+15, paint);

                paint.setTextSize(10);
                canvas.drawText("5 = Not Difficult at All", 15, titleBaseLine + 7 * 20 + 15 * 19 + 13+20, paint);
                canvas.drawText("4 = A Little Difficult", 15, titleBaseLine + 7 * 20 + 15 * 20 + 13+20, paint);
                canvas.drawText("3 = Somewhat Difficult", 15, titleBaseLine + 7 * 20 + 15 *21+13+20, paint);
                canvas.drawText("2 = Very Difficult", 15, titleBaseLine + 7 * 20 + 15 * 22 + 13+20, paint);
                canvas.drawText("1 = Extremely Difficult", 15, titleBaseLine + 7 * 20 + 15 * 23+13+20, paint);

                paint.setTextSize(14);
                canvas.drawText("   a. Carry heavy objects (e.g. bag of groceries) = " + Sisiii7a, 15, titleBaseLine + 7 * 20 + 15 * 24 + 13+25, paint);
                canvas.drawText("   b. Turn a doorknob = " + Sisiii7b, 15, titleBaseLine + 7 * 20 + 15 * 25 + 13+25, paint);
                canvas.drawText("   c. Open a can or jar = " + Sisiii7c, 15, titleBaseLine + 7 * 20 + 15 * 26 + 13+25, paint);
                canvas.drawText("   d. Tie a shoelace = " + Sisiii7d, 15, titleBaseLine + 7 * 20 + 15 * 27 + 13+25, paint);
                canvas.drawText("   e. Pick up a dime = " + Sisiii7e, 15, titleBaseLine + 7 * 20 + 15 * 28 + 13+25, paint);

            }
            else if (pagenumber == 5){

                paint.setTextSize(20);
                canvas.drawText("The following questions are about how stroke affected your ", 15, titleBaseLine + 1 * 28, paint);
                canvas.drawText("ability to be participate in the activities that you usually do,", 15, titleBaseLine + 1 * 28 + 20, paint);
                canvas.drawText("things that are meaning ful to you and help you to find ", 15, titleBaseLine + 1 * 28 + 40, paint);
                canvas.drawText("purpose in life: ", 15, titleBaseLine + 1 * 28 + 60, paint);

                paint.setTextSize(18);
                canvas.drawText("8. During the past 4 weeks, how much of the time have you been", 15, titleBaseLine + 3 * 29 + 20+20, paint);
                canvas.drawText("limited to...", 15, titleBaseLine + 3 * 29 + 40+20, paint);

                paint.setTextSize(10);
                canvas.drawText("5 = None of the time", 15, titleBaseLine + 6 * 20 + 15+35, paint);
                canvas.drawText("4 = A little of the time", 15, titleBaseLine + 6 * 20 + 2 * 15+35, paint);
                canvas.drawText("3 = Some of the time", 15, titleBaseLine + 6 * 20 + 15 * 3+35, paint);
                canvas.drawText("2 = Most of the time", 15, titleBaseLine + 6*20 + 15*4+35, paint);
                canvas.drawText("1 = All of the time", 15, titleBaseLine + 6 * 20 + 15 * 5+35, paint);
                paint.setTextSize(14);
                canvas.drawText("   a. Your work (paid, voluntary, or other) = " + Sisiii8a, 15, titleBaseLine + 7 * 20 + 15 * 6+35, paint);
                canvas.drawText("   b. Your social activities  = " + Sisiii8b, 15, titleBaseLine + 7 * 20 + 15 * 7+35, paint);
                canvas.drawText("   c. Quiet recreation (crafts, reading) = " + Sisiii8c, 15, titleBaseLine + 7 * 20 + 15 * 8+35, paint);
                canvas.drawText("   d. Active recreation (sports, outings, travel) = " + Sisiii8d, 15, titleBaseLine + 7 * 20 + 15 * 9+35, paint);
                canvas.drawText("   e. Your role as a family member and/or friend = " + Sisiii8e, 15, titleBaseLine + 7 * 20 + 15 * 10+35, paint);
                canvas.drawText("   f. Your participation in spiritual or religious activities =" + Sisiii8f, 15, titleBaseLine + 7 * 20 + 15 * 11+35, paint);
                canvas.drawText("   g. Your ability to control your life as you wish = " + Sisiii8g, 15, titleBaseLine + 7 * 20 + 15 * 12+35, paint);
                canvas.drawText("   h. Your ability to help others = " + Sisiii8h, 15, titleBaseLine + 7 * 20 + 15 * 13+35, paint);

                paint.setTextSize(18);
                canvas.drawText("9. Stroke Recovery", 15, titleBaseLine + 7 * 20 + 16 * 14+35, paint);
                canvas.drawText("On a scale of 0 to 100, with 100 representing full recovery and 0 ", 15, titleBaseLine + 7 * 20 + 16 * 15+35, paint);
                canvas.drawText("representing no recovery, how much have you recovered from your ", 15, titleBaseLine + 7 * 20 + 16 * 16+35, paint);
                canvas.drawText("stroke?", 15, titleBaseLine + 7 * 20 + 16 * 17+35, paint);

                canvas.drawText(""+ Sisiii9a, 15, titleBaseLine + 7 * 20 + 16 * 18+35+15, paint);





                paint.setTextSize(20);

                canvas.drawText("    Total: " + SisiiiQTotal, 15, titleBaseLine + 19 * 35, paint);

            }


        }





    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Stroke Impact Scale " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Stroke Impact Scale " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Stroke Impact Scale");

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
        Q.setCellValue("Sisiiiq1a");
        A = rowA.createCell(3);
        A.setCellValue(Sisiii1a);

        Q = rowQ.createCell(4);
        Q.setCellValue("Sisiii1b");
        A = rowA.createCell(4);
        A.setCellValue(Sisiii1b);

        Q = rowQ.createCell(5);
        Q.setCellValue("Sisiii1c");
        A = rowA.createCell(5);
        A.setCellValue(Sisiii1c);

        Q = rowQ.createCell(6);
        Q.setCellValue("Sisiii1d");
        A = rowA.createCell(6);
        A.setCellValue(Sisiii1d);

        Q = rowQ.createCell(7);
        Q.setCellValue("Sisiii2a");
        A = rowA.createCell(7);
        A.setCellValue(Sisiii2a);

        Q = rowQ.createCell(8);
        Q.setCellValue("Sisiii2b");
        A = rowA.createCell(8);
        A.setCellValue(Sisiii2b);

        Q = rowQ.createCell(9);
        Q.setCellValue("Sisiii2c");
        A = rowA.createCell(9);
        A.setCellValue(Sisiii2c);

        Q = rowQ.createCell(10);
        Q.setCellValue("Sisiii2d");
        A = rowA.createCell(10);
        A.setCellValue(Sisiii2d);

        Q = rowQ.createCell(11);
        Q.setCellValue("Sisiii2e");
        A = rowA.createCell(11);
        A.setCellValue(Sisiii2e);

        Q = rowQ.createCell(12);
        Q.setCellValue("Sisiii2f");
        A = rowA.createCell(12);
        A.setCellValue(Sisiii2f);

        Q = rowQ.createCell(13);
        Q.setCellValue("Sisiii2g");
        A = rowA.createCell(13);
        A.setCellValue(Sisiii2g);

        Q = rowQ.createCell(14);
        Q.setCellValue("Sisiii3a");
        A = rowA.createCell(14);
        A.setCellValue(Sisiii3a);

        Q = rowQ.createCell(15);
        Q.setCellValue("Sisiii3b");
        A = rowA.createCell(15);
        A.setCellValue(Sisiii3b);

        Q = rowQ.createCell(16);
        Q.setCellValue("Sisiii3c");
        A = rowA.createCell(16);
        A.setCellValue(Sisiii3c);

        Q = rowQ.createCell(17);
        Q.setCellValue("Sisiii3d");
        A = rowA.createCell(17);
        A.setCellValue(Sisiii3d);

        Q = rowQ.createCell(18);
        Q.setCellValue("Sisiii3e");
        A = rowA.createCell(18);
        A.setCellValue(Sisiii3e);

        Q = rowQ.createCell(19);
        Q.setCellValue("Sisiii3f");
        A = rowA.createCell(19);
        A.setCellValue(Sisiii3f);

        Q = rowQ.createCell(20);
        Q.setCellValue("Sisiii3g");
        A = rowA.createCell(20);
        A.setCellValue(Sisiii3g);

        Q = rowQ.createCell(21);
        Q.setCellValue("Sisiii3h");
        A = rowA.createCell(21);
        A.setCellValue(Sisiii3h);

        Q = rowQ.createCell(22);
        Q.setCellValue("Sisiii3i");
        A = rowA.createCell(22);
        A.setCellValue(Sisiii3i);

        Q = rowQ.createCell(23);
        Q.setCellValue("Sisiii4a");
        A = rowA.createCell(23);
        A.setCellValue(Sisiii4a);

        Q = rowQ.createCell(24);
        Q.setCellValue("Sisiii4b");
        A = rowA.createCell(24);
        A.setCellValue(Sisiii4b);

        Q = rowQ.createCell(25);
        Q.setCellValue("Sisiii4c");
        A = rowA.createCell(25);
        A.setCellValue(Sisiii4c);

        Q = rowQ.createCell(26);
        Q.setCellValue("Sisiii4d");
        A = rowA.createCell(26);
        A.setCellValue(Sisiii4d);

        Q = rowQ.createCell(27);
        Q.setCellValue("Sisiii4e");
        A = rowA.createCell(27);
        A.setCellValue(Sisiii4e);

        Q = rowQ.createCell(28);
        Q.setCellValue("Sisiii4f");
        A = rowA.createCell(28);
        A.setCellValue(Sisiii4f);

        Q = rowQ.createCell(29);
        Q.setCellValue("Sisiii4g");
        A = rowA.createCell(29);
        A.setCellValue(Sisiii4g);

        Q = rowQ.createCell(30);
        Q.setCellValue("Sisiii5a");
        A = rowA.createCell(30);
        A.setCellValue(Sisiii5a);

        Q = rowQ.createCell(31);
        Q.setCellValue("Sisiii5b");
        A = rowA.createCell(31);
        A.setCellValue(Sisiii5b);

        Q = rowQ.createCell(32);
        Q.setCellValue("Sisiii5c");
        A = rowA.createCell(32);
        A.setCellValue(Sisiii5c);

        Q = rowQ.createCell(33);
        Q.setCellValue("Sisiii5d");
        A = rowA.createCell(33);
        A.setCellValue(Sisiii5d);

        Q = rowQ.createCell(34);
        Q.setCellValue("Sisiii5e");
        A = rowA.createCell(34);
        A.setCellValue(Sisiii5e);

        Q = rowQ.createCell(35);
        Q.setCellValue("Sisiii5f");
        A = rowA.createCell(35);
        A.setCellValue(Sisiii5f);

        Q = rowQ.createCell(36);
        Q.setCellValue("Sisiii5g");
        A = rowA.createCell(36);
        A.setCellValue(Sisiii5g);

        Q = rowQ.createCell(37);
        Q.setCellValue("Sisiii5h");
        A = rowA.createCell(37);
        A.setCellValue(Sisiii5h);

        Q = rowQ.createCell(38);
        Q.setCellValue("Sisiii5i");
        A = rowA.createCell(38);
        A.setCellValue(Sisiii5i);

        Q = rowQ.createCell(39);
        Q.setCellValue("Sisiii5j");
        A = rowA.createCell(39);
        A.setCellValue(Sisiii5j);

        Q = rowQ.createCell(40);
        Q.setCellValue("Sisiii6a");
        A = rowA.createCell(40);
        A.setCellValue(Sisiii6a);

        Q = rowQ.createCell(41);
        Q.setCellValue("Sisiii6b");
        A = rowA.createCell(41);
        A.setCellValue(Sisiii6b);

        Q = rowQ.createCell(42);
        Q.setCellValue("Sisiii6c");
        A = rowA.createCell(42);
        A.setCellValue(Sisiii6c);

        Q = rowQ.createCell(43);
        Q.setCellValue("Sisiii6d");
        A = rowA.createCell(43);
        A.setCellValue(Sisiii6d);

        Q = rowQ.createCell(44);
        Q.setCellValue("Sisiii6e");
        A = rowA.createCell(44);
        A.setCellValue(Sisiii6e);

        Q = rowQ.createCell(45);
        Q.setCellValue("Sisiii6f");
        A = rowA.createCell(45);
        A.setCellValue(Sisiii6f);

        Q = rowQ.createCell(46);
        Q.setCellValue("Sisiii6g");
        A = rowA.createCell(46);
        A.setCellValue(Sisiii6g);

        Q = rowQ.createCell(47);
        Q.setCellValue("Sisiii6h");
        A = rowA.createCell(47);
        A.setCellValue(Sisiii6h);

        Q = rowQ.createCell(48);
        Q.setCellValue("Sisiii6i");
        A = rowA.createCell(48);
        A.setCellValue(Sisiii6i);

        Q = rowQ.createCell(49);
        Q.setCellValue("Sisiii7a");
        A = rowA.createCell(49);
        A.setCellValue(Sisiii7a);

        Q = rowQ.createCell(50);
        Q.setCellValue("Sisiii7b");
        A = rowA.createCell(50);
        A.setCellValue(Sisiii7b);

        Q = rowQ.createCell(51);
        Q.setCellValue("Sisiii7c");
        A = rowA.createCell(51);
        A.setCellValue(Sisiii7c);

        Q = rowQ.createCell(52);
        Q.setCellValue("Sisiii7d");
        A = rowA.createCell(52);
        A.setCellValue(Sisiii7d);

        Q = rowQ.createCell(53);
        Q.setCellValue("Sisiii7e");
        A = rowA.createCell(53);
        A.setCellValue(Sisiii7e);

        Q = rowQ.createCell(54);
        Q.setCellValue("Sisiii8a");
        A = rowA.createCell(54);
        A.setCellValue(Sisiii8a);

        Q = rowQ.createCell(55);
        Q.setCellValue("Sisiii8b");
        A = rowA.createCell(55);
        A.setCellValue(Sisiii8b);

        Q = rowQ.createCell(56);
        Q.setCellValue("Sisiii8c");
        A = rowA.createCell(56);
        A.setCellValue(Sisiii8c);

        Q = rowQ.createCell(57);
        Q.setCellValue("Sisiii8d");
        A = rowA.createCell(57);
        A.setCellValue(Sisiii8d);

        Q = rowQ.createCell(58);
        Q.setCellValue("Sisiii8e");
        A = rowA.createCell(58);
        A.setCellValue(Sisiii8e);

        Q = rowQ.createCell(59);
        Q.setCellValue("Sisiii8f");
        A = rowA.createCell(59);
        A.setCellValue(Sisiii8f);

        Q = rowQ.createCell(60);
        Q.setCellValue("Sisiii8g");
        A = rowA.createCell(60);
        A.setCellValue(Sisiii8g);

        Q = rowQ.createCell(61);
        Q.setCellValue("Sisiii8h");
        A = rowA.createCell(61);
        A.setCellValue(Sisiii8h);

        Q = rowQ.createCell(62);
        Q.setCellValue("Sisiii9");
        A = rowA.createCell(62);
        A.setCellValue(Sisiii9a);

        Q = rowQ.createCell(63);
        Q.setCellValue("SisiiiTotal");
        A = rowA.createCell(63);
        A.setCellValue(SisiiiQTotal);

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