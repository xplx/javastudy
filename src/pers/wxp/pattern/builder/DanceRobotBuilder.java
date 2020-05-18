package pers.wxp.pattern.builder;

/**
 * @author wuxiaopeng
 * @description:现在机器人的模型和创建标准都有了，让我们来实现一个会跳舞的机器人
 * @date 2020/5/11 15:49
 */
public class DanceRobotBuilder implements IBuildRobot {
    Robot robot;

    public DanceRobotBuilder() {
        robot = new Robot();
    }

    @Override
    public void buildHead() {
        robot.setHead("写入机械舞程序");
    }

    @Override
    public void buildBody() {
        robot.setBody("钛合金身体");
    }

    @Override
    public void buildHand() {
        robot.setHand("钛合金手");
    }

    @Override
    public void buildFoot() {
        robot.setFoot("钛合金脚");
    }

    @Override
    public Robot createRobot() {
        return robot;
    }

}
