package api.Request;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created by lucas on 9/28/15.
 */

public class HttpConnection extends AsyncTask {

    public final static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        public String handleResponse( HttpResponse response ) throws IOException {
            String result = null;

            HttpEntity entity = response.getEntity();

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


    public static String request( ResponseHandler<String> response, String url ) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet http = new HttpGet( url );

        String json = new String( client.execute( http, response ).getBytes(
                "ISO-8859-1" ), "UTF-8" );

        return json;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            Log.e(request(responseHandler,"http://159.203.95.153:8000/farmacia_popular_conveniada"),"");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
