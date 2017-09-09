package com.daoben.rfid.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;
import org.springframework.stereotype.Service;

@Service
public class SocketSend {
	private final String IP = "192.168.0.84";
	private final int PORT = 2001;

	public void send() {
		Socket socket = null;
		int warn = 1;
		try {
			socket.setSoTimeout(50000);
			socket = new Socket(IP, PORT);			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			//out.writeUTF("0x01");
			out.writeByte(warn);
			out.close();
			input.close();
		} catch (Exception e) {
			System.out.println("报警信息发送异常:" + e.getMessage());
		}
		finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					socket = null;
					System.out.println("关闭数据异常:" + e.getMessage());
				}
			}
		}
	}

	@Test
	public void sendTest() {
		send();
	}
}
