package pers.wxp.jvm;

public class Test {
    static class Human {
        protected void sayHello() {
            System.out.println("Human say hello");
        }
//        protected void sayHehe() {
//            System.out.println("Human say hehe");
//        }
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Man say hello");
        }

        protected void sayHehe() {
            System.out.println("Man say hehe");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Woman say hello");
        }

        protected void sayHehe() {
            System.out.println("Woman say hehe");
        }
    }

    public static void main(String[] args) {
        Man man = new Man();
        man.sayHehe();
    }
}
