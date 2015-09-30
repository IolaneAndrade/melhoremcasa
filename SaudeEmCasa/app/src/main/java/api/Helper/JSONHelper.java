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

        JSONObject jsonObj = new JSONObject(hospitalJsonList);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            Hospital hospital = null;

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
    public static List<DrugStore> drugstorePublicListFromJSON(String drugstoreJsonList )throws JSONException {
        drugstoreList.clear();

        JSONObject jsonObj = new JSONObject(drugstoreJsonList);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            DrugStore drugStore = null;

            for( int index = 0; index < jArray.length(); index++ ) {

                drugStore = new DrugStore();

                drugStore.setLongitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(0));

                drugStore.setLatitude(jArray.getJSONObject(index).getJSONObject("geometry").getJSONArray("coordinates").getString(1));

                drugStore.setAddress(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(5).getString("ds_endereco_farmacia"));

                drugStore.setPostalCode(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(6).getString("nu_cep_farmacia"));

                drugStore.setState(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(7).getString("uf"));

                drugStore.setCity(jArray.getJSONObject(index).getJSONArray("properties").getJSONObject(8).getString("cidade"));

                drugStore.setTelephone("(00) 00000000");

                drugStore.setName("Farmácia popular do Brasil");

                drugStore.setType("FARMACIAPOPULAR");
                Log.e("POSTALCODE: ", drugStore.getPostalCode());
                drugstoreList.add(drugStore);
            }

        } catch( NullPointerException npe ) {}

        return drugstoreList;
    }

    /*
    * @param drugstoreList
    *               It is the list of hospitals in the JSON format
    *
    * @return List of drugstore object
    *
    * @throws JSONException
    * */
    public static List<DrugStore> drugstorePrivateListFromJSON(String drugstoreJsonList )throws JSONException {
        drugstoreList.clear();
        JSONObject jsonObj = new JSONObject(drugstoreJsonList);
        JSONArray jArray = jsonObj.getJSONArray("features");

        try {
            DrugStore drugStore = null;

            for( int index = 0; index < jArray.length(); index++ ) {

                drugStore = new DrugStore();

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
                Log.e("POSTALCODE: ", drugStore.getPostalCode());
                drugstoreList.add(drugStore);
            }

        } catch( NullPointerException npe ) {}

        return drugstoreList;
    }
}

// for future use in tests
/*
        String input ="{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2001063\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"TRAVESSA IPASE\"},{\"nu_endereco\":\"77\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(68)3224 3693\"},{\"no_fantasia\":\"CENTRO DE CONTROLE DE ONCOLOGIA DO ACRE\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.81423,-9.96876]}}]}";
        Log.e("IN = ", input);
        try {
            hospitalListFromJSON(input);
        } catch (JSONException e) {
            Log.e("ERROR","JSON");
        }*/
        /*String input ="{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":[{\"gid\":\"17\"},{\"lat\":\"-3.0206756\"},{\"long\":\"-59.9768139\"},{\"ano_farm_pop\":\"2014\"},{\"mes_farm_pop\":\"2\"},{\"ds_endereco_farmacia\":\"AVENIDA NOEL NUTELS N\\u00ba 811\"},{\"nu_cep_farmacia\":\"69095000\"},{\"uf\":\"AM\"},{\"cidade\":\"Manaus\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-59.9768139,-3.0206756]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"444\"},{\"lat\":\"-10.9128701\"},{\"long\":\"-37.0738442\"},{\"ano_farm_pop\":\"2014\"},{\"mes_farm_pop\":\"2\"},{\"ds_endereco_farmacia\":\"RUA CARLOS CORREIA, 528\"},{\"nu_cep_farmacia\":\"49075120\"},{\"uf\":\"SE\"},{\"cidade\":\"Aracaju\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-37.0738442,-10.9128701]}}]}";
        Log.e("IN = ", input);
        try {
            drugstorePublicListFromJSON(input);
        } catch (JSONException e) {
            Log.e("ERROR","JSON");
        }*/
        /*String input = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":[{\"lat\":\"-25.8970182\"},{\"long\":\"-53.0714448\"},{\"nu_ddd_farmacia\":\"46\"},{\"nu_telefone_farmacia\":\"35361015\"},{\"nu_cep_farmacia\":\"85660000\"},{\"no_bairro_farmacia\":\"CENTRO\"},{\"ds_endereco_farmacia\":\"TRAV. DR. ARNALDO BUSATO, N\\u00ba 48\"},{\"no_farmacia\":\"CARNIELETTO & COLFERAI LTDA ME\"},{\"no_cidade\":\"DOIS VIZINHOS\"},{\"uf\":\"PR\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-53.0714448,-25.8970182]}},{\"type\":\"Feature\",\"properties\":[{\"lat\":\"-26.2758084\"},{\"long\":\"-48.8447711\"},{\"nu_ddd_farmacia\":\"47\"},{\"nu_telefone_farmacia\":\"34330357\"},{\"nu_cep_farmacia\":\"89221500\"},{\"no_bairro_farmacia\":\"AMERICA\"},{\"ds_endereco_farmacia\":\"RUA ARACAJU N\\u00ba 305\"},{\"no_farmacia\":\"DROGARIA E FARMACIA CATARINENSE S\\/A\"},{\"no_cidade\":\"JOINVILLE\"},{\"uf\":\"SC\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-48.8447711,-26.2758084]}}]}";
        Log.e("IN = ", input);
        try {
            drugstorePrivateListFromJSON(input);
        } catch (JSONException e) {
            Log.e("ERROR","JSON");
        }
        */