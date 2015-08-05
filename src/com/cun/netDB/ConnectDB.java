package com.cun.netDB;

import java.sql.Connection;
import java.sql.SQLException;
/*���� 13-8��˵�������ݿ����ӵľ�̬����connectByJdbc()��
 * �÷��������������ݿ�URL���û����������������ݿ⣬
 * ������ӳɹ�����������true�����Ӳ��ɹ����򷵻�false��*/
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) {
		//
	}

	public static Connection conectByJdbc(String url, String username,	String password) {

		Connection con = null;
		try {
			Class.forName( // �����ض�����������
			"com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
			return null; // ����ʧ��
		}
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // ����ʧ��
		}
		return con; // ���ӳɹ�
	}
}