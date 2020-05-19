package pers.wxp.thread.security;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/17 14:44
 */
public class AccountOperator implements Runnable {
    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        //指定要给某个对象加锁
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}
