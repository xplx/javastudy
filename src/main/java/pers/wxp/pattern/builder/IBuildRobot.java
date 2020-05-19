package pers.wxp.pattern.builder;

/**
 * @author wuxiaopeng
 * @description:接下来定义一个造机器人的标准。一个把头、身体、手、脚造出来的标准。
 * @date 2020/5/11 15:49
 */
public interface IBuildRobot {
    public void buildHead();

    public void buildBody();

    public void buildHand();

    public void buildFoot();

    public Robot createRobot();
}
