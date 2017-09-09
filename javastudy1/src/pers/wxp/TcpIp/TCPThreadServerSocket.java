package pers.wxp.TcpIp;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.ServerSocket;  
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
            //获取服务端输入的消息  
            in = socket.getInputStream();  
            //服务端返回的消息  
            out = socket.getOutputStream();  
            //用一个字节数字来存放消息，提高效率  
            byte[] recData = new byte[1024];  
            in.read(recData);  
            String data = new String(recData);  
  
            System.out.println("读取到客户端发送来的数据：" + data);  
            //返回给客户端的消息  
            out.write("Hello client I am server".getBytes());  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                //关闭资源  
                in.close();  
                out.close();  
                socket.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
}  
  

