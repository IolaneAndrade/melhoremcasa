package api.Request;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

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
}