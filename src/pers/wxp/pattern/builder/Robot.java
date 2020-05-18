package pers.wxp.pattern.builder;

/**
 * @author wuxiaopeng
 * @description:这就是机器人模型，有头，有身体，有手，有脚。机器人都是由这个模型出来的。
 * @date 2020/5/11 15:48
 */
public class Robot {
    private String head;
    private String body;
    private String hand;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
