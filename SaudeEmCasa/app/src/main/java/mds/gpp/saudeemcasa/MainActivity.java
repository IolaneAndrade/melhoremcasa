package mds.gpp.saudeemcasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.model.DrugStore;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrugStoreDao DDao;
        DDao = DrugStoreDao.getInstance(getApplicationContext());
        DrugStore drugstore = new DrugStore();
        Log.e("entrei","criadoDRug");
        drugstore.setPostalCode("00001");
        Log.e("entrei", "setadoDrug");
        drugstore.toString();
        DDao.insertDrugstore(drugstore);

        System.out.println(DDao.getAllDrugStores().size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
