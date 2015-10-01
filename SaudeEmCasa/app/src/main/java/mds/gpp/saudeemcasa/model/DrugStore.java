package mds.gpp.saudeemcasa.model;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class DrugStore extends Stablishment {
    public DrugStore() {
    }

    protected String postalCode = "";

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public DrugStore(String nameDrugStore, String telephoneDrugStore) {
        super(nameDrugStore, telephoneDrugStore);
    }

   // protected String number = "";
    //protected String district = "";

    //public String getNumber() { return number; }

    //public void setNumber(String number) { this.number = number; }

    //public String getDistrict() { return district; }

    //public void setDistrict(String district) { this.district = district; }
}