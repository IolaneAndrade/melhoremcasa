package mds.gpp.saudeemcasa.model;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class DrugStore extends Stablishment {

    public DrugStore(int id, String latitude, String longitude, String postalCode,String city, String address, float rate) {
        super (String city, String address,float rate);
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
    }

    protected int id=0;
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