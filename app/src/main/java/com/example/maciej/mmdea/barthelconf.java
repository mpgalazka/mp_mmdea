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
import java.util.Objects;

public class barthelconf extends AppCompatActivity {


    Double BarthelQ1, BarthelQ2, BarthelQ3, BarthelQ4, BarthelQ5, BarthelQ6, BarthelQ7, BarthelQ8, BarthelQ9, BarthelQ10, BarthelQTotal;

    String PatID, Date, Event, Session;

    JSONObject record;

    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barthelconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }



        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");


        BarthelQ1 = Answers.getDoubleExtra("BarthelQ1", 0);
        BarthelQ2 = Answers.getDoubleExtra("BarthelQ2", 0);
        BarthelQ3 = Answers.getDoubleExtra("BarthelQ3", 0);
        BarthelQ4 = Answers.getDoubleExtra("BarthelQ4", 0);
        BarthelQ5 = Answers.getDoubleExtra("BarthelQ5", 0);
        BarthelQ6 = Answers.getDoubleExtra("BarthelQ6", 0);
        BarthelQ7 = Answers.getDoubleExtra("BarthelQ7", 0);
        BarthelQ8 = Answers.getDoubleExtra("BarthelQ8", 0);
        BarthelQ9 = Answers.getDoubleExtra("BarthelQ9", 0);
        BarthelQ10 = Answers.getDoubleExtra("BarthelQ10", 0);
        BarthelQTotal = Answers.getDoubleExtra("BarthelQTotal", 0);


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


        ((TextView)findViewById(R.id.barthel1)).setText(String.valueOf(BarthelQ1));
        ((TextView)findViewById(R.id.barthel2)).setText(String.valueOf(BarthelQ2));
        ((TextView)findViewById(R.id.barthel3)).setText(String.valueOf(BarthelQ3));
        ((TextView)findViewById(R.id.barthel4)).setText(String.valueOf(BarthelQ4));
        ((TextView)findViewById(R.id.barthel5)).setText(String.valueOf(BarthelQ5));
        ((TextView)findViewById(R.id.barthel6)).setText(String.valueOf(BarthelQ6));
        ((TextView)findViewById(R.id.barthel7)).setText(String.valueOf(BarthelQ7));
        ((TextView)findViewById(R.id.barthel8)).setText(String.valueOf(BarthelQ8));
        ((TextView)findViewById(R.id.barthel9)).setText(String.valueOf(BarthelQ9));
        ((TextView)findViewById(R.id.barthel10)).setText(String.valueOf(BarthelQ10));
        ((TextView)findViewById(R.id.bartheltotal)).setText(String.valueOf(BarthelQTotal) + "/100.0");


        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("barthelq1", BarthelQ1);
        record.put("barthelq2", BarthelQ2);
        record.put("barthelq3", BarthelQ3);
        record.put("barthelq4", BarthelQ4);
        record.put("barthelq5", BarthelQ5);
        record.put("barthelq6", BarthelQ6);
        record.put("barthelq7", BarthelQ7);
        record.put("barthelq8", BarthelQ8);
        record.put("barthelq9", BarthelQ9);
        record.put("barthelq10", BarthelQ10);
        record.put("barthelqtotal", BarthelQTotal);
        record.put("redcap_event_name", Event);

        record.put("barthel_complete", "2");




    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Barthel ADL Index");
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
                                Intent PID = new Intent(barthelconf.this, Forms.class);
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
            int leftMargin = 54;

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);


            if (pagenumber == 1){

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("Barthel ADL Index", leftMargin + 115, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("1.Feeding: " + BarthelQ1, 15, titleBaseLine + 4 * 35, paint);
                canvas.drawText("2.Bathing: " + BarthelQ2, 15, titleBaseLine + 6 * 35, paint);
                canvas.drawText("3.Grooming: " + BarthelQ3, 15, titleBaseLine + 8 * 35, paint);
                canvas.drawText("4.Dressing: " + BarthelQ4, 15, titleBaseLine + 10 * 35, paint);
                canvas.drawText("5.Bowels: " + BarthelQ5, 15, titleBaseLine + 12 * 35, paint);
                canvas.drawText("6.Bladder: " + BarthelQ6, 15, titleBaseLine + 14 * 35, paint);
                canvas.drawText("7.Toilet Use: " + BarthelQ7, 15, titleBaseLine + 16 * 35, paint);
                canvas.drawText("8.Transfers (bed to chair and back): " + BarthelQ8, 15, titleBaseLine + 18 * 35, paint);

                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2*35, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 3 * 32, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = unable", 15, titleBaseLine + 4 * 35 + 13, paint);
                canvas.drawText("5 = needs help cutting, spreading butter, etc., or requires modified diet", 15, titleBaseLine + 4 * 35 + 2 * 13, paint);
                canvas.drawText("10 = independent", 15, titleBaseLine + 4 * 35 + 3 * 13, paint);

                canvas.drawText("0 = dependent", 15, titleBaseLine + 6 * 35 + 13, paint);
                canvas.drawText("5 = independent (or in shower)", 15, titleBaseLine + 6 * 35 + 2*13, paint);

                canvas.drawText("0 = needs to help with personal care", 15, titleBaseLine + 8 * 35 + 13, paint);
                canvas.drawText("5 = independent face/hair/teeth/shaving (implements provided)", 15, titleBaseLine + 8 * 35 + 2*13, paint);

                canvas.drawText("0 = dependent", 15, titleBaseLine + 10 * 35 + 13, paint);
                canvas.drawText("5 = needs help but can do about half unaided", 15, titleBaseLine + 10 * 35 + 2*13, paint);
                canvas.drawText("10 = independent (including buttons, zips, laces, etc.)", 15, titleBaseLine + 10 * 35 + 3*13, paint);

                canvas.drawText("0 = incontinent (or needs to be given enemas)", 15, titleBaseLine + 12 * 35 + 13, paint);
                canvas.drawText("5 = occasional accident", 15, titleBaseLine + 12 * 35 + 2*13, paint);
                canvas.drawText("10 =  continent", 15, titleBaseLine + 12 * 35 + 3*13, paint);

                canvas.drawText("0 = incontinent, or catheterized and unable to manage alone", 15, titleBaseLine + 14 * 35 + 13, paint);
                canvas.drawText("5 = occasional accident", 15, titleBaseLine + 14 * 35 + 2*13, paint);
                canvas.drawText("10 =  continent", 15, titleBaseLine + 14 * 35 + 3*13, paint);

                canvas.drawText("0 = dependent", 15, titleBaseLine + 16 * 35 + 13, paint);
                canvas.drawText("5 = needs some help, but can do something alone", 15, titleBaseLine + 16 * 35 + 2*13, paint);
                canvas.drawText("10 =  independent", 15, titleBaseLine + 16 * 35 + 3*13, paint);

                canvas.drawText("0 = unable, no sitting balance", 15, titleBaseLine + 18 * 35 + 13, paint);
                canvas.drawText("5 = major help (one or two people, physical), can sit", 15, titleBaseLine + 18 * 35 + 2*13, paint);
                canvas.drawText("10 =  minor help (verbal or physical)", 15, titleBaseLine + 18 * 35 + 3*13, paint);
                canvas.drawText("15 = independent", 15, titleBaseLine + 18 * 35 + 4*13, paint);

            }

            else if (pagenumber == 2){

                paint.setTextSize(20);
                canvas.drawText("9.Mobility (on level surfaces): " + BarthelQ9, 15, titleBaseLine, paint);
                canvas.drawText("10.Stairs: " + BarthelQ10, 15, titleBaseLine + 2 * 35 + 10, paint);
                canvas.drawText("Total: " + BarthelQTotal + "/100.0", 15, titleBaseLine + 5 * 35 + 10, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = immobile or less than 50 yards", 15, titleBaseLine + 13, paint);
                canvas.drawText("5 = wheelchair independent, including corners, greater than 50 yards", 15, titleBaseLine + 2 * 13, paint);
                canvas.drawText("10 =  walks with help of one person (verbal or physical) greater than 50 yards", 15, titleBaseLine + 3 * 13, paint);
                canvas.drawText("15 = independent (but may use any aid; for example, stick) greater than 50 yards", 15, titleBaseLine + 4 * 13, paint);

                canvas.drawText("0 = unable", 15, titleBaseLine + 2 * 35 + 13 + 10, paint);
                canvas.drawText("5 = needs help (verbal, physical, carrying aid)", 15, titleBaseLine + 2 * 35 + 2*13 + 10, paint);
                canvas.drawText("10 = independent", 15, titleBaseLine + 2 * 35 + 3 * 13 + 10, paint);




                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC));
                canvas.drawText("The Barthel ADL Index: Guidelines", 15, titleBaseLine + 250, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("1. The index should be used as a record of what a patient does, not as a record of what a patient could do.", 15, titleBaseLine + 250 + 13, paint);
                canvas.drawText("2. The main aim is to establish degree of independence from any help, physical or verbal, however minor and for whatever reason.", 15, titleBaseLine + 250 + 2 * 13, paint);
                canvas.drawText("3. The need for supervision renders the patient not independent.", 15, titleBaseLine + 250 + 3 * 13, paint);
                canvas.drawText("4. A patients performance should be established using the best available evidence. Asking the patient, friends/relatives, and", 15, titleBaseLine + 250 + 4 * 13, paint);
                canvas.drawText("nurses will be the usual source, but direct observation and common sense are also important. However, direct testing is not needed.", 15, titleBaseLine + 250 + 5 * 13, paint);
                canvas.drawText("5. Usually the performance over the preceding 24 – 48 hours is important, but occasionally longer periods will be relevant.", 15, titleBaseLine + 250 + 6 * 13, paint);
                canvas.drawText("6. Middle categories imply that the patient supplies over 50% of the effort.", 15, titleBaseLine + 250 + 7 * 13, paint);
                canvas.drawText("7. Use of aids to be independent is allowed.", 15, titleBaseLine + 250 + 8 * 13, paint);


            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Barthel ADL Index " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Barthel ADL Index " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Barthel ADL Index");

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
        Q.setCellValue("Feeding");
        A = rowA.createCell(3);
        A.setCellValue(BarthelQ1);

        Q = rowQ.createCell(4);
        Q.setCellValue("Bathing");
        A = rowA.createCell(4);
        A.setCellValue(BarthelQ2);

        Q = rowQ.createCell(5);
        Q.setCellValue("Grooming");
        A = rowA.createCell(5);
        A.setCellValue(BarthelQ3);

        Q = rowQ.createCell(6);
        Q.setCellValue("Dressing");
        A = rowA.createCell(6);
        A.setCellValue(BarthelQ4);

        Q = rowQ.createCell(7);
        Q.setCellValue("Bowels");
        A = rowA.createCell(7);
        A.setCellValue(BarthelQ5);

        Q = rowQ.createCell(8);
        Q.setCellValue("Bladder");
        A = rowA.createCell(8);
        A.setCellValue(BarthelQ6);

        Q = rowQ.createCell(9);
        Q.setCellValue("Toilet Use");
        A = rowA.createCell(9);
        A.setCellValue(BarthelQ7);

        Q = rowQ.createCell(10);
        Q.setCellValue("Transfers (bed to chair and back)");
        A = rowA.createCell(10);
        A.setCellValue(BarthelQ8);

        Q = rowQ.createCell(11);
        Q.setCellValue("Mobility (on level surfaces)");
        A = rowA.createCell(11);
        A.setCellValue(BarthelQ9);

        Q = rowQ.createCell(12);
        Q.setCellValue("Stairs");
        A = rowA.createCell(12);
        A.setCellValue(BarthelQ10);

        Q = rowQ.createCell(13);
        Q.setCellValue("Total");
        A = rowA.createCell(13);
        A.setCellValue(BarthelQTotal);



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

