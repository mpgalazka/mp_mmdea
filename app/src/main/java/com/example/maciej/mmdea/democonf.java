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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class democonf extends AppCompatActivity {


    String Date, PatientName, phonea,doba,address1a,address2a,emaila,emergencynamea,emergencynumbera,numberofstrokesa,strokedatesa,braininjdatea,spineinjdatea,neuroillnessa,
            admdatea,comorbida,pharmamedsa,interest6a,

    veteran,exsmoker,smoker,cholesterol,alcohol,diei,dieii,prestroke,hypertension,famstroke,atrialf;

    ArrayList handedness,stroketype,lesionlocation,bodyweakness,weaklimb,interests,testing;
    String cool, PatID, Event;

    HttpResponse response;

    JSONObject record;

    //make new strings for new checkbox textboxes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_democonf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }


        Date = DateFormat.getDateTimeInstance().format(new Date());


        Event = "adm_arm_1";

        Intent Answers = this.getIntent();
        PatID = Answers.getStringExtra("PatientID");

        //textboxes

        PatientName = Answers.getStringExtra("PatientName");
        phonea = Answers.getStringExtra("phonea");
        doba = Answers.getStringExtra("doba");
        address1a = Answers.getStringExtra("address1a");
        address2a = Answers.getStringExtra("address2a");
        emaila = Answers.getStringExtra("emaila");
        emergencynamea = Answers.getStringExtra("emergencynamea");
        emergencynumbera = Answers.getStringExtra("emergencynumbera");
        numberofstrokesa = Answers.getStringExtra("numberofstrokesa");
        strokedatesa = Answers.getStringExtra("strokedatesa");
        braininjdatea = Answers.getStringExtra("braininjdatea");
        spineinjdatea = Answers.getStringExtra("spineinjdatea");
        neuroillnessa = Answers.getStringExtra("neuroillnessa");
        admdatea = Answers.getStringExtra("admdatea");
        comorbida = Answers.getStringExtra("comorbida");
        pharmamedsa = Answers.getStringExtra("pharmamedsa");
        interest6a = Answers.getStringExtra("interest6a");
        //checkbox replacements
        handedness = Answers.getCharSequenceArrayListExtra("handedness");
        stroketype = Answers.getCharSequenceArrayListExtra("stroketype");
        lesionlocation = Answers.getCharSequenceArrayListExtra("lesionlocation");
        bodyweakness = Answers.getCharSequenceArrayListExtra("bodyweakness");
        weaklimb = Answers.getCharSequenceArrayListExtra("weaklimb");
        veteran = Answers.getStringExtra("veteran");
        exsmoker = Answers.getStringExtra("exsmoker");
        smoker = Answers.getStringExtra("smoker");
        cholesterol = Answers.getStringExtra("cholesterol");
        alcohol = Answers.getStringExtra("alcohol");
        diei = Answers.getStringExtra("diei");
        dieii = Answers.getStringExtra("dieii");
        prestroke = Answers.getStringExtra("prestroke");
        hypertension = Answers.getStringExtra("hypertension");
        famstroke = Answers.getStringExtra("famstroke");
        atrialf = Answers.getStringExtra("atrialf");
        testing = Answers.getCharSequenceArrayListExtra("testing");
        interests = Answers.getCharSequenceArrayListExtra("interests");



        //textboxes
        ((TextView) findViewById(R.id.name)).setText(PatientName);
        ((TextView) findViewById(R.id.phone)).setText(phonea);
        ((TextView) findViewById(R.id.dob)).setText(doba);
        ((TextView) findViewById(R.id.address1)).setText(address1a);
        ((TextView) findViewById(R.id.address2)).setText(address2a);
        ((TextView) findViewById(R.id.email)).setText(emaila);
        ((TextView) findViewById(R.id.emergencyname)).setText(emergencynamea);
        ((TextView) findViewById(R.id.emergencynumber)).setText(emergencynumbera);
        ((TextView) findViewById(R.id.numberofstrokes)).setText(numberofstrokesa);
        ((TextView) findViewById(R.id.strokedates)).setText(strokedatesa);
        ((TextView) findViewById(R.id.braininjdate)).setText(braininjdatea);
        ((TextView) findViewById(R.id.spineinjdate)).setText(spineinjdatea);
        ((TextView) findViewById(R.id.neuroillness)).setText(neuroillnessa);
        ((TextView) findViewById(R.id.admdate)).setText(admdatea);
        ((TextView) findViewById(R.id.comorbid)).setText(comorbida);
        ((TextView) findViewById(R.id.pharmameds)).setText(pharmamedsa);
        ((TextView) findViewById(R.id.interest6)).setText(interest6a);
        //checkbox replacements




        ((TextView) findViewById(R.id.handednessa)).setText(TextUtils.join(", ", (handedness)));
        ((TextView) findViewById(R.id.stroketypea)).setText(TextUtils.join(", ", (stroketype)));
        ((TextView) findViewById(R.id.lesionlocationa)).setText(TextUtils.join(", ", (lesionlocation)));
        ((TextView) findViewById(R.id.bodyweaknessa)).setText(TextUtils.join(", ", (bodyweakness)));
        ((TextView) findViewById(R.id.weaklimba)).setText(TextUtils.join(", ", (weaklimb)));
        ((TextView) findViewById(R.id.veterana)).setText(veteran);
        ((TextView) findViewById(R.id.exsmokera)).setText(exsmoker);
        ((TextView) findViewById(R.id.smokera)).setText(smoker);
        ((TextView) findViewById(R.id.cholesterola)).setText(cholesterol);
        ((TextView) findViewById(R.id.alcohola)).setText(alcohol);
        ((TextView) findViewById(R.id.dieia)).setText(diei);
        ((TextView) findViewById(R.id.dieiia)).setText(dieii);
        ((TextView) findViewById(R.id.prestrokea)).setText(prestroke);
        ((TextView) findViewById(R.id.hypertensiona)).setText(hypertension);
        ((TextView) findViewById(R.id.famstrokea)).setText(famstroke);
        ((TextView) findViewById(R.id.atrialfa)).setText(atrialf);
        ((TextView) findViewById(R.id.testinga)).setText(TextUtils.join(", ", (testing)));
        ((TextView) findViewById(R.id.interestsa)).setText(TextUtils.join(", ", (interests)));








        //for REDCap variables
        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("name", PatientName);
        record.put("adline1", address1a);
        record.put("adline2", address2a);
        record.put("contactphone", phonea);
        record.put("dob", doba);
        record.put("email", emaila);
        record.put("emergencycontact", emergencynamea);
        record.put("emergencycontactnum", emergencynumbera);
        record.put("handedness", TextUtils.join(", ", (handedness)));
        record.put("stroketype", TextUtils.join(", ", (stroketype)));
        record.put("lesionloc", TextUtils.join(", ", (lesionlocation)));
        record.put("affectedsidebody", TextUtils.join(", ", (bodyweakness)));
        record.put("weaklimb", TextUtils.join(", ", (weaklimb)));
        record.put("numstrokes", numberofstrokesa);
        record.put("onsetdate", strokedatesa);
        record.put("braininjurydate", braininjdatea);
        record.put("spineinjurydate", spineinjdatea);
        record.put("neurological", neuroillnessa);
        record.put("admdate", admdatea);
        record.put("veteran", veteran);
        record.put("comorbid", comorbida);
        record.put("smoker", smoker);
        record.put("exsmoker", exsmoker);
        record.put("alcohol", alcohol);
        record.put("cholesterol", cholesterol);
        record.put("diabetes1", diei);
        record.put("diabetes2", dieii);
        record.put("priorstroke", prestroke);
        record.put("hypertension", hypertension);
        record.put("famhxstroke", famstroke);
        record.put("atfib", atrialf);
        record.put("med1", pharmamedsa);
        record.put("diagnostic_testing", TextUtils.join(", ", (testing)));
        record.put("program_of_interest", TextUtils.join(", ", interests));
        record.put("otherint", interest6a);
        record.put("redcap_event_name", Event);

        record.put("patient_demographics_complete", "2");


    }






    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close Patient Demographic");
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
                                Intent PID = new Intent(democonf.this, Forms.class);
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
                canvas.drawText("Patient Demographic Information", leftMargin, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(14);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2 * 25, paint);


                paint.setTextSize(10);
                canvas.drawText("Patient Name: " + PatientName, 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("Address Line 1: " + address1a, 15, titleBaseLine + 4 * 25, paint);
                canvas.drawText("Address Line 2: " + address2a, 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("Phone Number: " + phonea, 15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("DOB/Age: " + doba, 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("Email Address: " + emaila, 15, titleBaseLine + 8 * 25, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Emergency Contact", 15, titleBaseLine + 9 * 25 + 8, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("Contact Name: " + emergencynamea, 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("Number: " + emergencynumbera, 15, titleBaseLine + 11 * 25, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Please check off the following (as applicable)", 15, titleBaseLine + 12 * 25 + 8, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("Handedness: " + TextUtils.join(", ", (handedness)), 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText("Stroke Type: " + TextUtils.join(", ", (stroketype)), 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("Lesion Location (if known): " + TextUtils.join(", ", (lesionlocation)), 15, titleBaseLine + 15 * 25, paint);
                canvas.drawText("Body Weakness: " + TextUtils.join(", ", (bodyweakness)), 15, titleBaseLine + 16 * 25, paint);
                canvas.drawText("Weak Limbs: " + TextUtils.join(", ", (weaklimb)), 15, titleBaseLine + 17 * 25, paint);


                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Additional Information", 15, titleBaseLine + 18 * 25 + 8, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("Number Of Strokes: " + numberofstrokesa, 15, titleBaseLine + 19 * 25, paint);
                canvas.drawText("Stroke Date(s): " + strokedatesa, 15, titleBaseLine + 20 * 25, paint);
                canvas.drawText("Traumatic Brain Injury Date: " + braininjdatea, 15, titleBaseLine + 21 * 25, paint);
                canvas.drawText("Spinal Cord Injury Date/ Level: " + spineinjdatea, 15, titleBaseLine + 22 * 25, paint);
                canvas.drawText("Neurological Illness: " + neuroillnessa, 15, titleBaseLine + 23 * 25, paint);
                canvas.drawText("Admission Date To Clinical Trial: " + admdatea, 15, titleBaseLine + 24 * 25, paint);
                canvas.drawText("Veteran: " + veteran, 15, titleBaseLine + 25 * 25, paint);
                canvas.drawText("Co-morbid Diseases/ Pertinent Conditions: " + comorbida, 15, titleBaseLine + 26 * 25, paint);



                //new page

            }

            else if (pagenumber == 2){
                
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(20);
                canvas.drawText("Demographic Data", 15, titleBaseLine + 8, paint);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(10);
                canvas.drawText("Smoker: " + smoker, 15, titleBaseLine + 1 * 25, paint);
                canvas.drawText("Ex-Smoker: " + exsmoker, 15, titleBaseLine + 2 * 25, paint);
                canvas.drawText("Alcohol Use: " + alcohol, 15, titleBaseLine + 3 * 25, paint);
                canvas.drawText("High Cholesterol: " + cholesterol, 15, titleBaseLine + 4 * 25, paint);
                canvas.drawText("Diabetes Type I: " + diei, 15, titleBaseLine + 5 * 25, paint);
                canvas.drawText("Diabetes Type II: " + dieii, 15, titleBaseLine + 6 * 25, paint);
                canvas.drawText("Previous Stroke or TIA: " + prestroke, 15, titleBaseLine + 7 * 25, paint);
                canvas.drawText("Hypertension/ High Blood Pressure: " + hypertension, 15, titleBaseLine + 8 * 25, paint);
                canvas.drawText("Family history of Stroke/IHD < 65 yr: " + famstroke, 15, titleBaseLine + 9 * 25, paint);
                canvas.drawText("Atrial Fibrillation (including paroxysmal): " + atrialf, 15, titleBaseLine + 10 * 25, paint);
                canvas.drawText("Pharmacological Treatment/ Medication: " + pharmamedsa, 15, titleBaseLine + 11 * 25, paint);
                canvas.drawText("Diagnostic Testing: " + TextUtils.join(", ", (testing)), 15, titleBaseLine + 12 * 25, paint);
                canvas.drawText("Programs of interest: ", 15, titleBaseLine + 13 * 25, paint);
                canvas.drawText(TextUtils.join(", ", (interests)), 15, titleBaseLine + 14 * 25, paint);
                canvas.drawText("Other Programs of interest: " + interest6a, 15, titleBaseLine + 15 * 25, paint);
                //just in case we can seperate the top line into this bottom one as well, but itll add a page to pdf
                //canvas.drawText("Other Programs of interest: " + interest6a, 15, titleBaseLine2 + 22 * 25, paint);






            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " Patient Demographic Information" + " " + Date ;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }




    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " Patient Demographic Information " + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("Patient Demographic Information");

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
        //continue with questions

        Q = rowQ.createCell(3);
        Q.setCellValue("Name");
        A = rowA.createCell(3);
        A.setCellValue(PatientName);

        Q = rowQ.createCell(4);
        Q.setCellValue("address1a");
        A = rowA.createCell(4);
        A.setCellValue(address1a);

        Q = rowQ.createCell(5);
        Q.setCellValue("addess2a");
        A = rowA.createCell(5);
        A.setCellValue(address2a);

        Q = rowQ.createCell(6);
        Q.setCellValue("phone");
        A = rowA.createCell(6);
        A.setCellValue(phonea);

        Q = rowQ.createCell(7);
        Q.setCellValue("DOB");
        A = rowA.createCell(7);
        A.setCellValue(doba);

        Q = rowQ.createCell(8);
        Q.setCellValue("email");
        A = rowA.createCell(8);
        A.setCellValue(emaila);

        Q = rowQ.createCell(9);
        Q.setCellValue("emergency_contact");
        A = rowA.createCell(9);
        A.setCellValue(emergencynamea);

        Q = rowQ.createCell(10);
        Q.setCellValue("emergency_contact#");
        A = rowA.createCell(10);
        A.setCellValue(emergencynumbera);

        Q = rowQ.createCell(11);
        Q.setCellValue("handedness");
        A = rowA.createCell(11);
        A.setCellValue(TextUtils.join(", ", (handedness)));

        Q = rowQ.createCell(12);
        Q.setCellValue("stroke_type");
        A = rowA.createCell(12);
        A.setCellValue(TextUtils.join(", ", (stroketype)));

        Q = rowQ.createCell(13);
        Q.setCellValue("Lesion_location");
        A = rowA.createCell(13);
        A.setCellValue(TextUtils.join(", ", (lesionlocation)));

        Q = rowQ.createCell(14);
        Q.setCellValue("Affected_side_body");
        A = rowA.createCell(14);
        A.setCellValue(TextUtils.join(", ", (bodyweakness)));

        Q = rowQ.createCell(15);
        Q.setCellValue("weaklimb");
        A = rowA.createCell(15);
        A.setCellValue(TextUtils.join(", ", (weaklimb)));

        Q = rowQ.createCell(16);
        Q.setCellValue("Number_of_strokes");
        A = rowA.createCell(16);
        A.setCellValue(numberofstrokesa);

        Q = rowQ.createCell(17);
        Q.setCellValue("stroke_date");
        A = rowA.createCell(17);
        A.setCellValue(strokedatesa);

        Q = rowQ.createCell(18);
        Q.setCellValue("brain_injury_date");
        A = rowA.createCell(18);
        A.setCellValue(braininjdatea);

        Q = rowQ.createCell(19);
        Q.setCellValue("spine_in_date");
        A = rowA.createCell(19);
        A.setCellValue(spineinjdatea);

        Q = rowQ.createCell(20);
        Q.setCellValue("neurological_illness");
        A = rowA.createCell(20);
        A.setCellValue(neuroillnessa);

        Q = rowQ.createCell(21);
        Q.setCellValue("Admission_Date_to_Clinical_Trial");
        A = rowA.createCell(21);
        A.setCellValue(admdatea);

        Q = rowQ.createCell(22);
        Q.setCellValue("Veteran");
        A = rowA.createCell(22);
        A.setCellValue(veteran);

        Q = rowQ.createCell(23);
        Q.setCellValue("Co-morbid_diseases/ Pertinent Conditions");
        A = rowA.createCell(23);
        A.setCellValue(comorbida);

        Q = rowQ.createCell(24);
        Q.setCellValue("Smoker");
        A = rowA.createCell(24);
        A.setCellValue(smoker);

        Q = rowQ.createCell(25);
        Q.setCellValue("Ex-smoker");
        A = rowA.createCell(25);
        A.setCellValue(exsmoker);

        Q = rowQ.createCell(26);
        Q.setCellValue("Alcohol");
        A = rowA.createCell(26);
        A.setCellValue(alcohol);

        Q = rowQ.createCell(27);
        Q.setCellValue("High Cholesterol");
        A = rowA.createCell(27);
        A.setCellValue(cholesterol);

        Q = rowQ.createCell(28);
        Q.setCellValue("Diabetes Type I");
        A = rowA.createCell(28);
        A.setCellValue(diei);

        Q = rowQ.createCell(29);
        Q.setCellValue("Diabetes Type II");
        A = rowA.createCell(29);
        A.setCellValue(dieii);

        Q = rowQ.createCell(30);
        Q.setCellValue("Previous Stroke or TIA");
        A = rowA.createCell(30);
        A.setCellValue(prestroke);

        Q = rowQ.createCell(31);
        Q.setCellValue("Hypertension");
        A = rowA.createCell(31);
        A.setCellValue(prestroke);

        Q = rowQ.createCell(32);
        Q.setCellValue("Family History of Stroke");
        A = rowA.createCell(32);
        A.setCellValue(famstroke);

        Q = rowQ.createCell(33);
        Q.setCellValue("Atrial Fibrillation");
        A = rowA.createCell(33);
        A.setCellValue(atrialf);

        Q = rowQ.createCell(34);
        Q.setCellValue("Pharmacological Treatment");
        A = rowA.createCell(34);
        A.setCellValue(pharmamedsa);

        Q = rowQ.createCell(35);
        Q.setCellValue("Diagnostic Testing");
        A = rowA.createCell(35);
        A.setCellValue(TextUtils.join(", ", (testing)));

        Q = rowQ.createCell(36);
        Q.setCellValue("Programs of Interest");
        A = rowA.createCell(36);
        A.setCellValue(TextUtils.join(", ", interests));

        Q = rowQ.createCell(37);
        Q.setCellValue("Other");
        A = rowA.createCell(37);
        A.setCellValue(interest6a);


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




