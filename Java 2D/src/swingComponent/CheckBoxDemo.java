package swingComponent;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxDemo extends JPanel implements ItemListener {

	private JCheckBox[] checkBoxes = new JCheckBox[3];
	private String[] fruits = {"apple", "grape", "orange"};
	private JLabel[] labels = new JLabel[3];
	private ImageIcon[] icons = new ImageIcon[3];
//	icon = new ImageIcon
	
	public CheckBoxDemo() {
		
//		GridLayout gl = new GridLayout(0, 4);
		this.setLayout(new GridLayout(0, 4));
		
		for (int i = 0; i < checkBoxes.length; i++) {
			checkBoxes[i] = new JCheckBox(fruits[i]);
			checkBoxes[i].addItemListener(this);
			labels[i] = new JLabel(fruits[i] + ".gif");
			icons[i] = new ImageIcon(fruits[i] + ".gif");
			
		}
		
		JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
		for (int i = 0; i < checkBoxes.length; i++) 
			checkBoxPanel.add(checkBoxes[i]);
			
			
		this.add(checkBoxPanel);
		
		for (int i = 0; i < labels.length; i++) 
			this.add(labels[i]);
		
		
		
		
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		ImageIcon icon = null;
		Object source = e.getItemSelectable();
//		checkBoxes[0].addItemListener(this);
		for (int i = 0; i < checkBoxes.length; i++) {
			if(source == checkBoxes[i]) {
				if (e.getStateChange() == ItemEvent.SELECTED)
				labels[i].setIcon(icons[i]);
				else labels[i].setIcon(null);
			}
		}
		
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.add(new CheckBoxDemo());
				
				
				
		frame.setVisible(true);
	}
//	@Override
	
	
}
