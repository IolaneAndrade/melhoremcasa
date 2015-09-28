package api.Helper;

import org.json.JSONArray;
import org.json.JSONException;

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

                hospital = new Hospital();

                hospital.setType(jArray.getJSONObject(index).getString("tipo_sus"));

                hospital.setCity(jArray.getJSONObject(index).getString("cidade"));

                hospital.setState(jArray.getJSONObject(index).getString("uf"));

                hospital.setNumber(jArray.getJSONObject(index).getString("nu_endereco"));

                hospital.setDistrict(jArray.getJSONObject(index).getString("no_bairro"));

                hospital.setTelephone(jArray.getJSONObject(index).getString("nu_telefone"));

                hospital.setName(jArray.getJSONObject(index).getString("no_fantasia"));

                hospital.setAddress(jArray.getJSONObject(index).getString("no_logradouro"));

                hospital.setRate(0);


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
                /*
                drugStore = new DrugStore();

                hospital.setType(jArray.getJSONObject(index).getString("tipo_sus"));

                hospital.setCity(jArray.getJSONObject(index).getString("cidade"));

                hospital.setState(jArray.getJSONObject(index).getString("uf"));

                hospital.setNumber(jArray.getJSONObject(index).getString("nu_endereco"));

                hospital.setDistrict(jArray.getJSONObject(index).getString("no_bairro"));

                hospital.setTelephone(jArray.getJSONObject(index).getString("nu_telefone"));

                hospital.setName(jArray.getJSONObject(index).getString("no_fantasia"));

                hospital.setAddress(jArray.getJSONObject(index).getString("no_logradouro"));

                hospital.setRate(0);


                hospitalList.add(hospital);*/
            }

        } catch( NullPointerException npe ) {}

        return drugstoreList;
    }
}
