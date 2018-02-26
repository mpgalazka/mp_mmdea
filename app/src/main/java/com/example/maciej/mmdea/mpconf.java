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
/**
 * Created by RAZA on 4/4/2016.
 */
public class mpconf extends AppCompatActivity {

    Double mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20, mpqTotal,mpqTotal1,mpqTotal2;

    String PatID, Date, Event, Session;

    JSONObject record;

    HttpResponse response;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }




        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");


        mp1 = Answers.getDoubleExtra("mp1", 0);
        mp2 = Answers.getDoubleExtra("mp2", 0);
        mp3 = Answers.getDoubleExtra("mp3", 0);
        mp4 = Answers.getDoubleExtra("mp4", 0);
        mp5 = Answers.getDoubleExtra("mp5", 0);
        mp6 = Answers.getDoubleExtra("mp6", 0);
        mp7 = Answers.getDoubleExtra("mp7", 0);
        mp8 = Answers.getDoubleExtra("mp8", 0);
        mp9 = Answers.getDoubleExtra("mp9", 0);
        mp10 = Answers.getDoubleExtra("mp10", 0);
        mp11 = Answers.getDoubleExtra("mp11", 0);
        mp12 = Answers.getDoubleExtra("mp12", 0);
        mp13 = Answers.getDoubleExtra("mp13", 0);
        mp14 = Answers.getDoubleExtra("mp14", 0);
        mp15 = Answers.getDoubleExtra("mp15", 0);
        mp16 = Answers.getDoubleExtra("mp16", 0);
        mp17 = Answers.getDoubleExtra("mp17", 0);
        mp18 = Answers.getDoubleExtra("mp18", 0);
        mp19 = Answers.getDoubleExtra("mp19", 0);
        mp20 = Answers.getDoubleExtra("mp20", 0);
        mpqTotal = Answers.getDoubleExtra("mpqTotal", 0);
        mpqTotal1 = Answers.getDoubleExtra("mpqTotal1", 0);
        mpqTotal2 = Answers.getDoubleExtra("mpqTotal2", 0);



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


        ((TextView)findViewById(R.id.mpp1)).setText(String.valueOf(mp1));
        ((TextView)findViewById(R.id.mpp2)).setText(String.valueOf(mp2));
        ((TextView)findViewById(R.id.mpp3)).setText(String.valueOf(mp3));
        ((TextView)findViewById(R.id.mpp4)).setText(String.valueOf(mp4));
        ((TextView)findViewById(R.id.mpp5)).setText(String.valueOf(mp5));
        ((TextView)findViewById(R.id.mpp6)).setText(String.valueOf(mp6));
        ((TextView)findViewById(R.id.mpp7)).setText(String.valueOf(mp7));
        ((TextView)findViewById(R.id.mpp8)).setText(String.valueOf(mp8));
        ((TextView)findViewById(R.id.mpp9)).setText(String.valueOf(mp9));
        ((TextView)findViewById(R.id.mpp10)).setText(String.valueOf(mp10));
        ((TextView)findViewById(R.id.mpp11)).setText(String.valueOf(mp11));
        ((TextView)findViewById(R.id.mpp12)).setText(String.valueOf(mp12));
        ((TextView)findViewById(R.id.mpp13)).setText(String.valueOf(mp13));
        ((TextView)findViewById(R.id.mpp14)).setText(String.valueOf(mp14));
        ((TextView)findViewById(R.id.mpp15)).setText(String.valueOf(mp15));
        ((TextView)findViewById(R.id.mpp16)).setText(String.valueOf(mp16));
        ((TextView)findViewById(R.id.mpp17)).setText(String.valueOf(mp17));
        ((TextView)findViewById(R.id.mpp18)).setText(String.valueOf(mp18));
        ((TextView)findViewById(R.id.mpp19)).setText(String.valueOf(mp19));
        ((TextView)findViewById(R.id.mpp20)).setText(String.valueOf(mp20));
        ((TextView)findViewById(R.id.mppqT)).setText(String.valueOf(mpqTotal));
        ((TextView)findViewById(R.id.mppqT1)).setText(String.valueOf(mpqTotal1));
        ((TextView)findViewById(R.id.mppqT2)).setText(String.valueOf(mpqTotal2));




        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("mp1", mp1);
        record.put("mp2", mp2);
        record.put("mp3", mp3);
        record.put("mp4", mp4);
        record.put("mp5", mp5);
        record.put("mp6", mp6);
        record.put("mp7", mp7);
        record.put("mp8", mp8);
        record.put("mp9", mp9);
        record.put("mp10", mp10);
        record.put("mp11", mp11);
        record.put("mp12", mp12);
        record.put("mp13", mp13);
        record.put("mp14", mp14);
        record.put("mp15", mp15);
        record.put("mp16", mp16);
        record.put("mp17", mp17);
        record.put("mp18", mp18);
        record.put("mp19", mp19);
        record.put("mp20", mp20);
        record.put("mptotal", mpqTotal);
        record.put("mptotal1", mpqTotal1);
        record.put("mptotal2", mpqTotal2);

        record.put("redcap_event_name", Event);

        record.put("motor_power_complete", "2");




    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Motor Power");
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
                                Intent PID = new Intent(mpconf.this, Forms.class);
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
                canvas.drawText("Motor Power (MP) Scale", leftMargin + 90, titleBaseLine, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                paint.setTextSize(15);


                canvas.drawText("Use for reference: ", 15, titleBaseLine + 4 * 35, paint);

                paint.setTextSize(12);
                canvas.drawText("0 = no contraction ", 15, titleBaseLine + 4 * 35 + 13, paint);
                canvas.drawText("1 = trace contraction ", 15, titleBaseLine + 4 * 35 + 2 * 13, paint);
                canvas.drawText("2 = active movement possible with gravity eliminated or limb supported by examiner ", 15, titleBaseLine + 4 * 35 + 3 * 13, paint);
                canvas.drawText("3 = anti-gravity strength ", 15, titleBaseLine + 4 * 35 + 4*13, paint);
                canvas.drawText("4 = reduced function but adequate to overcome some resistance ", 15, titleBaseLine + 4 * 35 + 5*13, paint);
                canvas.drawText("5 = normal strength ", 15, titleBaseLine + 4 * 35 + 6*13, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("1. Scapular Abduction/Upward Rotation (Serratus Anterior): " + mp1, 15, titleBaseLine + 7 * 35, paint);
                canvas.drawText("2. Scapular Elevation (Upper Trapezius, Levator Scapulae): " + mp2, 15, titleBaseLine + 8 * 35, paint);
                canvas.drawText("3. Scapular Adduction (Middle Trapezius, Rhomboid Major): " + mp3, 15, titleBaseLine + 9 * 35, paint);
                canvas.drawText("4. Scapular Adduction/Depression (lower Trapezius): " + mp4, 15, titleBaseLine + 10 * 35, paint);
                canvas.drawText("5. Scapular Adduction/Downward Rotation (Rhomboid Major/Minor): " + mp5, 15, titleBaseLine + 11 * 35, paint);
                canvas.drawText("6. Shoulder Flexion (Deltoid, Coracobrachialis, Rotator Cuff): " + mp6, 15, titleBaseLine + 12 * 35, paint);
                canvas.drawText("7. Shoulder Extension (Latissimus Dorsi, Teres Major, Posterior Deltoid): " + mp7, 15, titleBaseLine + 13 * 35, paint);
                canvas.drawText("8. Shoulder Abduction (Deltoid Supraspinatus): " + mp8, 15, titleBaseLine + 14 * 35, paint);
                canvas.drawText("9. Shoulder Horizontal Adduction (Pectoralis Major): " + mp9, 15, titleBaseLine + 15 * 35, paint);
                canvas.drawText("10. Shoulder Horizontal Abduction (Posterior  Deltoid): " + mp10, 15, titleBaseLine + 16 * 35, paint);
                canvas.drawText("11. Shoulder External Rotation (Infraspinatus, Teres Minor): " + mp11, 15, titleBaseLine + 17 * 35, paint);
                canvas.drawText("12. Shoulder Internal Rotation (Subcap., Pec Major, Latissimus, Teres Major): " + mp12, 15, titleBaseLine + 18 * 35, paint);
                canvas.drawText("13. Elbow Flexion (Biceps Brachii, Brachialis, Brachioradialis): " + mp13, 15, titleBaseLine + 19 * 35, paint);
                canvas.drawText("14. Elbow Extension (Triceps Brachii): " + mp14, 15, titleBaseLine + 20 * 35, paint);


                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 35, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 3 * 32, paint);

            }

            else if (pagenumber == 2){

                paint.setTextSize(10);

                canvas.drawText("15. Wrist Pronation: " + mp15, 15, titleBaseLine, paint);
                canvas.drawText("16. Wrist Supination: " + mp16, 15, titleBaseLine + 1 * 35, paint);
                canvas.drawText("17. Wrist Flexion: " + mp17, 15, titleBaseLine + 2 * 35, paint);
                canvas.drawText("18. Wrist Extension: " + mp18, 15, titleBaseLine + 3 * 35, paint);
                canvas.drawText("19. Radial Deviation: " + mp19, 15, titleBaseLine + 4 * 35, paint);
                canvas.drawText("20. Ulnar Deviation: " + mp20, 15, titleBaseLine + 5 * 35, paint);

                paint.setTextSize(14);
                canvas.drawText(" Total (1-14): " + mpqTotal1, 15, titleBaseLine + 7 * 35 + 10, paint);
                canvas.drawText(" Total (15-20): " + mpqTotal2, 15, titleBaseLine + 8 * 35 + 10, paint);
                canvas.drawText(" Grand Total: " + mpqTotal, 15, titleBaseLine + 9 * 35 + 10, paint);


            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Motor Power " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }


    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Motor Power " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Motor Power");

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
        Q.setCellValue("mpq1");
        A = rowA.createCell(3);
        A.setCellValue(mp1);

        Q = rowQ.createCell(4);
        Q.setCellValue("mpq2");
        A = rowA.createCell(4);
        A.setCellValue(mp2);

        Q = rowQ.createCell(5);
        Q.setCellValue("mpq3");
        A = rowA.createCell(5);
        A.setCellValue(mp3);

        Q = rowQ.createCell(6);
        Q.setCellValue("mpq4");
        A = rowA.createCell(6);
        A.setCellValue(mp4);

        Q = rowQ.createCell(7);
        Q.setCellValue("mpq5");
        A = rowA.createCell(7);
        A.setCellValue(mp5);

        Q = rowQ.createCell(8);
        Q.setCellValue("mpq6");
        A = rowA.createCell(8);
        A.setCellValue(mp6);

        Q = rowQ.createCell(9);
        Q.setCellValue("mpq7");
        A = rowA.createCell(9);
        A.setCellValue(mp7);

        Q = rowQ.createCell(10);
        Q.setCellValue("mpq8");
        A = rowA.createCell(10);
        A.setCellValue(mp8);

        Q = rowQ.createCell(11);
        Q.setCellValue("mpq9");
        A = rowA.createCell(11);
        A.setCellValue(mp9);

        Q = rowQ.createCell(12);
        Q.setCellValue("mpq10");
        A = rowA.createCell(12);
        A.setCellValue(mp10);

        Q = rowQ.createCell(13);
        Q.setCellValue("mpq11");
        A = rowA.createCell(13);
        A.setCellValue(mp11);

        Q = rowQ.createCell(14);
        Q.setCellValue("mpq12");
        A = rowA.createCell(14);
        A.setCellValue(mp12);

        Q = rowQ.createCell(15);
        Q.setCellValue("mpq13");
        A = rowA.createCell(15);
        A.setCellValue(mp13);

        Q = rowQ.createCell(16);
        Q.setCellValue("mpq14");
        A = rowA.createCell(16);
        A.setCellValue(mp14);

        Q = rowQ.createCell(17);
        Q.setCellValue("mpq15");
        A = rowA.createCell(17);
        A.setCellValue(mp15);

        Q = rowQ.createCell(18);
        Q.setCellValue("mpq16");
        A = rowA.createCell(18);
        A.setCellValue(mp16);

        Q = rowQ.createCell(19);
        Q.setCellValue("mpq17");
        A = rowA.createCell(19);
        A.setCellValue(mp17);

        Q = rowQ.createCell(20);
        Q.setCellValue("mpq18");
        A = rowA.createCell(20);
        A.setCellValue(mp18);

        Q = rowQ.createCell(21);
        Q.setCellValue("mpq19");
        A = rowA.createCell(21);
        A.setCellValue(mp19);

        Q = rowQ.createCell(22);
        Q.setCellValue("mpq20");
        A = rowA.createCell(22);
        A.setCellValue(mp20);

        Q = rowQ.createCell(23);
        Q.setCellValue("mptotal1");
        A = rowA.createCell(23);
        A.setCellValue(mpqTotal1);

        Q = rowQ.createCell(24);
        Q.setCellValue("mptotal2");
        A = rowA.createCell(24);
        A.setCellValue(mpqTotal2);

        Q = rowQ.createCell(25);
        Q.setCellValue("mptotal");
        A = rowA.createCell(25);
        A.setCellValue(mpqTotal);

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
