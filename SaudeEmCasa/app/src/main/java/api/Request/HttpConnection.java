package api.Request;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;


/*
 * Created by lucas on 9/28/15.
 */
public class HttpConnection{

    private Context context;

    public HttpConnection (Context context)
    {
        this.context = context;
    }
    public String Request(String ipAddress) throws ConnectionErrorException{
        String json;
        try{
            HttpGet httpGet = new HttpGet(ipAddress);

            HttpClient client = new DefaultHttpClient();

        json = Request(httpGet,client);

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


    public String Request(HttpGet httpGet ,HttpClient client) throws IOException {

        ResponseHandler<String> responseHandler=new BasicResponseHandler();

        return client.execute(httpGet,responseHandler);
    }
}