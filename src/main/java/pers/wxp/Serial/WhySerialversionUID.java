package pers.wxp.Serial;

import java.io.*;

/**
 * @author wuxiaopeng
 * @create 2018-06-01 20:37
 **/

public class WhySerialversionUID {
    public static void main(String[] args) throws Exception {
        //读写进入磁盘
//        Person person= new Person();
//        person.setUserName("jack");
//        ObjectOutputStream oo = new ObjectOutputStream  (new FileOutputStream(new File("D://jack.test")));
//        oo.writeObject(person);
//        oo.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D://jack.test")));
        Person person = (Person) ois.readObject();
        String name = person.getUserName();
        System.out.println("name is: " + name);
    }
}