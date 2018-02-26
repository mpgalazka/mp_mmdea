package com.example.maciej.mmdea;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import android.content.Context;

import android.content.Intent;

import android.os.Environment;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;



public class Redcapdictionary extends AppCompatActivity {
    Button r1,btn;
    EditText v1,s1,fn1,ft1,fl1,v2,s2,fn2,ft2,fl2,v3,s3,fn3,ft3,fl3,v4,s4,fn4,ft4,fl4,v5,s5,fn5,ft5,fl5,v6,s6,fn6,ft6,fl6,v7,s7,fn7,ft7,fl7,v8,s8,fn8,ft8,fl8,v9,s9,fn9,ft9,fl9,v10,s10,fn10,ft10,fl10,v11,s11,fn11,ft11,fl11,v12,s12,fn12,ft12,fl12,v13,s13,fn13,ft13,fl13,v14,s14,fn14,ft14,fl14,v15,s15,fn15,ft15,fl15,v16,s16,fn16,ft16,fl16,v17,s17,fn17,ft17,fl17,v18,s18,fn18,ft18,fl18,v19,s19,fn19,ft19,fl19,v20,s20,fn20,ft20,fl20;
    int res, res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13, res14, res15, res16, res17, res18, res19, res20;
    private boolean isRowEmpty;

// Defining xml (layout) file associated with the java code file

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redcapdictionary);

        // Defining Symbolic variables

        r1 = (Button)findViewById(R.id.Excel);
        v1 = (EditText) findViewById(R.id.name);
        s1 = (EditText) findViewById(R.id.sectionheader1);
        fn1 = (EditText) findViewById(R.id.formname1);
        ft1 = (EditText) findViewById(R.id.fieldtype1);
        fl1 = (EditText) findViewById(R.id.fieldlabel1);

        v2 = (EditText) findViewById(R.id.address);
        s2 = (EditText) findViewById(R.id.sectionheader2);
        fn2 = (EditText) findViewById(R.id.formname2);
        ft2 = (EditText) findViewById(R.id.fieldtype2);
        fl2 = (EditText) findViewById(R.id.fieldlabel2);

        v3 = (EditText) findViewById(R.id.phonenumber);
        s3 = (EditText) findViewById(R.id.sectionheader3);
        fn3 = (EditText) findViewById(R.id.formname3);
        ft3 = (EditText) findViewById(R.id.fieldtype3);
        fl3 = (EditText) findViewById(R.id.fieldlabel3);

        v4 = (EditText) findViewById(R.id.dob);
        s4 = (EditText) findViewById(R.id.sectionheader4);
        fn4 = (EditText) findViewById(R.id.formname4);
        ft4 = (EditText) findViewById(R.id.fieldtype4);
        fl4 = (EditText) findViewById(R.id.fieldlabel4);

        v5 = (EditText) findViewById(R.id.email);
        s5 = (EditText) findViewById(R.id.sectionheader5);
        fn5 = (EditText) findViewById(R.id.formname5);
        ft5 = (EditText) findViewById(R.id.fieldtype5);
        fl5 = (EditText) findViewById(R.id.fieldlabel5);

        v6 = (EditText) findViewById(R.id.contact);
        s6 = (EditText) findViewById(R.id.sectionheader6);
        fn6 = (EditText) findViewById(R.id.formname6);
        ft6 = (EditText) findViewById(R.id.fieldtype6);
        fl6 = (EditText) findViewById(R.id.fieldlabel6);

        v7 = (EditText) findViewById(R.id.number);
        s7 = (EditText) findViewById(R.id.sectionheader7);
        fn7 = (EditText) findViewById(R.id.formname7);
        ft7 = (EditText) findViewById(R.id.fieldtype7);
        fl7 = (EditText) findViewById(R.id.fieldlabel7);

        v8 = (EditText) findViewById(R.id.handedness);
        s8 = (EditText) findViewById(R.id.sectionheader8);
        fn8 = (EditText) findViewById(R.id.formname8);
        ft8 = (EditText) findViewById(R.id.fieldtype8);
        fl8 = (EditText) findViewById(R.id.fieldlabel8);

        v9 = (EditText) findViewById(R.id.stroke);
        s9 = (EditText) findViewById(R.id.sectionheader9);
        fn9 = (EditText) findViewById(R.id.formname9);
        ft9 = (EditText) findViewById(R.id.fieldtype9);
        fl9 = (EditText) findViewById(R.id.fieldlabel9);

        v10 = (EditText) findViewById(R.id.lesion);
        s10 = (EditText) findViewById(R.id.sectionheader10);
        fn10 = (EditText) findViewById(R.id.formname10);
        ft10 = (EditText) findViewById(R.id.fieldtype10);
        fl10 = (EditText) findViewById(R.id.fieldlabel10);

        v11 = (EditText) findViewById(R.id.variable1);
        s11 = (EditText) findViewById(R.id.sectionheader11);
        fn11 = (EditText) findViewById(R.id.formname11);
        ft11 = (EditText) findViewById(R.id.fieldtype11);
        fl11 = (EditText) findViewById(R.id.fieldlabel11);

        v12 = (EditText) findViewById(R.id.variable2);
        s12 = (EditText) findViewById(R.id.sectionheader12);
        fn12 = (EditText) findViewById(R.id.formname12);
        ft12 = (EditText) findViewById(R.id.fieldtype12);
        fl12 = (EditText) findViewById(R.id.fieldlabel12);

        v13 = (EditText) findViewById(R.id.variable3);
        s13 = (EditText) findViewById(R.id.sectionheader13);
        fn13 = (EditText) findViewById(R.id.formname13);
        ft13 = (EditText) findViewById(R.id.fieldtype13);
        fl13 = (EditText) findViewById(R.id.fieldlabel13);

        v14 = (EditText) findViewById(R.id.variable4);
        s14 = (EditText) findViewById(R.id.sectionheader14);
        fn14 = (EditText) findViewById(R.id.formname14);
        ft14 = (EditText) findViewById(R.id.fieldtype14);
        fl14 = (EditText) findViewById(R.id.fieldlabel14);

        v15 = (EditText) findViewById(R.id.variable5);
        s15 = (EditText) findViewById(R.id.sectionheader15);
        fn15 = (EditText) findViewById(R.id.formname15);
        ft15 = (EditText) findViewById(R.id.fieldtype15);
        fl15 = (EditText) findViewById(R.id.fieldlabel15);

        v16 = (EditText) findViewById(R.id.variable6);
        s16 = (EditText) findViewById(R.id.sectionheader16);
        fn16 = (EditText) findViewById(R.id.formname16);
        ft16 = (EditText) findViewById(R.id.fieldtype16);
        fl16 = (EditText) findViewById(R.id.fieldlabel16);

        v17 = (EditText) findViewById(R.id.variable7);
        s17 = (EditText) findViewById(R.id.sectionheader17);
        fn17 = (EditText) findViewById(R.id.formname17);
        ft17 = (EditText) findViewById(R.id.fieldtype17);
        fl17 = (EditText) findViewById(R.id.fieldlabel17);

        v18 = (EditText) findViewById(R.id.variable8);
        s18 = (EditText) findViewById(R.id.sectionheader18);
        fn18 = (EditText) findViewById(R.id.formname18);
        ft18 = (EditText) findViewById(R.id.fieldtype18);
        fl18 = (EditText) findViewById(R.id.fieldlabel18);

        v19 = (EditText) findViewById(R.id.variable9);
        s19 = (EditText) findViewById(R.id.sectionheader19);
        fn19 = (EditText) findViewById(R.id.formname19);
        ft19 = (EditText) findViewById(R.id.fieldtype19);
        fl19 = (EditText) findViewById(R.id.fieldlabel19);

        v20 = (EditText) findViewById(R.id.variable10);
        s20 = (EditText) findViewById(R.id.sectionheader20);
        fn20 = (EditText) findViewById(R.id.formname20);
        ft20 = (EditText) findViewById(R.id.fieldtype20);
        fl20 = (EditText) findViewById(R.id.fieldlabel20);


        btn = (Button) findViewById(R.id.btn_clickme);

        // Defining hyperlink when Upload to Redcap Button is pressed (Pressed refers to OnClickListener)

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://redcap.ctsc.med.cornell.edu/redcap_protocols/"));
                startActivity(myWebLink);
            }
        });

    }



    public void info(View view){

        switch (view.getId()) {

            case R.id.ibtn1:

                AlertDialog alertDialog1 = new AlertDialog.Builder(this).create();
                alertDialog1.setTitle("Variable");
                alertDialog1.setMessage("1. Variable/Field names specify the variable name that will be used in data exports.\n" +
                        "2. Must be lowercase and can not start with a number. May contain letters, numbers, and underscores, but no spaces, special characters.");
                alertDialog1.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog1.show();

                break;

            case R.id.ibtn2:

                AlertDialog alertDialog2 = new AlertDialog.Builder(this).create();
                alertDialog2.setTitle("Form Name");
                alertDialog2.setMessage("1. Forms are groupings of variables within the database.\n" +
                        "2. Form names must be all lowercase. If your form name contains more than one word, connect the words with an underscore, such as “form_name”. The underscore will appear as a space in REDCap.");
                alertDialog2.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog2.show();

                break;


            case R.id.ibtn3:

                AlertDialog alertDialog3 = new AlertDialog.Builder(this).create();
                alertDialog3.setTitle("Section Header");
                alertDialog3.setMessage("1. Section Headers are used to visually separate items within a form\n" +
                        "2. May contain upper or lower case letters, numbers, and underscores,spaces, and special characters.");
                alertDialog3.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog3.show();

                break;


            case R.id.ibtn4:

                AlertDialog alertDialog4 = new AlertDialog.Builder(this).create();
                alertDialog4.setTitle("Field Type");
                alertDialog4.setMessage("1. Field type determines what types of responses are allowed, and how they will be displayed.\n" +
                        "2. Field types include: dropdown, radio button, checkboxes, text box, note box, calculated field, file upload, and section header.");
                alertDialog4.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog4.show();

                break;


            case R.id.ibtn5:

                AlertDialog alertDialog5 = new AlertDialog.Builder(this).create();
                alertDialog5.setTitle("Field Label");
                alertDialog5.setMessage("1. A Field Label is a word or phrase that is more descriptive than the variable. It is displayed on the form.\n" +
                        "2. May contain upper or lower case letters, numbers, and underscores,spaces, and special characters.");
                alertDialog5.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog5.show();

                break;



        }


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Assessment Creation")
                .setMessage("Are you sure you want to return to main page?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    /**
     * Called when the activity is first created.
     */


    // Defining java code for when Export to Excel (CSV) button is pressed

    public void Excel(View view) throws IOException {

        saveExcelFile(this, "Dictionary.csv"); //Telling program name of csv file

    }
    private boolean saveExcelFile(Context context, String fileName) throws IOException {

        boolean success = false;
        File[] fs = context.getExternalFilesDirs(null); // Retrieving device external storage directory
        String extPath = ""; // Creating empty string that is defined below

        // at index 0 you have the internal storage and at index 1 the real external SD card...
        if (fs != null && fs.length >= 2)
        {
            extPath = fs[1].getAbsolutePath(); //Defining path string
            // at index 0 you have the internal storage and at index 1 (fs[1]) the real external SD card...
            Log.e("SD Path",fs[1].getAbsolutePath());
        }

        //Opening Previous Workbook and Excel file
        File fileis = new File(Environment.getExternalStorageDirectory() + "/My Documents/Dictionary.csv");
        //FileInputStream fileInputStream = new FileInputStream(fileis); //Creating input stream to read excel file and retrieve previous written lines
        HSSFWorkbook wb = new HSSFWorkbook();

        // Creating empty cell string that will be used to append data
        Cell Q = null;
        Cell A = null;

        //Getting Sheet
        Sheet sheet1 = wb.createSheet("Dictionary1"); //Getting Dictionary Sheet in excel file

        //Getting last row number to append new data to end of current excel file

        for(int i = 0; i < sheet1.getLastRowNum(); i++){


            if(sheet1.getRow(i)==null){
                isRowEmpty=true;
                sheet1.shiftRows(i + 1, sheet1.getLastRowNum(), -1);
                i--;
                continue;
            }
            for(int j =0; j<sheet1.getRow(i).getLastCellNum();j++){
                if(sheet1.getRow(i).getCell(j).toString().trim().equals("")){ //Getting lines that are empty
                    isRowEmpty=true;
                }else {
                    isRowEmpty=false;
                    break;
                }
            }
            if(isRowEmpty==true){
                sheet1.shiftRows(i + 1, sheet1.getLastRowNum(), -1); // Removing empty lines
                i--;
            }
        }



        res = sheet1.getLastRowNum(); // Saving last row number as string variable
        //res = 0;





        // Using last row number to generate column headings
        res1 = res;
        Row row0 = sheet1.createRow(res1);
        res2 = res+1;
        Row row1 = sheet1.createRow(res2);
        res3 = res+2;
        Row row2 = sheet1.createRow(res3);
        res4 = res+3;
        Row row3 = sheet1.createRow(res4);
        res5 = res+4;
        Row row4 = sheet1.createRow(res5);
        res6 = res+5;
        Row row5 = sheet1.createRow(res6);
        res7 = res+6;
        Row row6 = sheet1.createRow(res7);
        res8 = res+7;
        Row row7 = sheet1.createRow(res8);
        res9 = res+8;
        Row row8 = sheet1.createRow(res9);
        res10 = res+9;
        Row row9 = sheet1.createRow(res10);
        res11 = res+10;
        Row row10 = sheet1.createRow(res11);
        res12 = res+11;
        Row row11 = sheet1.createRow(res12);
        res13 = res+12;
        Row row12 = sheet1.createRow(res13);
        res14 = res+13;
        Row row13 = sheet1.createRow(res14);
        res15 = res+14;
        Row row14 = sheet1.createRow(res15);
        res16 = res+15;
        Row row15 = sheet1.createRow(res16);
        res17 = res+16;
        Row row16 = sheet1.createRow(res17);
        res18 = res+17;
        Row row17 = sheet1.createRow(res18);
        res19 = res+18;
        Row row18 = sheet1.createRow(res19);
        res20 = res+19;
        Row row19 = sheet1.createRow(res20);


        //Using empty cell string variables from before along with symbolic variables to define new lines to add

        // Variable Names
        A = row0.createCell(0);
        A.setCellValue(v1.getText().toString());
        A = row1.createCell(0);
        A.setCellValue(v2.getText().toString());
        A = row2.createCell(0);
        A.setCellValue(v3.getText().toString());
        A = row3.createCell(0);
        A.setCellValue(v4.getText().toString());
        A = row4.createCell(0);
        A.setCellValue(v5.getText().toString());
        A = row5.createCell(0);
        A.setCellValue(v6.getText().toString());
        A = row6.createCell(0);
        A.setCellValue(v7.getText().toString());
        A = row7.createCell(0);
        A.setCellValue(v8.getText().toString());
        A = row8.createCell(0);
        A.setCellValue(v9.getText().toString());
        A = row9.createCell(0);
        A.setCellValue(v10.getText().toString());
        A = row10.createCell(0);
        A.setCellValue(v11.getText().toString());
        A = row11.createCell(0);
        A.setCellValue(v12.getText().toString());
        A = row12.createCell(0);
        A.setCellValue(v13.getText().toString());
        A = row13.createCell(0);
        A.setCellValue(v14.getText().toString());
        A = row14.createCell(0);
        A.setCellValue(v15.getText().toString());
        A = row15.createCell(0);
        A.setCellValue(v16.getText().toString());
        A = row16.createCell(0);
        A.setCellValue(v17.getText().toString());
        A = row17.createCell(0);
        A.setCellValue(v18.getText().toString());
        A = row18.createCell(0);
        A.setCellValue(v19.getText().toString());
        A = row19.createCell(0);
        A.setCellValue(v20.getText().toString());

        // Section Headers
        A = row0.createCell(2);
        A.setCellValue(s1.getText().toString());
        A = row1.createCell(2);
        A.setCellValue(s2.getText().toString());
        A = row2.createCell(2);
        A.setCellValue(s3.getText().toString());
        A = row3.createCell(2);
        A.setCellValue(s4.getText().toString());
        A = row4.createCell(2);
        A.setCellValue(s5.getText().toString());
        A = row5.createCell(2);
        A.setCellValue(s6.getText().toString());
        A = row6.createCell(2);
        A.setCellValue(s7.getText().toString());
        A = row7.createCell(2);
        A.setCellValue(s8.getText().toString());
        A = row8.createCell(2);
        A.setCellValue(s9.getText().toString());
        A = row9.createCell(2);
        A.setCellValue(s10.getText().toString());
        A = row10.createCell(2);
        A.setCellValue(s11.getText().toString());
        A = row11.createCell(2);
        A.setCellValue(s12.getText().toString());
        A = row12.createCell(2);
        A.setCellValue(s13.getText().toString());
        A = row13.createCell(2);
        A.setCellValue(s14.getText().toString());
        A = row14.createCell(2);
        A.setCellValue(s15.getText().toString());
        A = row15.createCell(2);
        A.setCellValue(s16.getText().toString());
        A = row16.createCell(2);
        A.setCellValue(s17.getText().toString());
        A = row17.createCell(2);
        A.setCellValue(s18.getText().toString());
        A = row18.createCell(2);
        A.setCellValue(s19.getText().toString());
        A = row19.createCell(2);
        A.setCellValue(s20.getText().toString());

        //Form Names
        A = row0.createCell(1);
        A.setCellValue(fn1.getText().toString());
        A = row1.createCell(1);
        A.setCellValue(fn2.getText().toString());
        A = row2.createCell(1);
        A.setCellValue(fn3.getText().toString());
        A = row3.createCell(1);
        A.setCellValue(fn4.getText().toString());
        A = row4.createCell(1);
        A.setCellValue(fn5.getText().toString());
        A = row5.createCell(1);
        A.setCellValue(fn6.getText().toString());
        A = row6.createCell(1);
        A.setCellValue(fn7.getText().toString());
        A = row7.createCell(1);
        A.setCellValue(fn8.getText().toString());
        A = row8.createCell(1);
        A.setCellValue(fn9.getText().toString());
        A = row9.createCell(1);
        A.setCellValue(fn10.getText().toString());
        A = row10.createCell(1);
        A.setCellValue(fn11.getText().toString());
        A = row11.createCell(1);
        A.setCellValue(fn12.getText().toString());
        A = row12.createCell(1);
        A.setCellValue(fn13.getText().toString());
        A = row13.createCell(1);
        A.setCellValue(fn14.getText().toString());
        A = row14.createCell(1);
        A.setCellValue(fn15.getText().toString());
        A = row15.createCell(1);
        A.setCellValue(fn16.getText().toString());
        A = row16.createCell(1);
        A.setCellValue(fn17.getText().toString());
        A = row17.createCell(1);
        A.setCellValue(fn18.getText().toString());
        A = row18.createCell(1);
        A.setCellValue(fn19.getText().toString());
        A = row19.createCell(1);
        A.setCellValue(fn20.getText().toString());

        // Form Type
        A = row0.createCell(3);
        A.setCellValue(ft1.getText().toString());
        A = row1.createCell(3);
        A.setCellValue(ft2.getText().toString());
        A = row2.createCell(3);
        A.setCellValue(ft3.getText().toString());
        A = row3.createCell(3);
        A.setCellValue(ft4.getText().toString());
        A = row4.createCell(3);
        A.setCellValue(ft5.getText().toString());
        A = row5.createCell(3);
        A.setCellValue(ft6.getText().toString());
        A = row6.createCell(3);
        A.setCellValue(ft7.getText().toString());
        A = row7.createCell(3);
        A.setCellValue(ft8.getText().toString());
        A = row8.createCell(3);
        A.setCellValue(ft9.getText().toString());
        A = row9.createCell(3);
        A.setCellValue(ft10.getText().toString());
        A = row10.createCell(3);
        A.setCellValue(ft11.getText().toString());
        A = row11.createCell(3);
        A.setCellValue(ft12.getText().toString());
        A = row12.createCell(3);
        A.setCellValue(ft13.getText().toString());
        A = row13.createCell(3);
        A.setCellValue(ft14.getText().toString());
        A = row14.createCell(3);
        A.setCellValue(ft15.getText().toString());
        A = row15.createCell(3);
        A.setCellValue(ft16.getText().toString());
        A = row16.createCell(3);
        A.setCellValue(ft17.getText().toString());
        A = row17.createCell(3);
        A.setCellValue(ft18.getText().toString());
        A = row18.createCell(3);
        A.setCellValue(ft19.getText().toString());
        A = row19.createCell(3);
        A.setCellValue(ft20.getText().toString());


        // Field Label
        A = row0.createCell(4);
        A.setCellValue(fl1.getText().toString());
        A = row1.createCell(4);
        A.setCellValue(fl2.getText().toString());
        A = row2.createCell(4);
        A.setCellValue(fl3.getText().toString());
        A = row3.createCell(4);
        A.setCellValue(fl4.getText().toString());
        A = row4.createCell(4);
        A.setCellValue(fl5.getText().toString());
        A = row5.createCell(4);
        A.setCellValue(fl6.getText().toString());
        A = row6.createCell(4);
        A.setCellValue(fl7.getText().toString());
        A = row7.createCell(4);
        A.setCellValue(fl8.getText().toString());
        A = row8.createCell(4);
        A.setCellValue(fl9.getText().toString());
        A = row9.createCell(4);
        A.setCellValue(fl10.getText().toString());
        A = row10.createCell(4);
        A.setCellValue(fl11.getText().toString());
        A = row11.createCell(4);
        A.setCellValue(fl12.getText().toString());
        A = row12.createCell(4);
        A.setCellValue(fl13.getText().toString());
        A = row13.createCell(4);
        A.setCellValue(fl14.getText().toString());
        A = row14.createCell(4);
        A.setCellValue(fl15.getText().toString());
        A = row15.createCell(4);
        A.setCellValue(fl16.getText().toString());
        A = row16.createCell(4);
        A.setCellValue(fl17.getText().toString());
        A = row17.createCell(4);
        A.setCellValue(fl18.getText().toString());
        A = row18.createCell(4);
        A.setCellValue(fl19.getText().toString());
        A = row19.createCell(4);
        A.setCellValue(fl20.getText().toString());


        // Create a path where we will place our List of objects on external storage
        File file = new File(Environment.getExternalStorageDirectory() + "/My Documents", fileName);


        FileOutputStream os = null;

        // Using the code to write the new file
        // Error Messages are defined using Log.w (Log Write)
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