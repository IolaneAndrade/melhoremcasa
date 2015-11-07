package api.Helper;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import api.Dao.HospitalDao;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by lucas on 9/27/15.
 */
public class JSONHelper {




    public JSONHelper(Context context){
        drugStoreDao = DrugStoreDao.getInstance(context);
        hospitalDao =HospitalDao.getInstance(context);
    }
    //list of hospitals to be populated
    HospitalDao hospitalDao;

    /*
    * @param hospitalJsonList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of hospital object
    *
    * @throws JSONException
    * */
    public boolean hospitalListFromJSON(String hospitalJsonList )throws JSONException {
        JSONArray tmp = new JSONArray(hospitalJsonList);
        JSONObject jsonObj = tmp.getJSONObject(0);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            Hospital hospital = new Hospital();

            for( int index = 0; index < jArray.length(); index++ ) {

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

                hospitalDao.insertHospital(hospital);

                System.out.println("hospital inserted");
            }

        } catch( NullPointerException npe ) {return false;}

        return true;
    }

    //list of hospitals to be populated
    DrugStoreDao drugStoreDao;

    /*
    * @param drugstoreList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of drugstore object
    *
    * @throws JSONException
    * */
    public boolean drugstorePublicListFromJSON(String drugstoreJsonList )throws JSONException {

        JSONArray tmp = new JSONArray(drugstoreJsonList);
        JSONObject jsonObj = tmp.getJSONObject(0);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {

            DrugStore drugStore = new DrugStore();

            for( int index = 0; index < jArray.length(); index++ ) {

                drugStore.setLongitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(0));

                drugStore.setLatitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(1));

                drugStore.setAddress(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(5).getString("ds_endereco_farmacia"));

                drugStore.setPostalCode(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(6).getString("nu_cep_farmacia"));

                drugStore.setState(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(7).getString("uf"));

                drugStore.setCity(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(8).getString("cidade"));

                drugStore.setTelephone("(00) 00000000");

                drugStore.setName("Farmácia popular do Brasil");

                drugStore.setType("FARMACIAPOPULAR");

                drugStoreDao.insertDrugstore(drugStore);

                System.out.println("drugstore inserted");

            }

        } catch( NullPointerException npe ) {
            return false;
        }

        return true;
    }

    /*
    * @param drugstoreList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of drugstore object
    *
    * @throws JSONException
    * */
    public boolean drugstorePrivateListFromJSON(String drugstoreJsonList )throws JSONException {

        JSONArray tmp = new JSONArray(drugstoreJsonList);
        JSONObject jsonObj = tmp.getJSONObject(0);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            DrugStore drugStore = new DrugStore();;

            for( int index = 0; index < jArray.length(); index++ ) {

                drugStore.setLongitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(0));

                drugStore.setLatitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(1));

                drugStore.setTelephone("(" + jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(2).getString("nu_ddd_farmacia") + ")"
                        + jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(3).getString("nu_telefone_farmacia"));

                drugStore.setPostalCode(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(4).getString("nu_cep_farmacia"));

                drugStore.setAddress(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(6).getString("ds_endereco_farmacia"));

                drugStore.setName(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(7).getString("no_farmacia"));

                drugStore.setCity(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(8).getString("no_cidade"));

                drugStore.setState(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(9).getString("uf"));

                drugStore.setType("AQUITEMFARMACIAPOPULAR");

                drugStoreDao.insertDrugstore(drugStore);

                System.out.println("drugstore inserted");
            }

        } catch( NullPointerException npe ) {
            return false;
        }

        return true;
    }
}
