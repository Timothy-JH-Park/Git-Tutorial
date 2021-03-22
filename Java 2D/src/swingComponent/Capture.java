package swingComponent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture extends JFrame implements ActionListener {
	
	private Robot robot;
	private JPanel panel;
	private JButton button;
	
	
	public Capture() {
		
		JFrame capture = new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d;
		Rectangle rec = new Rectangle(500, 500);
		this.setSize(d = new Dimension(500, 500));
		this.setVisible(true);
		
	}
		
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Robot rb = new Robot();
			final BufferedImage image = rb.createScreenCapture(rec);
			image.flush();
			
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			capture.getContentPane().add(panel);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	 public static void main(String[] args) {
		 new Capture();
	 }
}
