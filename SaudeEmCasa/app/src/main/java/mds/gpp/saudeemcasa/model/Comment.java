package mds.gpp.saudeemcasa.model;

import java.util.Date;

/**
 * Created by lucas on 9/22/15.
 */
public class Comment {
    protected String textComment;
    protected Date dateComment;
    protected User userComment;

    public Comment(String textComment, Date dateComment, User userComment) {
        this.textComment = textComment;
        this.dateComment = dateComment;
        this.userComment = userComment;
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
