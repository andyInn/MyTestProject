package jiuDuOJ;

/**
 * ��ͨ������еľֲ�����
 * @author zendao
 */
public class CodeBlock {

    public static void main(String args[]) {

        int x = 100;
        String str=null;
        {
            //  ��ͨ�����
            x = 30;
            str="�Ұ��㡫";
            System.out.println("in str="+str);
            System.out.println("in x="+x);
        }
        System.out.println("out str="+str);
        System.out.println("out x="+x);
    }
}