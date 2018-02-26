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

public class ULMASconf extends AppCompatActivity {

    String QULMAS1, QULMAS2, QULMAS3, QULMAS4;

    String PatID, Date, Event, Session;

    JSONObject record;

    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulmasconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }



        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");


        QULMAS1 = Answers.getStringExtra("QULMAS1");
        QULMAS2 = Answers.getStringExtra("QULMAS2");
        QULMAS3 = Answers.getStringExtra("QULMAS3");
        QULMAS4 = Answers.getStringExtra("QULMAS4");



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


        ((TextView)findViewById(R.id.QULMAS1)).setText(String.valueOf(QULMAS1));
        ((TextView)findViewById(R.id.QULMAS2)).setText(String.valueOf(QULMAS2));
        ((TextView)findViewById(R.id.QULMAS3)).setText(String.valueOf(QULMAS3));
        ((TextView)findViewById(R.id.QULMAS4)).setText(String.valueOf(QULMAS4));



        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("ulmas1", QULMAS1);
        record.put("ulmas2", QULMAS2);
        record.put("ulmas3", QULMAS3);
        record.put("ulmas4", QULMAS4);
        record.put("redcap_event_name", Event);

        record.put("upper_limb_modified_ashworth_score_complete", "2");

    }

    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Upper Limb Modified Ashworth Score");
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
                                Intent PID = new Intent(ULMASconf.this, Forms.class);
                                PID.putExtra("PatientID", PatID);
                                PID.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
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
        public int totalpages = 1;

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
                canvas.drawText("Upper Limb Modified Ashworth Score", 15 , titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("Elbow (flexors): " + QULMAS1, 15, titleBaseLine + 274, paint);
                canvas.drawText("Elbow (extensors): " + QULMAS2, 15, titleBaseLine + 330, paint);
                canvas.drawText("Wrist/Fingers (flexors): " + QULMAS3, 15, titleBaseLine + 386, paint);
                canvas.drawText("Wrist/Fingers (extensors): " + QULMAS4, 15, titleBaseLine + 455, paint);


                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2*35, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 3 * 32, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = No increase in tone", 15, titleBaseLine + 4 * 35 + 13 - 20, paint);

                canvas.drawText("1 = Slight increase in tone manifested by catch and release or by minimal resistance at the end of the range of motion when affected", 15, titleBaseLine + 4 * 35 + 2 * 13 - 20, paint);
                canvas.drawText("    part(s) is moved in flexion or extension", 15, titleBaseLine + 4 * 35 + 3 * 13 - 20, paint);

                canvas.drawText("1+ = Slight increase in tone, manifested by at catch, followed by minimal resistance throughout the remainder (less than half) of the", 15, titleBaseLine + 4 * 35 + 4 * 13 - 20, paint);
                canvas.drawText("    range of motion", 15, titleBaseLine + 4 * 35 + 5 * 13 - 20, paint);

                canvas.drawText("2 = More marked increase in tone through most of the range of motion, but affected part(s) easily moved", 15, titleBaseLine + 4 * 35 + 6 * 13 - 20, paint);
                canvas.drawText("3 = Considerable increase in muscle tone - passive movement difficult", 15, titleBaseLine + 4 * 35 + 7 * 13 - 20, paint);
                canvas.drawText("4 = Affected part(s) rigid in flexion or extension", 15, titleBaseLine + 4 * 35 + 8 * 13 - 20, paint);


                canvas.drawText("Passively range the patient's elbow from maximum possible flexion to maximum possible extension in 1 second. Do not repeat", 15, titleBaseLine + 274 + 13, paint);
                canvas.drawText("more than 3 times.", 15, titleBaseLine + 274 + 2 * 13, paint);

                canvas.drawText("Passively range the patient's elbow from maximum possible extension to maximum possible flexion in 1 second. Do not repeat", 15, titleBaseLine + 330 + 13, paint);
                canvas.drawText("more than 3 times.", 15, titleBaseLine + 330 + 2 * 13, paint);

                canvas.drawText("With the patients elbow at 90 degrees and wrist pronated (palm down), passively range the patient's wrist from maximum possible", 15, titleBaseLine + 386 + 13, paint);
                canvas.drawText("flexion to maximum possible extension in 1 second while maintaining the MCPs, PIPs, and DIPs in 0 degree/neutral. Do not repeat", 15, titleBaseLine + 386 + 2 * 13, paint);
                canvas.drawText("more than 3 times.", 15, titleBaseLine + 386 + 3 * 13, paint);

                canvas.drawText("With the patients elbow at 90 degrees and wrist pronated (palm down), passively range the patient's wrist from maximum possible", 15, titleBaseLine + 455 + 13, paint);
                canvas.drawText("flexion to maximum possible extension in 1 second while maintaining the MCPs, PIPs, and DIPs in 0 degree/neutral. Do not repeat", 15, titleBaseLine + 455 + 2 * 13, paint);
                canvas.drawText("more than 3 times.", 15, titleBaseLine + 455 + 3 * 13, paint);

            }


        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Upper Limb Modified Ashworth Score " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Upper Limb Modified Ashworth Score " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null; //question cells
        Cell A = null; //answer cells

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Upper Limb Modified Ashworth Score");

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
        Q.setCellValue("Elbow (flexors)");
        A = rowA.createCell(3);
        A.setCellValue(QULMAS1);

        Q = rowQ.createCell(4);
        Q.setCellValue("Elbow (extensors)");
        A = rowA.createCell(4);
        A.setCellValue(QULMAS2);

        Q = rowQ.createCell(5);
        Q.setCellValue("Wrist/Fingers (flexors)");
        A = rowA.createCell(5);
        A.setCellValue(QULMAS3);

        Q = rowQ.createCell(6);
        Q.setCellValue("Wrist/Fingers (extensors)");
        A = rowA.createCell(6);
        A.setCellValue(QULMAS4);


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
