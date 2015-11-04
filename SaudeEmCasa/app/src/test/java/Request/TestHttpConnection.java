package Request;

import junit.framework.TestCase;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpParams;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;

import api.Exception.ConnectionErrorException;
import api.Request.HttpConnection;

/**
 * Created by lucas on 10/27/15.
 */
public class TestHttpConnection extends TestCase {

    String responseString = null;
    @Test
    public void testNewRequest() {
        HttpConnection connection = new HttpConnection();

        try {
            //connect with google base connection
            responseString = connection.newRequest("http://159.203.95.153:3000/farmacia_popular");
            System.out.println(responseString);
            assertNotNull(responseString);
        } catch (ConnectionErrorException e) {
            assertTrue(false);
        }
    }
    @Test
    public void testHandler() {
        String responseString = null;

        if(responseString.contains("GUIMARÃES")){
            assert(true);
        }else{
            assert(false);
        }
    }

}