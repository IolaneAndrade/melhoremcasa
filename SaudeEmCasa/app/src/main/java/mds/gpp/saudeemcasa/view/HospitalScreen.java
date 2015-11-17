package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.Hospital;


/**
 * Created by lucas on 10/21/15.
 */
public class HospitalScreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_screen);
        HospitalController controller = HospitalController.getInstance(this);
        // setting name
        TextView nameTextView = (TextView)findViewById(R.id.hospitalName);
        nameTextView.setText(controller.getHospital().getName());
        // Address
//        TextView addressTextView = (TextView)findViewById(R.id.textViewAddress);
//        addressTextView.setText(Html.fromHtml(controller.getDrugstore().getAddress() + " - " + controller.getDrugstore().getCity() + " - " + controller.getDrugstore().getState()));
//        //CEP
//        TextView cepTextView = (TextView)findViewById(R.id.textViewCep);
//        cepTextView.setText("Cep: "+controller.getDrugstore().getPostalCode());
//        // setting telephone
//        if(controller.getDrugstore().getType().equals("FARMACIAPOPULAR")){
//            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
//            telephoneTextView.setText("");
//        }else {
//            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
//            telephoneTextView.setText("Tel: " + controller.getDrugstore().getTelephone());
//        }
    }
}
