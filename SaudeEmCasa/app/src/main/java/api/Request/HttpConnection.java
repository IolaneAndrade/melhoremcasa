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

    @Override
    protected String doInBackground(String... params) {
        String json = "";

        try {

            if(op.equals("hospital")){

                Log.e("hospital","init");

                HttpGet httpGet = new HttpGet(params[0]);

                HttpClient client = new DefaultHttpClient();

                json = Request(httpGet,client);

                HospitalController.getInstance(context).updateHospital(json);

                Log.e("Resquest complete", params[0]);
            }else if(op.equals("drugstore")){

                Log.e("Request ","init");

                HttpGet httpGet = new HttpGet(params[0]);

                HttpClient client = new DefaultHttpClient();

                json = Request(httpGet,client);

                DrugStoreController.getInstance(context).updateDruStores(json, 1);

                Log.e("Request Complete", params[0]);
                //public
                httpGet = new HttpGet(params[1]);

                client = new DefaultHttpClient();

                json = Request(httpGet,client);

                DrugStoreController.getInstance(context).updateDruStores(json,0);

                Log.e("Resquest complete", params[1]);
            }

        } catch (ClientProtocolException e) {
            Log.e("ClientProtocol"," Exception");
        } catch (IOException e) {
            Log.e("IO ","Exception");
        }

        return json;

    }
    @Override
    protected void onPostExecute(String json){/*do nothing*/}

    public String Request(HttpGet httpGet ,HttpClient client) throws IOException {

        ResponseHandler<String> responseHandler=new BasicResponseHandler();

        return client.execute(httpGet,responseHandler);
    }
}