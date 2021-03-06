package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JFrame 
				implements MouseListener, MouseMotionListener{
	
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	private int[] as = {100, 200, 450, 500};
	private int[] bs = {250, 100, 350, 250};
	
	private int dragIndex = -1;
	private int dragIndex1 = -1;
	
	private MyPanel drawPanel;

	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			/*
			 xs 배열 ys 배열 의 좌표를 이용하여 배지어 곡선을 그린다
			 */
			g.setColor(Color.BLUE);
			g.fillRect(xs[0], ys[0], 16, 16);
			g.fillRect(xs[2], ys[2], 16, 16);
			g.setColor(Color.RED);
			g.fillRect(xs[1], ys[1], 16, 16);
			g.fillRect(xs[3], ys[3], 16, 16);
			
		
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			
			g2d.draw(path);
			

			g.setColor(Color.BLUE);
			g.fillRect(as[0], bs[0], 16, 16);
			g.fillRect(as[2], bs[2], 16, 16);
			g.setColor(Color.RED);
			g.fillRect(as[1], bs[1], 16, 16);
			g.fillRect(as[3], bs[3], 16, 16);
			
						
			Graphics2D g2d1 = (Graphics2D) g;
			g2d1.setColor(Color.BLACK);
			GeneralPath path1 = new GeneralPath();
			path1.moveTo(as[0], bs[0]);
			path1.curveTo(as[1], bs[1], as[2], bs[2], as[3], bs[3]);
			g2d1.draw(path1);
		}
		
	}
	
	
	public BezierCurve() {
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("배지어 커브 데모");
		drawPanel = new MyPanel();
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		add(drawPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		dragIndex = -1;
		dragIndex1 = -1;
		
		for (int i = 0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[i] - 4, ys[i] - 4, 20, 20);
			if (r.contains(e.getX(), e.getY())) {
				dragIndex = i;
			}
			
		}
		for (int i = 0; i < 4; i++) {
			Rectangle r = new Rectangle(as[i] - 4, bs[i] - 4, 20, 20);
			if (r.contains(e.getX(), e.getY())) {
				dragIndex1 = i;
			}
			
		}
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 선택된 점이 있는지 보고 즉 dragIndex가 -1인지 아닌지 보고
		 아니라면 선택된 점의 x, y 좌표를 변경한다
		 * */
		if (dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
						
		}
		if (dragIndex1 != -1) {
			as[dragIndex1] = e.getX();
			bs[dragIndex1] = e.getY();
						
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		dragIndex = -1;
//		dragIndex1 = -1;
		
//		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new BezierCurve();
	}
	
	
}
