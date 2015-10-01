package mds.gpp.saudeemcasa.controller;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.HospitalDao;
import api.Helper.JSONHelper;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.Hospital;
import mds.gpp.saudeemcasa.view.HospitalList;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class HospitalController {

    private static HospitalController instance = null;
    private static Hospital hospital;
    private static List<Hospital> hospitalList = new ArrayList<Hospital>();

    private static HospitalDao hospitalDao;

    private HospitalController(Context context) {
        hospitalDao = HospitalDao.getInstance(context);
    }

    public static HospitalController getInstance(Context context) {
        if (instance == null) {
            instance = new HospitalController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }
    public void setHospital( Hospital hospital ) {
        HospitalController.hospital = hospital;
    }

    public static List<Hospital> getAllHospitals(){

        return hospitalList;
    }

    public boolean initControllerHospital() throws IOException, JSONException {
        try {
            if (hospitalDao.isDbEmpty()) {
                //getJSON
                String JsonList = jsonInput;//readFile("/home/lucas/git/melhoremcasa/SaudeEmCasa/app/src/main/java/mds/gpp/saudeemcasa/controller/hp");
                //Create JSON helper
                JSONHelper jsonParser = new JSONHelper();
                //PARSE JSON to object
                List<Hospital> tempHospitalList = jsonParser.hospitalListFromJSON(JsonList);
                //insert in DB
                hospitalDao.insertAllHospitals(tempHospitalList);
                //setting hospitals to local list
                hospitalList = hospitalDao.getAllHospitals();
                return true;
            } else {
                //just setting hospitals to local list
                hospitalList = hospitalDao.getAllHospitals();
                return true;
            }
        }catch (Exception e){
            return false;
        }

    }

    public static float[] getDistance(Context context,ArrayList<Hospital> list) {
        float[] results = new float[list.size()];
        GPSTracker gps = new GPSTracker(context);
        if(gps.canGetLocation()) {
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();

            for (int i = 0; i < list.size(); i++) {
                String auxLatitude = list.get(i).getLatitude();
                String auxLongitude = list.get(i).getLongitude();
                Location hospitalLocation = null;
                Double hospitalLatitude = null;
                Double hospitalLongitude = null;
                hospitalLatitude.parseDouble(auxLatitude);
                hospitalLongitude.parseDouble(auxLongitude);
                hospitalLocation.setLatitude(hospitalLatitude);
                hospitalLocation.setLongitude(hospitalLongitude);
                results[i] = gps.getLocation().distanceTo(hospitalLocation);
            }
            return results;
        }else {
            return null;
        }

    }

    //temporary String imitating the http request anwer
    public static String jsonInput =
            "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2001063\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"TRAVESSA IPASE\"},{\"nu_endereco\":\"77\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(68)3224 3693\"},{\"no_fantasia\":\"CENTRO DE CONTROLE DE ONCOLOGIA DO ACRE\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.81423,-9.96876]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2001063\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"TRAVESSA IPASE\"},{\"nu_endereco\":\"77\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(68)3224 3693\"},{\"no_fantasia\":\"CENTRO DE CONTROLE DE ONCOLOGIA DO ACRE\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.81423,-9.96876]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"6627595\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AM\"},{\"cidade\":\"Manaus\"},{\"no_logradouro\":\"RUA MARIO YPIRANGA\"},{\"nu_endereco\":\"1581\"},{\"no_bairro\":\"ADRIANOPOPLIS\"},{\"nu_telefone\":\"\"},{\"no_fantasia\":\"INSTITUTO DA MULHER DONA LINDU\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-60.00531,-3.06231]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"6627595\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AM\"},{\"cidade\":\"Manaus\"},{\"no_logradouro\":\"RUA MARIO YPIRANGA\"},{\"nu_endereco\":\"1581\"},{\"no_bairro\":\"ADRIANOPOPLIS\"},{\"nu_telefone\":\"\"},{\"no_fantasia\":\"INSTITUTO DA MULHER DONA LINDU\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-60.00531,-3.06231]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"3477487\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"PA\"},{\"cidade\":\"Bel\\u00e9m\"},{\"no_logradouro\":\"AV GENERALISSIMO DEODORO\"},{\"nu_endereco\":\"S\\/N\"},{\"no_bairro\":\"NAZARE\"},{\"nu_telefone\":\"(91)40060006\"},{\"no_fantasia\":\"CLINICA LOBO\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-48.48268,-1.45386]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"6456251\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"PA\"},{\"cidade\":\"Bel\\u00e9m\"},{\"no_logradouro\":\"RUA DOS MUNDURUCUS\"},{\"nu_endereco\":\"3100\"},{\"no_bairro\":\"GUAMA\"},{\"nu_telefone\":\"30843091\"},{\"no_fantasia\":\"PORTO DIAS DIAGNOSTICO\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-48.479,-1.45814]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"6861849\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"RUA VALERIO MAGALHAES\"},{\"nu_endereco\":\"63\"},{\"no_bairro\":\"BOSQUE\"},{\"nu_telefone\":\"68-3223-4345\"},{\"no_fantasia\":\"CEDIMP\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.80064,-9.94949]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"3472264\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"PA\"},{\"cidade\":\"Bel\\u00e9m\"},{\"no_logradouro\":\"TV HUMAITA\"},{\"nu_endereco\":\"1598\"},{\"no_bairro\":\"MARCO\"},{\"nu_telefone\":\"(91)31817000\"},{\"no_fantasia\":\"HOSPITAL SAUDE DA MULHER\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-48.46967,-1.43683]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"3472264\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"PA\"},{\"cidade\":\"Bel\\u00e9m\"},{\"no_logradouro\":\"TV HUMAITA\"},{\"nu_endereco\":\"1598\"},{\"no_bairro\":\"MARCO\"},{\"nu_telefone\":\"(91)31817000\"},{\"no_fantasia\":\"HOSPITAL SAUDE DA MULHER\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-48.46967,-1.43683]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2019426\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AM\"},{\"cidade\":\"Manaus\"},{\"no_logradouro\":\"AV EDUARDO RIBEIRO\"},{\"nu_endereco\":\"620\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(92)6333355\"},{\"no_fantasia\":\"CENTRO RADIOLOGICO DE MANAUS LTDA\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-60.02352,-3.13526]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"5223202\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"AC\"},{\"cidade\":\"Rio Branco\"},{\"no_logradouro\":\"AVENIDA CEARA\"},{\"nu_endereco\":\"412\"},{\"no_bairro\":\"CENTRO\"},{\"nu_telefone\":\"(68) 3224 1763\"},{\"no_fantasia\":\"CLINICA ANDRE LUIZ DIAGNOSTICO POR IMAGEM\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.8076,-9.97131]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"5874645\"},{\"tipo_sus\":\"NAOSUS\"},{\"uf\":\"PA\"},{\"cidade\":\"Cana\\u00e3 dos Caraj\\u00e1s\"},{\"no_logradouro\":\"RUA BELEM\"},{\"nu_endereco\":\"S\\/N\"},{\"no_bairro\":\"MONTE CASTELO\"},{\"nu_telefone\":\"(94) 3358-1735\"},{\"no_fantasia\":\"HOSPITAL 05 DE OUTUBRO\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-49.87843,-6.49737]}},{\"type\":\"Feature\",\"properties\":[{\"gid\":\"2017644\"},{\"tipo_sus\":\"SUS\"},{\"uf\":\"AM\"},{\"cidade\":\"Manaus\"},{\"no_logradouro\":\"AV APURINA\"},{\"nu_endereco\":\"04\"},{\"no_bairro\":\"PRACA 14 DE JANEIRO\"},{\"nu_telefone\":\"(92)33054700\"},{\"no_fantasia\":\"HOSPITAL UNIVERSITARIO GETULIO VARGAS\"}],\"geometry\":{\"type\":\"Point\",\"coordinates\":[-60.01922,-3.116]}}]}";
}


