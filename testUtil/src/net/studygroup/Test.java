package net.studygroup ;
import java.util.*;


public class Test{

    public static void main(String argv[])throws Exception{

        long s = getTime();
        long e = getTime();
        println("HashMap with and without type construction") ;

        HashMap<String,String> hashMap1 = new HashMap<String, String>(9999);
        s = getTime();
        for(int i =1; i<=9999; i++){
            hashMap1.put(new String(Integer.toString(i)),new String(Integer.toString(i)));
        }
        e = getTime();
        println("put with type"); 
        println( e - s ); 

        HashMap hashMap2 = new HashMap(9999);
        s = getTime();
        for(int i =1; i<=9999; i++){
            hashMap2.put(new String(Integer.toString(i)),new String(Integer.toString(i)));
        }
        e = getTime();
        println("put without type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=9999; i++){
            String tmp = hashMap1.get(new String(Integer.toString(i)));
        }
        e = getTime();
        println("get with type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=9999; i++){
            Object tmp = hashMap2.get(new String(Integer.toString(i)));
        }
        e = getTime();
        println("get without type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=9999; i++){
            String tmp = (String)hashMap2.get(new String(Integer.toString(i)));
        }
        e = getTime();
        println("get without type and trasfer to the right type"); 
        println( e - s ); 

    }

    private static long getTime(){
         return System.nanoTime() ;
    }
    private static void println(Object msg){
        System.out.println(msg);
    }
 
}
