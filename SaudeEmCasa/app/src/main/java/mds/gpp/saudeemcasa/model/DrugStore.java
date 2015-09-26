package mds.gpp.saudeemcasa.model;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class DrugStore extends Stablishment {
    public DrugStore() {
    }

    public DrugStore(int id, String latitude, String longitude, String postalCode,String state, String city, String address, float rate) {
        super(city,address,state, rate,id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
    }

    protected String latitude = "";
    protected String longitude = "";
    protected String postalCode = "";

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}