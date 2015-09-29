package mds.gpp.saudeemcasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import api.Helper.JSONHelper;

import static api.Helper.JSONHelper.hospitalListFromJSON;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("CREATED: ", "SUCESS");
        String input ="{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2001063\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"TRAVESSA IPASE\"},{\"nu_endereco\":\"77\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(68)3224 3693\"},{\"no_fantasia\":\"CENTRO DE CONTROLE DE ONCOLOGIA DO ACRE\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.81423,-9.96876]}}]}";
        Log.e("IN = ", input);
        try {
            hospitalListFromJSON(input);
        } catch (JSONException e) {
            Log.e("ERROR","JSON");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
