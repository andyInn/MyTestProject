package com.cun.netDB;
//��������ˡ�����
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
/*���� 13-6����Ӧ��10.5�ͻ���СӦ�ó���ķ�������СӦ�ó���
 * �����Զ�4441������ͻ��˵��׽������ӣ����������յ��ͻ��˵������
 * �Կͻ����׽��ֽ���һ���̣߳���������
 * ���û�пͻ����룬����������ͻ������롣
 * �̰߳��ͻ����׽��ֽ�������������in����������out��
 * �߳�����in��ȡ�ͻ�������·�����Ϣ��
 * ������ܵ���Ϣ��"����"�� ��������ظ�"����"��ر��׽������ӣ�
 * ����ظ���"���Ƿ����������˵"���Լ����������յ�����Ϣ��*/

@SuppressWarnings("serial")
public class Socket_ServerThread extends Applet implements Runnable,ActionListener{
    JButton button; JTextField textF; JTextArea textA;
    Socket socket; Thread thread;
    DataInputStream in; DataOutputStream out;
    public void init(){
        setBackground(new Color(120,153,137));
        setLayout(new BorderLayout());
        button = new JButton("������Ϣ");
        textF = new JTextField(20);
        textA = new JTextArea(20,30);
        setSize(450,350);
        JPanel p = new JPanel();
        p.add(textF); p.add(button);
        add(textA,"Center"); add(p,"South");
        button.addActionListener(this);
    }
    public void start(){
        try{
            socket = new Socket(this.getCodeBase().getHost(),4441);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){}
        if(thread==null){
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }
    public void run(){
        String s = null;
        while(true){
             try{
                s = in.readUTF();
            }catch(IOException e){}
            if(s.equals("����")){
                try{
                    socket.close();break;
                }catch(IOException e){}
            }else textA.append(s + "\n");
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            String s = textF.getText();
            if(s!= null){
                try{
                    out.writeUTF(s);
                }catch(IOException e1){}
            }
            else{
                try{
                    out.writeUTF("��˵��");
                }catch(IOException e1){}
            }
       }
    }
}