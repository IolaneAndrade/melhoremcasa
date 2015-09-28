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

        JSONArray jArray = new JSONArray( hospitalJsonList );

        try {
            Hospital hospital = null;

            for( int index = 0; index < jArray.length(); index++ ) {
                JSONObject temp = jArray.getJSONObject(index).getJSONObject("features");

                hospital = new Hospital();

                hospital.setLatitude(temp.getJSONObject("geometry").getString("coordinates"));

                hospital.setLongitude(temp.getJSONObject("geometry").getString("coordinates"));

                hospital.setType(temp.getJSONObject("properties").getString("tipo_sus"));

                hospital.setCity(temp.getJSONObject("properties").getString("cidade"));

                hospital.setState(temp.getJSONObject("properties").getString("uf"));

                hospital.setNumber(temp.getJSONObject("properties").getString("nu_endereco"));

                hospital.setDistrict(temp.getJSONObject("properties").getString("no_bairro"));

                hospital.setTelephone(temp.getJSONObject("properties").getString("nu_telefone"));

                hospital.setName(temp.getJSONObject("properties").getString("no_fantasia"));

                hospital.setAddress(temp.getJSONObject("properties").getString("no_logradouro"));


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
    public static List<DrugStore> drugstoreListFromJSON(String drugstoreJsonList )throws JSONException {

        JSONArray jArray = new JSONArray( drugstoreJsonList );

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
