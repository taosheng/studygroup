package net.studygroup;

import org.apache.http.client.HttpClient ;
import org.apache.http.*;
import org.apache.http.impl.client.DefaultHttpClient ;
import org.apache.http.client.methods.*; 

import java.io.*;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;


 
public class MusicMetadataWrapperJDOM{

    private String QUERY_URL="http://musicbrainz.org/ws/2/";

    private Document getQueryResultDocument(String queryString)throws Exception{

        HttpClient mzclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(queryString);
        HttpResponse response = mzclient.execute(httpget);
        HttpEntity entity = response.getEntity();
 
        if (entity != null) {
             println("prepare entity") ;
             InputStream instream = entity.getContent();
             SAXBuilder builder = new SAXBuilder();
             Document doc = builder.build(instream);
             println(doc);
	    return doc ;
        }else{
	    return null;
	}

//getElementsByTagName(String name) 

    }
  
    public String findArtist(String name)throws Exception{
	String id ="" ;
        String queryString = this.QUERY_URL + "artist?query="+name;
        println(queryString);
        Document artistDoc = getQueryResultDocument(queryString) ;
        println(artistDoc) ;
        println(artistDoc.getRootElement() );

        XPath xp = XPath.newInstance("/x:metadata/x:artist-list/x:artist/@id");
        xp.addNamespace("x", "http://musicbrainz.org/ns/mmd-2.0#");
//        Element attr = (Element) xp.selectSingleNode(artistDoc.getRootElement());
        Attribute attr = (Attribute) xp.selectSingleNode(artistDoc.getRootElement());


        println(attr);
	return attr.getValue();
    }
    public static void main(String[] args)throws Exception{
        println("musicbrainz test...using JDOM ") ;

	MusicMetadataWrapperJDOM mmw = new MusicMetadataWrapperJDOM();
	String artistId = mmw.findArtist("Mozart");
        println( artistId );

        
       // Prepare a request object
//        String qstring="http://musicbrainz.org/ws/2/release?artist=3033ce2b-2fb2-408e-8c5a-aea48592d7bc&limit=50" ;

        
    }

    public static void println(Object msg){
        System.out.println(msg);
    }
}
