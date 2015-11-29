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
public class HttpConnection {
    private static String states[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

    public HttpConnection() {

    }

    public String newRequest(String ipAddress) throws ConnectionErrorException {
        String json;
        try {
            System.out.println("Starting connection with " + ipAddress);
            HttpGet httpGet = new HttpGet(ipAddress);

            HttpClient client = new DefaultHttpClient();

            json = Request(httpGet, client);

            System.out.println("Resquest complete " + ipAddress);

        } catch (ClientProtocolException e) {
            System.out.println("Request failed " + ipAddress);
            throw new ConnectionErrorException();

        } catch (IOException e) {
            System.out.println("Request failed " + ipAddress);
            throw new ConnectionErrorException();
        }
        return json;
    }

    public String RequestAll(String ipAdress) {
        String finalJson = "";

        for (int i = 0; i < states.length; i++) {
            String tmp = null;
            try {
                tmp = newRequest(ipAdress + "/uf/" + states[i]);
            } catch (ConnectionErrorException e) {
                Log.e("Error to request UF = ", states[i]);
            }
            finalJson = finalJson + "," + tmp.substring(1, tmp.length() - 1);
        }
        finalJson = finalJson.substring(1, finalJson.length());
        return "[" + finalJson + "]";
    }

    public String Request(HttpGet httpGet, HttpClient client) throws IOException {

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        return client.execute(httpGet, responseHandler);
    }

}