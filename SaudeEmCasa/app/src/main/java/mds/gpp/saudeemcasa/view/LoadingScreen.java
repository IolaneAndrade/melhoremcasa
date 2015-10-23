package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.apache.http.client.ResponseHandler;
import org.json.JSONException;

import java.io.IOException;

import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;

/**
 * Created by freemanpivo on 9/25/15.
 */

public class LoadingScreen extends Activity {
    HospitalController hospitalController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        final ImageView logoSaudeEmCasa = (ImageView) findViewById(R.id.saude_em_casa_logo);
        //------//
        hospitalController = HospitalController.getInstance(getApplicationContext());
        //---------//
        requestHospital();
    }

    public void requestHospital() {
        //DIALOG
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Carregando dados...");
        progress.show();
        //-----//
        new Thread() {

            public void run() {
                Looper.prepare();

                HospitalController hospitalController = HospitalController.getInstance(getApplicationContext());

                try {
                    hospitalController.initControllerHospital();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                DrugStoreController drugstoreController = DrugStoreController.getInstance(getApplicationContext());
                try {
                    drugstoreController.initControllerDrugstore();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        progress.setMessage("Dados carregados");

                        if (false) {
                            toListScreen();
                        } else {
                            /* ! Nothing To Do. */
                        }

                        progress.dismiss();
                        Looper.loop();
                    }
                });
            }
        }.start();
    }

    private void toListScreen() {
        finish();
        Intent nextScreen = new Intent(getBaseContext(), ChooseScreen.class);
        startActivity(nextScreen);
    }
}
        /*final ImageView spinner = (ImageView) findViewById(R.id.spinner);

        final Animation spinnerAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation fadeOutEffect = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        spinner.startAnimation(spinnerAnimation);
        spinnerAnimation.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spinner.startAnimation(fadeOutEffect);

                finish();
                Intent nextScreen = new Intent(getBaseContext(), ChooseScreen.class);
                startActivity(nextScreen);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }*/

