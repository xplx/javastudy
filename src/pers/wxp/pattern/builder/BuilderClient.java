package pers.wxp.pattern.builder;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/11 15:51
 */
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();
        Robot robot = director.createRobotByDirecotr(new DanceRobotBuilder());
        System.out.println(robot.getHead());
        System.out.println(robot.getBody());
        System.out.println(robot.getHand());
        System.out.println(robot.getFoot());
        System.out.println("机器人创建成功，恭喜！");
    }
}
