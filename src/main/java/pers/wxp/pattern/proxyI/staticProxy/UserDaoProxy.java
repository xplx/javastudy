package pers.wxp.pattern.proxyI.staticProxy;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/20 10:43
 */
public class UserDaoProxy implements IUserDao {
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
