import junit.framework.TestCase;

import org.junit.Test;

import mds.gpp.saudeemcasa.model.Comment;

public class TestModelComment extends TestCase{

    @Test
    public void testSetIdComment(){
        Comment comment = new Comment();
        comment.setIdComment(12345);
        assertTrue(comment.getIdComment() == 12345);
    }

    @Test
    public void testGetIdComment(){
        Comment comment = new Comment();
        comment.setIdComment(67890);
        assertEquals(67890, comment.getIdComment());
    }

    @Test
    public void testSetTextComment(){
        Comment comment = new Comment();
        comment.setTextComment("Good job!");
        assertTrue(comment.getTextComment() == "Good job!" );
    }

    @Test
    public void testGetTextComment(){
        Comment comment = new Comment();
        comment.setTextComment("Nice job!");
        assertEquals("Nice job!", comment.getTextComment());
    }

}
