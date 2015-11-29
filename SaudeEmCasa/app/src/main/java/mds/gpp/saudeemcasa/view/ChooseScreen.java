package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class ChooseScreen extends Activity{

    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_screen);

        Button hospitalButton = (Button) findViewById(R.id.melhor_em_casa_button);
        Button drugStoreButton = (Button) findViewById(R.id.farm_popular_button);
        gps = new GPSTracker(this);

        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospitalListThread();
            }
        });

        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drugstoreListThread();
            }
        });
    }
    public void hospitalListThread(){
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Requerindo avaliações...");
        progress.show();
        new Thread() {
            public void run() {
                Looper.prepare();
                try {
                    HospitalController.getInstance(getApplicationContext()).requestRating();
                    Intent nextScreen = new Intent(getBaseContext(), HospitalList.class);
                    startActivity(nextScreen);
                } catch (ConnectionErrorException e) {
                    Toast.makeText(getApplicationContext(),"Houve um error de conexão.\nverifique sua conexão com a internet. ",Toast.LENGTH_LONG).show();
                }
                progress.dismiss();
                Looper.loop();
            }
        }.start();
    }
    public void drugstoreListThread(){
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Requerindo avaliações...");
        progress.show();
        new Thread() {
            public void run() {
                Looper.prepare();
                try {
                    DrugStoreController.getInstance(getApplicationContext()).requestRating();
                    Intent nextScreen = new Intent(getBaseContext(), DrugStoreList.class);
                    startActivity(nextScreen);
                } catch (ConnectionErrorException e) {
                    Toast.makeText(getApplicationContext(), "Houve um error de conexão.\nverifique sua conexão com a internet. ", Toast.LENGTH_LONG).show();
                }

                progress.dismiss();
                Looper.loop();
            }
        }.start();
    }
}