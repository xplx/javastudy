package pers.wxp.tcpIp;

import java.io.*;
import java.net.*;

public class MyTcp { // ������MyTcp
	private BufferedReader reader; // ����BufferedReader����
	private ServerSocket server; // ����ServerSocket����
	private Socket socket; // ����Socket����socket




	void getserver() {
		try {
			server = new ServerSocket(8082); // ʵ����Socket����
			SocketAddress clientAddress = socket.getRemoteSocketAddress();
			System.out.println("Handling client at " + clientAddress);
			System.out.println("�������׽����Ѿ������ɹ�"); // �����Ϣ
			while (true) { // ����׽���������״̬
				System.out.println("�ȴ��ͻ���������"); // �����Ϣ
				socket = server.accept(); // ʵ����Socket����
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ʵ����BufferedReader����
				getClientMessage(); // ����getClientMessage()����
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}

	private void getClientMessage() {
		try {
			while (true) { // ����׽���������״̬
				if (reader.ready()) {
					// ��ÿͻ�����Ϣ
					System.out.println("�ͻ���:" + reader.readLine());
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		try {
			if (reader != null) {
				reader.close(); // �ر���
			}
			if (socket != null) {
				socket.close(); // �ر��׽���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // ������
		MyTcp tcp = new MyTcp(); // �����������
		tcp.getserver(); // ���÷���
		//tcp.getClientMessage();
	}
}
