package component;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class csds extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private Timer timer;
    private int x1, y1;
    private final int START_X=0, START_Y=250;
    private final int WIDTH=500, HEIGHT=300;
    private int moveSection=0;
    private boolean xUp=true, yUp=true;

    public csds()
    {
        //�̹��� ������ �о image ��ü�� ����
        // 20ms ���� �̺�Ʈ�� �߻���Ű�� timer ��ü�� �����ϰ� timer�� start ��Ŵ
        File file=new File("spaceShip1.png");
        try{
                image = ImageIO.read(file);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(1);
            }

        x1=START_X;
        y1=START_Y;
        timer =new Timer(20, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        // x,y��ǥ�� �̹����� �׸���.
            g.drawImage(image,x1,y1,this);
            System.out.println(x1 + ", " + y1);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // x,y ��ǥ ����

        // if(y1<20 && xUp==true)
        // {
        //     x1+=1;  xUp=true;
        //     y1+=1;  yUp=false;
        // }
        // else if(y1>150)
        // {
        //     x1+=1;  xUp=true;
        //     y1-=1;  yUp=true;
        // }
        // else if(x1>430)
        // {
        //     x1-=1;  xUp=false;
        //     y1-=1;  yUp=true;
        // }
        // // else if(y1<20)
        // // {
        // //     x1-=1;  xUp=false;
        // //     y1+=1;  yUp=false;
        // // }
        // else
        // {
        //     x1+=1;  
        //     y1-=1;  
        // }

        
        if(y1<20 && xUp==true)
        {
            xUp=true;   yUp=false;
        }
        else if(y1>150 && xUp==true)
        {
            xUp=true; yUp=true;
        }
        else if(x1>400 && yUp==true)
        {
            xUp=false; yUp=true;
        }
        else if(x1>400 && yUp==false)
        {
            xUp=false; yUp=false;
        }
        else if(y1<20 && xUp==false)
        {
            xUp=false; yUp=false;
        }
        else if(y1>150 && xUp==false)
        {
            xUp=false; yUp=true;
        }
        else if(x1<20 && yUp==false)
        {
            xUp=true; yUp=false;
        }



        if(xUp==true)
            x1+=1;
        else if(xUp==false)
            x1-=1;
        if(yUp==true)
            y1-=1;
        else if(yUp==false)
            y1+=1;
        

        repaint();

    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.add(new AnimationBasic());
        frame.setTitle("animation test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
        System.out.println(System.getProperty("user.dir"));
    }
    
}
