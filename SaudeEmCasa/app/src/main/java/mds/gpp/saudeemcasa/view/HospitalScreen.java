package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;

/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_screen);
        HospitalController controller = HospitalController.getInstance(this);
        // setting name
        TextView nameTextView = (TextView)findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());
        // Address
        TextView addressTextView = (TextView)findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().getAddress() + " - " + controller.getHospital().getCity() + " - " + controller.getHospital().getState()));
        // setting telephone
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewHospTel);
            telephoneTextView.setText("Tel: " + controller.getHospital().getTelephone());

    }
}
