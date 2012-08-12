package net.studygroup ;

import com.google.code.facebookapi.*;

/**

FACEBOOK_APP_ID = '192260850799345'
FACEBOOK_APP_SECRET = '488ef9cd3b5c012c72525d6c826c0763'

informCollector
APP_ID=	395203237213319
App Secret:	5129669d03631df091ba68d55baad85b


*/

public class FBClientTest{

    public static void main(String arg[])throws Exception{

        println("FB client test program...");
        String API_KEY = "395203237213319" ;
        String SECRET_KEY = "5129669d03631df091ba68d55baad85b";

FacebookJsonRestClient client = new FacebookJsonRestClient(API_KEY, SECRET_KEY);
String token = client.auth_createToken();
String url = "http://www.facebook.com/login.php?api_key=" + API_KEY + "&version=1.0" + "&auth_token=" + token;
Runtime.getRuntime().exec("open " + url); // OS X only!
System.out.println("log in to facebook and press enter.");
System.in.read();
Boolean isDesktop = client.isDesktop();
String session = client.auth_getSession(token, true);
String cacheSessionKey = client.getCacheSessionKey();





    }

	private static void println(Object msg){
		System.out.println(msg);
	}

}
