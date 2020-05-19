package pers.wxp.pattern.proxyI.CglibProxyl;

/**
 * @author wuxiaopeng
 * @description:目标对象,没有实现任何接口
 * @date 2020/3/20 11:10
 */
public class UserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
