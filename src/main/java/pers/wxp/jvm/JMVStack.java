package pers.wxp.jvm;

/**
 * @author lenovo
 * @date 2020-11-04
 * @Java虚拟机的栈：Java虚拟机栈存储栈帧(Frame)。 每个被调用的方法就会产生一个栈帧，
 * 栈帧中保存了一个方法的状态信息，如：局部变量，操作栈帧，方出出口等。
 */
public class JMVStack {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        test();
    }
}
