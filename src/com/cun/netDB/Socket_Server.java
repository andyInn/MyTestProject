package com.cun.netDB;

/*���� 13-4������10.3 Client��Ӧ�ó����Ӧ��Server��Ӧ�ó���
 * ������4441�˿ڼ���������⵽�пͻ�������ʱ��
 * ����һ����Ϊ"�ͻ�����ã����Ƿ�����"���ַ���������ͻ��ˡ�*/
import java.io.*;
import java.net.*;

public class Socket_Server {
	public static void main(String args[]) {
		ServerSocket server = null;
		Socket you = null;
		String s = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			server = new ServerSocket(4441);
		} catch (IOException e1) {
			System.out.println("ERROR:" + e1);
		}
		try {
			you = server.accept();
			in = new DataInputStream(you.getInputStream());
			out = new DataOutputStream(you.getOutputStream());
			while (true) {
				s = in.readUTF();
				if (s != null)
					break;
			}
			out.writeUTF("�ͻ�����ã����Ƿ�����");
			out.close();
		} catch (IOException e) {
			System.out.println("ERROR:" + e);
		}
	}
}