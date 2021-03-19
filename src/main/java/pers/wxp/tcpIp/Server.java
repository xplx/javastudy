package pers.wxp.tcpIp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 4.��socketͨѶд������ͻ��˺�һ���������˵�ͨѶ��
 * Ҫ��ͻ��������ݺ��ܹ�������ͬ�����ݣ����Թ��ܣ���ʵ��TCP��ʽ����
 */
public class Server {

	// �����
	public static void main(String[] args) throws IOException {
		scoketServer();
	}

	// ������tcp8888�����˿�
	public static void scoketServer() throws IOException {
		ServerSocket server = new ServerSocket(8082);
		while (true) {
			// δ��ͨǰ�߳���������ͨ����һ��socketͨ���̺߳��������8888�˿�
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress().getHostAddress() + "���ӽ���");
			new SocketThread(socket).start();
		}
	}

}

// һ���������˿��м�������ͷ���ͨ���߳�
class SocketThread extends Thread {
	// ����ͨ��д�����ļ���
	private static List<PrintWriter> list = new ArrayList<PrintWriter>();

	private BufferedReader bufferedReader;
	private PrintWriter printWriter;

	public SocketThread(Socket socket) throws IOException {
		this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.printWriter = new PrintWriter(socket.getOutputStream());
		list.add(printWriter);
	}

	@Override
	public void run() {
		String string = null;
		while (true) {
			try {
				// ��������ͨ���ж�������Ϣ���Ը��ͷ���
				String receivBuf = bufferedReader.readLine();
				System.out.println("�ͷ�����Ϣ��" + string);
				for (PrintWriter printWriter : list) {
					printWriter.write("���������ԣ�" + string + "\r\n");
					printWriter.flush();
				}
			} catch (IOException e) {

			}
		}

	}
}
