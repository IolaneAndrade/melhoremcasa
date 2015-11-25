package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.helper.GPSTracker;

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
                if(gps.canGetLocation()) {
                    Intent nextScreen = new Intent(getBaseContext(), HospitalList.class);
                    startActivity(nextScreen);
                }else {
                    Toast.makeText(getApplicationContext(),"Ligue seu GPS/Conecte-se a internet",Toast.LENGTH_LONG).show();

                }

            }
        });

        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gps.canGetLocation()) {
                    Intent nextScreen = new Intent(getBaseContext(), DrugStoreList.class);
                    startActivity(nextScreen);
                }else {
                    Toast.makeText(getApplicationContext(),"Ligue seu GPS/Conecte-se a internet",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}