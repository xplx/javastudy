package pers.wxp.tcpIp;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class MyClien extends JFrame { // ������̳�JFrame��
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter writer; // ����PrintWriter�����
	Socket socket; // ����Socket����
	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����
	Container cc; // ����Container����

	public MyClien(String title) { // ���췽��
		super(title); // ���ø���Ĺ��췽��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // ʵ��������

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // ���ı�����ڴ�����²�
		tf.addActionListener(new ActionListener() {
			// ���¼�
			public void actionPerformed(ActionEvent e) {
				// ���ı�������Ϣд����
				writer.println(tf.getText());
				// ���ı�������Ϣ��ʾ���ı�����
				ta.append(tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}

	private void connect() { // �����׽��ַ���
		ta.append("��������\n"); // �ı�������ʾ��Ϣ
		try { // ��׽�쳣
			//socket = new Socket("221.238.131.134", 8082); // ʵ����Socket����
			socket = new Socket("192.168.0.160", 8082); // ʵ����Socket����
			writer = new PrintWriter(socket.getOutputStream(), true);
			ta.append("�������\n"); // �ı�������ʾ��Ϣ
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}

	public static void main(String[] args) { // ������
		MyClien clien = new MyClien("�������������"); // ������������
		clien.setSize(200, 200); // ���ô����С
		clien.setVisible(true); // ��������ʾ
		clien.connect(); // �������ӷ���
	}
}
