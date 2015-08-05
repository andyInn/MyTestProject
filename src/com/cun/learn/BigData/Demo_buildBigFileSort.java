package com.cun.learn.BigData;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * �ⲿ���� ָ���Ǵ��ļ������򣬼�������ļ�¼�洢����洢���ϣ���������ļ��޷�һ��װ���ڴ棬
 * ��Ҫ���ڴ���ⲿ�洢��֮����ж�����ݽ������Դﵽ���������ļ���Ŀ�ġ�ѡ�԰ٶȰٿơ�
 * �˳��������ȷִ��
 * @author Andy
 */

public class Demo_buildBigFileSort {

	public static void main(String[] args) throws IOException {
		String strSource = "D:/TEMP/quickSort/test.txt";
		// ��һ���� ����������������һ����ŵ��ļ���
		File fileSource = new File(strSource);
		Demo_buildBigFileSort.buildBigFile(strSource);
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader fr = new BufferedReader(inputStreamReader);// Դ�����ļ���ȡ��

		final int SIZE = 10000;// �����Ƕ������ǽ�Դ�ļ�������������10000����¼��Ϊ��λ���зָ���ָ��ÿ���ļ��а���10000����¼��
		int[] linesSplit = new int[SIZE];// ��ʱ��ŷָ�ʱ�ļ�¼
		List<String> fileNames = new ArrayList<String>();// �������зָ��ļ�������
		int index = 0;
		while (true) {
			String lineRead = fr.readLine();// ��ԭ�ļ��ж�ȡһ����¼
			if (lineRead == null) {// �����ȡ��Ϻ󣬽���һ�����򲢱���
				fileNames.add(sortAndSave(linesSplit, index));
				break;
			}
			linesSplit[index] = Integer.valueOf(lineRead);
			index++;
			if (index == SIZE) {// ��nums����������ֵ��ﳤ�ȱ߽�ʱ�����򣬴洢
				fileNames.add(sortAndSave(linesSplit, index));// sortAndSave�ǽ�nums��ǰindex����¼�ȿ�������Ȼ������ļ�����ý��ļ������ء�
				index = 0;// ����index
			}
		}
		fr.close();
		mergeSort(fileNames);// ������fileNames���ļ����кϲ�
	}

	// ��һ���� ����������������һ����ŵ��ļ���
	public static void buildBigFile(String strSource) {
		File file = new File(strSource);
		int numCount = 100000;
		Random r = new Random();
		if (file.exists())
			file.delete();

		try {
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < numCount; i++) {
				fw.write(r.nextInt() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// sortAndSave�ǽ�linesSplit��ǰindex����¼�ȿ�������Ȼ������ļ�����ý��ļ�������
	public static String sortAndSave(int[] linesSplit, int size) throws IOException {
		QuickSort.quickSortIni(linesSplit, 0, size - 1);
		String fileName = "D:/TEMP/quickSort/sort/sort" + System.nanoTime() + ".txt";
		File rf = new File(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(rf));
		for (int i = 0; i < linesSplit.length; i++)
			bw.write(linesSplit[i] + "\n");
		bw.close();
		return fileName;
	}

	public static void mergeSort(List<String> fileNames) throws IOException {
		List<String> tempFileNames = new ArrayList<String>();
		for (int i = 0; i < fileNames.size(); i++) {
			//����for������������һ��������ÿ�ν���������List�ϲ�������֤�������
			//�������������������򵥣�����isFirst��firstNext����������֤��һ��ѭ�����Ժ�����List�ĸ���ȡ�����ݵ���ȷִ�С�
			String resultFileName = "D:/TEMP/quickSort/result/result" + System.nanoTime() + ".txt";
			File resultFile = new File(resultFileName);
			tempFileNames.add(resultFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));

			File file1 = new File(fileNames.get(i++));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			if (i < fileNames.size()) {//��֤i����Խ��,��������ļ�δ����������if��
				File file2 = new File(fileNames.get(i));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				int num1 = 0;
				int num2 = 0;
				boolean isFirst = true;
				boolean firstNext = true;
				String numVal1 = null, numVal2 = null;
				while (true) {//����������List�ϲ�������֤�������
					if (isFirst) {
						numVal1 = br1.readLine();
						numVal2 = br2.readLine();
						num1 = Integer.valueOf(numVal1);
						num2 = Integer.valueOf(numVal2);
						isFirst = false;
					} else if (firstNext)
						numVal1 = br1.readLine();
					else
						numVal2 = br2.readLine();
					if (numVal1 != null && numVal2 != null) {
						if (firstNext) {
							num1 = Integer.valueOf(numVal1);
						} else {
							num2 = Integer.valueOf(numVal2);
						}
						if (num1 < num2) {
							bw.write(num1 + "\n");
							firstNext = true;
						} else {
							bw.write(num2 + "\n");
							firstNext = false;
						}
					} else {
						if (numVal1 != null)
							bw.write(numVal1 + "\n");
						if (numVal2 != null)
							bw.write(numVal2 + "\n");
						break;
					}
				}// while
				
				while (true) {
					//��ʣ�����������׷�ӵ�����ļ���
					numVal2 = br2.readLine();
					if (numVal2 != null)
						bw.write(numVal2 + "\n");
					else
						break;
				}// while
				br2.close();
				file2.delete();
			}//if (i < fileNames.size())
			
			while (true) {//���ֻʣ���һ����ֻ����һ���ļ�����ô��ʣ�����������׷�ӵ�����ļ���ȥ��
				String numVal1 = br1.readLine();
				if (numVal1 != null) {
					bw.write(numVal1 + "\n");
				} else
					break;
			}//while
			br1.close();
			file1.delete();
			bw.close();
		}//for (int i = 0; i < fileNames.size(); i++)
		int size = tempFileNames.size();
		if (size > 1) {//�ݹ�ؽ�����ļ��ϲ�
			mergeSort(tempFileNames);
		} else if (size == 1) {//�ݹ���������
			File file = new File(tempFileNames.get(0));
			file.renameTo(new File("D:/TEMP/quickSort/result.txt"));
		}
	}//mergeSort
}

// ��������
class QuickSort {

	public int[] data;

	public QuickSort() {
	}

	// ���ﱾ�������ù��캯���������Ҫд�ɾ�̬����ȥ��quickSort
	public static void quickSortIni(int data[], int low, int high) {
		QuickSort qs = new QuickSort();
		qs.data = data;
		qs.quickSort(low, high);
	}

	// Step1,�ݹ�ؽ��п���
	private void quickSort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			quickSort(low, result - 1);
			quickSort(result + 1, hight);
		}
	}

	// Step2
	private int partition(int sortArray[], int low, int hight) {
		int key = sortArray[low];
		while (low < hight) {
			while (low < hight && sortArray[hight] >= key)
				hight--;
			sortArray[low] = sortArray[hight];
			while (low < hight && sortArray[low] <= key)
				low++;
			sortArray[hight] = sortArray[low];
		}
		sortArray[low] = key;
		return low;
	}

	// ��ӡ��ǰ��������
	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}