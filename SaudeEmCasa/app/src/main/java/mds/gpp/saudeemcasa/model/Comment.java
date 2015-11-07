package mds.gpp.saudeemcasa.model;

import java.util.Date;

/**
 * Created by lucas on 9/22/15.
 */
public class Comment {
    protected int idComment;
    protected String textComment;
    protected Date dateComment;
    protected User userComment;
    protected Stablishment stablishment;

    public Comment(){

    }

    public Comment(int idComment, String textComment, Date dateComment, User userComment, Stablishment stablishment) {
        this.idComment = idComment;
        this.textComment = textComment;
        this.dateComment = dateComment;
        this.userComment = userComment;
        this.stablishment = stablishment;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public Stablishment getStablishment() {
        return stablishment;
    }

    public void setStablishment(Stablishment stablishment) {
        this.stablishment = stablishment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }
}
