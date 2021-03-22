package miniPingPongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener{

	Ball ball;
	Racquet racquet1;
	Racquet racquet2;
	int index1 = 0;
	int index2 = 0;
	
	public GameBoard() {
		ball = new Ball(this, Color.RED);
		this.setBackground(Color.GREEN);
		
		racquet1 = new Racquet(this, 10, 150, Color.BLUE);
		racquet2 = new Racquet(this, 560, 150, Color.YELLOW);
		setFocusable(true);
		addKeyListener(this);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
//		racquet1.keyReleased(e);
//		racquet2.keyReleased(e);
		
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			
			racquet1.keyReleased(e);
		}
		else racquet2.keyReleased(e);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
//		racquet1.keyPressed(e);
//		racquet2.keyPressed(e);
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			racquet1.keyPressed(e);
			}
		else racquet2.keyPressed(e);
	}
	
	private void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
		checkCollision();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
	
		g.drawLine(300, 0, 300, 400);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif", Font.PLAIN, 40));
		g.drawString(String.valueOf(index1), 250, 40);
		g.drawString(String.valueOf(index2), 330, 40);
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Pong °ÔÀÓ");
		frame.setSize(600, 400);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard game = new GameBoard();
		frame.add(game);
		frame.setVisible(true);
		
		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void checkCollision() {
		if(ball.x+40>=this.getWidth()) {
			ball.x=this.getWidth()/2;
			index1++;
		}
		if(ball.x+ball.xspeed<=0) {
			ball.x=this.getWidth()/2;
			index2++;
		}
	}
	
}
