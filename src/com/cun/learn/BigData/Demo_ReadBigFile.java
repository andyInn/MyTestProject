package com.cun.learn.BigData;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * java��ȡ���ļ�1G+
 * 
 * @author Andy
 * @date 20150311
 */
/**
 *  ������ȡ���ļ������ܻ��뵽�û���
 *  �����FileInputStream��BufferedInputStream��һ�������˻����Ż����������������������
 * @author Andy
 */

public class Demo_ReadBigFile {

	public static void readBigFile(String path) {
		BigInteger sum;
		try {
			File file = new File(path);
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 5 * 1024 * 1024);// ��5M�Ļ����ȡ�ı��ļ�

			String line = "";
			sum = BigInteger.ZERO;
			while ((line = reader.readLine()) != null) {
				sum = sum.add(BigInteger.ONE);

			}

			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		readBigFile("D:\\test.txt");
	}

}