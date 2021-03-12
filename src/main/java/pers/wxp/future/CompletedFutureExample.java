package pers.wxp.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * @author wxp
 * @date 2020-11-24
 */
public class CompletedFutureExample {
    /**
     * 最简单的例子就是使用一个预定义的结果创建一个完成的CompletableFuture,
     * 通常我们会在计算的开始阶段使用它。
     */
    static void completedFutureExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
        System.out.println(cf.getNow(null));
    }

    /**
     * CompletableFuture的方法如果以Async结尾,
     * 它会异步的执行(没有指定executor的情况下)， 异步执行通过ForkJoinPool实现，
     * 它使用守护线程去执行任务。注意这是CompletableFuture的特性，
     * 其它CompletionStage可以override这个默认的行为。
     */
    static void runAsyncExample() throws InterruptedException {
        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        assertFalse(cf.isDone());
        System.out.println("开始时间");
        Thread.sleep(10000);
        assertTrue(cf.isDone());
        System.out.println("完成时间");
    }

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

    /**
     * 主动触发计算
     * @throws InterruptedException
     */
    public static void autoCompute() throws InterruptedException {
        final CompletableFuture<Integer> f = compute();
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }

            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        //设置Future.get()获取到的值
        f.complete(100);
        //以异常的形式触发计算
        //f.completeExceptionally(new Exception());
        Thread.sleep(1000);
    }

    /**
     * Apply函数应用另一个函数并传递一个持有值的future
     *
     * Accept函数使用此值并返回void
     */
    public static void applyAccept(){
        CompletableFuture.completedFuture("FUTURE")
                .thenApply(r -> r.toLowerCase())
                .thenAccept(f -> System.out.println(f))
                .thenAccept(f -> System.out.println(f))
                .thenApply(f -> new String("FUTURE"))
                .thenAccept(f -> System.out.println(f))
                .thenAccept(f -> System.out.println(f));
    }

    public static void main(String[] args) {
        try {
            applyAccept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
