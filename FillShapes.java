package component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FillShapes extends JFrame {

	public FillShapes() {
		setSize(600, 130);
		setTitle("Java 2D Fill Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
	}
	
	public static void main (String[] args) {
		new FillShapes();
	}
	
	class MyPanel extends JPanel {
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		
		public MyPanel() {
			Shape s;
			
			s = new Rectangle2D.Float(10, 10, 70, 80);
			shapeArray.add(s);
			
			s = new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);
			shapeArray.add(s);
			
			s = new Ellipse2D.Float(210, 10, 80, 80);
			shapeArray.add(s);
			
			s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
			shapeArray.add(s);
			
			s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
			shapeArray.add(s);
			
			s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
			shapeArray.add(s);
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			// ??Ƽ ???ϸ????? ????
			
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.setStroke(new BasicStroke(3));
			GradientPaint gp = new GradientPaint(0, 10, Color.WHITE,
					0, 70, Color.RED);
			
			// ?簢??
			
			g2.setPaint(Color.RED);
			g2.fill(new Rectangle2D.Float(10, 10, 70, 80));
			
			// ?ձ? ?簢??
			
			g2.setPaint(gp);
			g2.fill(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
			
			
			//
			// ??
			
			g2.setPaint(Color.RED);
			g2.fill(new Ellipse2D.Float(210, 10, 80, 80));
			
			// ȣ
			
			g2.setPaint(gp);
			g2.fill(new Arc2D.Float(310, 10, 80, 80, 20, 240, Arc2D.CHORD));
			
			
			// ȣä??
			
			g2.setPaint(Color.RED);
			g2.fill(new Arc2D.Float(410, 10, 80, 80, 20, 240, Arc2D.CHORD));
			
			// ??
			
			g2.setPaint(gp);
			g2.fill(new Arc2D.Float(510, 10, 80, 80, 45, 210, Arc2D.PIE));
			
			
			
		}
		
		
	}
}
