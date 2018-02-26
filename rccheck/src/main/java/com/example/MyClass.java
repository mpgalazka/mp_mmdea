package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

public class MyClass
{
    private final List<NameValuePair> params;
    private final HttpPost post;
    private HttpResponse resp;
    private final HttpClient client;
    private int respCode;
    private BufferedReader reader;
    private final StringBuffer result;
    private String line, deva, demopp1, demopp2, demopp3;

    public MyClass(final Config c)
    {




        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("token", c.API_TOKEN));
        params.add(new BasicNameValuePair("content", "record"));
        params.add(new BasicNameValuePair("format", "json"));
        params.add(new BasicNameValuePair("type", "flat"));

        params.add(new BasicNameValuePair("records", "123"));
        params.add(new BasicNameValuePair("fields[0]", "fugl_meyer_complete"));
        params.add(new BasicNameValuePair("fields[1]", "barthel_complete"));
        params.add(new BasicNameValuePair("rawOrLabel", "raw"));
        params.add(new BasicNameValuePair("events[0]", "dc_arm_1"));
        params.add(new BasicNameValuePair("events[1]", "pp1_arm_1"));
        params.add(new BasicNameValuePair("events[2]", "pp2_arm_1"));
        params.add(new BasicNameValuePair("rawOrLabelHeaders", "raw"));
        params.add(new BasicNameValuePair("exportCheckboxLabel", "false"));
        params.add(new BasicNameValuePair("exportSurveyFields", "false"));
        params.add(new BasicNameValuePair("exportDataAccessGroups", "false"));
        params.add(new BasicNameValuePair("returnFormat", "json"));


        post = new HttpPost(c.API_URL);
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");

        try
        {
            post.setEntity(new UrlEncodedFormEntity(params));
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        result = new StringBuffer();
        client = HttpClientBuilder.create().build();
        respCode = -1;
        reader = null;
        line = null;
    }

    public void doPost()
    {
        resp = null;

        try
        {
            resp = client.execute(post);
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        if(resp != null)
        {
            respCode = resp.getStatusLine().getStatusCode();

            try
            {
                reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
        }

        if(reader != null)
        {
            try
            {
                while((line = reader.readLine()) != null)
                {
                    result.append(line);
                }
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("respCode: " + respCode);
        System.out.println("result: " + result);



        deva = result.toString();
        JSONArray GAY = new JSONArray(deva);

        demopp1 = GAY.getJSONObject(0).toString();
        demopp2 = GAY.getJSONObject(1).toString();
        demopp3 = GAY.getJSONObject(2).toString();




        String gal = GAY.getJSONObject(0).getString("fugl_meyer_complete");
        String gal1 = GAY.getJSONObject(1).getString("fugl_meyer_complete");
        String gal2 = GAY.getJSONObject(2).getString("fugl_meyer_complete");

        String ayy = GAY.getJSONObject(0).getString("barthel_complete");




        System.out.println("PP1 " + demopp1);
        System.out.println("PP2 " + demopp2);
        System.out.println("PP3 " + demopp3);

        System.out.println("test " + gal);
        System.out.println("test " + gal1);
        System.out.println("test " + gal2);
        System.out.println("test " + ayy);





    }


}
