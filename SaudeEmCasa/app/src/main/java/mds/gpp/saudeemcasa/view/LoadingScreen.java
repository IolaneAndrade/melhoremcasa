package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;

import org.apache.http.client.ResponseHandler;
import org.json.JSONException;

import java.io.IOException;


import api.Exception.ConnectionErrorException;
import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;

/**
 * Created by freemanpivo on 9/25/15.
 */

public class LoadingScreen extends Activity {
    HospitalController hospitalController;
    private Handler messageHandler = new Handler();

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
        final AlertDialog.Builder msgNeutralBuilder =
                new AlertDialog.Builder( this )
                        .setNeutralButton( "Retry", new RetryButtonListener() );

        msgNeutralBuilder
                .setTitle( "Falha na Conexão" )
                .setMessage("Não foi possível baixar os dados do servidor.");
        final AlertDialog messageFailedConnection = msgNeutralBuilder.create();
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
                } catch (ConnectionErrorException e) {
                    showMessageOnThread( messageFailedConnection, messageHandler);
                }

                DrugStoreController drugstoreController = DrugStoreController.getInstance(getApplicationContext());
                try {
                    drugstoreController.initControllerDrugstore();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }catch (ConnectionErrorException cee){
                    showMessageOnThread( messageFailedConnection, messageHandler);
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
    private void showMessageOnThread( final AlertDialog message,
                                      Handler messageHandler ) {

        messageHandler.post(new Runnable() {
            public void run() {
                message.show();
            }
        });
    }
    private void toListScreen() {
        finish();
        Intent nextScreen = new Intent(getBaseContext(), ChooseScreen.class);
        startActivity(nextScreen);
    }
    private class RetryButtonListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick( DialogInterface dialog, int which ) {
            dialog.dismiss();

        }
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

