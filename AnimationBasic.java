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

public class AnimationBasic extends JPanel implements ActionListener{

	private final int WIDTH = 500, HEIGHT = 300;
	private BufferedImage image;
	private Timer timer;
	private int x, y;
	private final int START_X = 0, START_Y= 250;
	private int moveSection=0;
    private boolean xIncrease=true, yIncrease=true;
	
	public AnimationBasic() {
		//이미지 파일을 읽어서 image 객체롤 생성
		//20ms 마다 이벤트를 발생시키는 timer 객체를 생성하고 timer 를 start 시킴
		
		File file = new File("spaceShip1.png");
	//	System.out.println(file.getAbsolutePath());
		try {
			image = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
//		image = ImageIO.read(file);
		
		x = START_X;
		y = START_Y;
		
		timer = new Timer(20, this);
		timer.start();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// x, y 좌표에 이미지를 그린다
		g.drawImage(image, x, y, this);
		System.out.println(x + ", " + y);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// x, y 좌표 변경
//		x += 1;
//		y -= 1;
//		if (x > WIDTH) {
//			x = START_X;
//			y = START_Y;
//		}
		 
        if(y<20 && xIncrease==true)
        {
        	xIncrease=true;   yIncrease=false;
        }
        else if(y>150 && yIncrease==true)
        {
        	xIncrease=true; yIncrease=true;
        }
        else if(x>400 && yIncrease==true)
        {
        	xIncrease=false; yIncrease=true;
        }
        else if(x>400 && yIncrease==false)
        {
        	xIncrease=false; yIncrease=false;
        }
        else if(y<20 && xIncrease==false)
        {
        	xIncrease=false; yIncrease=false;
        }
        else if(y>150 && xIncrease==false)
        {
        	xIncrease=false; yIncrease=true;
        }
        else if(y>150 && xIncrease==true)
        {
        	xIncrease=true; yIncrease=true;
        }
        else if(x<20 && yIncrease==false)
        {
        	xIncrease=true; yIncrease=false;
        }



        if(xIncrease==true)
            x+=1;
        else if(xIncrease==false)
            x-=1;
        if(yIncrease==true)
            y-=1;
        else if(yIncrease==false)
            y+=1;
		
		
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new AnimationBasic());
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
	
}
