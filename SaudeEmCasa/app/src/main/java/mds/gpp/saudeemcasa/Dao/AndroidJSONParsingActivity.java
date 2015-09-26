package mds.gpp.saudeemcasa.Dao;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;


public class AndroidJSONParsingActivity extends ListActivity {

    // url to make request
    private static String url = "API TO GET THE DATA";
    // JSON Node names
    /*
    private static final String TAG_CATEGORY = "categories";
    private static final String TAG_CATEGORY_ID = "category_id";
    private static final String TAG_NAME = "name";
    private static final String TAG_IS_ACTIVE = "is_active";
    */
    //contacts JSONArray
    JSONArray contacts = null;
    private DBCore db;
    //private SQLiteDatabase mydatabase = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();

        // Creating JSON Parser instance
        JSONParser jParser = new JSONParser();

        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url);

        try {
            // Getting Array of Contacts
            contacts = json.getJSONArray(TAG_CATEGORY);

            // looping through All Contacts
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);

                // Storing each json item in variable
                String id = c.getString(TAG_CATEGORY_ID);
                String name = c.getString(TAG_NAME);
                String is_active = c.getString(TAG_IS_ACTIVE);

                databaseHelper.saveCategoryRecord(id, name);

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_CATEGORY_ID, id);
                map.put(TAG_NAME, name);
                map.put(TAG_IS_ACTIVE, is_active);
                // adding HashList to ArrayList
                contactList.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}