package pers.wxp.thread;

import java.util.Random;

/**
 * @author wxp
 * @date 2018年1月24日 下午2:49:24
 * @Description: TODO(线程局部变量(ThreadLocal)其实的功用非常简单，就是为每一个使用该变量的线程都提供一个变量值的副本，是Java中一种较为特殊的线程绑定机制，是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突)
 */
public class ThreadLocalDemo  implements Runnable{
	 //创建线程局部变量studentLocal，在后面你会发现用来保存Student对象
    private final static ThreadLocal studentLocal = new ThreadLocal();
 
    public static void main(String[] agrs) {
        ThreadLocalDemo td = new ThreadLocalDemo();
        Thread t1 = new Thread(td, "a");
        Thread t2 = new Thread(td, "b");
        t1.start();
        t2.start();
        //可以看到a、b两个线程age在不同时刻打印的值是完全相同的。这个程序通过妙用ThreadLocal，既实现多线程并发，游兼顾数据的安全性。
    }
 
    public void run() {
        accessStudent();
    }
 
    /**
     * 示例业务方法，用来测试
     */
    public void accessStudent() {
        //获取当前线程的名字
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");
        //产生一个随机数并打印
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentThreadName + " set age to:" + age);
        //获取一个Student对象，并将随机数年龄插入到对象属性中
        Student student = getStudent();
        student.setAge(age);
        System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
    }
 
    protected Student getStudent() {
        //获取本地线程变量并强制转换为Student类型
        Student student = (Student) studentLocal.get();
        //线程首次执行此方法的时候，studentLocal.get()肯定为null
        if (student == null) {
            //创建一个Student对象，并保存到本地线程变量studentLocal中
            student = new Student();
            studentLocal.set(student);
        }
        return student;
    }
}

class Student {
	private int age = 0; // 年龄

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
