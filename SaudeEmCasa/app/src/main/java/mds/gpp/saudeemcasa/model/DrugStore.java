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
}