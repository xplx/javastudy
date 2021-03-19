package pers.wxp.tcpIp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadServer {
    private static final int PORT = 8082;

    public static void main(String[] args) {
        int count = 1;
        try {
            /**
             * ����һ��ServerSocket���󣬲������ƶ�һ���˿ںţ�
             * ͨ������˿ں��������ͻ��˵����ӣ�����˽��ܿͻ������ӵ�������
             * ����ϵؽ��ܵģ����Է���˵ı��һ�㶼������ֹ������
             */
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("�������Ѿ�����������");
            while (true) {
                /**
                 * �ڷ���˵���accept()�������ܿͻ��˵����Ӷ���accept()������
                 * һ������ʽ�ķ�����һֱɵɵ�صȴ����Ƿ��пͻ�����������
                 */

                Socket s = ss.accept();
                System.out.println("��" + count + "������,IP��ַ�ǣ�"
                        + s.getInetAddress());
                count++;
                /**
                 * �����ʹ�ö��̷߳����ͻ��˵�����
                 * ���ｫ����˵�socket�����ڲ��࣬����ÿ���ͻ��˶�����һ���߳�
                 */
                Thread t = new Thread(new TCPThreadServerSocket(s));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
