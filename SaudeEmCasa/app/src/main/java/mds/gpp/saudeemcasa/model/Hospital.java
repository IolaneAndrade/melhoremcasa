package mds.gpp.saudeemcasa.model;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class Hospital extends Stablishment {

    public Hospital(int id, String type, String number, String district, String telephone, String name,String city, String address,float rate) {
        super (String city, String address,float rate);
        this.type = type;
        this.number = number;
        this.district = district;
        this.telephone = telephone;
        this.name = name;
    }

    protected int id=0;
    protected String type = "";
    protected String number = "";
    protected String district = "";
    protected String telephone = "";
    protected String name = "";


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}