package api.Request;

import android.content.Entity;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import api.Exception.ConnectionErrorException;


/*
 * Created by lucas on 9/28/15.
 */
public class HttpConnection{


    public HttpConnection() {

    }

    public String newRequest(String ipAddress) throws ConnectionErrorException{
        String json;
        try{
            System.out.println("Starting connection with " + ipAddress);
            HttpGet httpGet = new HttpGet(ipAddress);

            HttpClient client = new DefaultHttpClient();

        json = Request(httpGet, client);

        System.out.println("Resquest complete " + ipAddress);

        } catch (ClientProtocolException e) {
            System.out.println("Request failed "+ ipAddress);
            throw new ConnectionErrorException();

        } catch (IOException e) {
            System.out.println("Request failed "+ ipAddress);
            throw new ConnectionErrorException();
        }
        return json;
    }


    public String Request(HttpGet httpGet, HttpClient client) throws IOException {

        ResponseHandler<String> responseHandler=new BasicResponseHandler();

        return client.execute(httpGet,responseHandler);
    }

    public String postRequest(JSONObject json,String ipAdress) {

        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(ipAdress);
        StringEntity jsonString = null;
        try {
            jsonString = new StringEntity(json.toString());
        } catch (UnsupportedEncodingException e) {
            /*handle exception*/
        }
        httpPost.setEntity(jsonString);
        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(httpPost);
        } catch (IOException e) {
            /*handle exception*/
        }
        String responseText = null;

        try {
            responseText = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            Log.i("parse exception", e + "");
        }
        //JSONObject jsonResponse = new JSONObject(responseText);
        return responseText;
    }
}