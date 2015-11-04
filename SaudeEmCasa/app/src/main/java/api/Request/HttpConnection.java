package api.Request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import api.Exception.ConnectionErrorException;


/*
 * Created by lucas on 9/28/15.
 */
public class HttpConnection{


    public HttpConnection() {

    }
    public final static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

        public String handleResponse( HttpResponse response ) throws IOException {

            HttpEntity entity = response.getEntity();
            String result = null;

            BufferedReader buffer = new BufferedReader( new InputStreamReader(
                entity.getContent() ) );

            StringBuilder builder = new StringBuilder();
            String line = null;

            while( ( line = buffer.readLine() ) != null ) {

                builder.append( line + "\n" );
            }

            buffer.close();
            result = builder.toString();

            return result;
        }
    };
    public synchronized static ResponseHandler<String> getResponseHandler() {
        return responseHandler;
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

        ResponseHandler<String> responseHandler= getResponseHandler();

        return new String(client.execute(httpGet,responseHandler).getBytes("ISO-8859-1" ), "UTF-8" );
    }
}