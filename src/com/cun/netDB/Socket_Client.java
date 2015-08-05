package com.cun.netDB;

/*���� 13-3��C/Sģʽ�е�Client��Ӧ�ó�������һ��Client�˵���ʽSocketͨ�ŵļ�ʵ����
 ����˵��Client�˳���ı�д���������У�Client����������������Ķ˿�4441�������
 ���ӽ�������ɶԷ������Ķ�д��*/
import java.io.*;
import java.net.*;

public class Socket_Client {
	public static void main(String args[]) {
		String s = null;
		Socket mySocket;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			mySocket = new Socket("localhost", 4441);
			in = new DataInputStream(mySocket.getInputStream());
			out = new DataOutputStream(mySocket.getOutputStream());
			out.writeUTF("good server!");
			while (true) {
				s = in.readUTF();
				if (s == null)
					break;
				else
					System.out.println(s);
			}
			mySocket.close();
		} catch (IOException e) {
			System.out.println("can��t connect");
		}
	}
}
