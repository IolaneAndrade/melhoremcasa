package api.Helper;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by lucas on 9/27/15.
 */
public class JSONHelper {
    //list of hospitals to be populated
    private static List<Hospital> hospitalList = new ArrayList<Hospital>();

    /*
    * @param hospitalJsonList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of hospital object
    *
    * @throws JSONException
    * */
    public static List<Hospital> hospitalListFromJSON(String hospitalJsonList )throws JSONException {
        Log.e("IN", "try1");
        JSONObject jsonObj = new JSONObject(hospitalJsonList);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            Hospital hospital = null;
            Log.e("IN", "try2");
            for( int index = 0; index < jArray.length(); index++ ) {

                hospital = new Hospital();

                hospital.setLatitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(1));

                hospital.setLongitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(0));

                hospital.setType(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(1).getString("tipo_sus"));

                hospital.setState(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(2).getString("uf"));

                hospital.setCity(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(3).getString("cidade"));

                hospital.setAddress(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(4).getString("no_logradouro"));

                hospital.setNumber(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(5).getString("nu_endereco"));

                hospital.setDistrict(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(6).getString("no_bairro"));

                hospital.setTelephone(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(7).getString("nu_telefone"));

                hospital.setName(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(8).getString("no_fantasia"));


                hospitalList.add(hospital);
            }

        } catch( NullPointerException npe ) {}

        return hospitalList;
    }

    //list of hospitals to be populated
    private static List<DrugStore> drugstoreList = new ArrayList<DrugStore>();

    /*
    * @param drugstoreList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of drugstore object
    *
    * @throws JSONException
    * */
    public static List<DrugStore> drugstoreBrazilListFromJSON(String drugstoreJsonList )throws JSONException {

        JSONObject jsonObj = new JSONObject(drugstoreJsonList);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            DrugStore drugStore = null;

            for( int index = 0; index < jArray.length(); index++ ) {
                JSONObject temp = jArray.getJSONObject(index).getJSONObject("features");

                drugStore = new DrugStore();

                drugStore.setLatitude(temp.getJSONObject("geometry").getString("coordinates"));
                Log.i(temp.getJSONObject("geometry").getString("coordinates"),"");
                drugStore.setLongitude(temp.getJSONObject("geometry").getString("coordinates"));

                drugStore.setType("AQUITEMFARMACIAPOPULAR");

                drugStore.setCity(temp.getJSONObject("properties").getString("no_cidade"));

                drugStore.setState(temp.getJSONObject("properties").getString("uf"));

                drugStore.setPostalCode(temp.getJSONObject("properties").getString("nu_cep_farmacia"));

                drugStore.setTelephone(temp.getJSONObject("properties").getString("nu_ddd_farmacia")+temp.getJSONObject("properties").getString("nu_telefone_farmacia"));

                drugStore.setName(temp.getJSONObject("properties").getString("no_farmacia"));

                drugStore.setAddress(temp.getJSONObject("properties").getString("no_logradouro"));
            }

        } catch( NullPointerException npe ) {}

        return drugstoreList;
    }
}
