package com.cun.netDB;

//���� 13-2����������������ȡ��ҳ���ݵ�Ӧ�ó��򡣳�������ʱ����ַ���ı����ж�ȡ��

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class GetByURL {
	public static void main(String args[]) {
		new DownNetFile();
	}
}

@SuppressWarnings("serial")
class DownNetFile extends JFrame implements ActionListener {
	JTextField infield = new JTextField(30);
	JTextArea showArea = new JTextArea();
	JButton b = new JButton("download");
	JPanel p = new JPanel();

	DownNetFile() {
		super("read network text file application");
		Container con = this.getContentPane();
		p.add(infield);
		p.add(b);
		JScrollPane jsp = new JScrollPane(showArea);
		b.addActionListener(this);
		con.add(p, "North");
		con.add(jsp, "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		readByURL(infield.getText());
	}

	public void readByURL(String urlName) {
		try {
			URL url = new URL(urlName);// ����ַ����URL����
			URLConnection tc = url.openConnection();// ���URLConnection����
			tc.connect();// ������������
			InputStreamReader in = new InputStreamReader(tc.getInputStream());
			BufferedReader dis = new BufferedReader(in);// ���û���ʽ����
			String inline;
			while ((inline = dis.readLine()) != null) {
				showArea.append(inline + "\n");
			}
			dis.close();// ������Դʹ�ý�������������ʱ�ر�
			/* ����������Դ���ܲ���MalformedURLException��IOException�쳣 */
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}