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
public class Lextremityconf extends AppCompatActivity {

    String PatID, Date, Event, joined, Session;
    Double LExtrmt_QTotal, LExtrmt_1a, LExtrmt_1b, LExtrmt_2a, LExtrmt_2b, LExtrmt_2c, LExtrmt_3a, LExtrmt_3b,
            LExtrmt_3c, LExtrmt_3d, LExtrmt_4a, LExtrmt_4b, LExtrmt_5a, LExtrmt_5b, LExtrmt_6a, LExtrmt_7a, LExtrmt_7b, LExtrmt_7c;
    TextView patientID, currentDateTimeString, LExtrmt_totalconf;


// /use notes1 etc for the conf pg variables


    HttpResponse response;

    JSONObject record;

    //make new strings for new checkbox textboxes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lextremityconf);


        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }


        Intent Answers = this.getIntent();
        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");

        //radiobuttons
        LExtrmt_1a = Answers.getDoubleExtra("LExtrmt_1a", 0);
        LExtrmt_1b = Answers.getDoubleExtra("LExtrmt_1b", 0);
        LExtrmt_2a = Answers.getDoubleExtra("LExtrmt_2a", 0);
        LExtrmt_2b = Answers.getDoubleExtra("LExtrmt_2b", 0);
        LExtrmt_2c = Answers.getDoubleExtra("LExtrmt_2c", 0);

        LExtrmt_3a = Answers.getDoubleExtra("LExtrmt_3a", 0);
        LExtrmt_3b = Answers.getDoubleExtra("LExtrmt_3b", 0);
        LExtrmt_3c = Answers.getDoubleExtra("LExtrmt_3c", 0);
        LExtrmt_3d = Answers.getDoubleExtra("LExtrmt_3d", 0);

        LExtrmt_4a = Answers.getDoubleExtra("LExtrmt_4a", 0);
        LExtrmt_4b = Answers.getDoubleExtra("LExtrmt_4b", 0);
        LExtrmt_5a = Answers.getDoubleExtra("LExtrmt_5a", 0);
        LExtrmt_5b = Answers.getDoubleExtra("LExtrmt_5b", 0);
        LExtrmt_6a = Answers.getDoubleExtra("LExtrmt_6a", 0);

        LExtrmt_7a = Answers.getDoubleExtra("LExtrmt_7a", 0);
        LExtrmt_7b = Answers.getDoubleExtra("LExtrmt_7b", 0);
        LExtrmt_7c = Answers.getDoubleExtra("LExtrmt_7c", 0);
        LExtrmt_QTotal = Answers.getDoubleExtra("LExtrmt_QTotal", 0);


        Session = Answers.getStringExtra("Session");

        if (Objects.equals("pp1_arm_1", Event)) {
            Session = "PP1";
        } else if (Objects.equals("pp2_arm_1", Event)) {
            Session = "PP2";
        } else if (Objects.equals("fu_arm_1", Event)) {
            Session = "FU";
        } else if (Objects.equals("adm_arm_1", Event)) {
            Session = "ADM";
        } else if (Objects.equals("dc_arm_1", Event)) {
            Session = "DC";
        } else if (Objects.equals("mp_arm_1", Event)) {
            Session = "MP";
        }


        ((TextView) findViewById(R.id.conDate)).setText(String.valueOf("Date: " + Date));
        ((TextView) findViewById(R.id.conPatID)).setText(String.valueOf(PatID));
        ((TextView) findViewById(R.id.conSession)).setText(String.valueOf(Session));

        //radiobuttons
        ((TextView) findViewById(R.id.LExtrmt_1a0pre)).setText(String.valueOf(LExtrmt_1a));
        ((TextView) findViewById(R.id.LExtrmt_1b0pre)).setText(String.valueOf(LExtrmt_1b));

        ((TextView) findViewById(R.id.LExtrmt_2a0pre)).setText(String.valueOf(LExtrmt_2a));
        ((TextView) findViewById(R.id.LExtrmt_2b0pre)).setText(String.valueOf(LExtrmt_2b));
        ((TextView) findViewById(R.id.LExtrmt_2c0pre)).setText(String.valueOf(LExtrmt_2c));

        ((TextView) findViewById(R.id.LExtrmt_3a0pre)).setText(String.valueOf(LExtrmt_3a));
        ((TextView) findViewById(R.id.LExtrmt_3b0pre)).setText(String.valueOf(LExtrmt_3b));
        ((TextView) findViewById(R.id.LExtrmt_3c0pre)).setText(String.valueOf(LExtrmt_3c));
        ((TextView) findViewById(R.id.LExtrmt_3d0pre)).setText(String.valueOf(LExtrmt_3d));

        ((TextView) findViewById(R.id.LExtrmt_4a0pre)).setText(String.valueOf(LExtrmt_4a));
        ((TextView) findViewById(R.id.LExtrmt_4b0pre)).setText(String.valueOf(LExtrmt_4b));
        ((TextView) findViewById(R.id.LExtrmt_5a0pre)).setText(String.valueOf(LExtrmt_5a));
        ((TextView) findViewById(R.id.LExtrmt_5b0pre)).setText(String.valueOf(LExtrmt_5b));
        ((TextView) findViewById(R.id.LExtrmt_6a0pre)).setText(String.valueOf(LExtrmt_6a));

        ((TextView) findViewById(R.id.LExtrmt_7a0pre)).setText(String.valueOf(LExtrmt_7a));
        ((TextView) findViewById(R.id.LExtrmt_7b0pre)).setText(String.valueOf(LExtrmt_7b));
        ((TextView) findViewById(R.id.LExtrmt_7c0pre)).setText(String.valueOf(LExtrmt_7c));
        ((TextView) findViewById(R.id.LExtrmt_Totalconf)).setText(String.valueOf(String.valueOf(LExtrmt_QTotal)));

//    ((TextView) findViewById(R.id.LExtrmt_total)).setText(String.valueOf(LExtrmt_7c+LExtrmt_7c+LExtrmt_7c);


        //for REDCap variables
        record = new JSONObject();
            record.put("record_id", PatID);
            record.put("lextrmt_q1a", LExtrmt_1a);
            record.put("lextrmt_q1b", LExtrmt_1b);
            record.put("lextrmt_q2a", LExtrmt_2a);
            record.put("lextrmt_q2b", LExtrmt_2b);
            record.put("lextrmt_q2c", LExtrmt_2c);

            record.put("lextrmt_q3a", LExtrmt_3a);
            record.put("lextrmt_q3b", LExtrmt_3b);
            record.put("lextrmt_q3c", LExtrmt_3c);
            record.put("lextrmt_q3d", LExtrmt_3d);

            record.put("lextrmt_q4a", LExtrmt_4a);
            record.put("lextrmt_q4b", LExtrmt_4b);
            record.put("lextrmt_q5a", LExtrmt_5a);
            record.put("lextrmt_q5b", LExtrmt_5b);
            record.put("lextrmt_q6a", LExtrmt_6a);

            record.put("lextrmt_q7a", LExtrmt_7a);
            record.put("lextrmt_q7b", LExtrmt_7b);
            record.put("lextrmt_q7c", LExtrmt_7c);
            record.put("lextrmt_qtotal", LExtrmt_QTotal);
            record.put("redcap_event_name", Event);


            record.put("lower_extremity_complete", "2");


    }


    //Return to Forms List

    public void ReturnToForms(View view) {
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close L. Extremity Questionnaire");
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
                                Intent PID = new Intent(Lextremityconf.this, Forms.class);
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
        alertclose.setIcon(R.mipmap.ic_launcher);
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
            alertDialog.setIcon(R.mipmap.ic_launcher);
            alertDialog.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Success");
            alertDialog.setMessage("Successfully uploaded to REDCap");
            alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.setIcon(R.mipmap.ic_launcher);
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
                            final PrintDocumentAdapter.WriteResultCallback callback) {

            for (int i = 0; i < totalpages; i++) {
                if (pageInRange(pageRanges, i)) {
                    PdfDocument.PageInfo newPage = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i).create();

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

            int titleBaseLine = 74;
            int leftMargin = 98;

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);


            if (pagenumber == 1) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(33);
                canvas.drawText("Lower Extremity Questionnaire", leftMargin, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 4 * 25, paint);


                paint.setTextSize(10);
                canvas.drawText("I. Reflex Activity: ", 15, titleBaseLine + 6 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = No reflex elicited; 2 = Reflex elicited ", 15, titleBaseLine + 7 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   1a.Achilles: " + LExtrmt_1a, 15, titleBaseLine + 8 * 25, paint);
                canvas.drawText("   1b.Patelar: " + LExtrmt_1b, 15, titleBaseLine + 9 * 25, paint);

                canvas.drawText("II. Flexor Synergy: ", 15, titleBaseLine + 11 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = No Motion; 1 = Partial Motion; 2 = Full Motion ", 15, titleBaseLine + 12 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   2a.Hip flexion:   " + LExtrmt_2a, 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("   2b.Knee flexion: " + LExtrmt_2b, 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("   2c.Ankle dorsiflexion: " + LExtrmt_2c, 15, titleBaseLine + 15 * 25, paint);

                canvas.drawText("III. Extensor Synergy: ", 15, titleBaseLine + 17 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = No Motion; 1 = Partial Motion; 2 = Full Motion ", 18, titleBaseLine + 18 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   3a.Hip extension: " + LExtrmt_3a, 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("   3b.Adduction: " + LExtrmt_3b, 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("   3c.Knee extension: " + LExtrmt_3c, 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("   3d.Ankle plantar flexion: " + LExtrmt_3d, 15, titleBaseLine + 22 * 25, paint);

                canvas.drawText("IV.Combined Synergies: ", 15, titleBaseLine + 24 * 25, paint);
                canvas.drawText("   4a.Knee flexion beyond 90o: " + LExtrmt_4a, 15, titleBaseLine + 25 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = No active motion; 1 =Knee can be fixed but not beyond 90 degrees ", 15, titleBaseLine + 26 * 25, paint);
                canvas.drawText(" 2 = Knee flexion beyond 90 degrees ", 15, titleBaseLine + 27 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   4b.Ankle dorsiflexion: " + LExtrmt_4b, 15, titleBaseLine + 29 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = No active motion; 1 =Incomplete  active flexion; 2 =Normal dorsiflexion", 15, titleBaseLine + 30 * 25, paint);
                paint.setTextSize(10);

                //new page

            } else if (pagenumber == 2) {

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);

                canvas.drawText("V. Movement out of Synergy: ", 15, titleBaseLine + 1 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = Knee cannot flex w/o hip flexion; 1 = Knee begins flexion w/o hip flexion ", 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("2 = Full motion ", 15, titleBaseLine + 3 * 25, paint);

                paint.setTextSize(10);
                canvas.drawText("   5a.Knee flexion: " + LExtrmt_5a, 15, titleBaseLine + 4 * 25, paint);
                canvas.drawText("   5b.Ankle dorsiflexion: " + LExtrmt_5b, 15, titleBaseLine + 5 * 25, paint);

                canvas.drawText("VI. Normal Reflexes: ", 15, titleBaseLine + 7 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = Markedly hyperactive reflexes; 1 = At least 2 reflexes are lively; 2 =No hyperactive reflexes ", 15, titleBaseLine + 8 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("  Knee flexor, patellar, Achilles " + LExtrmt_6a, 15, titleBaseLine + 9 * 25, paint);


                canvas.drawText("VII.Coodinations and Speed: ", 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("   7a.Tremor: " + LExtrmt_7a, 15, titleBaseLine + 13 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = Marked tremor; 1 = Slight tremor; 2 = No tremor", 15, titleBaseLine + 14 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   7b.Dysmetria: " + LExtrmt_7b, 15, titleBaseLine + 16 * 25, paint);

                paint.setTextSize(8);
                canvas.drawText("0 = Pronounced unsymetric dysmetria; 1 = Symetric dysmetria; 2 = No dysmetria ", 15, titleBaseLine + 17 * 25, paint);
                paint.setTextSize(10); canvas.drawText("   7c.Speed: " + LExtrmt_7c, 15, titleBaseLine + 19 * 25, paint);
                paint.setTextSize(8);
                canvas.drawText("0 = More than 6 seconds longer; 1 = 2-5.9 seconds longers; 2 = Less than 2 seconds diffference ", 15, titleBaseLine + 20 * 25, paint);
                paint.setTextSize(10);
                canvas.drawText("   LOWER EXTREMITY TOTAL: " + LExtrmt_QTotal + "/34", 15, titleBaseLine + 22 * 25, paint);

                canvas.drawText("   End of Report ", 15, titleBaseLine + 24 * 25, paint);


                //just in case we can seperate the top line into this bottom one as well, but itll add a page to pdf
                //canvas.drawText("Other Programs of interest: " + interest6a, 15, titleBaseLine2 + 22 * 25, paint);


            }

        }


    }

    public void printDocument(View view) {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Motor Function-Lower Extremity" + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }


    // Excel Stuff Below

    public void Excel(View view) {

        saveExcelFile(this, PatID + "Motor Function-Lower Extremity " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Lower Extremity Questionnaire");

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
        Q.setCellValue("LExtrmt_1a");
        A = rowA.createCell(3);
        A.setCellValue(LExtrmt_1a);

        Q = rowQ.createCell(4);
        Q.setCellValue("LExtrmt_1b");
        A = rowA.createCell(4);
        A.setCellValue(LExtrmt_1b);

        Q = rowQ.createCell(5);
        Q.setCellValue("LExtrmt_2a");
        A = rowA.createCell(5);
        A.setCellValue(LExtrmt_2a);

        Q = rowQ.createCell(6);
        Q.setCellValue("LExtrmt_2b");
        A = rowA.createCell(6);
        A.setCellValue(LExtrmt_2b);

        Q = rowQ.createCell(7);
        Q.setCellValue("LExtrmt_2c");
        A = rowA.createCell(7);
        A.setCellValue(LExtrmt_2c);

        Q = rowQ.createCell(8);
        Q.setCellValue("LExtrmt_3a");
        A = rowA.createCell(8);
        A.setCellValue(LExtrmt_3a);


        Q = rowQ.createCell(9);
        Q.setCellValue("LExtrmt_3a");
        A = rowA.createCell(9);
        A.setCellValue(LExtrmt_3a);

        Q = rowQ.createCell(10);
        Q.setCellValue("LExtrmt_3c");
        A = rowA.createCell(10);
        A.setCellValue(LExtrmt_3c);

        Q = rowQ.createCell(11);
        Q.setCellValue("LExtrmt_3d");
        A = rowA.createCell(11);
        A.setCellValue(LExtrmt_3d);

        Q = rowQ.createCell(12);
        Q.setCellValue("LExtrmt_4a");
        A = rowA.createCell(12);
        A.setCellValue(LExtrmt_4a);

        Q = rowQ.createCell(13);
        Q.setCellValue("LExtrmt_4b");
        A = rowA.createCell(13);
        A.setCellValue(LExtrmt_4b);

        Q = rowQ.createCell(14);
        Q.setCellValue("LExtrmt_5a");
        A = rowA.createCell(14);
        A.setCellValue(LExtrmt_5a);

        Q = rowQ.createCell(15);
        Q.setCellValue("LExtrmt_5b");
        A = rowA.createCell(15);
        A.setCellValue(LExtrmt_5b);

        Q = rowQ.createCell(16);
        Q.setCellValue("LExtrmt_6a");
        A = rowA.createCell(16);
        A.setCellValue(LExtrmt_6a);


        Q = rowQ.createCell(17);
        Q.setCellValue("LExtrmt_7a");
        A = rowA.createCell(17);
        A.setCellValue(LExtrmt_7a);

        Q = rowQ.createCell(18);
        Q.setCellValue("LExtrmt_7b");
        A = rowA.createCell(18);
        A.setCellValue(LExtrmt_7b);

        Q = rowQ.createCell(19);
        Q.setCellValue("LExtrmt_7c");
        A = rowA.createCell(19);
        A.setCellValue(LExtrmt_7c);

        Q = rowQ.createCell(20);
        Q.setCellValue("LExtrmt_QTotal");
        A = rowA.createCell(20);
        A.setCellValue(LExtrmt_QTotal);


//

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

//    // Create a path where we will place our List of objects on external storage
//    File[] fs = context.getExternalFilesDirs(null);
//    String extpath = "";
//    if (fs != null && fs.length >= 2)
//    {
//        extpath = fs[1].getAbsolutePath();
//        Log.e("SD Path", fs[1].getAbsolutePath());
//    }
//    File file = new File(extpath, fileName);
//    FileOutputStream os = null;
//
//    try {
//        os = new FileOutputStream(file);
//        wb.write(os);
//        Log.w("FileUtils", "Writing file" + file);
//        Toast toast1 = Toast.makeText(getApplicationContext(), "Excel Generated", Toast.LENGTH_SHORT);
//        toast1.show();
//        success = true;
//    } catch (IOException e) {
//        Log.w("FileUtils", "Error writing " + file, e);
//        Toast toast1 = Toast.makeText(getApplicationContext(), "Error writing", Toast.LENGTH_SHORT);
//        toast1.show();
//    } catch (Exception e) {
//        Log.w("FileUtils", "Failed to save file", e);
//        Toast toast1 = Toast.makeText(getApplicationContext(), "Failed to save file", Toast.LENGTH_SHORT);
//        toast1.show();
//    } finally {
//        try {
//            if (null != os)
//                os.close();
//        } catch (Exception ex) {
//        }
//    }
//
//    return success;
//}
//
//
//}
//


}

