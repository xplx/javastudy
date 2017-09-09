package pers.wxp.gather;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortExample {
	 public static void main(String args[]) {
		    Map<Integer, Object> map1 = new HashMap<Integer, Object>(); 
		    Map<Integer, Object> map2 = new LinkedHashMap<Integer, Object>();
		    for(int i=0;i<10;i++){
		    	double s=Math.random()*100;//产生一个随机数，并将其放入Map中
		    	 map1.put(new Integer((int) s),"第 "+i+" 个放入的元素："+s+"\n");
		    	 map2.put(new Integer((int) s),"第 "+i+" 个放入的元素："+s+"\n");
		    }
		    
		    System.out.println("未排序前HashMap："+map1);
		    System.out.println("未排序前LinkedHashMap："+map2);
		    //使用TreeMap来对另外的Map进行重构和排序
		    Map<Integer, Object> sortedMap = new TreeMap<Integer, Object>(map1);
		    System.out.println("排序后："+sortedMap);
		    System.out.println("排序后："+new TreeMap<Integer, Object>(map2));
		  }

}
