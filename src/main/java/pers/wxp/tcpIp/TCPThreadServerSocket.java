package pers.wxp.tcpIp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class TCPThreadServerSocket implements Runnable {
    private Socket socket = null;
    private InputStream in = null;
    private OutputStream out = null;
    public TCPThreadServerSocket(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            //��ȡ������������Ϣ
            in = socket.getInputStream();
            //����˷��ص���Ϣ
            out = socket.getOutputStream();
            //��һ���ֽ������������Ϣ�����Ч��
            byte[] recData = new byte[1024];
            in.read(recData);
            String data = new String(recData);

            System.out.println("��ȡ���ͻ��˷����������ݣ�" + data);
            //���ظ��ͻ��˵���Ϣ
            out.write("Hello client I am server".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //�ر���Դ
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


