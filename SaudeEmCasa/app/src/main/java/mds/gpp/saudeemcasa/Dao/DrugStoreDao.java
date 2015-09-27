package mds.gpp.saudeemcasa.Dao;

import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by lucas on 9/27/15.
 */
public class DrugStoreDao {
    private static DrugStore instance;
    private static String tableName = "DRUGSTORE";

        //DRUGSTORE
        private static final String DRUGSTORE_ID = "[drugstoreId]";
        private static final String DRUGSTORE_LATITUDE = "[latitude]";
        private static final String DRUGSTORE_LONGETUDE = "[longitude]";
        private static final String DRUGSTORE_POSTALCODE = "[postalCode]";
}
