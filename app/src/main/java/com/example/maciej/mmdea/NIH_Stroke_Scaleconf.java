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

public class NIH_Stroke_Scaleconf extends AppCompatActivity {

    Double NIHQ1a, NIHQ1b, NIHQ1c, NIHQ2, NIHQ3, NIHQ4, NIHQ5R, NIHQ5L, NIHQ6R, NIHQ6L, NIHQ7, NIHQ8, NIHQ9, NIHQ10, NIHQ11, NIHQTotal;

    String PatID, Date, Event, Session,
            NIHQ5RT, NIHQ5LT, NIHQ6RT, NIHQ6LT, NIHQ7T, NIHQ10T,
            NIHQ5RF, NIHQ5LF, NIHQ6RF, NIHQ6LF, NIHQ7F, NIHQ10F,
            notes1a, notes2a, notes3a, notes4a, notes5a, notes6a;

    JSONObject record;

    HttpResponse response;

    ArrayList<String> NIHUN;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nih__stroke__scaleconf);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }

        Intent Answers = this.getIntent();


        PatID = Answers.getStringExtra("PatientID");
        Date = Answers.getStringExtra("Date");
        Event = Answers.getStringExtra("Event");


        NIHQ1a = Answers.getDoubleExtra("NIHQ1a", 0);
        NIHQ1b = Answers.getDoubleExtra("NIHQ1b", 0);
        NIHQ1c = Answers.getDoubleExtra("NIHQ1c", 0);
        NIHQ2 = Answers.getDoubleExtra("NIHQ2", 0);
        NIHQ3 = Answers.getDoubleExtra("NIHQ3", 0);
        NIHQ4 = Answers.getDoubleExtra("NIHQ4", 0);
        NIHQ5R = Answers.getDoubleExtra("NIHQ5R", 0);
        NIHQ5L = Answers.getDoubleExtra("NIHQ5L", 0);
        NIHQ6R = Answers.getDoubleExtra("NIHQ6R", 0);
        NIHQ6L = Answers.getDoubleExtra("NIHQ6L", 0);
        NIHQ7 = Answers.getDoubleExtra("NIHQ7", 0);
        NIHQ8 = Answers.getDoubleExtra("NIHQ8", 0);
        NIHQ9 = Answers.getDoubleExtra("NIHQ9", 0);
        NIHQ10 = Answers.getDoubleExtra("NIHQ10", 0);
        NIHQ11 = Answers.getDoubleExtra("NIHQ11", 0);
        NIHQTotal = Answers.getDoubleExtra("NIHQTotal", 0);

        NIHQ5RT = Answers.getStringExtra("NIHQ5RT");
        NIHQ5LT = Answers.getStringExtra("NIHQ5LT");
        NIHQ6RT = Answers.getStringExtra("NIHQ6RT");
        NIHQ6LT = Answers.getStringExtra("NIHQ6LT");
        NIHQ7T = Answers.getStringExtra("NIHQ7T");
        NIHQ10T = Answers.getStringExtra("NIHQ10T");

        NIHUN = Answers.getStringArrayListExtra("NIHUN");

        notes1a = Answers.getStringExtra("notes1a");
        notes2a = Answers.getStringExtra("notes2a");
        notes3a = Answers.getStringExtra("notes3a");
        notes4a = Answers.getStringExtra("notes4a");
        notes5a = Answers.getStringExtra("notes5a");
        notes6a = Answers.getStringExtra("notes6a");



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


        
        if (Objects.equals("", NIHQ5RT)) {
            NIHQ5RF = String.valueOf(NIHQ5R);
        } else {
            NIHQ5RF = String.valueOf(NIHQ5RT);
        }
        if (Objects.equals("", NIHQ5LT)) {
            NIHQ5LF = String.valueOf(NIHQ5L);
        }else {
            NIHQ5LF = String.valueOf(NIHQ5LT);
        }
        if (Objects.equals("", NIHQ6RT)) {
            NIHQ6RF = String.valueOf(NIHQ6R);
        } else {
            NIHQ6RF = String.valueOf(NIHQ6RT);
        }
        if (Objects.equals("", NIHQ6LT)) {
            NIHQ6LF = String.valueOf(NIHQ6L);
        }else {
            NIHQ6LF = String.valueOf(NIHQ6LT);
        }
        if (Objects.equals("", NIHQ7T)) {
            NIHQ7F = String.valueOf(NIHQ7);
        }else {
            NIHQ7F = String.valueOf(NIHQ7T);
        }
        if (Objects.equals("", NIHQ10T)) {
            NIHQ10F = String.valueOf(NIHQ10);
        }else {
            NIHQ10F = String.valueOf(NIHQ10T);
        }


        ((TextView) findViewById(R.id.notes1)).setText(notes1a);
        ((TextView) findViewById(R.id.notes2)).setText(notes2a);
        ((TextView) findViewById(R.id.notes3)).setText(notes3a);
        ((TextView) findViewById(R.id.notes4)).setText(notes4a);
        ((TextView) findViewById(R.id.notes5)).setText(notes5a);
        ((TextView) findViewById(R.id.notes6)).setText(notes6a);

        ((TextView)findViewById(R.id.NIH1a)).setText(String.valueOf(NIHQ1a));
        ((TextView)findViewById(R.id.NIH1b)).setText(String.valueOf(NIHQ1b));
        ((TextView)findViewById(R.id.NIH1c)).setText(String.valueOf(NIHQ1c));
        ((TextView)findViewById(R.id.NIH2)).setText(String.valueOf(NIHQ2));
        ((TextView)findViewById(R.id.NIH3)).setText(String.valueOf(NIHQ3));
        ((TextView)findViewById(R.id.NIH4)).setText(String.valueOf(NIHQ4));
        ((TextView) findViewById(R.id.NIH5R)).setText(String.valueOf(NIHQ5RF));
        ((TextView) findViewById(R.id.NIH5L)).setText(String.valueOf(NIHQ5LF));
        ((TextView) findViewById(R.id.NIH6R)).setText(String.valueOf(NIHQ6RF));
        ((TextView) findViewById(R.id.NIH6L)).setText(String.valueOf(NIHQ6LF));
        ((TextView) findViewById(R.id.NIH7)).setText(String.valueOf(NIHQ7F));
        ((TextView)findViewById(R.id.NIH8)).setText(String.valueOf(NIHQ8));
        ((TextView)findViewById(R.id.NIH9)).setText(String.valueOf(NIHQ9));
        ((TextView) findViewById(R.id.NIH10)).setText(String.valueOf(NIHQ10F));
        ((TextView)findViewById(R.id.NIH11)).setText(String.valueOf(NIHQ11));
        ((TextView)findViewById(R.id.NIHtotal)).setText(String.valueOf(NIHQTotal));
        ((TextView)findViewById(R.id.NIHUN)).setText(TextUtils.join(", ", (NIHUN)));


        record = new JSONObject();
        record.put("record_id", PatID);
        record.put("nihq1a", NIHQ1a);
        record.put("nihq1b", NIHQ1b);
        record.put("nihq1c", NIHQ1c);
        record.put("nihq2", NIHQ2);
        record.put("nihq3", NIHQ3);
        record.put("nihq4", NIHQ4);
        record.put("nihq5r", NIHQ5RF);
        record.put("nihq5l", NIHQ5LF);
        record.put("nihq6r", NIHQ6RF);
        record.put("nihq6l", NIHQ6LF);
        record.put("nihq7", NIHQ7F);
        record.put("nihq8", NIHQ8);
        record.put("nihq9", NIHQ9);
        record.put("nihq10", NIHQ10F);
        record.put("nihq11", NIHQ11);
        record.put("nihqtotal", NIHQTotal);
        record.put("nihun", TextUtils.join(", ", (NIHUN)));



        record.put("nihq5rnotes", notes1a);
        record.put("nihq5lnotes", notes2a);
        record.put("nihq6rnotes", notes3a);
        record.put("nihq6lnotes", notes4a);
        record.put("nihq7notes", notes5a);
        record.put("nihq10notes", notes6a);



        record.put("redcap_event_name", Event);

        record.put("nih_stroke_scale_complete", "2");
        
    }


    //Return to Forms List

    public void ReturnToForms(View view){
        AlertDialog alertclose = new AlertDialog.Builder(this).create();
        alertclose.setTitle("Close NIH Stroke Scale");
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
                                Intent PID = new Intent(NIH_Stroke_Scaleconf.this, Forms.class);
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
                canvas.drawText("NIH Stroke Scale", leftMargin + 115, titleBaseLine, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("1a. Level of Consciousness: " + NIHQ1a, 15, titleBaseLine + 4 * 35, paint);
                canvas.drawText("1b. LOC Questions: Ask patient the month and his/her age: " + NIHQ1b, 15, titleBaseLine + 222, paint);
                canvas.drawText("1c. LOC Commands: Open + close eyes and grip + release", 15, titleBaseLine + 291, paint);
                canvas.drawText("non-paretic hand: " + NIHQ1c, 15, titleBaseLine + 291+20, paint);
                canvas.drawText("2. Best Gaze: Horizontal Movements only: " + NIHQ2, 15, titleBaseLine + 380, paint);
                canvas.drawText("3. Visual Fields: " + NIHQ3, 15, titleBaseLine + 449, paint);
                canvas.drawText("4. Facial Palsy: " + NIHQ4, 15, titleBaseLine + 531, paint);
                canvas.drawText("5. Motor Function - Arm:     " + "Right: " + NIHQ5RF + "   " + "Left: " + NIHQ5LF, 15, titleBaseLine + 613, paint);


                paint.setTextSize(14);
                canvas.drawText("Date: " + Date, 15, titleBaseLine + 45+10, paint);
                canvas.drawText("Patient ID: " + PatID, 15, titleBaseLine + 2*35+10, paint);
                canvas.drawText("Session: " + Session, 15, titleBaseLine + 3 * 32+10, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                canvas.drawText("0 = Alert, keenly responsive", 15, titleBaseLine + 140+13, paint);
                canvas.drawText("1 = Not Alert, but arousable by minor stimulation", 15, titleBaseLine + 140+13*2, paint);
                canvas.drawText("2 = Not Alert, requires repeated stimulation to attend", 15, titleBaseLine + 140+13*3, paint);
                canvas.drawText("3 = Unresponsive, reflex movements only", 15, titleBaseLine + 140+13*4, paint);

                canvas.drawText("0 = Answers both questions correctly", 15, titleBaseLine + 222 + 13, paint);
                canvas.drawText("1 = Answers one question correctly", 15, titleBaseLine + 222 + 2 * 13, paint);
                canvas.drawText("2 = Answers neither question correctly", 15, titleBaseLine + 222 + 3 * 13, paint);

                canvas.drawText("0 = Performs both tasks correctly", 15, titleBaseLine + 311+13, paint);
                canvas.drawText("1 = Performs one task correctly", 15, titleBaseLine + 311 + 2 * 13, paint);
                canvas.drawText("2 = Performs neither task correctly", 15, titleBaseLine + 311 + 3 * 13, paint);

                canvas.drawText("0 = Normal", 15, titleBaseLine + 380 + 13, paint);
                canvas.drawText("1 = Partial gaze palsy", 15, titleBaseLine + 380 + 2 * 13, paint);
                canvas.drawText("2 = Forced deviation not overcome by oculocephalic maneuver", 15, titleBaseLine + 380 + 3 * 13, paint);

                canvas.drawText("0 = Normal", 15, titleBaseLine + 449 + 13, paint);
                canvas.drawText("1 = Partial Hemianopia", 15, titleBaseLine + 449 + 2 * 13, paint);
                canvas.drawText("2 = Complete Hemianopia", 15, titleBaseLine + 449 + 3 * 13, paint);
                canvas.drawText("3 = Bilateral Hemianopia (blind including cortical blindness)", 15, titleBaseLine + 449 + 4 * 13, paint);

                canvas.drawText("0 = Normal", 15, titleBaseLine + 531 + 13, paint);
                canvas.drawText("1 = Minor paralysis (flattened nasolabial fold, asymmetry on smiling)", 15, titleBaseLine + 531 + 2 * 13, paint);
                canvas.drawText("2 = Partial paralysis (total or near total paralysis of lower face)", 15, titleBaseLine + 531 + 3 * 13, paint);
                canvas.drawText("3 = Complete paralysis of one or both sides (absence of facial movement in the upper and lower face)", 15, titleBaseLine + 531 + 4 * 13, paint);

                canvas.drawText("0 = Normal; limb holds 90 (or 45) degrees for 10 seconds without drift", 15, titleBaseLine + 613 + 13, paint);
                canvas.drawText("1 = Drift; limb holds 90 (or 45) degrees but drifts down before full 10 seconds but does not hit bed or other support", 15, titleBaseLine + 613 + 2 * 13, paint);
                canvas.drawText("2 = Some effort against gravity", 15, titleBaseLine + 613 + 3 * 13, paint);
                canvas.drawText("3 = No effort against gravity; limb falls", 15, titleBaseLine + 613 + 4 * 13, paint);
                canvas.drawText("4 = No movement", 15, titleBaseLine + 613 + 5 * 13, paint);
                canvas.drawText("UN = Untestable; joint fused or amputated", 15, titleBaseLine + 613 + 6 * 13, paint);

            }

            else if (pagenumber == 2){

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                paint.setTextSize(20);
                canvas.drawText("6. Motor Function - Leg:     " + "Right: " + NIHQ6RF + "   " + "Left: " + NIHQ6LF, 15, titleBaseLine, paint);
                canvas.drawText("7. Limb Ataxia: Finger/nose and heel/shin both sides.", 15, titleBaseLine + 108, paint);
                canvas.drawText("Ataxia disproportionate to weakness only: " + NIHQ7F, 15, titleBaseLine + 128, paint);
                canvas.drawText("8. Sensory: " + NIHQ8, 15, titleBaseLine + 210, paint);
                canvas.drawText("9. Best Language: " + NIHQ9, 15, titleBaseLine + 279, paint);
                canvas.drawText("10. Dysarthia: " + NIHQ10F, 15, titleBaseLine + 361, paint);
                canvas.drawText("11. Extinction and Inattention: " + NIHQ11, 15, titleBaseLine + 443, paint);

                canvas.drawText("Total: " + NIHQTotal, 15, titleBaseLine + 482 + 30, paint);
                canvas.drawText("UN: " + TextUtils.join(", ", (NIHUN)), 15, titleBaseLine + 510 + 30, paint);

                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

                canvas.drawText("Notes", 15, titleBaseLine + 550 + 30, paint);


                paint.setTextSize(10);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));

                canvas.drawText("0 = Normal; leg holds 30 degrees position for 5 seconds", 15, titleBaseLine + 13, paint);
                canvas.drawText("1 = Drift; leg falls by the end of 5 second period but does not hit bed", 15, titleBaseLine + 2 * 13, paint);
                canvas.drawText("2 = Some effort against gravity", 15, titleBaseLine + 3 * 13, paint);
                canvas.drawText("3 = No effort against gravity; limb falls", 15, titleBaseLine + 4 * 13, paint);
                canvas.drawText("4 = No movement", 15, titleBaseLine + 5 * 13, paint);
                canvas.drawText("UN = Untestable; joint fused or amputated", 15, titleBaseLine + 6 * 13, paint);

                canvas.drawText("0 = No ataxia or paralysed/comatose/does not understand", 15, titleBaseLine + 128 + 13, paint);
                canvas.drawText("1 = Present in one limb", 15, titleBaseLine + 128 + 2 * 13, paint);
                canvas.drawText("2 = Present in two limbs", 15, titleBaseLine + 128 + 3 * 13, paint);
                canvas.drawText("UN = Untestable only if amputation or joint fusion", 15, titleBaseLine + 128 + 4 * 13, paint);

                canvas.drawText("0 = Normal", 15, titleBaseLine + 210 + 13, paint);
                canvas.drawText("1 = Mild to moderate sensory loss, aware of touch", 15, titleBaseLine + 210 + 2 * 13, paint);
                canvas.drawText("2 = Severe to total sensory loss", 15, titleBaseLine + 210 + 3 * 13, paint);

                canvas.drawText("0 = No aphasia", 15, titleBaseLine + 279 + 13, paint);
                canvas.drawText("1 = Mild to moderate aphasia; loss of fluency or comprehension", 15, titleBaseLine + 279 + 2 * 13, paint);
                canvas.drawText("2 = Severe aphasia; fragmented communication", 15, titleBaseLine + 279 + 3 * 13, paint);
                canvas.drawText("3 = Mute, global aphasia; no useable speech or auditory comprehension", 15, titleBaseLine + 279 + 4 * 13, paint);

                canvas.drawText("0 = Normal", 15, titleBaseLine + 361 + 13, paint);
                canvas.drawText("1 = Mild to moderate dysarthia; slurring of words, at worst can be understand with some difficulty", 15, titleBaseLine + 361 + 2 * 13, paint);
                canvas.drawText("2 = Severe dysarthia; near unintelligible or unable to speak (out of proportion to aphasia)", 15, titleBaseLine + 361 + 3 * 13, paint);
                canvas.drawText("UN = Untestable due to intubation or other physical barrier", 15, titleBaseLine + 361 + 4 * 13, paint);

                canvas.drawText("0 = No abnormality", 15, titleBaseLine + 443 + 13, paint);
                canvas.drawText("1 = Inattention or extinction to bilateral simultaneous stimulation in one sensory modality (visual, tactile, auditory, spatial or personal)", 15, titleBaseLine + 443 + 2 * 13, paint);
                canvas.drawText("2 = Profound hemi-attention or extinction to more than one modality", 15, titleBaseLine + 443 + 3 * 13, paint);


                
                
                paint.setTextSize(8);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                canvas.drawText("5 (Right): " + notes1a, 15, titleBaseLine + 600, paint);
                canvas.drawText("5 (Left): " + notes2a, 15, titleBaseLine + 600 + 13, paint);
                canvas.drawText("6 (Right): " + notes3a, 15, titleBaseLine + 600 + 2 * 13, paint);
                canvas.drawText("6 (Left): " + notes4a, 15, titleBaseLine + 600 + 3 * 13, paint);
                canvas.drawText("7: " + notes5a, 15, titleBaseLine + 600 + 4 * 13, paint);
                canvas.drawText("10: " + notes6a, 15, titleBaseLine + 600 + 5 * 13, paint);




            }

        }


    }
    public void printDocument(View view)
    {
        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = PatID + " NIH Stroke Scale " + Session + " " + Date;

        printManager.print(jobName, new MyPrintDocumentAdapter(this),
                null);
    }



    // Excel Stuff Below

    public void Excel(View view){

        saveExcelFile(this,PatID + " NIH Stroke Scale " + Session + " " + ".xls");

    }


    private boolean saveExcelFile(Context context, String fileName) {

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell Q = null;
        Cell A = null;

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("NIH Stroke Scale");

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
        Q.setCellValue("NIHQ1a");
        A = rowA.createCell(3);
        A.setCellValue(NIHQ1a);

        Q = rowQ.createCell(4);
        Q.setCellValue("NIHQ1b");
        A = rowA.createCell(4);
        A.setCellValue(NIHQ1b);

        Q = rowQ.createCell(5);
        Q.setCellValue("NIHQ1c");
        A = rowA.createCell(5);
        A.setCellValue(NIHQ1c);

        Q = rowQ.createCell(6);
        Q.setCellValue("NIHQ2");
        A = rowA.createCell(6);
        A.setCellValue(NIHQ2);

        Q = rowQ.createCell(7);
        Q.setCellValue("NIHQ3");
        A = rowA.createCell(7);
        A.setCellValue(NIHQ3);

        Q = rowQ.createCell(8);
        Q.setCellValue("NIHQ4");
        A = rowA.createCell(8);
        A.setCellValue(NIHQ4);

        Q = rowQ.createCell(9);
        Q.setCellValue("NIHQ5R");
        A = rowA.createCell(9);
        A.setCellValue(NIHQ5RF);

        Q = rowQ.createCell(10);
        Q.setCellValue("NIHQ5RNotes");
        A = rowA.createCell(10);
        A.setCellValue(notes1a);



        Q = rowQ.createCell(11);
        Q.setCellValue("NIHQ5L");
        A = rowA.createCell(11);
        A.setCellValue(NIHQ5LF);

        Q = rowQ.createCell(12);
        Q.setCellValue("NIHQ5LNotes");
        A = rowA.createCell(12);
        A.setCellValue(notes2a);



        Q = rowQ.createCell(13);
        Q.setCellValue("NIHQ6R");
        A = rowA.createCell(13);
        A.setCellValue(NIHQ6RF);

        Q = rowQ.createCell(14);
        Q.setCellValue("NIHQ6RNotes");
        A = rowA.createCell(14);
        A.setCellValue(notes3a);


        Q = rowQ.createCell(15);
        Q.setCellValue("NIHQ6L");
        A = rowA.createCell(15);
        A.setCellValue(NIHQ6LF);

        Q = rowQ.createCell(16);
        Q.setCellValue("NIHQ6LNotes");
        A = rowA.createCell(16);
        A.setCellValue(notes4a);



        Q = rowQ.createCell(17);
        Q.setCellValue("NIHQ7");
        A = rowA.createCell(17);
        A.setCellValue(NIHQ7F);

        Q = rowQ.createCell(18);
        Q.setCellValue("NIHQ7Notes");
        A = rowA.createCell(18);
        A.setCellValue(notes5a);


        Q = rowQ.createCell(19);
        Q.setCellValue("NIHQ8");
        A = rowA.createCell(19);
        A.setCellValue(NIHQ8);

        Q = rowQ.createCell(20);
        Q.setCellValue("NIHQ9");
        A = rowA.createCell(20);
        A.setCellValue(NIHQ9);

        Q = rowQ.createCell(21);
        Q.setCellValue("NIHQ10");
        A = rowA.createCell(21);
        A.setCellValue(NIHQ10F);

        Q = rowQ.createCell(22);
        Q.setCellValue("NIHQ10Notes");
        A = rowA.createCell(22);
        A.setCellValue(notes6a);



        Q = rowQ.createCell(23);
        Q.setCellValue("NIHQ11");
        A = rowA.createCell(23);
        A.setCellValue(NIHQ11);

        Q = rowQ.createCell(24);
        Q.setCellValue("NIHQTotal");
        A = rowA.createCell(24);
        A.setCellValue(NIHQTotal);

        Q = rowQ.createCell(25);
        Q.setCellValue("NIHUN");
        A = rowA.createCell(25);
        A.setCellValue(TextUtils.join(", ", (NIHUN)));
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
