package net.studygroup ;
import java.util.*;


public class Test{

    public static void main(String argv[])throws Exception{
        hashMapTest() ;
        arrayTest() ;

    }
 


    public static void arrayTest()throws Exception{
        long s = getTime();
        long e = getTime();
        int max = 9999;
        String arrayPure[] = new String[max];
        println("initial Pure array[] ") ;
        s = getTime();
        for(int i=0; i<max; i++){
            arrayPure[i] = Integer.toString(i);
        }
        e = getTime();
        println( e - s ); 

        ArrayList arrayList = new ArrayList(9999);
        println("ArrayList add ") ;
        s = getTime();
        for(int i=0; i<max; i++){
            arrayList.add(Integer.toString(i)) ;
        }
        e = getTime();
        println( e - s ); 

        println("get all object from  array[] ") ;
        s = getTime();
        for(int i=0; i<max; i++){
            String tmp = arrayPure[i] ;
        }
        e = getTime();
        println( e - s ); 

        println("get all object from ArrayList  ") ;
        s = getTime();
        for(int i=0; i<max; i++){
            String tmp = (String)arrayList.get(i);
        }
        e = getTime();
        println( e - s ); 
       
        String s7899 = Integer.toString(7980) ;
        println("get one object from  array[] ") ;
        s = getTime();
        for(int i=0; i<max; i++){
            if(arrayPure[i].equals(s7899) ){
                break ;
            } 
        }
        e = getTime();
        println( e - s ); 

        println("get one object from ArrayList  ") ;
        s = getTime();
        int position = arrayList.indexOf(s7899);
        String theOne = (String)arrayList.get(position);
        e = getTime();
        println( e - s ); 

    }

    public static void hashMapTest()throws Exception{

        long s = getTime();
        long e = getTime();
        int max = 9999;
        println("HashMap with and without type construction") ;

        HashMap<String,String> hashMap1 = new HashMap<String, String>(max);
        s = getTime();
        for(int i =1; i<=max; i++){
            hashMap1.put(new String(Integer.toString(i)),new String(Integer.toString(i)));
        }
        e = getTime();
        println("put with type"); 
        println( e - s ); 

        HashMap hashMap2 = new HashMap(max);
        s = getTime();
        for(int i =1; i<=max; i++){
            hashMap2.put(new String(Integer.toString(i)),new String(Integer.toString(i)));
        }
        e = getTime();
        println("put without type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=max; i++){
            String tmp = hashMap1.get(new String(Integer.toString(i)));
        }
        e = getTime();
        println("get with type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=max; i++){
            String tmp = (String)hashMap2.get(new String(Integer.toString(i)));
        }
        e = getTime();
        println("get without type and trasfer to the right type"); 
        println( e - s ); 

        s = getTime();
        for(int i =1; i<=max; i++){
            Object tmp = hashMap2.get(new String(Integer.toString(i)));
        }
        println("get without type"); 
        e = getTime();
        println( e - s ); 

    }

    private static long getTime(){
         return System.nanoTime() ;
    }
    private static void println(Object msg){
        System.out.println(msg);
    }
 
}
