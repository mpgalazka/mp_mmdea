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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class tdcsconf extends AppCompatActivity {


    String PatID, Date, Event,Session, joined, notes1a,notes2a,notes3a,notes4a,notes5a,notes6a,notes7a,notes8a,notes9a,
            tdcs1a,tdcs1b,tdcs2a,tdcs2b,tdcs3a,tdcs3b,tdcs4a,tdcs4b,tdcs5a,tdcs5b,tdcs6a,tdcs6b,tdcs7a,tdcs7b,tdcs8a,tdcs8b,tdcs9a,tdcs9b;

//use notes1 etc for the conf pg variables


    HttpResponse response;

    JSONObject record;

    //make new strings for new checkbox textboxes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdcsconf);



        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }


        Date = DateFormat.getDateTimeInstance().format(new Date());


        Event = "NULL";

        Intent Answers = this.getIntent();
        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");
        //textboxes

        notes1a = Answers.getStringExtra("notes1a");
        notes2a = Answers.getStringExtra("notes2a");
        notes3a = Answers.getStringExtra("notes3a");
        notes4a = Answers.getStringExtra("notes4a");
        notes5a = Answers.getStringExtra("notes5a");
        notes6a = Answers.getStringExtra("notes6a");
        notes7a = Answers.getStringExtra("notes7a");
        notes8a = Answers.getStringExtra("notes8a");
        notes9a = Answers.getStringExtra("notes9a");




        //textboxes
        ((TextView) findViewById(R.id.notes1)).setText(notes1a);
        ((TextView) findViewById(R.id.notes2)).setText(notes2a);
        ((TextView) findViewById(R.id.notes3)).setText(notes3a);
        ((TextView) findViewById(R.id.notes4)).setText(notes4a);
        ((TextView) findViewById(R.id.notes5)).setText(notes5a);
        ((TextView) findViewById(R.id.notes6)).setText(notes6a);
        ((TextView) findViewById(R.id.notes7)).setText(notes7a);
        ((TextView) findViewById(R.id.notes8)).setText(notes8a);
        ((TextView) findViewById(R.id.notes9)).setText(notes9a);





        //radiobuttons
        tdcs1a = Answers.getStringExtra("tdcs1a");
        tdcs1b = Answers.getStringExtra("tdcs1b");
        tdcs2a = Answers.getStringExtra("tdcs2a");
        tdcs2b = Answers.getStringExtra("tdcs2b");
        tdcs3a = Answers.getStringExtra("tdcs3a");
        tdcs3b = Answers.getStringExtra("tdcs3b");
        tdcs4a = Answers.getStringExtra("tdcs4a");
        tdcs4b = Answers.getStringExtra("tdcs4b");
        tdcs5a = Answers.getStringExtra("tdcs5a");
        tdcs5b = Answers.getStringExtra("tdcs5b");
        tdcs6a = Answers.getStringExtra("tdcs6a");
        tdcs6b = Answers.getStringExtra("tdcs6b");
        tdcs7a = Answers.getStringExtra("tdcs7a");
        tdcs7b = Answers.getStringExtra("tdcs7b");
        tdcs8a = Answers.getStringExtra("tdcs8a");
        tdcs8b = Answers.getStringExtra("tdcs8b");
        tdcs9a = Answers.getStringExtra("tdcs9a");
        tdcs9b = Answers.getStringExtra("tdcs9b");
        Session = Answers.getStringExtra("Session");

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

        //radiobuttons
        ((TextView) findViewById(R.id.tdcs1aa)).setText(tdcs1a);
        ((TextView) findViewById(R.id.tdcs1ba)).setText(tdcs1b);
        ((TextView) findViewById(R.id.tdcs2aa)).setText(tdcs2a);
        ((TextView) findViewById(R.id.tdcs2ba)).setText(tdcs2b);
        ((TextView) findViewById(R.id.tdcs3aa)).setText(tdcs3a);
        ((TextView) findViewById(R.id.tdcs3ba)).setText(tdcs3b);
        ((TextView) findViewById(R.id.tdcs4aa)).setText(tdcs4a);
        ((TextView) findViewById(R.id.tdcs4ba)).setText(tdcs4b);
        ((TextView) findViewById(R.id.tdcs5aa)).setText(tdcs5a);
        ((TextView) findViewById(R.id.tdcs5ba)).setText(tdcs5b);
        ((TextView) findViewById(R.id.tdcs6aa)).setText(tdcs6a);
        ((TextView) findViewById(R.id.tdcs6ba)).setText(tdcs6b);
        ((TextView) findViewById(R.id.tdcs7aa)).setText(tdcs7a);
        ((TextView) findViewById(R.id.tdcs7ba)).setText(tdcs7b);
        ((TextView) findViewById(R.id.tdcs8aa)).setText(tdcs8a);
        ((TextView) findViewById(R.id.tdcs8ba)).setText(tdcs8b);
        ((TextView) findViewById(R.id.tdcs9aa)).setText(tdcs9a);
        ((TextView) findViewById(R.id.tdcs9ba)).setText(tdcs9b);




        //for REDCap variables
        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("redcap_event_name", Event);
        record.put("tdcsq1c", notes1a);
        record.put("tdcsq2c", notes2a);
        record.put("tdcsq3c", notes3a);
        record.put("tdcsq4c", notes4a);
        record.put("tdcsq5c", notes5a);
        record.put("tdcsq6c", notes6a);
        record.put("tdcsq7c", notes7a);
        record.put("tdcsq8c", notes8a);
        record.put("tdcsq9c", notes9a);

        record.put("tdcsq1a", tdcs1a);
        record.put("tdcsq1b", tdcs1b);
        record.put("tdcsq2a", tdcs2a);
        record.put("tdcsq2b", tdcs2b);
        record.put("tdcsq3a", tdcs3a);
        record.put("tdcsq3b", tdcs3b);
        record.put("tdcsq4a", tdcs4a);
        record.put("tdcsq4b", tdcs4b);
        record.put("tdcsq5a", tdcs5a);
        record.put("tdcsq5b", tdcs5b);
        record.put("tdcsq6a", tdcs6a);
        record.put("tdcsq6b", tdcs6b);
        record.put("tdcsq7a", tdcs7a);
        record.put("tdcsq7b", tdcs7b);
        record.put("tdcsq8a", tdcs8a);
        record.put("tdcsq8b", tdcs8b);
        record.put("tdcsq9a", tdcs9a);
        record.put("tdcsq9b", tdcs9b);



        record.put("tdcs_complete", "2");


    }






    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close tDCS Questionnaire");
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
                                Intent PID = new Intent(tdcsconf.this, Forms.class);
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
            int leftMargin = 160;

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);


            if (pagenumber == 1){

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("tDCS Questionnaire", leftMargin, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 4 * 25, paint);


                paint.setTextSize(10);
                canvas.drawText("1. Headache: ", 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("   1a: " + tdcs1a, 15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("   1b: " + tdcs1b, 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("   Notes: " + notes1a, 15, titleBaseLine + 8 * 25, paint);

                canvas.drawText("2. Neck Pain: ", 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("   2a: " + tdcs2a, 15, titleBaseLine + 10* 25, paint);
                canvas.drawText("   2b: " + tdcs2b, 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("   Notes: " + notes2a, 15, titleBaseLine + 12 * 25, paint);

                canvas.drawText("3. Scalp Pain: ", 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("   3a: " + tdcs3a, 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("   3b: " + tdcs3b, 15, titleBaseLine + 15 * 25, paint);
                canvas.drawText("   Notes: " + notes3a, 15, titleBaseLine + 16 * 25, paint);

                canvas.drawText("4. Headache: ", 15, titleBaseLine + 17 * 25, paint);
                canvas.drawText("   4a: " + tdcs4a, 15, titleBaseLine + 18 * 25, paint);
                canvas.drawText("   4b: " + tdcs4b, 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("   Notes: " + notes4a, 15, titleBaseLine + 20 * 25, paint);

                canvas.drawText("5. Headache: ", 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("   5a: " + tdcs5a, 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("   5b: " + tdcs5b, 15, titleBaseLine + 23 * 25, paint);
                canvas.drawText("   Notes: " + notes5a, 15, titleBaseLine + 24 * 25, paint);

                canvas.drawText("6. Headache: ", 15, titleBaseLine + 25 * 25, paint);
                canvas.drawText("   6a: " + tdcs6a, 15, titleBaseLine + 26 * 25, paint);
                canvas.drawText("   6b: " + tdcs6b, 15, titleBaseLine + 27 * 25, paint);
                canvas.drawText("   Notes: " + notes6a, 15, titleBaseLine + 28 * 25, paint);










                //new page

            }

            else if (pagenumber == 2){

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);


                canvas.drawText("7. Headache: ", 15, titleBaseLine + 1 * 25, paint);
                canvas.drawText("   7a: " + tdcs7a, 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("   7b: " + tdcs7b, 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("   Notes: " + notes7a, 15, titleBaseLine + 4 * 25, paint);

                canvas.drawText("8. Headache: ", 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("   8a: " + tdcs8a, 15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("   8b: " + tdcs8b, 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("   Notes: " + notes8a, 15, titleBaseLine + 8 * 25, paint);

                canvas.drawText("9. Headache: ", 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("   9a: " + tdcs9a, 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("   9b: " + tdcs9b, 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("   Notes: " + notes9a, 15, titleBaseLine + 12 * 25, paint);

                //just in case we can seperate the top line into this bottom one as well, but itll add a page to pdf
                //canvas.drawText("Other Programs of interest: " + interest6a, 15, titleBaseLine2 + 22 * 25, paint);






            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " tDCS Questionnaire" + " " + Date ;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " tDCS Questionnaire " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("tDCS Questionnaire");

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
        Q.setCellValue("tdcs1a");
        A = rowA.createCell(3);
        A.setCellValue(tdcs1a);

        Q = rowQ.createCell(4);
        Q.setCellValue("tdcs1b");
        A = rowA.createCell(4);
        A.setCellValue(tdcs1b);

        Q = rowQ.createCell(5);
        Q.setCellValue("notes1");
        A = rowA.createCell(5);
        A.setCellValue(notes1a);

        Q = rowQ.createCell(6);
        Q.setCellValue("tdcs2a");
        A = rowA.createCell(6);
        A.setCellValue(tdcs2a);

        Q = rowQ.createCell(7);
        Q.setCellValue("tdcs2b");
        A = rowA.createCell(7);
        A.setCellValue(tdcs2b);

        Q = rowQ.createCell(8);
        Q.setCellValue("notes2");
        A = rowA.createCell(8);
        A.setCellValue(notes2a);

        Q = rowQ.createCell(9);
        Q.setCellValue("tdcs3a");
        A = rowA.createCell(9);
        A.setCellValue(tdcs3a);

        Q = rowQ.createCell(10);
        Q.setCellValue("tdcs3b");
        A = rowA.createCell(10);
        A.setCellValue(tdcs3b);

        Q = rowQ.createCell(11);
        Q.setCellValue("notes3");
        A = rowA.createCell(11);
        A.setCellValue(notes3a);

        Q = rowQ.createCell(12);
        Q.setCellValue("tdcs4a");
        A = rowA.createCell(12);
        A.setCellValue(tdcs4a);

        Q = rowQ.createCell(13);
        Q.setCellValue("tdcs4b");
        A = rowA.createCell(13);
        A.setCellValue(tdcs4b);

        Q = rowQ.createCell(14);
        Q.setCellValue("notes3");
        A = rowA.createCell(14);
        A.setCellValue(notes3a);

        Q = rowQ.createCell(15);
        Q.setCellValue("tdcs5a");
        A = rowA.createCell(15);
        A.setCellValue(tdcs5a);

        Q = rowQ.createCell(16);
        Q.setCellValue("tdcs5b");
        A = rowA.createCell(16);
        A.setCellValue(tdcs5b);

        Q = rowQ.createCell(17);
        Q.setCellValue("notes4");
        A = rowA.createCell(17);
        A.setCellValue(notes4a);

        Q = rowQ.createCell(18);
        Q.setCellValue("tdcs6a");
        A = rowA.createCell(18);
        A.setCellValue(tdcs6a);

        Q = rowQ.createCell(19);
        Q.setCellValue("tdcs6b");
        A = rowA.createCell(19);
        A.setCellValue(tdcs6b);

        Q = rowQ.createCell(20);
        Q.setCellValue("notes4");
        A = rowA.createCell(20);
        A.setCellValue(notes4a);

        Q = rowQ.createCell(21);
        Q.setCellValue("tdcs7a");
        A = rowA.createCell(21);
        A.setCellValue(tdcs7a);

        Q = rowQ.createCell(22);
        Q.setCellValue("tdcs7b");
        A = rowA.createCell(22);
        A.setCellValue(tdcs7b);

        Q = rowQ.createCell(23);
        Q.setCellValue("notes5");
        A = rowA.createCell(23);
        A.setCellValue(notes5a);

        Q = rowQ.createCell(24);
        Q.setCellValue("tdcs8a");
        A = rowA.createCell(24);
        A.setCellValue(tdcs8a);

        Q = rowQ.createCell(25);
        Q.setCellValue("tdcs8b");
        A = rowA.createCell(25);
        A.setCellValue(tdcs8b);

        Q = rowQ.createCell(26);
        Q.setCellValue("notes6");
        A = rowA.createCell(26);
        A.setCellValue(notes6a);

        Q = rowQ.createCell(27);
        Q.setCellValue("tdcs9a");
        A = rowA.createCell(27);
        A.setCellValue(tdcs9a);

        Q = rowQ.createCell(28);
        Q.setCellValue("tdcs9b");
        A = rowA.createCell(28);
        A.setCellValue(tdcs9b);

        Q = rowQ.createCell(29);
        Q.setCellValue("notes9");
        A = rowA.createCell(29);
        A.setCellValue(notes9a);
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