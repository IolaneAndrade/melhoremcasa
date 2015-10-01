package api.Request;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import api.Dao.HospitalDao;
import api.Helper.JSONHelper;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.Hospital;
import mds.gpp.saudeemcasa.model.Stablishment;

/*
 * Created by lucas on 9/28/15.
 */
/*

public class HttpConnection extends AsyncTask<Void,Void,Void> {




    */
/*public static String request( *//*
*/
/*ResponseHandler<String> response,*//*
*/
/* String url ) throws IOException {
*//*
*/
/*
        CloseableHttpClient client = HttpClients.createDefault();
        //HttpClient client = HttpClientBuilder.create().build();
        HttpGet http = new HttpGet( url );

        String json = new String( client.execute( http, response ).getBytes(
                "ISO-8859-1" ), "UTF-8" );
        client.close();
        return json;
*//*
*/
/*


    }*//*

//    @Override
//    protected void onPreExecute(){
//        //TODO put initial screen to animate.
//    }
    @Override
    protected Void doInBackground(Void... params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://159.203.95.153:8000/habilitados");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
*/
public class HttpConnection extends AsyncTask<String, Integer, String > {

    private Context context;

    public HttpConnection (Context context)
    {
        this.context = context;
    }

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

    @Override
    protected String doInBackground(String... params) {
        HttpResponse response = null;
        String json =null;

        try {
            String comparison[] = params[0].split("/");
            String op = comparison[comparison.length-1];

            if(op.equals("habilitados")){
                HttpGet httpGet = new HttpGet(params[0]);
               //hospitals
                HttpClient client = new DefaultHttpClient();
                //response = client.execute(httpGet);
                json = new String( client.execute( httpGet, responseHandler ).getBytes(
                        "ISO-8859-1" ), "UTF-8" );

                HospitalController.getInstance(context).updateHospital(json);
                Log.e("I did it!", "Hospital");
            }else{
                //drugstore
                //private
                HttpGet httpGet = new HttpGet(params[0]);
                HttpClient client = new DefaultHttpClient();
                //response = client.execute(httpGet);
                json = new String( client.execute( httpGet, responseHandler ).getBytes(
                        "ISO-8859-1" ), "UTF-8" );

                DrugStoreController.getInstance(context).updateDruStores(json);
                Log.e("I did it!", "drugstore");
                //public
                httpGet = new HttpGet(params[1]);
                client = new DefaultHttpClient();
                //response = client.execute(httpGet);
                json = new String( client.execute( httpGet, responseHandler ).getBytes(
                        "ISO-8859-1" ), "UTF-8" );

                DrugStoreController.getInstance(context).updateDruStores(json);
                Log.e("I did it!", "drugstore 1");
            }

        } catch (ClientProtocolException e) {
            Log.e("I did it!","nopsc");
            //Toast.makeText(this.context, "Caught ClientProtocolException", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.e("I did it!","nops");
            //Toast.makeText(this.context, "Caught IOException", Toast.LENGTH_SHORT).show();
        }

        return json;

    }
    @Override
    protected void onPostExecute(String json){/*do nothing*/}

}