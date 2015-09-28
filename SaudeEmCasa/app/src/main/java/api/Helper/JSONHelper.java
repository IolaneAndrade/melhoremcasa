package api.Helper;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by lucas on 9/27/15.
 */
public class JSONHelper {

    private static List<Hospital> hospitalList = new ArrayList<Hospital>();

    public static List<Hospital> hospitalListFromJSON(String hospitalJsonList )throws JSONException {

        JSONArray jArray = new JSONArray( hospitalJsonList );

        try {
            Hospital hospital = null;

            for( int index = 0; index < jArray.length(); index++ ) {

                hospital = new Hospital();
                //TODO change atribute to the atribute in the JSON file
                hospital.setType(jArray.getJSONObject(index).getString("atribute"));

                hospital.setNumber(jArray.getJSONObject(index).getString("atribute"));

                hospital.setDistrict(jArray.getJSONObject(index).getString("atribute"));

                hospital.setTelephone(jArray.getJSONObject(index).getString("atribute"));

                hospital.setName(jArray.getJSONObject(index).getString("atribute"));


                hospitalList.add(hospital);
            }

        } catch( NullPointerException npe ) {}

        return hospitalList;
    }

}
