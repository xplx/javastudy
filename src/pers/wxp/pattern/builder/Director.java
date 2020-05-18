package pers.wxp.pattern.builder;

/**
 * @author wuxiaopeng
 * @description:指挥官Director
 * @date 2020/5/11 15:50
 */
public class Director {
    public Robot createRobotByDirecotr(IBuildRobot ibr) {
        ibr.buildBody();
        ibr.buildFoot();
        ibr.buildHand();
        ibr.buildHead();
        return ibr.createRobot();
    }
}
