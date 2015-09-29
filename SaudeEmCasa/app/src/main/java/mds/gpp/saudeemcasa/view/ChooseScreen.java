package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mds.gpp.saudeemcasa.R;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class ChooseScreen extends Activity{

    public boolean hospitalButtonState = false;
    public boolean drugStoreButtonState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_screen);

        Button hospitalButton = (Button) findViewById(R.id.melhor_em_casa_button);
        Button drugStoreButton = (Button) findViewById(R.id.farm_popular_button);


        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getBaseContext(), HospitalList.class);
                startActivity(nextScreen);

            }
        });

        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getBaseContext(), DrugStoreList.class);
                startActivity(nextScreen);
            }
        });
    }

    private void setupHospitalButton(Button hospitalButton){
        //1. Get a reference to the button
        //Button hospitalButton = (Button) findViewById(R.id.melhor_em_casa_button);

        //2. Set the click listener to run the code
        hospitalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View screen) {
                Intent nextScreen = new Intent(getBaseContext(), HospitalList.class);
                startActivity(nextScreen);
            }
        });
    }

    private void setupDrugStoreButton(Button drugStoreButton){
        //1. Get a reference to the button
        //Button drugStoreButton = (Button) findViewById(R.id.drugbutton);

        //2. Set the click listener to run the code
        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View screen){
                Intent nextScreen = new Intent(getBaseContext(), DrugStoreList.class);
                startActivity(nextScreen);
            }
        });
    }
}