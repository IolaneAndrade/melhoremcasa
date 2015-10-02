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

import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;


/*
 * Created by lucas on 9/28/15.
 */
public class HttpConnection extends AsyncTask<String, Integer, String > {

    private Context context;
    protected String op;

    public HttpConnection (Context context,String op)
    {
        this.context = context;
        this.op = op;
    }
/*

    public final static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        public String handleResponse( HttpResponse response ) throws IOException {
            String result;

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
*/

    @Override
    protected String doInBackground(String... params) {
        HttpResponse response = null;
        String json = "";

        try {


            if(op.equals("hospital")){
                Log.e("hospital","init");
                HttpGet httpGet = new HttpGet(params[0]);
               //hospitals
                HttpClient client = new DefaultHttpClient();

                ResponseHandler<String> responseHandler=new BasicResponseHandler();
                //String responseBody = client.execute(get, responseHandler);
                json = client.execute(httpGet, responseHandler);

                HospitalController.getInstance(context).updateHospital(json);
                Log.e("hospital", "done");
            }else if(op.equals("drugstore")){

                Log.e("drugstore","init");
                HttpGet httpGet = new HttpGet(params[0]);

                HttpClient client = new DefaultHttpClient();

                ResponseHandler<String> responseHandler=new BasicResponseHandler();

                json = client.execute(httpGet,responseHandler);

                DrugStoreController.getInstance(context).updateDruStores(json,1);
                Log.e("I did it!", "drugstore");
                //public
                httpGet = new HttpGet(params[1]);

                client = new DefaultHttpClient();

                json = client.execute(httpGet,responseHandler);

                DrugStoreController.getInstance(context).updateDruStores(json,0);
                Log.e("I did it!", "drugstore 1");
            }

        } catch (ClientProtocolException e) {
            Log.e("I did it!","nopsc");
        } catch (IOException e) {
            Log.e("I did it!","nops");
        }

        return json;

    }
    @Override
    protected void onPostExecute(String json){/*do nothing*/}

}