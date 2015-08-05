package com.cun.learn.merge;

import java.io.BufferedReader;   

/**  
 *   
 * �ļ���Ϣ  
 * http://blog.csdn.net/gameover8080/article/details/7054248
 * ��·�鲢���� ������ ���ļ����� javaʵ��
 * @author Andy
 *  
 * @version $Id: FileInfo.java, v 0.1 2009-8-1 ����02:11:30 Exp $  
 */  
public class FileInfo {   
  
    /**  
     * �ļ���  
     */  
    private int            fileNum;   
  
    /**  
     * ��ǰ�к�  
     */  
    private int            lineNum = 0;   
  
    /**  
     * ��ǰֵ  
     */  
    private String         value;   
  
    /**  
     * BufferedReader����  
     */  
    private BufferedReader bufferedReader;   
  
    public boolean readNextValue() throws Exception {   
        String value;   
        if ((value = this.bufferedReader.readLine()) != null) {   
            this.value = value;   
            this.lineNum++;   
            return true;   
        } else {   
            this.bufferedReader.close();   
            return false;   
        }   
    }   
  
    public int getFileNum() {   
        return fileNum;   
    }   
  
    public void setFileNum(int fileNum) {   
        this.fileNum = fileNum;   
    }   
  
    public int getLineNum() {   
        return lineNum;   
    }   
  
    public void setLineNum(int lineNum) {   
        this.lineNum = lineNum;   
    }   
  
    public String getValue() {   
        return value;   
    }   
  
    public void setValue(String value) {   
        this.value = value;   
    }   
  
    public BufferedReader getReader() {   
        return bufferedReader;   
    }   
  
    public void setReader(BufferedReader reader) {   
        this.bufferedReader = reader;   
    }   
} 