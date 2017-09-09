package pers.wxp.gather;

import java.util.LinkedList;

public class ListExample {
	public static void main(String args[]) {
	    LinkedList<String> queue = new LinkedList<String>();
	    queue.addFirst("Bernadine");
	    queue.addFirst("Elizabeth");
	    queue.addFirst("Gene");
	    queue.addFirst("Elizabeth");	
	    queue.addFirst("Clara");
	    System.out.println(queue);
	    queue.removeLast();
	    queue.removeLast();
	    System.out.println(queue);
	  }

}
