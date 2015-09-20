package mds.gpp.saudeemcasa.model;

/**
 * Created by freemanpivo on 9/20/15.
 */



public class Stablishment {

    protected String city = "";
    protected String address = "";
    protected String state = "";
    protected int rate = 0;

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCity() {

        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public int getRate() {
        return rate;
    }
}