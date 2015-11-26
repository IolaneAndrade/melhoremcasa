package mds.gpp.saudeemcasa.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;


/**
 * Created by lucas on 10/21/15.
 */
public class DrugstoreScreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugstore_screen);
        DrugStoreController controller = DrugStoreController.getInstance(this);
        // setting name
        TextView nameTextView = (TextView)findViewById(R.id.textViewDrugName);
        nameTextView.setText(controller.getDrugstore().getName());
        // Address
        TextView addressTextView = (TextView)findViewById(R.id.textViewAddress);
        addressTextView.setText(Html.fromHtml(controller.getDrugstore().getAddress() + " - " + controller.getDrugstore().getCity() + " - " + controller.getDrugstore().getState()));
        //CEP
        TextView cepTextView = (TextView)findViewById(R.id.textViewCep);
        cepTextView.setText("Cep: "+controller.getDrugstore().getPostalCode());
        // setting telephone
        if(controller.getDrugstore().getType().equals("FARMACIAPOPULAR")){
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
            telephoneTextView.setText("");
        }else {
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
            telephoneTextView.setText("Tel: " + controller.getDrugstore().getTelephone());
        }
        setPhoneCallListenner(controller.getDrugstore().getTelephone());
    }

    private void setPhoneCallListenner(final String telephone) {
        ImageButton phoneCallButton = (ImageButton) findViewById(R.id.phonecallButtonDrugstore);
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent phoneCall = new Intent(Intent.ACTION_CALL);
                phoneCall.setData(Uri.parse(telephone));
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(phoneCall);

            }
        });

    }
}