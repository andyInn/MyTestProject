package com.cun.netDB;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

/*���� 13-9��JavaӦ�ó���������ݿ⡣Ӧ�ó���򿪿�����Ϣ��ksInfo������ȡ�������ĸ�����Ϣ��
 * �迼����Ϣ���ݿ�Ľṹ���£�
����		�ַ���	�ַ���	����		�ַ���	�ַ���
�ֶ���	����		����		�ɼ�		��ַ		����

public class Demo_ReadDB extends JFrame implements ActionListener{
    public static Connection connectByJdbcodbc(String url, String username,String password){
        Connection con = null;
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //����ODBC��������
        }
        catch (Exception e){
            e.printStackTrace();
            return null; //����ʧ�ܣ����Ӳ��ɹ�
        }
        try{
            con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null; //����ʧ��
        }
        return con; //���ӳɹ�
    }
    String title[] ={"����", "����", "�ɼ�", "��ַ", "����"};
    JTextField txtNo = new JTextField(8);
    JTextField txtName = new JTextField(10);
    JTextField txtScore = new JTextField(3);
    JTextField txtAddr = new JTextField(30);
    JTextArea txtresume = new JTextArea();
    JButton prev = new JButton("ǰһ��");
    JButton next = new JButton("��һ��");
    JButton first = new JButton("��һ��");
    JButton last = new JButton("���һ��");
    Statement sql; //SQL������
    ResultSet rs; //��Ų�ѯ�������
    Demo_ReadDB(Connection connect){
        super("������Ϣ�鿴����");
        setSize(450, 350);
        try{
            sql = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM ksInfo");
            Container con = getContentPane();
            con.setLayout(new BorderLayout(0, 6));
            JPanel p[] = new JPanel[4];
            for (int i = 0; i < 4; i++){
                p[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
                p[i].add(new JLabel(title[i]));
            }
            p[0].add(txtNo);
            p[1].add(txtName);
            p[2].add(txtScore);
            p[3].add(txtAddr);
            JPanel p1 = new JPane(new GridLayout94, 1, 0, 8);
            JScrollPane jsp = new JScrollPane(txtResume,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                jsp.setPreforredSize(new Dimension(300, 60);
            for (int i = 0; i < 4; i++){
                p1.add(p[i]);
            }
            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0);
            p2.add(new JLabel(title[4]));
            p2.add(jsp);
            Jpanel p3 = new Jpanel();
            p3.add(prev);
            p3.add(next);
            p3.add(first);
            p3.add(last);
            prev.addActionListener(this);
            next.addActionListener(this);
            first.addActionListener(this);
            last.addActionlistener(this);
            rs.first();
            readRecord();
        }
        catch (Exception e){
            e.printStackTrace():
        }
        setVisible(ture);
    }
    public void modifyRecord(Connection connect){
        String stuNo = (String)JOptionPane.showInputDialog(null,
            "�����뿼������", "���뿼�ŶԻ���", JOptionPane.PLAIN_MESSAGE, null,
            null, "");
        try {
            sql = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM ksInfo");
            Container con = getContentPane();
            con.setLayout(new Boarderlayout(0, 6));
            Jpanel p[] = new JPanel[4];
            for (int i = 0; i < ; i++){
                p[i] = new JPane(new FlowLayout(flowLayout.LEFT, 8, 0));
                p[i].add(new JLabel(title[i]));
            }
            p[0].add(txtNo);
            p[1].add(txtName);
            p[2].add(txtScore);
            p[3].add(txtAddr);
            Jpanel p1 = new Jpane(new GridLayout(4, 1, 0, 8));
            JScrollPane jsp = new JScrollPane(txtResume,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jsp.setPreferredSize (new dimension(300, 60));
            for (int i = 0; i < 4; i++){
                p1.add(p[i]);
            }
            Jpanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
            p2.add(new JLableI(title[4]));
            p2.add(jsp);
            JPanel p3 = new JPanel();
            p3.add(prev);
            p3.add(next);
            p3.add(first);
            p3.add(last);
            prev.addActionListener(this);
            next.addActionListener(this);
            first.addActionListenerIthis);
            last.addActionListener(this);
            rs.first();
            readRecord();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    boolean readRecord(){
        try{
            txtNo.setText(rs.getString("����")); txtName.setText(rs.getString("����")); txtScore.setText(rs.getString("�ɼ�"));
            txtAddr.setText(rs.getString("��ַ")); txtResume.setText(rs.getString("����"));
        }
        catch (SQLException e){
            e.printStackTrace(); return false;
        }
        return true;
    }
    public void actionPerformed(ActionEvent e){
        try{
            if (e.getSource() == prev)rs.previous();
            else if (e.getSource() == next)rs.next();
            else if (e.getSource() == first)rs.first();
            else if (e.getSource() == last)rs.last(); readRecord();
        }
        catch (Exception e2){}
    }
    public static void main(String args[]){
        Connection connect = null;
        JFrame .setDefaultLookAndFeeDecorated(true);
        Font font = new Font("JFrame", Font.PLAIN, 14);
        if ((connect =connectByJdbcOdbc("jdbc:odbc:redsun", "xia", "1234")) == null){
            JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��!");
            System.exit ( - 1);
        }
        new Demo_ReadDB(connect); //��������
    }
}*/