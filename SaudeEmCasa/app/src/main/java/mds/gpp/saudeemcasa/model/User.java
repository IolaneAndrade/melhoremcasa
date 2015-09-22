package mds.gpp.saudeemcasa.model;

import java.util.Date;

/**
 * Created by lucas on 9/22/15.
 */
public class User {
    protected String nameUser;
    protected String emailUser;
    protected Date birthDateUser;

    public User(String nameUser, String emailUser, Date birthDateUser) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.birthDateUser = birthDateUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Date getBirthDateUser() {
        return birthDateUser;
    }

    public void setBirthDateUser(Date birthDateUser) {
        this.birthDateUser = birthDateUser;
    }
}
