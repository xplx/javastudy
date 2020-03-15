package pers.wxp.thread;

class Zhangsan{	
	public void say(){
		System.out.println("张三说") ;
	}
	public void get(){
		System.out.println("张三获取") ;
	}
};
class Lisi{	
	public void say(){
		System.out.println("李四说") ;
	}
	public void get(){
		System.out.println("李四说") ;
	}
};
public class ThreadDeadLock implements Runnable{
	private static Zhangsan zs = new Zhangsan() ;		
	private static Lisi ls = new Lisi() ;		
	private boolean flag = false ;	
	public void run(){	
		if(flag){
			synchronized(zs){	
				zs.say() ;
				try{
					Thread.sleep(500) ;
				}catch(InterruptedException e){
					e.printStackTrace() ;
				}
				synchronized(ls){
					zs.get() ;
				}
			}
		}else{
			synchronized(ls){
				ls.say() ;
				try{
					Thread.sleep(500) ;
				}catch(InterruptedException e){
					e.printStackTrace() ;
				}
				synchronized(zs){
					ls.get() ;
				}
			}
		}
	}
	public static void main(String args[]){
		ThreadDeadLock t1 = new ThreadDeadLock() ;		
		ThreadDeadLock t2 = new ThreadDeadLock() ;		
		t1.flag = true ;
		t2.flag = false ;
		Thread thA = new Thread(t1) ;
		Thread thB = new Thread(t2) ;
		thA.start() ;
		thB.start() ;
	}
};