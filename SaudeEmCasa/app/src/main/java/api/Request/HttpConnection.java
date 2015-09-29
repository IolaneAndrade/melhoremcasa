package api.Request;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lucas on 9/28/15.
 */
public class HttpConnection {

    public final static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        public String handleResponse( HttpResponse response ){
            String result = null;

            
            return result;
        }
    };
    public static String request( String url ) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet http = new HttpGet( "http://mkyong.com" );
        HttpResponse response= client.execute(http);
        //String json = new String( client.execute( http ));
        Log.e( response.getEntity().getContent().read()));
        return "";
    }
}
