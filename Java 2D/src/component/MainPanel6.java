package component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// �׷��� ��ġ ������ �� ��
//----------------------------------------------------------------------------------

// �� ���� �ؽ�Ʈ�ʵ�� ��ư ���� �г��� ��� �ִ� Ŭ����
class MyPanel4 extends JPanel{

    JTextField a,b,c;
    double A,B,C;
    JButton button;

    public MyPanel4()
    {
        this.setBounds(0,0,500,100);
        a=new JTextField("1.0",10);
        b=new JTextField("-5.0",10);
        c=new JTextField("6.0",10);
        add(a);
        add(b);
        add(c);
        button=new JButton("DRAW");
        add(button);
    } 
    Double getA(){A=Double.parseDouble(a.getText()); return A;} // 6. �� Ŭ���� ������ A,B,C ���� ������ ����
    Double getB(){B=Double.parseDouble(b.getText()); return B;} // �� ���� ���� return �� �ִ� �޼ҵ���� ����
    Double getC(){C=Double.parseDouble(c.getText()); return C;} // a.getText()�� a �ȿ� ����ִ� ���� �������� ��
                                                                // Double.parseDouble�� �� ���� Double������ ��ȯ
}

// �������� ��� �ִ� Ŭ���� 
public class MainPanel6 extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    MyPanel4 myPanel4=new MyPanel4();       // 1. �����ӿ��� �ؽ�Ʈ �ʵ� �г� ����
    DrawPanel drawPanel=new DrawPanel();    // 2. �����ӿ��� �׷��� �г� ����
    
    public MainPanel6()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(myPanel4);
        this.add(drawPanel);
        myPanel4.button.addActionListener(this);    // 3. �ؽ�Ʈ �ʵ� �гο� �ִ� draw �г� ��ư�� ���� �� actionListener�� ����
        this.setSize(500,400);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainPanel6();
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // 4. ��ư ������ ����Ǵ� ��ɾ�
        // TODO Auto-generated method stub
        drawPanel.setABC(myPanel4.getA(),myPanel4.getB(),myPanel4.getC());  // 5. �׷��� �гο� A, B, C ���� �־��ִ� �޼ҵ�
        drawPanel.setRepaint();     // 8. �׷����� �׸��� �гο��� �ٽñ׷��ִ�(repaint)�� ��������ִ� �޼ҵ�
    }
    
    
}

// �׷����� �׸��� �г��� ����ִ� Ŭ����
class DrawPanel extends JPanel
    {
        Double A=0.0 ,B=0.0 ,C=0.0 ;
        JPanel test=new JPanel();
        void setRepaint()   // 9. �ٽ� �׷��ִ� repaint �޼ҵ�
        {
            repaint();
        }
        public DrawPanel()
        {
            this.setBounds(0,100,500,300);
        }
        void setABC(Double A, Double B, Double C)   // 7. �ؽ�Ʈ �ʵ� �г� Ŭ������ �ִ� A,B,C�� �ٸ� Ŭ�����̹Ƿ�
        {                                           // ������ �Ұ��ؼ� �ؽ�Ʈ �ʵ� Ŭ������ �ִ� ���� �޾Ƽ�
            this.A=A;                               // �̰����� �־��ְ� ��
            this.B=B;
            this.C=C;
        }
        @Override
        public void paintComponent(Graphics g) {    // 10. repaint()�� ���� �Ǵ� �޼ҵ�
            // TODO Auto-generated method stub
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D) g;
            g2.drawLine(0,200,400,200);
            g2.drawLine(200,0,200,400);
            g2.setPaint(Color.red);
            for(int i=-200; i<200; i++)
            {
                int x=i;
                int y= (int)(A * x * x + B*x + C);
                g2.fillOval(200+x-2, 200-(y-2), 4,4);
            }
        }
    }