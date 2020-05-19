package pers.wxp.pattern.proxyI.staticProxy;

/**
 * @author wuxiaopeng
 * @description: 接口实现类，目标对象
 * @date 2020/3/20 10:41
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
