package pers.wxp.gather;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array1 = {1, 2};
        List al = new ArrayList();
        al.add(new Object());
        al.add(new Integer(111));
        al.add(new String("hello world111"));

        List<Object> a2 = al ;
        a2.add(new Object ( ) );
        a2 .add (new Integer( 222 ) );
        a2.add(new String ("hello world222") ) ;

        List<Integer> a3 = al ;
        a3.add( new Integer ( 333 ));
        a3.add (new Object()) ;
        a3.add( new String ("hello world33")) ;

        List<?> a4 = al ;
        al.remove (0) ;
        a4.clear () ;
        a4.add (new Object());
    }
}
