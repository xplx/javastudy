package pers.wxp.thread.call;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wuxiaopeng
 * @description: 创建实现Callable接口的类myCallable
 * Runnable 接口 run 方法无返回值；Callable 接口 call 方法有返回值，
 * 是个泛型，和Future、FutureTask配合可以用来获取异步执行的结果。
 * Runnable 接口 run 方法只能抛出运行时异常，且无法捕获处理；
 * Callable 接口 call 方法允许抛出异常，可以获取异常信息。
 * 所以说 Callable用于产生结果，
 * Future 用于获取结果。
 * @date 2020/3/16 14:03
 */
public class CallableTest implements Callable<Integer> {

    /**
     * 创建实现Callable接口的类myCallable
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
        return 1;
    }

    public static void main(String[] args) {
        //以myCallable为参数创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableTest());
        //将FutureTask作为参数创建Thread对象
        Thread thread = new Thread(futureTask);
        //调用线程对象的start()方法
        thread.start();
        try {
            Thread.sleep(1000);
            System.out.println("返回结果 " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "方法执行完成");
    }
}
