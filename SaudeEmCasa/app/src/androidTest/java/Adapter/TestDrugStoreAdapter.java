package Adapter;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.adapter.DrugStoreAdapter;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.view.LoadingScreen;

/**
 * Created by vinisilvacar on 10/11/15.
 */
public class TestDrugStoreAdapter extends ActivityInstrumentationTestCase2<LoadingScreen> {
    private LoadingScreen myActivity;
    private ArrayList<DrugStore> lista;

    private DrugStoreAdapter drugStoreAdapter;
    Context context;

    public TestDrugStoreAdapter() {

            super(LoadingScreen.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.myActivity = getActivity();
        lista = new ArrayList<DrugStore>();
        context = myActivity.getApplicationContext();
        drugStoreAdapter = new DrugStoreAdapter(context,lista);

    }

    public void testGetCount() {

        assertNotNull(drugStoreAdapter);
        assertEquals(drugStoreAdapter.getCount(), drugStoreAdapter.COUNT);
    }

    /*public void testGetItem() {
        int position = 0;
        assertNotNull(drugStoreAdapter);
        assertEquals(drugStoreAdapter.getItem(position), lista.get(position));
    } */

    public void testGetItemId() {
        int position = 5;
        assertNotNull(drugStoreAdapter);
        assertEquals(drugStoreAdapter.getItemId(position), position);
    }

    public void testGetView() throws Exception {


    }
}
